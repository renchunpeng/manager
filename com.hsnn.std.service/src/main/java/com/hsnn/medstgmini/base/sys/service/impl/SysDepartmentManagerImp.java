package com.hsnn.medstgmini.base.sys.service.impl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.apache.commons.lang3.StringUtils;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.hsnn.medstgmini.base.std.model.StdDict;
import com.hsnn.medstgmini.base.sys.dao.SysDepartmentDao;
import com.hsnn.medstgmini.base.sys.dao.SysRoleDao;
import com.hsnn.medstgmini.base.sys.dao.SysRoleResourceDao;
import com.hsnn.medstgmini.base.sys.dao.SysUserDao;
import com.hsnn.medstgmini.base.sys.form.SysDepartmentForm;
import com.hsnn.medstgmini.base.sys.model.SysDepartment;
import com.hsnn.medstgmini.base.sys.model.SysRole;
import com.hsnn.medstgmini.base.sys.model.SysRoleResource;
import com.hsnn.medstgmini.base.sys.model.SysUser;
import com.hsnn.medstgmini.base.sys.service.ISysDepartmentManager;
import com.hsnn.medstgmini.common.service.impl.GenericManagerImpl;
import com.hsnn.medstgmini.util.Pagination;

@Service("departmentService")
public class SysDepartmentManagerImp extends GenericManagerImpl<SysDepartment, Integer> implements ISysDepartmentManager {

	@Autowired
	private SysDepartmentDao departmentDao;
	

	@Autowired
	private SysUserDao sysUserDao;

	/*@Autowired
	private SysUserManager sysUserManager;*/
	
	@Autowired
	private SysRoleDao sysRoleDao;
	
	@Autowired
	private SysRoleResourceDao sysRoleResourceDao;
	
	
	@Override
	public String getDeptList(Pagination page) {
		PageHelper.startPage(page.getPage(), page.getCount());
		
		List<SysDepartment> pagelist = departmentDao.queryAll(page.getConditions());
		Page<SysDepartment> departments = (Page<SysDepartment>) pagelist;
		page.setRows(departments);
		page.setRecords(departments.getTotal());
		JSONObject jsonObject = new JSONObject(page);
		return jsonObject.toString();
	}
	@Override
	public List<SysDepartment> getDeptList(Map<String, Object> map) {
		return departmentDao.queryAll(map);
	}

	@Override
	public boolean addData(SysDepartmentForm form) {
		SysDepartment  sysDepartment = new SysDepartment();
		BeanUtils.copyProperties(form, sysDepartment);
		int i = departmentDao.save(sysDepartment);
		if(i > 0) {
			return true;
		}else {
			return false;
		}
	}
	

	@Override
	public int addDeptData(SysDepartment sysDepartment,SysUser sysUser ,SysRole sysRole, 
			List<SysRoleResource> sysRoleResources) {
		int i = departmentDao.save(sysDepartment);
		if(i > 0) {
			sysUser.setDepartmentId(sysDepartment.getDepartmentId());
			sysUser.setUserId(UUID.randomUUID().toString());
			// 将部门id放到 部门角色中 
			sysRole.setBelongDepartmentId(sysDepartment.getDepartmentId());
			// 部门角色
			for (SysRoleResource sysRoleResource : sysRoleResources) {
				sysRoleResource.setBelongDepartmentId(sysDepartment.getDepartmentId());
			}
		   this.addRoleResourceList(sysRole, sysRoleResources);
		    
		    // user  为部门管理员登陆账户
			// 为用户添加用户资源
		/*	Map<String, Object> map = new Map<String, Object>();
			map.put("roleId", sysUser.getRoleId());
			map.put("isUsing", 1);
			List<SysRoleResource> resList  = sysRoleResourceManager.getroleResourceList(map);
			List<SysUserResource> userRList = new ArrayList<SysUserResource>();
			
			for (SysRoleResource sysRoleResource : resList) {
				SysUserResource sysUserResource = new SysUserResource();
				sysUserResource.setResourceId(sysRoleResource.getResourceId());
				sysUserResource.setIsUsing(sysRoleResource.getIsUsing());
				sysUserResource.setAddUserId(sysUser.getAddUserId());
				sysUserResource.setAddUserName(sysUser.getAddUserName());
				userRList.add(sysUserResource);
			}
			sysUserManager.addUserAndResList(sysUser, userRList);*/
			sysUserDao.save(sysUser);
			return sysDepartment.getDepartmentId();
		}else {
			return 0;
		}
	}
	
