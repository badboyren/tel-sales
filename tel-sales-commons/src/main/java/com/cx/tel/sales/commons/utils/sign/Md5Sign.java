package com.cx.tel.sales.commons.utils.sign;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

@SuppressWarnings("rawtypes")
public class Md5Sign {
	public static String encodeByMD5(String str) {
	    try {
//	    	 MessageDigest digest = MessageDigest.getInstance("MD5");
	        byte[] output = MessageDigest.getInstance("MD5").digest(str.getBytes());
	        StringBuffer out = new StringBuffer();

	        for (int i = 0; i < output.length; ++i) {
	            String t = Integer.toHexString(output[i] & 255);
	            out.append(t.length() == 1 ? "0" + t : t);
	        }

	        String sign = out.toString().toUpperCase();
	        return sign;
	    } catch (NoSuchAlgorithmException e) {
	        e.printStackTrace();
	        return null;
	    }
	}
	public static String getSign(TreeMap<String, String> params) {
	    StringBuffer sbkey = new StringBuffer();
	    // entrySet 所有参与传参的参数按照accsii排序（升序）
		Set es = params.entrySet();
	    Iterator it = es.iterator();
	    while (it.hasNext()) {
	        Map.Entry entry = (Map.Entry) it.next();
	        String k = (String) entry.getKey();
	        Object v = entry.getValue();
	        if (null != v && !"".equals(v)) {
	            sbkey.append(k + "=" + v + "&");
	        }
	    }
	    StringBuffer key = sbkey.deleteCharAt(sbkey.length() - 1);
	    //MD5加密,结果转换为大写字符
	    return encodeByMD5(key.toString());
	}
	public static void main(String[] args) {
		TreeMap<String, String> tree = new TreeMap<>();
		tree.put("account", "13408678419");
		tree.put("sendType", "pwd");
		tree.put("smsCode", "123456");
		String sign = getSign(tree);
		System.out.println(sign);
	}
}
