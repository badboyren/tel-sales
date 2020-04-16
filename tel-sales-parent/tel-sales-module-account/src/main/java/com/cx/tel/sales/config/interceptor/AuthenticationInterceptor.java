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
import com.cx.tel.sales.commons.utils.http.ValidHttpParam;
import com.cx.tel.sales.commons.utils.http.ValidReqSignUtils;


public class AuthenticationInterceptor implements HandlerInterceptor {

    private Logger logger = LoggerFactory.getLogger(this.getClass());
    
    @Autowired
    private ValidAnnotations validAnnotations;
    @Autowired
    private ValidToken validToken;

    @SuppressWarnings("unused")
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest,
                             HttpServletResponse httpServletResponse,
                             Object object) throws Exception {
    	

        String token = httpServletRequest.getHeader("token");// 从 http 请求头中取出 token
        // 如果不是映射到方法直接通过
        if (!(object instanceof HandlerMethod)) {
            return true;
        }
        
        HandlerMethod handlerMethod = (HandlerMethod) object;
        Method method = handlerMethod.getMethod();
        
        logger.info("业务请求地址:{}",httpServletRequest.getRequestURI());
        //验证头信息
        ValidHttpParam.validReqHeadler(httpServletRequest);
        //验签
        ValidReqSignUtils.validReqData(httpServletRequest);
        //验证annotations
        validAnnotations.validAnnotation(httpServletRequest, method);
        //验证token
        validToken.validToken(httpServletRequest, method);
        
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
