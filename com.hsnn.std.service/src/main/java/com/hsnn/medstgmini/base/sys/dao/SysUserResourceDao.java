package com.hsnn.medstgmini.base.sys.dao;
import java.util.Map;

import com.hsnn.medstgmini.base.sys.model.SysUserResource;
import com.hsnn.medstgmini.common.dao.GenericDao;

public interface SysUserResourceDao extends GenericDao<SysUserResource, java.lang.Integer> {

	int deleteByParam(Map<String, Object> params);
	/**
	 * @desc 根据部门id 和资源id 修改用户资源
	 * @param sysUserResource
	 * @return
	 */
	int updateUserResourceByDept(SysUserResource sysUserResource);
	void addSysUserResource(SysUserResource sysUserResource);
	
}