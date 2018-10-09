package com.kentrasoft.cms.controller.dict;

import com.kentrasoft.base.controller.BaseController;
import com.kentrasoft.base.plugin.PageForm;
import com.kentrasoft.cms.model.Dict;
import com.kentrasoft.cms.model.Menu;
import com.kentrasoft.cms.service.DictService;
import com.kentrasoft.cms.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;

/**
 * 描述：字典controller
 *
 * @author zmk
 * @date 2018-9-28
 */
@Controller
@RequestMapping("/dict")
public class DictController extends BaseController {
    @Autowired
    private DictService dictService;

    /**
     * 描述：字典列表
     *
     * @param pf
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public PageForm<Dict> list(PageForm<Dict> pf) {
        HashMap<String, Object> pageData = this.getPageData();
        pf.setPageData(pageData);
        pf = dictService.queryPageList(pf);
        return pf;
    }


    /**
     * 描述：添加字典
     *
     * @param dict
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public Long add(Dict dict) {
        Long id = (Long)dictService.insertObject(dict);
        return id;
    }


    /**
     * 描述：删除字典
     *
     * @param ids
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public Integer delete(String ids) {
        int i = dictService.deleteByIdsStr(ids);
        return i;
    }


    /**
     * 描述：修改字典
     *
     * @param dict
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public Integer edit(Dict dict) {
        int i = dictService.updateByObject(dict);
        return i;
    }


    /**
     * 描述：查詢所有可用字典
     *
     * @return
     */
    @ResponseBody
    @RequestMapping("/findAll")
    public void findAll() {
        dictService.findAll();
    }
}