	@Override
	public boolean updateDeptData(SysDepartment sysDepartment,SysUser sysUser ,SysRole sysRole, List<SysRoleResource> sysRoleResources) {
		int i = departmentDao.updateDepartment(sysDepartment);
		if(i > 0) {
			sysUserDao.updateSysUser(sysUser);
			this.updateRoleResourceList(sysRole, sysRoleResources);
			return true;
		}else {
			return false;
		}
	}
	
	@Override
	public int updateDeptData(SysDepartment sysDepartment) {
		return departmentDao.updateDepartmentByIsNull(sysDepartment);
	}

	@Override
	public SysDepartment getDepartment(int id) {
		return departmentDao.get(id);
	}
	
	/**
	 * 
	 *@category 获取监管部门列表
	 *@author wangbing
	 *@date 2016年2月20日11:24:12
	 *@return
	 */
	@Override
	public String getJgDepartmentList(Pagination page) {
		PageHelper.startPage(page.getPage(), page.getMaxResults());
		Page<SysDepartment> sysDepartment = departmentDao.getJgDepartmentList(page.getConditions());
		page.setRows(sysDepartment);
		page.setRecords(sysDepartment.getTotal());
		JSONObject jsonObject = new JSONObject(page);
		return jsonObject.toString();
	}
	
	/**
	 * 
	 *@category 获取监管部门详情
	 *@author wangbing
	 *@date 2016年2月20日11:24:12
	 *@return
	 */
	@Override
	public SysDepartment getJgDepartmentDetail(int id) {
		return departmentDao.get(id);
	}
	
	/**
	 * 
	 *@category 获取监管部门权限
	 *@author wangbing
	 *@date 2016年2月20日11:24:12
	 *@return
	 */
	@Override
	public String getResourceList(Map<String, Object> map) {
		return toPrivTree(departmentDao.getResourceList(map));
	}
	
	/**
	 * 
	 *@category 获取角色资源
	 *@author wangs
	 *@return
	 */
	@Override
	public String getRoleResourceList(Map<String, Object> map) {
		JSONArray jsonArray = new JSONArray(departmentDao.getResourceList(map));
		return jsonArray.toString();
	}
	
	/**
	 * @category 列表转树型结构
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public String toPrivTree(
			List<Map<String, Object>> list) {
		List<Map<String, Object>> result = new LinkedList<Map<String, Object>>();
		if (list != null) {
			Map<Object, Map<String, Object>> map = new HashMap<Object, Map<String, Object>>();
			for (Map<String, Object> priv : list) {
				map.put(priv.get("id"), priv);
			}
			for (Map<String, Object> priv : list) {
				Map<String, Object> father = map.get(priv.get("pid"));
				if (father != null) {
					List<Map<String, Object>> children = (List<Map<String, Object>>) father
							.get("children");
					if (children == null) {
						children = new LinkedList<Map<String, Object>>();
						father.put("children", children);
					}
					children.add(priv);
				} else {
					result.add(priv);
				}
			}
		}
		JSONArray jsonArray = new JSONArray(result);
		return jsonArray.toString();
	}
	/**
	 * 
	 *@category 获取医疗部门列表
	 *@author wangbing
	 *@date 2016年2月20日11:24:12
	 *@return
	 */
	@Override
	public String getHospDepartmentList(Pagination page) {
		PageHelper.startPage(page.getPage(), page.getMaxResults());
		Page<Map<String, Object>> sysDepartment = departmentDao.getHospDepartmentList(page.getConditions());
		page.setRows(sysDepartment);
		page.setRecords(sysDepartment.getTotal());
		JSONObject jsonObject = new JSONObject(page);
		return jsonObject.toString();
	}
	
	/**
	 * 
	 *@category 获取医疗部门详情
	 *@author wangbing
	 *@date 2016年2月20日11:24:12
	 *@return
	 */
	@Override
	public Map<String,Object> getHospDepartmentDetail(int id) {
		return departmentDao.getHospDepartmentDetail(id);
	}
	
