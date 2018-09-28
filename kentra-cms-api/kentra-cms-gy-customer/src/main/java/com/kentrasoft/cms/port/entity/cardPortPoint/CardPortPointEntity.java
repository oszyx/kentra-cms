package com.kentrasoft.cms.port.entity.cardPortPoint;

import java.util.List;

public class CardPortPointEntity{
	
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
	 * 卡口数据
	 */
	private List<CardPortContent> data;

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

	public List<CardPortContent> getData() {
		return data;
	}

	public void setData(List<CardPortContent> data) {
		this.data = data;
	}

}
