package com.hsnn.medstgmini.base.sys.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hsnn.medstgmini.base.sys.service.SysMessageManager;
import com.hsnn.medstgmini.base.sys.service.SysMessageRecpManager;
import com.hsnn.medstgmini.common.service.impl.GenericManagerImpl;
import com.hsnn.medstgmini.util.Pagination;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.hsnn.medstgmini.base.sys.dao.SysMessageDao;
import com.hsnn.medstgmini.base.sys.model.SysMessage;
import com.hsnn.medstgmini.base.sys.model.SysMessageRecp;

@Service
public class SysMessageManagerImpl extends GenericManagerImpl<SysMessage, String> implements SysMessageManager {

	@Autowired
	private SysMessageDao sysMessageDao;
	
	@Autowired
	private SysMessageRecpManager sysMessageRecpManager;

	@Override
	public Pagination getNoReadList(Pagination page) {
		PageHelper.startPage(page.getPage(), page.getCount());
		Page<SysMessage> departments = sysMessageDao.getNoReadList(page.getConditions());
		page.setRows(departments);
		page.setRecords(departments.getTotal());
		return page;
	}

	// 扩展接口实现
	@Override
	public int addSysMessage(SysMessage sysMessage, SysMessageRecp sysMessageRecp) {
		int i = sysMessageDao.save(sysMessage);
		sysMessageRecp.setMessageId(sysMessage.getMessageId());
		sysMessageRecpManager.add(sysMessageRecp);
		return i;
	}

	
	@Override
	public Pagination getReceList(Pagination page) {
		
		PageHelper.startPage(page.getPage(), page.getCount(), page.getOrderby());
		Page<SysMessage> models = (Page<SysMessage>) sysMessageDao.queryReceAll(page.getConditions());
		page.setRows(models);
		page.setRecords(models.getTotal());
		printLog("查询",page,"分页查询");
		return page;
	}
    
}