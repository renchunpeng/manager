package com.hsnn.medstgmini.base.std.service.impl;

import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.hsnn.medstgmini.base.std.dao.StdAppointmentSettingDao;
import com.hsnn.medstgmini.base.std.model.StdAppointmentSetting;
import com.hsnn.medstgmini.base.std.service.StdAppointmentSettingManager;
import com.hsnn.medstgmini.common.service.impl.GenericManagerImpl;

@Service
public class StdAppointmentSettingManagerImpl extends GenericManagerImpl<StdAppointmentSetting,Integer> implements StdAppointmentSettingManager {

	@Override
	public int updateByIds(String[] ids, StdAppointmentSetting setting) {
		printLog("批量修改",setting,"根据id:"+JSON.toJSONString(ids));
		return ((StdAppointmentSettingDao)this.getDao()).updateByIds(ids, setting);
	}

}