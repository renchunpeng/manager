package com.hsnn.medstgmini.base.std.service;

import java.util.Date;

import com.hsnn.medstgmini.base.std.enums.AppointmentDealTimeinterval;
import com.hsnn.medstgmini.base.std.model.StdAppointment;
import com.hsnn.medstgmini.common.service.GenericManager;
import com.hsnn.medstgmini.util.Pagination;

/**
 * 
 * 预约信息管理
 *@author ZXL
 *@date 2016年2月25日10:45:25
 */
public interface StdAppointmentManager extends GenericManager<StdAppointment, Integer> {
	/**
	 * 获取预约号
	 * @param appointmentType	预约类型
	 * @param appointmentArrivalDatetime 预约时间
	 * @param appointmentDealTimeinterval 预约时间段
	 * @return
	 *  null 不允许预约或者已预约完毕
	 */
	public Integer getAppointmentNumber(int appointmentType,Date appointmentArrivalDatetime,int appointmentDealTimeinterval);
	/**
	 * 获取剩余的数量
	 * @param appointmentType	预约类型
	 * @param appointmentArrivalDatetime 预约时间
	 * @param appointmentDealTimeinterval 预约时间段
	 * @return
	 *  null 不允许预约或者已预约完毕
	 */
	public Integer getSurplusAppointmentNumber(int appointmentType,
			Date appointmentArrivalDatetime, int appointmentDealTimeinterval);
	
	/**
	 * 根据orgid 分组获取预约信息
	 * @param map
	 * @return
	 */
	Pagination queryGroupByOrgId(Pagination page);
	
	int updateByIds(String[] ids,StdAppointment appointment);
	
	void expiredProcess(AppointmentDealTimeinterval dealTimeinterval);
	/**
	 * 根据企业ID获取过期数
	 * @param companyId
	 * @return
	 */
	int overdueCount(String companyId);
}