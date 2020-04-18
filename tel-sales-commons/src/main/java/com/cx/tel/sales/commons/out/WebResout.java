package com.cx.tel.sales.commons.out;


import javax.servlet.http.HttpServletRequest;

import org.springframework.util.StringUtils;

import com.cx.tel.sales.commons.base.entity.BaseObject;

/**
 * web响应参数
 * @author Administrator
 */
public class WebResout extends BaseObject{
	
	private static final long serialVersionUID = 1L;
	protected long currentTimeMillis = 0; //系统时间
	protected String location = null;  //请求地址
	protected String lang= "";  //国际化
	
	private int code = 0xffffffff;    //错误码
	private String desc = "";         //描述
	private String token = null;   //token
	private Object data = null;    //响应数据
	
	public WebResout() {
		this.currentTimeMillis = System.currentTimeMillis();
	}
	
	public WebResout(HttpServletRequest req) {
		if(!StringUtils.isEmpty(req.getHeader("token"))) {
			this.token = req.getHeader("token");
		}
		this.currentTimeMillis = System.currentTimeMillis();
		this.location = req.getRequestURL().toString();
	}
	
	public WebResout(HttpServletRequest req,String token) {
		this.currentTimeMillis = System.currentTimeMillis();
		this.location = req.getRequestURL().toString();
		this.token = token;
	}
	
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public long getCurrentTimeMillis() {
		return currentTimeMillis;
	}
	public void setCurrentTimeMillis(long currentTimeMillis) {
		this.currentTimeMillis = currentTimeMillis;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}

	public String getLang() {
		return lang;
	}
	public void setLang(String lang) {
		this.lang = lang;
	}
	
}
