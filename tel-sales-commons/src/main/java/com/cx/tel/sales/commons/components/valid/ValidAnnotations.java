package com.cx.tel.sales.commons.components.valid;

import java.lang.reflect.Method;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.cx.tel.sales.commons.annotations.LoginToken;
import com.cx.tel.sales.commons.annotations.NoToken;
import com.cx.tel.sales.commons.constants.http.HttpHandler;
import com.cx.tel.sales.commons.global.GlobalMsgThrowException;

/**
 * 验证业务注解
 */
@Component
public class ValidAnnotations {
	
	public static Logger logger  = LoggerFactory.getLogger(ValidAnnotations.class);
	
	@Autowired
	private ValidToken validToken;
	
	//检验是否需要token
	public  void validAnnotation(HttpServletRequest request,Method method ) {
	   if (method.isAnnotationPresent(NoToken.class)) { //不需要tonken
		   logger.info("check....annotation...is..NoToken");
		   return;
	   }
	   if(method.isAnnotationPresent(LoginToken.class)) { //需要token登陆
		 logger.info("check....annotation...is..LoginToken");
		  String token = request.getParameter(HttpHandler.token);
		  if(StringUtils.isEmpty(token)) {
			  logger.info("必须需要....token参数");
			  GlobalMsgThrowException.reqParamExp(HttpHandler.token);
		  }
		  logger.info("有参数token..............");
		  //看token是否过期
		  validToken.validAppToken(token);
	   }
	}
}
