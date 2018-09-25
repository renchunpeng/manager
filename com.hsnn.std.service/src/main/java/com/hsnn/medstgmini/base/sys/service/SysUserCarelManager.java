package com.hsnn.medstgmini.base.sys.service;

import java.util.List;
import java.util.Map;

import com.hsnn.medstgmini.base.sys.model.SysUserCarel;
import com.hsnn.medstgmini.common.service.GenericManager;
import com.hsnn.medstgmini.util.Pagination;

public interface SysUserCarelManager extends GenericManager<SysUserCarel, String> {

	Pagination getCaUserCodeList(Pagination page);

	List<SysUserCarel> checkRepeat(String caCode);

	SysUserCarel getValidateId(Map<String, String> map);

	
	
	
	
	
	
}