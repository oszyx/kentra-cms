package com.kentrasoft.cms.entity;

import java.io.Serializable;
import java.util.Date;

public class User implements Serializable {
    /**
     * 用户id
     */
    private Long id;

    /**
     * 用户名
     */
    private String username;

    /**
     * 登录密码
     */
    private String password;

    /**
     * 手机号码
     */
    private String telphone;

    /**
     * 出生日期
     */
    private Date birthday;

    /**
     * 身份证号
     */
    private String identityCard;

    /**
     * 
     */
    private Integer relySystem;

    /**
     * 用户状态
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

    /**
     * 扩展字段
     */
    private String ext1;

    /**
     * 扩展字段
     */
    private String ext2;

    /**
     * user
     */
    private static final long serialVersionUID = 1L;

    /**
     * 用户id
     * @return id 用户id
     */
    public Long getId() {
        return id;
    }

    /**
     * 用户id
     * @param id 用户id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 用户名
     * @return username 用户名
     */
    public String getUsername() {
        return username;
    }

    /**
     * 用户名
     * @param username 用户名
     */
    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    /**
     * 登录密码
     * @return password 登录密码
     */
    public String getPassword() {
        return password;
    }

    /**
     * 登录密码
     * @param password 登录密码
     */
    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    /**
     * 手机号码
     * @return telphone 手机号码
     */
    public String getTelphone() {
        return telphone;
    }

    /**
     * 手机号码
     * @param telphone 手机号码
     */
    public void setTelphone(String telphone) {
        this.telphone = telphone == null ? null : telphone.trim();
    }

    /**
     * 出生日期
     * @return birthday 出生日期
     */
    public Date getBirthday() {
        return birthday;
    }

    /**
     * 出生日期
     * @param birthday 出生日期
     */
    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    /**
     * 身份证号
     * @return identity_card 身份证号
     */
    public String getIdentityCard() {
        return identityCard;
    }

    /**
     * 身份证号
     * @param identityCard 身份证号
     */
    public void setIdentityCard(String identityCard) {
        this.identityCard = identityCard == null ? null : identityCard.trim();
    }

    /**
     * 
     * @return rely_system 
     */
    public Integer getRelySystem() {
        return relySystem;
    }

    /**
     * 
     * @param relySystem 
     */
    public void setRelySystem(Integer relySystem) {
        this.relySystem = relySystem;
    }

    /**
     * 用户状态
     * @return status 用户状态
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 用户状态
     * @param status 用户状态
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

    /**
     * 扩展字段
     * @return ext1 扩展字段
     */
    public String getExt1() {
        return ext1;
    }

    /**
     * 扩展字段
     * @param ext1 扩展字段
     */
    public void setExt1(String ext1) {
        this.ext1 = ext1 == null ? null : ext1.trim();
    }

    /**
     * 扩展字段
     * @return ext2 扩展字段
     */
    public String getExt2() {
        return ext2;
    }

    /**
     * 扩展字段
     * @param ext2 扩展字段
     */
    public void setExt2(String ext2) {
        this.ext2 = ext2 == null ? null : ext2.trim();
    }
}