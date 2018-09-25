package com.hsnn.medstgmini.base.sys.service.impl;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.hsnn.medstgmini.base.sys.dao.SysDepartmentDao;
import com.hsnn.medstgmini.base.sys.dao.SysPostDao;
import com.hsnn.medstgmini.base.sys.dao.SysRoleDao;
import com.hsnn.medstgmini.base.sys.dao.SysRoleResourceDao;
import com.hsnn.medstgmini.base.sys.form.SysPostForm;
import com.hsnn.medstgmini.base.sys.model.SysDepartment;
import com.hsnn.medstgmini.base.sys.model.SysPost;
import com.hsnn.medstgmini.base.sys.model.SysRole;
import com.hsnn.medstgmini.base.sys.model.SysRoleResource;
import com.hsnn.medstgmini.base.sys.model.SysUser;
import com.hsnn.medstgmini.base.sys.service.ISysPostManager;
import com.hsnn.medstgmini.common.model.UserType;
import com.hsnn.medstgmini.util.Pagination;



/**
 * @category 岗位管理
 * @author 言科
 * @date 2016年2月19日
 */
@Service("zxMinSysPostManager")
public class SysPostManagerImpl implements ISysPostManager {
	private static final Logger log = Logger.getLogger(SysPostManagerImpl.class);
	@Autowired
	private SysPostDao sysPostDao;
	
	@Autowired
	private SysRoleResourceDao sysRoleResourceDao;
	
	@Autowired
	private SysDepartmentDao sysDepartmentDao;
	
	@Autowired
	private SysRoleDao sysRoleDao;

	/**
	 * @category 查询岗位列表
	 * @author 言科
	 * @date 2016年2月19日
	 */
	@Override
	public String getZxMinSysPostList(Pagination page){
		PageHelper.startPage(page.getPage(), page.getCount());
		Page<SysPost> sysPost =  sysPostDao.queryGangWei(page.getConditions());	
		page.setRows(sysPost);
		page.setRecords(sysPost.getTotal());
		JSONObject jsonObject = new JSONObject(page);
		return jsonObject.toString();
	}
	
	
	
	
	/**
	 * @category 岗位启用列表
	 * @author 言科
	 * @date 2016年2月19日
	 */
	@Override
	public String getzxMinSysPostListStart(Pagination page){
		PageHelper.startPage(page.getPage(), page.getCount());
		page.getConditions().put("isUsing", "0");
		Page<SysPost> sysPost =  sysPostDao.queryGangWeiStart(page.getConditions());	
		page.setRows(sysPost);
		page.setRecords(sysPost.getTotal());
		JSONObject jsonObject = new JSONObject(page);
		return jsonObject.toString();
	}
	
	
	/**
	 * @category 岗位停用列表
	 * @author 言科
	 * @date 2016年2月19日
	 */
	@Override
	public String getzxMinSysPostListStop(Pagination page){
		PageHelper.startPage(page.getPage(), page.getCount());
		page.getConditions().put("isUsing", "1");
		Page<SysPost> sysPost =  sysPostDao.queryGangWeiStop(page.getConditions());	
		page.setRows(sysPost);
		page.setRecords(sysPost.getTotal());
		JSONObject jsonObject = new JSONObject(page);
		return jsonObject.toString();
	}


	/**
	 * @category 岗位批量(启用|停用)按钮
	  * @author 言科
	 * @date 2016年2月19日
	 */
	@Override
	public void batchChangeStatus(Pagination page) {
		
		 sysPostDao.updateSysPostUsing(page.getConditions());
		
	}
	
	
	/**
	 * @category 岗位编辑列表
	 * @author 言科
	 * @date 2016年2月19日
	 */
	@Override
	public String getzxMinSysPostListEdit(Pagination page){
		PageHelper.startPage(page.getPage(), page.getCount());
		page.getConditions().put("isUsing", "1");
		Page<SysPost> sysPost =  sysPostDao.queryGangWeiEdit(page.getConditions());	
		page.setRows(sysPost);
		page.setRecords(sysPost.getTotal());
		JSONObject jsonObject = new JSONObject(page);
		return jsonObject.toString();
	}
	
	/**
	 * @category 岗位编辑功能
	 * @author 言科
	 * @date 2016年2月19日
	 */
	@Override
	public boolean updateSysPost(SysPostForm form) {
		SysPost  sysPost = new SysPost();
		BeanUtils.copyProperties(form, sysPost);
		
		int i = sysPostDao.updateSysPost(sysPost);
		if(i > 0) {
			return true;
		}else {
			return false;
		}
	}
	
	
	/**
	 * @category 岗位启用停用，更新表中状态
	 * @author 言科
	 * @date 2016年2月19日
	 */
	public int updateSysPostIsUsing(SysPost sysPost) {
		return sysPostDao.updateSysPostIsUsing(sysPost);
	}


