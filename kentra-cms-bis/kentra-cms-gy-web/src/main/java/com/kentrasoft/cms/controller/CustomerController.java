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
@RequestMapping(value = "/customer/")
public class CustomerController {
	
    @RequestMapping(value = "index")
    public String goList(){
        return "customer/list";
    }

    @RequestMapping(value = "goAdd")
    public String goAdd(){
        return "customer/add";
    }

    @RequestMapping(value = "goEdit")
    public String goEdit(){
        return "customer/edit";
    }

    @RequestMapping(value = "goView")
    public String goView(){
        return "customer/view";
    }

    @RequestMapping(value = "goAddDrivingLicense")
    public String goAddDrivingLicense(){
        return "customer/addDrivingLicense";
    }

    /**
     * 用户注册统计
     * @return
     */
    @RequestMapping(value = "customerCount")
    public String goCustomerCount(){
        return "count/customer_count";
    }

}