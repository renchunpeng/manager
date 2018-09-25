package com.hsnn.medstgmini.base.std.dao;

import org.apache.ibatis.annotations.Param;

import com.hsnn.medstgmini.base.std.model.StdAppointmentSetting;
import com.hsnn.medstgmini.common.dao.GenericDao;

public interface StdAppointmentSettingDao extends GenericDao<StdAppointmentSetting,Integer> {
	int updateByIds(@Param("ids") String[] ids,@Param("model") StdAppointmentSetting setting);
}