package com.cx.tel.sales.commons.base.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.cx.tel.sales.commons.base.entity.BaseObject;
import com.cx.tel.sales.commons.enums.ConstantEnum;
import com.cx.tel.sales.commons.out.WebResout;

public class BaseController extends BaseObject {
	
	protected Logger logger = LoggerFactory.getLogger(this.getClass());
	
	private static final long serialVersionUID = 1L;
	/**获取真实IP */
	  public String getIpAddress(HttpServletRequest request) { 
	    String ip = request.getHeader("x-forwarded-for"); 
	    if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) { 
	      ip = request.getHeader("Proxy-Client-IP"); 
	    } 
	    if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) { 
	      ip = request.getHeader("WL-Proxy-Client-IP"); 
	    } 
	    if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) { 
	      ip = request.getHeader("HTTP_CLIENT_IP"); 
	    } 
	    if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) { 
	      ip = request.getHeader("HTTP_X_FORWARDED_FOR"); 
	    } 
	    if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) { 
	      ip = request.getRemoteAddr(); 
	    } 
	    return ip; 
	  }
	  
	  //操作成功
	  public WebResout success(HttpServletRequest request) {
		  WebResout out = new WebResout(request);
		  out.setCode(ConstantEnum._SUCCESS.getVal());
		  out.setDesc(ConstantEnum._SUCCESS.getDesc());
		  return out;
	  }
	  public WebResout success(HttpServletRequest request,Object data) {
		  WebResout out = new WebResout(request);
		  out.setCode(ConstantEnum._SUCCESS.getVal());
		  out.setDesc(ConstantEnum._SUCCESS.getDesc());
		  out.setData(data);
		  return out;
	  }
	  public WebResout success(HttpServletRequest request,String token,Object data) {
		  WebResout out = new WebResout(request,token);
		  out.setCode(ConstantEnum._SUCCESS.getVal());
		  out.setDesc(ConstantEnum._SUCCESS.getDesc());
		  out.setData(data);
		  return out;
	  }
	  
	  //失败操作
	  public WebResout fail(HttpServletRequest request) {
		  WebResout out = new WebResout(request);
		  out.setCode(ConstantEnum._FAIL.getVal());
		  out.setDesc(ConstantEnum._FAIL.getDesc());
		  return out;
	  }
      public WebResout fail(HttpServletRequest request,String data) {
        WebResout out = new WebResout(request);
        out.setCode(ConstantEnum._FAIL.getVal());
        out.setDesc(ConstantEnum._FAIL.getDesc());
        out.setData(data);
        return out;
      }
      //自己指定错误枚举提示
      public WebResout fail(HttpServletRequest request,ConstantEnum constant) {
          WebResout out = new WebResout(request);
          out.setCode(constant.getVal());
          out.setDesc(constant.getDesc());
          return out;
      }
      
      public WebResout fail_exp(int code,String desc) {
		  WebResout out = new WebResout();
		  out.setCode(code);
		  out.setDesc(desc);
		  return out;
	  }
      public WebResout fail_exp(HttpServletRequest request,int code,String desc) {
		  WebResout out = new WebResout(request);
		  out.setCode(code);
		  out.setDesc(desc);
		  return out;
	  }
      public WebResout fail_exp(HttpServletRequest request,ConstantEnum constant) {
          WebResout out = new WebResout(request);
          out.setCode(constant.getVal());
          out.setDesc(constant.getDesc());
          return out;
      }
}
