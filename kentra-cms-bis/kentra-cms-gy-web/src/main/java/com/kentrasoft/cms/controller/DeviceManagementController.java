package com.kentrasoft.cms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/device")
public class DeviceManagementController {
	
	/**
	 * 5.8G设备管理首页
	 *author:赵参谋
	 * @return
	 */
	@RequestMapping("/index")
	public String loadDeviceIndex() {
		return "device/device_list.html";
	}
    
	/**
	 * 新增页面
	 *author:赵参谋
	 * @return
	 */
	@RequestMapping("/goAdd")
	public String goAdd() {
		return "device/device_goAdd.html";
	}
	
	/**
	 * 设备管理详细页面
	 *author:赵参谋
	 * @return
	 */
	@RequestMapping("/goQuery")
	public String goQuery() {
		return "device/device_view.html";
	}
	/**
	 * 编辑首页
	 *author:赵参谋
	 * @return
	 */
	@RequestMapping("/goEdit")
	public String goEdit() {
		return "device/device_edit.html";
	}
	
	/**
	 * 维护首页
	 */
	@RequestMapping("/goRepair")
	public String goRepair() {
		return "device/device_repair.html";
	}
	
	/**
	 * 数据统计
	 */
	@RequestMapping("/deviceCount")
	public String goDeviceCount() {
		return "count/device_count.html";
	}


}
