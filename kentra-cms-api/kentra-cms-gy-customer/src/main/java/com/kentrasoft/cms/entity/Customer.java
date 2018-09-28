package com.kentrasoft.cms.entity;

import java.io.Serializable;
import java.util.Date;

public class Customer implements Serializable {
    /**
     * 用户ID
     */
    private Long id;

    /**
     * 姓名
     */
    private String name;

    /**
     * 用户密码
     */
    private String password;
    /**
     * 性别
     */
    private String sex;

    /**
     * 国籍
     */
    private String national;

    /**
     * 出生日期
     */
    private Date birthday;

    /**
     * 头像
     */
    private String photo;

    /**
     * 证件类型
     */
    private String documentType;

    /**
     * 证件号码
     */
    private String documentNum;

    /**
     * 联系方式1 手机
     */
    private String linkTelphone1;

    /**
     * 联系方式2 座机
     */
    private String linkTelphone2;

    /**
     * 联系地址
     */
    private String linkAddress;

    /**
     * 驾驶证号码
     */
    private String driveNum;

    /**
     * 准驾车型
     */
    private String driveType;

    /**
     * 初次领证日期
     */
    private Date evidenceStart;

    /**
     * 有效期开始日期
     */
    private Date effectiveStart;

    /**
     * 有效期结束日期
     */
    private Date effectiveEnd;

    /**
     * 有效期限
     */
    private String expirationDate;

    /**
     * 创建日期
     */
    private Date createTime;

    /**
     * 更新日期
     */
    private Date updateTime;

    /**
     * 客户状态（1：正常；2：黑名单；3：白名单
     */
    private String customerStatus;

    /**
     * 驾驶证图片
     */
    private String driverLicense;

    /**
     * 备用字段1
     */
    private String extends1;

    /**
     * 备用字段2
     */
    private String extends2;

    /**
     * 备用字段3
     */
    private String extends3;

    /**
     * 用于统计用户注册数据
     */
    private Integer totalNum;
    private  Integer amount;

    /**
     * customer
     */
    private static final long serialVersionUID = 1L;

    /**
     * 用户ID
     * @return id 用户ID
     */
    public Long getId() {
        return id;
    }

    /**
     * 用户ID
     * @param id 用户ID
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 姓名
     * @return name 姓名
     */
    public String getName() {
        return name;
    }

    /**
     * 姓名
     * @param name 姓名
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * 性别
     * @return sex 性别
     */
    public String getSex() {
        return sex;
    }

    /**
     * 性别
     * @param sex 性别
     */
    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    /**
     * 国籍
     * @return national 国籍
     */
    public String getNational() {
        return national;
    }

