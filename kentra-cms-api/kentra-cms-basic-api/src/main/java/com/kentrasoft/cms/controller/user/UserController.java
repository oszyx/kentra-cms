package com.kentrasoft.cms.controller.user;

import com.kentrasoft.base.controller.BaseController;
import com.kentrasoft.base.plugin.PageForm;
import com.kentrasoft.cms.model.User;
import com.kentrasoft.cms.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;

/**
 * 描述：用户controller
 *
 * @author zmk
 * @date 2018-9-28
 */
@Controller
@RequestMapping("/user")
public class UserController extends BaseController {
    @Autowired
    private UserService userService;

    /**
     * 描述：用户列表
     *
     * @param pf
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public PageForm<User> list(PageForm<User> pf) {
        HashMap<String, Object> pageData = this.getPageData();
        pf.setPageData(pageData);
        pf = userService.queryPageList(pf);
        return pf;
    }


    /**
     * 描述：添加用户
     *
     * @param user
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public Long add(User user) {
        Long id = (Long)userService.insertObject(user);
        return id;
    }


    /**
     * 描述：删除用户
     *
     * @param ids
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public Integer delete(String ids) {
        int i = userService.deleteByIdsStr(ids);
        return i;
    }


    /**
     * 描述：修改用户
     *
     * @param user
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public Integer edit(User user) {
        int i = userService.updateByObject(user);
        return i;
    }


    /**
     * 描述：设置/修改 用户权限
     *
     * @return
     */
    @ResponseBody
    @RequestMapping("/setUserRights")
    public void setUserRights(String roleIds) {
        // 设置参数
        HashMap<String,Object> queryParams = new HashMap<String,Object>();
        queryParams.put("id", 1);
        queryParams.put("userRights", roleIds);
        // 修改权限
        Integer integer = userService.setUserRights(queryParams);
    }
}
