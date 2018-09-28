package com.kentrasoft.cms.port.entity.equipmentStatus;

import java.io.Serializable;
import java.util.List;

public class EqStatusEntity implements Serializable{
	
	private static final long serialVersionUID = 105628787457917947L;
	
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
	 * 监控状态数据
	 */
	private List<EqStatusContent> data;

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

	public List<EqStatusContent> getData() {
		return data;
	}

	public void setData(List<EqStatusContent> data) {
		this.data = data;
	}
	
	

}
