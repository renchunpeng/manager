package com.hsnn.medstgmini.base.sys.dao;

import java.util.List;
import java.util.Map;

import com.github.pagehelper.Page;
import com.hsnn.medstgmini.base.sys.model.SysMessage;
import com.hsnn.medstgmini.common.dao.GenericDao;

public interface SysMessageDao extends GenericDao<SysMessage, String> {
	
	
	List<SysMessage> queryReceAll(Map<String, Object> map);
	Page<SysMessage> getNoReadList(Map<String,Object> map);

}
