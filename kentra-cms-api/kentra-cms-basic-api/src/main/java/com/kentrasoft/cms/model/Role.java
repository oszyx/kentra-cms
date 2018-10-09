package com.kentrasoft.cms.model;

import java.io.Serializable;


/**
 * 描述：Role
 *
 * @author : zmk
 * @date : 2018-09-30
 */
public class Role implements Serializable{

    private static final long serialVersionUID = 1L;

    /**
     * 角色id
     */
	private Long id;
    /**
     * 角色名
     */
	private String roleName;
    /**
     * 角色码
     */
	private String roleCode;
    /**
     * 角色权限
     */
	private String roleRights;
    /**
     * 角色状态: 0-不可用 1-正常
     */
	private Integer roleStatus;
    /**
     * 角色分组
     */
	private Long rolePid;
    /**
     * 创建人
     */
	private Long creator;
    /**
     * 创建时间
     */
	private java.util.Date createTime;
    /**
     * 修改人
     */
	private Long updator;
    /**
     * 修改时间
     */
	private java.util.Date updateTime;

    public Long getId() {
    	return id;
    }

    public void setId(Long id) {
    	this.id = id;
    }

    public String getRoleName() {
    	return roleName;
    }

    public void setRoleName(String roleName) {
    	this.roleName = roleName;
    }

    public String getRoleCode() {
    	return roleCode;
    }

    public void setRoleCode(String roleCode) {
    	this.roleCode = roleCode;
    }

    public String getRoleRights() {
    	return roleRights;
    }

    public void setRoleRights(String roleRights) {
    	this.roleRights = roleRights;
    }

    public Integer getRoleStatus() {
    	return roleStatus;
    }

    public void setRoleStatus(Integer roleStatus) {
    	this.roleStatus = roleStatus;
    }

    public Long getRolePid() {
    	return rolePid;
    }

    public void setRolePid(Long rolePid) {
    	this.rolePid = rolePid;
    }

    public Long getCreator() {
    	return creator;
    }

    public void setCreator(Long creator) {
    	this.creator = creator;
    }

    public java.util.Date getCreateTime() {
    	return createTime;
    }

    public void setCreateTime(java.util.Date createTime) {
    	this.createTime = createTime;
    }

    public Long getUpdator() {
    	return updator;
    }

    public void setUpdator(Long updator) {
    	this.updator = updator;
    }

    public java.util.Date getUpdateTime() {
    	return updateTime;
    }

    public void setUpdateTime(java.util.Date updateTime) {
    	this.updateTime = updateTime;
    }

}