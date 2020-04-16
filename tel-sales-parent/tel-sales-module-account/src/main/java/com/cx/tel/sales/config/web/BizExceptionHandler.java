package com.cx.tel.sales.config.web;

import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.cx.tel.sales.commons.base.controller.BaseController;
import com.cx.tel.sales.commons.enums.ConstantEnum;
import com.cx.tel.sales.commons.exception.BusinessException;
import com.cx.tel.sales.commons.exception.ReqParamException;
import com.cx.tel.sales.commons.exception.ServiceException;
import com.cx.tel.sales.commons.exception.SignException;
import com.cx.tel.sales.commons.exception.TokenException;
import com.cx.tel.sales.commons.out.WebResout;

@RestControllerAdvice
public class BizExceptionHandler extends BaseController{

	private static final long serialVersionUID = 1L;

	//控制器出错
	@ExceptionHandler({BusinessException.class})
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public WebResout processBizException(HttpServletRequest request,BusinessException e) {
        return fail_exp(request,e.getExpCode(), e.getExpMsg());
    }
	
	//保证签名正确
	@ExceptionHandler({SignException.class})
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public WebResout signException(HttpServletRequest request,SignException e) {
        return fail_exp(request,e.getExpCode(), e.getExpMsg());
    }
	
	//缺少必要参数信息
	@ExceptionHandler({ReqParamException.class})
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public WebResout reqParamException(HttpServletRequest request,ReqParamException e) {
        return fail_exp(request,e.getExpCode(), e.getExpMsg());
    }
	
	//token错误
	@ExceptionHandler({TokenException.class})
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public WebResout tokenException(HttpServletRequest request,TokenException e) {
        return fail_exp(request,e.getExpCode(), e.getExpMsg());
    }
	
	
	//商业业务错误
	@ExceptionHandler({ServiceException.class})
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public WebResout serviceException(HttpServletRequest request,ServiceException e) {
        return fail_exp(request,e.getExpCode(), e.getExpMsg());
    }
	
	//开发者请求类型错误
	@ExceptionHandler({HttpRequestMethodNotSupportedException.class})
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public WebResout httpRequestMethodNotSupportedException(HttpServletRequest request,HttpRequestMethodNotSupportedException e) {
        return fail_exp(request,ConstantEnum._DEV_REQ_METHOD_ERROR);
    }
	
}
