package com.kentrasoft.cms.controller.role;

import com.kentrasoft.cms.base.controller.BaseController;
import com.kentrasoft.cms.base.plugin.PageForm;
import com.kentrasoft.cms.model.Role;
import com.kentrasoft.cms.service.MenuService;
import com.kentrasoft.cms.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;

/**
 * 描述：角色controller
 *
 * @author zmk
 * @date 2018-9-28
 */
@Controller
@RequestMapping("/role")
public class RoleController extends BaseController {
    @Autowired
    private RoleService roleService;

    @Autowired
    private MenuService menuService;

    /**
     * 描述：角色列表
     *
     * @param pf
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public PageForm<Role> list(PageForm<Role> pf) {
        HashMap<String, Object> pageData = this.getPageData();
        pf.setPageData(pageData);
        pf = roleService.queryPageList(pf);
        return pf;
    }


    /**
     * 描述：添加角色
     *
     * @param role
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public Long add(Role role) {
        Long id = (Long)roleService.insertObject(role);
        return id;
    }


    /**
     * 描述：删除角色
     *
     * @param ids
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public Integer delete(String ids) {
        int i = roleService.deleteByIdsStr(ids);
        return i;
    }


    /**
     * 描述：修改角色
     *
     * @param role
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public Integer edit(Role role) {
        int i = roleService.updateByObject(role);
        return i;
    }


    /**
     * 描述：设置/修改 角色权限
     *
     * @return
     */
    @ResponseBody
    @RequestMapping("/setRoleRights")
    public void setRoleRights(String menuIds) {
        // 设置参数
        HashMap<String,Object> queryParams = new HashMap<String,Object>();
        queryParams.put("id", 1);
        queryParams.put("roleRights", menuIds);
        // 修改权限
        Integer integer = roleService.setRoleRights(queryParams);
    }


    /**
     * 描述：查询角色权限
     *
     * @param id
     */
    @ResponseBody
    @RequestMapping("/findRoleRights")
    public void findRoleRights(Long id) {
        // 获取角色
        Role role = roleService.findById(id);
    }
}
