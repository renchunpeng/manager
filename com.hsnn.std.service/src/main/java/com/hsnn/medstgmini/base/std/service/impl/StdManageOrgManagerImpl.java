package com.hsnn.medstgmini.base.std.service.impl;

import com.hsnn.medstgmini.base.std.model.StdArea;
import com.hsnn.medstgmini.util.SelectForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.hsnn.medstgmini.base.std.dao.StdManageOrgDao;
import com.hsnn.medstgmini.base.std.service.StdManageOrgManager;
import com.hsnn.medstgmini.common.service.impl.GenericManagerImpl;
import com.hsnn.medstgmini.util.Pagination;
import com.hsnn.medstgmini.base.std.model.StdManageOrg;

import java.util.List;

@Service
public class StdManageOrgManagerImpl extends GenericManagerImpl<StdManageOrg, String> implements StdManageOrgManager {
	@Autowired
	private StdManageOrgDao stdManageOrgDao;
	// 扩展接口实现

	@Override
	public Pagination getJgSelectList(Pagination page) {
		// TODO Auto-generated method stub
		PageHelper.startPage(page.getPage(), page.getCount(), page.getOrderby());
		Page<StdManageOrg> stdManageOrg = (Page<StdManageOrg>) stdManageOrgDao.getJgSelectList(page.getConditions());
		page.setRows(stdManageOrg);
		page.setRecords(stdManageOrg.getTotal());
		return page;
	}

	@Override
	public Pagination getJgSendSelectList(Pagination page) {
		// TODO Auto-generated method stub
		PageHelper.startPage(page.getPage(), page.getCount(), page.getOrderby());
		Page<StdManageOrg> stdManageOrg = (Page<StdManageOrg>) stdManageOrgDao.getJgSendSelectList(page.getConditions());
		page.setRows(stdManageOrg);
		page.setRecords(stdManageOrg.getTotal());
		return page;
	}

	@Override
	public StdManageOrg queryStdManageOrgById(String id) {
		// TODO Auto-generated method stub
		return stdManageOrgDao.queryStdManageOrgById(id);
	}

	@Override
	public String getAreaIdByOrgId(String orgId) {
		// TODO Auto-generated method stub
		return stdManageOrgDao.getAreaIdByOrgId(orgId);
	}

	@Override
	public Pagination getManageOrgSelectList(Pagination page) {
		PageHelper.startPage(page.getPage(), page.getCount(), page.getOrderby());
		Page<StdManageOrg> stdManageOrg = (Page<StdManageOrg>) stdManageOrgDao.getManageOrgSelectList(page.getConditions());
		page.setRows(stdManageOrg);
		page.setRecords(stdManageOrg.getTotal());
		return page;
	}

	@Override
	public void updateAccountCode(String id, String zhuSequence) {
		stdManageOrgDao.updateAccountCode(id,zhuSequence);
	}

	//新增疫苗监管
	@Override
	public int getManageOrgName(String _parameter) {

		return stdManageOrgDao.getManageOrgName(_parameter);
	}

	@Override
	public boolean addManageOrg(StdManageOrg stdManageOrg) {
		int count = stdManageOrgDao.addManageOrg(stdManageOrg);
		if(count < 1) {
			return false;
		}
		return true;
	}
	public StdArea getStdAreaByOrgId(String id){
		StdArea stdArea =stdManageOrgDao.getStdAreaByOrgId(id);
		return  stdArea;
	}
}