package com.hsnn.medstgmini.base.sys.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.hsnn.medstgmini.base.sys.model.SysDate;
import com.hsnn.medstgmini.common.service.GenericManager;



/**
 * 工作日历
 * @author ZXL
 * @date 2016年2月22日11:21:08
 */
public interface SysDateManager extends GenericManager<SysDate, Integer>{
	/**
	 * 根据年份初始化当前年的日历信息
	 * @param year
	 */
	boolean insertInitDate(int year);
	
	/**
	 * 根据日期修改是否是工作日
	 * @param dates
	 * @param isWorkDay
	 * @return
	 */
	int updateByDates(List<Date> dates ,boolean isWorkDay);
	/**
	 * 根据查询参数进行查询
	 * @param params
	 * @return
	 */
	List<SysDate> getList(Map<String, Object> params);
	
	/**
	 * 是否是工作日
	 * @param date
	 * @return
	 */
	boolean isWorkDay(Date date);
	
	/**
	 * 获取n个工作日之后的日期
	 */
	Date getAfterWorkday(int n);
	
	/**
	 * 获取时间段的非工作日
	 * @param minDate
	 * @param maxDate
	 * @return
	 */
	List<Date> getRestdays(Date minDate, Date maxDate);
	
	/**
	 *  获取前工作日
	 *
	 * @Title: getWorkDayBefore 
	 * @param timeNode
	 * @return Date
	 */
	Date getWorkDayBefore(String timeNode);

	Map<String, Object> getWorkDayAndNow();
}
