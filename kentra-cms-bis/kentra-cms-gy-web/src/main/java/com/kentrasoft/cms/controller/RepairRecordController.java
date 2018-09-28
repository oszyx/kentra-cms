package com.kentrasoft.cms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 描述：维修记录表
 *
 * @author zhangmengkang
 * @date 2018-6-15 13:42:37
 */
@Controller
@RequestMapping(value = "/repair")
public class RepairRecordController {
    @RequestMapping(value = "/goList")
    public String goList() {
        return "repairRecord/list";
    }

    @RequestMapping(value = "/goAdd")
    public String goAdd() {
        return "repairRecord/add";
    }

    @RequestMapping(value = "/goEdit")
    public String goEdit() {
        return "repairRecord/edit";
    }

    @RequestMapping(value = "/goDetail")
    public String goDetail() {
        return "repairRecord/detail";
    }
}