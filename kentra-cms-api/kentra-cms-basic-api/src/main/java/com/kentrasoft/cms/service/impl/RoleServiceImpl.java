package com.kentrasoft.cms.service.impl;

import com.kentrasoft.cms.base.dao.BaseDao;
import com.kentrasoft.cms.base.service.impl.BaseServiceImpl;
import com.kentrasoft.cms.dao.RoleDao;
import com.kentrasoft.cms.model.Role;
import com.kentrasoft.cms.service.RoleService;
import com.kentrasoft.cms.common.util.RightsUtils.RightsHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

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

    /**
     * 描述：根据用户权限 获得角色
     *
     * @param userRights
     * @return
     */
    @Override
    public List<Role> getRoleByUserRights(String userRights) {
        // 从缓存中获取数据
        List<Role> all = this.findAll();
        List<Role> roles = new ArrayList<>();
        for (Role role : all) {
            boolean flag = RightsHelper.testRights(userRights, role.getId() + "");
            if (flag) {
                roles.add(role);
            }
        }
        return roles;
    }
}
