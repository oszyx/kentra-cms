package com.kentrasoft.cms.dao;

import com.kentrasoft.cms.base.dao.BaseDao;
import com.kentrasoft.cms.model.User;
import org.springframework.stereotype.Repository;

/**
 * 描述：UserDao
 *
 * @author : zmk
 * @date : 2018-09-30
 */
@Repository
public interface UserDao  extends BaseDao<User,Long> {

}
