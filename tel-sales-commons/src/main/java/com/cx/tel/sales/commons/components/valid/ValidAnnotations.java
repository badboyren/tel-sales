package com.cx.tel.sales.commons.components.valid;

import java.lang.reflect.Method;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.cx.tel.sales.commons.annotations.LoginToken;
import com.cx.tel.sales.commons.annotations.NoToken;
import com.cx.tel.sales.commons.constants.http.HttpHandler;
import com.cx.tel.sales.commons.global.GlobalMsgThrowException;
import com.cx.tel.sales.commons.logger.CommonsLogger;

/**
 * 验证业务注解
 */
@Component
public class ValidAnnotations {
	
	@Autowired
	private ValidToken validToken;
	
	//检验是否需要token
	public  void validAnnotation(HttpServletRequest request,Method method ) {
	   if (method.isAnnotationPresent(NoToken.class)) { //不需要tonken
		   CommonsLogger.contrllerLogger.info("check....annotation...is..NoToken");
		   return;
	   }
	   if(method.isAnnotationPresent(LoginToken.class)) { //需要token登陆
		   CommonsLogger.contrllerLogger.info("check....annotation...is..LoginToken");
		  String token = request.getParameter(HttpHandler.token);
		  if(StringUtils.isEmpty(token)) {
			  CommonsLogger.contrllerLogger.info("必须需要....token参数");
			  GlobalMsgThrowException.reqParamExp(HttpHandler.token);
		  }
		  CommonsLogger.contrllerLogger.info("有参数token..............");
		  //看token是否过期
		  validToken.validAppToken(token);
	   }
	}
}
