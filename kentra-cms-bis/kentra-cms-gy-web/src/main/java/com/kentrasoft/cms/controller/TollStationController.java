package com.kentrasoft.cms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/tollStation")
public class TollStationController {
	
	@RequestMapping(value = "goList")
    public String goList(){
        return "tollStation/tollStation_list";
    }
	
    @RequestMapping(value = "add")
    public String add() {
    	return "tollStation/tollStation_add";
    }
    
    @RequestMapping(value = "edit")
    public String edit() {
        return "tollStation/tollStation_edit";
    }
}
