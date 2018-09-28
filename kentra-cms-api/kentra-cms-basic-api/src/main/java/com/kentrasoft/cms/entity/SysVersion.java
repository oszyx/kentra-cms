package com.kentrasoft.cms.entity;

import java.io.Serializable;
import java.util.Date;

public class SysVersion implements Serializable {

    private Integer id;
    /**
     * 版本号
     */
    private String vId;
    /**
     * 版本名称
     */
    private String vName;
    /**
     * 版本下载地址
     */
    private String vDownloadUrl;
    /**
     * 版本状态 是否可用 0 不可用  1可用
     */
    private String vState;
    /**
     * 是否强制更新 0 不强制  1强制
     */
    private String vForcedUpdate;
    /**
     * 发布时间
     */
    private Date vReleaseTime;
    /**
     * 创建时间
     */
    private Date vCreateTime;
    /**
     * 预留字段
     */
    private String vExtends;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getvId() {
        return vId;
    }

    public void setvId(String vId) {
        this.vId = vId;
    }

    public String getvName() {
        return vName;
    }

    public void setvName(String vName) {
        this.vName = vName;
    }

    public String getvDownloadUrl() {
        return vDownloadUrl;
    }

    public void setvDownloadUrl(String vDownloadUrl) {
        this.vDownloadUrl = vDownloadUrl;
    }

    public String getvState() {
        return vState;
    }

    public void setvState(String vState) {
        this.vState = vState;
    }

    public String getvForcedUpdate() {
        return vForcedUpdate;
    }

    public void setvForcedUpdate(String vForcedUpdate) {
        this.vForcedUpdate = vForcedUpdate;
    }

    public Date getvReleaseTime() {
        return vReleaseTime;
    }

    public void setvReleaseTime(Date vReleaseTime) {
        this.vReleaseTime = vReleaseTime;
    }

    public Date getvCreateTime() {
        return vCreateTime;
    }

    public void setvCreateTime(Date vCreateTime) {
        this.vCreateTime = vCreateTime;
    }

    public String getvExtends() {
        return vExtends;
    }

    public void setvExtends(String vExtends) {
        this.vExtends = vExtends;
    }

    @Override
    public String toString() {
        return "SysVersion{" +
                "id=" + id +
                ", vId='" + vId + '\'' +
                ", vName='" + vName + '\'' +
                ", vDownloadUrl='" + vDownloadUrl + '\'' +
                ", vState=" + vState +
                ", vForcedUpdate=" + vForcedUpdate +
                ", vReleaseTime=" + vReleaseTime +
                ", vCreateTime=" + vCreateTime +
                ", vExtends='" + vExtends + '\'' +
                '}';
    }
}