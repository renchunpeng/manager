package com.hsnn.medstgmini.base.sys.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.hsnn.medstgmini.Constants;
import com.hsnn.medstgmini.base.std.dao.StdCompanyDao;
import com.hsnn.medstgmini.base.std.dao.StdHospitalDao;
import com.hsnn.medstgmini.base.std.dao.StdManageOrgDao;
import com.hsnn.medstgmini.base.std.model.StdCompanys;
import com.hsnn.medstgmini.base.std.model.StdHospitals;
import com.hsnn.medstgmini.base.std.model.StdManageOrg;
import com.hsnn.medstgmini.base.sys.dao.*;
import com.hsnn.medstgmini.base.sys.form.SysUserForm;
import com.hsnn.medstgmini.base.sys.model.*;
import com.hsnn.medstgmini.base.sys.service.ISysUser;
import com.hsnn.medstgmini.common.model.UserType;
import com.hsnn.medstgmini.util.EmailUtil;
import com.hsnn.medstgmini.util.Pagination;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang.NullArgumentException;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.mail.Session;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class SysUserManagerImpl implements ISysUser {
	private static final Logger log = Logger.getLogger(SysUserManagerImpl.class);

	@Autowired
	private SysUserDao sysUserDao;
	
	@Autowired
	private SysDepartmentDao sysDepartmentDao;
	
	@Autowired
	private SysRoleDao sysRoleDao;
	
	@Autowired
	private StdCompanyDao stdCompanyDao;
	
	@Autowired
	private StdManageOrgDao stdManageOrgDao;
	
	@Autowired
	private StdHospitalDao stdHospitalDao;
	
	@Autowired
	private SysPostDao sysPostDao;
	
	@Autowired
	private SysUserResourceDao sysUserResourceDao ;
	
	@Autowired
	private SysRoleResourceDao sysRoleResourceDao;

	@Override
	public int updateUserInfoFirstLogin(SysUser user) {
		return sysUserDao.updateUserInfoFirstLogin(user);
	}

	public int updateUserInfoFirstLoginC(SysUser user) {
		return sysUserDao.updateUserInfoFirstLoginC(user);
	}

	public int updateUserIsUsing(SysUser user) {
		return sysUserDao.updateUserIsUsing(user);
	}

	@Override
	public SysUser selectSysUserByUsername(String username) {
		return sysUserDao.selectSysUserByUsername(username);
	}
	@Override
	public SysUser selectSysUserByEmail(String email) {
		return sysUserDao.selectSysUserByEmail(email);
	}
	@Override
	public SysUser selectSysUserByResetToken(String resetToken) {
		return sysUserDao.selectSysUserByResetToken(resetToken);
	}
	
	//疫苗忘记密码
	@Override
	public void sendEmail(SysUser user, String address,Pagination page) throws Exception {
		Properties prop = new Properties();
		String resetToken = "";
		prop.load(EmailUtil.class.getResourceAsStream("/mail.properties"));
        prop.put("addresses", address);
        StringBuilder url =new StringBuilder();
         
    			resetToken = UUID.randomUUID().toString();
    			String time = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
    			url.append(page.getConditions().get("rootUrl"))
    			.append(page.getConditions().get("webAppName"))
    			.append("/resetPsw/toResetPsw.html")
    			.append("?sign=").append(resetToken)
    			.append("&token=").append(DigestUtils.md5Hex(user.getUserName()+time));
				EmailUtil.sendTextMail(prop, "找回云南省政府采购和出让中心密码",body(url.toString(),user.getUserName()));
				user.setResetToken(resetToken);
				user.setResetTime(time);
    	sysUserDao.update(user);
	}

	
	public String body(String url,String userName){
		StringBuffer head =new StringBuffer();
		head.append("<h4>").append(userName).append("，您好！</h4></br>")
		.append("&nbsp;&nbsp;您正在进行云南省政府采购和出让中心密码找回，点击以下链接完成验证，重新设置密码。</br>")
		.append("<a href =").append(url).append(">").append(url).append("</a></br>")
		.append("<pre>（该链接在24小时内有效，24小时后需要重新获取验证邮件）</pre></br>")
		.append("<pre>如果该链接无法点击，请将其复制粘贴到你的浏览器地址栏中访问。</pre>")
		.append("<pre>如果这不是您的邮件，请忽略此邮件。</pre>")
		.append("这是云南省政府采购和出让中心系统邮件，请勿回复。");
		return head.toString();
	}
	
	//单点登录忘记密码
	@Override
	public void sendEmailSSO(SysUser user, String address,Pagination page) throws Exception {
		Properties prop = new Properties();
		String resetToken = "";
		prop.load(EmailUtil.class.getResourceAsStream("/mail.properties"));
        prop.put("addresses", address);
        StringBuilder url =new StringBuilder();
         
    			resetToken = UUID.randomUUID().toString();
    			String time = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
    			url.append(page.getConditions().get("rootUrl"))
    			.append(page.getConditions().get("webAppName"))
    			.append("/resetPsw/toResetPsw.html")
    			.append("?sign=").append(resetToken)
    			.append("&token=").append(DigestUtils.md5Hex(user.getUserName()+time));
				EmailUtil.sendTextMail(prop, "找回云南省药品集中采购系统的密码",bodySSO(url.toString(),user.getUserName()));
				user.setResetToken(resetToken);
				user.setResetTime(time);
    	sysUserDao.update(user);
	}

	
	public String bodySSO(String url,String userName){
		StringBuffer head =new StringBuffer();
		head.append("<h4>").append(userName).append("，您好！</h4></br>")
		.append("&nbsp;&nbsp;您正在进行云南省药品集中采购系统的密码找回，点击以下链接完成验证，重新设置密码。</br>")
		.append("<a href =").append(url).append(">").append(url).append("</a></br>")
		.append("<pre>（该链接在24小时内有效，24小时后需要重新获取验证邮件）</pre></br>")
		.append("<pre>如果该链接无法点击，请将其复制粘贴到你的浏览器地址栏中访问。</pre>")
		.append("<pre>如果这不是您的邮件，请忽略此邮件。</pre>")
		.append("这是云南省药品集中采购系统的系统邮件，请勿回复。");
		return head.toString();
	}
	
	
	
	
	
	@Override
	public boolean restPsw(Pagination page) {
		/*SysUser user = sysUserDao.get(page.getConditions().get("userId").toString());
		String jgcz = page.getConditions().get("jgcz").toString();
		if(user.getAcctType()==Constants.BUSINESS_ACCOUNTS || "1".equals(jgcz)){
			user.setUserPassword(page.getConditions().get("newpassword").toString());
			return sysUserDao.update(user)==1;
		}else{
			if(StringUtils.isBlank(user.getResetToken())){
				return false;
			}
			user.setUserPassword(page.getConditions().get("newpassword").toString());
			user.setResetToken("");
			user.setResetTime(null);
			return sysUserDao.update(user)==1;
		}*/
		SysUser user = sysUserDao.get(page.getConditions().get("userId").toString());
		if(user.getAcctType()==Constants.BUSINESS_ACCOUNTS){
			user.setUserPassword(page.getConditions().get("newpassword").toString());
			return sysUserDao.update(user)==1;
		}else{
			if(StringUtils.isBlank(user.getResetToken())){
				return false;
			}
			user.setUserPassword(page.getConditions().get("newpassword").toString());
			user.setResetToken("");
			user.setResetTime(null);
			return sysUserDao.update(user)==1;
		}
		
		

	
	}
	
	/**
	 * 用户信息查询
	 */
	public String getSysUserManager(Pagination page) {
		PageHelper.startPage(page.getPage(), page.getCount());
		Page<SysUserDepartPost> sysUserDepartPostPage = (Page<SysUserDepartPost>) sysUserDao.queryAllDataSysUser(page.getConditions());
		page.setRows(sysUserDepartPostPage);
		page.setRecords(sysUserDepartPostPage.getTotal());
		JSONObject jsonObject = new JSONObject(page);
		return jsonObject.toString();
	}

	/**
	 * 用户信息数据保存
	 */
	public void saveSysUser(SysUser sysUser) {
		
		sysUserDao.save(sysUser);
	}
	
	/**
	 * @desc 
	 * @param sysUser
	 */
	public int saveUser(SysUser sysUser) {
		return sysUserDao.save(sysUser);
	}

	/**
	 * 校验用户名称是否已经存在
	 */
	public boolean testSysUserName(String userName){
		//根据登录帐号得到用户信息
	    SysUser sysUser = sysUserDao.selectSysUserByUsername(userName);
	    if(sysUser != null){
	    	return false;
	    }else{
	    	return true;
	    }
	}
	
	/**
	 * 用户信息资源信息数据保存
	 */
	public void saveSysUserResource(SysUser sysUser,Pagination page) {
		Object postId = page.getConditions().get("postId");
		if(null != postId && StringUtils.isNotBlank(postId.toString())){
			int roleId =  sysUserDao.getRoleIdByPostId(String.valueOf(page.getConditions().get("postId")));
			sysUser.setRoleId(roleId);
		}
		sysUser.setOrgId(sysUser.getOrgId());//机构编号
		sysUser.setUserType(sysUser.getUserType());//用户类型
		saveSysUser(sysUser);
		if(postId == null || StringUtils.isBlank(postId.toString())){
			String adds = page.getConditions().get("adds").toString();
			String userId = page.getConditions().get("userId").toString();
			String updUserId = page.getConditions().get("updUserId").toString();
			String userName = page.getConditions().get("userName").toString();
			if(StringUtils.isNotBlank(adds)){
				List<SysUserResource> list = new ArrayList<SysUserResource>();
				String[] add = adds.split(",");
				for(int i=0;i<add.length;i++){
					SysUserResource srr = new SysUserResource();
					srr.setUserId(userId);
					srr.setResourceId(Integer.parseInt(add[i]));
					srr.setIsUsing(1);
					srr.setType(sysUser.getUserType());
					srr.setAddUserId(updUserId);
					srr.setAddUserName(userName);
//					srr.setAddTime(new Date(System.currentTimeMillis()));// oracle
					srr.setAddTime(new Timestamp(System.currentTimeMillis()));// mysql
					/*srr.setLastUpdateUserId(updUserId);
					srr.setLastUpdateUserName(userName);
					srr.setLastUpdateTime(new Date(System.currentTimeMillis()));*/
					srr.setBelongOrg(sysUser.getOrgId());
					srr.setBelongDepartmentId(sysUser.getDepartmentId());
					list.add(srr);
				}
				sysUserDao.addUserResource(list);
			}
		}
	}

	/**
	 * 查询部门所有id和名称
	 */
	public List<SysDepartment> findDepartmentIdAndName(SysDepartment department) {
		List<SysDepartment> list = sysDepartmentDao.findDepartmentIdAndName(department);
		return list;
	}

	public int updateUserDisabale(SysUser sysUser) {
		return sysUserDao.updateUserDisabale(sysUser);
	}
	
	/**
	 * @category 保存登陆ip，登陆时间，登陆次数等信息
	 * @date 2016年2月22日
	 * @param
	 */
	public void updateLoginInfo(String loginIp, String userId) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("loginIp",loginIp);
		map.put("userId",userId);
		map.put("lastLoginTime",new Date());
		sysUserDao.updateLoginInfo(map);
	}

	/**
	 * 获取启用用户数据
	 */
	public String getSysUserStartData(Pagination page) {
		PageHelper.startPage(page.getPage(), page.getCount());
		Page<SysUserDepartPost> sysUserDepartPostPage = (Page<SysUserDepartPost>)sysUserDao.queryAllDataStartSysUser(page.getConditions());
		page.setRows(sysUserDepartPostPage);
		page.setRecords(sysUserDepartPostPage.getTotal());
		JSONObject jsonObject = new JSONObject(page);
		return jsonObject.toString();
	}
	
	/**
	 * 获取停用用用户数据
	 */
	public String getSysUserStopData(Pagination page) {
		PageHelper.startPage(page.getPage(), page.getCount());
		Page<SysUserDepartPost> sysUserDepartPostPage = (Page<SysUserDepartPost>)sysUserDao.queryAllDataStopSysUser(page.getConditions());
		page.setRows(sysUserDepartPostPage);
		page.setRecords(sysUserDepartPostPage.getTotal());
		JSONObject jsonObject = new JSONObject(page);
		return jsonObject.toString();
	}
	/**
	 * 更新用户表中状态
	 */
	public int updateSysUserIsUsing(SysUser sysUser) {
		return sysUserDao.updateSysUserIsUsing(sysUser);
	}
	
	
	/**
	 * @category 根据用户id查询用户数据
	 * @author 韩守松
	 * @date   2016年2月22日
	 * @param  @param userId
	 * @param  @return
	 */
	public SysUserDepartPost querySysUserDataById(String userId){
		List<SysUserDepartPost> list = sysUserDao.querySysUserDataById(userId);
		if(list.size()>0){
			SysUserDepartPost sysUserDepartPost = list.get(0);
			return sysUserDepartPost;
		}else{
			return new SysUserDepartPost(); 
		}
	}

	/**
	 * @category 查询用户对应的机构信息
	 * @author 应晓川
	 * @date   2016年2月22日14:14:00
	 * @param
	 */
	@Override
	public String getUserListByHosp(Pagination page) {
		PageHelper.startPage(page.getPage(), page.getCount());
		Page<Map<String, Object>> map =  (Page<Map<String, Object>>) sysUserDao.getUserListByHosp(page.getConditions());
		page.setRows(map);
		page.setRecords(map.getTotal());
		JSONObject jsonObject = new JSONObject(page);
		return jsonObject.toString();
	}
	
	/**
	 * @category 查询企业用户
	 * @author 应晓川
	 * @date   2016年2月22日14:14:00
	 * @param
	 */
	@Override
	public String getUserListByComp(Pagination page) {
		PageHelper.startPage(page.getPage(), page.getCount());
		Page<Map<String, Object>> map =  (Page<Map<String, Object>>) sysUserDao.getUserListByComp(page.getConditions());
		page.setRows(map);
		page.setRecords(map.getTotal());
		JSONObject jsonObject = new JSONObject(page);
		return jsonObject.toString();
	}
	
	/**
	 * @category 查询监管机构用户
	 * @author 应晓川
	 * @date   2016年2月22日14:14:00
	 */
	@Override
	public String getUserListBySupervision(Pagination page) {
		PageHelper.startPage(page.getPage(), page.getCount());
		Page<Map<String, Object>> map =  (Page<Map<String, Object>>) sysUserDao.getUserListBySupervision(page.getConditions());
		page.setRows(map);
		page.setRecords(map.getTotal());
		JSONObject jsonObject = new JSONObject(page);
		return jsonObject.toString();
	}
	/**
	 * 更新用户信息
	 */
	public void updateSysUserDepartPost(SysUser su,Pagination page) {
		sysUserDao.update(su);
		//saveUserResource(page);
	}

	/**
	 * 根据用户id获取用户信息
	 */
	public SysUser findSysUserDataById(String userId) {
		List<SysUser> list = sysUserDao.findSysUserDataById(userId);
		SysUser sysUser = list.get(0);
		return sysUser;
	}
	
	/**
	 * 更新用户密码
	 */
	@Override
	public void updateSysUserPassWordById(SysUserForm form){
		SysUser user = new SysUser();
		BeanUtils.copyProperties(form, user);
		sysUserDao.updateSysUserPassWordById(user);
		
	}
	
	@Override
	public List<SysUser> getSysUserQuery(Map<String, Object> map) {
		return sysUserDao.queryAll(map);
	}
	@Override
	public int updateSysUser(SysUser sysUser) {
		return sysUserDao.updateSysUser(sysUser);
	}
	@Override
	public String getResourceListByUser(Map<String, Object> map) {
		return toPrivTree(sysUserDao.getResourceListByUser(map));
	}
	
	/**
	 * 
	 *@category 获取用户列表
	 *@author wangbing
	 *@date 2016年2月23日18:44:22
	 *@return
	 */
	@Override
	public String getUserList(Pagination page) {
		PageHelper.startPage(page.getPage(), page.getCount());
		Page<SysUserDepartPost> sysUserDepartPostPage = (Page<SysUserDepartPost>) sysUserDao.queryAllDataSysUser(page.getConditions());
		page.setRows(sysUserDepartPostPage);
		page.setRecords(sysUserDepartPostPage.getTotal());
		JSONObject jsonObject = new JSONObject(page);
		return jsonObject.toString();
	}
	
	/**
	 * 
	 *@category 获取用户权限集合
	 *@author wangbing
	 *@date 2016年2月20日11:24:12
	 *@return
	 */
	@Override
	public String getUserResource(Map<String, Object> map){
		return toPrivTree(sysUserDao.getUserResource(map));
	}
	/**
	 * 获取部门用户权限
	 */
	public String getDepartmentUserResource(Map<String, Object> map){
		return toPrivTree(sysUserDao.getDepartmentUserResource(map));
	}
	
	/**
	 * 获取岗位用户权限
	 */
	public String getPostUserResource(Map<String, Object> map){
		return toPrivTree(sysUserDao.getPostUserResource(map));
	}
	/**
	 * 
	 *@category 根据部门获取用户权限集合
	 *@author wangbing
	 *@date 2016年2月20日11:24:12
	 *@return
	 */
	@Override
	public String getUserResourceByDepart(Map<String, Object> map){
		return toPrivTree(sysUserDao.getUserResourceByDepart(map));
	}
	
	/**
	 * 
	 *@category 根据岗位获取用户权限集合
	 *@author wangbing
	 *@date 2016年2月20日11:24:12
	 *@return
	 */
	@Override
	public String getUserResourceByPost(Map<String, Object> map){
		return toPrivTree(sysUserDao.getUserResourceByPost(map));
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
	 *@category 保存用户权限编辑
	 *@author wangbing
	 *@date 2016年2月20日11:24:12
	 *@return
	 */
	@Override
	public String saveUserResource(Pagination page){
		String adds = page.getConditions().get("adds").toString();
		String dels = page.getConditions().get("dels").toString();
		String userId = page.getConditions().get("userId").toString();
		String updUserId = page.getConditions().get("updUserId").toString();
		String userName = page.getConditions().get("userName").toString();
		String postId = page.getConditions().get("postId").toString();
		int departmentId = Integer.parseInt(page.getConditions().get("departmentId").toString());
		String orgId = page.getConditions().get("orgId").toString();
		int userType = Integer.parseInt(page.getConditions().get("userType").toString());
		if(StringUtils.isNotBlank(postId)){
			Map<String,Object> map = new HashMap<String,Object>();
			map.put("updUserId", updUserId);
			map.put("userName", userName);
			map.put("postId", postId);
			map.put("userId", userId);
			sysUserDao.updatePostId(map);
			sysUserDao.deleteResourceByUserId(userId);
		}else{
			Map<String,Object> map = new HashMap<String,Object>();
			map.put("updUserId", updUserId);
			map.put("userName", userName);
			map.put("userId", userId);
			sysUserDao.updatePostIdNull(map);
			if(StringUtils.isNotBlank(dels)){
				sysUserDao.deleteUserResource(userId,dels.split(","));
			}
			if(StringUtils.isNotBlank(adds)){
				List<SysUserResource> list = new ArrayList<SysUserResource>();
				String[] add = adds.split(",");
				for(int i=0;i<add.length;i++){
					SysUserResource srr = new SysUserResource();
					srr.setUserId(userId);
					srr.setResourceId(Integer.parseInt(add[i]));
					srr.setIsUsing(1);
					srr.setType(userType);
					srr.setAddUserId(updUserId);
					srr.setAddUserName(userName);
					srr.setAddTime(new Timestamp(System.currentTimeMillis()));
					/*srr.setLastUpdateUserId(updUserId);
					srr.setLastUpdateUserName(userName);
					srr.setLastUpdateTime(new Date(System.currentTimeMillis()));*/
					srr.setBelongOrg(orgId);
					srr.setBelongDepartmentId(departmentId);
					list.add(srr);
				}
				sysUserDao.addUserResource(list);
			}
		}
		JSONObject jsonObject = new JSONObject(page);
		return jsonObject.toString();
	}
	
	
	
	/**
	 * 登录时根据登录帐号查询用户信息
	 * @param username
	 * @return
	 */
	public SysUser getUserByUsername(String username) {
		//根据登录帐号得到用户信息
		SysUser sysUser = sysUserDao.selectSysUserByUsername(username);
		
		if (sysUser != null) {
			//String orgId = sysUser.getOrgId();//机构编号
			SysDepartment sysDepartment = null;
			//判断部门是否为空
			if(sysUser.getDepartmentId()!=null) {
				sysDepartment = sysDepartmentDao.get(sysUser.getDepartmentId());
				sysUser.setSysDepartment(sysDepartment);
			}
			//判断岗位编号是否为空
			if(sysUser.getPostId()!=null) {
				SysPost sysPost = sysPostDao.get(sysUser.getPostId());//岗位信息
				sysUser.setSysPost(sysPost);//添加岗位信息
			}
			
			
			/*//根据用户中的角色编号获取角色信息
			SysRole sysRole = sysRoleDao.getRoleById(sysUser.getRoleId());
			//判断角色是否为空并且判断角色类型是否符合规范
			if (sysRole != null && sysRole.getRoleType()>=0) {
				
				//角色类型：0:自建、1.生产企业、2.经营企业、3. 生产企业和经营企业，4.医疗机构，5.药械中心，6.监管机构
				int roleType = sysRole.getRoleType();
				if(sysDepartment != null) {
					roleType = sysDepartment.getDepartmentType();//部门类型
				}
				addOrgInfo(roleType, orgId, sysUser);
			}else {//业务用户
				if(sysUser.getAcctType() == 1) {
					if(sysDepartment != null) {
						addOrgInfo(sysDepartment.getDepartmentType(), orgId, sysUser);
						sysUser.setFatherName(sysDepartment.getGroupName());
					}
				}
			}*/
			//addOrgInfo(sysUser.getUserType(), orgId, sysUser,sysDepartment);
			
		}
		return sysUser;
	}
	
	private void addOrgInfo(int roleTyp, String orgId, SysUser sysUser, SysDepartment sysDepartment) {
		Integer roleType = (Integer) roleTyp;
		if(StringUtils.isBlank(orgId)){
			throw new NullArgumentException("orgId can not be found !");
		}
		if (UserType.jkzx.getKey().equals(roleType)) {// 医疗机构
			StdHospitals stdHospitals = new StdHospitals();
			BeanUtils.copyProperties(stdHospitalDao.get(orgId), stdHospitals);
			sysUser.setStdHospital(stdHospitals);
			if(sysUser.getStdHospital() != null) {
				StdHospitals sh = sysUser.getStdHospital();
				sysUser.setFatherName(sh.getHospitalName());
			}
		} else if (UserType.scqy.getKey().equals(roleType)) {// 企业
			StdCompanys stdCompany = new StdCompanys();
			BeanUtils.copyProperties(stdCompanyDao.get(orgId), stdCompany);
			sysUser.setStdCompany(stdCompany);
			if(sysUser.getStdCompany() != null) {
				StdCompanys sc = sysUser.getStdCompany();
				sysUser.setFatherName(sc.getCompanyName());
			}
		} else if (UserType.cgzx.getKey().equals(roleType) || UserType.wsj.getKey().equals(roleType)) {
			StdManageOrg smo =  stdManageOrgDao.get(orgId);
			if (smo != null) {
				sysUser.setStdManageOrg(smo);
				if(sysUser.getStdManageOrg() != null) {
					StdManageOrg sm = (StdManageOrg)sysUser.getStdManageOrg();
					sysUser.setFatherName(sm.getHeaBurName());
				}
			}
		}
		
		if(sysUser.getAcctType() == 1) {//管理帐号
			if(sysDepartment != null) {
				sysUser.setFatherName(sysDepartment.getGroupName());
			}
		}
	}
	@Override
	public int addUserAndResList(SysUser sysUser, List<SysUserResource> list) {
	   sysUser.setOrgId(sysUser.getOrgId());//机构编号
	   sysUser.setUserType(sysUser.getUserType());//用户类型
	   int i = sysUserDao.save(sysUser);
	   if(i > 0){
		   for (SysUserResource sysUserResource : list) {
			   sysUserResource.setUserId(sysUser.getUserId());
		   }
		   sysUserResourceDao.insertBatch(list);
	   }
		return i;
	}
	
	@Override
	public List<SysUser> queryRepeatUserName(Map<String, Object> map){
		return sysUserDao.queryRepeatUserName(map);
	}
	@Override
	public List<SysUser> getSysUsersBy0rgId(String orgId) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("orgId", orgId);
		List<SysUser> sysUsers = new ArrayList<SysUser>();
		sysUsers = sysUserDao.queryAll(map);
		return sysUsers;
	}
	@Override
	public List<SysUser> getSysUserListById(String[] ids) {	
		return sysUserDao.getSysUserListById(ids);
	}
	
	public SysUser getIsOrg(String userName) {
		return sysUserDao.getIsOrg(userName);
	}
	
	/**
	 * @category 医院用户启用停用
	 * @author wangbing
	 * @date 2016年6月14日下午5:07:44
	 * @parameter
	 * @return
	 */
	@Override
	public int updateHospUserIsUsing(Map<String,Object> map){
		return sysUserDao.updateHospUserIsUsing(map);
	}
	@Override
	public String getJGUserListPro(Pagination page) {
		PageHelper.startPage(page.getPage(), page.getCount(), page.getOrderby());
		Page<Map<String, Object>> models = (Page<Map<String, Object>>) sysUserDao.getJGUserListPro(page.getConditions());
		page.setRows(models);
		page.setRecords(models.getTotal());
		printLog("查询",page,"分页查询");
		JSONObject jsonObject = new JSONObject(page);
		return jsonObject.toString();
	}
	@Override
	public String getJGUserListCity(Pagination page) {
		PageHelper.startPage(page.getPage(), page.getCount(), page.getOrderby());
		Page<Map<String, Object>> models = (Page<Map<String, Object>>) sysUserDao.getJGUserListCity(page.getConditions());
		page.setRows(models);
		page.setRecords(models.getTotal());
		printLog("查询",page,"分页查询");
		JSONObject jsonObject = new JSONObject(page);
		return jsonObject.toString();
	}
	@Override
	public String getJGUserListCounty(Pagination page) {
		PageHelper.startPage(page.getPage(), page.getCount(), page.getOrderby());
		Page<Map<String, Object>> models = (Page<Map<String, Object>>) sysUserDao.getJGUserListCounty(page.getConditions());
		page.setRows(models);
		page.setRecords(models.getTotal());
		printLog("查询",page,"分页查询");
		JSONObject jsonObject = new JSONObject(page);
		return jsonObject.toString();
	}
	
	/**
	 * 可用于日志处理，打印一些通用的操作
	 * @param model
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
	public SysUser getById(String id) {
		printLog("查询",id,"根据ID");
		
		SysUser model = sysUserDao.get(id);
		return model;
	}
	
	@Override
	public List<SysUser> getLists(Map<String, Object> params) {
		printLog("查询",params,"普通查询");
		return sysUserDao.queryAll(params);
	}
	@Override
	public String getList(Pagination page) {
		PageHelper.startPage(page.getPage(), page.getCount(), page.getOrderby());
		Page<SysUser> models = (Page<SysUser>) sysUserDao.queryAll(page.getConditions());
		page.setRows(models);
		page.setRecords(models.getTotal());
		printLog("查询",page,"分页查询");
		JSONObject jsonObject = new JSONObject(page);
		return jsonObject.toString();
	}
	@Override
	public boolean addSysUser(SysUser su) {
		// TODO Auto-generated method stub
		return sysUserDao.addSysUser(su);
	}
	@Override
	public boolean addSysUserRoleAndPrivilegeYY(String id,Integer drugPurchaseProperty,SysRole sysRole,Integer userType,String userId, String roleId,
			Date updTime, String updUser) {
			if (sysRoleDao.addSysRole(sysRole)) {
				if(drugPurchaseProperty == 3){
					Integer roleId1 = 1355;
					sysUserDao.updateSysUserRole(roleId1,userId);
				}else if(drugPurchaseProperty == 1 || drugPurchaseProperty == 2){
					sysUserDao.updateSysUserRole(sysRole.getRoleId(),userId);
				}
				
				List<SysRoleResource> sysRoleResource2 = sysRoleResourceDao.getResource(userType);
				for(int i=0; i < sysRoleResource2.size() ;i++){
					SysUserResource  sysUserResource = new SysUserResource();
					sysUserResource.setUserId(userId);
					sysUserResource.setResourceId(sysRoleResource2.get(i).getResourceId());
					sysUserResource.setBelongOrg(sysRoleResource2.get(i).getBelongOrg());
					sysUserResource.setBelongDepartmentId(sysRoleResource2.get(i).getBelongDepartmentId());
					sysUserResource.setBelongPostId(sysRoleResource2.get(i).getBelongPostId());
					sysUserResource.setIsUsing(1);
					sysUserResource.setType(sysRoleResource2.get(i).getType());
					sysUserResource.setAddTime(sysRoleResource2.get(i).getAddTime());
					sysUserResource.setAddUserId(sysRoleResource2.get(i).getAddUserId());
					sysUserResource.setAddUserName(sysRoleResource2.get(i).getAddUserName());
					sysUserResource.setLastUpdateTime(sysRoleResource2.get(i).getLastUpdateTime());
					sysUserResource.setLastUpdateUserId(sysRoleResource2.get(i).getLastUpdateUserId());
					sysUserResource.setLastUpdateUserName(sysRoleResource2.get(i).getLastUpdateUserName());
					sysUserResourceDao.addSysUserResource(sysUserResource);
				}
				
				
				Integer roleId2 = sysRole.getRoleId();
				List<String> list = sysRoleResourceDao.getRolePrivilegeList(userType);
				StringBuffer values = new StringBuffer();
				if(list!=null && list.size()>0){
					for(int i =0;i<list.size();i++){
						values.append("('"+userId+"','0','"+list.get(i).toString()+"'),");
						SysRoleResource  sysRoleResource = new SysRoleResource();
						
						if(drugPurchaseProperty == 3){
							Integer roleId1 = 1355;
							sysRoleResource.setRoleId(roleId1);
						}else if(drugPurchaseProperty == 1 || drugPurchaseProperty == 2){
							sysRoleResource.setRoleId(roleId2);
						}
						
						
						sysRoleResource.setResourceId(Integer.parseInt(list.get(i).toString()));
						sysRoleResource.setBelongOrg(id);
						sysRoleResource.setAddTime(new Timestamp(updTime.getTime())); //mysql
						sysRoleResource.setAddUserId(userId);
						sysRoleResource.setAddUserName(updUser);
						sysRoleResource.setLastUpdateTime(new Timestamp(updTime.getTime())); // mysql
						sysRoleResource.setLastUpdateUserId(userId);
						sysRoleResource.setLastUpdateUserName(updUser);
						sysRoleResourceDao.addPrivilege(sysRoleResource);
					}
				/*	SysRoleResource sysRoleResource = new SysRoleResource();
					sysRoleResource.setUserId(userId);
					sysRoleResource.setUpdTime(updTime);
					sysRoleResource.setList(list);*/
				//boolean temp = sysRoleResourceDao.addPrivilege(sysRoleResource);
				//return temp;
			}
			return false;

		}
			return false;
	}
	@Override
	public Pagination getSysUserByOrgId(Pagination page) {
		PageHelper.startPage(page.getPage(), page.getCount(), page.getOrderby());
		Page<SysUser> stdCompanies = (Page<SysUser>) this.sysUserDao.queryUserAll(page.getConditions());
		page.setRows(stdCompanies);
		page.setRecords(stdCompanies.getTotal());
		return page;
	}
	
	@Override
	public Pagination getCaUserList(Pagination page) {
		// TODO Auto-generated method stub
		PageHelper.startPage(page.getPage(), page.getCount());
		Page<Map<String, Object>> map =  sysUserDao.getCaUserList(page.getConditions());
		page.setRows(map);
		page.setRecords(map.getTotal());
		return page;
		
	}
	
	@Override
	public SysUser getUsercacodeById(String id) {
		// TODO Auto-generated method stub
		Map<String,Object> map =new HashMap<String,Object>();
		map.put("userId", id);
		return sysUserDao.getUsercacodeById(map);
	}
	
	public Pagination getCompTbUsercacode(Pagination page) {
		// TODO Auto-generated method stub
		PageHelper.startPage(page.getPage(), page.getCount());
		Page<Map<String, Object>> map =  sysUserDao.getCompTbUsercacode(page.getConditions());
		page.setRows(map);
		page.setRecords(map.getTotal());
		return page;
	}
	
	@Override
	public Pagination getSysUserCAData(Pagination page) {
		PageHelper.startPage(page.getPage(), page.getCount());
		Page<Map<String, Object>> map =  sysUserDao.getSysUserCAData(page.getConditions());
		page.setRows(map);
		page.setRecords(map.getTotal());
		return page;
	}
	@Override
	public void updateALLStart(SysUser sysUser) {
		sysUserDao.updateALLStart(sysUser);
	}
	@Override
	public void updateALLDisable(SysUser sysUser) {
		sysUserDao.updateALLDisable(sysUser);
	}

	@Override
	public SysUser getByRoleId(String userName) {
		// TODO Auto-generated method stub
		return sysUserDao.getByRoleId(userName);
	}

	@Override
	public void updateById(SysUser users) {
		// TODO Auto-generated method stub
		sysUserDao.updateById(users);
	}

	@Override
	public Pagination getSysUserDatas(Pagination page) {
		PageHelper.startPage(page.getPage(), page.getCount());
		Page<Map<String, Object>> map =  sysUserDao.getSysUserDatas(page.getConditions());
		page.setRows(map);
		page.setRecords(map.getTotal());
		return page;
	}
	@Override
	public SysUser getJcName(String id) {
		return sysUserDao.getJcName(id);
	}

	@Override
	public Pagination getSearchPwdData(Pagination page) {
		PageHelper.startPage(page.getPage(),page.getCount());
		Page<Map<String,Object>> map = sysUserDao.getSearchPwdData(page.getConditions());
		page.setRows(map);
		page.setRecords(map.getTotal());
		return page;
	}

	@Override
	public Pagination getBaseUserList(Pagination page) {
		PageHelper.startPage(page.getPage(), page.getCount(), page.getOrderby());
		Page<SysUser> stdCompanies = (Page<SysUser>) sysUserDao.getBaseUserList(page.getConditions());
		page.setRows(stdCompanies);
		page.setRecords(stdCompanies.getTotal());
		return page;
	}

	@Override
	public List<SysUser> getValidateData(Map<String, Object> map) {
		return sysUserDao.getValidateData(map);
	}

	@Override
	public SysUser getUserBySerialnumber(String serialnumber) {
		return sysUserDao.getUserBySerialnumber(serialnumber);
	}

	@Override
	public Pagination getCompanyUserData(Pagination page) {
		PageHelper.startPage(page.getPage(), page.getCount(), page.getOrderby());
		Page<SysUser> stdCompanies = sysUserDao.getCompanyUserData(page.getConditions());
		page.setRows(stdCompanies);
		page.setRecords(stdCompanies.getTotal());
		return page;
	}

	@Override
	@Transactional
	public int toBindCAData(Pagination page) {
		return sysUserDao.toBindCAData(page.getConditions());
	}

	@Override
	@Transactional
	public void toEmptyCA(Pagination page) {
		sysUserDao.toEmptyCA(page.getConditions());
	}

}


