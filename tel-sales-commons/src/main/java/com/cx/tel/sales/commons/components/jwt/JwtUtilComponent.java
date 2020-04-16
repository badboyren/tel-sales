package com.cx.tel.sales.commons.components.jwt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.cx.tel.sales.commons.constants.redis.RedisKeys;
import com.cx.tel.sales.commons.enums.ConstantEnum;
import com.cx.tel.sales.commons.exception.TokenException;

@Component
public class JwtUtilComponent{
	
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
		 String serKey = null;
         try {
       	  	 serKey = JWT.decode(token).getAudience().get(0);
         } catch (JWTDecodeException e) {
             throw new TokenException(ConstantEnum._FAIL_TOKEN_ERROR.getVal(), ConstantEnum._FAIL_TOKEN_ERROR.getDesc());
         }
		return serKey;
	}
	
	//判断token是否过期
    public void containsToken(String serKey) {
    	String key = RedisKeys.redis_app_login_user + serKey;
    	String redis_value = (String) redisTemplate.opsForValue().get(key);
    	if(StringUtils.isEmpty(redis_value)) {
    		  throw new TokenException(ConstantEnum._FAIL_TOKEN_exceed.getVal(), ConstantEnum._FAIL_TOKEN_exceed.getDesc());
    	}
    }
}
