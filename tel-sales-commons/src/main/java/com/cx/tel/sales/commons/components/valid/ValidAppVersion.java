package com.cx.tel.sales.commons.components.valid;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.cx.tel.sales.commons.components.redis.RedisUtils;
import com.cx.tel.sales.commons.constants.http.HttpHandler;
import com.cx.tel.sales.commons.constants.redis.RedisKeys;
import com.cx.tel.sales.commons.dto.version.AppVersion;
import com.cx.tel.sales.commons.enums.ConstantEnum;
import com.cx.tel.sales.commons.global.GlobalMsgThrowException;
import com.cx.tel.sales.commons.logger.CommonsLogger;
import com.cx.tel.sales.commons.utils.http.ValidHttpParam;
import com.cx.tel.sales.commons.utils.tools.app.AppTools;

@Component
public class ValidAppVersion {
	
	@Autowired
	private RedisUtils redisUtils;
	
	public void validVersion(HttpServletRequest request) {
		
		ValidHttpParam.validReqHeadler(request); //验证参数
		
		String agant = request.getHeader(HttpHandler.agant);
		
		String appType = AppTools.getAppType(agant);
		if(!StringUtils.isEmpty(appType)) { //其他终端我们就操作
			Object object = redisUtils.get(getRedisKey(appType));
			if(object == null) {
				CommonsLogger.contrllerLogger.info("dev  容器没有在redis中存入App版本信息  error");
				GlobalMsgThrowException.devServiceInitExp("容器没有在redis中存入App版本信息");
			}
			AppVersion version = (AppVersion) object;
			String cver = request.getHeader(HttpHandler.cver);
			if(version.getNewVersion().equals(cver)) { //如果版本相同。表示最新版本
				CommonsLogger.contrllerLogger.info("当前移动端{}版本是最新版本{}",appType,cver);
				return;
			} else {
				CommonsLogger.contrllerLogger.info("当前移动端{}版本是{}服务器最新版本{}不相同",appType,cver,version.getNewVersion());
				if("1".equals(version.getForceUpdate())) { 
					if(AppTools.afterVersion(version.getNewVersion(), cver)) { //服务器版本大于移动端版本
						GlobalMsgThrowException.appVersionExp(ConstantEnum._APP_VERIOSN_UP);  //版本过低
					} else {
						GlobalMsgThrowException.appVersionExp(ConstantEnum._APP_VERIOSN_ERROR);  //移动端版本错误
					}
				} else {
					// TODO.. 最小版本兼容
				}
			}
		}
	}
	
	public String getRedisKey(String appType) {
		if(HttpHandler.app_type_android.equals(appType)) {
			CommonsLogger.contrllerLogger.info("get redis android version key");
			return RedisKeys.redis_app_android_version_key;
		} else if(HttpHandler.app_type_ios.equals(appType)) {
			CommonsLogger.contrllerLogger.info("get redis ios version key");
			return RedisKeys.redis_app_ios_version_key;
		}
		return appType;
	}
	
}
