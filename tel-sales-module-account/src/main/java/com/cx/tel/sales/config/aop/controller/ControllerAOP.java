package com.cx.tel.sales.config.aop.controller;


import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.cx.tel.sales.commons.components.valid.ValidAppVersion;
import com.cx.tel.sales.commons.logger.CommonsLogger;
import com.cx.tel.sales.commons.utils.http.ValidHttpParam;
import com.cx.tel.sales.commons.utils.http.ValidReqSignUtils;

@Aspect
@Configuration
public class ControllerAOP {
	
	  @Autowired
	  private ValidAppVersion validAppVersion;
	
	  @Pointcut("execution(public * com.cx.tel.sales.api.*.*.*(..))")  
	  public void webController(){}  
	  
	  @Before("webController()")  
      public void webBefore(JoinPoint joinPoint) throws Throwable {  
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();  
        HttpServletRequest request = attributes.getRequest();  
        controllerBefore(joinPoint, request);
      }  
	  
	  @AfterReturning(returning = "ret", pointcut = "webController()")   
      public void webAfterReturning(Object ret) throws Throwable {  
		  controllerAfter(ret);
      }
	  
	  
	  protected synchronized void controllerBefore(JoinPoint joinPoint,HttpServletRequest request) {
		    CommonsLogger.contrllerLogger.info("**************************controller logger Start*******************************");
			
		    CommonsLogger.contrllerLogger.info("=====>请求的地址：{}",request.getRequestURL().toString());
		    ValidHttpParam.validReqHeadler(request);
	        ValidReqSignUtils.validReqData(request);
	        validAppVersion.validVersion(request);
	        
			JSONObject g = new JSONObject();
			Enumeration<String> enu=request.getParameterNames(); 
	        while(enu.hasMoreElements()){ 
	            String paraName=(String)enu.nextElement(); 
	            g.put(paraName, request.getParameter(paraName));
	        } 
	        CommonsLogger.contrllerLogger.info("=====>请求的HTTP_METHOD：{}",request.getMethod());
	        CommonsLogger.contrllerLogger.info("=====>请求的类：{}",joinPoint.getSignature().getDeclaringTypeName());
	        CommonsLogger.contrllerLogger.info("=====>执行的方法：{}",joinPoint.getSignature().getName());
	        CommonsLogger.contrllerLogger.info("=====>请求的参数：{}", g.toJSONString());
		}
		protected synchronized void controllerAfter(Object ret) {
			 CommonsLogger.contrllerLogger.info("=====返回的结果{}",JSON.toJSONString(ret));
			 CommonsLogger.contrllerLogger.info("**************************controller logger End*******************************");
		}
}
