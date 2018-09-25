package com.hsnn.medstgmini.base.sys.service.impl;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.hsnn.medstgmini.base.sys.dao.SysOperationLogDao;
import com.hsnn.medstgmini.base.sys.model.SysOperationLog;
import com.hsnn.medstgmini.base.sys.model.SysUser;
import com.hsnn.medstgmini.base.sys.service.ISysOperationLog;
import com.hsnn.medstgmini.util.ClassUtils;
import com.hsnn.medstgmini.util.JudgmentRole;
import com.hsnn.medstgmini.util.Pagination;

@Service
public class SysOperationLogManagerImpl implements ISysOperationLog{
	
	@Autowired
	SysOperationLogDao sysOperationLogDao;
	
	@Override
	public String getOperationLogList(Pagination page) {
		PageHelper.startPage(page.getPage(), page.getCount());
		Page<SysOperationLog> operationLogs = (Page<SysOperationLog>) sysOperationLogDao.queryAll(page.getConditions());
		
		page.setRows(operationLogs);
		page.setRecords(operationLogs.getTotal());
		JSONObject jsonObject = new JSONObject(page);
		return jsonObject.toString();
	}

	@Override
	public int save(Object clazz,SysUser sysUser,String tableCode,String ip,
			int operationType, String operationContent,String sysId) {
		 	int addNum = 0;
		 try {
			//获取机构 部门 岗位
			 String mechanismName = JudgmentRole.judgmentRole(sysUser);
			 String departmentName =JudgmentRole.judgmentDepartment(sysUser);
			 String jobName = JudgmentRole.judgmentJob(sysUser);
				
	         SysOperationLog log = new SysOperationLog();
	         log.setTableName(ClassUtils.getClazzToTable(clazz));
	         log.setTableCode(tableCode);
	         ObjectOutputStream oos = null;//对象输出流
	 		 ByteArrayOutputStream baos = null;//byte数组输出流
	         //序列化
			 baos = new ByteArrayOutputStream();
			 oos = new ObjectOutputStream(baos);
			 //将数组流传入对象流
			 oos.writeObject(clazz);
			 byte[] bytes = baos.toByteArray();//用数组流将传入的对象转化为byte数组
			 //保存到数据库
	         log.setSerializeObj(bytes);
	         log.setOperateType(operationType);// 操作类型
	         log.setOperation(operationContent);// 操作内容
	         log.setSysId(sysId);
	         log.setCreaterIp(ip);// IP地址
	         log.setCreaterName(sysUser.getName());// 操作用户
	         log.setCreaterId(sysUser.getUserId());// 操作用户ID
	         if(!"".equals(mechanismName)){
	        	 log.setMechanismName(mechanismName);//机构名称
	         }
	         if(!"".equals(departmentName)){
	        	 log.setDepartmentName(departmentName);//部门名称
	         }
	         if(!"".equals(jobName)){
	        	 log.setJobName(jobName);//岗位名称
	         }
	         addNum = sysOperationLogDao.save(log);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 return addNum;
	}
	
	/**
	 * 新增岗位记录日志
	 */
	@Override
	public int saveByPostAdd(Object clazz,SysUser sysUser,String tableCode,String ip,
			int operationType, String operationContent,String sysId,String jobName) {
		 	int addNum = 0;
		 try {
			//获取机构 部门 岗位
			 String mechanismName = JudgmentRole.judgmentRole(sysUser);
			 String departmentName =JudgmentRole.judgmentDepartment(sysUser);
				
	         SysOperationLog log = new SysOperationLog();
	         log.setTableName(ClassUtils.getClazzToTable(clazz));
	         log.setJobName(ClassUtils.getClazzToTable(clazz));
	         log.setTableCode(tableCode);
	         ObjectOutputStream oos = null;//对象输出流
	 		 ByteArrayOutputStream baos = null;//byte数组输出流
	         //序列化
			 baos = new ByteArrayOutputStream();
			 oos = new ObjectOutputStream(baos);
			 //将数组流传入对象流
			 oos.writeObject(clazz);
			 byte[] bytes = baos.toByteArray();//用数组流将传入的对象转化为byte数组
			 //保存到数据库
	         log.setSerializeObj(bytes);
	         log.setOperateType(operationType);// 操作类型
	         log.setOperation(operationContent);// 操作内容
	         log.setSysId(sysId);
	         log.setCreaterIp(ip);// IP地址
	         log.setCreaterName(sysUser.getName());// 操作用户
	         log.setCreaterId(sysUser.getUserId());// 操作用户ID
	         if(!"".equals(mechanismName)){
	        	 log.setMechanismName(mechanismName);//机构名称
	         }
	         if(!"".equals(departmentName)){
	        	 log.setDepartmentName(departmentName);//部门名称
	         }
	         if(!"".equals(jobName)){
	        	 log.setJobName(jobName);//岗位名称
	         }
	         addNum = sysOperationLogDao.save(log);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 return addNum;
	}

	@Override
	public SysOperationLog getById(Integer id) {
		SysOperationLog sysOperationLog=sysOperationLogDao.get(id);
		return sysOperationLog;
	}

	@Override
	public int insertBatch(List<?> clazzList,SysUser sysUser,List<String> tableCodes,String ip, int operationType, String operationContent,String sysIde) {
		List<SysOperationLog> sysOperationLogList = new ArrayList<SysOperationLog>();
		if(clazzList.size()>0){
			for (int i = 0; i < clazzList.size(); i++) {
				//获取机构 部门 岗位
				 String mechanismName = JudgmentRole.judgmentRole(sysUser);
				 String departmentName =JudgmentRole.judgmentDepartment(sysUser);
				 String jobName = JudgmentRole.judgmentJob(sysUser);
					
		         SysOperationLog log = new SysOperationLog();
		         log.setTableName(ClassUtils.getClazzToTable(clazzList.get(i)));
		         log.setTableCode(tableCodes.get(i));
		         ObjectOutputStream oos = null;//对象输出流
		 		 ByteArrayOutputStream baos = null;//byte数组输出流
				 try {
					 //序列化
					 baos = new ByteArrayOutputStream();
					 oos = new ObjectOutputStream(baos);
					 //将数组流传入对象流
					 oos.writeObject(clazzList.get(i));
					 byte[] bytes = baos.toByteArray();//用数组流将传入的对象转化为byte数组
					 
					 //保存到数据库
			         log.setSerializeObj(bytes);
			         log.setOperateType(operationType);// 操作类型
			         log.setOperation(operationContent);// 操作内容
			         log.setSysId(sysIde);
			         log.setCreaterIp(ip);// IP地址
			         log.setCreaterName(sysUser.getName());// 操作用户
			         log.setCreaterId(sysUser.getUserId());// 操作用户ID
			         if(!"".equals(mechanismName)){
			        	 log.setMechanismName(mechanismName);//机构名称
			         }
			         if(!"".equals(departmentName)){
			        	 log.setDepartmentName(departmentName);//部门名称
			         }
			         if(!"".equals(jobName)){
			        	 log.setJobName(jobName);//岗位名称
			         }
			         sysOperationLogList.add(log);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		if(sysOperationLogList.size()>0){
			
			for (SysOperationLog log: sysOperationLogList) {
				sysOperationLogDao.save(log);
			}
			return 1;
			//return sysOperationLogDao.insertBatch(sysOperationLogList);
		}
		return 0;
	}

	@Override
	public int insertBatchByPostAdd(List<?> clazzList,SysUser sysUser,List<String> tableCodes,String ip, int operationType, String operationContent,String sysIde,String jobName) {
		List<SysOperationLog> sysOperationLogList = new ArrayList<SysOperationLog>();
		if(clazzList.size()>0){
			for (int i = 0; i < clazzList.size(); i++) {
				//获取机构 部门 岗位
				 String mechanismName = JudgmentRole.judgmentRole(sysUser);
				 String departmentName =JudgmentRole.judgmentDepartment(sysUser);
					
		         SysOperationLog log = new SysOperationLog();
		         log.setTableName(ClassUtils.getClazzToTable(clazzList.get(i)));
		         log.setTableCode(tableCodes.get(i));
		         ObjectOutputStream oos = null;//对象输出流
		 		 ByteArrayOutputStream baos = null;//byte数组输出流
				 try {
					 //序列化
					 baos = new ByteArrayOutputStream();
					 oos = new ObjectOutputStream(baos);
					 //将数组流传入对象流
					 oos.writeObject(clazzList.get(i));
					 byte[] bytes = baos.toByteArray();//用数组流将传入的对象转化为byte数组
					 //保存到数据库
			         log.setSerializeObj(bytes);
			         log.setOperateType(operationType);// 操作类型
			         log.setOperation(operationContent);// 操作内容
			         log.setSysId(sysIde);
			         log.setCreaterIp(ip);// IP地址
			         log.setCreaterName(sysUser.getName());// 操作用户
			         log.setCreaterId(sysUser.getUserId());// 操作用户ID
			         if(!"".equals(mechanismName)){
			        	 log.setMechanismName(mechanismName);//机构名称
			         }
			         if(!"".equals(departmentName)){
			        	 log.setDepartmentName(departmentName);//部门名称
			         }
			         if(!"".equals(jobName)){
			        	 log.setJobName(jobName);//岗位名称
			         }
			         sysOperationLogList.add(log);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		if(sysOperationLogList.size()>0){
			return sysOperationLogDao.insertBatch(sysOperationLogList);
		}
		return 0;
	}

}
