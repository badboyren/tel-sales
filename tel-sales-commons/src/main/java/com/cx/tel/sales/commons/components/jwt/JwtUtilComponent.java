package com.cx.tel.sales.commons.components.jwt;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.cx.tel.sales.commons.components.valid.ValidToken;
import com.cx.tel.sales.commons.constants.redis.RedisKeys;
import com.cx.tel.sales.commons.enums.ConstantEnum;
import com.cx.tel.sales.commons.global.GlobalMsgThrowException;

@Component
public class JwtUtilComponent{
	
	public static Logger logger  = LoggerFactory.getLogger(JwtUtilComponent.class);
	
	@Autowired
	private RedisTemplate<String, String> redisTemplate;
	
	/**
	 * serKey 业务Key  一般用户主键
	 * salt  私有混淆盐值
	 * @return token
	 */
	public String genToken(String serKey,String salt) {
	 String token = JWT.create().withAudience(serKey)// 将 serKey 保存到 token 里面
                .sign(Algorithm.HMAC256(salt));// 以 salt 作为 token 的密钥
        return token;
	}
	
	//获取JWT业务Key
	public String getSaveKey(String token) {
		logger.info("JWT 解密token..........");
		 String serKey = null;
         try {
       	  	 serKey = JWT.decode(token).getAudience().get(0);
         } catch (JWTDecodeException e) {
        	 logger.info("JWT 解密失败token错误..........");
        	 GlobalMsgThrowException.tokenExp(ConstantEnum._FAIL_TOKEN_ERROR);
         }
        logger.info("JWT 解密获取到秘钥:{}",serKey);
		return serKey;
	}
	
	//判断token是否过期
    public void containsAppToken(String serKey) {
    	String key = RedisKeys.redis_app_login_user + serKey;
    	String redis_value = (String) redisTemplate.opsForValue().get(key);
    	if(StringUtils.isEmpty(redis_value)) {
    		logger.info("token 失效........");
    		GlobalMsgThrowException.tokenExp(ConstantEnum._FAIL_TOKEN_exceed);
    	}
    	logger.info("token有效........");
    }
}
