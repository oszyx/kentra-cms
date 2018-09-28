package com.kentrasoft.cms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 描述：控制器管理controller
 *
 * @author zhangmengkang
 * @date 2018-6-12 13:42:37
 */
@Controller
@RequestMapping(value = "/control")
public class ControllerManagementController {

    @RequestMapping(value = "/index")
    public String index() {
        return "index";
    }

    @RequestMapping(value = "/goList")
    public String goList() {
        return "control/list";
    }

    @RequestMapping(value = "/goAdd")
    public String goAdd() {
        return "control/add";
    }

    @RequestMapping(value = "/goEdit")
    public String goEdit() {
        return "control/edit";
    }

    @RequestMapping(value = "/goDetail")
    public String goDetail() {
        return "control/detail";
    }

    @RequestMapping(value = "/goRepair")
    public String goRepair() {
        return "control/repair";
    }
}