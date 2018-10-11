package com.kentrasoft.cms.dao;

import com.kentrasoft.base.dao.BaseDao;
import com.kentrasoft.cms.model.User;
import org.springframework.stereotype.Repository;

import java.util.Map;

/**
 * 描述：UserDao
 *
 * @author : zmk
 * @date : 2018-09-30
 */
@Repository
public interface UserDao extends BaseDao<User, Long> {


    /**
     * 根据用户名查询用户信息
     *
     * @param params
     * @return
     */
    User findUserByUserName(Map<String, Object> params);
}
