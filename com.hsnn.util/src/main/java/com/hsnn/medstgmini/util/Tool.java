package com.hsnn.medstgmini.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public final class Tool {

	/**
	 * 返回去除前后空格，避免空指针
	 * @param str
	 * @return
	 */
	public static String parseString(String str) {
		return str == null ? "" : str.trim();
	}
	
	/**
	 * 返回去除前后空格，避免空指针
	 * @param obj
	 * @return
	 */
	public static String parseString(Object obj) {
		return obj == null ? "" : obj.toString().trim();
	}
	
	/**
	 * 日期加减天数
	 * @param dateYMDHMS - 日期字符串（yyyy-MM-dd HH:mm:ss）
	 * @param days - 要加减的天数
	 * @return 返回加减后的日期（yyyy-MM-dd）
	 * @throws ParseException
	 */
	public static String addDate(String dateYMDHMS, int days) throws ParseException {
		return addDate(dateYMDHMS, "yyyy-MM-dd HH:mm:ss", "days", days);
	}
	
	/**
	 * 日期加减天数、小时、分钟
	 * @param dateYMDHMS - 日期字符串（格式为format指定的格式）
	 * @param format - 指定dateYMDHMS的日期格式
	 * @param unit - 日期加减的单位（可以是天数、小时、分钟）
	 * @param number - 要加减的数量
	 * @return 返回加减后的日期（格式为format指定的格式）
	 * @throws ParseException
	 */
	public static String addDate(String dateYMDHMS, String format, String unit, int number) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		sdf.setLenient(false);
		Date dateSource = sdf.parse(dateYMDHMS);
		return sdf.format(addDate(dateSource, unit, number));
	}
	
	/**
	 * 日期加减
	 * @param dateSource - 日期
	 * @param unit - 日期加减的单位（年月日小时分钟）。例如，day或days:天；hour或hours:小时……
	 * @param number - 要加减的数量，负数为减。
	 * @return 返回加减后的日期
	 */
	public static Date addDate(Date dateSource, String unit, int number) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(dateSource);
		if (unit.equalsIgnoreCase("year") || unit.equalsIgnoreCase("years")) {
			calendar.add(Calendar.YEAR, number);
		} else if (unit.equalsIgnoreCase("month")
				|| unit.equalsIgnoreCase("months")) {
			calendar.add(Calendar.MONTH, number);
		} else if (unit.equalsIgnoreCase("day")
				|| unit.equalsIgnoreCase("days")) {
			calendar.add(Calendar.DATE, number);
		} else if (unit.equalsIgnoreCase("hour")
				|| unit.equalsIgnoreCase("hours")) {
			calendar.add(Calendar.HOUR, number);
		} else if (unit.equalsIgnoreCase("minute")
				|| unit.equalsIgnoreCase("minutes")) {
			calendar.add(Calendar.MINUTE, number);
		}
		return calendar.getTime();
	}
}
