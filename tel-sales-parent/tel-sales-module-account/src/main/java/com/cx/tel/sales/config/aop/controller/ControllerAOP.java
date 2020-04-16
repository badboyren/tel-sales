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
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.cx.tel.sales.commons.components.valid.ValidAnnotations;
import com.cx.tel.sales.commons.utils.http.ValidHttpParam;
import com.cx.tel.sales.commons.utils.http.ValidReqSignUtils;


@Aspect
@Configuration
public class ControllerAOP {
	
	  protected Logger logger = LoggerFactory.getLogger("controller");
	
	
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
			logger.info("**************************controller logger Start*******************************");
			
			logger.info("=====>请求的地址：{}",request.getRequestURL().toString());
		    ValidHttpParam.validReqHeadler(request,logger);
	        ValidReqSignUtils.validReqData(request,logger);
			
			JSONObject g = new JSONObject();
			Enumeration<String> enu=request.getParameterNames(); 
	        while(enu.hasMoreElements()){ 
	            String paraName=(String)enu.nextElement(); 
	            g.put(paraName, request.getParameter(paraName));
	        } 
			logger.info("=====>请求的HTTP_METHOD：{}",request.getMethod());
			logger.info("=====>请求的类：{}",joinPoint.getSignature().getDeclaringTypeName());
			logger.info("=====>执行的方法：{}",joinPoint.getSignature().getName());
			logger.info("=====>请求的参数：{}", g.toJSONString());
		}
		protected synchronized void controllerAfter(Object ret) {
			logger.info("=====返回的结果{}",JSON.toJSONString(ret));
			logger.info("**************************controller logger End*******************************");
		}
}
