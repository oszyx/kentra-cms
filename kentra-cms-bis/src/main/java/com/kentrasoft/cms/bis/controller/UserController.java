package com.kentrasoft.cms.bis.controller;

import com.kentrasoft.cms.bis.entity.User;
import com.kentrasoft.cms.bis.service.UserService;
import com.kentrasoft.cms.common.cache.util.RedisUtil;
import com.kentrasoft.cms.common.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

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
    @Autowired
    private RedisUtil redisTemplate;
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
        Map<String, Object> claims = new HashMap<>(2);
        claims.put("sub", user.getUsername());
        claims.put("created", new Date());
        String token =JwtUtil.generateToken(claims,"123456",2592000L * 1000);
        user.setExt1(token);

        redisTemplate.set("token",user.getUsername()+":"+user.getPassword());
        return user;
    }

}
