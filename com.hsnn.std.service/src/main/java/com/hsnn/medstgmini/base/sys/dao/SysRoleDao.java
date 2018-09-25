package com.hsnn.medstgmini.base.sys.dao;
import java.util.Map;

import com.hsnn.medstgmini.base.sys.model.SysRole;
import com.hsnn.medstgmini.common.dao.GenericDao;

public interface SysRoleDao extends GenericDao<SysRole, java.lang.Integer> {
	
	/**
	 * @category 根据角色id获取角色信息
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
	 * @category 根据机构id获取医疗机构信息
	 * @author 韩守松
	 * @date   2016年2月23日
	 * @param  @param orgId
	 * @param  @return
	 */
	Map<String,Object> getOrgCompDataById(String orgId);
	
	int updateRole(SysRole sysRole);
	
	/**
	 * 
	 *@category 新增岗位权限保存
	 *@author 言科
	 *@date 2016年2月20日11:24:12
	 *@return
	 */
	int savePostResource(SysRole sysRole);
	
	/**
	 * 
	 *@category 岗位新增时获取数据库中自增的那个roleId
	 *@author 言科
	 *@date 2016年2月20日11:24:12
	 *@return
	 */
	int returnLastRoleId();
	
	boolean addSysRole(SysRole sysRole);
	
}