	/**
	 * 
	 *@category 获取企业部门列表
	 *@author wangbing
	 *@date 2016年2月20日11:24:12
	 *@return
	 */
	@Override
	public String getCompDepartmentList(Pagination page) {
		PageHelper.startPage(page.getPage(), page.getMaxResults());
		Page<Map<String, Object>> sysDepartment = departmentDao.getCompDepartmentList(page.getConditions());
		page.setRows(sysDepartment);
		page.setRecords(sysDepartment.getTotal());
		JSONObject jsonObject = new JSONObject(page);
		return jsonObject.toString();
	}
	
	/**
	 * 
	 *@category 获取企业部门详情
	 *@author wangbing
	 *@date 2016年2月20日11:24:12
	 *@return
	 */
	@Override
	public Map<String,Object> getCompDepartmentDetail(int id) {
		return departmentDao.getCompDepartmentDetail(id);
	}
	@Override
	public boolean updateStart(SysDepartment sysDepartment) {
		sysDepartment.setIsUsing(1);
		int i = departmentDao.updateDepartment(sysDepartment);
		// 这儿要启用对应的 管理员账户
		SysUser sysUser = new SysUser();
		sysUser.setDepartmentId(sysDepartment.getDepartmentId());
		sysUser.setIsUsing(1);
		sysUser.setAcctType(0);
		sysUser.setLastUpdateUserId(sysDepartment.getLastUpdateUserId());
		sysUser.setLastUpdateUserName(sysDepartment.getLastUpdateUserName());
		sysUserDao.updateUserDisabale(sysUser);
		
		if(i > 0) {
			return true;
		}else {
			return false;
		}
	}

	@Override
	public boolean updateDisable(SysDepartment sysDepartment) {
		sysDepartment.setIsUsing(0);
		int i = departmentDao.updateDepartment(sysDepartment);
		SysUser sysUser = new SysUser();
		sysUser.setDepartmentId(sysDepartment.getDepartmentId());
		sysUser.setIsUsing(0);
		sysUser.setLastUpdateUserId(sysDepartment.getLastUpdateUserId());
		sysUser.setLastUpdateUserName(sysDepartment.getLastUpdateUserName());
		sysUserDao.updateUserDisabale(sysUser);
		if(i > 0) {
			return true;
		}else {
			return false;
		}
	}
	
	/**
	 * 
	 *@category 获取部门列表
	 *@author wangbing
	 *@date 2016年2月20日11:24:12
	 *@return
	 */
	@Override
	public String getDepartmentList(Pagination page) {
		PageHelper.startPage(page.getPage(), page.getMaxResults());
		Page<Map<String, Object>> sysDepartment = departmentDao.getDepartmentList(page.getConditions());
		page.setRows(sysDepartment);
		page.setRecords(sysDepartment.getTotal());
		JSONObject jsonObject = new JSONObject(page);
		return jsonObject.toString();
	}
	/**
	 * 
	 *@category 获取部门权限
	 *@author wangbing
	 *@date 2016年2月20日11:24:12
	 *@return
	 */
	@Override
	public String getDepartmentResource(Pagination page) {
		return toPrivTree(departmentDao.getDepartmentResource(page.getConditions()));
	}
	
	/**
	 * 
	 *@category 保存部门权限编辑
	 *@author wangbing
	 *@date 2016年2月20日11:24:12
	 *@return
	 */
	@Override
	public String saveDepartmentResource(Pagination page){
		String adds = page.getConditions().get("adds").toString();
		String dels = page.getConditions().get("dels").toString();
		String roleId = page.getConditions().get("roleId").toString();
		String departmentId = page.getConditions().get("departmentId").toString();
		String userId = page.getConditions().get("userId").toString();
		String userName = page.getConditions().get("userName").toString();
		String orgId = page.getConditions().get("orgId").toString();
		Integer type = (Integer) page.getConditions().get("type");
		if(StringUtils.isNotBlank(dels)){
			departmentDao.deleteDepartmentResource(departmentId,dels.split(","));
			departmentDao.deleteUserResource(departmentId,dels.split(","));
		}
		if(StringUtils.isNotBlank(adds)){
			List<SysRoleResource> list = new ArrayList<SysRoleResource>();
			String[] add = adds.split(",");
			for(int i=0;i<add.length;i++){
				SysRoleResource srr = new SysRoleResource();
				srr.setRoleId(Integer.parseInt(roleId));
				srr.setResourceId(Integer.parseInt(add[i]));
				srr.setBelongOrg(orgId);
				srr.setBelongDepartmentId(Integer.parseInt(departmentId));
				srr.setType(type);
				srr.setIsUsing(1);
				srr.setAddUserId(userId);
				srr.setAddUserName(userName);
				srr.setAddTime(new Timestamp(new Date().getTime()));
				//srr.setLastUpdateUserId(userId);
				//srr.setLastUpdateUserName(userName);
				//srr.setLastUpdateTime(new Date(System.currentTimeMillis()));
				list.add(srr);
			}
			departmentDao.addDepartmentResource(list);
		}
		JSONObject jsonObject = new JSONObject(page);
		return jsonObject.toString();
	}
	

