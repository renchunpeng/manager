package com.hsnn.medstgmini.util;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.RSAPrivateCrtKeySpec;
import java.security.spec.RSAPublicKeySpec;

import javax.crypto.Cipher;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Node;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

@SuppressWarnings("restriction")
public class CcbTool {
	/**
	 * 签名算法 SHA1withRSA
	 */
	public static final String SIGNATURE_ALGORITHM = "MD5withRSA";
	
	private static byte[] decode(String base64EncodedString) {
		BASE64Decoder base64Decoder = new BASE64Decoder();
		try {
			return base64Decoder.decodeBuffer(base64EncodedString);
		} catch (IOException e) {
			return null;
		}
	}

	private static String GetMiddleString(String source, String strHead, String strTail) {
		return GetMiddleString(source, strHead, strTail, false);
	}

	private static String GetMiddleString(String source, String strHead, String strTail, boolean KeepHeadAndTail) {
		try {
			int indexHead, indexTail;

			if (strHead == null || strHead.isEmpty()) {
				indexHead = 0;
			} else {
				indexHead = source.indexOf(strHead);
			}

			if (strTail == null || strTail.isEmpty()) {
				indexTail = source.length();
			} else {
				indexTail = source.indexOf(strTail, indexHead + strHead.length());
			}
			if (indexTail < 0) {
				indexTail = source.length();
			}

			String rtnStr = "";
			if ((indexHead >= 0) && (indexTail >= 0)) {
				if (KeepHeadAndTail) {
					rtnStr = source.substring(indexHead, indexTail + strTail.length());
				} else {
					rtnStr = source.substring(indexHead + strHead.length(), indexTail);
				}
			}
			return rtnStr;
		} catch (Exception ex) {
			return "";
		}
	}

	// 得到私钥
	public static PrivateKey decodePrivateKeyFromXml(String xml) {
		xml = xml.replaceAll("\r", "").replaceAll("\n", "");
		BigInteger modulus = new BigInteger(1, decode(GetMiddleString(xml, "<Modulus>", "</Modulus>")));
		BigInteger publicExponent = new BigInteger(1, decode(GetMiddleString(xml, "<Exponent>", "</Exponent>")));
		BigInteger privateExponent = new BigInteger(1, decode(GetMiddleString(xml, "<D>", "</D>")));
		BigInteger primeP = new BigInteger(1, decode(GetMiddleString(xml, "<P>", "</P>")));
		BigInteger primeQ = new BigInteger(1, decode(GetMiddleString(xml, "<Q>", "</Q>")));
		BigInteger primeExponentP = new BigInteger(1, decode(GetMiddleString(xml, "<DP>", "</DP>")));
		BigInteger primeExponentQ = new BigInteger(1, decode(GetMiddleString(xml, "<DQ>", "</DQ>")));
		BigInteger crtCoefficient = new BigInteger(1, decode(GetMiddleString(xml, "<InverseQ>", "</InverseQ>")));
		RSAPrivateCrtKeySpec rsaPriKey = new RSAPrivateCrtKeySpec(modulus,
				publicExponent, privateExponent, primeP, primeQ,
				primeExponentP, primeExponentQ, crtCoefficient);
		KeyFactory keyf;
		try {
			keyf = KeyFactory.getInstance("RSA");
			return keyf.generatePrivate(rsaPriKey);
		} catch (Exception e) {
			return null;
		}
	}

	// 得到公钥
	public static PublicKey decodePublicKeyFromXml(String xml) {
		xml = xml.replaceAll("\r", "").replaceAll("\n", "");
		BigInteger modulus = new BigInteger(1, decode(GetMiddleString(xml, "<Modulus>", "</Modulus>")));
		BigInteger publicExponent = new BigInteger(1, decode(GetMiddleString(xml, "<Exponent>", "</Exponent>")));
		RSAPublicKeySpec rsaPubKey = new RSAPublicKeySpec(modulus, publicExponent);
		KeyFactory keyf;
		try {
			keyf = KeyFactory.getInstance("RSA");
			return keyf.generatePublic(rsaPubKey);
		} catch (Exception e) {
			return null;
		}
	}

	// 分段解密
	public static String decryptByPrivateKey(String data, RSAPrivateKey privateKey) throws Exception {
		String[] trueValue = data.split("★");
		StringBuffer sb = new StringBuffer();
		for (String item : trueValue) {
			sb.append(decryptByPrivateKey1(item, privateKey));
		}
		return sb.toString();
	}

