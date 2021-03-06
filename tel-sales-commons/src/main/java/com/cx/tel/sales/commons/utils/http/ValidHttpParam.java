package com.cx.tel.sales.commons.utils.http;

import javax.servlet.http.HttpServletRequest;

import org.springframework.util.StringUtils;

import com.cx.tel.sales.commons.constants.http.HttpHandler;
import com.cx.tel.sales.commons.global.GlobalMsgThrowException;
import com.cx.tel.sales.commons.logger.CommonsLogger;

/***
 */
public class ValidHttpParam {
	//验证头信息参数
	public static void validReqHeadler(HttpServletRequest request) {
		CommonsLogger.contrllerLogger.info("开始验证头信息.......");
		String agant = request.getHeader(HttpHandler.agant);
		String cver = request.getHeader(HttpHandler.cver);
		if(StringUtils.isEmpty(agant)) {
			CommonsLogger.contrllerLogger.info("验证失败：缺少头信息.......{}  ",HttpHandler.agant);
			GlobalMsgThrowException.reqParamExp(HttpHandler.agant);
		}
		if(StringUtils.isEmpty(cver)) {
			CommonsLogger.contrllerLogger.info("验证失败：缺少头信息..... {}  ",HttpHandler.cver);
			GlobalMsgThrowException.reqParamExp(HttpHandler.cver);
		}
		CommonsLogger.contrllerLogger.info("验证通过：请求头信息agant = {},cver = {}",agant,cver);
	}
	//验证token
	public static String validReqToken(HttpServletRequest request) {
		String token = request.getParameter(HttpHandler.token);
		if(StringUtils.isEmpty(token)) {
			GlobalMsgThrowException.reqParamExp(HttpHandler.token);
		}
		return token;
	}
}
