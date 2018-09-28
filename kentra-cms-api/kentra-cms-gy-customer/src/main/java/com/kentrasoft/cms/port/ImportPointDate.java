package com.kentrasoft.cms.port;

import com.kentrasoft.cms.dao.BreakRecordMapper;
import com.kentrasoft.cms.dao.DrivingRecordMapper;
import com.kentrasoft.cms.dao.DrivingTrackMapper;
import com.kentrasoft.cms.dao.TollStationMapper;
import com.kentrasoft.cms.entity.BreakRecord;
import com.kentrasoft.cms.entity.DrivingRecord;
import com.kentrasoft.cms.entity.DrivingTrack;
import com.kentrasoft.cms.entity.TollStation;
import com.kentrasoft.cms.port.entity.importPoint.ImportContent;
import com.kentrasoft.cms.port.entity.importPoint.ImportPointEntity;
import net.sf.json.JSONObject;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 进出口数据接口
 * @author jiaming
 *
 */
@Component
public class ImportPointDate {
	
	private static final Logger log=LoggerFactory.getLogger(ImportPointDate.class);

	@Autowired
	private DrivingRecordMapper drivingRecordMapper;
	
	@Autowired
	private DrivingTrackMapper drvingTrackMapper;
	
	@Autowired
	private TollStationMapper tollStationMapper;
	
	@Autowired
	private BreakRecordMapper breakRecordMapper;
	
	
	@KafkaListener(topics= {"gyfvs-inoutpoint"})
	public synchronized void loadImportPointDate(String BaseData) {
		    try {
		    	sun.misc.BASE64Decoder decoder = new sun.misc.BASE64Decoder();
				String Data=new String(decoder.decodeBuffer(BaseData), "UTF-8");
				log.warn("------进出口数据-----" + Data);
		    	Map<String, Class> listMap = new HashMap<>();
				listMap.put("data", ImportContent.class);
				ImportPointEntity importPointEntity = (ImportPointEntity) JSONObject.toBean(JSONObject.fromObject(Data),ImportPointEntity.class, listMap);

				// 校验数据
				boolean checkData = this.checkData(importPointEntity);
				SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				sdf.setTimeZone(TimeZone.getTimeZone("Asia/Shanghai"));
				if (checkData) {
					for(ImportContent inOutContent : importPointEntity.getData()) {
						//查询行驶记录表，cond:车牌，出站时间
						DrivingRecord drivingRecord=drivingRecordMapper.selectbyInoutEndtime(this.licenseaddpoint(inOutContent.getLicense()),sdf.format(new Date(inOutContent.getOutstationTime())));
					    if(drivingRecord==null) {
					    	log.info("未查询到车牌：{},进站时间{},出站时间{},的进出口行驶记录",inOutContent.getLicense(),new Date(inOutContent.getInstationTime()),new Date(inOutContent.getOutstationTime()));
					    	continue;
					    }
						//更新行驶记录
						HashMap<String, TollStation> map=this.updatedrvingrecord(drivingRecord,inOutContent);
						//判断是否有违规记录，更新违规信息
						this.updateBreakRecord(drivingRecord.getDrivingRecord(),inOutContent);
						//存入行驶轨迹
						this.insertDrivingTrack(drivingRecord,map,inOutContent);
						log.info("-----进出口数据处理完毕-----{}", Data);
					}
				}else {
					log.warn("进出站口数据校验不通过:{}", Data);
				}
			} catch (Exception e) {
				log.info("数据解析出错");
				e.printStackTrace();
			}
			
	}
	
	/**
	 * 更新违规记录信息
	 * 
	 *author:赵参谋
	 * @param trackId
	 * @param inOutContent
	 */
	public void updateBreakRecord(String trackId,ImportContent inOutContent) {
		BreakRecord breakrecord= breakRecordMapper.selectBytrackid(trackId);
		if(breakrecord!=null) {
			//进站口名称
			breakrecord.setEntranceName(inOutContent.getInstationName());
			//进站时间
			breakrecord.setEntranceTime(new Date(inOutContent.getInstationTime()));
			//出站名称
			breakrecord.setExitName(inOutContent.getOutstationName());
			//出站时间
			breakrecord.setExitTime(new Date(inOutContent.getOutstationTime()));
			//更新时间
			breakrecord.setUpdateTime(new Date());
			
			breakRecordMapper.updateByPrimaryKey(breakrecord);
		}
	}
	
