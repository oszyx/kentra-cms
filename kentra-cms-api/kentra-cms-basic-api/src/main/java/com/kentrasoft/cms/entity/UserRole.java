package com.kentrasoft.cms.entity;

import java.io.Serializable;

public class UserRole implements Serializable {
    /**
     * 用户_角色_id
     */
    private Long id;

    /**
     * 用户id
     */
    private Long userId;

    /**
     * 角色id
     */
    private Long roleId;

    /**
     * user_role
     */
    private static final long serialVersionUID = 1L;

    /**
     * 用户_角色_id
     * @return id 用户_角色_id
     */
    public Long getId() {
        return id;
    }

    /**
     * 用户_角色_id
     * @param id 用户_角色_id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 用户id
     * @return user_id 用户id
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * 用户id
     * @param userId 用户id
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * 角色id
     * @return role_id 角色id
     */
    public Long getRoleId() {
        return roleId;
    }

    /**
     * 角色id
     * @param roleId 角色id
     */
    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }
}