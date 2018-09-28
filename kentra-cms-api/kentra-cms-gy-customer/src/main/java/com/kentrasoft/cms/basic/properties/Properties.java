package com.kentrasoft.cms.basic.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@Configuration
@ConfigurationProperties(ignoreInvalidFields=true)
@PropertySource("classpath:constantConfig.properties")
public class Properties {
	
	private String devicestatus;
	
	private String CardportimgLinkaddress;
	
	private String CardportimgCountaddress;
	
	private String MapsLinkaddress;
	
	private String postdeviceAddress;
	
	
	public String getPostdeviceAddress() {
		return postdeviceAddress;
	}

	public void setPostdeviceAddress(String postdeviceAddress) {
		this.postdeviceAddress = postdeviceAddress;
	}

	public String getMapsLinkaddress() {
		return MapsLinkaddress;
	}

	public void setMapsLinkaddress(String mapsLinkaddress) {
		MapsLinkaddress = mapsLinkaddress;
	}

	public String getDevicestatus() {
		return devicestatus;
	}

	public void setDevicestatus(String devicestatus) {
		this.devicestatus = devicestatus;
	}

	public String getCardportimgLinkaddress() {
		return CardportimgLinkaddress;
	}

	public void setCardportimgLinkaddress(String cardportimgLinkaddress) {
		CardportimgLinkaddress = cardportimgLinkaddress;
	}

	public String getCardportimgCountaddress() {
		return CardportimgCountaddress;
	}

	public void setCardportimgCountaddress(String cardportimgCountaddress) {
		CardportimgCountaddress = cardportimgCountaddress;
	}
	
	

}