	/**
	 * 
	 *@category 根据部门id获取角色id
	 *@author wangbing
	 *@date 2016年2月20日11:24:12
	 *@return
	 */
	@Override
	public Map<String,Object> getRoleByDepartmentId(String id){
		Map<String, String> map = new HashMap<String, String>();
		map.put("departmentId", id);
		return departmentDao.getRoleByDepartmentId(map);
	}
	
	public SysDepartment getDepartmentById(Integer department){
		return departmentDao.getDepartmentById(department);
	}

	@Override
	public List<SysDepartment> getReviewDeptName(Map<String, Object> map) {
		return departmentDao.getReviewDeptName(map);
	}
	@Override
	public String queryHosDeptAll(Pagination page) {
		PageHelper.startPage(page.getPage(), page.getCount(), page.getOrderby());
		Page<SysDepartment> models = (Page<SysDepartment>) departmentDao.queryHosDeptAll(page.getConditions());
		page.setRows(models);
		page.setRecords(models.getTotal());
		JSONObject jsonObject = new JSONObject(page);
		return jsonObject.toString();
	}
	
	@Override
	public int updateIsUsingByOrgId(Map<String, Object> map){
		return departmentDao.updateIsUsingByOrgId(map);
	}
	@Override
	public String getJGDepartmentListSJ(Pagination page) {
		PageHelper.startPage(page.getPage(), page.getCount(), page.getOrderby());
		Page<SysDepartment> models = (Page<SysDepartment>) departmentDao.getJGDepartmentListSJ(page.getConditions());
		page.setRows(models);
		page.setRecords(models.getTotal());
		JSONObject jsonObject = new JSONObject(page);
		return jsonObject.toString();
	}
	@Override
	public String getJGDepartmentListShJ(Pagination page) {
		PageHelper.startPage(page.getPage(), page.getCount(), page.getOrderby());
		Page<SysDepartment> models = (Page<SysDepartment>) departmentDao.getJGDepartmentListShJ(page.getConditions());
		page.setRows(models);
		page.setRecords(models.getTotal());
		JSONObject jsonObject = new JSONObject(page);
		return jsonObject.toString();
	}
	@Override
	public String getJGDepartmentListXJ(Pagination page) {
		PageHelper.startPage(page.getPage(), page.getCount(), page.getOrderby());
		Page<SysDepartment> models = (Page<SysDepartment>) departmentDao.getJGDepartmentListXJ(page.getConditions());
		page.setRows(models);
		page.setRecords(models.getTotal());
		JSONObject jsonObject = new JSONObject(page);
		return jsonObject.toString();
	}
	
	
	
	public int addRoleResourceList(SysRole sysRole,
			List<SysRoleResource> roleResourceList) {
		
		int i = sysRoleDao.save(sysRole);
		for (SysRoleResource sysRoleResource : roleResourceList) {
			sysRoleResource.setRoleId(sysRole.getRoleId());
		}
		if(i > 0) {
			if(roleResourceList.size() > 0)
				sysRoleResourceDao.insertBatch(roleResourceList);
			return sysRole.getRoleId();
		}else {
			return 0;
		}
	}
	
	public int updateRoleResourceList(SysRole sysRole,
			List<SysRoleResource> roleResourceList) {
		int i = sysRoleDao.updateRole(sysRole);
		roleResourceRel(roleResourceList, sysRole);
		return i;
	}
	
