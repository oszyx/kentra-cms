package com.kentrasoft.cms.entity;

import java.io.Serializable;
import java.util.Date;

public class BreakRecord implements Serializable {
    /**
     * 主键
     */
    private Integer id;

    /**
     * 行驶记录ID
     */
    private String drivingRecord;

    /**
     * 车牌号码
     */
    private String licenseNum;

    /**
     * 行驶时间起
     */
    private Date entranceTime;

    /**
     * 行驶时间止
     */
    private Date exitTime;

    /**
     * 行驶段起名称
     */
    private String entranceName;

    /**
     * 行驶段止名称
     */
    private String exitName;

    /**
     * 罚款金额
     */
    private String payMoney;

    /**
     * 违规类型(数据字典)
     */
    private String remakeType;

    /**
     * 违规备注
     */
    private String remakeContent;

    /**
     * 审核状态（01：审核中 02：审核通过 03：审核不通过）
     */
    private String auditStatus;

    /**
     * 创建日期
     */
    private Date createTime;

    /**
     * 更新日期
     */
    private Date updateTime;

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
     * break_record
     */
    private static final long serialVersionUID = 1L;

    /**
     * 主键
     * @return id 主键
     */
    public Integer getId() {
        return id;
    }

    /**
     * 主键
     * @param id 主键
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 行驶记录ID
     * @return driving_record 行驶记录ID
     */
    public String getDrivingRecord() {
        return drivingRecord;
    }

    /**
     * 行驶记录ID
     * @param drivingRecord 行驶记录ID
     */
    public void setDrivingRecord(String drivingRecord) {
        this.drivingRecord = drivingRecord == null ? null : drivingRecord.trim();
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

    /**
     * 行驶时间起
     * @return entrance_time 行驶时间起
     */
    public Date getEntranceTime() {
        return entranceTime;
    }

    /**
     * 行驶时间起
     * @param entranceTime 行驶时间起
     */
    public void setEntranceTime(Date entranceTime) {
        this.entranceTime = entranceTime;
    }

    /**
     * 行驶时间止
     * @return exit_time 行驶时间止
     */
    public Date getExitTime() {
        return exitTime;
    }

    /**
     * 行驶时间止
     * @param exitTime 行驶时间止
     */
    public void setExitTime(Date exitTime) {
        this.exitTime = exitTime;
    }

    /**
     * 行驶段起名称
     * @return entrance_name 行驶段起名称
     */
    public String getEntranceName() {
        return entranceName;
    }

    /**
     * 行驶段起名称
     * @param entranceName 行驶段起名称
     */
    public void setEntranceName(String entranceName) {
        this.entranceName = entranceName == null ? null : entranceName.trim();
    }

    /**
     * 行驶段止名称
     * @return exit_name 行驶段止名称
     */
    public String getExitName() {
        return exitName;
    }

    /**
     * 行驶段止名称
     * @param exitName 行驶段止名称
     */
    public void setExitName(String exitName) {
        this.exitName = exitName == null ? null : exitName.trim();
    }

    /**
     * 罚款金额
     * @return pay_money 罚款金额
     */
    public String getPayMoney() {
        return payMoney;
    }

    /**
     * 罚款金额
     * @param payMoney 罚款金额
     */
    public void setPayMoney(String payMoney) {
        this.payMoney = payMoney == null ? null : payMoney.trim();
    }

    /**
     * 违规类型
     * @return remake_type 违规类型
     */
    public String getRemakeType() {
        return remakeType;
    }

    /**
     * 违规类型
     * @param remakeType 违规类型
     */
    public void setRemakeType(String remakeType) {
        this.remakeType = remakeType == null ? null : remakeType.trim();
    }

    /**
     * 违规备注
     * @return remake_content 违规备注
     */
    public String getRemakeContent() {
        return remakeContent;
    }

    /**
     * 违规备注
     * @param remakeContent 违规备注
     */
    public void setRemakeContent(String remakeContent) {
        this.remakeContent = remakeContent == null ? null : remakeContent.trim();
    }

    /**
     * 审核状态（01：审核中 02：审核通过 03：审核不通过）
     * @return audit_status 审核状态（01：审核中 02：审核通过 03：审核不通过）
     */
    public String getAuditStatus() {
        return auditStatus;
    }

    /**
     * 审核状态（01：审核中 02：审核通过 03：审核不通过）
     * @param auditStatus 审核状态（01：审核中 02：审核通过 03：审核不通过）
     */
    public void setAuditStatus(String auditStatus) {
        this.auditStatus = auditStatus == null ? null : auditStatus.trim();
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