	/**
	 * 查询部门所有id和名称
	 */
	public List<SysDepartment> findDepartmentIdAndName(SysDepartment department) {
		List<SysDepartment> list = sysDepartmentDao.findDepartmentIdAndName(department);
		return list;
	}
	
	
	/**
	 * @category 岗位新增功能
	 * @author 言科
	 * @return 
	 * @date 2016年2月19日
	 */
	
	public String[] saveSysPost(SysPostForm form, SysUser user,Pagination page)  {
		SysPost  sysPost = new SysPost();
		BeanUtils.copyProperties(form, sysPost);
		
		
		sysPost.setAddTime(new Date(System.currentTimeMillis()));
		sysPost.setAddUserId(user.getUserId());
		//sysPost.setAddUserName(user.getUserName());
		sysPost.setAddUserName(user.getName()+"("+user.getUserName()+")");
		/*sysPost.setLastUpdateTime(new Date(System.currentTimeMillis()));
		sysPost.setLastUpdateUserId(user.getAddUserId());
		sysPost.setLastUpdateUserName(user.getUserName());*/
		
		sysPostDao.saveSysPost(sysPost);
		form.setPostId(sysPost.getPostId());//前台要hodel住..
		
		int postId = sysPost.getPostId();
		SysDepartment depart=user.getSysDepartment();
		SysRole sysRole = new SysRole();
		sysRole.setRoleName(sysPost.getPostName());
		sysRole.setRoleType(depart.getDepartmentType());//sysPost.getDepartmentType()<<
		sysRole.setIsUsing(sysPost.getIsUsing());
		//sysRole.setAddTime(sysPost.getAddTime());// oracle 时间处理方式
		sysRole.setAddTime(new Timestamp(sysPost.getAddTime().getTime()));// mysql
		sysRole.setAddUserId(user.getAddUserId());
		sysRole.setAddUserName(user.getAddUserName());
		sysRole.setBelongDepartmentId(depart.getDepartmentId());//sysPost.getDepartmentId()<<
		sysRole.setBelongOrg(user.getOrgId());//机构ID
		//sysRole.setLastUpdateTime(sysPost.getLastUpdateTime());
		sysRole.setLastUpdateTime(new Timestamp(sysPost.getLastUpdateTime().getTime()));
		sysRole.setLastUpdateUserId(sysPost.getLastUpdateUserName());
		sysRole.setLastUpdateUserName(sysPost.getLastUpdateUserName());
		sysRole.setBelongPostId(postId);
		
		sysRoleDao.savePostResource(sysRole);
		String[] retArrObj = new String[2];
		retArrObj[0] = sysRole.getRoleId()+"";
		retArrObj[1] = form.getPostId()+"";
		 return retArrObj;

		
	}

	/**
	 * 
	 *@category 岗位新增保存（获取的是部门的权限）
	 *@author 言科
	 *@date 2016年2月20日11:24:12
	 *@return
	 */
	@Override
	public String saveSysPostResource(Pagination page,SysUser user){
		String adds = page.getConditions().get("adds").toString();
		String userId = page.getConditions().get("userId").toString();
		String userName = page.getConditions().get("userName").toString();
		String postId=page.getConditions().get("postId").toString();
		int roleId = Integer.parseInt(page.getConditions().get("roleId").toString());
		
		if(StringUtils.isNotBlank(adds)){
			List<SysRoleResource> list = new ArrayList<SysRoleResource>();
			String[] add = adds.split(",");
			for(int i=0;i<add.length;i++){
				SysRoleResource srr = new SysRoleResource();
				srr.setRoleId(roleId);
				srr.setResourceId(Integer.parseInt(add[i]));
				srr.setIsUsing(1);
				srr.setType(user.getUserType());//类型 TODO 是从user.Role中取?
				srr.setAddUserId(userId);
				srr.setAddUserName(userName);
//				srr.setAddTime(new Date(System.currentTimeMillis())); // oracle
				srr.setAddTime(new Timestamp(new Date().getTime())); // mysql
				srr.setLastUpdateUserId(userId);
				srr.setLastUpdateUserName(userName);
				srr.setBelongOrg(user.getOrgId());
				srr.setBelongDepartmentId(user.getDepartmentId());
				srr.setBelongPostId(Integer.parseInt(postId));
//				srr.setLastUpdateTime(new Date(System.currentTimeMillis())); // oralce
				srr.setLastUpdateTime(new Timestamp(new Date().getTime()));
				list.add(srr);
			}
			sysPostDao.addPostResource(list);
		}
		JSONObject jsonObject = new JSONObject(page);
		return jsonObject.toString();
	}
	

	
	
