package com.hsnn.medstgmini.base.sys.service;

import java.util.List;
import java.util.Map;

import javax.jws.WebMethod;
import javax.jws.WebService;

import com.hsnn.medstgmini.base.sys.form.SysDepartmentForm;
import com.hsnn.medstgmini.base.sys.model.SysDepartment;
import com.hsnn.medstgmini.base.sys.model.SysRole;
import com.hsnn.medstgmini.base.sys.model.SysRoleResource;
import com.hsnn.medstgmini.base.sys.model.SysUser;
import com.hsnn.medstgmini.common.service.GenericManager;
import com.hsnn.medstgmini.util.Pagination;


@WebService
public interface ISysDepartmentManager{

	String getJgDepartmentList(Pagination page);

	SysDepartment getJgDepartmentDetail(int id);
	
	SysDepartment getDepartment(int id);
	
	String getResourceList(Map<String, Object> map);
	
	List<SysDepartment> getReviewDeptName(Map<String, Object> map);
	
	String getDeptList(Pagination page);
	
	@WebMethod(operationName="getDeptLists")
	List<SysDepartment> getDeptList(Map<String, Object> map);
	
	boolean addData(SysDepartmentForm form);
	
	String getHospDepartmentList(Pagination page);

	Map<String, Object> getHospDepartmentDetail(int id);

	Map<String, Object> getCompDepartmentDetail(int id);

	String getCompDepartmentList(Pagination page);
	
	int addDeptData(SysDepartment sysDepartment,SysUser sysUser ,SysRole sysRole, List<SysRoleResource> sysRoleResources);
	
	int updateDeptData(SysDepartment sysDepartment);
	
	@WebMethod(operationName="updateDeptDatas")
	boolean updateDeptData(SysDepartment sysDepartment,SysUser sysUser,SysRole sysRole, List<SysRoleResource> sysRoleResources);
	
	boolean updateStart(SysDepartment sysDepartment);
	
	boolean updateDisable(SysDepartment sysDepartment);

	String getDepartmentList(Pagination page);
	Pagination getDepartmentListAll(Pagination page);

	String getDepartmentResource(Pagination page);

	Map<String, Object> getRoleByDepartmentId(String id);

	String saveDepartmentResource(Pagination page);

	String getRoleResourceList(Map<String, Object> map);
	
	/**
	 * @category 根据部门id获取部门信息
	 * @author 韩守松
	 * @date   2016年3月1日
	 * @param  @param departmentId
	 * @param  @return
	 */
	SysDepartment getDepartmentById(Integer departmentId);
	
	
	/**
	 * 医疗机构的部门列表
	 * @param map
	 * @return
	 */
	String queryHosDeptAll(Pagination page);

	int updateIsUsingByOrgId(Map<String, Object> map);
	
	int updateDepartmentById(SysDepartment sysDepartment);
	
	/**
	 * 监管机构部门查看 :省级机构
	 * @param map
	 * @return
	 */
	public String  getJGDepartmentListSJ(Pagination page);
	
	/**
	 * 监管机构部门查看 :市级机构
	 * @param map
	 * @return
	 */
    public String  getJGDepartmentListShJ(Pagination page);
	
	/**
	 * 监管机构部门查看 :县级机构
	 * @param map
	 * @return
	 */
     public String getJGDepartmentListXJ(Pagination page);
     public List<SysDepartment> selectNameAndId(SysDepartment departmentId);
     
     boolean addDepartment(SysDepartment sysDepartment);
}