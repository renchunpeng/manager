package com.hsnn.medstgmini.util.validate;

import java.math.BigDecimal;
import java.util.regex.Matcher;

import com.hsnn.medstgmini.common.model.ExcelImportTempBean;
import com.hsnn.medstgmini.util.enums.DataState;

public class ValidateImportDataUtil {
	/**
	 * @param regex
	 *            正则表达式字符串
	 * @param str
	 *            要匹配的字符串
	 * @return 如果str 符合 regex的正则表达式格式,返回true, 否则返回 false;
	 */
	private static boolean match(String regex, String str) {
		java.util.regex.Pattern pattern = java.util.regex.Pattern
				.compile(regex);
		Matcher matcher = pattern.matcher(str);
		return matcher.matches();
	}

	/**
	 * 验证输入的电话号码
	 *
	 * @Title: isTelephone
	 * @param str
	 * @return
	 * @return boolean
	 * @throws
	 */
	public static boolean isTelephone(String str) {
		String regex = "^(1\\d{10})|(0[1-9]{2,3}-[0-9]{5,10})|([1-9]{1}[0-9]{5,8})$";
		return match(regex, str);
	}

	/**
	 * 验证输入的邮箱
	 *
	 * @Title: isEmail
	 * @param str
	 * @param title
	 * @return
	 * @return boolean
	 * @throws
	 */
	public static ExcelImportTempBean isEmail(String str, String title,
			String tmpImportId) {
		String regex = "^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\\.[a-zA-Z0-9_-]+)+$";
		boolean isRight = match(regex, str);
		ExcelImportTempBean result = new ExcelImportTempBean();
		if (!isRight) {
			result.setTmpImportDataState(DataState.IS_ERROR.getKey());
			result.setTmpImportDataDescription(title + ":邮箱格式错误！");
			result.setTmpImportId(tmpImportId);
		}
		return result;
	}

	/**
	 * 验证输入的手机号码
	 *
	 * @Title: isMobile
	 * @param str
	 * @return
	 * @return boolean
	 * @throws
	 */
	public static boolean isMobile(String str) {
		String regex = "^[1]+[3,5]+\\d{9}$";
		return match(regex, str);
	}

	/**
	 * 数字验证
	 * 
	 * @param str
	 * @return
	 */
	public static ExcelImportTempBean isNumber(String str, String title, String tmpImportId) {
		java.util.regex.Pattern pattern = java.util.regex.Pattern
				.compile("[0-9]*");
		java.util.regex.Matcher match = pattern.matcher(str.trim());
		boolean isRight = match.matches();

		ExcelImportTempBean result = new ExcelImportTempBean();
		if (!isRight) {
			result.setTmpImportDataState(DataState.IS_ERROR.getKey());
			result.setTmpImportDataDescription(title + ":数值不正确！");
			result.setTmpImportId(tmpImportId);
		}
		return result;
	}
	
	/**
	 * 价格验证
	 * 
	 * @param str
	 * @return
	 */
	public static ExcelImportTempBean isBigDecimal(BigDecimal str,String title,  String tmpImportId) {
		String outString=str.toString();
		String regex = "^((\\d*)|(\\d*.[0-9]{1,3}))";
		boolean isRight = match(regex,outString);
		ExcelImportTempBean result = new ExcelImportTempBean();
		if(!isRight) {
			result.setTmpImportDataState(DataState.IS_ERROR.getKey());
			result.setTmpImportDataDescription(title + ":数值不正确！");
			result.setTmpImportId(tmpImportId);
		}
		return result;
	}
}
