package com.cx.tel.sales.commons.global;

import com.cx.tel.sales.commons.enums.ConstantEnum;
import com.cx.tel.sales.commons.exception.AppVersionException;
import com.cx.tel.sales.commons.exception.ReqParamException;
import com.cx.tel.sales.commons.exception.ServiceException;
import com.cx.tel.sales.commons.exception.SignException;
import com.cx.tel.sales.commons.exception.TokenException;

/**
 * 全局提示异常
 */
public class GlobalMsgThrowException {
	
	//企业业务服务错误提示
	public static void busServerExp(String msg) {
		throw new ServiceException(ConstantEnum._bus_SERVER_ERROR.getVal(),
				String.format(ConstantEnum._bus_SERVER_ERROR.getDesc(), msg));
	}
	
	
	
	//dev 开发错误 缺少必要参数
	public static void reqParamExp(String msg) {
		throw new ReqParamException(ConstantEnum._DEV_PARAM_NULL.getVal(),
				String.format(ConstantEnum._DEV_PARAM_NULL.getDesc(), msg));
	}
	
	// 签名相关错误
	public static void  signExp(String msg) {
		throw new SignException(ConstantEnum._SIGN_ERROR.getVal(), 
				String.format(ConstantEnum._SIGN_ERROR.getDesc(), msg));
	}
	
	// token 相关错误
	public static void  tokenExp(ConstantEnum enums) {
        throw new TokenException(enums.getVal(), enums.getDesc());
	}
	
	// dev 开发错误
	public static void  devServiceInitExp(String message) {
		throw new RuntimeException(message);
	}
	
	//APP 版本太低，请升级
	public static void appVersionExp(ConstantEnum enums) {
		throw new AppVersionException(enums.getVal(),enums.getDesc());
	}
}
