package com.hsnn.medstgmini.base.sys.service;

import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.jws.WebService;

import com.hsnn.medstgmini.base.sys.model.SysResource;
import com.hsnn.medstgmini.util.Pagination;

@WebService
public interface ISysResource {

	/**
	 * @category 查询用户权限列表
	 * @date 2016年2月22日
	 * @param userId 用户编号
	 * @return
	 */
	Set<SysResource> getResourceListByUser(String userId);
	
	
	/**
	 * @category 查询权限列表
	 * @return
	 */
	List<SysResource> getPrivilegeList(String roleId);

	/**
	 * @category 保存权限
	 * @param privilege
	 */
	SysResource savePrivilege(SysResource privilege);

	/**
	 * @category 删除权限
	 * @param privilege
	 */
	void deletePrivilege(SysResource privilege);
	/**
	 * @category 获取主角色列表
	 * @param privilege
	 */
	String getMainRoleList(Pagination page);
	/**
	 * @category 获取角色权限
	 * @param privilege
	 */
	List<Map<String, Object>> getRoleResource(Pagination page);
	
	String saveRoleResource(Pagination page);
	
	/**
	 * @category 查询用户权限列表
	 * @date 2016年2月22日
	 * @param roleId 角色编号
	 * @return
	 */
	Set<SysResource> getResourceListByRoleId(int roleId);
	
	/**
	 * 获得机构下部门已选择的权限
	 */
	Set<SysResource> getDeptSelectResource(String orgId, Integer deptId);

	List<SysResource> queryAll(Map<String, Object> map);
}
