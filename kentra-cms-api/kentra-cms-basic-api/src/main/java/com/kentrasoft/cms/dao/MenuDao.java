package com.kentrasoft.cms.dao;

import com.kentrasoft.cms.base.dao.BaseDao;
import com.kentrasoft.cms.model.Menu;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * 描述：MenuDao
 *
 * @author : zmk
 * @date : 2018-09-30
 */
@Repository
public interface MenuDao extends BaseDao<Menu, Long> {

    /**
     * 登录用户的权限菜单
     *
     * @param params
     * @return
     */
    List<Menu> userMenuTree(Map<String, Object> params);
}
