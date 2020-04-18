package com.cx.tel.sales.commons.components.valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.cx.tel.sales.commons.components.jwt.JwtUtilComponent;

/**
 * 验证token信息
 */
@Component
public class ValidToken {
	
	public static Logger logger  = LoggerFactory.getLogger(ValidToken.class);
	
	@Autowired
	private JwtUtilComponent jwtUtils;
	
	//检验是否需要token
	public void validAppToken(String token) {
	   //获取的  业务序列Key 
       String serKey = jwtUtils.getSaveKey(token); 
       jwtUtils.containsAppToken(serKey);  //判断是否过期
	}
	
}
