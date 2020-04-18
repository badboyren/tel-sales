package com.cx.tel.sales.commons.dto.version;

import java.io.Serializable;
import java.util.Date;

/**
 * redis存储app版本数据
 */
public class AppVersion implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private String appType;
	private String newVersion; //最新版本
	private String forceUpdate; //是否强制更新  1是0否
	private String downUrl; //更新地址
	private String upMsg; //更新文案
	private Date upTime;  //更新时间
	
	public String getAppType() {
		return appType;
	}
	public void setAppType(String appType) {
		this.appType = appType;
	}
	public String getNewVersion() {
		return newVersion;
	}
	public void setNewVersion(String newVersion) {
		this.newVersion = newVersion;
	}
	public String getForceUpdate() {
		return forceUpdate;
	}
	public void setForceUpdate(String forceUpdate) {
		this.forceUpdate = forceUpdate;
	}
	public String getDownUrl() {
		return downUrl;
	}
	public void setDownUrl(String downUrl) {
		this.downUrl = downUrl;
	}
	public String getUpMsg() {
		return upMsg;
	}
	public void setUpMsg(String upMsg) {
		this.upMsg = upMsg;
	}
	public Date getUpTime() {
		return upTime;
	}
	public void setUpTime(Date upTime) {
		this.upTime = upTime;
	}
}
