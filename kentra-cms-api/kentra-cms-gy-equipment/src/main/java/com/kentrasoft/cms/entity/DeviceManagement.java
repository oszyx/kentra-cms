package com.kentrasoft.cms.entity;

import java.io.Serializable;
import java.util.Date;

public class DeviceManagement implements Serializable {
    /**
     * 设备ID
     */
    private String id;

    /**
     * 设备名称
     */
    private String name;

    /**
     * 设备编号
     */
    private String deviceCode;

    /**
     * 设备地址
     */
    private String deviceAddress;

    /**
     * 设备所处经度
     */
    private String deviceGisX;

    /**
     * 设备所处纬度
     */
    private String deviceGisY;

    /**
     * 所属设备管理
     */
    private String belongEqipment;

    /**
     * 设备状态
     */
    private String deviceStatus;

    /**
     * 设备描述信息
     */
    private String descripInfos;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
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

    private Integer countNum;

    /**
     * device_management
     */
    private static final long serialVersionUID = 1L;

    /**
     * 设备ID
     *
     * @return id 设备ID
     */
    public String getId() {
        return id;
    }

    /**
     * 设备ID
     *
     * @param id 设备ID
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * 设备名称
     *
     * @return name 设备名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设备名称
     *
     * @param name 设备名称
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 设备编号
     *
     * @return device_code 设备编号
     */
    public String getDeviceCode() {
        return deviceCode;
    }

    /**
     * 设备编号
     *
     * @param deviceCode 设备编号
     */
    public void setDeviceCode(String deviceCode) {
        this.deviceCode = deviceCode == null ? null : deviceCode.trim();
    }

    /**
     * 设备地址
     *
     * @return device_address 设备地址
     */
    public String getDeviceAddress() {
        return deviceAddress;
    }

    /**
     * 设备地址
     *
     * @param deviceAddress 设备地址
     */
    public void setDeviceAddress(String deviceAddress) {
        this.deviceAddress = deviceAddress == null ? null : deviceAddress.trim();
    }

    /**
     * 设备所处经度
     *
     * @return device_gis_x 设备所处经度
     */
    public String getDeviceGisX() {
        return deviceGisX;
    }

    /**
     * 设备所处经度
     *
     * @param deviceGisX 设备所处经度
     */
    public void setDeviceGisX(String deviceGisX) {
        this.deviceGisX = deviceGisX == null ? null : deviceGisX.trim();
    }

    /**
     * 设备所处纬度
     *
     * @return device_gis_y 设备所处纬度
     */
    public String getDeviceGisY() {
        return deviceGisY;
    }

    /**
     * 设备所处纬度
     *
     * @param deviceGisY 设备所处纬度
     */
    public void setDeviceGisY(String deviceGisY) {
        this.deviceGisY = deviceGisY == null ? null : deviceGisY.trim();
    }

    /**
     * 所属设备管理
     *
     * @return belong_eqipment 所属设备管理
     */
    public String getBelongEqipment() {
        return belongEqipment;
    }

    /**
     * 所属设备管理
     *
     * @param belongEqipment 所属设备管理
     */
    public void setBelongEqipment(String belongEqipment) {
        this.belongEqipment = belongEqipment == null ? null : belongEqipment.trim();
    }

    /**
     * 设备状态
     *
     * @return device_status 设备状态
     */
    public String getDeviceStatus() {
        return deviceStatus;
    }

    /**
     * 设备状态
     *
     * @param deviceStatus 设备状态
     */
    public void setDeviceStatus(String deviceStatus) {
        this.deviceStatus = deviceStatus == null ? null : deviceStatus.trim();
    }

    /**
     * 设备描述信息
     *
     * @return descrip_infos 设备描述信息
     */
    public String getDescripInfos() {
        return descripInfos;
    }

    /**
     * 设备描述信息
     *
     * @param descripInfos 设备描述信息
     */
    public void setDescripInfos(String descripInfos) {
        this.descripInfos = descripInfos == null ? null : descripInfos.trim();
    }

    /**
     * 创建时间
     *
     * @return create_time 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 创建时间
     *
     * @param createTime 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 更新时间
     *
     * @return update_time 更新时间
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 更新时间
     *
     * @param updateTime 更新时间
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * 备用字段1
     *
     * @return extends1 备用字段1
     */
    public String getExtends1() {
        return extends1;
    }

    /**
     * 备用字段1
     *
     * @param extends1 备用字段1
     */
    public void setExtends1(String extends1) {
        this.extends1 = extends1 == null ? null : extends1.trim();
    }

    /**
     * 备用字段2
     *
     * @return extends2 备用字段2
     */
    public String getExtends2() {
        return extends2;
    }

    /**
     * 备用字段2
     *
     * @param extends2 备用字段2
     */
    public void setExtends2(String extends2) {
        this.extends2 = extends2 == null ? null : extends2.trim();
    }

    /**
     * 备用字段3
     *
     * @return extends3 备用字段3
     */
    public String getExtends3() {
        return extends3;
    }

    /**
     * 备用字段3
     *
     * @param extends3 备用字段3
     */
    public void setExtends3(String extends3) {
        this.extends3 = extends3 == null ? null : extends3.trim();
    }

    public Integer getCountNum() {
        return countNum;
    }

    public void setCountNum(Integer countNum) {
        this.countNum = countNum;
    }
}