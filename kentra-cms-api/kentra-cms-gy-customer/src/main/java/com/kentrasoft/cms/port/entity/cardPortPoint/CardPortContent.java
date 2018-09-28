package com.kentrasoft.cms.port.entity.cardPortPoint;

public class CardPortContent {

	/**
	 * 车牌号
	 */
	String license;
	
	/**
	 * 卡口名称
	 */
	String pointName;
	
	/**
	 * 卡口通过时间
	 */
	Long pointTime;
	
	/**
	 * 卡口经度
	 */
	String pointGisX;
	
	/**
	 * 卡口纬度
	 */
	String pointGisY;
	
	/**
	 * 卡口标识
	 */
	String pointCode;
	
	/**
	 * 图片标识
	 */
   String imageCode;

	public String getLicense() {
		return license;
	}

	public void setLicense(String license) {
		this.license = license;
	}

	public String getPointName() {
		return pointName;
	}

	public void setPointName(String pointName) {
		this.pointName = pointName;
	}

	public Long getPointTime() {
		return pointTime;
	}

	public void setPointTime(Long pointTime) {
		this.pointTime = pointTime;
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

	public String getImageCode() {
		return imageCode;
	}

	public void setImageCode(String imageCode) {
		this.imageCode = imageCode;
	}
}
