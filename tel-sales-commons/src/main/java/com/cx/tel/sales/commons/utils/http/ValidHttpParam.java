package com.cx.tel.sales.commons.utils.http;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

import com.cx.tel.sales.commons.constants.http.HttpHandler;
import com.cx.tel.sales.commons.enums.ConstantEnum;
import com.cx.tel.sales.commons.exception.ReqParamException;

/***
 */
public class ValidHttpParam {
	public static Logger logger  = LoggerFactory.getLogger(ValidHttpParam.class);
	
	//验证头信息参数
	public static void validReqHeadler(HttpServletRequest request) {
		String agant = request.getHeader(HttpHandler.agant);
		String cver = request.getHeader(HttpHandler.cver);
		if(StringUtils.isEmpty(agant)) {
			throw new ReqParamException(ConstantEnum._DEV_PARAM_NULL.getVal(), String.format(ConstantEnum._DEV_PARAM_NULL.getDesc(), HttpHandler.agant));
		}
		if(StringUtils.isEmpty(cver)) {
			throw new ReqParamException(ConstantEnum._DEV_PARAM_NULL.getVal(), String.format(ConstantEnum._DEV_PARAM_NULL.getDesc(), HttpHandler.cver));
		}
		logger.info("请求头信息agant = {},cver = {}",agant,cver);
	}
	//验证token
	public static String validReqToken(HttpServletRequest request) {
		String token = request.getParameter(HttpHandler.token);
		if(StringUtils.isEmpty(token)) {
			throw new ReqParamException(ConstantEnum._DEV_PARAM_NULL.getVal(), String.format(ConstantEnum._DEV_PARAM_NULL.getDesc(), HttpHandler.token));
		}
		return token;
	}
}
