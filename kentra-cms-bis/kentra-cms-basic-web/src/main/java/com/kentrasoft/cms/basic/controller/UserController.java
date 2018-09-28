package com.kentrasoft.cms.basic.controller;

import com.kentrasoft.cms.basic.client.UserRemote;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 描述：用户页面跳转控制controller
 *
 * @author zhangmengkang
 * @date 2018-6-7 10:25:16
 */
@RequestMapping("/user")
@Controller
public class UserController {
    @Autowired
    private UserRemote userRemote;

    @RequestMapping(value = "/goListPage")
    public String goPageList() {
        return "system/user/user_list";
    }


    /**
     * 描述：跳转到用户新增页面
     *
     * @return
     */
    @RequestMapping(value = "/goAddPage")
    public String add() {
        return "system/user/user_add";
    }


    /**
     * 描述：跳转到用户编辑页面
     *
     * @return
     */
    @RequestMapping(value = "/goEditPage")
    public String edit() {
        return "system/user/user_edit";
    }

    /**
     * 描述：跳转到用户编详情页面
     *
     * @return
     */
    @RequestMapping(value = "/goDetailPage")
    public String detail() {
        return "system/user/user_detail";
    }


    /**
     * 描述：跳转到角色树形菜单页面
     *
     * @return
     */
    @RequestMapping(value = "/goAddRolePage")
    public String roleTree() {
        return "system/user/user_addRole";
    }

}
