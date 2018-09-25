package com.hsnn.medstgmini.base.sys.service;

import java.util.List;
import java.util.Map;

import javax.jws.WebService;

import com.hsnn.medstgmini.base.sys.model.SysUserResource;

@WebService
public interface ISysUserResource {
	int addinsertBatch(List<SysUserResource> list);
	
	int deleteByParam(Map<String,Object> params);
	
	int updateUserResourceByDept(SysUserResource sysUserResource);
	
}