	/**
	 * 插入行驶轨迹
	 * 
	 *author:赵参谋
	 * @param drivingRecord
	 * @param map
	 */
	public void insertDrivingTrack(DrivingRecord  drivingRecord,HashMap<String, TollStation> map,ImportContent inOutContent) {
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		sdf.setTimeZone(TimeZone.getTimeZone("Asia/Shanghai"));//设置时区
		Iterator<String> iter=map.keySet().iterator();
		while(iter.hasNext()) {
			String key=iter.next();
			TollStation tollstation=map.get(key);
			DrivingTrack track = new DrivingTrack();
			//行驶记录id
			track.setDrivingRecord(drivingRecord.getDrivingRecord());
			//车牌号码
			track.setLicenseNum(this.licenseaddpoint(drivingRecord.getLicenseNum()));
			//坐标GISX,坐标GISY
			if(null!=tollstation) {
				track.setDeviceGisX(tollstation.getLongitude());
				track.setDeviceGisY(tollstation.getLatitude());
			}else {
				track.setDeviceGisX("");
				track.setDeviceGisY("");
			}
			//通过时间,站点编号,站点名称
			if("instation".equals(key)) {
				track.setThroughTime(new Date(inOutContent.getInstationTime()));
				track.setEquipmentNumber(inOutContent.getInstationCode());
				track.setDeviceAddress(inOutContent.getInstationName());
			}else {
				track.setThroughTime(new Date(inOutContent.getOutstationTime()));
				track.setEquipmentNumber(inOutContent.getOutstationCode());
				track.setDeviceAddress(inOutContent.getOutstationName());
			}
			// 结束行程
			track.setExtends1("02");
			// 站点数据
			track.setExtends2("02");
			// 创建时间
			track.setLaneNum(sdf.format(new Date()));
			
			drvingTrackMapper.insert(track);// 插入出口经纬度数据
		}
	}
	
	/**
	 * 更新行驶记录信息
	 * 
	 *author:赵参谋
	 * @param drivingRecord
	 * @param inOutContent
	 */
	public HashMap<String, TollStation> updatedrvingrecord(DrivingRecord  drivingRecord,ImportContent inOutContent) {
		HashMap<String, TollStation> map=new HashMap<>();
		//进站名称
		drivingRecord.setEntranceName(inOutContent.getInstationName());
		//进站时间
		drivingRecord.setEntranceTime(new Date(inOutContent.getInstationTime()));
		// 查询进站口经纬度
		TollStation instationgis = this.tollstationinfos(inOutContent.getInstationName(), inOutContent.getInstationCode());
		if(null!=instationgis) {
		    //进站坐标GISX
			drivingRecord.setEntranceLongitude(instationgis.getLongitude());
			//进站坐标GISY
			drivingRecord.setEntranceLatitudes(instationgis.getLatitude());
		}else {
			//进站坐标GISX
			drivingRecord.setEntranceLongitude("");
			//进站坐标GISY
			drivingRecord.setEntranceLatitudes("");
		}
		//进站口编号
		drivingRecord.setInstationCode(inOutContent.getInstationCode());
		
		
		
		//出站名称
		drivingRecord.setExitName(inOutContent.getOutstationName());
		//出站站时间
		drivingRecord.setExitTime(new Date(inOutContent.getOutstationTime()));
		// 查询进出站经纬度
		TollStation outstationgis = this.tollstationinfos(inOutContent.getOutstationName(), inOutContent.getOutstationCode());
		if(null!=outstationgis) {
			//出站坐标GISX
			drivingRecord.setExportLongitude(outstationgis.getLongitude());
			//出站坐标GISY
			drivingRecord.setExportLatitudes(outstationgis.getLatitude());
		}else {
			//出站坐标GISX
			drivingRecord.setExportLongitude("");
			//出站坐标GISY
			drivingRecord.setExportLatitudes("");
		}
		
		//出站口编号
		drivingRecord.setOutstationCode(inOutContent.getOutstationCode());
		//创建时间
		drivingRecord.setCreateTime(new Date());// 发送时间
		
		drivingRecordMapper.updateByPrimaryKey(drivingRecord);
		
		map.put("instation", instationgis);
		map.put("outstation", outstationgis);
		return map;
	}
    
	/**
	 * 查询进出口坐标
	 * 
	 *author:赵参谋
	 * @param stationName
	 * @param stationcode
	 * @return
	 */
	public TollStation tollstationinfos(String stationName,String stationcode) {
		TollStation tollstation= tollStationMapper.querytollstationbycode(stationName,stationcode);
		if(tollstation!=null) {
			return tollstation;
		}else {
			log.info("未查询到收费站信息");
			return null;
		}
	}
	
	/**
	 * 校验数据
	 *author:jiaming
	 */
	public boolean checkData(ImportPointEntity importPointEntity) {
		try {
			if(importPointEntity.getData()==null) {
				log.warn("data数据不为空");
				return false;
			}
			if(StringUtils.isBlank(importPointEntity.getFrom())) {
				log.warn("数据来源不为空");
				return false;
			}
			if(importPointEntity.getTimestamp()==0) {
				log.warn("发送时间不为空");
				return false;
			}
			for(ImportContent importContent:importPointEntity.getData()) {
				for(Field field:importContent.getClass().getDeclaredFields()) {
					  String fileName=field.getName();
					  if("instationGisX".equals(fileName) || "instationGisY".equals(fileName) ||
					      "outstationGisX".equals(fileName)	||"outstationGisY".equals(fileName)	  ) {
						  continue;
					  }
					  field.setAccessible(true);
					  Object value= field.get(importContent);
					  if(value==null || value.toString()==null ||value.toString().length()==0) {
						  log.warn("{}:不能为空",fileName);
						  return false;
					 }
				}
			}
			  
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			log.warn("进站口数据校验失败:{}",e.getMessage());
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
