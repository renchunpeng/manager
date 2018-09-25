package com.hsnn.medstgmini.base.std.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.hsnn.medstgmini.base.std.dao.StdAppointmentDao;
import com.hsnn.medstgmini.base.std.enums.AppointmentDealTimeinterval;
import com.hsnn.medstgmini.base.std.enums.AppointmentStatus;
import com.hsnn.medstgmini.base.std.model.StdAppointment;
import com.hsnn.medstgmini.base.std.model.StdAppointmentSetting;
import com.hsnn.medstgmini.base.std.service.StdAppointmentManager;
import com.hsnn.medstgmini.base.std.service.StdAppointmentSettingManager;
import com.hsnn.medstgmini.common.service.impl.GenericManagerImpl;
import com.hsnn.medstgmini.util.Pagination;

@Service
public class StdAppointmentManagerImpl extends GenericManagerImpl<StdAppointment, Integer> implements StdAppointmentManager {
	@Autowired
	private StdAppointmentSettingManager stdAppointmentSettingManager; 
	
	@Override
	public Integer getAppointmentNumber(int appointmentType,
			Date appointmentArrivalDatetime, int appointmentDealTimeinterval) {
		StdAppointmentSetting setting = stdAppointmentSettingManager.getById(appointmentType);
		Integer result = null;
		//if(setting.getIsUsing() && setting.getEndTime().after(appointmentArrivalDatetime) && setting.getBeginTime().before(appointmentArrivalDatetime)){
		if(setting.getIsUsing() && setting.getBeginTime().getTime() <= appointmentArrivalDatetime.getTime() && appointmentArrivalDatetime.getTime() <= setting.getEndTime().getTime()){
			Map<String,Object> params = new HashMap<String, Object>();
			params.put("appointmentType", appointmentType);
			params.put("appointmentArrivalDatetime", appointmentArrivalDatetime);
			params.put("appointmentDealTimeinterval", appointmentDealTimeinterval);
			params.put("notAppointmentStatus", 2);
			int count = this.getDao().queryAll(params).size();
			switch (appointmentDealTimeinterval) {
			case 1:
				result = setting.getLimitNumberBefore10Morning() -count;
				break;
			case 2:
				result = setting.getLimitNumberAfter10Morning() -count;
				break;
			case 3:
				result = setting.getLimitNumberBefore15Afternoon() -count;
				break;
			case 4:
				result = setting.getLimitNumberAfter15Afternoon() -count;
				break;
			default:
				break;
			}
			if(result>0){
				return count+1;
			}
			return null;
		}
		return result;
	}
	public Integer getSurplusAppointmentNumber(int appointmentType,
			Date appointmentArrivalDatetime, int appointmentDealTimeinterval) {
		StdAppointmentSetting setting = stdAppointmentSettingManager.getById(appointmentType);
		Integer result = null;
		if(setting.getIsUsing() && setting.getBeginTime().getTime() <= appointmentArrivalDatetime.getTime() && appointmentArrivalDatetime.getTime() <= setting.getEndTime().getTime()){
			Map<String,Object> params = new HashMap<String, Object>();
			params.put("appointmentType", appointmentType);
			params.put("appointmentArrivalDatetime", appointmentArrivalDatetime);
			params.put("appointmentDealTimeinterval", appointmentDealTimeinterval);
			params.put("notAppointmentStatus", 2);
			int count = this.getDao().queryAll(params).size();
			switch (appointmentDealTimeinterval) {
			case 1:
				result = setting.getLimitNumberBefore10Morning() -count;
				break;
			case 2:
				result = setting.getLimitNumberAfter10Morning() -count;
				break;
			case 3:
				result = setting.getLimitNumberBefore15Afternoon() -count;
				break;
			case 4:
				result = setting.getLimitNumberAfter15Afternoon() -count;
				break;
			default:
				break;
			}
		}
		return result;
	}
	@Override
	public Pagination queryGroupByOrgId(Pagination page) {
		printLog("查询",page,"根据企业统计预约");
		PageHelper.startPage(page.getPage(), page.getCount());
		Page models = (Page) this.getDao().queryGroupByOrgId(page.getConditions());
		page.setRows(models);
		page.setRecords(models.getTotal());
		return page;
	}
	
	@Override
	public int updateByIds(String[] ids, StdAppointment appointment) {
		printLog("批量修改",appointment,"根据ID:"+JSON.toJSONString(ids));

		return this.getDao().updateByIds(ids, appointment);
	}
	
	@Override
	public void expiredProcess(AppointmentDealTimeinterval dealTimeinterval) {
		Map<String,Object> params = new HashMap<String, Object>();
		params.put("endAppointmentArrivalDatetime", new Date());
		params.put("appointmentDealTimeinterval", dealTimeinterval.getKey());
		params.put("appointmentStatus", AppointmentStatus.SUBMIT.getKey());
		StdAppointment appointment = new StdAppointment();
		appointment.setAppointmentStatus(AppointmentStatus.OVERDUE.getKey());
		int count = this.getDao().updateByParams(params, appointment);
		printLog("预约过期处理",dealTimeinterval,"共处理"+count+"条");
	}
	@Override
	public int overdueCount(String companyId) {
		Map<String,Object> params = new HashMap<String, Object>();
		params.put("orgId", companyId);
		params.put("appointmentStatus",AppointmentStatus.OVERDUE.getKey() );
		int count = this.getLists(params).size();
		printLog("获取逾期数",companyId,"逾期数量"+count+"条");
		return count;
	}
	
	@Override
	public StdAppointmentDao getDao() {
		return super.getDao();
	}
}
