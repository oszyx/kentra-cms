/**
 * 5.8G设备数据
 * author:赵参谋
 * date:2018-07-09
 */
package com.kentrasoft.cms.port.entity.equipmentData;

public class EquipmentContent {
    
	/**
	 * 车牌号
	 */
	private String  license;
	
	/**
	 * 设备名称
	 */
	private String equipmentName;
	
	/**
	 * 通过设备时间
	 */
	private String equipmentTime;
	
	/**
	 * 设备经度
	 */
	private String equipmentGisX;
	
	/**
	 * 设备纬度
	 */
	private String equipmentGisY;
	
	/**
	 * 设备标识
	 */
	private String equipmentCode;

	public String getLicense() {
		return license;
	}

	public void setLicense(String license) {
		this.license = license;
	}

	public String getEquipmentName() {
		return equipmentName;
	}

	public void setEquipmentName(String equipmentName) {
		this.equipmentName = equipmentName;
	}

	public String getEquipmentTime() {
		return equipmentTime;
	}

	public void setEquipmentTime(String equipmentTime) {
		this.equipmentTime = equipmentTime;
	}

	public String getEquipmentGisX() {
		return equipmentGisX;
	}

	public void setEquipmentGisX(String equipmentGisX) {
		this.equipmentGisX = equipmentGisX;
	}

	public String getEquipmentGisY() {
		return equipmentGisY;
	}

	public void setEquipmentGisY(String equipmentGisY) {
		this.equipmentGisY = equipmentGisY;
	}

	public String getEquipmentCode() {
		return equipmentCode;
	}

	public void setEquipmentCode(String equipmentCode) {
		this.equipmentCode = equipmentCode;
	}
	
	
}
