package com.kentrasoft.cms.basic.controller.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author zmk
 * @date 2018-10-11
 */
@Controller
@RequestMapping("/user")
public class UserController {

    /**
     * 跳转到用户列表页面
     *
     * @return
     */
    @RequestMapping("/list")
    public String list() {
        return "system/user/user_list.html";
    }
}
