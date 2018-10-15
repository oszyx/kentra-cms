package com.kentrasoft.cms.model;

import java.io.Serializable;
import java.util.List;


/**
 * 描述：User
 *
 * @author : zmk
 * @date : 2018-09-30
 */
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 用户id
     */
    private Long id;
    /**
     * 用户名
     */
    private String username;
    /**
     * 密码
     */
    private String password;
    /**
     * 姓名
     */
    private String name;
    /**
     * 生日
     */
    private java.util.Date birthday;
    /**
     * 性别：0-女 1-男
     */
    private Integer sex;
    /**
     * 电话号码
     */
    private String telphone;
    /**
     * 身份证号
     */
    private String idCard;
    /**
     * 用户权限
     */
    private String userRights;
    /**
     * 用户状态 0：禁用 1：可用
     */
    private Integer userStatus;
    /**
     * 创建者
     */
    private Long creator;
    /**
     * 创建时间
     */
    private java.util.Date createTime;
    /**
     * 修改者
     */
    private Long updator;
    /**
     * 修改时间
     */
    private java.util.Date updateTime;

    /**
     * 登录用户的token存放字段
     *
     * @return
     */
    private String userToken;
    /**
     * 登陆用户的menus存放字段
     */
    private List<Menu> userMenus;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public java.util.Date getBirthday() {
        return birthday;
    }

    public void setBirthday(java.util.Date birthday) {
        this.birthday = birthday;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getTelphone() {
        return telphone;
    }

    public void setTelphone(String telphone) {
        this.telphone = telphone;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getUserRights() {
        return userRights;
    }

    public void setUserRights(String userRights) {
        this.userRights = userRights;
    }

    public Integer getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(Integer userStatus) {
        this.userStatus = userStatus;
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

    public String getUserToken() {
        return userToken;
    }

    public void setUserToken(String userToken) {
        this.userToken = userToken;
    }

    public List<Menu> getUserMenus() {
        return userMenus;
    }

    public void setUserMenus(List<Menu> userMenus) {
        this.userMenus = userMenus;
    }
}