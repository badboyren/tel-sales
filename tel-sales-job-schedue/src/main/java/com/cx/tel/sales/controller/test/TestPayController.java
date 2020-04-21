package com.cx.tel.sales.controller.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cx.tel.sales.commons.base.controller.BaseController;
import com.cx.tel.sales.commons.components.pay.MposPayDataUtils;

@RestController
@RequestMapping(value = "/test/pay", method = RequestMethod.POST)
public class TestPayController extends BaseController{
	private static final long serialVersionUID = 1L;
	
	@Autowired
	private MposPayDataUtils mposPayDataUtils;
	
	@RequestMapping(value = "/req", method = RequestMethod.GET)
	public String test() {
		mposPayDataUtils.TestReq();
		return "req";
		
	}
}
