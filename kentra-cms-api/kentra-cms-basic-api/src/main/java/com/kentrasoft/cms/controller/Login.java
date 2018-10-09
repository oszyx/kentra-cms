package com.kentrasoft.cms.controller;

import com.kentrasoft.base.controller.BaseController;
import com.kentrasoft.cms.common.cache.util.RedisUtil;
import com.kentrasoft.cms.model.User;
import com.kentrasoft.cms.service.MenuService;
import com.kentrasoft.cms.service.UserService;
import com.kentrasoft.utils.jwt.JWTUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/cms")
public class Login extends BaseController {
    @Autowired
    private UserService userService;

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
    public HashMap<String, String> login() {
        String username = (String) this.getPageData().get("username");
        String password = (String) this.getPageData().get("password");

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
        // 生成token储存到redis 和 cookie


        return null;
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
