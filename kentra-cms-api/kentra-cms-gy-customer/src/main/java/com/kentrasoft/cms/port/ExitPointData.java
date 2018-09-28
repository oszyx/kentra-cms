package com.kentrasoft.cms.port;

import com.kentrasoft.cms.basic.properties.Properties;
import com.kentrasoft.cms.dao.DrivingRecordMapper;
import com.kentrasoft.cms.dao.DrivingTrackMapper;
import com.kentrasoft.cms.entity.DrivingRecord;
import com.kentrasoft.cms.port.entity.exitPoint.ExitContent;
import com.kentrasoft.cms.port.entity.exitPoint.ExitPointEntity;
import com.kentrasoft.cms.port.entity.exitPoint.ExitpointQueryResult;
import com.kentrasoft.utils.uuid.UUIDUtils;
import net.sf.json.JSONObject;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.lang.reflect.Field;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 出站口数据接口
 * auhor:赵参谋
 * date:2018-07-09
 */

@Component
public class ExitPointData {
	
	private static final Logger log=LoggerFactory.getLogger(ExitPointData.class);
	
	@Autowired
	private DrivingTrackMapper drvingTrackMapper;
	
	@Autowired
	private DrivingRecordMapper drivingRecordMapper;
	
	
	@Autowired
	private Properties properties;
	
	@SuppressWarnings("restriction")
	@KafkaListener(topics="gyfvs-exitpoint")
	public void loadExitPointData(String BaseData) {
		try {
			sun.misc.BASE64Decoder decoder = new sun.misc.BASE64Decoder();
			String Data=new String(decoder.decodeBuffer(BaseData), "UTF-8");
			log.warn("-----传输出口数据-----" + Data);
			Map<String, Class> listMap = new HashMap<>();
			listMap.put("data", ExitContent.class);
			ExitPointEntity exitPointEntity = (ExitPointEntity) JSONObject.toBean(JSONObject.fromObject(Data),ExitPointEntity.class,listMap);
			
			// 校验数据
			boolean checkData = this.checkData(exitPointEntity);
			if (checkData) {
				// 根据车牌，时间段查询行驶轨迹,状态未完成行程
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				sdf.setTimeZone(TimeZone.getTimeZone("Asia/Shanghai"));//设置时区
				List<ExitContent> exitdataList=exitPointEntity.getData();
				for(ExitContent exitdata:exitdataList) {
					List<ExitpointQueryResult> exitpointQueryResult = drvingTrackMapper.queryTrackAndCard(this.licenseaddpoint(exitdata.getLicense()),sdf.format(new Date(exitdata.getExitTime())));
		            // 结束行程
					String trackId="";
					if(exitpointQueryResult!=null && exitpointQueryResult.size()>0 && StringUtils.isNotBlank(exitpointQueryResult.get(0).getTrackid())) {
						trackId=exitpointQueryResult.get(0).getTrackid();
						drvingTrackMapper.updatedeviceStatus(exitpointQueryResult.get(0).getTrackid(),"02");
					}else {
						trackId = UUIDUtils.getUUID("track");
					}
					
					//生成行驶记录
					this.insertDrivingRecord(exitdata, trackId);
					
					// 查询led设备连地址，发送地图数据
					String exitPointCode=exitdata.getExitCode()+exitdata.getExitPointCode();
					List<String> postAddress = drvingTrackMapper.querylinkAddress(exitPointCode);
					if (null!=postAddress && postAddress.size() == 1 &&  StringUtils.isNotBlank(postAddress.get(0))) {
						String linkaddress=postAddress.get(0);
						this.postmaps(linkaddress, exitdata.getExitPointCode(), trackId,this.licenseaddpoint(exitdata.getLicense()));
						log.info("-----传输出口数据完毕-----{}", sdf.format(new Date()));
					} else {
						log.info("出站口编号{},车道编号{},设备连接地址未找到",exitdata.getExitCode(),exitdata.getExitPointCode());
					}
				}
				
			}else {
				log.warn("出站口数据校验不通过:{}", Data);
			}
		} catch (Exception e) {
			log.warn("接收出口数据错误");
			e.printStackTrace();
		}
	}
	
	
	/**
	 * 插入行驶记录
	 * 
	 *author:赵参谋
	 * @param exitdata
	 * @param trackId
	 */
	public void insertDrivingRecord(ExitContent exitdata,String trackId) {
		DrivingRecord dRecord = new DrivingRecord();
		//记录ID
		dRecord.setDrivingRecord(trackId);
		//车牌
		dRecord.setLicenseNum(this.licenseaddpoint(exitdata.getLicense()));
		//进站名称
		dRecord.setEntranceName("暂无数据");
		//进站时间
		dRecord.setEntranceTime(null);
		//进站坐标GISX
		dRecord.setEntranceLongitude("暂无数据");
		//进站坐标GISY
		dRecord.setEntranceLatitudes("暂无数据");
		//进站编号
		dRecord.setInstationCode("暂无数据");
		//出站名称
		dRecord.setExitName("暂无数据");
		//出站时间
		dRecord.setExitTime(new Date(exitdata.getExitTime()));
		//出站坐标GISX
		dRecord.setExportLongitude("暂无数据");
		//出站坐标GISY
		dRecord.setExportLatitudes("暂无数据");
		//出站编号
		dRecord.setOutstationCode("暂无数据");
		//创建时间
		dRecord.setCreateTime(new Date());// 发送时间
		
		drivingRecordMapper.insert(dRecord);
	}
	
