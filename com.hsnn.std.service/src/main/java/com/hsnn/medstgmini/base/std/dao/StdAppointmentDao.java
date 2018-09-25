package com.hsnn.medstgmini.base.std.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.hsnn.medstgmini.base.std.model.StdAppointment;
import com.hsnn.medstgmini.common.dao.GenericDao;

public interface StdAppointmentDao extends GenericDao<StdAppointment,Integer> {
	/**
	 * 根据orgId 分组统计
	 * @param map
	 * @return
	 */
	List<Map<String, Object>> queryGroupByOrgId(Map<String, Object> map);
	
	int updateByIds(@Param("ids") String[] ids,@Param("model") StdAppointment appointment);
	
	int updateByParams(@Param("param")Map<String,Object> param,@Param("model") StdAppointment appointment);
}