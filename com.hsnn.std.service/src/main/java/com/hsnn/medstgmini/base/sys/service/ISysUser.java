package com.hsnn.medstgmini.base.sys.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.jws.WebService;

import com.hsnn.medstgmini.base.sys.form.SysUserForm;
import com.hsnn.medstgmini.base.sys.model.SysDepartment;
import com.hsnn.medstgmini.base.sys.model.SysRole;
import com.hsnn.medstgmini.base.sys.model.SysUser;
import com.hsnn.medstgmini.base.sys.model.SysUserDepartPost;
import com.hsnn.medstgmini.base.sys.model.SysUserResource;
import com.hsnn.medstgmini.util.Pagination;

@WebService
public interface ISysUser {
	int updateUserInfoFirstLoginC(SysUser user);
	int updateUserInfoFirstLogin(SysUser user);
	int updateUserIsUsing(SysUser user);
	SysUser selectSysUserByUsername(String username);
	SysUser selectSysUserByEmail(String email);
	SysUser selectSysUserByResetToken(String resetToken);
	void sendEmail(SysUser user,String address,Pagination page) throws Exception;
	void sendEmailSSO(SysUser user,String address,Pagination page) throws Exception;
	boolean restPsw(Pagination page);
	
	/**
	 * @category 获取部门用户查看列表数据
	 * @author 韩守松
	 * @date   2016年2月19日
	 * @param  @param page
	 * @param  @return
	 */
	String getSysUserManager(Pagination page);
	
	/**
	 * @category 保存部门用户信息数据
	 * @author 韩守松
	 * @date   2016年2月19日
	 * @param  @param sysUser
	 */
	void saveSysUser(SysUser sysUser);
	
	/**
	 * @category 校验用户名称是否已存在
	 * @author 韩守松
	 * @date   2016年2月29日
	 * @param  @param userName
	 * @param  @return
	 */
	boolean testSysUserName(String userName);
	
	/**
	 * @category 保存部门用户信息资源数据
	 * @author 韩守松
	 * @date   2016年2月19日
	 * @param  @param sysUser
	 */
	void saveSysUserResource(SysUser sysUser,Pagination page);
	
	/**
	 * @category 查询出部门所有id和名称
	 * @author 韩守松
	 * @date   2016年2月20日
	 * @param  @return
	 */
	List<SysDepartment> findDepartmentIdAndName(SysDepartment department); 
	
	/**
	 * @desc 根据部门id停用用户
	 * @author wangs
	 * @param sysUser
	 * @return
	 */
	int updateUserDisabale(SysUser sysUser);
	

	/**
	 * @category 获取启用用户列表数据
	 * @author 韩守松
	 * @date   2016年2月19日
	 * @param  @param page
	 * @param  @return
	 */
	String getSysUserStartData(Pagination page);
	
	/**
	 * @category 获取停用用户列表数据
	 * @author 韩守松
	 * @date   2016年2月19日
	 * @param  @param page
	 * @param  @return
	 */
	String getSysUserStopData(Pagination page);
	
	/**
	 * @category 更新用户表中状态
	 * @author 韩守松
	 * @date   2016年2月22日
	 * @param  @param sysUser
	 * @param  @return
	 */
	int updateSysUserIsUsing(SysUser sysUser);
	
	/**
	 * @category 根据用户id查询用户数据
	 * @author 韩守松
	 * @date   2016年2月22日
	 * @param  @param userId
	 * @param  @return
	 */
	SysUserDepartPost querySysUserDataById(String userId);
	
	/**
	 * @category 更新用户信息
	 * @author 韩守松
	 * @date   2016年2月22日
	 * @param  @param sysUserDepartPost
	 */
	void updateSysUserDepartPost(SysUser su,Pagination page);
	/**
	 * @category 查询医院用户
	 * @author 应晓川
	 * @date   2016年2月22日14:14:00
	 * @param  Pagination
	 */
	String getUserListByHosp(Pagination page);
	
	/**
	 * @category 根据id获取用户信息
	 * @author 韩守松
	 * @date   2016年2月22日
	 * @param  @param userId
	 * @param  @return
	 */
	SysUser findSysUserDataById(String userId);
	
	/**
	 * @category 查询企业用户
	 * @author 应晓川
	 * @date   2016年2月22日14:14:00
	 * @param  Pagination
	 */
	String getUserListByComp(Pagination page);
	
	/**
	 * @category 查询监管机构用户
	 * @author 应晓川
	 * @date   2016年2月22日14:14:00
	 * @param  Pagination
	 */
	String getUserListBySupervision(Pagination page); 
	
	/**
	 * @category 保存登陆ip，登陆时间，登陆次数等信息
	 * @date 2016年2月22日
	 * @param user
	 */
	void updateLoginInfo(String loginIp, String userId);
	
