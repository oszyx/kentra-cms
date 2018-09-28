package com.kentrasoft.cms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class Maps {
	
	/**
	 * 展示行驶轨迹
	 *author:赵参谋
	 * @param trackid
	 * @param modelAndView
	 * @return
	 */
    @RequestMapping("/gyfvsmap")
	public ModelAndView gyfvsmaps(@RequestParam("trackid") String trackid, @RequestParam("license") String license, ModelAndView modelAndView) {
    	modelAndView.setViewName("map/baidumap.html");
    	modelAndView.addObject("trackid", trackid);
    	modelAndView.addObject("license", license);
    	return modelAndView;
	}
	
}
