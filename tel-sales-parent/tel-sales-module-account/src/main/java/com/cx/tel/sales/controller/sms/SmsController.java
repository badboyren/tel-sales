package com.cx.tel.sales.controller.sms;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cx.tel.sales.commons.base.controller.BaseController;
import com.cx.tel.sales.commons.components.sms.SmsUtilsComponent;
import com.cx.tel.sales.commons.out.WebResout;

@Controller
@RequestMapping("/sms")
public class SmsController extends BaseController {
	private static final long serialVersionUID = 1L;
	
	@Autowired
	private SmsUtilsComponent smsUtilsComponent;
	
	/*** 发送短信  */
	@PostMapping("send")
	@ResponseBody
	public WebResout send(
			HttpServletRequest request,
			@RequestParam("account") String account,
			@RequestParam("sendType") String sendType) {
		
		if("pwd".equals(sendType)) {
			boolean send = smsUtilsComponent.sendPassword(account);
			if(send) {
				return success(request);
			} 
		}
		
		return fail(request,"短信发送失败,请稍后再试");
	}
	
	/*** 发送短信  */
	@PostMapping("valid")
	@ResponseBody
	public WebResout valid(
			HttpServletRequest request,
			@RequestParam("account") String account,
			@RequestParam("sendType") String sendType,
			@RequestParam("smsCode") String code) {
		
		if("pwd".equals(sendType)) {
			boolean send = smsUtilsComponent.validCode(account, sendType, code);
			if(send) {
				return success(request);
			} 
		}
		return fail(request,"短信验证失败,请稍后再试");
	}
}
