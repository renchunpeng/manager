package com.hsnn.medstgmini.base.sys.service;

import java.util.List;
import java.util.Map;

import com.hsnn.medstgmini.base.sys.model.SysDatainterfaceLastRequest;
import com.hsnn.medstgmini.base.sys.model.SysDatainterfaceOrganization;
import com.hsnn.medstgmini.common.service.GenericManager;
import com.hsnn.medstgmini.util.Pagination;

public interface SysDatainterfaceOrganizationManager extends GenericManager<SysDatainterfaceOrganization, Integer> {
	// 扩展接口
	
	/**
	 * 
	 * @param model
	 * @return
	 */
	int add(SysDatainterfaceOrganization sdo,List<SysDatainterfaceLastRequest> reList);
	/**
	 * 
	 * @param model
	 * @return
	 */
	int add(List<SysDatainterfaceOrganization> sdoList,List<SysDatainterfaceLastRequest> reList);
	
	/**
	 * 根据id修改不为空的数据
	 * @param model
	 * @return
	 */
	int updateBySelective(SysDatainterfaceOrganization sdo ,List<SysDatainterfaceLastRequest> reList);
	/**
	 * 获取企业分页数据
	 * @param page
	 * @return
	 */
	Pagination getComList(Pagination page);
	/**
	 * 根据企业查询获取数据
	 * @param params
	 * @return
	 */
	List<SysDatainterfaceOrganization> getComList(Map<String,Object> params);
	

	/**
	 * 获取医疗机构分页数据
	 * @param page
	 * @return
	 */
	Pagination getHosList(Pagination page);
	/**
	 * 根据查询获取医疗机构数据
	 * @param params
	 * @return
	 */
	List<SysDatainterfaceOrganization> getHosList(Map<String,Object> params);
	
	Pagination getCompData(Pagination pagination);
	Pagination getHospData(Pagination pagination);
	
	
	Pagination getData(Pagination page);
	
	List<SysDatainterfaceOrganization> getData(Map<String,Object> params);
}