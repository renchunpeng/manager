package com.hsnn.medstgmini.base.sys.service.impl;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.hsnn.medstgmini.base.sys.dao.SysChangeLogDao;
import com.hsnn.medstgmini.base.sys.model.SysChangeLog;
import com.hsnn.medstgmini.base.sys.model.SysOperationLog;
import com.hsnn.medstgmini.base.sys.model.SysUser;
import com.hsnn.medstgmini.base.sys.service.ISysChangeLog;
import com.hsnn.medstgmini.util.ClassUtils;
import com.hsnn.medstgmini.util.JudgmentRole;
import com.hsnn.medstgmini.util.Pagination;

@Service
public class SysChangeLogManagerImpl implements ISysChangeLog{
	
	@Autowired
	private SysChangeLogDao sysChangeLogDao;
	
	@Override
	public String getChangeLogList(Pagination page) {
		PageHelper.startPage(page.getPage(), page.getCount());
		Page<SysChangeLog> departments = (Page<SysChangeLog>) sysChangeLogDao.queryAll(page.getConditions());
		
		page.setRows(departments);
		page.setRecords(departments.getTotal());
		JSONObject jsonObject = new JSONObject(page);
		return jsonObject.toString();
	}
	
	@Override
	public int save(Object clazz,String tableCode,SysUser sysUser,int operateType,String ip,String sysId) {
		int insertRow=0;
		ObjectOutputStream oos = null;//对象输出流
		ByteArrayOutputStream baos = null;//byte数组输出流
		try {
			//获取机构 部门 岗位
			String mechanismName = JudgmentRole.judgmentRole(sysUser);
			String departmentName =JudgmentRole.judgmentDepartment(sysUser);
			String jobName = JudgmentRole.judgmentJob(sysUser);
			 
			//序列化
			baos = new ByteArrayOutputStream();
			oos = new ObjectOutputStream(baos);//将数组流传入对象流
			oos.writeObject(clazz);
	
		    byte[] bytes = baos.toByteArray();//用数组流将传入的对象转化为byte数组
			//保存到数据库
			SysChangeLog sysChangeLog=new SysChangeLog();
			String tableName=ClassUtils.getClazzToTable(clazz);
			sysChangeLog.setSerializeTable(tableName);
			sysChangeLog.setTableCode(tableCode);
			sysChangeLog.setSerializeObj(bytes);
			sysChangeLog.setCreaterIp(ip);
			sysChangeLog.setOperateType(operateType);
			sysChangeLog.setSysId(sysId);
			//创建人信息
			sysChangeLog.setCreaterId(sysUser.getUserId());
			sysChangeLog.setCreaterName(sysUser.getUserName());
			sysChangeLog.setCreaterIp(ip);
			
			 if(!"".equals(mechanismName)){
				 sysChangeLog.setMechanismName(mechanismName);//机构名称
	         }
			if(!"".equals(departmentName)){
				sysChangeLog.setDepartmentName(departmentName);//部门名称
	         }
	         if(!"".equals(jobName)){
	        	 sysChangeLog.setJobName(jobName);//岗位名称
	         }
			//保存
			 insertRow=sysChangeLogDao.save(sysChangeLog);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return insertRow;
	}
	
	
	@Override
	public int saveByPostAdd(Object clazz,String tableCode,SysUser sysUser,int operateType,String ip,String sysId,String jobName) {
		int insertRow=0;
		ObjectOutputStream oos = null;//对象输出流
		ByteArrayOutputStream baos = null;//byte数组输出流
		try {
			//获取机构 部门 岗位
			String mechanismName = JudgmentRole.judgmentRole(sysUser);
			String departmentName =JudgmentRole.judgmentDepartment(sysUser);
			 
			//序列化
			baos = new ByteArrayOutputStream();
			oos = new ObjectOutputStream(baos);//将数组流传入对象流
			oos.writeObject(clazz);
	
		    byte[] bytes = baos.toByteArray();//用数组流将传入的对象转化为byte数组
			//保存到数据库
			SysChangeLog sysChangeLog=new SysChangeLog();
			String tableName=ClassUtils.getClazzToTable(clazz);
			sysChangeLog.setSerializeTable(tableName);
			sysChangeLog.setTableCode(tableCode);
			sysChangeLog.setSerializeObj(bytes);
			sysChangeLog.setCreaterIp(ip);
			sysChangeLog.setOperateType(operateType);
			sysChangeLog.setSysId(sysId);
			//创建人信息
			sysChangeLog.setCreaterId(sysUser.getUserId());
			sysChangeLog.setCreaterName(sysUser.getUserName());
			sysChangeLog.setCreaterIp(ip);
			
			 if(!"".equals(mechanismName)){
				 sysChangeLog.setMechanismName(mechanismName);//机构名称
	         }
			if(!"".equals(departmentName)){
				sysChangeLog.setDepartmentName(departmentName);//部门名称
	         }
	         if(!"".equals(jobName)){
	        	 sysChangeLog.setJobName(jobName);//岗位名称
	         }
			//保存
			 insertRow=sysChangeLogDao.save(sysChangeLog);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return insertRow;
	}
    @Override
	public List<SysChangeLog> getTableByCodeId(Integer[] ids) {
    	Map<String,Object> map = new HashMap<String,Object>();
		map.put("ids", ids);
		map.put("orderColumn","id");
		map.put("orderDirection","DESC");
		List<SysChangeLog> sysChangeLogList =sysChangeLogDao.queryAll(map);
		return sysChangeLogList;
	}

	@Override
	public SysChangeLog getById(Integer id) {
		SysChangeLog sysChangeLog=sysChangeLogDao.get(id);
		return sysChangeLog;
	}

	@Override
	public int insertBatch(List<?> classList,List<String> tableCodes,SysUser sysUser,int operateType,String ip,String sysId) {
		List<SysChangeLog> sysChangeLogList = new ArrayList<SysChangeLog>();
		if(classList.size()>0){
			for (int i = 0; i < classList.size(); i++) {
				ObjectOutputStream oos = null;//对象输出流
				ByteArrayOutputStream baos = null;//byte数组输出流
				try {
					//获取机构 部门 岗位
					String mechanismName = JudgmentRole.judgmentRole(sysUser);
					String departmentName =JudgmentRole.judgmentDepartment(sysUser);
					String jobName = JudgmentRole.judgmentJob(sysUser);
					 
					//序列化
					baos = new ByteArrayOutputStream();
					oos = new ObjectOutputStream(baos);//将数组流传入对象流
					oos.writeObject(classList.get(i));
			
				    byte[] bytes = baos.toByteArray();//用数组流将传入的对象转化为byte数组
					//保存到数据库
					SysChangeLog sysChangeLog=new SysChangeLog();
					String tableName=ClassUtils.getClazzToTable(classList.get(i));
					sysChangeLog.setSerializeTable(tableName);
					sysChangeLog.setTableCode(tableCodes.get(i));
					sysChangeLog.setSerializeObj(bytes);
					sysChangeLog.setCreaterIp(ip);
					sysChangeLog.setOperateType(operateType);
					sysChangeLog.setSysId(sysId);
					//创建人信息
					sysChangeLog.setCreaterId(sysUser.getUserId());
					sysChangeLog.setCreaterName(sysUser.getUserName());
					sysChangeLog.setCreaterIp(ip);
					
					 if(!"".equals(mechanismName)){
						 sysChangeLog.setMechanismName(mechanismName);//机构名称
			         }
					if(!"".equals(departmentName)){
						sysChangeLog.setDepartmentName(departmentName);//部门名称
			         }
			         if(!"".equals(jobName)){
			        	 sysChangeLog.setJobName(jobName);//岗位名称
			         }
			         sysChangeLogList.add(sysChangeLog);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		if (sysChangeLogList.size() > 0) {
			//sysChangeLogDao.insertBatch(sysChangeLogList);
			for (SysChangeLog log: sysChangeLogList) {
				sysChangeLogDao.save(log);
			}
			return 1;
		}
		return 0;
	}

	@Override
	public int insertBatchByPostAdd(List<?> classList, List<String> tableCodes,
			SysUser sysUser, int operateType, String ip,
			String sysId, String jobName) {
		List<SysChangeLog> sysChangeLogList = new ArrayList<SysChangeLog>();
		if(classList.size()>0){
			for (int i = 0; i < classList.size(); i++) {
				ObjectOutputStream oos = null;//对象输出流
				ByteArrayOutputStream baos = null;//byte数组输出流
				try {
					//获取机构 部门 岗位
					String mechanismName = JudgmentRole.judgmentRole(sysUser);
					String departmentName =JudgmentRole.judgmentDepartment(sysUser);
					 
					//序列化
					baos = new ByteArrayOutputStream();
					oos = new ObjectOutputStream(baos);//将数组流传入对象流
					oos.writeObject(classList.get(i));
			
				    byte[] bytes = baos.toByteArray();//用数组流将传入的对象转化为byte数组
					//保存到数据库
					SysChangeLog sysChangeLog=new SysChangeLog();
					String tableName=ClassUtils.getClazzToTable(classList.get(i));
					sysChangeLog.setSerializeTable(tableName);
					sysChangeLog.setTableCode(tableCodes.get(i));
					sysChangeLog.setSerializeObj(bytes);
					sysChangeLog.setCreaterIp(ip);
					sysChangeLog.setOperateType(operateType);
					sysChangeLog.setSysId(sysId);
					//创建人信息
					sysChangeLog.setCreaterId(sysUser.getUserId());
					sysChangeLog.setCreaterName(sysUser.getUserName());
					sysChangeLog.setCreaterIp(ip);
					
					 if(!"".equals(mechanismName)){
						 sysChangeLog.setMechanismName(mechanismName);//机构名称
			         }
					if(!"".equals(departmentName)){
						sysChangeLog.setDepartmentName(departmentName);//部门名称
			         }
			         if(!"".equals(jobName)){
			        	 sysChangeLog.setJobName(jobName);//岗位名称
			         }
			         sysChangeLogList.add(sysChangeLog);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		if(sysChangeLogList.size()>0){
			sysChangeLogDao.insertBatch(sysChangeLogList);
		}
		return 0;
	}

}
