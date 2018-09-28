package com.kentrasoft.cms.entity;

import java.io.Serializable;
import java.util.Date;

public class LedManagement implements Serializable {
    /**
     * 主键id(UUID:LEDxxxx)
     */
    private String id;

    /**
     * LED名称
     */
    private String name;

    /**
     * LED编号
     */
    private String ledCode;

    /**
     * LED地址
     */
    private String ledAddress;

    /**
     * LED所处经度
     */
    private String ledGisX;

    /**
     * LED所处纬度
     */
    private String ledGisY;

    /**
     * 设备状态（01:未启动，02：正常，03：故障，04：维修中）
     */
    private String ledStatus;

    /**
     * 描述
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
     * 预留字段1
     */
    private String extends1;

    /**
     * 预留字段2
     */
    private String extends2;

    /**
     * 预留字段3
     */
    private String extends3;

    /**
     * led_management
     */
    private static final long serialVersionUID = 1L;

    /**
     * 主键id(UUID:LEDxxxx)
     * @return id 主键id(UUID:LEDxxxx)
     */
    public String getId() {
        return id;
    }

    /**
     * 主键id(UUID:LEDxxxx)
     * @param id 主键id(UUID:LEDxxxx)
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * LED名称
     * @return name LED名称
     */
    public String getName() {
        return name;
    }

    /**
     * LED名称
     * @param name LED名称
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * LED编号
     * @return LED_code LED编号
     */
    public String getLedCode() {
        return ledCode;
    }

    /**
     * LED编号
     * @param ledCode LED编号
     */
    public void setLedCode(String ledCode) {
        this.ledCode = ledCode == null ? null : ledCode.trim();
    }

    /**
     * LED地址
     * @return LED_address LED地址
     */
    public String getLedAddress() {
        return ledAddress;
    }

    /**
     * LED地址
     * @param ledAddress LED地址
     */
    public void setLedAddress(String ledAddress) {
        this.ledAddress = ledAddress == null ? null : ledAddress.trim();
    }

    /**
     * LED所处经度
     * @return LED_gis_x LED所处经度
     */
    public String getLedGisX() {
        return ledGisX;
    }

    /**
     * LED所处经度
     * @param ledGisX LED所处经度
     */
    public void setLedGisX(String ledGisX) {
        this.ledGisX = ledGisX == null ? null : ledGisX.trim();
    }

    /**
     * LED所处纬度
     * @return LED_gis_y LED所处纬度
     */
    public String getLedGisY() {
        return ledGisY;
    }

    /**
     * LED所处纬度
     * @param ledGisY LED所处纬度
     */
    public void setLedGisY(String ledGisY) {
        this.ledGisY = ledGisY == null ? null : ledGisY.trim();
    }

    /**
     * 设备状态（01:未启动，02：正常，03：故障，04：维修中）
     * @return LED_status 设备状态（01:未启动，02：正常，03：故障，04：维修中）
     */
    public String getLedStatus() {
        return ledStatus;
    }

    /**
     * 设备状态（01:未启动，02：正常，03：故障，04：维修中）
     * @param ledStatus 设备状态（01:未启动，02：正常，03：故障，04：维修中）
     */
    public void setLedStatus(String ledStatus) {
        this.ledStatus = ledStatus == null ? null : ledStatus.trim();
    }

    /**
     * 描述
     * @return descrip_infos 描述
     */
    public String getDescripInfos() {
        return descripInfos;
    }

    /**
     * 描述
     * @param descripInfos 描述
     */
    public void setDescripInfos(String descripInfos) {
        this.descripInfos = descripInfos == null ? null : descripInfos.trim();
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
     * 预留字段1
     * @return extends1 预留字段1
     */
    public String getExtends1() {
        return extends1;
    }

    /**
     * 预留字段1
     * @param extends1 预留字段1
     */
    public void setExtends1(String extends1) {
        this.extends1 = extends1 == null ? null : extends1.trim();
    }

    /**
     * 预留字段2
     * @return extends2 预留字段2
     */
    public String getExtends2() {
        return extends2;
    }

    /**
     * 预留字段2
     * @param extends2 预留字段2
     */
    public void setExtends2(String extends2) {
        this.extends2 = extends2 == null ? null : extends2.trim();
    }

    /**
     * 预留字段3
     * @return extends3 预留字段3
     */
    public String getExtends3() {
        return extends3;
    }

    /**
     * 预留字段3
     * @param extends3 预留字段3
     */
    public void setExtends3(String extends3) {
        this.extends3 = extends3 == null ? null : extends3.trim();
    }
}