package com.cx.tel.sales.commons.components.valid;

import java.lang.reflect.Method;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cx.tel.sales.commons.annotations.LoginToken;
import com.cx.tel.sales.commons.components.jwt.JwtUtilComponent;
import com.cx.tel.sales.commons.utils.http.ValidHttpParam;

/**
    *     验证token信息
 */
@Component
public class ValidToken {
	
	public static Logger logger  = LoggerFactory.getLogger(ValidToken.class);
	
	@Autowired
	private JwtUtilComponent jwtUtils;
	
	//检验是否需要token
	public  void validToken(HttpServletRequest request,Method method ) {
	   if(method.isAnnotationPresent(LoginToken.class)) { //需要token登陆
		 
		  String token =  ValidHttpParam.validReqToken(request);
		  // 获取 token 中的 user id
          String serKey = jwtUtils.getSaveKey(token);
          
          jwtUtils.containsToken(serKey);  //判断是否过期
	   }
	}
}
