package com.hsnn.medstgmini.base.sys.service.impl;

import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.hsnn.medstgmini.base.sys.dao.SysOrgResourceForbiddenDao;
import com.hsnn.medstgmini.base.sys.model.SysOrgResourceForbidden;
import com.hsnn.medstgmini.base.sys.service.ISysOrgResourceForbiddenManager;
import com.hsnn.medstgmini.util.Pagination;

@Service
public class SysOrgResourceForbiddenManagerImpl implements ISysOrgResourceForbiddenManager {


	@Autowired
	private SysOrgResourceForbiddenDao sysOrgResourceForbiddenDao;
	
	
	@Override
	public String getOrgList(Pagination page) {
		PageHelper.startPage(page.getPage(), page.getCount(),page.getOrderby());
		List<Map<String, Object>> pagelist = sysOrgResourceForbiddenDao.getOrgList(page.getConditions());
		Page<Map<String, Object>> pages = (Page<Map<String, Object>>) pagelist;
		page.setRows(pages);
		page.setRecords(pages.getTotal());
		JSONObject jsonObject = new JSONObject(page);
		return jsonObject.toString();
	}


	@Override
	public int updateOrgResourct(String orgId,List<SysOrgResourceForbidden> addSysOrgResourceForbiddens,List<SysOrgResourceForbidden> delSysOrgResourceForbiddens) {
		int i = 0;
		if(delSysOrgResourceForbiddens.size() > 0){
			i = sysOrgResourceForbiddenDao.deleteByOrgIdList(delSysOrgResourceForbiddens);
		}
		if(addSysOrgResourceForbiddens.size() > 0){
			i = sysOrgResourceForbiddenDao.insertBatch(addSysOrgResourceForbiddens);
		}
		sysOrgResourceForbiddenDao.deleteDeptResByOrgId(orgId);
		sysOrgResourceForbiddenDao.deleteUserResByOrgId(orgId);
		return i;
	}


	@Override
	public String getRoleResourceList(Map<String, Object> map) {
		JSONArray jsonArray = new JSONArray(sysOrgResourceForbiddenDao.getRoleResourceList(map));
		return jsonArray.toString();
	}
    
	@Override
	public String getList(Pagination page) {
		PageHelper.startPage(page.getPage(), page.getCount(), page.getOrderby());
		Page<SysOrgResourceForbidden> models = (Page<SysOrgResourceForbidden>) sysOrgResourceForbiddenDao.queryAll(page.getConditions());
		page.setRows(models);
		page.setRecords(models.getTotal());
		JSONObject jsonObject = new JSONObject(page);
		return jsonObject.toString();
	}
	
	
	@Override
	public int add(SysOrgResourceForbidden model) {
		
		int saveCount = sysOrgResourceForbiddenDao.save(model);
		return saveCount;
	}
}