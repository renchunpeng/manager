package com.hsnn.medstgmini.validator;

import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

/**
 * @category 验证通用类
 * @author 单大伟
 * @date 2015-06-10
 */
public class ValidatorUtil {
	
	private static final Logger log = Logger.getLogger(ValidatorUtil.class);
	private static final String integerRegex = "^[0-9]+$";
	private static final String alphaNummeric = "^[a-zA-Z0-9]+$";
	private static final String alphabet = "^[a-zA-Z]+$";
	private static final String emailRegx = "^([a-zA-Z0-9_\\-\\.]+)@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.)|(([a-zA-Z0-9\\-]+\\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\\]?)$";
	private static final String regexLowerCase = ".*[a-z].*";
	private static final String regexUpperCase = ".*[A-Z].*";
	private static final String regexDigit = ".*[0-9].*";
	private static final String regexSpecialChar = ".*[\\~\\!\\@\\#\\$\\%\\^\\&\\*\\(\\)\\_\\+\\`\\-\\=\\{\\}\\|\\[\\]\\:\\;\\<\\>\\?\\,\\.\\/\\\\\\s].*";
	private static final String domainRegx = "^http://+[a-zA-Z0-9][a-zA-Z0-9.:?/-]*[a-zA-Z]$";
	
	/**
	 * @category 判断是否是大于零的整数
	 * @author 单大伟
	 * @date 2015-06-10
	 * @param String value 被验证的数
	 * @return true  是大于零的整数
	 *         false 不是大于零的整数
	 */
    public static boolean validatePositiveInteger (String value) {

        // Check if the field value is numeric.
        if (isNumber(value)) {
        	// Check if the field value is positive.
        	if(Integer.valueOf(value) > 0)
        	{
        		return true;
        	}
        }
        
        return false;
    }
    
	/**
	 * @category 判断是否是大于零的正数
	 * @author 单大伟
	 * @date 2015-06-10
	 * @param String value 被验证的数
	 * @return true  是大于零的正数
	 *         false 不是大于零的正数
	 */
	public static boolean validatePositiveNumeric(String value) {

		try{
			double parseValue = Double.parseDouble(value);
			if (parseValue > 0) {
				return true;
			}
		} catch (Exception e) {
			log.error("Invalid number.", e);
		}
		
		return false;
	}
    
	/**
	 * @category 判断是否是数字
	 * @author 单大伟
	 * @date 2015-06-10
	 * @param String value 被验证的数
	 * @return true  是数字
	 *         false 不是数字
	 */
	public static boolean isNumber(String value){
    	
    	if (StringUtils.isBlank(value)) {
    		return false;
    	} else if (Pattern.matches(integerRegex, value)) {
    		return true;
    	}
    	return false;
    }
    
	/**
	 * @category 判断是否是实数
	 * @author 单大伟
	 * @date 2015-06-10
	 * @param String input 被验证的数
	 * @return true  是实数
	 *         false 不是实数
	 */
    public static boolean isDouble(String input) {
    	try {
    		double i = Double.parseDouble(input);
    	} catch (Exception e) {
    		log.error("invalid value.", e);
    		return false;
    	}
    	return true;
    }
    
	/**
	 * @category 判断是否是数字字母组合
	 * @author 单大伟
	 * @date 2015-06-10
	 * @param String input 被验证的数
	 * @return true  是数字字母组合
	 *         false 不是数字字母组合
	 */
    public static boolean isAlphaNummeric(String input) {
    	if (Pattern.matches(alphaNummeric, input)) {
    		return true;
    	}
    	return false;
    }
    
	/**
	 * @category 判断是否是字母
	 * @author 单大伟
	 * @date 2015-06-10
	 * @param String input 被验证的数
	 * @return true  是字母
	 *         false 不是字母
	 */
    public static boolean isAlphabets(String input){
    	if (Pattern.matches(alphabet, input)) {
    		return true;
    	}
    	return false;
    }

	/**
	 * @category 判断两个String是否相等
	 * @author 单大伟
	 * @date 2015-06-10
	 * @param String input2 被验证的String
	 * @param String input2 被验证的String
	 * @return true  相等
	 *         false 不等
	 */
    public static boolean equalFields(String input1, String input2){
    	if (input1.equalsIgnoreCase(input2)) {
    		return true;
    	}
    	return false;
    }
    
