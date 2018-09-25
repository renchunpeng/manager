package com.hsnn.medstgmini.base.sys.service;

import com.hsnn.medstgmini.common.service.GenericManager;
import com.hsnn.medstgmini.base.sys.model.SysDatainterfaceLastRequest;
import com.hsnn.medstgmini.base.sys.model.SysDatainterfaceReqRecord;

public interface SysDatainterfaceReqRecordManager extends GenericManager<SysDatainterfaceReqRecord, Integer> {
	// 扩展接口
	/**
	 * 记录接口调用信息  
	 *
	 * @Title: saveInterfaceRequestInfo 
	 * @param sysDatainterfaceReqRecord
	 * @param sysDatainterfaceLastRequest
	 * @param optionType
	 * @return int
	 */
	int saveInterfaceRequestInfo(SysDatainterfaceReqRecord sysDatainterfaceReqRecord, SysDatainterfaceLastRequest sysDatainterfaceLastRequest, Integer optionType);
}