	/**
	 * 发送数据LED
	 * param:postAddress 发送地址
	 * param:pointCode：led显示设备编号
	 * param:trackId：行驶记录id
	 * param:license：车牌号
	 * @throws UnknownHostException 
	 * linkAddress:LED发送地址
	 */
	public void postmaps(String postAddress,String pointCode,String trackId,String license) throws UnknownHostException {
		log.info("lcd发送地址：{}",postAddress);
		RestTemplate restTemplate = new RestTemplate();
		
		HttpHeaders headers = new HttpHeaders();
		MediaType type = MediaType.parseMediaType("application/json; charset=UTF-8");
		headers.setContentType(type);
		
		HashMap<String,String> params=new HashMap<>();
		params.put("LCDCode", pointCode);
		String maplinkAddress=properties.getMapsLinkaddress()+"/gyWeb/gyfvsmap?trackid="+trackId+"&token=gyfvsmap&license="+license;
		log.info("车牌:{},获取地图连接地址,{}",license,maplinkAddress);
		params.put("linkAddress", maplinkAddress);
		JSONObject paramjson=JSONObject.fromObject(params);
		
		HttpEntity<String> requestEntity = new HttpEntity<String>(paramjson.toString(), headers);
		
		ResponseEntity<String> response = restTemplate.postForEntity(postAddress, requestEntity, String.class);
		log.info(200==response.getStatusCodeValue()?license+"地图信息发送成功":license+"地图信息发送失败");
	}
	
	
	
	
	/**
	 * 校验数据
	 *author:赵参谋
	 */
	public boolean checkData(ExitPointEntity exitPointEntity) {
		try {
			if(exitPointEntity.getData()==null) {
				log.warn("data数据不为空");
				return false;
			}
			if(StringUtils.isBlank(exitPointEntity.getFrom())) {
				log.warn("数据来源不为空");
				return false;
			}
			if(exitPointEntity.getTimestamp()==0) {
				log.warn("发送时间不为空");
				return false;
			}
			for(ExitContent exitContent:exitPointEntity.getData()) {
				for(Field field:exitContent.getClass().getDeclaredFields()) {
					String fileName=field.getName();
					if("exitGisX".equals(fileName) || "exitGisY".equals(fileName)) {
						continue;
					}
					field.setAccessible(true);
					Object value= field.get(exitContent);
					if(value==null || value.toString()==null ||value.toString().length()==0) {
						  log.warn("{}:不能为空",fileName);
						  return false;
					 }
				}
			}
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			log.warn("出站口数据校验失败:{}",e.getMessage());
			return false;
		}
		
	}
	
	/**
	 * 给车牌加·
	 *author:赵参谋
	 * @param license
	 * @return
	 */
	public String licenseaddpoint(String license) {
		if(license.contains("·")) {
			return license;
		}else {
			return license.substring(0, 2)+"·"+license.substring(2, license.length());
		}
	}
	
	
	

}
