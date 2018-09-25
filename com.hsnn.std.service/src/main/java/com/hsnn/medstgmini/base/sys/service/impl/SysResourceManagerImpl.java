package com.hsnn.medstgmini.base.sys.service.impl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.hsnn.medstgmini.base.sys.dao.SysResourceDao;
import com.hsnn.medstgmini.base.sys.model.SysResource;
import com.hsnn.medstgmini.base.sys.model.SysRole;
import com.hsnn.medstgmini.base.sys.model.SysRoleResource;
import com.hsnn.medstgmini.base.sys.model.SysUserResource;
import com.hsnn.medstgmini.base.sys.service.ISysResource;
import com.hsnn.medstgmini.util.Pagination;
import com.hsnn.medstgmini.util.TreeUtil;

@Service
public class SysResourceManagerImpl implements ISysResource {
	
	@Autowired
	private SysResourceDao resourceDao;
	
	/**
	 * @category 查询用户权限列表
	 * @date 2016年2月22日
	 * @param userId 用户编号
	 * @return
	 */
	public Set<SysResource> getResourceListByUser(String userId) {
		return resourceDao.getResourceListByUser(userId);
	}

	/**
	 * @category 查询权限列表
	 * @return
	 */
	public List<SysResource> getPrivilegeList(String roleId) {
		List<SysResource> list = resourceDao.getPrivilegeList(roleId);
		return TreeUtil.toPrivilegeTree(list);
	}

	/**
	 * @category 保存权限
	 * @param privilege
	 * @return
	 */
	@Transactional
	public SysResource savePrivilege(SysResource privilege) {
		if(null != privilege.getResourceId()){//编辑
			resourceDao.update(privilege);
		}else{//新增
			resourceDao.save(privilege);
			privilege = resourceDao.get(resourceDao.returnLastId());
		}
		return privilege;
	}

	/**
	 * @category 删除权限
	 * @param privilege
	 */
	@Transactional
	public void deletePrivilege(SysResource privilege) {
		if (null != privilege.getResourceId()) {
			privilege = resourceDao.get(privilege.getResourceId());
		}
			deleteChildren(privilege);
			resourceDao.delete(privilege.getResourceId());
	}
	
	private void deleteChildren(SysResource sysResource){
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("parentResourceId", sysResource.getResourceId());
		List<SysResource> list = resourceDao.queryAll(map);
		if(list.size()>0){
			for(SysResource sr : list ){
				if(null!=sr.getResourceId()){
					deleteChildren(sr);
					resourceDao.delete(sr.getResourceId());
				}
			}
		}
	}

	@Override
	public String getMainRoleList(Pagination page ) {
		PageHelper.startPage(page.getPage(), page.getMaxResults());
		Page<SysRole> sr = resourceDao.getMainRoleList();
		page.setRows(sr);
		page.setRecords(sr.getTotal());
		JSONObject jsonObject = new JSONObject(page);
		return jsonObject.toString();
	}

	@Override
	public List<Map<String,Object>> getRoleResource(Pagination page) {
		return resourceDao.getPrivilegeLists(page.getConditions().get("roleId").toString());
	}

	@Override
	public String saveRoleResource(Pagination page) {
		String roleId = page.getConditions().get("roleId").toString();
		String userId = page.getConditions().get("userId").toString();
		String userName = page.getConditions().get("userName").toString();
		if(null != page.getConditions().get("dels")){
			String dels = String.valueOf(page.getConditions().get("dels"));
			resourceDao.deleteRoleResource(roleId,dels.split(","));
			resourceDao.deleteUserResource(roleId,dels.split(","));
		}
		if(null != page.getConditions().get("adds")){
			String adds  = String.valueOf(page.getConditions().get("adds"));
			List<SysRoleResource> list = new ArrayList<SysRoleResource>();
			String[] add = adds.split(",");
			for(int i=0;i<add.length;i++){
				SysRoleResource srr = new SysRoleResource();
				srr.setRoleId(Integer.parseInt(roleId));
				srr.setResourceId(Integer.parseInt(add[i]));
				srr.setIsUsing(1);
				srr.setAddUserId(userId);
				srr.setAddUserName(userName);
//				srr.setAddTime(new Date(System.currentTimeMillis()));//oracle
				srr.setAddTime(new Timestamp(new Date().getTime()));//mysql
				srr.setLastUpdateUserId(userId);
				srr.setLastUpdateUserName(userName);
//				srr.setLastUpdateTime(new Date(System.currentTimeMillis()));// oracle
				srr.setLastUpdateTime(new Timestamp(new Date().getTime()));// mysql
				list.add(srr);
			}
			resourceDao.addRoleResource(list);
			
			List<SysUserResource> listSu = new ArrayList<SysUserResource>();
			String user = resourceDao.getSysUserByRoleId(roleId);
			for(int i=0;i<add.length;i++){
				SysUserResource srr = new SysUserResource();
				srr.setUserId(user);
				srr.setResourceId(Integer.parseInt(add[i]));
				srr.setIsUsing(1);
				srr.setAddUserId(userId);
				srr.setAddUserName(userName);
//				srr.setAddTime(new Date(System.currentTimeMillis())); //oracel
				srr.setAddTime(new Timestamp(new Date().getTime())); //mysql
				srr.setLastUpdateUserId(userId);
				srr.setLastUpdateUserName(userName);
//				srr.setLastUpdateTime(new Date(System.currentTimeMillis())); //oracle
				srr.setLastUpdateTime(new Timestamp(new Date().getTime())); //mysql
				listSu.add(srr);
			}
			resourceDao.addUserResource(listSu);
		}
		JSONObject jsonObject = new JSONObject(page);
		return jsonObject.toString();
	}
	
	

	/**
	 * @category 查询用户权限列表
	 * @date 2016年2月22日
	 * @param roleId 角色编号
	 * @return
	 */
	@Override
	public Set<SysResource> getResourceListByRoleId(int roleId) {
		
		return resourceDao.getResourceListByRoleId(roleId);
	}
	
	public Set<SysResource> getDeptSelectResource(String orgId, Integer deptId) {
		return resourceDao.getDeptSelectResource(orgId, deptId);
	}

	@Override
	public List<SysResource> queryAll(Map<String, Object> map) {
		return resourceDao.queryAll(map);
	}


}
