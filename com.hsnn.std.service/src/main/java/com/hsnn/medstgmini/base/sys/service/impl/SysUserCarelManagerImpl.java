package com.hsnn.medstgmini.base.sys.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.hsnn.medstgmini.base.sys.dao.SysUserCarelDao;
import com.hsnn.medstgmini.base.sys.model.SysUserCarel;
import com.hsnn.medstgmini.base.sys.service.SysUserCarelManager;
import com.hsnn.medstgmini.common.service.impl.GenericManagerImpl;
import com.hsnn.medstgmini.util.Pagination;

@Service
public class SysUserCarelManagerImpl extends GenericManagerImpl<SysUserCarel, String> implements SysUserCarelManager {

	@Autowired
	private SysUserCarelDao sysUserCarelDao;
	
	
	@Override
	public Pagination getCaUserCodeList(Pagination page) {
		// TODO Auto-generated method stub
		PageHelper.startPage(page.getPage(), page.getCount(), page.getOrderby());
		Page<SysUserCarel> usercacode = (Page<SysUserCarel>) sysUserCarelDao.getCaUserCodeList(page.getConditions());
		page.setRows(usercacode);
		page.setRecords(usercacode.getTotal());
		return page;
	}


	@Override
	public List<SysUserCarel> checkRepeat(String caCode) {
		// TODO Auto-generated method stub
		return sysUserCarelDao.checkRepeat(caCode);
	}


	@Override
	public SysUserCarel getValidateId(Map<String, String> map) {
		// TODO Auto-generated method stub
		return sysUserCarelDao.getValidateId(map);
	}
	
    
}