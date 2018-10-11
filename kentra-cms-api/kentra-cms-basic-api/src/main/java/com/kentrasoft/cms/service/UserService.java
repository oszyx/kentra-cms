package com.kentrasoft.cms.service;


import com.kentrasoft.base.service.BaseService;
import com.kentrasoft.cms.model.User;

import java.util.HashMap;
import java.util.Map;

/**
 * 描述：UserService
 *
 * @author : zmk
 * @date : 2018-09-07
 */
public interface UserService extends BaseService<User> {

    public Integer setUserRights(HashMap<String, Object> queryParams);

    public User getUserById(Long userIds);

    /**
     * 根据用户名查询用户信息
     *
     * @param params
     * @return
     */
    User findUserByUserName(Map<String, Object> params);
}