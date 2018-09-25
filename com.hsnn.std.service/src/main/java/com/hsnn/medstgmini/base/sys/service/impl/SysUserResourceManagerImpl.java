package com.hsnn.medstgmini.base.sys.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hsnn.medstgmini.base.sys.dao.SysUserResourceDao;
import com.hsnn.medstgmini.base.sys.model.SysUserResource;
import com.hsnn.medstgmini.base.sys.service.ISysUserResource;

@Service
public class SysUserResourceManagerImpl  implements ISysUserResource {

	@Autowired
	private SysUserResourceDao sysUserResourceDao;

	public int addinsertBatch(List<SysUserResource> list) {
		return sysUserResourceDao.insertBatch(list);
	}

	public int deleteByParam(Map<String, Object> params) {
		return sysUserResourceDao.deleteByParam(params);
	}

	public int updateUserResourceByDept(SysUserResource sysUserResource) {
		return sysUserResourceDao.updateUserResourceByDept(sysUserResource);
	}
	
}


