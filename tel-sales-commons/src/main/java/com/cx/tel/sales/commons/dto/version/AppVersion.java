package com.cx.tel.sales.commons.dto.version;

import java.io.Serializable;

/**
 * redis存储app版本数据
 */
public class AppVersion implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private String appType;
	private String tVersion; //当前版本
	private String newVersion; //最新版本
	
	public String getAppType() {
		return appType;
	}
	public void setAppType(String appType) {
		this.appType = appType;
	}
	public String gettVersion() {
		return tVersion;
	}
	public void settVersion(String tVersion) {
		this.tVersion = tVersion;
	}
	public String getNewVersion() {
		return newVersion;
	}
	public void setNewVersion(String newVersion) {
		this.newVersion = newVersion;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
