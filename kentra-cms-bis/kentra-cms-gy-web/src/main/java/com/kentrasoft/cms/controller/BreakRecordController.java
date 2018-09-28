package com.kentrasoft.cms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/breakRecord/")
public class BreakRecordController {

	
    @RequestMapping(value = "goList")
    public String goList(){
        return "breakRecord/breakRecord_list";
    }
	
    @RequestMapping(value = "add")
    public String add() {
    	return "breakRecord/breakRecord_add";
    }
    
    @RequestMapping(value = "goDetail")
    public String goDetail() {
        return "breakRecord/breakRecord_detail";
    }
    
    @RequestMapping(value = "edit")
    public String edit() {
        return "breakRecord/breakRecord_edit";
    }
    
    @RequestMapping(value = "examine")
    public String examine() {
        return "breakRecord/breakRecord_examine";
    }
    /**
     * 车牌查询行驶记录查询
     */
    @RequestMapping("/licenseSerach")
    public String licenseSerach() {
    	return "breakRecord/licenseSerach";
    }
}
