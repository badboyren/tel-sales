package com.cx.tel.sales.config.init;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.cx.tel.sales.commons.components.redis.RedisUtils;
import com.cx.tel.sales.commons.constants.http.HttpHandler;
import com.cx.tel.sales.commons.constants.redis.RedisKeys;
import com.cx.tel.sales.commons.dto.version.AppVersion;
import com.cx.tel.sales.commons.utils.tools.app.AppTools;


@Component
public class InitConfigSetting implements ApplicationRunner{

	@Autowired
	private RedisUtils redisUtils;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		AppVersion ios = new AppVersion();
		ios.setAppType(HttpHandler.app_type_ios);
		ios.setDownUrl("www.baidu.com");
		ios.setForceUpdate("1");
		ios.setNewVersion("2.0.0");
		ios.setUpMsg("ios 更新了");
		ios.setUpTime(new Date());
		
		redisUtils.set(RedisKeys.redis_app_ios_version_key, ios);
	}

}
