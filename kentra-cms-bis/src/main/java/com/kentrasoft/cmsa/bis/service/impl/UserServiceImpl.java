package com.kentrasoft.cmsa.bis.service.impl;

import com.kentrasoft.cmsa.bis.dao.UserMapper;
import com.kentrasoft.cmsa.bis.entity.User;
import com.kentrasoft.cmsa.bis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

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
    public User findById(Long id) {
        return userMapper.findById(id);
    }
}
