package com.hsnn.medstgmini.base.sys.service;

import java.util.List;
import java.util.Map;

import javax.jws.WebService;

import com.hsnn.medstgmini.base.sys.model.SysRoleResource;

@WebService
public interface ISysRoleResource {

	/**
	 * @desc  批量插入数据
	 * @param roleResourceList
	 * @return
	 */
	public int addBatch(List<SysRoleResource> roleResourceList);
	
	/**
	 * @desc  批量修改数据
	 * @param roleResourceList
	 * @return
	 */
	public int updateBatch(List<SysRoleResource> roleResourceList);
	
	/**
	 * @desc  批量修改数据
	 * @param roleResourceList
	 * @return
	 */
	public int updateRoleResource(SysRoleResource sysRoleResource);
	
	/**
	 * @desc 根据条件查找数据
	 * @param map
	 * @return
	 */
	public List<SysRoleResource> getroleResourceList(Map<String, Object> map);
	
	
	/**
	 * @desc  根据部门 和 资源id 修改数据
	 * @param roleResourceList
	 * @return
	 */
	public int updateRoleResourceByDept(SysRoleResource sysRoleResource);
	
	/**
	 * 根据条件更新
	 * @param param
	 * @param appointment
	 * @return
	 */
	int updateByParams(Map<String,Object> param,SysRoleResource sysRoleResource);
	
}
