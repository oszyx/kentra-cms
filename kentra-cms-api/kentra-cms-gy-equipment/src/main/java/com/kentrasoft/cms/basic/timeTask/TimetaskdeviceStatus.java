package com.kentrasoft.cms.basic.timeTask;//废除
/*package com.kentrasoft.basic.timeTask;
*//**
 * 定时任务监测设备状态
 *//*
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.kentrasoft.dao.DeviceManagementMapper;
import com.kentrasoft.dao.RepairRecordMapper;
import com.kentrasoft.entity.DeviceManagement;
import com.kentrasoft.utils.redis.RedisUtils;
@Component
public class TimetaskdeviceStatus {
	
	private static Logger log=LoggerFactory.getLogger(TimetaskdeviceStatus.class);
	
	
	@Autowired
	DeviceManagementMapper deviceManagementMapper;
	
	@Autowired
	private RedisUtils redisUtils;
	
	@Autowired
	private RepairRecordMapper repairRecordMapper;
	
	@Scheduled(cron="0 0/10 * * * ?")
	public void CheckdeviceStatus() {
		log.info(new Date()+"-------设备状态监测-------");
		try {
		//查询设备状态更新时间,如果更新时间extends1+30min<sysdate则判断故障
		List<DeviceManagement> devicelist=deviceManagementMapper.selectDeviceStatsus();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Long systemMillis=System.currentTimeMillis();
		for(DeviceManagement device:devicelist) {
			//设备更新时间
			String updateTime=device.getExtends1();
			
			String statusName=redisUtils.StringGet(device.getDeviceStatus());
			
			if("equipment_state_0".equals(device.getDeviceStatus())) {//未启用
				continue;
			}
			
			if(updateTime==null || "".equals(updateTime)) {
				deviceManagementMapper.updateDeviceStatus(device.getId(),"equipment_state_2");
				continue;
			}
			
			Long updateMillis=sdf.parse(updateTime).getTime();
			if("equipment_state_1".equals(device.getDeviceStatus()) && systemMillis-updateMillis>1800000) {
				//正常执行设备状态更新:故障
				deviceManagementMapper.updateDeviceStatus(device.getId(),"equipment_state_2");
			}else if(( "equipment_state_2".equals(device.getDeviceStatus())||"equipment_state_3".equals(device.getDeviceStatus()) ) && systemMillis-updateMillis<1800000) {
				//故障/维修中执行设备状态更新:正常
				deviceManagementMapper.updateDeviceStatus(device.getId(),"equipment_state_1");
				repairRecordMapper.updateRepairRecordStatus(device.getId(),"repairStatus_03");//修改维修状态为“维修完成”
			}
		 }
		} catch (Exception  e) {
			e.printStackTrace();
		}
	}

}
*/