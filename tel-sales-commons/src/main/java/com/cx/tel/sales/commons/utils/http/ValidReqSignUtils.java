package com.cx.tel.sales.commons.utils.http;

import java.util.Enumeration;
import java.util.TreeMap;

import javax.servlet.http.HttpServletRequest;

import org.springframework.util.StringUtils;

import com.alibaba.fastjson.JSON;
import com.cx.tel.sales.commons.constants.http.HttpHandler;
import com.cx.tel.sales.commons.global.GlobalMsgThrowException;
import com.cx.tel.sales.commons.logger.CommonsLogger;
import com.cx.tel.sales.commons.utils.sign.Md5Sign;

/**
    *     验证签名
 */
public class ValidReqSignUtils {
	
	public static final String param_token = HttpHandler.token;
	public static final String param_ver = HttpHandler.cver;
	public static final String param_sign = "sign";
	private static ThreadLocal<TreeMap<String, String>> local = new ThreadLocal<TreeMap<String, String>>();
	/**
	    *   验证请求参数
	 * @param httpServletRequest
	 * @return
	 */
	public static synchronized void validReqData(HttpServletRequest request ) {
		CommonsLogger.contrllerLogger.info("开始验证数据签名信息 ................................");
		if(local.get() == null) {
			local.set(new TreeMap<String, String>());
		}
		Enumeration<String> em = request.getParameterNames();
		if(em.hasMoreElements()) {
			while (em.hasMoreElements()) {
				String param_key = (String) em.nextElement();
				if(param_token.equals(param_key) 
						|| param_ver.equals(param_key)
						|| param_sign.equals(param_key)) {  //不参与参数验证
					continue;
				}
				String value = request.getParameter(param_key);
				local.get().put(param_key, value);
			}
				if(local.get().size() > 0) {
					String sign = Md5Sign.getSign(local.get());
					String reqSign = request.getParameter(param_sign);
					if(StringUtils.isEmpty(reqSign)) {
						CommonsLogger.contrllerLogger.info("验证失败：缺少必要业务参数 = {}",param_sign);
						GlobalMsgThrowException.reqParamExp(param_sign);
					}
					if(!sign.equals(reqSign)) {
						CommonsLogger.contrllerLogger.info("验证失败： -->请求sign={},服务器={}",reqSign,sign);
						GlobalMsgThrowException.signExp(param_sign);
					}
					CommonsLogger.contrllerLogger.info("验证通过：请求参数是：reqdata = {}",JSON.toJSONString(local.get()));
				} else {
					CommonsLogger.contrllerLogger.info("没有业务参数,不需要验签..............");
				}
		} else {
			CommonsLogger.contrllerLogger.info("没有请求参数,不需要验签..............");
		}
	}
}
