package com.kentrasoft.cms.service;


import com.kentrasoft.cms.base.service.BaseService;
import com.kentrasoft.cms.model.User;

import java.util.HashMap;

/**
 * 描述：UserService
 *
 * @author : zmk
 * @date : 2018-09-07
 */
public interface UserService extends BaseService<User> {

    public Integer setUserRights(HashMap<String, Object> queryParams) ;

    public User getUserById(Long userIds);
}