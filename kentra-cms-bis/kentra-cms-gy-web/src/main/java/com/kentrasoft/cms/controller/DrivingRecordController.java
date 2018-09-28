package com.kentrasoft.cms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/drivingrecord")
public class DrivingRecordController {
	@RequestMapping(value = "/getPageList")
    public String getPageList(){
        return "drivingrecord/drivingRecord_List";
    }
	@RequestMapping(value = "/saveIrregularities")
    public String saveIrregularities(){
        return "drivingrecord/Irregularities";
    }
}
