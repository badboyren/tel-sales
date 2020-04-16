package com.cx.tel.sales.commons.utils.sign;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;


public class MD5Util {
	private static final String PUBLIC_KEY="https://www.cx.mpos.com";

	public static String sign(String content, String key, String charset)  {
		String signData = content + key;

		try {
			String sign = DigestUtils.md5Hex(signData.getBytes(charset));
			return sign;
		} catch (UnsupportedEncodingException e) {

			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 加密算法，加密密钥保存在配置文件中。
	 * 
	 * @param s
	 * @return
	 * @throws NoSuchAlgorithmException 
	 */
    public final static String MD5(String s) throws NoSuchAlgorithmException {
        char hexDigits[]={'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};       
            byte[] btInput = s.getBytes();
            // 获得MD5摘要算法的 MessageDigest 对象
            MessageDigest mdInst = MessageDigest.getInstance("MD5");
            // 使用指定的字节更新摘要
            mdInst.update(btInput);
            // 获得密文
            byte[] md = mdInst.digest();
            // 把密文转换成十六进制的字符串形式
            int j = md.length;
            char str[] = new char[j * 2];
            int k = 0;
            for (int i = 0; i < j; i++) {
                byte byte0 = md[i];
                str[k++] = hexDigits[byte0 >>> 4 & 0xf];
                str[k++] = hexDigits[byte0 & 0xf];
            }
            return new String(str);
    }
    
	/**
	 * 
	 * 随机盐值
	 * @return
	 */
	public static String randomSalt(){
		SecureRandomNumberGenerator randomNumberGenerator =  
			     new SecureRandomNumberGenerator();  
		
			randomNumberGenerator.setSeed(PUBLIC_KEY.getBytes());  
			String hex = randomNumberGenerator.nextBytes().toHex();  
			
			return hex;
	}
    
    
    /**
     * 加密
     * @param password
     * @param salt
     * @return
     */
	public static String[] generatePasswd(String password,String salt){
		
		String tmp_salt = randomSalt();
		
		SimpleHash hash = new SimpleHash("md5", password, salt + tmp_salt, 2);
		return new String[]{hash.toHex(),tmp_salt};
	}
	
	/**
	 * 解密
	 * @param 明文 password
	 * @param salt
	 * @return
	 */
	public static String decipherPasswd(String password,String salt){
		
		SimpleHash hash = new SimpleHash("md5", password, salt, 2);
		
		return hash.toHex();
	}	
    
	
	public final static String getMD5(String pwd) {  
        //用于加密的字符  
        char md5String[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',  
                'A', 'B', 'C', 'D', 'E', 'F' };  
        try {  
            //使用平台的默认字符集将此 String 编码为 byte序列，并将结果存储到一个新的 byte数组中  
            byte[] btInput = pwd.getBytes();  
               
            //信息摘要是安全的单向哈希函数，它接收任意大小的数据，并输出固定长度的哈希值。  
            MessageDigest mdInst = MessageDigest.getInstance("MD5");  
               
            //MessageDigest对象通过使用 update方法处理数据， 使用指定的byte数组更新摘要  
            mdInst.update(btInput);  
               
            // 摘要更新之后，通过调用digest（）执行哈希计算，获得密文  
            byte[] md = mdInst.digest();  
               
            // 把密文转换成十六进制的字符串形式  
            int j = md.length;  
            char str[] = new char[j * 2];  
            int k = 0;  
            for (int i = 0; i < j; i++) {   //  i = 0  
                byte byte0 = md[i];  //95  
                str[k++] = md5String[byte0 >>> 4 & 0xf];    //    5   
                str[k++] = md5String[byte0 & 0xf];   //   F  
            }  
               
            //返回经过加密后的字符串  
            return new String(str);  
               
        } catch (Exception e) {  
            return null;  
        }  
    }  
    
    /**
     * 测试代码，建议保留
     * 
     * @param args
     */
    public static void main(String[] args) {
        try {
        	String[] pw = MD5Util.generatePasswd("admin", "13408678419");
      		System.out.println(pw[0] + " ---- "+  pw[1]);
//        	String pw2 = MD5Util.decipherPasswd("6f3ddbb35bef4f9c5cb1bde8865da975", "1ef2f9b6b8984ce5ea3ba2ee0f656e57");
//      		System.out.println(pw2);
		} catch (Exception e) {
			e.printStackTrace();
		}

    }
    
    
}
