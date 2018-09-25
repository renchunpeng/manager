package com.hsnn.medstgmini.yimiao.service.impl;

import java.util.Date;
import java.util.Map;

import com.hsnn.medstgmini.yimiao.dao.YimiaoCompanyPsDao;
import com.hsnn.medstgmini.yimiao.model.YimiaoCompanyPs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.hsnn.medstgmini.util.Pagination;
import com.hsnn.medstgmini.yimiao.dao.YimiaoDelrelationshipDao;
import com.hsnn.medstgmini.yimiao.model.YimiaoCompany;
import com.hsnn.medstgmini.yimiao.model.YimiaoDelrelationship;
import com.hsnn.medstgmini.yimiao.service.YimiaoCompanyManager;
import com.hsnn.medstgmini.yimiao.service.YimiaoDelrelationshipManager;

@Service
public class YimiaoDelrelationshipManagerImpl implements YimiaoDelrelationshipManager{

	@Autowired
	private YimiaoDelrelationshipDao dao;

	@Autowired
	private YimiaoCompanyPsDao yimiaoCompanyPsDao;
	
	@Autowired
	private YimiaoCompanyManager yimiaoCompanyManager; 
	
	@Override
	public Pagination getYimiaoDelrelationshipList(Pagination page) {
		try {
			PageHelper.startPage(page.getPage(), page.getCount());
			Page<YimiaoDelrelationship> relation = dao.findRelation(page.getConditions());
			page.setRows(relation);
			page.setRecords(relation.getTotal());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return page;
	}

	@Override
	public boolean addYimiaoDelrelationship(Map<String,Object> map) {
		boolean row=false;
		try {
			YimiaoCompany sc=yimiaoCompanyManager.getYimiaoCompanyById(map.get("prodCompCode").toString());
			YimiaoCompany ps=yimiaoCompanyManager.getYimiaoCompanyById(map.get("delCompCode").toString());
			YimiaoDelrelationship relation=new YimiaoDelrelationship(sc.getCompanyId(), sc.getCompanyName()
					, sc.getCompSpelCode(), sc.getIsUsing(), ps.getCompanyId(), ps.getCompanyName()
					, ps.getCompSpelCode(), ps.getIsUsing(), map.get("userId").toString(), new Date());
			dao.insertRelation(relation);
			row=true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return row;
	}
	
	@Override
	public boolean delYimiaoDelrelationship(Map<String,Object> map) {
		boolean row=false;
		try {
			dao.deleteRelation(map);
			row=true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return row;
	}

	/**
	 *
	 * @param page
	 * @return
	 */
	@Override
	public Pagination yimiaoCompanyPs(Pagination page) {
		try {
			PageHelper.startPage(page.getPage(), page.getCount());
			Page<YimiaoCompanyPs> relation = yimiaoCompanyPsDao.getYimiaoCompanyPsList(page.getConditions());
			page.setRows(relation);
			page.setRecords(relation.getTotal());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return page;
	}


}
