package com.hsnn.medstgmini.base.sys.service;

import java.util.List;

import javax.jws.WebService;

import com.hsnn.medstgmini.base.sys.model.SysChangeLog;
import com.hsnn.medstgmini.base.sys.model.SysUser;
import com.hsnn.medstgmini.util.Pagination;

@WebService
public interface ISysChangeLog{

	/**
	 * 查询列表
	 * @param page
	 * @return
	 */
	public String getChangeLogList(Pagination page);
	
	/**
	 * 记录日志：该方法只记录修改以后的数据,用于数据对比
	 * 这个方法只记录修改后的数据,用于数据对比
	 * @param clazz 插入日志的对象
	 * @param tableCode 业务ID
	 * @param SysUser 操作人信息
	 * @param operateType 操作类型:用SysChangelogOperateType枚举 
	 * @param request 获取IP信息
	 * @param sysId 系统ID
	 * @return
	 */
	public int save(Object clazz,String tableCode,SysUser sysUser,int operateType,String ip,String sysId);
	
	/**
	 * 记录日志：该方法只记录修改以后的数据,用于数据对比
	 * 这个方法只记录修改后的数据,用于数据对比
	 * @param clazz 插入日志的对象
	 * @param tableCode 业务ID
	 * @param SysUser 操作人信息
	 * @param operateType 操作类型:用SysChangelogOperateType枚举 
	 * @param request 获取IP信息
	 * @param sysId 系统ID
	 * @return
	 */
	public int saveByPostAdd(Object clazz,String tableCode,SysUser sysUser,int operateType,String ip,String sysId,String jobName);
	
	/**
	 * 根据ID查询要比较的结果
	 * @param ids
	 * @return
	 */
	public List<SysChangeLog> getTableByCodeId(Integer[] ids);

	/**
	 * 查询详情
	 * @param id
	 * @return
	 */
	public SysChangeLog getById(Integer id);
	
	/**
	 * 批量插入变更日志
	 * @param classList
	 * @param tableCodes
	 * @param sysUser
	 * @param operateType
	 * @param request
	 * @param sysId
	 * @return
	 */
	public int insertBatch(List<?> classList,List<String> tableCodes,SysUser sysUser,int operateType,String ip,String sysId);
	
	/**
	 * @category 
	 * @author 韩守松
	 * @date   2016年7月11日
	 * @param  @param classList
	 * @param  @param tableCodes
	 * @param  @param sysUser
	 * @param  @param operateType
	 * @param  @param request
	 * @param  @param sysId
	 * @param  @param jobName
	 * @param  @return
	 */
	public int insertBatchByPostAdd(List<?> classList,List<String> tableCodes,SysUser sysUser,int operateType,String ip,String sysId,String jobName);
	

	
}
