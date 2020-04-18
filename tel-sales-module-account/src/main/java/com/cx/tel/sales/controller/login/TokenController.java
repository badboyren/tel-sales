package com.cx.tel.sales.controller.login;

import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.cx.tel.sales.commons.base.controller.BaseController;
import com.cx.tel.sales.commons.constants.http.HttpHandler;
import com.cx.tel.sales.commons.enums.ConstantEnum;
import com.cx.tel.sales.commons.out.WebResout;
import com.cx.tel.sales.domain.account.Account;


@Controller
@RequestMapping("/token")
public class TokenController extends BaseController{
	
	@GetMapping("valid")
	@ResponseBody
	public WebResout valid(HttpServletRequest request) {
		return validToken(request);
	}
	
	@PostMapping("getData")
	@ResponseBody
	public WebResout getTokenDate(HttpServletRequest request) {
		
		WebResout validOut = validToken(request);
		if(validOut.getCode() < 0) {
			return validOut;
		}
		String handlerToken = getHandlerToken(request);
		// 获取 token 中的 user id
        String accountId = JWT.decode(handlerToken).getAudience().get(0);
        
        //TODO DAO getData
        Account account = new Account();
        account.setAccount("13408678419");
        account.setUuid(accountId); //UUID
        account.setSalt("fadsfasdf4321413241sgfs");
        
		return success(request,account);
	}
	
	protected String getHandlerToken(HttpServletRequest request) {
		return request.getHeader(HttpHandler.token);
	}
	protected WebResout validToken(HttpServletRequest request) {
		String handlerToken = getHandlerToken(request);
		if(StringUtils.isEmpty(handlerToken)) {
			return  fail(request, ConstantEnum._DEV_PARAM_NULL);
		}
		// 获取 token 中的 user id
        String accountId = null;
        String name = null;
        String sex = null;
        try {
        	accountId = JWT.decode(handlerToken).getAudience().get(0);
        	name = JWT.decode(handlerToken).getAudience().get(1);
        	sex = JWT.decode(handlerToken).getAudience().get(2);
        } catch (JWTDecodeException e) {
        	logger.info("token  error.........");
            return  fail(request, ConstantEnum._FAIL_TOKEN_ERROR);
        }
		// 验证 token
        JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC256(name)).build();
        try {
            jwtVerifier.verify(handlerToken);
        } catch (JWTVerificationException e) {
            logger.info("token valid error.........");
            return  fail(request, ConstantEnum._FAIL_TOKEN_ERROR);
        }
		return success(request,"验证通过");
	}
}