     public int roleResourceRel(List<SysRoleResource> resList,SysRole sysRole) {
   	  
   	  Map<String, Object> map = new HashMap<String, Object>();
   	  map.put("roleId", sysRole.getRoleId());
   	  List<SysRoleResource> oldRoleResRel = sysRoleResourceDao.queryAll(map);
   	  
   	  List<SysRoleResource> inslList = new ArrayList<SysRoleResource>();

   	  List<SysRoleResource> delRelList = new ArrayList<SysRoleResource>();

   	  for (SysRoleResource sysResource : resList) {
   		  int i = 0;
   		  for (SysRoleResource orel : oldRoleResRel) {
   			  if (sysResource.getResourceId().equals(orel.getResourceId()) ) {
   				  break;
   			  }else {
   				  i ++;
   			  }
   		  }

   		  if (i == oldRoleResRel.size()) {
   			  sysResource.setRoleId(sysRole.getRoleId());
   			  sysResource.setIsUsing(1);
   			  inslList.add(sysResource);
   		  }

   	  }

   	  // update 
   	  for (SysRoleResource orel : oldRoleResRel) {
   		  int i = 0;
   		  for (SysRoleResource sysResource : resList) {
   			  if (sysResource.getResourceId() .equals(orel.getResourceId()) ) {
   				  break;
   			  }else {
   				  i ++;
   			  }
   		  }
   		  if (i == resList.size()) {
   			  orel.setIsUsing(0);
   			  delRelList.add(orel);
   		  }
   	  }

   	  int ins = 0;
   	  int up = 0;
   	  if (inslList.size()>0) {
   		  ins = sysRoleResourceDao.insertBatch(inslList);
   	  }
   	  // 修改该角色的资源
   	  if (delRelList.size()>0) {
   		  for (SysRoleResource sysRoleResource : delRelList) {
   			up += sysRoleResourceDao.updateRoleResource(sysRoleResource);
		  }
   		/*  up = sysRoleResourceManager.updateBatch(delRelList);*/
   	  }
   	  // 修改岗位资源的数据
   	  /*if (delRelList.size()>0) {
  		  for (SysRoleResource sysRoleResource : delRelList) {
  			sysRoleResource.setBelongDepartmentId(sysRole.getBelongDepartmentId());
  			up += sysRoleResourceManager.updateRoleResourceByDept(sysRoleResource);
		  }
  	  }*/
   	  // 修改用户资源的数据
   	/*if (delRelList.size()>0) {
		  for (SysRoleResource sysRoleResource : delRelList) {
			SysUserResource sysUserResource = new SysUserResource();
			sysUserResource.setResourceId(sysRoleResource.getResourceId());
			sysUserResource.setBelongDepartmentId(sysRole.getBelongDepartmentId());
			sysUserResource.setIsUsing(0);
			sysUserResource.setLastUpdateUserId(sysRole.getLastUpdateUserId());
			sysUserResource.setLastUpdateUserName(sysRole.getLastUpdateUserName());
			up += sysUserResourceManager.updateUserResourceByDept(sysUserResource);
		  }
	  }*/
   	  
   	  return ins + up;
     }
	@Override
	public Pagination getDepartmentListAll(Pagination page) {
		PageHelper.startPage(page.getPage(), page.getCount(), page.getOrderby());
		Page<SysDepartment> stdCompanies = (Page<SysDepartment>) departmentDao.departMentQueryAll(page.getConditions());
		page.setRows(stdCompanies);
		page.setRecords(stdCompanies.getTotal());
		return page;
	}
	@Override
	public int add(SysDepartment model) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public int insertBatch(List<SysDepartment> models) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public SysDepartment getById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public int deleteById(Integer id) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public int updateById(SysDepartment model) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public int updateBySelective(SysDepartment model) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public Pagination getList(Pagination page) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<SysDepartment> getLists(Map<String, Object> params) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Pagination getListWithImport(Pagination page) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<SysDepartment> getListWithImports(Map<String, Object> params) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public int getCount(Map<String, Object> params) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public int updateByParams(Map<String, Object> params, SysDepartment entity) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public int updateByParams2(Map<String, Object> params, SysDepartment entity, Integer isAutoUpdateInfo) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public int count(Map<String, Object> params) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public int insertBatchTemp(List<SysDepartment> datas, String tableName, String isError) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public int updateDepartmentById(SysDepartment sysDepartment) {
		return this.departmentDao.updateDepartmentById(sysDepartment);
	}
	@Override
	public List<SysDepartment> selectNameAndId(SysDepartment departmentId) {
		return this.departmentDao.selectNameAndId(departmentId);
	}
	@Override
	public boolean addDepartment(SysDepartment sysDepartment) {
		
		int count = departmentDao.addDepartment(sysDepartment);
		if(count > 0) {
			return true;
		}
		return false;
	}
}