    /**
     * 国籍
     * @param national 国籍
     */
    public void setNational(String national) {
        this.national = national == null ? null : national.trim();
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
     * 头像
     * @return photo 头像
     */
    public String getPhoto() {
        return photo;
    }

    /**
     * 头像
     * @param photo 头像
     */
    public void setPhoto(String photo) {
        this.photo = photo == null ? null : photo.trim();
    }

    /**
     * 证件类型
     * @return document_type 证件类型
     */
    public String getDocumentType() {
        return documentType;
    }

    /**
     * 证件类型
     * @param documentType 证件类型
     */
    public void setDocumentType(String documentType) {
        this.documentType = documentType == null ? null : documentType.trim();
    }

    /**
     * 证件号码
     * @return document_num 证件号码
     */
    public String getDocumentNum() {
        return documentNum;
    }

    /**
     * 证件号码
     * @param documentNum 证件号码
     */
    public void setDocumentNum(String documentNum) {
        this.documentNum = documentNum == null ? null : documentNum.trim();
    }

    /**
     * 联系方式1 手机
     * @return link_telphone1 联系方式1 手机
     */
    public String getLinkTelphone1() {
        return linkTelphone1;
    }

    /**
     * 联系方式1 手机
     * @param linkTelphone1 联系方式1 手机
     */
    public void setLinkTelphone1(String linkTelphone1) {
        this.linkTelphone1 = linkTelphone1 == null ? null : linkTelphone1.trim();
    }

    /**
     * 联系方式2 座机
     * @return link_telphone2 联系方式2 座机
     */
    public String getLinkTelphone2() {
        return linkTelphone2;
    }

    /**
     * 联系方式2 座机
     * @param linkTelphone2 联系方式2 座机
     */
    public void setLinkTelphone2(String linkTelphone2) {
        this.linkTelphone2 = linkTelphone2 == null ? null : linkTelphone2.trim();
    }

    /**
     * 联系地址
     * @return link_address 联系地址
     */
    public String getLinkAddress() {
        return linkAddress;
    }

    /**
     * 联系地址
     * @param linkAddress 联系地址
     */
    public void setLinkAddress(String linkAddress) {
        this.linkAddress = linkAddress == null ? null : linkAddress.trim();
    }

    /**
     * 驾驶证号码
     * @return drive_num 驾驶证号码
     */
    public String getDriveNum() {
        return driveNum;
    }

    /**
     * 驾驶证号码
     * @param driveNum 驾驶证号码
     */
    public void setDriveNum(String driveNum) {
        this.driveNum = driveNum == null ? null : driveNum.trim();
    }

    /**
     * 准驾车型
     * @return drive_type 准驾车型
     */
    public String getDriveType() {
        return driveType;
    }

    /**
     * 准驾车型
     * @param driveType 准驾车型
     */
    public void setDriveType(String driveType) {
        this.driveType = driveType == null ? null : driveType.trim();
    }

    /**
     * 初次领证日期
     * @return evidence_start 初次领证日期
     */
    public Date getEvidenceStart() {
        return evidenceStart;
    }

    /**
     * 初次领证日期
     * @param evidenceStart 初次领证日期
     */
    public void setEvidenceStart(Date evidenceStart) {
        this.evidenceStart = evidenceStart;
    }

    /**
     * 有效期开始日期
     * @return effective_start 有效期开始日期
     */
    public Date getEffectiveStart() {
        return effectiveStart;
    }

    /**
     * 有效期开始日期
     * @param effectiveStart 有效期开始日期
     */
    public void setEffectiveStart(Date effectiveStart) {
        this.effectiveStart = effectiveStart;
    }

    /**
     * 有效期结束日期
     * @return effective_end 有效期结束日期
     */
    public Date getEffectiveEnd() {
        return effectiveEnd;
    }

    /**
     * 有效期结束日期
     * @param effectiveEnd 有效期结束日期
     */
    public void setEffectiveEnd(Date effectiveEnd) {
        this.effectiveEnd = effectiveEnd;
    }

    /**
     * 有效期限
     * @return expiration_date 有效期限
     */
    public String getExpirationDate() {
        return expirationDate;
    }

    /**
     * 有效期限
     * @param expirationDate 有效期限
     */
    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate == null ? null : expirationDate.trim();
    }

    /**
     * 创建日期
     * @return create_time 创建日期
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 创建日期
     * @param createTime 创建日期
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 更新日期
     * @return update_time 更新日期
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 更新日期
     * @param updateTime 更新日期
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * 客户状态（1：正常；2：黑名单；3：白名单
     * @return customer_status 客户状态（1：正常；2：黑名单；3：白名单
     */
    public String getCustomerStatus() {
        return customerStatus;
    }

    /**
     * 客户状态（1：正常；2：黑名单；3：白名单
     * @param customerStatus 客户状态（1：正常；2：黑名单；3：白名单
     */
    public void setCustomerStatus(String customerStatus) {
        this.customerStatus = customerStatus == null ? null : customerStatus.trim();
    }

    /**
     * 驾驶证图片
     * @return driver_license 驾驶证图片
     */
    public String getDriverLicense() {
        return driverLicense;
    }

    /**
     * 驾驶证图片
     * @param driverLicense 驾驶证图片
     */
    public void setDriverLicense(String driverLicense) {
        this.driverLicense = driverLicense == null ? null : driverLicense.trim();
    }

    /**
     * 备用字段1
     * @return extends1 备用字段1
     */
    public String getExtends1() {
        return extends1;
    }

    /**
     * 备用字段1
     * @param extends1 备用字段1
     */
    public void setExtends1(String extends1) {
        this.extends1 = extends1 == null ? null : extends1.trim();
    }

    /**
     * 备用字段2
     * @return extends2 备用字段2
     */
    public String getExtends2() {
        return extends2;
    }

    /**
     * 备用字段2
     * @param extends2 备用字段2
     */
    public void setExtends2(String extends2) {
        this.extends2 = extends2 == null ? null : extends2.trim();
    }

    /**
     * 备用字段3
     * @return extends3 备用字段3
     */
    public String getExtends3() {
        return extends3;
    }

    /**
     * 备用字段3
     * @param extends3 备用字段3
     */
    public void setExtends3(String extends3) {
        this.extends3 = extends3 == null ? null : extends3.trim();
    }

    public Integer getTotalNum() {
        return totalNum;
    }

    public void setTotalNum(Integer totalNum) {
        this.totalNum = totalNum;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }
}