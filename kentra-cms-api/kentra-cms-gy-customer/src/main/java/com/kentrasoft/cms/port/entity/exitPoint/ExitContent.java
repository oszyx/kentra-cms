package com.kentrasoft.cms.port.entity.exitPoint;


public class ExitContent{
	/**
	 * 车牌号
	 */
	private String license;
	
	/**
	 * 出站口名称
	 */
	private String exitName;
	
	/**
	 * 出站口通过时间
	 */
	private Long exitTime;
	
	/**
	 * 出站口经度
	 */
	private String exitGisX;
	
	/**
	 * 出站口纬度
	 */
	private String exitGisY;
	
	/**
	 * 出站口标识
	 */
	private String exitCode;
	
	/**
	 * 出站口车道标识
	 */
	private String exitPointCode;

	public String getLicense() {
		return license;
	}

	public void setLicense(String license) {
		this.license = license;
	}

	public String getExitName() {
		return exitName;
	}

	public void setExitName(String exitName) {
		this.exitName = exitName;
	}

	public Long getExitTime() {
		return exitTime;
	}

	public void setExitTime(Long exitTime) {
		this.exitTime = exitTime;
	}

	public String getExitGisX() {
		return exitGisX;
	}

	public void setExitGisX(String exitGisX) {
		this.exitGisX = exitGisX;
	}

	public String getExitGisY() {
		return exitGisY;
	}

	public void setExitGisY(String exitGisY) {
		this.exitGisY = exitGisY;
	}

	public String getExitCode() {
		return exitCode;
	}

	public void setExitCode(String exitCode) {
		this.exitCode = exitCode;
	}

	public String getExitPointCode() {
		return exitPointCode;
	}

	public void setExitPointCode(String exitPointCode) {
		this.exitPointCode = exitPointCode;
	}
	
	

}
