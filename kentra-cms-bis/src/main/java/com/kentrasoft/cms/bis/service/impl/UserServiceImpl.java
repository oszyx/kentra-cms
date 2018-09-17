package com.kentrasoft.cms.bis.service.impl;

import com.kentrasoft.cms.bis.dao.UserMapper;
import com.kentrasoft.cms.bis.entity.User;
import com.kentrasoft.cms.bis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * 描述：
 *
 * @author zhangmengkang
 * @date 2018/5/28 10:25
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    /**
     * 描述：根据用户Id查找 用户
     *
     * @param id
     * @return
     */
    @Override
    @Cacheable(value="user", key="'user'.concat(#id.toString())")
    public User findById(Long id) {
//        try {
//            Thread.sleep(10000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

        return userMapper.findById(id);
    }
}
