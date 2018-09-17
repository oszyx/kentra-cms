package com.kentrasoft.cms.bis.controller;

import com.kentrasoft.cms.common.cache.util.RedisUtil;
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
    private RedisUtil redisTemplate;

    @RequestMapping(value = "/setKey")
    @ResponseBody
    public void setKey() {
        redisTemplate.set("key1","永久有效");
        redisTemplate.set("key2","永久有效",5000L);
    }

    @RequestMapping(value = "/getKey")
    @ResponseBody
    public String getKey(String key) {
        String value = (String) redisTemplate.get(key);
        System.out.println(value);
        return value;
    }

}
