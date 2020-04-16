package com.cx.tel.sales.config.base;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;

import com.cx.tel.sales.commons.base.controller.BaseController;
import com.cx.tel.sales.commons.components.jwt.JwtUtilComponent;
import com.cx.tel.sales.commons.constants.http.HttpHandler;
import com.cx.tel.sales.domain.account.Account;
import com.cx.tel.sales.service.account.IAccountService;

public class ApiBaseController extends BaseController{
	private static final long serialVersionUID = 1L;
	
	@Autowired
     private JwtUtilComponent jwtUtil;
     @Autowired
     private IAccountService accountService;
     
     public Account getLoinAccount(HttpServletRequest request) {
	   	 String token = request.getParameter(HttpHandler.token);
	   	 String uuid = jwtUtil.getSaveKey(token);
	   	 return accountService.selectByUUid(uuid);
     }
     
}
