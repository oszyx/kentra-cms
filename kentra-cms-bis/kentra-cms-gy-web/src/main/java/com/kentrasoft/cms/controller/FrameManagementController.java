package com.kentrasoft.cms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/frame")
public class FrameManagementController {
	
	/**
	 * 龙门架首页
	 *author:赵参谋
	 * @return
	 */
	@RequestMapping("/index")
	public String loadFrameIndex() {
		return "frame/frame_list.html";
	}
	
	/**
	 * 新增页面
	 *author:赵参谋
	 * @return
	 */
	@RequestMapping("/goAdd")
	public String goAdd() {
		return "frame/frame_add.html";
	}
	/**
	 * 查看首页
	 *author:赵参谋
	 * @return
	 */
	@RequestMapping("/goQuery")
	public String goQuery() {
		return "frame/frame_view.html";
	}
	/**
	 * 编辑首页
	 *author:赵参谋
	 * @return
	 */
	@RequestMapping("/goEdit")
	public String goEdit() {
		return "frame/frame_edit.html";
	}
	
	/**
	 * 维修首页
	 *author:赵参谋
	 * @return
	 */
	@RequestMapping("/goRepair")
	public String goRepair() {
		return "frame/frame_repair.html";
	}

}
