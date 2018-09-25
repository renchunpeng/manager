package com.hsnn.medstgmini.base.sys.dao;

import com.github.pagehelper.Page;
import com.hsnn.medstgmini.common.dao.GenericDao;


import java.util.List;
import java.util.Map;

import com.hsnn.medstgmini.base.sys.model.SysDatainterfaceOrganization;

public interface SysDatainterfaceOrganizationDao extends GenericDao<SysDatainterfaceOrganization, Integer> {
	
	List<SysDatainterfaceOrganization> getComList(Map<String, Object> params);
	
	List<SysDatainterfaceOrganization> getHosList(Map<String, Object> params);
	
	
	List<SysDatainterfaceOrganization> getData(Map<String, Object> params);
	
	Page<Map<String, Object>> getCompData(Map<String, Object> map);
	Page<Map<String, Object>> getHospData(Map<String, Object> map);
}