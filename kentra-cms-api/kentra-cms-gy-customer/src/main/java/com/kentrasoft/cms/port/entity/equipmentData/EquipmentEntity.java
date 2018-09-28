package com.kentrasoft.cms.port.entity.equipmentData;

import java.io.Serializable;


public class EquipmentEntity implements Serializable{

	private static final long serialVersionUID = 2710845402403613591L;
	
	/**
	 * 队列名称
	 */
	private String topic;
	
	/**
	 * 数据来源
	 */
	private String from;
	
	/**
	 * 数据发送时间
	 */
	private Long timestamp;
	
	/**
	 * 5.8G采集数据
	 */
	private EquipmentContent data;

	public String getTopic() {
		return topic;
	}

	public void setTopic(String topic) {
		this.topic = topic;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public Long getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Long timestamp) {
		this.timestamp = timestamp;
	}

	public EquipmentContent getData() {
		return data;
	}

	public void setData(EquipmentContent data) {
		this.data = data;
	}
	

}
