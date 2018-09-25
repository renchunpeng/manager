package com.hsnn.medstgmini.base.std.service;

import com.hsnn.medstgmini.base.std.model.StdAppointmentSetting;
import com.hsnn.medstgmini.common.service.GenericManager;

/**
 * 
 * 预约申请的设置
 *@author ZXL
 *@date 2016年2月25日10:45:25
 */
public interface StdAppointmentSettingManager extends GenericManager<StdAppointmentSetting, Integer> {
	int updateByIds(String[] ids,StdAppointmentSetting setting);
}