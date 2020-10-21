package project.common.util;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Base64;


public class AESCrypto {

	public static String encrypt(String key, String plainText) throws Exception {
		
		SecretKeySpec skeySpec = new SecretKeySpec(key.getBytes(), "AES");
		Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding"); 
		
		cipher.init(Cipher.ENCRYPT_MODE, skeySpec); 
		byte[] encrypted = cipher.doFinal(plainText.getBytes()); 
		
		return Base64.encodeBase64String(encrypted);
	}
	
	public static String decrypt(String key, String encryptText) throws Exception {
		
		SecretKeySpec skeySpec = new SecretKeySpec(key.getBytes(), "AES");
		Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding"); 

		cipher.init(Cipher.DECRYPT_MODE, skeySpec);
		
		byte[] original = cipher.doFinal(Base64.decodeBase64(encryptText));
		
		return new String(original);
	}
	
	
	public static void main(String[] args) throws Exception {
		
		String kr = AESCrypto.encrypt("83e255849ddd6e4c", "무굴화꽃이피었습니다");
		System.out.println(kr);
		String en = AESCrypto.decrypt("83e255849ddd6e4c", "vOJhRayEUU2qnw5pBzLPOg==");
		System.out.println(en);		
		
		System.out.println(AESCrypto.decrypt("83e255849ddd6e4c", "yT1ooQSi7IIHQmNgW6uj0ra0czObc55akYvW3AoMZME="));
	}
	
}
