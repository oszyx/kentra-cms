package com.kentrasoft.cms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 描述：客户管理controller
 *
 * @author lihr
 * @date 2018-6-15
 */
@Controller
@RequestMapping(value = "/whitelist/")
public class WhitelistController {
	
    @RequestMapping(value = "index")
    public String goList(){
        return "whitelist/list";
    }

    @RequestMapping(value = "goAdd")
    public String goAdd(){
        return "whitelist/add";
    }

    @RequestMapping(value = "goEdit")
    public String goEdit(){
        return "whitelist/edit";
    }


}