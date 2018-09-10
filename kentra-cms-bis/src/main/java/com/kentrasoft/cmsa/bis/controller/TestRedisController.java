package com.kentrasoft.cmsa.bis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 描述：用户controller
 *
 * @author zhangmengkang
 * @date 2018-5-25 17:47:34
 */
@Controller
@RequestMapping("/testRedis")
public class TestRedisController {
    @Autowired
    private RedisTemplate redisTemplate;

    @RequestMapping(value = "/setKey")
    @ResponseBody
    public void setKey() {
        redisTemplate.opsForValue().set("liyang", "liyang");
        redisTemplate.opsForValue().set("a", "a1");
        redisTemplate.opsForValue().set("b", "b");
        redisTemplate.opsForValue().set("c", "c");
        redisTemplate.opsForValue().set("d", "1234");
    }

    @RequestMapping(value = "/getKey")
    @ResponseBody
    public String getKey(String key) {
        String value = (String) redisTemplate.opsForValue().get(key);
        System.out.println(value);
        return value;
    }

}
