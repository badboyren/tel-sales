package com.cx.tel.sales.commons.enums;

/**
 * 公共枚举
 * @author 24168
 */
public enum ConstantEnum {
	//全局操作成功失败
	_SUCCESS("操作成功", 200),
	_FAIL("操作失败", -1),
	
	//商业业务错误
	_bus_SERVER_ERROR("%s",-1),
	
	_FAIL_TOKEN_ERROR("非法Token",-100),
	_FAIL_TOKEN_exceed("token过期",-200),
	
	//开发缺少必要参数
	_DEV_PARAM_NULL("缺少必要参数%s",-100),
	_DEV_REQ_METHOD_ERROR("HTTP请求类型错误",-100),
	_SIGN_ERROR("业务请求签签名错误",-100),
	
	_APP_VERIOSN_UP("当前版本太低,请升级",-1000),
	_APP_VERIOSN_ERROR("移动端版本错误",-1),
	
	_FAIL_DATA_NULL("数据不存在或已被删除",-1),
	_manage_setting_error("管理员[%s]数据配置错误",-500),
	
	_CONTROLLER_EXP("服务好像出问题了,稍后再试下",-500);
	
	private int val;
	private String desc;
	
	private ConstantEnum(String desc, int val) {
		this.desc = desc;
		this.val = val;
	}
	public int getVal() {
		return this.val;
	}
	public String getDesc() {
		return this.desc;
	}
}
