package com.kentrasoft.cms.entity;

import java.io.Serializable;
import java.util.Date;

public class DrivingLicense implements Serializable {
    /**
     * 行驶证ID
     */
    private Long id;

    /**
     * 用户ID
     */
    private Long customerId;

    /**
     * 优先等级
     */
    private String customerLevel;

    /**
     * 车牌号码
     */
    private String licenseNum;
    /**
     * 行驶证号码
     */
    private String drivingNum ;
    /**
     * 车辆类型
     */
    private String carType;

    /**
     * 所有人
     */
    private String owner;

    /**
     * 家庭住址
     */
    private String houseAddress;

    /**
     * 使用性质
     */
    private String carUsetype;

    /**
     * 车辆品牌型号
     */
    private String carVehicle;

    /**
     * 车辆识别代号
     */
    private String carIndetcode;

    /**
     * 发动机号码
     */
    private String carFramenumber;

    /**
     * 注册日期
     */
    private Date registerDate;

    /**
     * 发证日期
     */
    private Date issueDate;

    /**
     * 档案编号
     */
    private String fileNum;

    /**
     * 核定载人数
     */
    private String authorNum;

    /**
     * 总质量
     */
    private String totalMass;

    /**
     * 创建日期
     */
    private Date createTime;

    /**
     * 更新日期
     */
    private Date updateTime;

    /**
     * 行驶证图片
     */
    private String drivingLicense;

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
     * driving_license
     */
    private static final long serialVersionUID = 1L;

    /**
     * 行驶证ID
     * @return id 行驶证ID
     */
    public Long getId() {
        return id;
    }

    /**
     * 行驶证ID
     * @param id 行驶证ID
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 用户ID
     * @return customer_id 用户ID
     */
    public Long getCustomerId() {
        return customerId;
    }

    /**
     * 用户ID
     * @param customerId 用户ID
     */
    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    /**
     * 优先等级
     * @return customer_level 优先等级
     */
    public String getCustomerLevel() {
        return customerLevel;
    }

    /**
     * 优先等级
     * @param customerLevel 优先等级
     */
    public void setCustomerLevel(String customerLevel) {
        this.customerLevel = customerLevel == null ? null : customerLevel.trim();
    }

    /**
     * 车牌号码
     * @return license_num 车牌号码
     */
    public String getLicenseNum() {
        return licenseNum;
    }

    /**
     * 车牌号码
     * @param licenseNum 车牌号码
     */
    public void setLicenseNum(String licenseNum) {
        this.licenseNum = licenseNum == null ? null : licenseNum.trim();
    }

    public String getDrivingNum() {
        return drivingNum;
    }

    public void setDrivingNum(String drivingNum) {
        this.drivingNum = drivingNum;
    }

    /**
     * 车辆类型
     * @return car_type 车辆类型
     */
    public String getCarType() {
        return carType;
    }

    /**
     * 车辆类型
     * @param carType 车辆类型
     */
    public void setCarType(String carType) {
        this.carType = carType == null ? null : carType.trim();
    }

    /**
     * 所有人
     * @return owner 所有人
     */
    public String getOwner() {
        return owner;
    }

    /**
     * 所有人
     * @param owner 所有人
     */
    public void setOwner(String owner) {
        this.owner = owner == null ? null : owner.trim();
    }

    /**
     * 家庭住址
     * @return house_address 家庭住址
     */
    public String getHouseAddress() {
        return houseAddress;
    }

    /**
     * 家庭住址
     * @param houseAddress 家庭住址
     */
    public void setHouseAddress(String houseAddress) {
        this.houseAddress = houseAddress == null ? null : houseAddress.trim();
    }

    /**
     * 使用性质
     * @return car_usetype 使用性质
     */
    public String getCarUsetype() {
        return carUsetype;
    }

    /**
     * 使用性质
     * @param carUsetype 使用性质
     */
    public void setCarUsetype(String carUsetype) {
        this.carUsetype = carUsetype == null ? null : carUsetype.trim();
    }

    /**
     * 车辆品牌型号
     * @return car_vehicle 车辆品牌型号
     */
    public String getCarVehicle() {
        return carVehicle;
    }

    /**
     * 车辆品牌型号
     * @param carVehicle 车辆品牌型号
     */
    public void setCarVehicle(String carVehicle) {
        this.carVehicle = carVehicle == null ? null : carVehicle.trim();
    }

    /**
     * 车辆识别代号
     * @return car_indetcode 车辆识别代号
     */
    public String getCarIndetcode() {
        return carIndetcode;
    }

    /**
     * 车辆识别代号
     * @param carIndetcode 车辆识别代号
     */
    public void setCarIndetcode(String carIndetcode) {
        this.carIndetcode = carIndetcode == null ? null : carIndetcode.trim();
    }

    /**
     * 发动机号码
     * @return car_framenumber 发动机号码
     */
    public String getCarFramenumber() {
        return carFramenumber;
    }

    /**
     * 发动机号码
     * @param carFramenumber 发动机号码
     */
    public void setCarFramenumber(String carFramenumber) {
        this.carFramenumber = carFramenumber == null ? null : carFramenumber.trim();
    }

    /**
     * 注册日期
     * @return register_date 注册日期
     */
    public Date getRegisterDate() {
        return registerDate;
    }

    /**
     * 注册日期
     * @param registerDate 注册日期
     */
    public void setRegisterDate(Date registerDate) {
        this.registerDate = registerDate;
    }

    /**
     * 发证日期
     * @return issue_date 发证日期
     */
    public Date getIssueDate() {
        return issueDate;
    }

    /**
     * 发证日期
     * @param issueDate 发证日期
     */
    public void setIssueDate(Date issueDate) {
        this.issueDate = issueDate;
    }

    /**
     * 档案编号
     * @return file_num 档案编号
     */
    public String getFileNum() {
        return fileNum;
    }

    /**
     * 档案编号
     * @param fileNum 档案编号
     */
    public void setFileNum(String fileNum) {
        this.fileNum = fileNum == null ? null : fileNum.trim();
    }

    /**
     * 核定载人数
     * @return author_num 核定载人数
     */
    public String getAuthorNum() {
        return authorNum;
    }

    /**
     * 核定载人数
     * @param authorNum 核定载人数
     */
    public void setAuthorNum(String authorNum) {
        this.authorNum = authorNum == null ? null : authorNum.trim();
    }

    /**
     * 总质量
     * @return total_mass 总质量
     */
    public String getTotalMass() {
        return totalMass;
    }

    /**
     * 总质量
     * @param totalMass 总质量
     */
    public void setTotalMass(String totalMass) {
        this.totalMass = totalMass == null ? null : totalMass.trim();
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
     * 行驶证图片
     * @return driving_license 行驶证图片
     */
    public String getDrivingLicense() {
        return drivingLicense;
    }

    /**
     * 行驶证图片
     * @param drivingLicense 行驶证图片
     */
    public void setDrivingLicense(String drivingLicense) {
        this.drivingLicense = drivingLicense == null ? null : drivingLicense.trim();
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
}