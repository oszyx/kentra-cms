package com.kentrasoft.cms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 缴费记录页面跳转controller
 * @author xdjpp
 *
 */
@Controller
@RequestMapping(value = "/record")
public class PayRecordController {
	
	@RequestMapping(value = "/getPageList")
    public String getPageList(){
        return "record/payRecord_list";
    }
	
	@RequestMapping(value = "/goAdd")
    public String goAdd(){
        return "record/payRecord_add";
    }
	
	@RequestMapping(value = "/goEdit")
    public String goEdit(){
        return "record/payRecord_edit";
    }
	
	@RequestMapping(value = "/goQuery")
    public String query(){
        return "record/payRecord_query";
    }

}
