package com.hsnn.medstgmini.base.sys.dao;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.ibatis.annotations.Param;

import com.github.pagehelper.Page;
import com.hsnn.medstgmini.base.sys.model.SysResource;
import com.hsnn.medstgmini.base.sys.model.SysRole;
import com.hsnn.medstgmini.base.sys.model.SysRoleResource;
import com.hsnn.medstgmini.base.sys.model.SysUserResource;
import com.hsnn.medstgmini.common.dao.GenericDao;

public interface SysResourceDao extends GenericDao<SysResource, java.lang.Integer> {
	
	/**
	 * @category 查询用户权限列表
	 * @date 2016年2月22日
	 * @param userId 用户编号
	 * @return
	 */
	Set<SysResource> getResourceListByUser(String userId);
	int saveresource(SysResource sysResource);

	int getresourceId(@Param(value= "resourceUrl") String resourceUrl);

	/**
	 * @category 查询权限列表
	 * @return
	 */
	List<SysResource> getPrivilegeList(String roleId);
	
	/**
	 * @category 保存权限
	 * @param privilege
	 * @return
	 */
	SysResource savePrivilege(SysResource privilege);
	
	Integer returnLastId();
	
	
	/**
	 * @category 获取主角色列表
	 * @param privilege
	 */
	Page<SysRole> getMainRoleList();
	
	/**
	 * @category 查询权限Map列表
	 * @return
	 */
	List<Map<String, Object>> getPrivilegeLists(String roleId);
	
	
	
	void deleteRoleResource(@Param(value = "roleId") String roleId,@Param(value = "dels") String[] dels);
	void deleteUserResource(@Param(value = "roleId") String roleId,@Param(value = "dels") String[] dels);
	void addRoleResource(List<SysRoleResource> list);
	void addUserResource(List<SysUserResource> list);
	String getSysUserByRoleId(String roleId);
	
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
	Set<SysResource> getDeptSelectResource(@Param("orgId")String orgId, @Param("deptId")Integer deptId);
}