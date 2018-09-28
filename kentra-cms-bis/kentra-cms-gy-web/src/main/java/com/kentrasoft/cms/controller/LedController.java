package com.kentrasoft.cms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 描述：led管理
 *
 * @author liyang
 * @date 2018年6月20日 09点59分
 */
@Controller
@RequestMapping(value = "/led")
public class LedController {

    //led分页列表页面
    @RequestMapping(value = "/list")
    public String list() {
        return "led/list";
    }

    //led详情
    @RequestMapping(value = "/goLedDetail")
    public String goLedDetail() {
        return "led/ledDetail";
    }

    //led编辑功能
    @RequestMapping(value = "/goLedEdit")
    public String goLedEdit() {
        return "led/ledEdit";
    }

    //led添加功能
    @RequestMapping(value = "/addLed")
    public String addLed() {
        return "led/addLed";
    }

   //led维护功能
   @RequestMapping(value = "/repairLed")
    public String repairLed() {
        return "led/repairLed";
    }

}