package com.kentrasoft.cms.basic.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/sysVersion")
public class SysVersionController {


    //版本分页列表页面
    @RequestMapping(value = "/goList")
    public String goList() {
        return "system/version/list";
    }
    //版本添加页面
    @RequestMapping(value = "/goAdd")
    public String goAdd() {
        return "system/version/add";
    }
    //版本编辑页面
    @RequestMapping(value = "/goEdit")
    public String goEdit() {
        return "system/version/edit";
    }
    //版本详情页面
    @RequestMapping(value = "/goDetail")
    public String goDetail() {
        return "system/version/detail";
    }
}
