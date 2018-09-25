package com.hsnn.medstgmini.util;

import java.math.BigDecimal;

import org.apache.commons.lang.StringUtils;

public class ParseNumber {
	public static Double toDouble(String s) {
		try {
			double d = Double.parseDouble(s);
			return new Double(d);
		} catch (Exception e) {
			return null;
		}
	}

	public static Float toFloat(String s) {
		try {
			float f = Float.parseFloat(s);
			return new Float(f);
		} catch (Exception e) {
			return null;
		}
	}

	public static Long toLong(String s) {
		try {
			long l = Long.parseLong(s);
			return new Long(l);
		} catch (Exception e) {
			return null;
		}
	}

	public static Integer toInteger(String s) {
		try {
			int i = Integer.parseInt(s);
			return new Integer(i);
		} catch (Exception e) {
			return null;
		}
	}

	public static Byte toByte(String s) {
		try {
			byte b = Byte.parseByte(s);
			return new Byte(b);
		} catch (Exception e) {
			return null;
		}
	}

	@SuppressWarnings("null")
	public static short toShort(String s) {
		try {
			short b = Short.parseShort(s);
			return new Short(b);
		} catch (Exception e) {
			return (Short) null;
		}
	}
	/**
	 * 
	 * @category 格式化字符，保留两位小数（四舍五入）
	 * @author 邱磊
	 * @date 2015年7月1日 上午8:45:13
	 * @param s
	 * @return
	 */
	public static Double toDecimal(String s) {
		try {
			BigDecimal b = new BigDecimal(s);
			double f = b.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
			return f;
		} catch (Exception e) {
			return null;
		}
	}
	/**
	 * 
	 *@category 将double类型数据转换成两位小数的字符串(不管小数是几位，永远都显示两位：如13会显示13.00)
	 *@author 邱磊
	 *@date 2015年7月2日 下午6:40:19
	 *@param d
	 *@return
	 */
	public static String toStrDecimal(Double d){
		try {
			String f = String.format("%.2f", d);
			return f;
		} catch (Exception e) {
			return null;
		}
	}
	
	public static String toStrDecimal(Double d, int w){
		try {
			String f = String.format("%."+ w +"f", d);
			return f;
		} catch (Exception e) {
			return null;
		}
	}
	/**
	 * 
	 *@category 乱码转换
	 *@author 应晓川
	 *@date 2015年8月31日20:13:09
	 *@param 
	 *@return
	 */
	public static String toMessyCode(String str){
		try {
			return  new String (str.getBytes("iso-8859-1"),"utf-8" );
		} catch (Exception e) {
			return null;
		}
	}
	
	/**
	 * 
	 * @param str 需要格式化的数字
	 * @param len 保留小数点后len位
	 * @return
	 */
	public static String stringToFormat(String str,int len){
		StringBuffer holdStr = new StringBuffer();
		if(StringUtils.isBlank(str)) {
			return  holdStr.append("0.").append(rightZero("",len)).toString();
		}
		String[] strs =  str.split("\\.");
		if(strs.length==1) {
			holdStr.append(str).append(".").append(rightZero("",len));
		}else {
			holdStr.append(strs[0]).append(".").append(rightZero(strs[1],len));
		}
		return holdStr.toString();
	}
	public static StringBuffer rightZero(String decimalPart,int len) {
		StringBuffer sb = new StringBuffer(decimalPart);
		while(sb.length()<len) {
			sb.append("0");
		}
		return new StringBuffer(sb.substring(0, len));
	}
	
}
