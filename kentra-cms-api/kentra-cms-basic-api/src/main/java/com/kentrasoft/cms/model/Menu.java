package com.kentrasoft.cms.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


/**
 * 描述：Menu
 *
 * @author : zmk
 * @date : 2018-09-30
 */
public class Menu implements Serializable{

    private static final long serialVersionUID = 1L;

    /**
     * 菜单id
     */
	private Long id;
    /**
     * 菜单code
     */
	private String menuCode;
    /**
     * 菜单名称
     */
	private String menuName;
    /**
     * 菜单icon
     */
	private String menuIcon;
    /**
     * 菜单访问路径
     */
	private String menuUrl;
    /**
     * 是否展开(0:闭合 1:展开)
     */
	private Integer menuSpread;
    /**
     * 叶子节点(0:主干 1:叶子)
     */
	private Integer menuLeaf;
    /**
     * 菜单顺序
     */
	private Integer menuOrder;
    /**
     * 菜单状态(0:禁用 1:可用)
     */
	private Integer menuStatus;
    /**
     * 菜单描述
     */
	private String menuDesc;
    /**
     * 父级菜单id
     */
	private Long menuPid;
    /**
     * 创建人
     */
	private Long creator;
    /**
     * 修改人
     */
	private Long updator;
    /**
     * 创建时间
     */
	private java.util.Date createTime;
    /**
     * 更新时间
     */
	private java.util.Date updateTime;

    public Long getId() {
    	return id;
    }

    public void setId(Long id) {
    	this.id = id;
    }

    public String getMenuCode() {
    	return menuCode;
    }

    public void setMenuCode(String menuCode) {
    	this.menuCode = menuCode;
    }

    public String getMenuName() {
    	return menuName;
    }

    public void setMenuName(String menuName) {
    	this.menuName = menuName;
    }

    public String getMenuIcon() {
    	return menuIcon;
    }

    public void setMenuIcon(String menuIcon) {
    	this.menuIcon = menuIcon;
    }

    public String getMenuUrl() {
    	return menuUrl;
    }

    public void setMenuUrl(String menuUrl) {
    	this.menuUrl = menuUrl;
    }

    public Integer getMenuSpread() {
    	return menuSpread;
    }

    public void setMenuSpread(Integer menuSpread) {
    	this.menuSpread = menuSpread;
    }

    public Integer getMenuLeaf() {
    	return menuLeaf;
    }

    public void setMenuLeaf(Integer menuLeaf) {
    	this.menuLeaf = menuLeaf;
    }

    public Integer getMenuOrder() {
    	return menuOrder;
    }

    public void setMenuOrder(Integer menuOrder) {
    	this.menuOrder = menuOrder;
    }

    public Integer getMenuStatus() {
    	return menuStatus;
    }

    public void setMenuStatus(Integer menuStatus) {
    	this.menuStatus = menuStatus;
    }

    public String getMenuDesc() {
    	return menuDesc;
    }

    public void setMenuDesc(String menuDesc) {
    	this.menuDesc = menuDesc;
    }

    public Long getMenuPid() {
    	return menuPid;
    }

    public void setMenuPid(Long menuPid) {
    	this.menuPid = menuPid;
    }

    public Long getCreator() {
    	return creator;
    }

    public void setCreator(Long creator) {
    	this.creator = creator;
    }

    public Long getUpdator() {
    	return updator;
    }

    public void setUpdator(Long updator) {
    	this.updator = updator;
    }

    public java.util.Date getCreateTime() {
    	return createTime;
    }

    public void setCreateTime(java.util.Date createTime) {
    	this.createTime = createTime;
    }

    public java.util.Date getUpdateTime() {
    	return updateTime;
    }

    public void setUpdateTime(java.util.Date updateTime) {
    	this.updateTime = updateTime;
    }

    private List<Menu> childMenus;

    public List<Menu> getChildMenus() {
        return childMenus;
    }

    public void setChildMenus(List<Menu> childMenus) {
        this.childMenus = childMenus;
    }

    public void addChildMenu(Menu childMenu) {
        if (this.childMenus==null) {
            this.childMenus = new ArrayList<Menu>();
        }
        this.childMenus.add(childMenu);
    }

    public void sameLevelSort() {
        if (childMenus != null && childMenus.size() != 0) {
            Collections.sort(childMenus, new Comparator<Menu>() {
                @Override
                public int compare(Menu m1, Menu m2) {
                    int a = m1.getMenuOrder();
                    int b = m2.getMenuOrder();
                    return (a < b ? -1 : (a == b ? 0 : 1));
                }
            });
            for (Menu n : childMenus) {
                n.sameLevelSort();
            }
        }
    }

}