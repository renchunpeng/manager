package com.hsnn.medstgmini.base.sys.dao;

import java.util.List;
import java.util.Map;

import com.hsnn.medstgmini.base.sys.model.SysOrgResourceForbidden;
import com.hsnn.medstgmini.common.dao.GenericDao;

public interface SysOrgResourceForbiddenDao extends GenericDao<SysOrgResourceForbidden, Integer> {
	
   List<Map<String, Object>> getOrgList(Map<String, Object> map);
   
	int deleteByOrgIdList(List<SysOrgResourceForbidden> delList);
	
	int deleteDeptResByOrgId(String orgId);
	
	int deleteUserResByOrgId(String orgId);
	
	 List<Map<String, Object>> getRoleResourceList(Map<String, Object> map);
}