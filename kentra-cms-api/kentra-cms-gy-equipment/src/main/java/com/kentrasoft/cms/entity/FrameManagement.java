package com.kentrasoft.cms.entity;

import java.io.Serializable;
import java.util.Date;

public class FrameManagement implements Serializable {
    /**
     * 龙门架ID
     */
    private String id;

    /**
     * 龙门架名称
     */
    private String name;

    /**
     * 龙门架编号
     */
    private String frameCode;

    /**
     * 龙门架地址
     */
    private String frameAddress;

    /**
     * 龙门架所处经度
     */
    private String frameGisX;

    /**
     * 龙门架所处纬度
     */
    private String frameGisY;

    /**
     * 设备状态
     */
    private String frameStatus;

    /**
     * 龙门架描述信息
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

    /**
     * frame_management
     */
    private static final long serialVersionUID = 1L;

    /**
     * 龙门架ID
     * @return id 龙门架ID
     */
    public String getId() {
        return id;
    }

    /**
     * 龙门架ID
     * @param id 龙门架ID
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * 龙门架名称
     * @return name 龙门架名称
     */
    public String getName() {
        return name;
    }

    /**
     * 龙门架名称
     * @param name 龙门架名称
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 龙门架编号
     * @return frame_code 龙门架编号
     */
    public String getFrameCode() {
        return frameCode;
    }

    /**
     * 龙门架编号
     * @param frameCode 龙门架编号
     */
    public void setFrameCode(String frameCode) {
        this.frameCode = frameCode == null ? null : frameCode.trim();
    }

    /**
     * 龙门架地址
     * @return frame_address 龙门架地址
     */
    public String getFrameAddress() {
        return frameAddress;
    }

    /**
     * 龙门架地址
     * @param frameAddress 龙门架地址
     */
    public void setFrameAddress(String frameAddress) {
        this.frameAddress = frameAddress == null ? null : frameAddress.trim();
    }

    /**
     * 龙门架所处经度
     * @return frame_gis_x 龙门架所处经度
     */
    public String getFrameGisX() {
        return frameGisX;
    }

    /**
     * 龙门架所处经度
     * @param frameGisX 龙门架所处经度
     */
    public void setFrameGisX(String frameGisX) {
        this.frameGisX = frameGisX == null ? null : frameGisX.trim();
    }

    /**
     * 龙门架所处纬度
     * @return frame_gis_y 龙门架所处纬度
     */
    public String getFrameGisY() {
        return frameGisY;
    }

    /**
     * 龙门架所处纬度
     * @param frameGisY 龙门架所处纬度
     */
    public void setFrameGisY(String frameGisY) {
        this.frameGisY = frameGisY == null ? null : frameGisY.trim();
    }

    /**
     * 设备状态
     * @return frame_status 设备状态
     */
    public String getFrameStatus() {
        return frameStatus;
    }

    /**
     * 设备状态
     * @param frameStatus 设备状态
     */
    public void setFrameStatus(String frameStatus) {
        this.frameStatus = frameStatus == null ? null : frameStatus.trim();
    }

    /**
     * 龙门架描述信息
     * @return descrip_infos 龙门架描述信息
     */
    public String getDescripInfos() {
        return descripInfos;
    }

    /**
     * 龙门架描述信息
     * @param descripInfos 龙门架描述信息
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