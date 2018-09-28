package com.kentrasoft.cms.entity;

import java.io.Serializable;
import java.util.Date;

public class CardPortData implements Serializable {
    /**
     * 主键
     */
    private Long id;

    /**
     * 车道编号
     */
    private String laneNum;

    /**
     * 行驶记录id
     */
    private String drivingRecord;

    /**
     * 车牌号
     */
    private String licenseNum;

    /**
     * 通过时间
     */
    private Date passTime;

    /**
     * 站点名称
     */
    private String stationName;

    /**
     * 卡口数据图片路径
     */
    private String imgUrl;

    /**
     * 状态
     */
    private String status;
    
    /**
     * 卡口经度
     */
    private String pointGisX;
    
    /**
     * 卡口纬度
     */
    private String pointGisY;
    
    /**
     * 卡口标识
     */
    private String pointCode;
    
    /**
     * 备用字段1
     */
    private String extends1;
    
    /**
     * 备用字段2
     */
    private String extends2;
    
    /**
     * 备用字段2
     */
    private String extends3;
    
    /**
     * card_port_data
     */
    private static final long serialVersionUID = 1L;

    /**
     * 主键
     * @return id 主键
     */
    public Long getId() {
        return id;
    }

    /**
     * 主键
     * @param id 主键
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 车道编号
     * @return lane_num 车道编号
     */
    public String getLaneNum() {
        return laneNum;
    }

    /**
     * 车道编号
     * @param laneNum 车道编号
     */
    public void setLaneNum(String laneNum) {
        this.laneNum = laneNum == null ? null : laneNum.trim();
    }

    /**
     * 行驶记录id
     * @return driving_record 行驶记录id
     */
    public String getDrivingRecord() {
        return drivingRecord;
    }

    /**
     * 行驶记录id
     * @param drivingRecord 行驶记录id
     */
    public void setDrivingRecord(String drivingRecord) {
        this.drivingRecord = drivingRecord == null ? null : drivingRecord.trim();
    }

    /**
     * 车牌号
     * @return license_num 车牌号
     */
    public String getLicenseNum() {
        return licenseNum;
    }

    /**
     * 车牌号
     * @param licenseNum 车牌号
     */
    public void setLicenseNum(String licenseNum) {
        this.licenseNum = licenseNum == null ? null : licenseNum.trim();
    }

    /**
     * 通过时间
     * @return pass_time 通过时间
     */
    public Date getPassTime() {
        return passTime;
    }

    /**
     * 通过时间
     * @param passTime 通过时间
     */
    public void setPassTime(Date passTime) {
        this.passTime = passTime;
    }

    /**
     * 站点名称
     * @return station_name 站点名称
     */
    public String getStationName() {
        return stationName;
    }

    /**
     * 站点名称
     * @param stationName 站点名称
     */
    public void setStationName(String stationName) {
        this.stationName = stationName == null ? null : stationName.trim();
    }

    /**
     * 卡口数据图片路径
     * @return img_url 卡口数据图片路径
     */
    public String getImgUrl() {
        return imgUrl;
    }

    /**
     * 卡口数据图片路径
     * @param imgUrl 卡口数据图片路径
     */
    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl == null ? null : imgUrl.trim();
    }

    /**
     * 状态
     * @return status 状态
     */
    public String getStatus() {
        return status;
    }

    /**
     * 状态
     * @param status 状态
     */
    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

	public String getPointGisX() {
		return pointGisX;
	}

	public void setPointGisX(String pointGisX) {
		this.pointGisX = pointGisX;
	}

	public String getPointGisY() {
		return pointGisY;
	}

	public void setPointGisY(String pointGisY) {
		this.pointGisY = pointGisY;
	}

	public String getPointCode() {
		return pointCode;
	}

	public void setPointCode(String pointCode) {
		this.pointCode = pointCode;
	}

	public String getExtends1() {
		return extends1;
	}

	public void setExtends1(String extends1) {
		this.extends1 = extends1;
	}

	public String getExtends2() {
		return extends2;
	}

	public void setExtends2(String extends2) {
		this.extends2 = extends2;
	}

	public String getExtends3() {
		return extends3;
	}

	public void setExtends3(String extends3) {
		this.extends3 = extends3;
	}
    
}