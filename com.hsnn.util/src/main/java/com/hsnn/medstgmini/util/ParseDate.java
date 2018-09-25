package com.hsnn.medstgmini.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class ParseDate {

	/**
	 * 转换短日期格式的字符串为日期.
	 * 
	 * @param s
	 *            yyyy-MM-dd
	 * @return Date
	 */
	public static Date fromShortFormat(final String s) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date d = sdf.parse(s);
			return d;
		} catch (ParseException e) {
			return null;
		}
	}
	

	/**
	 * 转换全日期格式的字符串为日期.
	 * 
	 * @param s
	 *            yyyy-MM-dd HH:mm:ss
	 * @return Date
	 */
	public static Date fromFullFormat(final String s) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			Date d = sdf.parse(s);
			return d;
		} catch (ParseException e) {
			return null;
		}
	}
	
	public static Date fromFullFormatst(final String s) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		try {
			Date d = sdf.parse(s);
			return d;
		} catch (ParseException e) {
			return null;
		}
	}

	/**
	 * 转换短日期格式(年月)的字符串为日期.
	 * 
	 * @param s
	 *            yyyy-MM
	 * @return Date
	 */
	public static Date fromYearMonthFormat(final String s) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
		try {
			Date d = sdf.parse(s);
			return d;
		} catch (ParseException e) {
			return null;
		}
	}

	/**
	 * 转换短日期格式(年月)的字符串为日期.
	 * 
	 * @param s
	 *            yyyy-MM
	 * @return Date
	 */
	public static String fromYearMonthFormat(final Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
		try {
			String d = sdf.format(date);
			return d;
		} catch (Exception e) {
			return null;
		}
	}
	/**
	 * 转换短格式日期
	 * 
	 * @param String
	 *            yyyy-MM-dd
	 * @return Date
	 */
	public static String parseShortFormat(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		return sdf.format(date);
	}
	public static String parseYMDFormat(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		return sdf.format(date);
	}
	/**
	 * 转换短格式日期年
	 * 
	 * @param String
	 *            yyyy-MM-dd
	 * @return Date
	 */
	public static String parseShortYearFormat(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
		return sdf.format(date);
	}
	/**
	 * 转换短格式日期月
	 * 
	 * @param String
	 *            yyyy-MM-dd
	 * @return Date
	 */
	public static String parseShortMonthFormat(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat("MM");
		return sdf.format(date);
	}
	/**
	 * 转换短格式日期年月
	 * 
	 * @param String
	 *            yyyy-MM-dd
	 * @return Date
	 */
	public static String parseYearMonthFormat(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
		return sdf.format(date);
	}
	/**
	 * 
	 * @param date
	 * yyyy-MM-dd HH:mm
	 * @return
	 */
	public static String parseShortsFormat(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		return sdf.format(date);
	}
	
	/**
	 * 
	 * @param date
	 * yyyy-MM-dd HH:mm
	 * @return
	 */
	public static String parseShortsFormatYMDH(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH");
		return sdf.format(date);
	}
	
	
	
	/**
	 * 
	 * @param date
	 * yyyy年-MM月-dd日
	 * @return
	 */
	public static String parseShortFormat2(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy年-MM月-dd日");
		return sdf.format(date);
	}

	/**
	 * 转换全格式日期
	 * 
	 * @param Date
	 * @return String yyyy-MM-dd HH:mm:ss
	 */
	public static String parseFullFormat(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return sdf.format(date);
	}

	/**
	 * 转换为数字 格式（20100505143757）
	 * 
	 * @param date
	 * @return
	 */
	public static Long parseWithNum(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		return new Long(sdf.format(date));
	}
	public static Long parseWithNumhh(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmm");
		return new Long(sdf.format(date));
	}

	/**
	 * 获取时间差
	 * 
	 * @param old
	 * @param now
	 * @return
	 */
	public static Long compareWithDay(Date old, Date now) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
		return new Long(sdf.format(now)) - new Long(sdf.format(old));
	}
	
	public static String parseShortFormatsHHSS(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
		return sdf.format(date);
	}
	
	public static String parseShortFormatsHHmmSS(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
		return sdf.format(date);
	}
	
	/**
	 * 获取当前星期几
	 * @param nowDate 今天日期 yyyy-MM-dd
	 * @return
	 */
	public static String getWeekDay(String nowDate){
		Date date= new Date(); 
        SimpleDateFormat d= new SimpleDateFormat("yyyy-MM-dd"); 
        try { 
            date= d.parse(nowDate); //自己定义的时间　或者可以接string 参数 
            SimpleDateFormat liuzm = new SimpleDateFormat("E"); 
            String  mydate=liuzm.format(date);// 
            return mydate;
        } catch (Exception e) { 
            e.printStackTrace(); 
        } 
        return null;
	}
	
	public static boolean stringIsNull(String param)
    {
        return (null == param) || ("".equals(param.trim()));
    }
	
	/**
     * 根据日期获取日期的中国式描述
     * 
     * @author WeiZhongJun Dec 7, 2010 5:39:48 PM
     * @param paramDate 参数日期
     * @return String
     */
    public static String getDateDescibe(Date paramDate)
    {
        try
        {
            Date currentDate = new Date();

            // 当前时间和参数时间的毫秒差
            Long interval = currentDate.getTime() - paramDate.getTime();
            
            if (interval < 0)
            {
                return "1秒前";
            }

            // 参数时间为多少秒
            Long seconds = interval / 1000;
            // 参数时间为多少分钟
            Long minutes = interval / 60000;
            // // 参数时间为多少小时
            // Long hours = interval / 3600000;

            // 当前时间的字符串形式
            String nowDateStr = FormatDate.toFullFormat(currentDate);

            // 参数时间的字符串形式
            String paramDateStr = FormatDate.toFullFormat(paramDate);

            if (stringIsNull(nowDateStr) || stringIsNull(paramDateStr))
            {
                return "1秒前";
            }

            if (seconds < 1)
            {
                return "1秒前";
            }

            // 如果秒数小于60
            if (seconds < 60)
            {
                return seconds + "秒前";
            }

            // 如果分钟数小于60
            if (minutes < 60)
            {
                return minutes + "分钟前";
            }

            // // 如果小时数小于24
            // if (hours < 24)
            // {
            // return hours + "小时前";
            // }

            // 参数日期的年份
            String year = paramDateStr.substring(0, 4);
            // 当前年份
            String nowYear = nowDateStr.substring(0, 4);

            // 参数日期的月份
            Long month = ParseNumber.toLong(paramDateStr.substring(5, 7));
            // 当前月份
            Long nowMonth = ParseNumber.toLong(nowDateStr.substring(5, 7));

            // 参数日期几号
            Long date = ParseNumber.toLong(paramDateStr.substring(8, 10));
            // 当前几号
            Long nowDate = ParseNumber.toLong(nowDateStr.substring(8, 10));

            // 参数日期的小时分钟：格式为： XX:XX
            String hourMinute = paramDateStr.substring(10, 16);

            // 年份相同只展示几月几日，小时分钟
            if (nowYear.equals(year))
            {
                // 月份，几号都相同
                if (nowMonth.equals(month) && nowDate.equals(date))
                {
                    return "今天" + hourMinute;
                }

                return month + "月" + date + "日" + hourMinute;
            }

            return year + "年" + month + "月" + date + "日" + hourMinute;
        }
        catch (Exception e)
        {
            return "1秒前";
        }
    }
    
    
    /** 
     * 得到本月第一天的日期 
     * @Methods Name getFirstDayOfMonth 
     * @return Date 
     */  
    public static Date getFirstDayOfMonth(Date date)   {
        Calendar cDay = Calendar.getInstance();     
        cDay.setTime(date);  
        cDay.set(Calendar.DAY_OF_MONTH, 1);  
        return cDay.getTime();     
    } 
    /** 
     * 得到本月第二天的日期 
     * @Methods Name getFirstDayOfMonth 
     * @return Date 
     */  
    public static Date getSecondDayOfMonth(Date date)   {     
        Calendar cDay = Calendar.getInstance();     
        cDay.setTime(date);  
        cDay.set(Calendar.DAY_OF_MONTH, 2);  
        return cDay.getTime();     
    } 
    /** 
     * 得到本月最后一天的日期 
     * @Methods Name getLastDayOfMonth 
     * @return Date 
     */  
    public static Date getLastDayOfMonth(Date date)   {     
        Calendar cDay = Calendar.getInstance();     
        cDay.setTime(date);  
        cDay.set(Calendar.DAY_OF_MONTH, cDay.getActualMaximum(Calendar.DAY_OF_MONTH));  
        return cDay.getTime();     
    }
    /**
     * 
     *@category 在日期上增加天数
     *@author 邱磊
     *@date 2015年7月9日 下午2:23:16
     *@param date
     *@param days
     *@return
     */
    @SuppressWarnings("static-access")
	public static Date addDate(Date date, int days){
         Calendar calendar = new GregorianCalendar(); 
         calendar.setTime(date); 
         calendar.add(calendar.DATE,days);
         date=calendar.getTime();
         return date;
    }
    
    /***
     * 上个月最后一天
     * @return
     */
    public static String getLastMonthDay() {
        Calendar cal = Calendar.getInstance();
        Date date = new Date();
        cal.setTime(date);
        cal.add(Calendar.MONTH, -1);
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH)+1; // 上个月月份
        int day = cal.getActualMaximum(Calendar.DAY_OF_MONTH); // 结束天数
        String endDay = year + "-" + month + "-" + day;
        return endDay;
    }
    
    /**
     *求两个日期差
     *@param beginDate  开始日期
     *@param endDate   结束日期
     *@return 两个日期相差天数
     */
   public static long GetDateMargin(Date beginDate,Date endDate){
       long margin = 0;

       margin = endDate.getTime() - beginDate.getTime();

       margin = margin/(1000*60*60*24);

       return margin;
   }
   /**
	 * @category 将日期转为yyyy-MM-dd日期
	 * @author 韩守松
	 * @date   2015年11月25日
	 * @param  @param d
	 * @param  @return
     * @throws ParseException 
	 */
	public static Date dateToDate(final Date d){
		if (d == null) {
			return null;
		}
		Date da = new Date();
		try {
			SimpleDateFormat format= new SimpleDateFormat("yyyy-MM-dd"); 
			String date = format.format(d);
			 da =  format.parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return da;
	}
	
	/**
	 * @category 将日期转为yyyy-MM-dd HH:mm:ss日期
	 * @author 韩守松
	 * @date   2015年11月25日
	 * @param  @param d
	 * @param  @return
     * @throws ParseException 
	 */
	public static Date dateToDateTime(final Date d){
		if (d == null) {
			return null;
		}
		Date da = new Date();
		try {
			SimpleDateFormat format= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
			String date = format.format(d);
			 da =  format.parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return da;
	}
	
	/**
	 * @category 将日期转为yyyy-MM-dd HH:mm:ss日期(日期比较 结束日期)
	 * @author 韩守松
	 * @date   2015年11月25日
	 * @param  @param d
	 * @param  @return
     * @throws ParseException 
	 */
	public static Date dateToEndDateTime(final Date d){
		if (d == null) {
			return null;
		}
		Date da = new Date();
		try {
			SimpleDateFormat format= new SimpleDateFormat("yyyy-MM-dd"); 
			String date = format.format(d);
			date = date + " 23:59:59";
			SimpleDateFormat formatTime= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
			 da =  formatTime.parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return da;
	}
	/**
	 * 日期类型转换成yyyyMMdd字符串
	 * 
	 * @param Date date 
	 * 
	 * @return Date
	 */
	public static String parseDateToYmd(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		return sdf.format(date);
	}
	
	/**
     * 
     *@category 在日期上增加月数
     *@author 李龙
     *@date 2015年12月03日
     *@param date
     *@param month
     *@return
     */
    @SuppressWarnings("static-access")
	public static Date addMonth(Date date, int month){
         Calendar calendar = new GregorianCalendar(); 
         calendar.setTime(date); 
         calendar.add(calendar.MONTH,month);
         date=calendar.getTime();
         return date;
    }
    
    /**
     * 
     *@category 在日期上增加年
     *@author 李龙
     *@date 2015年12月03日
     *@param date
     *@param month
     *@return
     */
    @SuppressWarnings("static-access")
	public static Date addYear(Date date, int year){
         Calendar calendar = new GregorianCalendar(); 
         calendar.setTime(date); 
         calendar.add(calendar.YEAR,year);
         date=calendar.getTime();
         return date;
    }
    
    /**
	 * 日期类型转换成yyyyMM字符串
	 * 
	 * @param Date date 
	 * 
	 * @return Date
	 */
	public static String parseDateToYm(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMM");
		return sdf.format(date);
	}
	
	
	/**
     * 
     *@category 得到日期所在季度
     *@author 李龙
     *@date 2015年12月04日
     *@param date
     *@return 例如201401
     */
    public static String getSea(Date date){
         Calendar calendar = new GregorianCalendar(); 
         calendar.setTime(date);
         int month = calendar.get(Calendar.MONTH) + 1;
         String sea = "";
         if(month == 1 || month ==2 || month ==3){
        	 sea = calendar.get(Calendar.YEAR)+"01";
         }
         else if(month == 4 || month ==5 || month ==6){
        	 sea = calendar.get(Calendar.YEAR)+"02";
         }
         else if(month == 7 || month ==8 || month ==9){
        	 sea = calendar.get(Calendar.YEAR)+"03";
         }
         else if(month == 10 || month ==11 || month ==12){
        	 sea = calendar.get(Calendar.YEAR)+"04";
         }
         return sea;
    }
    
    /**
     * 区分两个日期之间月份的差值
     * @param startTime  开始时间
     * @param endTime  结束时间
     * @return 计算后的月数
     */
    public static float getFieldDifference(Date startTime, Date endTime) {
        Calendar startCalendar = Calendar.getInstance();
        startCalendar.setTime(startTime);
        Calendar endCalendar = Calendar.getInstance();
        endCalendar.setTime(endTime);
        int startYear = startCalendar.get(Calendar.YEAR);
        int startMonth = startCalendar.get(Calendar.MONTH);
        int startDay=startCalendar.get(Calendar.DATE);
        
        int endYear = endCalendar.get(Calendar.YEAR);
        int endMonth = endCalendar.get(Calendar.MONTH);
        int endDay=endCalendar.get(Calendar.DATE);
        
        int  month= ((endYear - startYear) * 12 + (endMonth - startMonth));
        
        float result=(month*30+endDay-startDay)/30f;
        return result;
    }
    
    public static void main(String[] args){
    	Date startTime =new Date();
    	Date endTime=fromShortFormat("2016-06-24");
    	float count=getFieldDifference(startTime,endTime);
    	boolean isSuccess=count<0;
    	System.out.println(count+"\t"+isSuccess);
    }
}
