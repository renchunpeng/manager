package com.hsnn.medstgmini.base.sys.dao;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.hsnn.medstgmini.base.sys.model.SysRoleResource;
import com.hsnn.medstgmini.common.dao.GenericDao;

public interface SysRoleResourceDao extends GenericDao<SysRoleResource, java.lang.Integer> {
	
	int updateBatch(List<SysRoleResource> list);
	
	int updateRoleResource(SysRoleResource sysRoleResource);
	
	int updateRoleResourceByDept(SysRoleResource sysRoleResource);
	
	int updateByParams(@Param("param")Map<String,Object> param,@Param("model") SysRoleResource sysRoleResource);
	
	
	
	List<SysRoleResource> getResource(Integer userType);
	List<String> getRolePrivilegeList(Integer userType);
	void addPrivilege(SysRoleResource sysRoleResource);

	int saveRoleResource(SysRoleResource sysRoleResource);
}