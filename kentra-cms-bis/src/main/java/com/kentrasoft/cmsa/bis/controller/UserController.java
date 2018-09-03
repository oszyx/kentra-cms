package com.kentrasoft.cmsa.bis.controller;

import com.kentrasoft.cmsa.bis.entity.User;
import com.kentrasoft.cmsa.bis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 描述：用户controller
 *
 * @author zhangmengkang
 * @date 2018-5-25 17:47:34
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    /**
     * 根据用户Id查询用户
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/findById")
    @ResponseBody
    public User findById(Long id) {
        User user = userService.findById(id);
        return user;
    }
}
