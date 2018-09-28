package com.kentrasoft.cms.port;
/**
 * 设备状态
 * auhor:赵参谋
 * date:2018-07-09
 */

import com.kentrasoft.cms.dao.ControllerMapper;
import com.kentrasoft.cms.entity.ControllerManagement;
import com.kentrasoft.cms.port.entity.equipmentStatus.EqStatusContent;
import com.kentrasoft.cms.port.entity.equipmentStatus.EqStatusEntity;
import com.kentrasoft.cms.port.entity.equipmentStatus.EquipStatus;
import net.sf.json.JSONObject;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class EquipmentStatusData {
	
	private static final Logger log=LoggerFactory.getLogger(EquipmentStatusData.class);
	
	@Autowired
	private ControllerMapper controllerMapper;
	
	@KafkaListener(topics="gyfvs-eqstatus")
	public void loadEqStatus(String BaseData) {
		try {
			sun.misc.BASE64Decoder decoder = new sun.misc.BASE64Decoder();
			String Data=new String(decoder.decodeBuffer(BaseData), "UTF-8");
			log.warn("-----传输设备状态数据-----:{}", Data);
			JSONObject jsonObject = JSONObject.fromObject(Data);
			Map<String, Class<?>> listMap = new HashMap<>();
			listMap.put("data", EqStatusContent.class);
			listMap.put("equipmentStatus", EquipStatus.class);
			EqStatusEntity eqStatusEntity = (EqStatusEntity) JSONObject.toBean(jsonObject, EqStatusEntity.class,listMap);
			// 校验数据
			if (this.checkData(eqStatusEntity)) {
				this.analyData(eqStatusEntity);
				log.warn("-----传输设备状态数据完成-----:{}", Data);
			} else {
				log.info("数据校验校验未通过:{}", Data);
			}
			
		} catch (Exception e) {
			log.warn("设备状态解析出错:{}");
			e.printStackTrace();
		}
		
	}
	
	/**
	 * 校验数据
	 */
	public boolean checkData(EqStatusEntity eqStatusEntity) {
    try{
		if(eqStatusEntity.getData().size()==0) {
			log.warn("data数据不为空");
			return false;
		}
		if(StringUtils.isBlank(eqStatusEntity.getFrom())) {
			log.warn("数据来源不为空");
			return false;
		}
		if(eqStatusEntity.getTimestamp()==0) {
			log.warn("发送时间不为空");
			return false;
		}
		//判断Data值是否为空
		List<EqStatusContent> Eqdata=eqStatusEntity.getData();
		for(EqStatusContent data:Eqdata) {
			for(Field field:data.getClass().getDeclaredFields()) {
				field.setAccessible(true);
				Object value= field.get(data);
				if(value==null || value.toString()==null ||value.toString().length()==0) {
					log.warn("{}:不能为空",field.getName());
					return false;
				}
			}
		}
		
	   } catch (IllegalArgumentException|IllegalAccessException  e) {
			e.printStackTrace();
			return false;
	   } 
		return true;
	}
	
	/**
	 * 更新控制器设备信息
	 */
	public void analyData(EqStatusEntity statusData) {
		try {
			for(EqStatusContent eqStatusContent:statusData.getData()) {
				boolean flag=true;
				//查询设备状态信息
				ControllerManagement controllerManagement= controllerMapper.selectController(eqStatusContent.getEquipmentCode());
				//网络故障
				if(controllerManagement!=null && "02".equals(eqStatusContent.getNetStatus())) {
					//更新控制器网络状态:故障,天线状态：故障
					controllerMapper.updateControllerNet(eqStatusContent.getEquipmentCode(),"contro_net_status2","contro_equip_status2");
					
				}else if(controllerManagement!=null && "01".equals(eqStatusContent.getNetStatus())){
					for(EquipStatus status:eqStatusContent.getEquipmentStatus()) {
						if("02".equals(status.getStatus())) {
							//更新控制器天线状态：故障
							controllerMapper.updateControllerNet(eqStatusContent.getEquipmentCode(),"contro_net_status1","contro_equip_status2");
							flag=false;
							break;
						}
					}
					//控制器正常
					if(flag && ("contro_net_status2".equals(controllerManagement.getControllerStatus()) || 
							    "contro_equip_status2".equals(controllerManagement.getExtends3()))) {
						controllerMapper.updateControllerNet(eqStatusContent.getEquipmentCode(), "contro_net_status1", "contro_equip_status1");
					}
				}
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
	
	//测试
    /*@RequestMapping("/exitPoint/test")
	public void loadEqStatus(String Data) {
		String datas="{'topic':'gyfvs-eqstatus','from':'gyfvs-equipment','timestamp':'1530778989653','data':[{'equipmentName':'','equipmentGisX':'test1','equipmentGisY':'test1','equipmentCode':'test1'},{'equipmentName':'采集设备2','equipmentGisX':'1','equipmentGisY':'1','equipmentCode':'1'}]}";
	    JSONObject jsonObject=JSONObject.fromObject(datas);
	    
	    Map<String, Class> listMap = new HashMap<String, Class>();
	    listMap.put("data", EqStatusData.class);
	    
	    EqStatusEntity eqStatusEntity =(EqStatusEntity) JSONObject.toBean(jsonObject, EqStatusEntity.class, listMap);
	    if(this.checkData(eqStatusEntity)) {
		    this.analyData(eqStatusEntity);
	    }else {
	    	log.info("设备状态data内容为空");
	    }
	}*/

}
