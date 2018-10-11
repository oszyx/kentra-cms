package com.kentrasoft.cms.service.impl;

import com.kentrasoft.base.dao.BaseDao;
import com.kentrasoft.base.service.impl.BaseServiceImpl;
import com.kentrasoft.cms.dao.RoleDao;
import com.kentrasoft.cms.model.Role;
import com.kentrasoft.cms.service.RoleService;
import com.kentrasoft.utils.RightsUtils.RightsHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.HashMap;

/**
 * 描述：RoleServiceImpl
 *
 * @author : zmk
 * @date : 2018-09-07
 */
@Service
public class RoleServiceImpl extends BaseServiceImpl<Role> implements RoleService {

    @Autowired
    private RoleDao roleDao;

    @Override
    public BaseDao getModelDao() {
        return this.roleDao;
    }


    /**
     * 描述：修改/添加 角色权限
     *
     * @param roleId
     * @param roleRights
     * @return
     */
    @Override
    public Integer addRights(Long roleId, String roleRights) {
        // 查询条件
        HashMap<String, Object> queryParam = new HashMap<>();
        queryParam.put("id", roleId);
        queryParam.put("roleRights", roleRights);

        return roleDao.updateByParams(queryParam);
    }


    /**
     * 描述：修改/添加 角色权限
     *
     * @param queryParams
     * @return
     */
    @Override
    public Integer setRoleRights(HashMap<String, Object> queryParams) {
        String userRights = (String) queryParams.get("roleRights");
        // 计算权限
        BigInteger bigInteger = RightsHelper.sumRights(userRights.split(","));
        queryParams.put("roleRights", bigInteger + "");
        int i = roleDao.updateByParams(queryParams);
        return i;
    }
}