	/**
	 * 
	 *@category 根据id查询岗位信息（详情、编辑页面）
	 * @author 言科
	 * @date 2016年2月19日
	 */
	@Override
	public SysPost querySysPostById(Integer postId) {	
		List<SysPost> list = sysPostDao.querySysPostById(postId);
		SysPost sysPost = list.get(0);
		return sysPost;
	}
	
	/**
	 * 查询岗位所有id和Name
	 */
	public List<SysPost> findAllPostIdAndName(SysPost post) {
		return sysPostDao.findAllPostIdAndName(post);
	}
	
	/**
	 * 
	 *@category 获取监管岗位列表
	 *@author wangbing
	 *@date 2016年2月20日11:24:12
	 *@return
	 */
	@Override
	public String getJgPostList(Pagination page) {
		PageHelper.startPage(page.getPage(), page.getMaxResults());
		Page<Map<String, Object>> sysPost = sysPostDao.getJgPostList(page.getConditions());
		page.setRows(sysPost);
		page.setRecords(sysPost.getTotal());
		JSONObject jsonObject = new JSONObject(page);
		return jsonObject.toString();
	}
	
	/**
	 * 
	 *@category 获取医疗岗位列表
	 *@author wangbing
	 *@date 2016年2月20日11:24:12
	 *@return
	 */
	@Override
	public String getHospPostList(Pagination page) {
		PageHelper.startPage(page.getPage(), page.getMaxResults());
		Page<Map<String, Object>> sysPost = sysPostDao.getHospPostList(page.getConditions());
		page.setRows(sysPost);
		page.setRecords(sysPost.getTotal());
		JSONObject jsonObject = new JSONObject(page);
		return jsonObject.toString();
	}
	
	/**
	 * 
	 *@category 获取企业岗位列表
	 *@author wangbing
	 *@date 2016年2月20日11:24:12
	 *@return
	 */
	@Override
	public String getCompPostList(Pagination page) {
		PageHelper.startPage(page.getPage(), page.getMaxResults());
		Page<Map<String, Object>> sysPost = sysPostDao.getCompPostList(page.getConditions());
		page.setRows(sysPost);
		page.setRecords(sysPost.getTotal());
		JSONObject jsonObject = new JSONObject(page);
		return jsonObject.toString();
	}
	
	/**
	 * 
	 *@category 获取岗位权限
	 *@author wangbing
	 *@date 2016年2月20日11:24:12
	 *@return
	 */
	@Override
	public String getPostResource(Map<String, Object> map){
		JSONArray jsonArray = new JSONArray(toPrivTree(sysPostDao.getPostResource(map)));
		return jsonArray.toString();
	}
	
