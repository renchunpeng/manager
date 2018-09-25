package com.hsnn.medstgmini.base.sys.service;

import java.util.List;

import javax.jws.WebService;

import com.hsnn.medstgmini.base.sys.model.SysOperationLog;
import com.hsnn.medstgmini.base.sys.model.SysUser;
import com.hsnn.medstgmini.util.Pagination;

@WebService
public interface ISysOperationLog {

	/**
	 * 查询列表
	 * @param page
	 * @return
	 */
	String getOperationLogList(Pagination page);
	
	/**
	 * 添加操作日志：
     * @Title: addOperationLog
     * @Description: 添加操作信息
     * @param clazz 保存的类对象
     * @param sysUser  SESSION用户
     * @param tableCode 业务ID
     * @param request  请求
     * @param operationType  操作类型:用SysOprationLogOprateType枚举 
     * @param operationContent  操作内容
     * @param sysId 系统ID
     * @return int
     * @throws
     */
	int save(Object clazz,SysUser sysUser,String tableCode,String ip, int operationType, String operationContent,String sysIde);
	
	/**
	 * @category 
	 * @author 韩守松
	 * @date   2016年7月11日
	 * @param  @param clazz
	 * @param  @param sysUser
	 * @param  @param tableCode
	 * @param  @param request
	 * @param  @param operationType
	 * @param  @param operationContent
	 * @param  @param sysIde
	 * @param  @param jopName
	 * @param  @return
	 */
	int saveByPostAdd(Object clazz,SysUser sysUser,String tableCode,String ip, int operationType, String operationContent,String sysIde,String jopName);
	/**
	 * 根据日志ID查询日志
	 * @param id
	 * @return
	 */
	SysOperationLog getById(Integer id);
	
	/**
	 * 操作日志批量插入
	 * @param clazzList 保存的类对象
	 * @param sysUser  SESSION用户
     * @param sysUser  SESSION用户
     * @param tableCodes 业务ID
     * @param request  请求
     * @param operationType  操作类型:用SysOprationLogOprateType枚举 
     * @param operationContent  操作内容
     * @param sysId 系统ID
	 * @return
	 */
	int insertBatch(List<?> clazzList,SysUser sysUser,List<String> tableCodes,String ip, int operationType, String operationContent,String sysIde);
	
	/**
	 * @category 
	 * @author 韩守松
	 * @date   2016年7月11日
	 * @param  @param clazzList
	 * @param  @param sysUser
	 * @param  @param tableCodes
	 * @param  @param request
	 * @param  @param operationType
	 * @param  @param operationContent
	 * @param  @param sysIde
	 * @param  @param jobName
	 * @param  @return
	 */
	int insertBatchByPostAdd(List<?> clazzList,SysUser sysUser,List<String> tableCodes,String ip, int operationType, String operationContent,String sysIde,String jobName);

	
}
