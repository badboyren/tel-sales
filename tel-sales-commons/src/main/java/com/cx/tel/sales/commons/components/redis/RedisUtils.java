package com.cx.tel.sales.commons.components.redis;

import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

@Component
public class RedisUtils {
	
	@Autowired
	private RedisTemplate<String, Object> redisTemplate;
	
	public void set(String key,Object value) {
		redisTemplate.opsForValue().set(key, value);
	}
	public void set(String key,Object value,long timeout, TimeUnit unit) {
		redisTemplate.opsForValue().set(key, value, timeout,unit);
	}
	public Object get(String key) {
		return redisTemplate.opsForValue().get(key);
	}
	public void remove(String key) {
		 redisTemplate.opsForValue().set(key, "", 1, TimeUnit.MILLISECONDS);
	}
}