	/**
	 * 私钥解密
	 * 
	 * @param data
	 *            要解密的数据
	 * @param privateKey
	 *            私钥对象
	 * @return String 解密后的数据
	 * @throws Exception
	 */
	private static String decryptByPrivateKey1(String data,
			RSAPrivateKey privateKey) throws Exception {
		byte[] encryptedData = (new BASE64Decoder()).decodeBuffer(data);
		// 解密
		// 注意Cipher初始化时的参数“RSA/ECB/PKCS1Padding”,代表和.NET用相同的填充算法，如果是标准RSA加密，则参数为“RSA”
		Cipher cipher = Cipher.getInstance("RSA");
		cipher.init(Cipher.DECRYPT_MODE, privateKey);
		int inputLen = encryptedData.length;
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		int offSet = 0;
		byte[] cache;
		int i = 0;
		// 对数据分段解密
		while (inputLen - offSet > 0) {
			if (inputLen - offSet > 128) {
				cache = cipher.doFinal(encryptedData, offSet, 128);
			} else {
				cache = cipher.doFinal(encryptedData, offSet, inputLen - offSet);
			}
			out.write(cache, 0, cache.length);
			i++;
			offSet = i * 128;
		}
		byte[] decryptedData = out.toByteArray();
		out.close();
		return new String(decryptedData, "utf-8");
	}

	/**
	 * 公钥加密
	 * 
	 * @param data1
	 *            要加密的明文
	 * @param publicKey
	 *            公钥对象
	 * @return String 加密后的数据
	 * @throws Exception
	 */
	public static String encryptByPublicKey(String data1, RSAPublicKey publicKey)
			throws Exception {
		Cipher cipher = Cipher.getInstance("RSA");
		cipher.init(Cipher.ENCRYPT_MODE, publicKey);
		int length = data1.length();
		StringBuffer sb = new StringBuffer();
		int start = 0;
		int j = 0;
		String data2 = "";
		while (length - start > 0) {
			if (length - start >= 36) {
				data2 = data1.substring(start, start + 36);
			} else {
				data2 = data1.substring(start, length);
			}
			byte[] data = data2.getBytes("utf-8");
			int inputLen = data.length;
			int offSet = 0;
			byte[] cache;
			int i = 0;
			// 对数据分段加密
			while (inputLen - offSet > 0) {
				if (inputLen - offSet > 117) {
					cache = cipher.doFinal(data, offSet, 117);
				} else {
					cache = cipher.doFinal(data, offSet, inputLen - offSet);
				}
				sb.append((new BASE64Encoder()).encodeBuffer(cache) + "★");
				i++;
				offSet = i * 117;
			}
			j++;
			start = j * 36;
		}
		return sb.substring(0, sb.length() - 1);
	}
	
	/**
	 * 签名
	 * @return
	 */
	private static String sign(String data, RSAPrivateKey privateKey) throws Exception {
		Signature signature = Signature.getInstance(SIGNATURE_ALGORITHM);
		signature.initSign(privateKey);
		signature.update(data.getBytes("UTF-8"));
		return (new BASE64Encoder()).encodeBuffer(signature.sign());
	}

	/**
	 * 验证签名
	 * @param data
	 * @param publicKey
	 * @param signature
	 * @return
	 */
	private static boolean verify(String data, RSAPublicKey publicKey, String sign) throws Exception {
		Signature signature = Signature.getInstance(SIGNATURE_ALGORITHM);
		signature.initVerify(publicKey);
		signature.update(data.getBytes("UTF-8"));
		return signature.verify((new BASE64Decoder()).decodeBuffer(sign));
	}
	
	/**
	 * 组装发送的报文
	 * @param bizName
	 * @param bizXml
	 * @param privateKey
	 * @return
	 * @throws Exception
	 */
	public static String bulidSendXml(String bizName, String bizXml, RSAPublicKey publicKey, RSAPrivateKey privateKey) throws Exception{
		//加密
		String data = encryptByPublicKey(bizXml, publicKey);
		StringBuilder stringBuilder = new StringBuilder();
		//组装报文
		stringBuilder.append("<"+bizName+" xmlns=\"http://ws.apache.org/axis2\"><RequestBody><controlData xmlns=\"http://ip:port/server/getMessage\">");
		stringBuilder.append(data);
		stringBuilder.append("</controlData><key>"+sign(data, privateKey));
		stringBuilder.append("</key></RequestBody></"+bizName+">");
		return stringBuilder.toString();
	}
	
