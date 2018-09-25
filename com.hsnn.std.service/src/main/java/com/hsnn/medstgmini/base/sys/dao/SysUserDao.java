package com.hsnn.medstgmini.base.sys.dao;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.github.pagehelper.Page;
import com.hsnn.medstgmini.base.sys.model.SysUser;
import com.hsnn.medstgmini.base.sys.model.SysUserDepartPost;
import com.hsnn.medstgmini.base.sys.model.SysUserResource;
import com.hsnn.medstgmini.common.dao.GenericDao;

public interface SysUserDao extends GenericDao<SysUser, java.lang.String> {
	int updateUserInfoFirstLoginC(SysUser user);
	int updateUserInfoFirstLogin(SysUser user);
	int updateUserIsUsing(SysUser user);
	SysUser selectSysUserByUsername(@Param("username")String username);
	SysUser selectSysUserByEmail(String email);
	SysUser selectSysUserByResetToken(String resetToken);

	List<SysUser> getUsersData(Map<String,Object> map);

	/**
	 * @category 查询出部门用户信息
	 * @author 韩守松
	 * @date   2016年2月20日
	 * @param  @param map
	 * @param  @return
	 */
	List<SysUserDepartPost> queryAllDataSysUser(Map<String,Object> map);


	/**
	 * @category 查询出部门启用用户信息
	 * @author 韩守松
	 * @date   2016年2月20日
	 * @param  @param map
	 * @param  @return
	 */
	List<SysUserDepartPost> queryAllDataStartSysUser(Map<String,Object> map);
	
	/**
	 * @desc 根据部门id停用用户
	 * @author wangs
	 * @param sysUser
	 * @return
	 */
	int updateUserDisabale(SysUser sysUser);
	
	/**
	 * @category 查询出部门停用用户信息
	 * @author 韩守松
	 * @date   2016年2月20日
	 * @param  @param map
	 * @param  @return
	 */
	List<SysUserDepartPost> queryAllDataStopSysUser(Map<String,Object> map);
	
	/**
	 * @category 更新用户表中的状态
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
	List<SysUserDepartPost> querySysUserDataById(String userId);
	
	/**
	 * @category 查询机构用户列表
	 * @author 应晓川
	 * @date   2016年2月22日15:42:21
	 */
	List<Map<String, Object>> getUserListByHosp(Map<String, Object> map);
	/**
	 * @category 查询企业用户列表
	 * @author 应晓川
	 * @date   2016年2月22日15:42:21
	 */
	List<Map<String, Object>> getUserListByComp(Map<String, Object> map);
	/**
	 * @category 查询监管机构用户列表
	 * @author 应晓川
	 * @date   2016年2月22日15:42:21
	 */
	List<Map<String, Object>> getUserListBySupervision(Map<String, Object> map);
	
	/**
	 * @category 保存登陆ip，登陆时间，登陆次数等信息
	 * @date 2016年2月22日
	 * @param user
	 */
	void updateLoginInfo(Map<String, Object> map);
	
	/**
	 * @category 根据id获取用户信息
	 * @author 韩守松
	 * @date   2016年2月22日
	 * @param  @param userId
	 * @param  @return
	 */
	List<SysUser> findSysUserDataById(String userId);
	
	/**
	 * @category 更新用户密码
	 * @author 韩守松
	 * @date   2016年2月23日
	 * @param
	 */
	void updateSysUserPassWordById(SysUser user);
	/**
	 * 修改sysUser
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
	List<Map<String, Object>> getResourceListByUser(Map<String, Object> map);
	
	/**
	 * 
	 *@category 获取用户列表
	 *@author wangbing
	 *@date 2016年2月23日18:44:22
	 *@return
	 */
	public Page<Map<String, Object>> getUserList(Map<String, Object> map);
	
	/**
	 * 
	 *@category 获取用户权限集合
	 *@author wangbing
	 *@date 2016年2月23日18:44:22
	 *@return
	 */
	public List<Map<String, Object>> getUserResource(Map<String, Object> map);
	
	/**
	 * @category 获取部门用户权限
	 * @author 韩守松
	 * @date   2016年2月29日
	 * @param  @param map
	 * @param  @return
	 */
	public List<Map<String, Object>> getDepartmentUserResource(Map<String, Object> map);
	