	/**
	 * 
	 *@category 根据部门获取岗位权限
	 *@author wangbing
	 *@date 2016年2月20日11:24:12
	 *@return
	 */
	@Override
	public String getPostResourceByDepart(Map<String, Object> map){
		return toPrivTree(sysPostDao.getPostResourceByDepart(map));
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
	 *@category 保存岗位权限编辑
	 *@author wangbing
	 *@date 2016年2月20日11:24:12
	 *@return
	 */
	@Override
	public String savePostResource(Pagination page, SysUser user){
		String adds = page.getConditions().get("adds").toString();
		String dels = page.getConditions().get("dels").toString();
		String roleId = page.getConditions().get("roleId").toString();
		String userId = page.getConditions().get("userId").toString();
		String userName = page.getConditions().get("userName").toString();
		String postId=page.getConditions().get("postId").toString();
		if(StringUtils.isNotBlank(dels)){
			sysPostDao.deletePostResource(roleId,dels.split(","));
		}
		if(StringUtils.isNotBlank(adds)){
			List<SysRoleResource> list = new ArrayList<SysRoleResource>();
			String[] add = adds.split(",");
			for(int i=0;i<add.length;i++){
				SysRoleResource srr = new SysRoleResource();
				srr.setRoleId(Integer.parseInt(roleId));
				srr.setResourceId(Integer.parseInt(add[i]));
				srr.setIsUsing(1);
				
				srr.setType(user.getUserType());//类型 TODO 是从user.Role中取?
				srr.setBelongOrg(user.getOrgId());
				srr.setBelongDepartmentId(user.getSysDepartment().getDepartmentId());
				srr.setBelongPostId(Integer.parseInt(postId));
				
				srr.setAddUserId(userId);
				srr.setAddUserName(userName);
//				srr.setAddTime(new Date(System.currentTimeMillis())); // oracle
				srr.setAddTime(new Timestamp(new Date().getTime())); // mysql
				/*srr.setLastUpdateUserId(userId);
				srr.setLastUpdateUserName(userName);
				srr.setLastUpdateTime(new Date(System.currentTimeMillis()));*/
				list.add(srr);
			}
			sysPostDao.addPostResource(list);
		}
		JSONObject jsonObject = new JSONObject(page);
		return jsonObject.toString();
	}
	

	/**
	 * 
	 *@category 根据岗位id获取角色id
	 *@author wangbing
	 *@date 2016年2月20日11:24:12
	 *@return
	 */
	@Override
	public Map<String,Object> getRoleByPostId(String id){
		Map<String, String> map = new HashMap<String, String>();
		map.put("postId", id);
		return sysPostDao.getRoleByPostId(map);
	}
	
	/**
	 * 
	 *@category 获取岗位列表
	 *@author wangbing
	 *@date 2016年2月20日11:24:12
	 *@return
	 */
	@Override
	public String getPostList(Pagination page) {
		PageHelper.startPage(page.getPage(), page.getMaxResults());
		Page<Map<String, Object>> sysPost = sysPostDao.getPostList(page.getConditions());
		page.setRows(sysPost);
		page.setRecords(sysPost.getTotal());
		JSONObject jsonObject = new JSONObject(page);
		return jsonObject.toString();
	}

	
	@Override
	public int updateSysPostIsUsings(String[] ids, Integer state, SysUser sysUser) {
		SysPost sysPost = new SysPost();
		sysPost.setIsUsing(state);
		
		sysPost.setLastUpdateUserId(sysUser.getUserId());
		sysPost.setLastUpdateUserName(sysUser.getName()+"("+sysUser.getUserName()+")");
		
		SysRoleResource sysRoleResource=new SysRoleResource();
		sysRoleResource.setIsUsing(state);
		Map<String, Object> param=new HashMap<String, Object>();
		param.put("belongPostIds", ids);
		sysRoleResourceDao.updateByParams(param, sysRoleResource);
		return sysPostDao.updateByIds(ids, sysPost);
	}
	
	
	/**
	 * 
	 *@category 根据id查询岗位信息（详情、编辑页面）
	 */
	@Override
	public Map<String, Object> getPostDetail(Integer postId, int userTyp) {
		Integer userType=(Integer) userTyp;
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("postId", postId);
		if (UserType.jkzx.getKey().equals(userType)) {// 医疗机构
			map.put("hosId", "sss");
		} else if (UserType.scqy.getKey().equals(userType)) {// 企业
			map.put("comId", "sss");
		} else if (UserType.cgzx.getKey().equals(userType) || UserType.wsj.getKey().equals(userType)) {
			map.put("orgId", "sss");
		} 
		return sysPostDao.getPostDetail(map);
	}




	@Override
	public List<SysPost> getReviewPostName(SysPost sysPost) {
		return sysPostDao.getReviewPostName(sysPost);
	}




	@Override
	public String getJGPostListPro(Pagination page) {
		PageHelper.startPage(page.getPage(), page.getCount(), page.getOrderby());
		Page<Map<String, Object>> models = (Page<Map<String, Object>>) sysPostDao.getJGPostListPro(page.getConditions());
		page.setRows(models);
		page.setRecords(models.getTotal());
		printLog("查询",page,"分页查询");
		JSONObject jsonObject = new JSONObject(page);
		return jsonObject.toString();
	}

	@Override
	public String getJGPostListCity(Pagination page) {
		PageHelper.startPage(page.getPage(), page.getCount(), page.getOrderby());
		Page<Map<String, Object>> models = (Page<Map<String, Object>>) sysPostDao.getJGPostListCity(page.getConditions());
		page.setRows(models);
		page.setRecords(models.getTotal());
		printLog("查询",page,"分页查询");
		JSONObject jsonObject = new JSONObject(page);
		return jsonObject.toString();
	}

	@Override
	public String getJGPostListCounty(Pagination page) {
		PageHelper.startPage(page.getPage(), page.getCount(), page.getOrderby());
		Page<Map<String, Object>> models = (Page<Map<String, Object>>) sysPostDao.getJGPostListCounty(page.getConditions());
		page.setRows(models);
		page.setRecords(models.getTotal());
		printLog("查询",page,"分页查询");
		JSONObject jsonObject = new JSONObject(page);
		return jsonObject.toString();
	}
	
	/**
	 * 可用于日志处理，打印一些通用的操作
	 * @param
	 * @param params
	 * @param opt
	 * @param msg
	 */
	public void printLog(String opt,Object params,String msg){
		if(log.isDebugEnabled() && msg=="true"){
			Type type = ((ParameterizedType)this.getClass().getGenericSuperclass()).getActualTypeArguments()[0];
			System.out.println("实体："+type.getClass().getName());
			System.out.println("操作："+opt);
			System.out.println("参数："+JSON.toJSONString(params,SerializerFeature.NotWriteDefaultValue));
			System.out.println("信息："+msg);
		}
	}
	
	@Override
	public SysPost getById(int id) {
		printLog("查询",id,"根据ID");
		
		SysPost model = sysPostDao.get(id);
		return model;
	}
}