	/**
	 * @category 更新用户密码
	 * @author 韩守松
	 * @date   2016年2月23日
	 * @param  @param form
	 * @param  @return
	 */
	void updateSysUserPassWordById(SysUserForm form);
	
	/**
	 * @category 获得对应的部门用户
	 * @author wangs
	 * @date   2016年2月19日
	 * @param  @param page
	 * @param  @return
	 */
	List<SysUser> getSysUserQuery(Map<String, Object> map);
	
	/**
	 * @desc 修改用户基础信息
	 * @param sysUser
	 * @return
	 */
	int updateSysUser(SysUser sysUser);
	
	/**
	 * @category 获取用户权限
	 * @author 应晓川
	 * @date   2016年2月23日18:33:48
	 * @param  @param page
	 * @param  @return
	 */
	String getResourceListByUser(Map<String, Object> map);
	
	String getUserList(Pagination page);
	String getUserResource(Map<String, Object> map);
	/**
	 * @category 获取部门用户权限
	 * @author 韩守松
	 * @date   2016年2月29日
	 * @param  @param map
	 * @param  @return
	 */
	String getDepartmentUserResource(Map<String, Object> map);
	
	/**
	 * @category 获取岗位用户权限
	 * @author 韩守松
	 * @date   2016年2月29日
	 * @param  @param map
	 * @param  @return
	 */
	String getPostUserResource(Map<String, Object> map);
	
	/**
	 * @category 根据部门获取用户权限集合
	 * @author 韩守松
	 * @date   2016年2月29日
	 * @param  @param map
	 * @param  @return
	 */
	String getUserResourceByDepart(Map<String, Object> map);
	
	/**
	 * @category 根据岗位获取用户权限集合
	 * @author 韩守松
	 * @date   2016年2月29日
	 * @param  @param map
	 * @param  @return
	 */
	String getUserResourceByPost(Map<String, Object> map);
	String saveUserResource(Pagination page);
	

	/**
	 * 登录时根据登录帐号查询用户信息
	 * @param username
	 * @return
	 */
	SysUser getUserByUsername(String username);
	
	/**
	 * @desc  新增用户同时新增用户资源
	 * @param sysUser
	 * @param list
	 * @return
	 */
	int addUserAndResList(SysUser sysUser,List<SysUserResource> list);
	
	int saveUser(SysUser sysUser);
	
	/**
	 * 通过用户名查用户
	 * 如果不存在返回true
	 * @author he.fan
	 * @param userName
	 * @return
	 */
	 List<SysUser> queryRepeatUserName(Map<String, Object> map);
	
	/**
	 * 根据机构ID查找是否存在用户
	 * @param orgId
	 * @return
	 */
	List<SysUser> getSysUsersBy0rgId(String orgId);
	List<SysUser> getSysUserListById(String[] ids);
	
	/**
	 * 
	 * 
	 * 
	 * @param userName
	 * @return
	 */
	SysUser getIsOrg(String userName);
	int updateHospUserIsUsing(Map<String, Object> map);
	
	/**
	 * 监管 省
	 * @param map
	 * @return
	 */
	String getJGUserListPro(Pagination page);
	
	/**
	 *  监管 市
	 * @param map
	 * @return
	 */
	String getJGUserListCity(Pagination page);
	
	/**
	 *  监管 县区
	 * @param map
	 * @return
	 */
	String getJGUserListCounty(Pagination page);
	
	/**
	 * 通过id修改
	 * @param id
	 * @return
	 */
	SysUser getById(String id);
	
	/**
	 * 根据查询获取数据
	 * @param params
	 * @return
	 */
	List<SysUser> getLists(Map<String,Object> params);
	
	String  getList(Pagination page);
	
	boolean addSysUser(SysUser su);
	Pagination getSysUserByOrgId(Pagination page);
	boolean addSysUserRoleAndPrivilegeYY(String id, Integer drugPurchaseProperty,SysRole sysRole,Integer userType,String userId, String zhuRole, Date now,
			String createUserId);
	
	Pagination getCaUserList(Pagination page);
	SysUser getUsercacodeById(String id);
	Pagination getCompTbUsercacode(Pagination page);
	Pagination getSysUserCAData(Pagination page);
	void updateALLStart(SysUser sysUser);
	void updateALLDisable(SysUser sysUser);
	SysUser getByRoleId(String userName);
	void updateById(SysUser users);

    Pagination getSysUserDatas(Pagination page);

	SysUser getJcName(String id);
	
	Pagination getSearchPwdData(Pagination page);

	Pagination getBaseUserList(Pagination page);

	List<SysUser> getValidateData(Map<String,Object> map);

	SysUser getUserBySerialnumber(String serialnumber);

	Pagination getCompanyUserData(Pagination page);

	int toBindCAData(Pagination page);

	void toEmptyCA(Pagination page);
}
