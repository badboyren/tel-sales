package com.cx.tel.sales.commons.components.valid;

import java.lang.reflect.Method;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.cx.tel.sales.commons.annotations.LoginToken;
import com.cx.tel.sales.commons.annotations.NoToken;
import com.cx.tel.sales.commons.constants.http.HttpHandler;
import com.cx.tel.sales.commons.enums.ConstantEnum;
import com.cx.tel.sales.commons.exception.ReqParamException;

/**
    *     验证业务注解
 */
@Component
public class ValidAnnotations {
	
	public static Logger logger  = LoggerFactory.getLogger(ValidAnnotations.class);
	
	//检验是否需要token
	public  void validAnnotation(HttpServletRequest request,Method method ) {
	   if (method.isAnnotationPresent(NoToken.class)) { //不需要tonken
		   logger.info("check....annotation...is..NoToken");
		   return;
	   }
	   if(method.isAnnotationPresent(LoginToken.class)) { //需要token登陆
		  String token = request.getParameter(HttpHandler.token);
		  if(StringUtils.isEmpty(token)) {
				throw new ReqParamException(ConstantEnum._DEV_PARAM_NULL.getVal(), String.format(ConstantEnum._DEV_PARAM_NULL.getDesc(), HttpHandler.token));
		  }
	   }
	}
}
