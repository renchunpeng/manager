package com.hsnn.medstgmini.base.sys.dao;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.github.pagehelper.Page;
import com.hsnn.medstgmini.base.sys.model.SysDepartment;
import com.hsnn.medstgmini.base.sys.model.SysRoleResource;
import com.hsnn.medstgmini.common.dao.GenericDao;
public interface SysDepartmentDao extends GenericDao<SysDepartment, java.lang.Integer> {
	/**
	 * @category 查询出部门的所有id与名称
	 * @author 韩守松
	 * @date   2016年2月20日
	 * @param  @return
	 */
	List<SysDepartment> findDepartmentIdAndName(SysDepartment department);
	/**
	 * 
	 *@category 获取监管部门列表
	 *@author wangbing
	 *@date 2016年2月20日11:24:12
	 *@return
	 */
	public Page<SysDepartment> getJgDepartmentList(Map<String, Object> map);
	public SysDepartment get(int id);
	/**
	 * 
	 *@category 获取权限
	 *@author wangbing
	 *@date 2016年2月20日11:24:12
	 *@return
	 */
	public List<Map<String, Object>> getResourceList(Map<String, Object> map);
	
	/**
	 * 
	 *@category 修改部门
	 *@author wangs
	 *@date 2016年2月20日11:24:12
	 *@return
	 */
	int updateDepartment(SysDepartment department);
	
	/**
	 * 
	 *@category 修改部门
	 *@author wangs
	 *@date 2016年2月20日11:24:12
	 *@return
	 */
	int updateDepartmentByIsNull(SysDepartment department);
	
	/**
	 * @desc 根据 名称  orgId 验证部门是否存在
	 * @param map
	 * @return
	 */
	List<SysDepartment> getReviewDeptName(Map<String, Object> map);
	/**
	 * 
	 *@category 获取医疗部门列表
	 *@author wangbing
	 *@date 2016年2月20日11:24:12
	 *@return
	 */
	public Page<Map<String, Object>> getHospDepartmentList(Map<String, Object> map);
	
	/**
	 * 
	 *@category 获取医疗部门详情
	 *@author wangbing
	 *@date 2016年2月20日11:24:12
	 *@return
	 */
	public Map<String,Object> getHospDepartmentDetail(int id);
	/**
	 * 
	 *@category 获取企业部门列表
	 *@author wangbing
	 *@date 2016年2月20日11:24:12
	 *@return
	 */
	public Page<Map<String, Object>> getCompDepartmentList(Map<String, Object> map);
	
	/**
	 * 
	 *@category 获取企业部门详情
	 *@author wangbing
	 *@date 2016年2月20日11:24:12
	 *@return
	 */
	public Map<String,Object> getCompDepartmentDetail(int id);
	/**
	 * 
	 *@category 获取部门列表
	 *@author wangbing
	 *@date 2016年2月20日11:24:12
	 *@return
	 */
	public Page<Map<String, Object>> getDepartmentList(Map<String, Object> map);
	/**
	 * 
	 *@category 获取部门权限
	 *@author wangbing
	 *@date 2016年2月20日11:24:12
	 *@return
	 */
	public List<Map<String, Object>> getDepartmentResource(Map<String, Object> map);
	/**
	 * 
	 *@category 删除部门权限
	 *@author wangbing
	 *@date 2016年2月20日11:24:12
	 *@return
	 */
	public void deleteDepartmentResource(@Param(value = "departmentId") String departmentId,@Param(value = "dels") String[] dels);
	/**
	 * 
	 *@category 删除用户权限
	 *@author wangbing
	 *@date 2016年2月20日11:24:12
	 *@return
	 */
	public void deleteUserResource(@Param(value = "departmentId") String departmentId,@Param(value = "dels") String[] dels);
	/**
	 * 
	 *@category 添加部门权限
	 *@author wangbing
	 *@date 2016年2月20日11:24:12
	 *@return
	 */
	public void addDepartmentResource(List<SysRoleResource> list);
	/**
	 * 
	 *@category 根据部门id获取角色id
	 *@author wangbing
	 *@date 2016年2月20日11:24:12
	 *@return
	 */
	public Map<String,Object> getRoleByDepartmentId(Map<String, String> map);
	
	/**
	 * @category 根据部门id获取部门信息
	 * @author 韩守松
	 * @date   2016年2月23日
	 * @param  @param roleId
	 * @param  @return
	 */
	SysDepartment getDepartmentById(Integer departmentId);
	
	/**
	 * 医疗机构的部门列表
	 * @param map
	 * @return
	 */
	List<SysDepartment> queryHosDeptAll(Map<String, Object> map);
	
	int updateIsUsingByOrgId(Map<String, Object> map);
	
	/**
	 * 监管机构部门查看 :省级机构
	 * @param map
	 * @return
	 */
	public Page<SysDepartment> getJGDepartmentListSJ(Map<String, Object> map);
	
	/**
	 * 监管机构部门查看 :市级机构
	 * @param map
	 * @return
	 */
    public Page<SysDepartment>  getJGDepartmentListShJ(Map<String, Object> map);
	
	/**
	 * 监管机构部门查看 :县级机构
	 * @param map
	 * @return
	 */
     public Page<SysDepartment> getJGDepartmentListXJ(Map<String, Object> map);
     public List<SysDepartment> departMentQueryAll(Map<String, Object> map);
     int updateDepartmentById(SysDepartment sysDepartment);
     List<SysDepartment> selectNameAndId(SysDepartment department);
     
     int addDepartment(SysDepartment sysDepartment);
}