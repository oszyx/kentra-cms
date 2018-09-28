package com.kentrasoft.cms.port;


import com.kentrasoft.cms.basic.properties.Properties;
import com.kentrasoft.cms.port.entity.synchronizeDeviceData.DeviceData;
import com.kentrasoft.utils.plugin.BaseResult;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * 5.8G设备数据同步到硬件设备
 * @author 赵参谋
 *
 */
@RestController
@RequestMapping("/port")
@SuppressWarnings({"unchecked"})
public class SynchronizeDevicedata {
	
	private static Logger log=LoggerFactory.getLogger(SynchronizeDevicedata.class);
	
	@Autowired
	private Properties properties;
	
	@RequestMapping("/deviceData")
	public BaseResult<String> synDevicedata(String data ) {
		log.info("-----5.8G设备同步数据-----{}",data);
		JSONArray jsonObject=JSONArray.fromObject(data);
		List<DeviceData> postDevicedata=(List<DeviceData>) JSONArray.toCollection(jsonObject,DeviceData.class);
		String postAddress=properties.getPostdeviceAddress();//数据发送地址
		StringBuffer ErrorkResult = new StringBuffer();
		for(DeviceData postdata:postDevicedata) {
			boolean flag=this.postData(postAddress,postdata);
			if(!flag) {
				ErrorkResult.append("设备编码:"+postdata.getDeviceCode()+",同步失败。</br>");
			}
		}
		if(StringUtils.isBlank(ErrorkResult.toString())) {
			return new BaseResult<String>("200", "设备信息同步完成");
		}else {
			return new BaseResult<String>("300", ErrorkResult.toString());
		}
		
	}
	
	/**
	 * 发送数据
	 *author:赵参谋
	 * @param postdata
	 * @return
	 */
	public boolean postData(String postAddress,DeviceData postdata) {
		try {
			RestTemplate restTemplet=new RestTemplate();
			HttpHeaders headers=new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
			MultiValueMap<String, String> params=new LinkedMultiValueMap<String, String>();
			params.add("deviceName", postdata.getName());
			params.add("deviceCode", postdata.getDeviceCode());
			params.add("deviceGisX", postdata.getDeviceGisX());
			params.add("deviceGisY", postdata.getDeviceGisY());
			HttpEntity<MultiValueMap<String, String>> requestEntity = new HttpEntity<MultiValueMap<String, String>>(params, headers);
			ResponseEntity<String> response = restTemplet.exchange(postAddress, HttpMethod.POST, requestEntity, String.class);
			String backInfos=response.getBody();
			log.info("-----设备同步返回数据-----{}",backInfos);
			JSONObject object=JSONObject.fromObject(backInfos);
			if("true".equals(object.getString("status"))) {
				return true;
			}else {
				log.info("-----设备同步返回失败:message:{}-----",object.getString("message"));
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
			log.warn("-----5.8G數據同步失败-----");
			return false;
		}
	}

}
