package com.hsnn.medstgmini.util;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.interfaces.RSAPrivateCrtKey;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.HashMap;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

@SuppressWarnings("restriction")
public class RSATool {
	public static final String TRANSFORMATION = "RSA/ECB/PKCS1PADDING";
	public static final String ALGORITHM = "RSA";
	public static final int KEY_SIZE = 2048;
	public static final String PUBLIC_KEY = "RSAPublicKey";
	public static final String PRIVATE_KEY = "RSAPrivateKey";
	
	private static final String NEW_LINE_CHARACTER = "[\\t\\n\\r]";
	private static final BASE64Decoder base64Decoder = new BASE64Decoder();
	private static final BASE64Encoder base64Encoder= new BASE64Encoder();
	
	/**
	 * 使用密钥分段解密
	 * @param text 密文
	 * @param key 密钥
	 * @return 明文
	 * @throws NoSuchPaddingException 
	 * @throws NoSuchAlgorithmException 
	 * @throws InvalidKeyException 
	 * @throws BadPaddingException 
	 * @throws IllegalBlockSizeException
	 * @throws IOException 
	 */
	public static byte[] decryptAll(byte[] txtb, Key key) throws InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException, IOException {
		ByteArrayOutputStream swapStream = new ByteArrayOutputStream();
		int offSet = 0;
		while(offSet < txtb.length){
			byte[] cache;
			int len;
			if(offSet+128 < txtb.length){
				len = 128;
			} else {
				len = txtb.length-offSet;
			}
			cache = new byte[len];
			System.arraycopy(txtb, offSet, cache, 0, len);
			offSet+=128;
			byte[] encrypt = RSATool.decrypt(cache, key);
			swapStream.write(encrypt);
		}
		return swapStream.toByteArray();
	}
	
	/**
	 * 使用密钥分段加密
	 * 
	 * @param text 明文
	 * @param key 密钥
	 * @return 密文
	 * @throws IOException 
	 * @throws BadPaddingException 
	 * @throws IllegalBlockSizeException 
	 * @throws NoSuchPaddingException 
	 * @throws NoSuchAlgorithmException 
	 * @throws InvalidKeyException 
	 */
	public static byte[] encryptAll(byte[] txtb, Key key) throws InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException, IOException{
		int offSet = 0;
		ByteArrayOutputStream swapStream = new ByteArrayOutputStream();
		while(offSet < txtb.length){
			byte[] cache;
			int len;
			if(offSet+117 < txtb.length){
				len = 117;
			} else {
				len = txtb.length-offSet;
			}
			cache = new byte[len];
			System.arraycopy(txtb, offSet, cache, 0, len);
			offSet+=117;
			swapStream.write(RSATool.encrypt(cache, key));
		}
		return swapStream.toByteArray();
	}
	
