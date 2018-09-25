package com.hsnn.medstgmini.base.sys.dao;

import org.apache.ibatis.annotations.Param;

import com.hsnn.medstgmini.base.sys.model.SysSequence;
import com.hsnn.medstgmini.common.dao.GenericDao;

public interface SysSequenceDao extends GenericDao<SysSequence, String> {
	
	
	SysSequence getSequence(Integer userType);

	void UpdateSequence(@Param(value = "userType")Integer userType, @Param(value = "sequence")String sequence);

}