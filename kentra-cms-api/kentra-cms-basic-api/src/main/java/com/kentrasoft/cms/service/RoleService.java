package com.kentrasoft.cms.service;


import com.kentrasoft.cms.base.service.BaseService;
import com.kentrasoft.cms.model.Role;

import java.util.HashMap;
import java.util.List;

/**
 * 描述：RoleService
 *
 * @author : zmk
 * @date : 2018-09-07
 */
public interface RoleService extends BaseService<Role> {

    /**
     * 描述：修改/添加 角色权限
     *
     * @param roleId
     * @param roleRights
     * @return
     */
    Integer addRights(Long roleId, String roleRights);

    /**
     * 描述：修改/添加 角色权限
     *
     * @param queryParams
     * @return
     */
    Integer setRoleRights(HashMap<String, Object> queryParams);

    /**
     * 描述：根据用户权限 获得角色
     *
     * @param userRights
     * @return
     */
    List<Role> getRoleByUserRights(String userRights);
}