package com.kentrasoft.cms.entity;

import java.io.Serializable;
import java.util.Date;

public class RepairRecord implements Serializable {
    /**
     * 维修记录ID
     */
    private Long id;

    /**
     * 维修设备ID
     */
    private String repairDeviceId;

    /**
     * 维修设备名称
     */
    private String repairDeviceName;

    /**
     * 维修人员联系电话
     */
    private String repairUserPhone;

    /**
     * 维修人员姓名
     */
    private String repairUserName;

    /**
     * 维修时间起
     */
    private Date repairDateStar;

    /**
     * 维修时间止
     */
    private Date repairDateEnd;

    /**
     * 维修状态(01:未开始，02：维修进行中，03：维修完成)
     */
    private String repairStatus;

    /**
     * 维修事故通知说明
     */
    private String repairNotice;

    /**
     * 维修事故原因说明，过程阐述
     */
    private String repairReason;

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
     * repair_record
     */
    private static final long serialVersionUID = 1L;

    /**
     * 维修记录ID
     * @return id 维修记录ID
     */
    public Long getId() {
        return id;
    }

    /**
     * 维修记录ID
     * @param id 维修记录ID
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 维修设备ID
     * @return repair_device_id 维修设备ID
     */
    public String getRepairDeviceId() {
        return repairDeviceId;
    }

    /**
     * 维修设备ID
     * @param repairDeviceId 维修设备ID
     */
    public void setRepairDeviceId(String repairDeviceId) {
        this.repairDeviceId = repairDeviceId == null ? null : repairDeviceId.trim();
    }

    /**
     * 维修设备名称
     * @return repair_device_name 维修设备名称
     */
    public String getRepairDeviceName() {
        return repairDeviceName;
    }

    /**
     * 维修设备名称
     * @param repairDeviceName 维修设备名称
     */
    public void setRepairDeviceName(String repairDeviceName) {
        this.repairDeviceName = repairDeviceName == null ? null : repairDeviceName.trim();
    }

    /**
     * 维修人员联系电话
     * @return repair_user_phone 维修人员联系电话
     */
    public String getRepairUserPhone() {
        return repairUserPhone;
    }

    /**
     * 维修人员联系电话
     * @param repairUserPhone 维修人员联系电话
     */
    public void setRepairUserPhone(String repairUserPhone) {
        this.repairUserPhone = repairUserPhone == null ? null : repairUserPhone.trim();
    }

    /**
     * 维修人员姓名
     * @return repair_user_name 维修人员姓名
     */
    public String getRepairUserName() {
        return repairUserName;
    }

    /**
     * 维修人员姓名
     * @param repairUserName 维修人员姓名
     */
    public void setRepairUserName(String repairUserName) {
        this.repairUserName = repairUserName == null ? null : repairUserName.trim();
    }

    /**
     * 维修时间起
     * @return repair_date_star 维修时间起
     */
    public Date getRepairDateStar() {
        return repairDateStar;
    }

    /**
     * 维修时间起
     * @param repairDateStar 维修时间起
     */
    public void setRepairDateStar(Date repairDateStar) {
        this.repairDateStar = repairDateStar;
    }

    /**
     * 维修时间止
     * @return repair_date_end 维修时间止
     */
    public Date getRepairDateEnd() {
        return repairDateEnd;
    }

    /**
     * 维修时间止
     * @param repairDateEnd 维修时间止
     */
    public void setRepairDateEnd(Date repairDateEnd) {
        this.repairDateEnd = repairDateEnd;
    }

    /**
     * 维修状态(01:未开始，02：维修进行中，03：维修完成)
     * @return repair_status 维修状态(01:未开始，02：维修进行中，03：维修完成)
     */
    public String getRepairStatus() {
        return repairStatus;
    }

    /**
     * 维修状态(01:未开始，02：维修进行中，03：维修完成)
     * @param repairStatus 维修状态(01:未开始，02：维修进行中，03：维修完成)
     */
    public void setRepairStatus(String repairStatus) {
        this.repairStatus = repairStatus == null ? null : repairStatus.trim();
    }

    /**
     * 维修事故通知说明
     * @return repair_notice 维修事故通知说明
     */
    public String getRepairNotice() {
        return repairNotice;
    }

    /**
     * 维修事故通知说明
     * @param repairNotice 维修事故通知说明
     */
    public void setRepairNotice(String repairNotice) {
        this.repairNotice = repairNotice == null ? null : repairNotice.trim();
    }

    /**
     * 维修事故原因说明，过程阐述
     * @return repair_reason 维修事故原因说明，过程阐述
     */
    public String getRepairReason() {
        return repairReason;
    }

    /**
     * 维修事故原因说明，过程阐述
     * @param repairReason 维修事故原因说明，过程阐述
     */
    public void setRepairReason(String repairReason) {
        this.repairReason = repairReason == null ? null : repairReason.trim();
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