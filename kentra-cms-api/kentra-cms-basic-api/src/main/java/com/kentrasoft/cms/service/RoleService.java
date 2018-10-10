package com.kentrasoft.cms.service;


import com.kentrasoft.cms.base.service.BaseService;
import com.kentrasoft.cms.model.Role;

import java.util.HashMap;

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
}