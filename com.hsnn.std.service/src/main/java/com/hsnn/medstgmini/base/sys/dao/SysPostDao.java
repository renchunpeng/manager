package com.hsnn.medstgmini.base.sys.dao;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.github.pagehelper.Page;
import com.hsnn.medstgmini.base.sys.model.SysPost;
import com.hsnn.medstgmini.base.sys.model.SysRoleResource;
import com.hsnn.medstgmini.common.dao.GenericDao;

public interface SysPostDao extends GenericDao<SysPost, java.lang.Integer> {
	
	/**
	 * 获取岗位查看列表数据
	 * @author 言科
	 * @param page
	 * @return
	 */
	Page<SysPost> queryGangWei(Map<String, Object> map);
	
	/**
	 * @category 查询岗位所有id和Name
	 * @author 韩守松
	 * @date   2016年2月20日
	 * @param  @param post
	 * @param  @return
	 */
	List<SysPost> findAllPostIdAndName(SysPost post);

	/**
	 * 获取岗位启用列表数据
	 * @author 言科
	 * @param page
	 * @return
	 */
	Page<SysPost> queryGangWeiStart(Map<String, Object> map);
	
	/**
	 * 获取岗位停用列表数据
	 * @author 言科
	 * @param page
	 * @return
	 */
	Page<SysPost> queryGangWeiStop(Map<String, Object> map);
	
	
	/**
	 * @category 岗位批量(启用|停用)按钮
	  * @author 言科
	 * @date 2016年2月19日
	 */
	int updateSysPostUsing(Map<String, Object> map);
	
	
	/**
	 * 获取岗位编辑列表数据
	 * @author 言科
	 * @param page
	 * @return
	 */
	Page<SysPost> queryGangWeiEdit(Map<String, Object> map);
	
	
	
	
	/**
	 * 岗位编辑功能实现
	 * @author 言科
	 * @param page
	 * @return
	 */
	int updateSysPost(SysPost sysPost);
	
	
	/**
	 * @category 岗位新增功能
	 * @author 言科
	 * @date 2016年2月19日
	 */
	int saveSysPost(SysPost sysPost);
	 
	/**
	 * 验证岗位角色名称是否存在
	 * @param sysPost
	 * @return
	 */
	List<SysPost> getReviewPostName(SysPost sysPost);
	
	/**
	 * @category 根据id查询岗位信息（详情、编辑页面）
	 * @author 言科
	 * @param page
	 * @return
	 */
	List<SysPost> querySysPostById(Integer postId);
 
	/**
	 * @category 岗位启用停用，更新表中状态
	 * @author 言科
	 * @date 2016年2月19日
	 */
	int updateSysPostIsUsing(SysPost sysPost);
	

	
	/**
	 * 
	 *@category 获取企业岗位列表
	 *@author wangbing
	 *@date 2016年2月20日11:24:12
	 *@return
	 */
	public Page<Map<String, Object>> getJgPostList(Map<String, Object> map);
	
	/**
	 * 
	 *@category 获取医疗岗位列表
	 *@author wangbing
	 *@date 2016年2月20日11:24:12
	 *@return
	 */
	public Page<Map<String, Object>> getHospPostList(Map<String, Object> map);
	/**
	 * 
	 *@category 获取企业岗位列表
	 *@author wangbing
	 *@date 2016年2月20日11:24:12
	 *@return
	 */
	public Page<Map<String, Object>> getCompPostList(Map<String, Object> map);
	/**
	 * 
	 *@category 获取岗位权限
	 *@author wangbing
	 *@date 2016年2月20日11:24:12
	 *@return
	 */
	public List<Map<String, Object>> getPostResource(Map<String, Object> map);
	
	
	/**
	 * 
	 *@category 获取岗位权限
	 *@author wangbing
	 *@date 2016年2月20日11:24:12
	 *@return
	 */
	public List<Map<String, Object>> getPostResourceByDepart(Map<String, Object> map);
	
	/**
	 * 
	 *@category 删除岗位权限
	 *@author wangbing
	 *@date 2016年2月20日11:24:12
	 *@return
	 */
	public void deletePostResource(@Param(value = "roleId") String roleId,@Param(value = "dels") String[] dels);
	/**
	 * 
	 *@category 编辑岗位权限
	 *@author wangbing
	 *@date 2016年2月20日11:24:12
	 *@return
	 */
	public void addPostResource(List<SysRoleResource> list);
	/**
	 * 
	 *@category 根据岗位id获取角色id
	 *@author wangbing
	 *@date 2016年2月20日11:24:12
	 *@return
	 */
	public Map<String,Object> getRoleByPostId(Map<String, String> map);
	/**
	 * 
	 *@category 获取岗位列表
	 *@author wangbing
	 *@date 2016年2月20日11:24:12
	 *@return
	 */
	public Page<Map<String, Object>> getPostList(Map<String, Object> map);
	
	
	/**
	 * 
	 *@category 岗位新增保存（获取的是部门的权限）
	 *@author 言科
	 *@date 2016年2月20日11:24:12
	 *@return
	 */
	public void addPostDepartmentResource(List<SysRoleResource> list);
	
	/**
	 * 
	 *@category 岗位新增时获取数据库中自增的那个postId
	 *@author 言科
	 *@date 2016年2月20日11:24:12
	 *@return
	 */
	int returnLastId();
	
	/**
	 * 根据ids修改相应数据
	 * @param ids
	 * @param appointment
	 * @return
	 */
	int updateByIds(@Param("ids") String[] ids,@Param("model") SysPost sysPost);
	
	/**
	 * 根据岗位编号获取信息
	 * @param map
	 * @return
	 */
	Map<String, Object> getPostDetail(Map<String, Object> map);
	
	/**
	 * 监管 省级列表
	 * @param page
	 * @return
	 */
	public List<Map<String, Object>>  getJGPostListPro(Map<String, Object> map);
	
	/**
	 * 监管 市级列表
	 * @param page
	 * @return
	 */
	public List<Map<String, Object>>  getJGPostListCity(Map<String, Object> map);
	
	/**
	 * 监管 县区级 列表
	 * @param page
	 * @return
	 */
	public List<Map<String, Object>>  getJGPostListCounty(Map<String, Object> map);
}