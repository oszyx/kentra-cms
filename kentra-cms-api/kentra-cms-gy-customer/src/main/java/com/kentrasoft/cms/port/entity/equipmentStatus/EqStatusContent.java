package com.kentrasoft.cms.port.entity.equipmentStatus;

import java.util.List;

public class EqStatusContent {
      
	/**
	 * 设备名称
	 */
	private String equipmentName;

	/**
	 * 设备标识
	 */
	private String equipmentCode;

	/**
	 * 网络状态
	 */
	private String netStatus;

	/**
	 * 天线状态
	 */
	private List<EquipStatus> equipmentStatus;

	public String getEquipmentName() {
		return equipmentName;
	}

	public void setEquipmentName(String equipmentName) {
		this.equipmentName = equipmentName;
	}

	public String getEquipmentCode() {
		return equipmentCode;
	}

	public void setEquipmentCode(String equipmentCode) {
		this.equipmentCode = equipmentCode;
	}

	public String getNetStatus() {
		return netStatus;
	}

	public void setNetStatus(String netStatus) {
		this.netStatus = netStatus;
	}

	public List<EquipStatus> getEquipmentStatus() {
		return equipmentStatus;
	}

	public void setEquipmentStatus(List<EquipStatus> equipmentStatus) {
		this.equipmentStatus = equipmentStatus;
	}
	   
}
