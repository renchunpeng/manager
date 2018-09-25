package com.hsnn.medstgmini.base.sys.dao;

import java.util.Date;
import java.util.Map;

import com.hsnn.medstgmini.base.sys.model.SysDate;
import com.hsnn.medstgmini.common.dao.GenericDao;

public interface SysDateDao extends GenericDao<SysDate, java.lang.Integer>{
	int deleteByParam(Map<String, Object> params);
	int updateByParam(Map<String, Object> params);
	
	/**
	 *  获取前工作日
	 *
	 * @Title: getWorkDayBefore 
	 * @param timeNode
	 * @return Date
	 */
	Date getWorkDayBefore(String timeNode);
	
	/**
	 *  获取当前时间以及是否是工作日
	 *
	 * @Title: getWorkDayBefore 
	 * @param timeNode
	 * @return Date
	 */
	Map<String,Object> getWorkDayAndNow();
}