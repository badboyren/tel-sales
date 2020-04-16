package com.cx.tel.sales.config.interceptor;

import java.lang.reflect.Method;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.cx.tel.sales.commons.components.valid.ValidAnnotations;
import com.cx.tel.sales.commons.components.valid.ValidToken;


public class AuthenticationInterceptor implements HandlerInterceptor {

    private Logger logger = LoggerFactory.getLogger(this.getClass());
    
    @Autowired
    private ValidAnnotations validAnnotations;

    @SuppressWarnings("unused")
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest,
                             HttpServletResponse httpServletResponse,
                             Object object) throws Exception {
    	
//       // 如果不是映射到方法直接通过
          if (!(object instanceof HandlerMethod)) {
            return true;
          }
          System.out.println("------badboy-------"+httpServletRequest.getRequestURL());
        
          HandlerMethod handlerMethod = (HandlerMethod) object;
          Method method = handlerMethod.getMethod();
//        //验证annotations
          validAnnotations.validAnnotation(httpServletRequest, method);
        
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest,
                           HttpServletResponse httpServletResponse,
                           Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest,
                                HttpServletResponse httpServletResponse,
                                Object o, Exception e) throws Exception {

    }
}