	/**
	 * 使用密钥解密
	 * @param text 密文
	 * @param key 密钥
	 * @return 明文
	 * @throws NoSuchPaddingException 
	 * @throws NoSuchAlgorithmException 
	 * @throws InvalidKeyException 
	 * @throws BadPaddingException 
	 * @throws IllegalBlockSizeException
	 */
	public static byte[] decrypt(byte[] text, Key key) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
		byte[] dectyptedText = null;
		final Cipher cipher = Cipher.getInstance(ALGORITHM);
		cipher.init(Cipher.DECRYPT_MODE, key);
		dectyptedText = cipher.doFinal(text);
		return dectyptedText;
	}
	
	/**
	 * 使用密钥加密
	 * 
	 * @param text 明文
	 * @param key 密钥
	 * @return 密文
	 * @throws NoSuchPaddingException 
	 * @throws NoSuchAlgorithmException 
	 * @throws InvalidKeyException 
	 * @throws BadPaddingException 
	 * @throws IllegalBlockSizeException
	 */
	public static byte[] encrypt(byte[] text, Key key) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
		byte[] cipherText = null;
		final Cipher cipher = Cipher.getInstance(ALGORITHM);
		cipher.init(Cipher.ENCRYPT_MODE, key);
		cipherText = cipher.doFinal(text);
		return cipherText;
	}
	
	/**
	 * 从字符串中加载公钥
	 * 
	 * @param publicKeyStr 公钥数据字符串
	 * @return 公钥
	 * @throws Exception 加载公钥时产生的异常
	 */
	public static RSAPublicKey loadPublicKey(String publicKeyStr) throws Exception {
		try {
			byte[] buffer = base64Decoder.decodeBuffer(publicKeyStr);
			KeyFactory keyFactory = KeyFactory.getInstance(ALGORITHM);
			X509EncodedKeySpec keySpec = new X509EncodedKeySpec(buffer);
			return (RSAPublicKey) keyFactory.generatePublic(keySpec);
		} catch (NoSuchAlgorithmException e) {
			throw new Exception("无此算法");
		} catch (InvalidKeySpecException e) {
			throw new Exception("公钥非法");
		} catch (IOException e) {
			throw new Exception("公钥数据内容读取错误");
		} catch (NullPointerException e) {
			throw new Exception("公钥数据为空");
		}
	}
	
	/**
	 * 从字符串中加载私钥
	 * 
	 * @param privateKeyStr
	 * @return 私钥
	 * @throws Exception
	 */
	public static RSAPrivateKey loadPrivateKey(String privateKeyStr) throws Exception {
		try {
			byte[] buffer = base64Decoder.decodeBuffer(privateKeyStr);
			PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(buffer);
			KeyFactory keyFactory = KeyFactory.getInstance(ALGORITHM);
			return (RSAPrivateKey) keyFactory.generatePrivate(keySpec);
		} catch (NoSuchAlgorithmException e) {
			throw new Exception("无此算法");
		} catch (InvalidKeySpecException e) {
			throw new Exception("私钥非法");
		} catch (IOException e) {
			throw new Exception("私钥数据内容读取错误");
		} catch (NullPointerException e) {
			throw new Exception("私钥数据为空");
		}
	}
	
	/**
	 * 私钥转换成C#格式
	 * @param encodedPrivkey
	 * @return
	 */
	public static String getRSAPrivateKeyAsCSharpFormat(RSAPrivateKey privateKey) {
		try {
			PKCS8EncodedKeySpec pvkKeySpec = new PKCS8EncodedKeySpec(privateKey.getEncoded());
			KeyFactory keyFactory = KeyFactory.getInstance(ALGORITHM);
			RSAPrivateCrtKey pvkKey = (RSAPrivateCrtKey) keyFactory.generatePrivate(pvkKeySpec);

			StringBuffer buff = new StringBuffer();
			buff.append("<RSAKeyValue>");
			buff.append("<Modulus>" + encodeBase64(removeMSZero(pvkKey.getModulus().toByteArray())) + "</Modulus>");
			buff.append("<Exponent>" + encodeBase64(removeMSZero(pvkKey.getPublicExponent().toByteArray())) + "</Exponent>");
			buff.append("<P>"+ encodeBase64(removeMSZero(pvkKey.getPrimeP().toByteArray())) + "</P>");
			buff.append("<Q>"+ encodeBase64(removeMSZero(pvkKey.getPrimeQ().toByteArray())) + "</Q>");
			buff.append("<DP>"+ encodeBase64(removeMSZero(pvkKey.getPrimeExponentP().toByteArray())) + "</DP>");
			buff.append("<DQ>"+ encodeBase64(removeMSZero(pvkKey.getPrimeExponentQ().toByteArray())) + "</DQ>");
			buff.append("<InverseQ>"+ encodeBase64(removeMSZero(pvkKey.getCrtCoefficient().toByteArray())) + "</InverseQ>");
			buff.append("<D>"+ encodeBase64(removeMSZero(pvkKey.getPrivateExponent().toByteArray())) + "</D>");
			buff.append("</RSAKeyValue>");
			
			return buff.toString().replaceAll(NEW_LINE_CHARACTER, "");
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * 公钥转成C#格式
	 * @param encodedPrivkey
	 * @return
	 */
	public static String getRSAPublicKeyAsCSharpFormat(RSAPublicKey publicKey) {
		try {
			KeyFactory keyFactory = KeyFactory.getInstance(ALGORITHM);
			RSAPublicKey pukKey = (RSAPublicKey) keyFactory.generatePublic(new X509EncodedKeySpec(publicKey.getEncoded()));
			
			StringBuffer buff = new StringBuffer();
			buff.append("<RSAKeyValue>");
			buff.append("<Modulus>"+ encodeBase64(removeMSZero(pukKey.getModulus().toByteArray())) + "</Modulus>");
			buff.append("<Exponent>"+ encodeBase64(removeMSZero(pukKey.getPublicExponent().toByteArray())) + "</Exponent>");
			buff.append("</RSAKeyValue>");
			
			return buff.toString().replaceAll(NEW_LINE_CHARACTER, "");
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static String getHexString(byte[] b) throws Exception {
	  String result = "";
	  for (int i=0; i < b.length; i++) {
	    result += Integer.toString( ( b[i] & 0xff ) + 0x100, 16).substring( 1 );
	  }
	  return result;
	}

	/**获取密钥对
	 * @return
	 * @throws NoSuchAlgorithmException
	 */
	public static HashMap<String, Object> genKeys() throws NoSuchAlgorithmException {
		HashMap<String, Object> map = new HashMap<String, Object>();
		KeyPairGenerator keyPairGen = KeyPairGenerator.getInstance(ALGORITHM);
		keyPairGen.initialize(KEY_SIZE);
		KeyPair keyPair = keyPairGen.generateKeyPair();
		RSAPublicKey publicKey = (RSAPublicKey) keyPair.getPublic();
		RSAPrivateKey privateKey = (RSAPrivateKey) keyPair.getPrivate();
		map.put(PUBLIC_KEY, publicKey);
		map.put(PRIVATE_KEY, privateKey);
		return map;
	}
	
	/**
	 * @param data
	 * @return
	 */
	public static byte[] removeMSZero(byte[] data) {
		byte[] data1;
		int len = data.length;
		if (data[0] == 0) {
			data1 = new byte[data.length - 1];
			System.arraycopy(data, 1, data1, 0, len - 1);
		} else
			data1 = data;

		return data1;
	}
	
	public static byte[] decodeBase64(String key) throws Exception {
		return base64Decoder.decodeBuffer(key);
	}

	public static String encodeBase64(byte[] key) throws Exception {
		return base64Encoder.encodeBuffer(key);
	}
	
	public static void main(String args[]) throws Exception {
		HashMap map = RSATool.genKeys();
		String java_gy0 = RSATool.encodeBase64(((RSAPublicKey)map.get(PUBLIC_KEY)).getEncoded());
		String java_sy0 = RSATool.encodeBase64(((RSAPrivateKey)map.get(PRIVATE_KEY)).getEncoded());
		System.out.println(java_gy0);
		System.out.println(java_sy0);
		
		String java_gy = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDep+WSz6OtfQLJFiZKh4MYuqHLH3lm6Fxyoq6MAk/aKhUxtjYSmE9M2NLpZ04yLAol7fjbD4gK1fHMVsV4zR0uasZPQQwnsiN3VzEbbps7PMVCfCeNV4wiRLPlnZCy/K+Xw6n8Qqf6WCphKO5Q1EotHXrizkzv33d/IdwNQb4ZWQIDAQAB";
		RSAPublicKey publicKey = RSATool.loadPublicKey(java_gy);
		String cs_gy = RSATool.getRSAPublicKeyAsCSharpFormat(publicKey);
		System.out.println(cs_gy);
		
		String java_sy = "MIICdgIBADANBgkqhkiG9w0BAQEFAASCAmAwggJcAgEAAoGBAN6n5ZLPo619AskWJkqHgxi6ocsfeWboXHKirowCT9oqFTG2NhKYT0zY0ulnTjIsCiXt+NsPiArV8cxWxXjNHS5qxk9BDCeyI3dXMRtumzs8xUJ8J41XjCJEs+WdkLL8r5fDqfxCp/pYKmEo7lDUSi0deuLOTO/fd38h3A1BvhlZAgMBAAECgYASd+K29rog3cmpXEj4zZy2JGTfMFEllAh3Cb9opZhyBCOV6AM8L54ERcfYzFTUHIsK8l497V/fZjeUN25RwtG0rEi+UGQZa5zCAFizQy7Aay2yzR+6V9muC0VJW7nYzcEtdRwWwDgiiO86SnnDxtYvHSIJX+JocEz70CsC4P2WMQJBAPnr70UJ+c+BO6Ib5w74c8mqBtrzf1eShD4RpFA0CkEi4qe4c4XnHk5IzXJ+uxP+sys0pc/tPZSVy2OMJ9dB8ScCQQDkEjMZF8HFtb+EWuva7QRkUELX5qh8fTOMyZh4ubDZ+Q87hHjmP4FhZFhLb9sLXRd1hEiVFUYJ02FerG69iTF/AkAzC/fBODpoIdNWVzCopCKyTCI+UoHuFyUfsGbJYve9OizlaQ1fikdsYf5kpnH7sYhTCNvdTm3HjZkPai8xDmz9AkEAqwa+zK1VAKbnBCCORzB/n53UUkTEyf21P3kZXkaZSQuMkawoYTj0E42E7KTnlKDta5GUQD+gstORa8ZQkM8ljwJAP9b1P1+cUyKBpYmEQ+Dv9N/zgAhQndMFaV+1blvX5OvffZrMNn+Ga4oy0MLldT0YNBl6X3X2ElHbxadOBw/aEA==";
		RSAPrivateKey privateKey = RSATool.loadPrivateKey(java_sy);
		String cs_sy = RSATool.getRSAPrivateKeyAsCSharpFormat(privateKey);
		System.out.println(cs_sy);
		
		String srcStr = "123456";
		String dstStr = RSATool.encodeBase64(RSATool.encryptAll(srcStr.getBytes(), publicKey));
		//String dstStr = RSATool.getHexString(RSATool.encryptAll(srcStr.getBytes("utf-8"), publicKey));
		System.out.println(dstStr);
		srcStr = new String(RSATool.decryptAll(RSATool.decodeBase64(dstStr), privateKey));
		System.out.println(srcStr);
	}
}
