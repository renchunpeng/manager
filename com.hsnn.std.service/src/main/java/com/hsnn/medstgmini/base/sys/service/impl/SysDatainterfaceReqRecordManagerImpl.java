package com.hsnn.medstgmini.base.sys.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hsnn.medstgmini.base.sys.service.SysDatainterfaceLastRequestManager;
import com.hsnn.medstgmini.base.sys.service.SysDatainterfaceReqRecordManager;
import com.hsnn.medstgmini.common.service.impl.GenericManagerImpl;
import com.hsnn.medstgmini.util.enums.OptionType;
import com.hsnn.medstgmini.base.sys.dao.SysDatainterfaceReqRecordDao;
import com.hsnn.medstgmini.base.sys.model.SysDatainterfaceLastRequest;
import com.hsnn.medstgmini.base.sys.model.SysDatainterfaceReqRecord;

@Service
public class SysDatainterfaceReqRecordManagerImpl extends GenericManagerImpl<SysDatainterfaceReqRecord, Integer> implements SysDatainterfaceReqRecordManager {
	@Autowired
	private SysDatainterfaceLastRequestManager sysDatainterfaceLastRequestManager;
	// 扩展接口实现
	/**
	 * 记录接口调用信息  
	 *
	 * @Title: saveInterfaceRequestInfo 
	 * @param sysDatainterfaceReqRecord
	 * @param sysDatainterfaceLastRequest
	 * @param optionType
	 * @return int
	 */
	public int saveInterfaceRequestInfo(SysDatainterfaceReqRecord sysDatainterfaceReqRecord, SysDatainterfaceLastRequest sysDatainterfaceLastRequest, Integer optionType) {
		int saveNum = 0;
		SysDatainterfaceReqRecordDao sysDatainterfaceReqRecordDao = (SysDatainterfaceReqRecordDao)getDao();
		saveNum = sysDatainterfaceReqRecordDao.save(sysDatainterfaceReqRecord);
		if(OptionType.UPDATE.getKey().equals(optionType)) {
			sysDatainterfaceLastRequestManager.updateBySelective(sysDatainterfaceLastRequest);
		} else if(OptionType.ADD.getKey().equals(optionType)) {
			sysDatainterfaceLastRequestManager.add(sysDatainterfaceLastRequest);
		}
		return saveNum;
	}
}