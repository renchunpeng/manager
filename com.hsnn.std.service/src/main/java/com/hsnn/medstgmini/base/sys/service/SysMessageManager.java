package com.hsnn.medstgmini.base.sys.service;

import com.hsnn.medstgmini.common.service.GenericManager;
import com.hsnn.medstgmini.util.Pagination;
import com.hsnn.medstgmini.base.sys.model.SysMessage;
import com.hsnn.medstgmini.base.sys.model.SysMessageRecp;

public interface SysMessageManager extends GenericManager<SysMessage, String> {
	// 扩展接口
	Pagination getNoReadList(Pagination page);

	int addSysMessage(SysMessage sysMessage,SysMessageRecp sysMessageRecp);
 
	/**
	 * 获取分页数据
	 * @param page
	 * @return
	 */
	Pagination getReceList(Pagination page);
 
}