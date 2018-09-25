
package com.hsnn.medstgmini.base.std.dao;

import org.apache.ibatis.annotations.Param;

import com.hsnn.medstgmini.base.std.model.StdGmpgsp;
import com.hsnn.medstgmini.common.dao.GenericDao;

public interface StdGmpgspDao  extends GenericDao<StdGmpgsp, Integer> {
	// 扩展自定义查询
	/**
	 * 批量更新GMPGSP状态  
	 *
	 * @Title: batchUpdate 
	 * @param ids
	 * @param stdGmpgsp
	 * @return 
	 * @return int
	 * @throws
	 */
	int batchUpdate(@Param("ids") String[] ids, @Param("stdGmpgsp") StdGmpgsp stdGmpgsp);
	
	int updateStdGmpgsp(StdGmpgsp stdGmpgsp);
}
