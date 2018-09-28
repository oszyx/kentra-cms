package com.kentrasoft.cms.port.entity.importPoint;

import java.io.Serializable;
import java.util.List;

public class ImportPointEntity implements Serializable {
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
	 * 进站口数据
	 */
	private List<ImportContent> data;

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

	public List<ImportContent> getData() {
		return data;
	}

	public void setData(List<ImportContent> data) {
		this.data = data;
	}

	

}