	/**
	 * 组装返回报文
	 * @param bizName
	 * @param flag
	 * @param reason
	 * @param privateKey
	 * @return
	 * @throws Exception
	 */
	public static String[] bulidReturnXml(String bizName, int flag, String reason, RSAPublicKey publicKey, RSAPrivateKey privateKey) throws Exception{
		//flag非0时必须发送出错原因
		if(flag != 0 && (reason == null || reason.trim().length()==0)){
			throw new Exception("flag非0时必须发送出错原因");
		}
		StringBuilder stringBuilder = new StringBuilder();
		// 0接受成功，1失败，2 解析数据错误
		stringBuilder.append("<flag>"+flag+"</flag>");
		stringBuilder.append("<reason>"+reason+"</reason>");
		
		//加密
		String data = encryptByPublicKey(stringBuilder.toString(), publicKey);
		//组装报文
		StringBuilder stringBuilder1 = new StringBuilder();
		stringBuilder1.append("<ns:receiveDocumentCodeResponse xmlns:ns=\"http://ws.apache.org/axis2\"><ns:return xmlns:ns=\"http://ws.apache.org/axis2\">");
		stringBuilder1.append("<"+bizName+" xmlns=\"http://ip:port//receiveDocumentCode/\"><ResponseBody>");
		stringBuilder1.append(data);
		stringBuilder1.append("</ResponseBody><key>"+sign(data, privateKey));
		stringBuilder1.append("</key></"+bizName+"></ns:return></ns:receiveDocumentCodeResponse>");
		return new String[]{stringBuilder.toString(), stringBuilder1.toString()};
	}
	
	/**
	 * 解析请求报文，并解密
	 * @param bizName
	 * @param xml
	 * @return
	 * @throws Exception
	 */
	public static String parseRequestXml(String bizName, String xml, RSAPublicKey publicKey, RSAPrivateKey privateKey) throws Exception{
		//解析XML
		Document doc = org.dom4j.DocumentHelper.parseText(xml);
		Node controlData = doc.selectSingleNode("/*[name()='"+bizName+"']/*[name()='RequestBody']/*[name()='controlData']");
		Node key = doc.selectSingleNode("/*[name()='"+bizName+"']/*[name()='RequestBody']/*[name()='key']");
		if(verify(controlData.getText(), publicKey, key.getText())){
			//解密
			return "<?xml version=\"1.0\" encoding=\"UTF-8\"?><root>"+CcbTool.decryptByPrivateKey(controlData.getText(), privateKey)+"</root>";
		} else {
			throw new Exception("验证签名不通过");
		}
	}
	
	/**
	 * 解析响应报文，并解密
	 * @param bizName
	 * @param xml
	 * @return
	 * @throws Exception
	 */
	public static String parseResponseXml(String bizName, String xml, RSAPublicKey publicKey, RSAPrivateKey privateKey) throws Exception{
		//解析XML
		Document doc = org.dom4j.DocumentHelper.parseText(xml);
		Node responseBody = doc.selectSingleNode("/ns:receiveDocumentCodeResponse/ns:return/*[name()='"+bizName+"']/*[name()='ResponseBody']");
		Node key = doc.selectSingleNode("/ns:receiveDocumentCodeResponse/ns:return/*[name()='"+bizName+"']/*[name()='key']");
		if(verify(responseBody.getText(), publicKey, key.getText())){
			//解密
			return "<?xml version=\"1.0\" encoding=\"UTF-8\"?><root>"+CcbTool.decryptByPrivateKey(responseBody.getText(), privateKey)+"</root>";
		} else {
			throw new Exception("验证签名不通过");
		}
	}
	
	public static String getIds(String data){
		return getSingleNodeText(data, "ids");
	}
	
	public static int getFlag(String data){
		String flag = getSingleNodeText(data, "flag");
		return Integer.parseInt(flag);
	}
	
	public static String getReason(String data){
		return getSingleNodeText(data, "reason");
	}
	
	public static String getSingleNodeText(String data, String nodeName){
		try {
			Document doc = org.dom4j.DocumentHelper.parseText(data);
			return doc.selectSingleNode("/root/"+nodeName).getText();
		} catch (DocumentException e) {
			e.printStackTrace();
		}
		return null;
	}
}
