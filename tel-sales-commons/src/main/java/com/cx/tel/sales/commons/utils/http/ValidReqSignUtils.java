package com.cx.tel.sales.commons.utils.http;

import java.util.Enumeration;
import java.util.TreeMap;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

import com.alibaba.fastjson.JSON;
import com.cx.tel.sales.commons.constants.http.HttpHandler;
import com.cx.tel.sales.commons.enums.ConstantEnum;
import com.cx.tel.sales.commons.exception.SignException;
import com.cx.tel.sales.commons.utils.sign.Md5Sign;

/**
    *     验证签名
 */
public class ValidReqSignUtils {
	
	public static Logger logger  = LoggerFactory.getLogger(ValidReqSignUtils.class);
	
	public static final String param_token = HttpHandler.token;
	public static final String param_ver = HttpHandler.cver;
	public static final String param_sign = "sign";
	private static ThreadLocal<TreeMap<String, String>> local = new ThreadLocal<TreeMap<String, String>>();
	/**
	    *   验证请求参数
	 * @param httpServletRequest
	 * @return
	 */
	public static synchronized void validReqData(HttpServletRequest request) {
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
				String sign = Md5Sign.getSign(local.get());
				String reqSign = request.getParameter(param_sign);
				if(StringUtils.isEmpty(reqSign)) {
					logger.info("缺少必要业务参数 = {}",param_sign);
					throw new SignException(ConstantEnum._DEV_PARAM_NULL.getVal(), String.format(ConstantEnum._DEV_PARAM_NULL.getDesc(), param_sign));
				}
				if(!sign.equals(reqSign)) {
					logger.info("验签错误 -->请求sign={},服务器={}",reqSign,sign);
					throw new SignException(ConstantEnum._SIGN_ERROR.getVal(), String.format(ConstantEnum._SIGN_ERROR.getDesc(), param_sign));
				}
				logger.info("请求参数是：reqdata = {}",JSON.toJSONString(local.get()));
		} else {
			logger.info("没有请求参数,不需要验签..............");
		}
	}
}
