package com.kentrasoft.cms.entity.dto;

import java.io.Serializable;

/**
 * 描述：行驶记录支付详情
 *
 * @author meeek
 * @date 2018-6-28
 */
public class RecordDetails implements Serializable{
	/**
     * 行驶记录ID
     */
    private String drivingRecord;

    /**
     * 车牌号码
     */
    private String licenseNum;

    /**
     * 坐标X
     */
    private String gisX;

    /**
     * 坐标Y
     */
    private String gisY;

    /**
     * 进站口名称
     */
    private String througTime;

    /**
     * 出站口名称
     */
    private String stationName;

    /**
     * 统计时间
     */
    private String laneNum;

    /**
     * 里程
     */
    private String stationCode;

    /**
     * 设备编号
     */
    private String isEnd;

    /**
     * 出口经度
     */
    private String dataSource;

	public String getDrivingRecord() {
		return drivingRecord;
	}

	public void setDrivingRecord(String drivingRecord) {
		this.drivingRecord = drivingRecord;
	}

	public String getLicenseNum() {
		return licenseNum;
	}

	public void setLicenseNum(String licenseNum) {
		this.licenseNum = licenseNum;
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

	public String getStationName() {
		return stationName;
	}

	public void setStationName(String stationName) {
		this.stationName = stationName;
	}

	public String getLaneNum() {
		return laneNum;
	}

	public void setLaneNum(String laneNum) {
		this.laneNum = laneNum;
	}

	public String getStationCode() {
		return stationCode;
	}

	public void setStationCode(String stationCode) {
		this.stationCode = stationCode;
	}

	public String getIsEnd() {
		return isEnd;
	}

	public void setIsEnd(String isEnd) {
		this.isEnd = isEnd;
	}

	public String getDataSource() {
		return dataSource;
	}

	public void setDataSource(String dataSource) {
		this.dataSource = dataSource;
	}

	public String getThrougTime() {
		return througTime;
	}

	public void setThrougTime(String througTime) {
		this.througTime = througTime;
	}
	
}
