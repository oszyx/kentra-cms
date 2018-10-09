package com.kentrasoft.cms.controller.menu;

import com.kentrasoft.base.controller.BaseController;
import com.kentrasoft.base.plugin.PageForm;
import com.kentrasoft.cms.model.Menu;
import com.kentrasoft.cms.model.Role;
import com.kentrasoft.cms.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;

/**
 * 描述：菜单controller
 *
 * @author zmk
 * @date 2018-9-28
 */
@Controller
@RequestMapping("/menu")
public class MenuController extends BaseController {
    @Autowired
    private MenuService menuService;

    /**
     * 描述：菜單列表
     *
     * @param pf
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public PageForm<Menu> list(PageForm<Menu> pf) {
        HashMap<String, Object> pageData = this.getPageData();
        pf.setPageData(pageData);
        pf = menuService.queryPageList(pf);
        return pf;
    }


    /**
     * 描述：添加菜單
     *
     * @param menu
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public Long add(Menu menu) {
        Long id = (Long)menuService.insertObject(menu);
        return id;
    }


    /**
     * 描述：删除菜單
     *
     * @param ids
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public Integer delete(String ids) {
        int i = menuService.deleteByIdsStr(ids);
        return i;
    }


    /**
     * 描述：修改菜單
     *
     * @param menu
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public Integer edit(Menu menu) {
        int i = menuService.updateByObject(menu);
        return i;
    }


    /**
     * 描述：查詢所有可用菜单
     *
     * @return
     */
    @ResponseBody
    @RequestMapping("/findAll")
    public List<Menu> findAll() {
        List<Menu> all = menuService.findAll();
        return all;
    }
}
