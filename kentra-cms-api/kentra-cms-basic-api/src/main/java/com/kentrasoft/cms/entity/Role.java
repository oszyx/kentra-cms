package com.kentrasoft.cms.entity;

import java.io.Serializable;
import java.util.Date;

public class Role implements Serializable {
    /**
     * 角色id
     */
    private Long id;

    /**
     * 角色名
     */
    private String roleName;

    /**
     * 角色code
     */
    private String roleCode;

    /**
     * 角色从属：所属系统
     */
    private Integer relySystem;

    /**
     * 父角色id
     */
    private Long roleParentId;

    /**
     * 角色信息描述
     */
    private String desc;

    /**
     * 角色状态
     */
    private Integer status;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;
    
    private String roleTreeUrl;

    public String getRoleTreeUrl() {
		return roleTreeUrl;
	}

	public void setRoleTreeUrl(String roleTreeUrl) {
		this.roleTreeUrl = roleTreeUrl;
	}

	/**
     * role
     */
    private static final long serialVersionUID = 1L;

    /**
     * 角色id
     * @return id 角色id
     */
    public Long getId() {
        return id;
    }

    /**
     * 角色id
     * @param id 角色id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 角色名
     * @return role_name 角色名
     */
    public String getRoleName() {
        return roleName;
    }

    /**
     * 角色名
     * @param roleName 角色名
     */
    public void setRoleName(String roleName) {
        this.roleName = roleName == null ? null : roleName.trim();
    }

    /**
     * 角色code
     * @return role_code 角色code
     */
    public String getRoleCode() {
        return roleCode;
    }

    /**
     * 角色code
     * @param roleCode 角色code
     */
    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode == null ? null : roleCode.trim();
    }

    /**
     * 角色从属：所属系统
     * @return rely_system 角色从属：所属系统
     */
    public Integer getRelySystem() {
        return relySystem;
    }

    /**
     * 角色从属：所属系统
     * @param relySystem 角色从属：所属系统
     */
    public void setRelySystem(Integer relySystem) {
        this.relySystem = relySystem;
    }

    /**
     * 父角色id
     * @return role_parent_id 父角色id
     */
    public Long getRoleParentId() {
        return roleParentId;
    }

    /**
     * 父角色id
     * @param roleParentId 父角色id
     */
    public void setRoleParentId(Long roleParentId) {
        this.roleParentId = roleParentId;
    }

    /**
     * 角色信息描述
     * @return desc 角色信息描述
     */
    public String getDesc() {
        return desc;
    }

    /**
     * 角色信息描述
     * @param desc 角色信息描述
     */
    public void setDesc(String desc) {
        this.desc = desc == null ? null : desc.trim();
    }

    /**
     * 角色状态
     * @return status 角色状态
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 角色状态
     * @param status 角色状态
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * 创建时间
     * @return create_time 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 创建时间
     * @param createTime 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 更新时间
     * @return update_time 更新时间
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 更新时间
     * @param updateTime 更新时间
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    
}