package com.kentrasoft.cms.entity;

import java.io.Serializable;
import java.util.Date;

public class ControllerManagement implements Serializable {
    /**
     * 控制器设备ID(UUID:controllerxxxxx)
     */
    private String id;

    /**
     * 控制器设备名称
     */
    private String name;

    /**
     * 控制器设备编号
     */
    private String controllerCode;

    /**
     * 控制器设备地址
     */
    private String controllerAddress;

    /**
     * 控制器设备所处经度
     */
    private String controllerGisX;

    /**
     * 控制器所处纬度
     */
    private String controllerGisY;

    /**
     * 设备状态（01:未启用，02：正常，03：故障，04：维修中）
     */
    private String controllerStatus;

    /**
     * 控制器描述信息
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
     * 备用字段
     */
    private String extends1;

    /**
     * 备用字段
     */
    private String extends2;

    /**
     * 备用字段
     */
    private String extends3;

    /**
     * controller_management
     */
    private static final long serialVersionUID = 1L;

    /**
     * 控制器设备ID(UUID:controllerxxxxx)
     * @return id 控制器设备ID(UUID:controllerxxxxx)
     */
    public String getId() {
        return id;
    }

    /**
     * 控制器设备ID(UUID:controllerxxxxx)
     * @param id 控制器设备ID(UUID:controllerxxxxx)
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * 控制器设备名称
     * @return name 控制器设备名称
     */
    public String getName() {
        return name;
    }

    /**
     * 控制器设备名称
     * @param name 控制器设备名称
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 控制器设备编号
     * @return controller_code 控制器设备编号
     */
    public String getControllerCode() {
        return controllerCode;
    }

    /**
     * 控制器设备编号
     * @param controllerCode 控制器设备编号
     */
    public void setControllerCode(String controllerCode) {
        this.controllerCode = controllerCode == null ? null : controllerCode.trim();
    }

    /**
     * 控制器设备地址
     * @return controller_address 控制器设备地址
     */
    public String getControllerAddress() {
        return controllerAddress;
    }

    /**
     * 控制器设备地址
     * @param controllerAddress 控制器设备地址
     */
    public void setControllerAddress(String controllerAddress) {
        this.controllerAddress = controllerAddress == null ? null : controllerAddress.trim();
    }

    /**
     * 控制器设备所处经度
     * @return controller_gis_x 控制器设备所处经度
     */
    public String getControllerGisX() {
        return controllerGisX;
    }

    /**
     * 控制器设备所处经度
     * @param controllerGisX 控制器设备所处经度
     */
    public void setControllerGisX(String controllerGisX) {
        this.controllerGisX = controllerGisX == null ? null : controllerGisX.trim();
    }

    /**
     * 控制器所处纬度
     * @return controller_gis_y 控制器所处纬度
     */
    public String getControllerGisY() {
        return controllerGisY;
    }

    /**
     * 控制器所处纬度
     * @param controllerGisY 控制器所处纬度
     */
    public void setControllerGisY(String controllerGisY) {
        this.controllerGisY = controllerGisY == null ? null : controllerGisY.trim();
    }

    /**
     * 设备状态（01:未启用，02：正常，03：故障，04：维修中）
     * @return controller_status 设备状态（01:未启用，02：正常，03：故障，04：维修中）
     */
    public String getControllerStatus() {
        return controllerStatus;
    }

    /**
     * 设备状态（01:未启用，02：正常，03：故障，04：维修中）
     * @param controllerStatus 设备状态（01:未启用，02：正常，03：故障，04：维修中）
     */
    public void setControllerStatus(String controllerStatus) {
        this.controllerStatus = controllerStatus == null ? null : controllerStatus.trim();
    }

    /**
     * 控制器描述信息
     * @return descrip_infos 控制器描述信息
     */
    public String getDescripInfos() {
        return descripInfos;
    }

    /**
     * 控制器描述信息
     * @param descripInfos 控制器描述信息
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
     * 备用字段
     * @return extends1 备用字段
     */
    public String getExtends1() {
        return extends1;
    }

    /**
     * 备用字段
     * @param extends1 备用字段
     */
    public void setExtends1(String extends1) {
        this.extends1 = extends1 == null ? null : extends1.trim();
    }

    /**
     * 备用字段
     * @return extends2 备用字段
     */
    public String getExtends2() {
        return extends2;
    }

    /**
     * 备用字段
     * @param extends2 备用字段
     */
    public void setExtends2(String extends2) {
        this.extends2 = extends2 == null ? null : extends2.trim();
    }

    /**
     * 备用字段
     * @return extends3 备用字段
     */
    public String getExtends3() {
        return extends3;
    }

    /**
     * 备用字段
     * @param extends3 备用字段
     */
    public void setExtends3(String extends3) {
        this.extends3 = extends3 == null ? null : extends3.trim();
    }
}