package com.kentrasoft.cms.port.entity.exitPoint;

import java.io.Serializable;
import java.util.Date;

public class ExitpointQueryResult implements Serializable{
	
	private static final long serialVersionUID = 8876570341172209279L;
	
	/**
	 * 行驶记录Id 
	 */
	private  String  trackid;
	
	/**
	 * 车牌号
	 */
	private String license;
	
	/**
	 * 通过时间
	 */
	private  Date passtiem; 
	
	/**
	 * 设备经度
	 */
	private String gisx;
	
	/**
	 * 设备纬度
	 */
	private String gisy;
	
	/**
	 * 设备名称
	 */
	private String devicename;
	
	/**
	 * 数据来源和
	 */
	private String datafrom;

	public String getTrackid() {
		return trackid;
	}

	public void setTrackid(String trackid) {
		this.trackid = trackid;
	}

	public String getLicense() {
		return license;
	}

	public void setLicense(String license) {
		this.license = license;
	}

	public Date getPasstiem() {
		return passtiem;
	}

	public void setPasstiem(Date passtiem) {
		this.passtiem = passtiem;
	}

	public String getGisx() {
		return gisx;
	}

	public void setGisx(String gisx) {
		this.gisx = gisx;
	}

	public String getGisy() {
		return gisy;
	}

	public void setGisy(String gisy) {
		this.gisy = gisy;
	}

	public String getDevicename() {
		return devicename;
	}

	public void setDevicename(String devicename) {
		this.devicename = devicename;
	}

	public String getDatafrom() {
		return datafrom;
	}

	public void setDatafrom(String datafrom) {
		this.datafrom = datafrom;
	}
	
	

}
