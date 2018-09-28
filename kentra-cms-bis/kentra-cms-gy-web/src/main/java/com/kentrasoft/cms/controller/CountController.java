package com.kentrasoft.cms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 描述：统计查询
 *
 * @author zhangmengkang
 * @date 2018-8-6
 */
@Controller
@RequestMapping(value = "/count")
public class CountController {

    @RequestMapping(value = "/goBreakCount")
    public String breakCount() {
        return "count/breakCount";
    }

}
