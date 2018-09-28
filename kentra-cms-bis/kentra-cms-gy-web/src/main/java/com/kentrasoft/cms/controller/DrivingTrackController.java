package com.kentrasoft.cms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/drivingtrack")
public class DrivingTrackController {
	@RequestMapping(value = "/goQuery")
    public String query(){
        return "drivingtrack/trajectory";
    }
}
