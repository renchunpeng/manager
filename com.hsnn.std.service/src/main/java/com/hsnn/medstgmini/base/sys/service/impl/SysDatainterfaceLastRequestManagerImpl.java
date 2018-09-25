package com.hsnn.medstgmini.base.sys.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hsnn.medstgmini.base.sys.dao.SysDatainterfaceLastRequestDao;
import com.hsnn.medstgmini.base.sys.model.SysDatainterfaceLastRequest;
import com.hsnn.medstgmini.base.sys.service.SysDatainterfaceLastRequestManager;
import com.hsnn.medstgmini.common.service.impl.GenericManagerImpl;

@Service
public class SysDatainterfaceLastRequestManagerImpl extends GenericManagerImpl<SysDatainterfaceLastRequest, Integer> implements SysDatainterfaceLastRequestManager {
	// 扩展接口实现
	
	@Autowired
	private SysDatainterfaceLastRequestDao dao;

	@Override
	public int batchUpdate(List<SysDatainterfaceLastRequest> sysDatainterfaceLastRequestList) {
		return dao.batchUpdate(sysDatainterfaceLastRequestList);
	}
}