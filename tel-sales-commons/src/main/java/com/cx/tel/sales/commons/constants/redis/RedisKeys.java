package com.cx.tel.sales.commons.constants.redis;

public class RedisKeys {
	
	//android ios  最新版本信息Key
	public static final String redis_app_android_version_key = "app_android_ver";
	public static final String redis_app_ios_version_key = "app_ios_ver";
	
	
	//login user _key
	public static final int redis_app_login_user_time = 30; //token有效时间30分钟
	public static final String redis_app_login_user = "app_login_key_";
 
	
	//redis——sms_key
	public static final String redis_account_sms_count = "account_sms_count_";
	public static final String redis_account_sms_ = "account_sms_";
}