	/**
	 * @category 判断字符串长度是否是给定的值
	 * @author 单大伟
	 * @date 2015-06-10
	 * @param String input 被验证的String
	 * @param String length 字符串长度
	 * @return true  字符串长度是给定的值
	 *         false 字符串长度不是给定的值
	 */
    public static boolean hasLength(String input, int length){
    	if (input.trim().length() == length) {
    		return true;
    	}
    	return false;
    }
    
	/**
	 * @category 判断字符串长度是否超过给定的值
	 * @author 单大伟
	 * @date 2015-06-10
	 * @param String input 被验证的String
	 * @param String length 字符串长度
	 * @return true  字符串长度超过给定的值
	 *         false 字符串长度没有超过给定的值
	 */
    public static boolean minLength(String input, int length) {
    	if (input.trim().length() >= length) {
    		return true;
    	}
    	return false;
    }
    
	/**
	 * @category 判断字符串长度是否小于给定的值
	 * @author 单大伟
	 * @date 2015-06-10
	 * @param String input 被验证的String
	 * @param String length 字符串长度
	 * @return true  字符串长度小于给定的值
	 *         false 字符串长度不小于给定的值
	 */
    public static boolean maxLength(String input, int length){
    	if (input.trim().length() <= length) {
    		return true;
    	}
    	return false;
    }
    
	/**
	 * @category 判断字符串是否是电子邮件格式
	 * @author 单大伟
	 * @date 2015-06-10
	 * @param String input 被验证的String
	 * @param String length 字符串长度
	 * @return true  字符串是电子邮件格式
	 *         false 字符串不是电子邮件格式
	 */
    public static boolean isEmail(String input){
    	if (Pattern.matches(emailRegx, input)) {
    		return true;
    	}
    	return false;
    }
    
    /**
	 * @category 判断字符串是否是密码格式
	 *           1. 包括大写字母，小写字母，数字和一些特殊字符
	 *           2. 特殊字符支持ANSCII 33 - 126
	 * @author 单大伟
	 * @date 2015-06-10
	 * @param String input 被验证的String
	 * @param String length 密码最小长度
	 * @return true  字符串是密码格式
	 *         false 字符串不是密码格式
	 */
	public static boolean validatePasswordPattern(String value, int minLength) {
		
		// Check the password pattern.

		if (StringUtils.isBlank(value)) {
			boolean containsDigit = false;
			boolean containsLowerCase = false;
			boolean containsUpperCase = false;
			boolean containSpecialChar = false;

			if (value.matches(regexDigit)) {
				containsDigit = true;
			}
			if (value.matches(regexLowerCase)) {
				containsLowerCase = true;
			}
			if (value.matches(regexUpperCase)) {
				containsUpperCase = true;
			}
			if (value.matches(regexSpecialChar)) {
				containSpecialChar = true;
			}

			int containCharKinds = (containsDigit ? 1 : 0) + (containsLowerCase ? 1 : 0) + (containsUpperCase ? 1 : 0) + (containSpecialChar ? 1 : 0);

			if ((containCharKinds >= 3) && (value.length() >= minLength)) {
				return true;
			}
		}
		
		return false;
	}
    
    /**
	 * @category 判断字符串是否是域名
	 * @author 单大伟
	 * @date 2015-06-10
	 * @param String input 被验证的String
	 * @return true  字符串是域名
	 *         false 字符串不是域名
	 */
	public static boolean isDomain(String input) {

    	if (Pattern.matches(domainRegx, input)) {
    		return true;
    	}
    	return false;
    } 
	
	/**
	 * @category 判断是否是大于等于零的整数
	 * @author 单大伟
	 * @date 2015-06-10
	 * @param String value 被验证的数
	 * @return true  是大于等于零的整数
	 *         false 不是大于零的整数
	 */
    public static boolean validatePositiveZeroInteger (String value) {

        // Check if the field value is numeric.
        if (isNumber(value)) {
        	// Check if the field value is positive.
        	if(Integer.valueOf(value) >= 0)
        	{
        		return true;
        	}
        }
        
        return false;
    }
}