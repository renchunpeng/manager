package com.hsnn.medstgmini.base.sys.service;

import java.util.List;
import java.util.Map;

import javax.jws.WebService;

import com.hsnn.medstgmini.base.sys.model.SysOrgResourceForbidden;
import com.hsnn.medstgmini.util.Pagination;

@WebService
public interface ISysOrgResourceForbiddenManager {
	// 扩展接口
	
	/**
	 * 得到所有机构的数据  医疗 企业  监管
	 * 获取分页数据
	 * @param page
	 * @return
	 */
	String getOrgList(Pagination page);
	
	int updateOrgResourct(String orgId,List<SysOrgResourceForbidden> addSysOrgResourceForbiddens,List<SysOrgResourceForbidden> delSysOrgResourceForbiddens);
	
	String getRoleResourceList(Map<String, Object> map);
	
	/**
	 * 获取分页数据
	 * @param page
	 * @return
	 */
	String getList(Pagination page);
	
	/**
	 * 新增
	 * @param model
	 * @return
	 */
	int add(SysOrgResourceForbidden model);
}