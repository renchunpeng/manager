package com.hsnn.medstgmini.base.sys.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hsnn.medstgmini.base.sys.dao.SysRoleResourceDao;
import com.hsnn.medstgmini.base.sys.model.SysRoleResource;
import com.hsnn.medstgmini.base.sys.service.ISysRoleResource;

@Service
public class SysRoleResourceManagerImpl implements ISysRoleResource {
	
	@Autowired
	private SysRoleResourceDao sysRoleResourceDao;
	
	
	public int addBatch(List<SysRoleResource> roleResourceList){
		return sysRoleResourceDao.insertBatch(roleResourceList);
	}
	
	public List<SysRoleResource> getroleResourceList(Map<String, Object> map){
		return sysRoleResourceDao.queryAll(map);
	}

	@Override
	public int updateBatch(List<SysRoleResource> roleResourceList) {
		
		return sysRoleResourceDao.updateBatch(roleResourceList);
	}

	@Override
	public int updateRoleResource(SysRoleResource sysRoleResource) {
		return sysRoleResourceDao.updateRoleResource(sysRoleResource);
	}

	@Override
	public int updateRoleResourceByDept(SysRoleResource sysRoleResource) {
		return sysRoleResourceDao.updateRoleResourceByDept(sysRoleResource);
	}
	
	@Override
	public int updateByParams(Map<String, Object> param,
			SysRoleResource sysRoleResource) {
		return sysRoleResourceDao.updateByParams(param, sysRoleResource);
	}

}
