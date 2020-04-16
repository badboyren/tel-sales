package com.cx.tel.sales.commons.components.sms;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.cx.tel.sales.commons.components.redis.RedisUtils;
import com.cx.tel.sales.commons.constants.redis.RedisKeys;
import com.cx.tel.sales.commons.enums.ConstantEnum;
import com.cx.tel.sales.commons.exception.ServiceException;
import com.cx.tel.sales.commons.utils.tools.sno.SnoGerUtil;
/***
 *       短信接口服务
 * @author 24168
 */
@Component
@Configuration
@EnableCaching
public class SmsUtilsComponent {
	
	@Autowired
	private Environment env;
	@Autowired
	private SnoGerUtil snoGerUtil;
	@Autowired
	private RedisUtils redisUtils;
	
	/**
	 * 发送账户密码相关短信服务
	 * @param account  手机号
	 * @return
	 */
	public boolean sendPassword(String account) {
		String smsCountKey = RedisKeys.redis_account_sms_count + account ;
		String count =  (String) redisUtils.get(smsCountKey);
		if(!StringUtils.isEmpty(count)) {
			if(Integer.valueOf(count) >= 5) {
				throw new ServiceException(ConstantEnum._bus_SERVER_ERROR.getVal(),
						String.format(ConstantEnum._bus_SERVER_ERROR.getDesc(), "日短信次数超过限制"));
			}
		} else {
			count = "0";
		}
		String smsKey = RedisKeys.redis_account_sms_ + account ;
		
		String smsCode = snoGerUtil.getSmsCode();
		if (env.getProperty("profile").equals("prod_envrimont")) {
//			真实发短信  TODO..
		} else {
			redisUtils.set(smsKey, smsCode, 10, TimeUnit.MINUTES ); //短信分钟数
			redisUtils.set(smsCountKey, String.valueOf(Integer.parseInt(count)+1), 5, TimeUnit.MINUTES );
		}
		return true;
	}
	
	/**
	 * validCode
	 */
	public boolean validCode(String account,String sendType,String code) {
		String redisKey = "";
		if("pwd".equals(sendType)) {
			redisKey = RedisKeys.redis_account_sms_ + account ;
			String redisCode = (String) redisUtils.get(redisKey);
			if(StringUtils.isEmpty(redisCode)) {
				throw new ServiceException(ConstantEnum._bus_SERVER_ERROR.getVal(),
						String.format(ConstantEnum._bus_SERVER_ERROR.getDesc(), "验证码已过期"));
			}
			if(!redisCode.equals(code)) {
				throw new ServiceException(ConstantEnum._bus_SERVER_ERROR.getVal(),
						String.format(ConstantEnum._bus_SERVER_ERROR.getDesc(), "验证码错误"));
			} 
			return true;
		}
		return false;
	}
	
	public static void main(String[] args) throws Exception {
//		SmsUtilsComponent sms = new SmsUtilsComponent();
//		sms.sendLoginAccountSms("13408678419");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String date = sdf.format(new Date());
		System.out.println(date);
		String s = new String("【创鑫管家】非常抱歉，因银行通道原因".getBytes(),"UTF-8");
		System.out.println(s);
				
	}
}
