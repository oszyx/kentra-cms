package com.kentrasoft.cms.port;
/**
 * 5.8G设备采集数据接口
 */

import com.kentrasoft.cms.dao.CardPortDataMapper;
import com.kentrasoft.cms.dao.DrivingTrackMapper;
import com.kentrasoft.cms.entity.DrivingTrack;
import com.kentrasoft.cms.port.entity.equipmentData.EquipmentContent;
import com.kentrasoft.cms.port.entity.equipmentData.EquipmentEntity;
import com.kentrasoft.utils.uuid.UUIDUtils;
import net.sf.json.JSONObject;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;


@Component
public class EquipmentData {
	
	private static final Logger log=LoggerFactory.getLogger(EquipmentData.class);
	
	@Autowired
	DrivingTrackMapper drivingTrackMapper;
	
	@Autowired
	CardPortDataMapper cardPortDataMapper;
	
	
	
	@KafkaListener(topics= {"gyfvs-equipment"})
	public  synchronized  void loadDeviceData(String BaseData) {
        try {
			sun.misc.BASE64Decoder decoder = new sun.misc.BASE64Decoder();
			String Data=new String(decoder.decodeBuffer(BaseData), "UTF-8");
    		log.info("-----传输5.8G设备数据-----{}", Data);
        	JSONObject jsonObject = JSONObject.fromObject(Data);
    		EquipmentEntity equipmentEntity = (EquipmentEntity) JSONObject.toBean(jsonObject, EquipmentEntity.class);
    		// 校验数据
            boolean checkData=this.checkData(equipmentEntity);
    		if (checkData) {
    			//重复数据屏蔽
    			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    			sdf.setTimeZone(TimeZone.getTimeZone("Asia/Shanghai"));//设置时区
    			List<DrivingTrack> isreset=drivingTrackMapper.checkresetdata(this.licenseaddpoint(equipmentEntity.getData().getLicense()),sdf.format(new Date(Long.parseLong(equipmentEntity.getData().getEquipmentTime()))));
    			if(null!=isreset && isreset.size()>0) {
    				log.info("数据已推送:{}",Data);
    				return;
    			}
    			// 查询行驶记录，状态未结束行程
    			String trackId = "";
    			EquipmentContent device=equipmentEntity.getData();
    			List<DrivingTrack> tracklist = drivingTrackMapper.queryDrivingtrackNotend(this.licenseaddpoint(device.getLicense()), "01");
    			if(tracklist!=null && tracklist.size() > 0 && StringUtils.isNotBlank(tracklist.get(0).getDrivingRecord())) {
    				trackId = tracklist.get(0).getDrivingRecord();
    			}else {
    				trackId = UUIDUtils.getUUID("track");
    			}
    			// 存储行驶记录
    			this.insertTrack(equipmentEntity, trackId);
    			log.info("-----传输5.8G设备数据完毕-----{}", Data);
    		} else {
    			log.info("数据校验未通过");
    		}
		} catch (Exception e) {
			log.info("数据解析出错,{}",e.getMessage());
		}
		
	}

	public void insertTrack(EquipmentEntity equipmentEntity, String trackId) {
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		sdf.setTimeZone(TimeZone.getTimeZone("Asia/Shanghai"));//设置时区
		DrivingTrack drvingtrack = new DrivingTrack();
		EquipmentContent device=equipmentEntity.getData();
		// 行驶记录Id
		drvingtrack.setDrivingRecord(trackId);
		// 车牌号
		drvingtrack.setLicenseNum(this.licenseaddpoint(device.getLicense()));
		// 设备GisX
		drvingtrack.setDeviceGisX(device.getEquipmentGisX());
		// 设备GISY
		drvingtrack.setDeviceGisY(device.getEquipmentGisY());
		// 通过时间
		drvingtrack.setThroughTime(new Date(Long.parseLong(device.getEquipmentTime())));
		// 采集设备编号
		drvingtrack.setEquipmentNumber(device.getEquipmentCode());
		//采集设备名称
		drvingtrack.setDeviceAddress(device.getEquipmentName());
		// 状态：01未结束行程，02结束行程
		drvingtrack.setExtends1("01");
		// 数据来源:01设备采集数据，02出站口数据
		drvingtrack.setExtends2("01");
		// 创建时间
		drvingtrack.setLaneNum(sdf.format(new Date()));
		drivingTrackMapper.insert(drvingtrack);
	}
	
	/**
	 * 校验数据
	 *author:赵参谋
	 */
	public boolean checkData(EquipmentEntity equipmentEntity) {
		try {
			if(equipmentEntity.getData()==null) {
				log.warn("data数据不为空");
				return false;
			}
			if(StringUtils.isBlank(equipmentEntity.getFrom())) {
				log.warn("数据来源不为空");
				return false;
			}
			if(equipmentEntity.getTimestamp()==0) {
				log.warn("发送时间不为空");
				return false;
			}
			EquipmentContent Eqdata=equipmentEntity.getData();
			  for(Field field:Eqdata.getClass().getDeclaredFields()) {
				  field.setAccessible(true);
				  Object value= field.get(Eqdata);
				  if(value==null || "null".equals(value.toString()) || "".equals(value.toString()) ||value.toString().length()==0) {
					  log.warn("{}:不能为空",field.getName());
					  return false;
				 }
			}
			return true;
		} catch (Exception e) {
			log.warn("数据校验出错{}",e.getMessage());
			return true;
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
