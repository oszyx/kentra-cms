package com.kentrasoft.cms.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class Menu implements Serializable {
    /**
     * 菜单id
     */
    private Long id;

    /**
     * 菜单名称
     */
    private String menuName;

    /**
     * 菜单code
     */
    private String menuCode;

    /**
     * 菜单访问路径
     */
    private String menuUrl;

    /**
     * 父级菜单id
     */
    private Long menuParentId;

    /**
     * 菜单打开方式
     */
    private String menuTarget;

    /**
     * 菜单样式
     */
    private String menuStyle;

    /**
     * 菜单顺序
     */
    private String menuOrder;

    /**
     * 菜单从属：所属系统
     */
    private String relySystem;

    /**
     * 菜单状态
     */
    private String status;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;
    
    
    /**
     * 子菜单集
     */
    private List<Menu> menus;

    /**
     * menu
     */
    private static final long serialVersionUID = 1L;

    /**
     * 菜单id
     * @return id 菜单id
     */
    public Long getId() {
        return id;
    }

    /**
     * 菜单id
     * @param id 菜单id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 菜单名称
     * @return menu_name 菜单名称
     */
    public String getMenuName() {
        return menuName;
    }

    /**
     * 菜单名称
     * @param menuName 菜单名称
     */
    public void setMenuName(String menuName) {
        this.menuName = menuName == null ? null : menuName.trim();
    }

    /**
     * 菜单code
     * @return menu_code 菜单code
     */
    public String getMenuCode() {
        return menuCode;
    }

    /**
     * 菜单code
     * @param menuCode 菜单code
     */
    public void setMenuCode(String menuCode) {
        this.menuCode = menuCode == null ? null : menuCode.trim();
    }

    /**
     * 菜单访问路径
     * @return menu_url 菜单访问路径
     */
    public String getMenuUrl() {
        return menuUrl;
    }

    /**
     * 菜单访问路径
     * @param menuUrl 菜单访问路径
     */
    public void setMenuUrl(String menuUrl) {
        this.menuUrl = menuUrl == null ? null : menuUrl.trim();
    }

    /**
     * 父级菜单id
     * @return menu_parent_id 父级菜单id
     */
    public Long getMenuParentId() {
        return menuParentId;
    }

    /**
     * 父级菜单id
     * @param menuParentId 父级菜单id
     */
    public void setMenuParentId(Long menuParentId) {
        this.menuParentId = menuParentId;
    }

    /**
     * 菜单打开方式
     * @return menu_target 菜单打开方式
     */
    public String getMenuTarget() {
        return menuTarget;
    }

    /**
     * 菜单打开方式
     * @param menuTarget 菜单打开方式
     */
    public void setMenuTarget(String menuTarget) {
        this.menuTarget = menuTarget == null ? null : menuTarget.trim();
    }

    /**
     * 菜单样式
     * @return menu_style 菜单样式
     */
    public String getMenuStyle() {
        return menuStyle;
    }

    /**
     * 菜单样式
     * @param menuStyle 菜单样式
     */
    public void setMenuStyle(String menuStyle) {
        this.menuStyle = menuStyle == null ? null : menuStyle.trim();
    }

    /**
     * 菜单顺序
     * @return menu_order 菜单顺序
     */
    public String getMenuOrder() {
        return menuOrder;
    }

    /**
     * 菜单顺序
     * @param menuOrder 菜单顺序
     */
    public void setMenuOrder(String menuOrder) {
        this.menuOrder = menuOrder;
    }

    /**
     * 菜单从属：所属系统
     * @return rely_system 菜单从属：所属系统
     */
    public String getRelySystem() {
        return relySystem;
    }

    /**
     * 菜单从属：所属系统
     * @param relySystem 菜单从属：所属系统
     */
    public void setRelySystem(String relySystem) {
        this.relySystem = relySystem;
    }

    /**
     * 菜单状态
     * @return status 菜单状态
     */
    public String getStatus() {
        return status;
    }

    /**
     * 菜单状态
     * @param status 菜单状态
     */
    public void setStatus(String status) {
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

	public List<Menu> getMenus() {
		return menus;
	}

	public void setMenus(List<Menu> menus) {
		this.menus = menus;
	}
    
    
    
}