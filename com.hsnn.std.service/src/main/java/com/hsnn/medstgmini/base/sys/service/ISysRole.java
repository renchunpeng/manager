package com.hsnn.medstgmini.base.sys.service;

import java.util.List;
import java.util.Map;

import javax.jws.WebService;

import com.hsnn.medstgmini.base.sys.model.SysRole;
import com.hsnn.medstgmini.base.sys.model.SysRoleResource;

@WebService
public interface ISysRole {
	
	/**
	 * @category 根据角色id获取角色数据
	 * @author 韩守松
	 * @date   2016年2月23日
	 * @param  @param roleId
	 * @param  @return
	 */
	SysRole getRoleById(Integer roleId);
	
	/**
	 * @category 根据机构id获取医疗机构信息
	 * @author 韩守松
	 * @date   2016年2月23日
	 * @param  @param orgId
	 * @param  @return
	 */
	Map<String,Object> getOrgHospDataById(String orgId);
	
	/**
	 * @category 根据机构id获取企业机构信息
	 * @author 韩守松
	 * @date   2016年2月23日
	 * @param  @param orgId
	 * @param  @return
	 */
	Map<String,Object> getOrgCompDataById(String orgId);
	
	
	/**
	 * @category 新增角色（单表）
	 * @author wangs
	 * @param  @return
	 */
	boolean addRole(SysRole sysRole);
	
	/**
	 * @category 新增角色 同时插入对应的资源
	 * @author wangs
	 * @param  @return  roleId  (角色id)
	 */
	int addRoleResourceList(SysRole sysRole,List<SysRoleResource> roleResourceList);
	
	/**
	 * @category 修改角色同时 修改角色对应的资源
	 * @author wangs
	 * @param  @return
	 */
	int updateRoleResourceList(SysRole sysRole,List<SysRoleResource> roleResourceList);
	
	/**
	 * @desc  根据部门id 得到对应的role
	 * @param map
	 * @return
	 */
	List<SysRole> getRoleBydeptId(Map<String, Object> map);
	
}
