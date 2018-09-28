package com.kentrasoft.cms.entity;

import java.io.Serializable;
import java.util.Date;

public class DrivingTrack implements Serializable {
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
     * 设备GISX
     */
    private String deviceGisX;

    /**
     * 设备GISY
     */
    private String deviceGisY;

    /**
     * 通过时间
     */
    private Date throughTime;

    /**
     * 地址
     */
    private String deviceAddress;

    /**
     * 车道编号
     */
    private String laneNum;

    /**
     * 设备编号
     */
    private String equipmentNumber;

    /**
     * 备用字段
     */
    private String extends1;

    /**
     * 备用字段
     */
    private String extends2;

    /**
     * driving_track
     */
    private static final long serialVersionUID = 1L;

    private String num;
    private String address;
    private Date times;
    private String gisX;
    private String gisY;
    
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
     * 设备GISX
     * @return device_gis_x 设备GISX
     */
    public String getDeviceGisX() {
        return deviceGisX;
    }

    /**
     * 设备GISX
     * @param deviceGisX 设备GISX
     */
    public void setDeviceGisX(String deviceGisX) {
        this.deviceGisX = deviceGisX == null ? null : deviceGisX.trim();
    }

    /**
     * 设备GISY
     * @return device_gis_y 设备GISY
     */
    public String getDeviceGisY() {
        return deviceGisY;
    }

    /**
     * 设备GISY
     * @param deviceGisY 设备GISY
     */
    public void setDeviceGisY(String deviceGisY) {
        this.deviceGisY = deviceGisY == null ? null : deviceGisY.trim();
    }

    /**
     * 通过时间
     * @return through_time 通过时间
     */
    public Date getThroughTime() {
        return throughTime;
    }

    /**
     * 通过时间
     * @param throughTime 通过时间
     */
    public void setThroughTime(Date throughTime) {
        this.throughTime = throughTime;
    }

    /**
     * 地址
     * @return device_address 地址
     */
    public String getDeviceAddress() {
        return deviceAddress;
    }

    /**
     * 地址
     * @param deviceAddress 地址
     */
    public void setDeviceAddress(String deviceAddress) {
        this.deviceAddress = deviceAddress == null ? null : deviceAddress.trim();
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
     * 设备编号
     * @return equipment_number 设备编号
     */
    public String getEquipmentNumber() {
        return equipmentNumber;
    }

    /**
     * 设备编号
     * @param equipmentNumber 设备编号
     */
    public void setEquipmentNumber(String equipmentNumber) {
        this.equipmentNumber = equipmentNumber == null ? null : equipmentNumber.trim();
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

	public String getNum() {
		return num;
	}

	public void setNum(String num) {
		this.num = num;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Date getTimes() {
		return times;
	}

	public void setTimes(Date times) {
		this.times = times;
	}

	public String getGisX() {
		return gisX;
	}

	public void setGisX(String gisX) {
		this.gisX = gisX;
	}

	public String getGisY() {
		return gisY;
	}

	public void setGisY(String gisY) {
		this.gisY = gisY;
	}
	
}