	/**
	 * @category 获取岗位用户权限
	 * @author 韩守松
	 * @date   2016年2月29日
	 * @param  @param map
	 * @param  @return
	 */
	public List<Map<String, Object>> getPostUserResource(Map<String, Object> map);
	/**
	 * 
	 *@category 根据部门获取用户权限集合
	 *@author 韩守松
	 *@date 2016年2月23日18:44:22
	 *@return
	 */
	public List<Map<String, Object>> getUserResourceByDepart(Map<String, Object> map);
	
	/**
	 * 
	 *@category 根据岗位获取用户权限集合
	 *@author 韩守松
	 *@date 2016年2月23日18:44:22
	 *@return
	 */
	public List<Map<String, Object>> getUserResourceByPost(Map<String, Object> map);
	
	/**
	 * 
	 *@category 删除用户权限
	 *@author wangbing
	 *@date 2016年2月20日11:24:12
	 *@return
	 */
	public void deleteUserResource(@Param(value = "userId") String userId,@Param(value = "dels") String[] dels);
	/**
	 * 
	 *@category 添加用户权限
	 *@author wangbing
	 *@date 2016年2月20日11:24:12
	 *@return
	 */
	public void addUserResource(List<SysUserResource> list);
	/**
	 * 
	 *@category 根据postId获取角色id
	 *@author yxc
	 *@date 2016年3月10日19:28:00
	 *@return
	 */
	int getRoleIdByPostId(String postId);
	
	/**
	 * 通过账号查找用户
	 * @param map
	 * @return
	 */
	List<SysUser> queryRepeatUserName(Map<String, Object> map);
	
	/**
	 * 
	 *@category 根据用户id删除用户资源
	 *@author wangbing
	 *@date 2016年3月10日19:28:00
	 *@return
	 */
	public void deleteResourceByUserId(String userId);
	
	/**
	 * 
	 *@category 更新用户中岗位id
	 *@author wangbing
	 *@date 2016年3月10日19:28:00
	 *@return
	 */
	public void updatePostId(Map<String, Object> map);
	
	/**
	 * 
	 *@category 删除用户中岗位id
	 *@author wangbing
	 *@date 2016年3月10日19:28:00
	 *@return
	 */
	public void updatePostIdNull(Map<String, Object> map);
	
	List<SysUser> getSysUserListById(@Param("ids") String[] ids);
	
	/**
	 * 
	 * 
	 * 
	 * @param userName
	 * @return
	 */
	SysUser getIsOrg(String userName);
	
	int updateHospUserIsUsing(Map<String,Object> map);
	
	/**
	 * 监管 省
	 * @param map
	 * @return
	 */
	List<Map<String, Object>> getJGUserListPro(Map<String, Object> map);
	
	/**
	 *  监管 市
	 * @param map
	 * @return
	 */
	List<Map<String, Object>> getJGUserListCity(Map<String, Object> map);
	
	/**
	 *  监管 县区
	 * @param map
	 * @return
	 */
	List<Map<String, Object>> getJGUserListCounty(Map<String, Object> map);
	Page<SysUser> getUserData(Map<String, Object> conditions);
	
	
	
	boolean addSysUser(SysUser su);
	List<SysUser> queryUserAll(Map<String, Object> map);
	void updateSysUserRole(@Param(value = "roleId") Integer roleId,@Param(value = "userId") String userId);
	public Page<Map<String, Object>> getCaUserList(Map<String, Object> map);
	SysUser getUsercacodeById(Map<String, Object> map);
	Page<Map<String, Object>> getCompTbUsercacode(Map<String, Object> conditions);
	void getSysUserCA(Map<String, Object> conditions);
	Page<Map<String, Object>> getSysUserCAData(Map<String, Object> conditions);
	void updateALLStart(SysUser sysUser);
	void updateALLDisable(SysUser sysUser);
	SysUser getByRoleId(String userName);

	Page<SysUser> getChooseUserData(Map<String, Object> conditions);


	void updateById(SysUser users);

    Page<Map<String,Object>> getSysUserDatas(Map<String, Object> conditions);

	SysUser getJcName(String id);
	
	Page<Map<String,Object>> getSearchPwdData(Map<String,Object> map);

	List<SysUser> getBaseUserList(Map<String,Object> map);

	List<SysUser> getValidateData(Map<String,Object> map);

	SysUser getUserBySerialnumber(String serialnumber);

	Page<SysUser> getCompanyUserData(Map<String, Object> conditions);

	int toBindCAData(Map<String, Object> conditions);

	void toEmptyCA(Map<String, Object> conditions);
}