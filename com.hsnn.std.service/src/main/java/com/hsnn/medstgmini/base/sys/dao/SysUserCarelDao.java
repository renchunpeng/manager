package com.hsnn.medstgmini.base.sys.dao;


import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.github.pagehelper.Page;
import com.hsnn.medstgmini.base.sys.model.SysUserCarel;
import com.hsnn.medstgmini.common.dao.GenericDao;

public interface SysUserCarelDao extends GenericDao<SysUserCarel, String> {

	Page<SysUserCarel> getCaUserCodeList(Map<String, Object> conditions);

	List<SysUserCarel> checkRepeat(@Param("caCode")String caCode);

	SysUserCarel getValidateId(Map<String, String> map);
	
	
	
}