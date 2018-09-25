package com.hsnn.medstgmini.base.sys.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hsnn.medstgmini.base.sys.dao.SysRoleDao;
import com.hsnn.medstgmini.base.sys.dao.SysRoleResourceDao;
import com.hsnn.medstgmini.base.sys.model.SysRole;
import com.hsnn.medstgmini.base.sys.model.SysRoleResource;
import com.hsnn.medstgmini.base.sys.service.ISysRole;

@Service
public class SysRoleManagerImpl implements ISysRole {
	
	@Autowired
	private SysRoleDao roleDao;
	
	@Autowired
	private SysRoleResourceDao sysRoleResourceDao ;
	
	/**
	 * @category 根据角色id获取角色数据
	 * @author 韩守松
	 * @date   2016年2月23日
	 * @param  @param roleId
	 * @param  @return
	 */
	public SysRole getRoleById(Integer roleId){
		return roleDao.getRoleById(roleId);
	}
	
	/**
	 * @category 根据机构id获取机构信息
	 * @author 韩守松
	 * @date   2016年2月23日
	 * @param  @param orgId
	 * @param  @return
	 */
	public Map<String,Object> getOrgHospDataById(String orgId){
		return roleDao.getOrgHospDataById(orgId);
	}
	
	/**
	 * @category 根据机构id获取企业机构信息
	 * @author 韩守松
	 * @date   2016年2月23日
	 * @param  @param orgId
	 * @param  @return
	 */
	public Map<String,Object> getOrgCompDataById(String orgId){
		return roleDao.getOrgCompDataById(orgId);
	}

	@Override
	public boolean addRole(SysRole sysRole) {
		int i = roleDao.save(sysRole);
		if(i > 0) {
			return true;
		}else {
			return false;
		}
	}

	@Override
	public int addRoleResourceList(SysRole sysRole,
			List<SysRoleResource> roleResourceList) {
		
		int i = roleDao.save(sysRole);
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

	@Override
	public int updateRoleResourceList(SysRole sysRole,
			List<SysRoleResource> roleResourceList) {
		int i = roleDao.updateRole(sysRole);
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
	public List<SysRole> getRoleBydeptId(Map<String, Object> map) {
		return roleDao.queryAll(map);
	}
}
