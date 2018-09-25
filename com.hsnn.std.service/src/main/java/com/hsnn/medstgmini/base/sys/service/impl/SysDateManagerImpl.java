package com.hsnn.medstgmini.base.sys.service.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.hsnn.medstgmini.base.sys.dao.SysDateDao;
import com.hsnn.medstgmini.base.sys.model.SysDate;
import com.hsnn.medstgmini.base.sys.service.SysDateManager;
import com.hsnn.medstgmini.common.service.impl.GenericManagerImpl;
import com.hsnn.medstgmini.util.Pagination;
import com.hsnn.medstgmini.util.SessionUtil;

@Service
public class SysDateManagerImpl extends GenericManagerImpl<SysDate, Integer> implements SysDateManager {
	
	@Override
	public boolean insertInitDate(int year) {
		//默认的周末
	   	int[] week = {1,7};
    	 int yearNum = Integer.valueOf(year);
    	 Calendar sc = Calendar.getInstance();
    	 sc.clear();
    	 sc.set(Calendar.YEAR ,yearNum);
    	 Calendar ec = Calendar.getInstance();
    	 ec.clear();
    	 ec.set(Calendar.YEAR ,yearNum+1);
    	 
    	 Map<String, Object> params = new HashMap<String, Object>();
    	 params.put("startDate", sc.getTime());
    	 params.put("endDate", ec.getTime());
    	 ((SysDateDao)getDao()).deleteByParam(params);//清理数据
    	 
    	 List<SysDate> dates = new ArrayList<SysDate>();
    	 while (sc.before(ec)) {
    		 SysDate sd = new SysDate();
    		boolean weekday = true;
  			for (int i : week) {
 				if(i == sc.get(Calendar.DAY_OF_WEEK)){
 					weekday=false;
 				}
 			}
  			
  			sd.setIsWorkDay(weekday);
  			sd.setDayValue(sc.getTime());
  			
  			dates.add(sd);
  			
  			sc.add(Calendar.DATE, 1); 
    	 }
    	 insertBatch(dates);
		return true;
	}

	@Override
	public int updateByDates(List<Date> dates, boolean isWorkDay) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("dates", dates);
		params.put("isWorkDay", isWorkDay);
		params.put("lastUpdateUserId", SessionUtil.getSysUser().getUserId());
		params.put("lastUpdateUserName", SessionUtil.getSysUser().getUserName());
		
		return ((SysDateDao)getDao()).updateByParam(params);
	}

	@Override
	public List<SysDate> getList(Map<String, Object> params) {
		return ((SysDateDao)getDao()).queryAll(params);
	}
	
	@Override
	public boolean isWorkDay(Date date) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("dayValue", date);
		List<SysDate> sysDate = ((SysDateDao)getDao()).queryAll(params);
		
		return sysDate.size()>0?sysDate.get(0).getIsWorkDay():false;
	}

	@Override
	public Date getAfterWorkday(int n) {
		Pagination pagination = new Pagination();
		pagination.getConditions().put("startDate", new Date());
		pagination.getConditions().put("isWorkDay", 1);
		pagination.setCount(1);
		pagination.setPage(n);
		List<SysDate> list = (List<SysDate>) getList(pagination).getRows();
		if(list.size()==1){
			return list.get(0).getDayValue();
		}
		return null;
	}

	@Override
	public List<Date> getRestdays(Date minDate, Date maxDate) {
		List<Date> dates = new ArrayList<Date>();
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("startDate", minDate);
		params.put("endDate", maxDate);
		params.put("isWorkDay", 0);
		List<SysDate> list = getList(params);
		for (SysDate sysDate : list) {
			dates.add(sysDate.getDayValue());
		}
		return dates;
	}
	
	/**
	 *  获取前工作日
	 *
	 * @Title: getWorkDayBefore 
	 * @param timeNode
	 * @return Date
	 */
	public Date getWorkDayBefore(String timeNode) {
		return ((SysDateDao) getDao()).getWorkDayBefore(timeNode);
	}
	
	/**
	 *  获取当前时间以及是否是工作日
	 *
	 * @Title: getWorkDayBefore 
	 * @param timeNode
	 * @return Date
	 */
	@Override
	public Map<String,Object> getWorkDayAndNow(){
		return ((SysDateDao) getDao()).getWorkDayAndNow();
	}
}
