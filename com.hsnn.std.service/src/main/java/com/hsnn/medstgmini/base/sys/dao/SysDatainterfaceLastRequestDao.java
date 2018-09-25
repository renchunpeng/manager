package com.hsnn.medstgmini.base.sys.dao;

import java.util.List;

import com.hsnn.medstgmini.base.sys.model.SysDatainterfaceLastRequest;
import com.hsnn.medstgmini.common.dao.GenericDao;

public interface SysDatainterfaceLastRequestDao extends GenericDao<SysDatainterfaceLastRequest, Integer> {


	/**
	 * 批量更新
	 * @param ids
	 * @param sysDatainterfaceLastRequest
	 * @return 受影响的行数
	 * */
	int batchUpdate(List<SysDatainterfaceLastRequest> sysDatainterfaceLastRequestList);

}