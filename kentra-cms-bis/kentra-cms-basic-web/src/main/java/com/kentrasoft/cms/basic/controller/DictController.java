package com.kentrasoft.cms.basic.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/dict")
public class DictController {
	
    /**
     * 描述：跳转到数据字典列表页面
     *
     * @return
     */
    @RequestMapping(value = "/index")
    public String goDictList(HttpServletRequest request){
    	String dictParentId = request.getParameter("dictParentId");
    	request.setAttribute("dictParentId", dictParentId);
		return "system/dict/dict_list";
    }

    /**
     * 描述：跳转到数据字典添加页面
     *
     * @return
     */
    @RequestMapping(value = "/goAddPage")
    public String add(HttpServletRequest request){
    	String dictParentId = request.getParameter("dictParentId");
    	request.setAttribute("dictParentId", dictParentId);
        return "system/dict/dict_add";
    }

    /**
     * 描述：跳转到数据字典编辑页面
     *
     * @return
     */
    @RequestMapping(value = "/goEditPage")
    public String edit(HttpServletRequest request){
    	String type = request.getParameter("type");
    	request.setAttribute("type", type);
        return "system/dict/dict_edit";
    }
}
