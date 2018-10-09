package com.kentrasoft.cms.service.impl;

import com.kentrasoft.base.dao.BaseDao;
import com.kentrasoft.base.service.impl.BaseServiceImpl;
import com.kentrasoft.cms.dao.UserDao;
import com.kentrasoft.cms.model.User;
import com.kentrasoft.utils.RightsUtils.RightsHelper;
import com.kentrasoft.cms.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.HashMap;

/**
 * 描述：UserServiceImpl
 *
 * @author : zmk
 * @date : 2018-09-07
 */
@Service
public class UserServiceImpl extends BaseServiceImpl<User> implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public BaseDao getModelDao() {
        return this.userDao;
    }

    /**
     * 描述：设置用户权限
     *
     * @return
     */
    @Override
    public Integer setUserRights(HashMap<String,Object> queryParams) {
        String userRights = (String)queryParams.get("userRights");
        // 计算权限
        BigInteger bigInteger = RightsHelper.sumRights(userRights.split(","));
        queryParams.put("userRights", bigInteger+"");
        int i = userDao.updateByParams(queryParams);
        return i;
    }

    /**
     * 描述：根据用户id获取用户
     *
     * @param userIds
     * @return
     */
    @Override
    public User getUserById(Long userIds) {
        return userDao.findById(userIds);
    }
}
