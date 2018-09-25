package com.hsnn.medstgmini.yimiao.service.impl;

import java.util.List;
import java.util.Map;

import com.hsnn.medstgmini.yimiao.dao.YimiaoCompanyPsDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.hsnn.medstgmini.common.service.impl.GenericManagerImpl;
import com.hsnn.medstgmini.util.Pagination;
import com.hsnn.medstgmini.yimiao.dao.YimiaoCompanyDao;
import com.hsnn.medstgmini.yimiao.model.YimiaoCompany;
import com.hsnn.medstgmini.yimiao.service.YimiaoCompanyManager;

@Service
public class YimiaoCompanyManagerImpl extends GenericManagerImpl<YimiaoCompany, String> implements YimiaoCompanyManager{

	@Autowired
	private YimiaoCompanyDao dao;

	@Autowired
	private YimiaoCompanyPsDao yimiaoCompanyPsDao;
	
	@Override
	public Pagination getYimiaoCompList(Pagination page) {
		try {
			PageHelper.startPage(page.getPage(), page.getCount());
			Page<YimiaoCompany> YimiaoCompanines = dao.getYimiaoComp(page.getConditions());
			page.setRows(YimiaoCompanines);
			page.setRecords(YimiaoCompanines.getTotal());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return page;
	}

	@Override
	public YimiaoCompany getYimiaoCompanyById(String companyId) {
		return dao.getYimiaoCompanyById(companyId);
	}

	@Override
	public String getCompIdByUName(String uname) {
		return dao.getCompIdByUName(uname);
	}

	@Override
	public Pagination getAllList(Pagination page) {
		PageHelper.startPage(page.getPage(), page.getCount());
		Page<YimiaoCompany> models = dao.getAllList(page.getConditions());
		page.setRows(models);
		page.setRecords(models.getTotal());
		printLog("查询",page,"分页查询");
		return page;
	}

	@Override
	public int updateStart(String companyId) {
		return dao.updateStart(companyId);
	}
	@Override
	public int updateStartsc(String companyId) {
		return dao.updateStartsc(companyId);
	}

	@Override
	public int updateDisable(String companyId) {
		return dao.updateDisable(companyId);
	}
	@Override
	public int updateDisablesc(String companyId) {
		return dao.updateDisablesc(companyId);
	}

	@Override
	public List<Map<String, Object>> getExportExcelData(Map<String, Object> map) {
		List<Map<String,Object>> list = dao.getExportExcelData(map);
		return list;
		
	}

	@Override
	public int getCompanyName(String _parameter) {
		
		return dao.getCompanyName(_parameter);
	}

	@Override
	public boolean addCompanyQy(YimiaoCompany yimiaoCompany) {
		int i = dao.insertQy(yimiaoCompany);
		if(i > 0) {
			return true;
		}else {
			return false;
		}
	}

	@Override
	public void updateAccountCode(String companyId, String accountCode) {
		
		dao.updateAccountCode(companyId,accountCode);
	}

	@Override
	public boolean addYimiaoCompanyPs(String yimiaoCompanyPs) {
		boolean row=false;
		try {
			yimiaoCompanyPsDao.saveYimiaoCompanyPs(yimiaoCompanyPs);
			row=true;
		}catch (Exception e) {
			e.printStackTrace();
		}

		return row;
	}


}
