package com.kentrasoft.cms.controller;

import com.kentrasoft.cms.base.controller.BaseController;
import com.kentrasoft.cms.base.plugin.BaseResult;
import com.kentrasoft.cms.common.cache.util.RedisUtil;
import com.kentrasoft.cms.model.Menu;
import com.kentrasoft.cms.model.Role;
import com.kentrasoft.cms.model.User;
import com.kentrasoft.cms.service.MenuService;
import com.kentrasoft.cms.service.RoleService;
import com.kentrasoft.cms.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/cms")
public class Login extends BaseController {
    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @Autowired
    private MenuService menuService;

    @Autowired
    private RedisUtil redisUtil;


    /**
     * 描述:登陆验证
     *
     * @return
     */
    @RequestMapping("/login")
    public BaseResult login() {
        String username = (String) this.getPageData().get("username");
        String password = (String) this.getPageData().get("password");

        System.out.println("username:"+username+"  ____  password:"+password);

        // 用户名或密码为空
        if (username == "" || username == null || password == "" || password == null) {
            return null;
        }

        // 用户名或密码不正确
        List<User> users = userService.queryByParams(this.getPageData());
        if (users.size()==0) {
            return null;
        }

        // 返回用户信息
        User user = users.get(0);

        // 获得所有角色信息
        List<Role> roles = roleService.getRoleByUserRights(user.getUserRights());

        // 获取所有的菜单信息
        List<Menu> menus = new ArrayList<>();
        for (Role role : roles) {
            List<Menu> roleMenus =menuService.getMenuByRoleRights(role.getRoleRights());
            menus.addAll(roleMenus);
        }

        // 获得用户树形菜单
        List<Menu> menuTree = menuService.getMenuTree(menus);
        List<Menu> buttonRights = menuService.getButtonRights(menus);

        // 返回初始化信息
        Map<String, Object> userInfo = new HashMap<>();
        userInfo.put("user", user);
        userInfo.put("menu", menuTree);
        userInfo.put("button", buttonRights);

        // 生成token储存到redis 和 cookie

        return BaseResult.success("success",userInfo);
    }

    /**
     * 描述:初始化页面
     *
     * @return
     */
    @RequestMapping("/init")
    public HashMap<String, String> init() {

        return null;
    }

}
