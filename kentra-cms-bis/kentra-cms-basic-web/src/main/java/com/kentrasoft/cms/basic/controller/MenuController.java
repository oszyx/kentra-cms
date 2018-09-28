package com.kentrasoft.cms.basic.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@RequestMapping(value = "/menu")
@Controller
public class MenuController {

    /**
     * 获取菜单树节点名称数据
     */
	@RequestMapping(value = "/getTreeList")
	public String getTreeList() {
		return "system/menu/menu_list";
	}

    /**
     * 根据菜单名称获取菜单列表数据
     */
	@RequestMapping(value = "/getPageList")
	public String getPageList() {
		return "system/menu/menu_list";
	}
	
	/**
     * 描述：跳转到菜单新增页面
     *
     * @return
     */
    @RequestMapping(value = "/goAdd")
    public String add(){
        return "system/menu/menu_add";
    }


    /**
     * 描述：跳转到菜单编辑页面
     *
     * @return
     */
    @RequestMapping(value = "/goEdit")
    public String edit(){
        return "system/menu/menu_edit";
    }
    
    /**
     * 描述：跳转到查看详情页面
     */
    @RequestMapping(value = "/goQuery")
    public String query(){
        return "system/menu/menu_query";
    }
}
