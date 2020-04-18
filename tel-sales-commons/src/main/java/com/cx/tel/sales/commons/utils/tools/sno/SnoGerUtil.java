package com.cx.tel.sales.commons.utils.tools.sno;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

/**
 * 随机工具
 */
@Component
public class SnoGerUtil {
	private static Random random = new Random();

	@Autowired
	private Environment env;

	/**
	 * 获取uuid
	 */
	public static synchronized String getUUID() {

		StringBuffer result = new StringBuffer();
		String s = UUID.randomUUID().toString();
		result.append(
				s.substring(0, 8) + s.substring(9, 13) + s.substring(14, 18) + s.substring(19, 23) + s.substring(24));
		return result.toString();
	}

	/**
	 * 生成25位编码，格式为：yyMMddHHmmssSSS + 10 随机数
	 */
	public static synchronized String getOrderNumber() {

		StringBuffer result = new StringBuffer();

		Random random = new Random();

		int ID_BYTES = 6;

		// 取时间
		String dateTime = DateUtil.getyyyyMMddHHmmssDate();
		result = result.append(dateTime);
		// 取10位随机数
		for (int i = 0; i < ID_BYTES; i++) {
			result = result.append(random.nextInt(10));
		}
		return result.toString();
	}

	/**
	 * 获取随机字符
	 * 
	 * @param select
	 *            类型: 0:a-z 1:A-Z 2:0-9
	 * @return
	 */
	public static Character getRandomChar(int select) {
		int tempval = 0;
		if (select == 0) {
			tempval = (int) ((float) 'a' + random.nextFloat() * (float) ('z' - 'a'));
		} else if (select == 1) {
			tempval = (int) ((float) 'A' + random.nextFloat() * (float) ('Z' - 'A'));
		} else {
			tempval = (int) ((float) '0' + random.nextFloat() * (float) ('9' - '0'));
		}
		return new Character((char) tempval);
	}

	/**
	 * 获取指定长度随机字符串
	 * 
	 * @param length
	 * @return
	 */
	public static String getRandomString(int length) {
		StringBuffer buffer = new StringBuffer();
		for (int i = 0; i < length; i++) {
			int randomSelect = (int) (random.nextFloat() * 100) % 3;
			buffer.append(getRandomChar(randomSelect));
		}
		return buffer.toString();
	}

	/**
	 * 获取指定最大长度随机数
	 * 
	 * @param length
	 * @return
	 */
	public static Integer getRandomNumber(int maxLength) {
		StringBuffer buffer = new StringBuffer();
		for (int i = 0; i < maxLength; i++) {
			buffer.append(getRandomChar(2));
		}
		return Integer.parseInt(buffer.toString());
	}

	public static String getCode() {
		StringBuffer sb = new StringBuffer();
		String s = UUID.randomUUID().toString();
		sb.append(s.substring(0, 8) + s.substring(9, 13) + s.substring(14, 18) + s.substring(19, 23) + s.substring(24));
		return sb.toString();
	}

	/**
	 * 获取随即6位
	 * 
	 * @author lun
	 * @return
	 */
	public String getSmsCode() {
		if (env.getProperty("profile").equals("prod_envrimont")) {
			return (int) ((Math.random() * 9 + 1) * 100000) + "";
		} else {
			return "123456";
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		for (int i = 0; i < 40; i++) {
			String s = SnoGerUtil.getUUID();
			System.out.println(s);
		}
	}

	public static String getFlightPolicyId(String prefix) {
		StringBuffer result = new StringBuffer(prefix);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");
		Date d = new Date();
		// 取时间
		String dateTime = sdf.format(d).toString();
		result.append(dateTime.substring(2));
		return result.toString();
	}

}
