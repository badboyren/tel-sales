package com.cx.tel.sales.config.aop.service;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;


@Aspect
@Configuration
public class ServiceAOP{
	 
	//自定义的日志
	  protected Logger logger = LoggerFactory.getLogger("service");
	
	  @Pointcut("execution(public * com.cx.tel.sales.service.*.impl.*.*(..))")  
	  public void serverLog(){}  
	  
	 /**
	     * 环绕通知
	  */
     @Around(value = "serverLog()")
     public Object arround(ProceedingJoinPoint pjp) {
    	 
    	logger.info("method start ---------------------------------------------");
    	logger.info("=====>请求的类：{}",pjp.getSignature().getDeclaringTypeName());
    	logger.info("=====>执行的方法：{}",pjp.getSignature().getName());

        long startTime = System.currentTimeMillis();
        
        try {
            Object o =  pjp.proceed();
            return o;
        } catch (Throwable e) {
            logger.error(pjp.getSignature() + " 出现异常： ", e);
        } finally {
            logger.info("=====>执行时间：{}",System.currentTimeMillis() - startTime);
            logger.info("method end ---------------------------------------------");
        }
		return pjp;
    }
}
