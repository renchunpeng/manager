package com.hsnn.medstgmini.base.sys.service;

import java.util.List;

import com.hsnn.medstgmini.base.sys.model.SysDatainterfaceLastRequest;
import com.hsnn.medstgmini.common.service.GenericManager;

public interface SysDatainterfaceLastRequestManager extends GenericManager<SysDatainterfaceLastRequest, Integer> {
	// 扩展接口
	int batchUpdate(List<SysDatainterfaceLastRequest> sysDatainterfaceLastRequestList );
}