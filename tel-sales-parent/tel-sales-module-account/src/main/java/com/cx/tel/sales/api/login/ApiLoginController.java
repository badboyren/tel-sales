package com.cx.tel.sales.api.login;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cx.tel.sales.commons.annotations.LoginToken;
import com.cx.tel.sales.commons.annotations.NoToken;
import com.cx.tel.sales.commons.components.jwt.JwtUtilComponent;
import com.cx.tel.sales.commons.exception.BusinessException;
import com.cx.tel.sales.commons.out.WebResout;
import com.cx.tel.sales.config.base.ApiBaseController;
import com.cx.tel.sales.domain.account.Account;
import com.cx.tel.sales.service.account.IAccountService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;


@Api(value = "accountApi", description = "登陆账户")
@RestController
@RequestMapping("/api/1.0.0/account/account")
public class ApiLoginController extends ApiBaseController {
	
	private static final long serialVersionUID = 1L;
	
	@Autowired
	private JwtUtilComponent jwtUtilComponent;
	@Autowired
	private IAccountService accountService;
	
	@ApiOperation(value = "返回token", notes = "账户登陆",response=WebResout.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "没有查找到登陆账户") })
	@ApiImplicitParams({ 
		@ApiImplicitParam(name = "account", value = "登录账号", required = true, dataType = "string"),
		@ApiImplicitParam(name = "password", value = "登录密码", required = true, dataType = "string"),
		@ApiImplicitParam(name = "sign", value = "签名", dataType = "string")
	})
	@RequestMapping(value = "login", method = RequestMethod.GET)
	@NoToken
	public WebResout login(
			HttpServletRequest request,
			@RequestParam(value = "account", required = true) String account,
			@RequestParam(value = "password", required = true) String password,
			@RequestParam(value = "sign", required = true) String sign
			) throws BusinessException {
		
		Account login = accountService.login(account, password);
		String token = jwtUtilComponent.genToken(login.getUuid(), login.getSalt());
		return success(request,token);
	} 
	
	/**
	 * 获取登录账户信息
	 */
	@ApiOperation(value = "验证token", notes = "获取账户信息",response=WebResout.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "没有查找到登陆账户") })
	@ApiImplicitParams({ 
		@ApiImplicitParam(name = "token", value = "业务token", required = true, dataType = "string"),
	})
	@RequestMapping(value = "valid", method = RequestMethod.GET)
	@LoginToken
	public WebResout validToken(
			HttpServletRequest request,
			@RequestParam(value = "token", required = true) String account
			) throws BusinessException {
		return success(request,getLoinAccount(request));
	}
}
