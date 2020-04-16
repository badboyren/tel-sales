package com.cx.tel.sales.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cx.tel.sales.commons.components.redis.RedisUtils;

@RestController
public class HelloController {
	
	@Autowired
	public RedisUtils redis;
	
	@RequestMapping("/")
	public String index() {
		redis.set("afd", "sdfa");
		return "hello index";
	}
}
