package com.cx.tel.sales.commons.components.redis.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

@Configuration
@EnableRedisHttpSession(maxInactiveIntervalInSeconds = 60 * 30, redisNamespace = "shanrong-yuefou-admin") //30分钟失效
public class RedisSessionConfig {

}