package com.kentrasoft.cms.entity;

import java.io.Serializable;

public class RoleMenu implements Serializable {
    /**
     * 角色_菜单_id
     */
    private Long id;

    /**
     * 菜单id
     */
    private Long menuId;

    /**
     * 角色id
     */
    private Long roleId;

    /**
     * role_menu
     */
    private static final long serialVersionUID = 1L;

    /**
     * 角色_菜单_id
     * @return id 角色_菜单_id
     */
    public Long getId() {
        return id;
    }

    /**
     * 角色_菜单_id
     * @param id 角色_菜单_id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 菜单id
     * @return menu_id 菜单id
     */
    public Long getMenuId() {
        return menuId;
    }

    /**
     * 菜单id
     * @param menuId 菜单id
     */
    public void setMenuId(Long menuId) {
        this.menuId = menuId;
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