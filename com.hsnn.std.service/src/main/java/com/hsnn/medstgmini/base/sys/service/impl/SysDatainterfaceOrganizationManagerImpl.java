package com.hsnn.medstgmini.base.sys.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.hsnn.medstgmini.base.sys.dao.SysDatainterfaceOrganizationDao;
import com.hsnn.medstgmini.base.sys.model.SysDatainterfaceLastRequest;
import com.hsnn.medstgmini.base.sys.model.SysDatainterfaceOrganization;
import com.hsnn.medstgmini.base.sys.service.SysDatainterfaceLastRequestManager;
import com.hsnn.medstgmini.base.sys.service.SysDatainterfaceOrganizationManager;
import com.hsnn.medstgmini.common.service.impl.GenericManagerImpl;
import com.hsnn.medstgmini.util.Pagination;

@Service
public class SysDatainterfaceOrganizationManagerImpl extends GenericManagerImpl<SysDatainterfaceOrganization, Integer> implements SysDatainterfaceOrganizationManager {

	@Autowired
	private SysDatainterfaceOrganizationDao dao;
	@Autowired
	private SysDatainterfaceLastRequestManager sysDatainterfaceLastRequestManager;
	
	@Override
	public Pagination getComList(Pagination page) {
		PageHelper.startPage(page.getPage(), page.getCount(), page.getOrderby());
		Page<SysDatainterfaceOrganization> models = (Page<SysDatainterfaceOrganization>) dao.getComList(page.getConditions());
		page.setRows(models);
		page.setRecords(models.getTotal());
		printLog("查询",page,"分页查询");
		return page;
	}

	@Override
	public List<SysDatainterfaceOrganization> getComList(Map<String, Object> params) {
		return  dao.getComList(params);
	}

	@Override
	public Pagination getHosList(Pagination page) {
		PageHelper.startPage(page.getPage(), page.getCount(), page.getOrderby());
		Page<SysDatainterfaceOrganization> models = (Page<SysDatainterfaceOrganization>) dao.getHosList(page.getConditions());
		page.setRows(models);
		page.setRecords(models.getTotal());
		printLog("查询",page,"分页查询");
		return page;
	}

	@Override
	public List<SysDatainterfaceOrganization> getHosList(Map<String, Object> params) {
		return  dao.getHosList(params);
	}

	@Override
	public Pagination getCompData(Pagination pagination) {
		PageHelper.startPage(pagination.getPage(), pagination.getCount());
		Page<Map<String,Object>> models = dao.getCompData(pagination.getConditions());
		pagination.setRows(models);
		pagination.setRecords(models.getTotal());
		printLog("查询",pagination,"分页查询");
		return pagination;
	}

	@Override
	public Pagination getHospData(Pagination pagination) {
		PageHelper.startPage(pagination.getPage(), pagination.getCount());
		Page<Map<String,Object>> models = dao.getHospData(pagination.getConditions());
		pagination.setRows(models);
		pagination.setRecords(models.getTotal());
		printLog("查询",pagination,"分页查询");
		return pagination;
	}

	@Override
	public Pagination getData(Pagination page) {
		PageHelper.startPage(page.getPage(), page.getCount(), page.getOrderby());
		Page<SysDatainterfaceOrganization> models = (Page<SysDatainterfaceOrganization>) dao.getData(page.getConditions());
		page.setRows(models);
		page.setRecords(models.getTotal());
		printLog("查询",page,"分页查询");
		return page;
	}

	@Override
	public List<SysDatainterfaceOrganization> getData(Map<String, Object> params) {
		return dao.getData(params);
	}

	public int add(SysDatainterfaceOrganization sdo, List<SysDatainterfaceLastRequest> reList) {
		int i = dao.save(sdo);
		sysDatainterfaceLastRequestManager.insertBatch(reList);
		return i;
	}

	@Override
	public int updateBySelective(SysDatainterfaceOrganization sdo,List<SysDatainterfaceLastRequest> reList) {
		int i = dao.updateBySelective(sdo);
		sysDatainterfaceLastRequestManager.batchUpdate(reList);
		return i;
	}

	@Override
	public int add(List<SysDatainterfaceOrganization> sdoList, List<SysDatainterfaceLastRequest> reList) {
		int i = dao.insertBatch(sdoList);
		sysDatainterfaceLastRequestManager.insertBatch(reList);
		return i;
	}


}