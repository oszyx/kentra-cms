package com.kentrasoft.cms.bis.service;

import com.kentrasoft.cms.bis.entity.User;

/**
 * 描述：用户service接口
 *
 * @author zhangmengkang
 * @date 2018/5/28 10:26
 */
public interface UserService {
    /**
     * 描述：根据用户Id查找 用户
     * @param id
     * @return
     */
    User findById(Long id);
}
