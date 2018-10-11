package com.kentrasoft.cms.service.impl;

import com.kentrasoft.cms.base.dao.BaseDao;
import com.kentrasoft.cms.base.service.impl.BaseServiceImpl;
import com.kentrasoft.cms.dao.UserDao;
import com.kentrasoft.cms.model.User;
import com.kentrasoft.cms.common.util.RightsUtils.RightsHelper;
import com.kentrasoft.cms.service.UserService;
import com.kentrasoft.utils.RightsUtils.RightsHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

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
    public Integer setUserRights(HashMap<String, Object> queryParams) {
        String userRights = (String) queryParams.get("userRights");
        // 计算权限
        BigInteger bigInteger = RightsHelper.sumRights(userRights.split(","));
        queryParams.put("userRights", bigInteger + "");
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

    /**
     * 根据用户名查询用户信息
     *
     * @param params
     * @return
     */
    @Override
    public User findUserByUserName(Map<String, Object> params) {
        return userDao.findUserByUserName(params);
    }
}
