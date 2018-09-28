package com.kentrasoft.cms.port.entity.exitPoint;

import java.io.Serializable;
import java.util.List;

public class ExitPointEntity implements Serializable{
	
	private static final long serialVersionUID = 6422389186577277208L;
	
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
	 * 出站口数据
	 */
	private List<ExitContent> data;

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

	public List<ExitContent> getData() {
		return data;
	}

	public void setData(List<ExitContent> data) {
		this.data = data;
	}

}
