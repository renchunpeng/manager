package com.hsnn.medstgmini.base.std.service;

import com.hsnn.medstgmini.base.std.model.StdGmpgsp;
import com.hsnn.medstgmini.common.service.GenericManager;

public interface StdGmpgspManager extends GenericManager<StdGmpgsp, Integer> {
	// 扩展接口
	
	/**
	 * 批量更新GMPGSP状态 
	 *
	 * @Title: batchUpdate 
	 * @param ids
	 * @param stdGmpgsp
	 * @return 
	 * @return boolean
	 * @throws
	 */
	boolean batchUpdate(String[] ids, StdGmpgsp stdGmpgsp);
	
	int updateStdGmpgsp(StdGmpgsp stdGmpgsp);
}