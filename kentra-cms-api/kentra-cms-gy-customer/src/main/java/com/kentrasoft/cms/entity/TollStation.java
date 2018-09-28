package com.kentrasoft.cms.entity;

public class TollStation {
    /**
     * 主键
     */
	private int id;
	/**
	 * 收费站编码（车道）
	 */
	private String tollStationCode;
	/**
	 * 收费站名称
	 */
	private String tollStationName;
	/**
	 * 站口经度
	 */
	private String longitude;
	/**
	 * 站口纬度
	 */
	private String latitude;
	/**
	 * 状态（01：启用 02：禁用）
	 */
	private String status;
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
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTollStationCode() {
		return tollStationCode;
	}
	public void setTollStationCode(String tollStationCode) {
		this.tollStationCode = tollStationCode;
	}
	public String getTollStationName() {
		return tollStationName;
	}
	public void setTollStationName(String tollStationName) {
		this.tollStationName = tollStationName;
	}
	public String getLongitude() {
		return longitude;
	}
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	public String getLatitude() {
		return latitude;
	}
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
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
