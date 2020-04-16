package com.cx.tel.sales.commons.utils.tools.app;

import javax.servlet.http.HttpServletRequest;

import org.springframework.util.StringUtils;

import com.cx.tel.sales.commons.constants.http.HttpHandler;

public class AppTools {
	
	
	//获取版本信息
	public static String getAppType(String agant) {
		if(agant.toLowerCase().contains(HttpHandler.app_type_android)) {
			return HttpHandler.app_type_android;
		} else if(agant.toLowerCase().contains(HttpHandler.app_type_ios)) {
			return HttpHandler.app_type_ios;
		}
		return "";
	}
	public static String getAppType(HttpServletRequest request) {
		return getAppType(request.getHeader(HttpHandler.agant));
	}
	
	//验证版本信息
	/**
	    *    判断版本1是否在版本2之后
	   1>2 ? true : false
	 */
	public static boolean afterVersion(String version1, String version2) {
		if (StringUtils.isEmpty(version1) || StringUtils.isEmpty(version2)) {
			return false;
		}
		String[] versionArray1 = version1.split("\\.");
		String[] versionArray2 = version2.split("\\.");
		int idx = 0;

		// 取最小长度值
		int minLength = Math.min(versionArray1.length, versionArray2.length);
		int diff = 0;
		while (idx < minLength && (diff = versionArray1[idx].length() - versionArray2[idx].length()) == 0// 先比较长度
				&& (diff = versionArray1[idx].compareTo(versionArray2[idx])) == 0) {// 再比较字符
			++idx;
		}
		// 如果已经分出大小,则直接返回,如果未分出大小,则再比较位数，有子版本的为大;
		diff = (diff != 0) ? diff : versionArray1.length - versionArray2.length;
		return diff > 0;
	}
	public static void main(String[] args) {
		boolean b = afterVersion("2.0.1", "1.0.0");
		System.out.println(b);
	}
	
}
