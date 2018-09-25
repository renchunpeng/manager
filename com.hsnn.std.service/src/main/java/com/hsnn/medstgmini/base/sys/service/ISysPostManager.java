package com.hsnn.medstgmini.base.sys.service;


import java.util.List;
import java.util.Map;

import javax.jws.WebService;

import com.hsnn.medstgmini.base.sys.form.SysPostForm;
import com.hsnn.medstgmini.base.sys.model.SysDepartment;
import com.hsnn.medstgmini.base.sys.model.SysPost;
import com.hsnn.medstgmini.base.sys.model.SysUser;
import com.hsnn.medstgmini.util.Pagination;


@WebService
public interface ISysPostManager {

	
	/**
	 * @category 查询岗位列表
	 * @author 言科
	 * @date 2016年2月19日
	 */
	String getZxMinSysPostList(Pagination page);
	
	
	
	
	/**
	 * @category 岗位启用列表
	 * @author 言科
	 * @date 2016年2月19日
	 */
	String getzxMinSysPostListStart(Pagination page);
	
	
	/**
	 * @category 岗位停用列表
	 * @author 言科
	 * @date 2016年2月19日
	 */
	String getzxMinSysPostListStop(Pagination page);
	
	
	/**
	 * @category 岗位批量(启用|停用)按钮
	  * @author 言科
	 * @date 2016年2月19日
	 */
	void batchChangeStatus(Pagination page);
	
	
	/**
	 * @category 岗位编辑列表
	 * @author 言科
	 * @date 2016年2月19日
	 */
	String getzxMinSysPostListEdit(Pagination page);
	
	/**
	 * @category 岗位编辑功能
	 * @author 言科
	 * @date 2016年2月19日
	 */
	boolean updateSysPost(SysPostForm form);
	
	
	
	/**
	 * 
	 *@category 根据id查询岗位信息（详情、编辑页面）
	 * @author 言科
	 * @date 2016年2月19日
	 */
	SysPost querySysPostById(Integer postId);
	
	/**
	 * @category 岗位启用停用，更新表中状态
	 * @author 言科
	 * @date 2016年2月19日
	 */
	int updateSysPostIsUsing(SysPost sysPost);
	
	/**
	 * @category 查询出部门所有id和名称
	 * @author 韩守松
	 * @date   2016年2月20日
	 * @param  @return
	 */
	List<SysDepartment> findDepartmentIdAndName(SysDepartment department); 
	
	/**
	 * @category 岗位新增功能
	 * @author 言科
	 * @param user 
	 * @return 
	 * @date 2016年2月19日
	 */
	String[] saveSysPost(SysPostForm form, SysUser user,Pagination page);
	
	List<SysPost> getReviewPostName(SysPost sysPost);
	
	/**
	 * 
	 *@category 岗位新增保存（获取的是部门的权限）
	 *@author 言科
	 *@date 2016年2月20日11:24:12
	 *@return
	 */
/*	Pagination addPostDepartmentResource(Pagination page);*/
	
	String saveSysPostResource(Pagination page,SysUser user);

	
	/**
	 * @category 查询岗位所有id和Name
	 * @author 韩守松
	 * @date   2016年2月20日
	 * @param  @param post
	 * @param  @return
	 */
	List<SysPost> findAllPostIdAndName(SysPost post);


	String getJgPostList(Pagination page);


	String getHospPostList(Pagination page);


	String getCompPostList(Pagination page);


	String getPostResource(Map<String, Object> map);
	
	/**
	 * @category 根据部门获取岗位信息
	 * @author 韩守松
	 * @date   2016年2月29日
	 * @param  @param map
	 * @param  @return
	 */
	String getPostResourceByDepart(Map<String, Object> map);


	String savePostResource(Pagination page, SysUser user);


	Map<String, Object> getRoleByPostId(String id);


	String getPostList(Pagination page);

	/**
	 * 根据岗位ids 修改状态
	 * @param ids		岗位id数组
	 * @param state		修改成为什么状态
	 * @return			影响记录数
	 */
	int updateSysPostIsUsings(String[] ids, Integer state, SysUser sysUser);
	
	/**
	 * 根据岗位编号获取岗位信息
	 * @param postId
	 * @return
	 */
	Map<String, Object> getPostDetail(Integer postId, int userType);
	
	/**
	 * 监管 省级列表
	 * @param page
	 * @return
	 */
	String getJGPostListPro(Pagination page);
	
	/**
	 * 监管 市级列表
	 * @param page
	 * @return
	 */
	String getJGPostListCity(Pagination page);
	
	/**
	 * 监管 县区级 列表
	 * @param page
	 * @return
	 */
	String getJGPostListCounty(Pagination page);
	
	/**
	 * 通过id修改
	 * @param id
	 * @return
	 */
	SysPost getById(int id);
}
