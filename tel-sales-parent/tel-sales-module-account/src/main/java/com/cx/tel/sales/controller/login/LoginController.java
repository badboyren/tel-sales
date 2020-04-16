package com.cx.tel.sales.controller.login;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cx.tel.sales.commons.base.controller.BaseController;
import com.cx.tel.sales.commons.components.jwt.JwtUtilComponent;
import com.cx.tel.sales.commons.out.WebResout;
import com.cx.tel.sales.domain.account.Account;
import com.cx.tel.sales.service.account.IAccountService;


@Controller
@RequestMapping("/account")
public class LoginController extends BaseController{
	
	private static final long serialVersionUID = 1L;
	
	@Autowired
	private JwtUtilComponent jwt;
	
	@Autowired
	private IAccountService IAccountService;

	@PostMapping("login")
	@ResponseBody
	public WebResout login(
			HttpServletRequest request,
			@RequestParam("account") String account,
			@RequestParam("password")String password) {
		Account dbaccount = IAccountService.login(account, password);
		return success(request,jwt.genToken(dbaccount.getUuid(), dbaccount.getSalt()));
	}
	
	@PostMapping("init")
	@ResponseBody
	public WebResout init(
			HttpServletRequest request,
			@RequestParam("account") String account,
			@RequestParam("password")String password) {
		IAccountService.createAccountInit(account, password);
		return success(request);
	}
	
	//验证手机号
	@PostMapping("validAccount")
	@ResponseBody
	public WebResout validAccount(
			HttpServletRequest request,
			@RequestParam("account") String account) {
		IAccountService.checkAccount(account);
		return success(request);
	}
	
	
	@PostMapping("chargePwd")
	@ResponseBody
	public WebResout chargePwd(
			HttpServletRequest request,
			@RequestParam("account") String account,
			@RequestParam("pwd1") String pwd1,
			@RequestParam("pwd2") String pwd2,
			@RequestParam("smsCode")String smsCode) {
		IAccountService.chargeAccountPwd(account, pwd1, pwd2, smsCode);
		return success(request);
	}
	@PostMapping("logout")
	@ResponseBody
	public WebResout logout(HttpServletRequest request) {
		//删除token  TODO..
		//删除token
		return success(request,"删除成功");
	}
}
