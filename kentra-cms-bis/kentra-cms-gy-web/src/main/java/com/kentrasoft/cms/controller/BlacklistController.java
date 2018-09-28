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
@RequestMapping(value = "/blacklist/")
public class BlacklistController {
	
    @RequestMapping(value = "index")
    public String goList(){
        return "blacklist/list";
    }

    @RequestMapping(value = "goAdd")
    public String goAdd(){
        return "blacklist/add";
    }

    @RequestMapping(value = "goEdit")
    public String goEdit(){
        return "blacklist/edit";
    }


}