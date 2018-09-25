package com.hsnn.medstgmini.util;

import com.hsnn.medstgmini.base.std.model.StdCompanys;
import com.hsnn.medstgmini.base.std.model.StdHospitals;
import com.hsnn.medstgmini.base.std.model.StdManageOrg;
import com.hsnn.medstgmini.base.sys.model.SysDepartment;
import com.hsnn.medstgmini.base.sys.model.SysPost;
import com.hsnn.medstgmini.base.sys.model.SysUser;
import com.hsnn.medstgmini.common.model.UserType;

/**
 * 判断角色
 * @author he.fan
 *
 */
public class JudgmentRole {
	
	/**
	 * 根据登陆用户判断权限查询机构名称
	 * @param sysUser
	 * @return
	 */
	public static String judgmentRole(SysUser sysUser){
		
		int type=sysUser.getUserType();
		if(UserType.scqy.getKey().equals(type)){
			StdCompanys stdCompany = sysUser.getStdCompany();
			if(stdCompany!=null){
				return stdCompany.getCompanyName();
			}
			return null;
		}else if(type==UserType.wsj.getKey() || type==UserType.cgzx.getKey() ){
			StdManageOrg stdManageOrg  = sysUser.getStdManageOrg();
			if(stdManageOrg!=null){
				return stdManageOrg.getHeaBurName();
			}
			return null;
		}else if(type==UserType.jkzx.getKey() || type==UserType.jkzx.getKey()){
			StdHospitals hospital = sysUser.getStdHospital();
			if(hospital!=null){
				return hospital.getHospitalName();
			}
			return null;
		}
		return null;
	}
	
	/**
	 * 更具登陆用户查询部门名称
	 * @param sysUser
	 * @return
	 */
	public static String judgmentDepartment(SysUser sysUser){
		SysDepartment sysDepartment = new SysDepartment();
		sysDepartment = sysUser.getSysDepartment();
		if(sysDepartment!=null){
			return sysDepartment.getGroupName();
		}
		return "";
	}
	
	/**
	 * 更具登陆用户返回岗位名称
	 * @param sysUser
	 * @return
	 */
	public static String judgmentJob(SysUser sysUser){
		SysPost sysPost = new SysPost();
		sysPost = sysUser.getSysPost();
		if(sysPost!=null){
			return sysPost.getPostName();
		}
		return "";
	}
	
	
	/**
	 * 通过当前登录用户,返回当前机构ID
	 * @param sysUser
	 * @return
	 */
	public static String judgmentRoleId(SysUser sysUser){
		
		int type=sysUser.getUserType();
		if(UserType.scqy.getKey().equals(type)){
			StdCompanys stdCompany = sysUser.getStdCompany();
			if(stdCompany!=null){
				return stdCompany.getCompanyId();
			}
			return null;
		}else if(UserType.wsj.getKey().equals(type) || UserType.cgzx.getKey().equals(type) ){
			StdManageOrg stdManageOrg  = sysUser.getStdManageOrg();
			if(stdManageOrg!=null){
				return stdManageOrg.getId();
			}
			return null;
		}else if(UserType.jkzx.getKey().equals(type)){
			StdHospitals hospital = sysUser.getStdHospital();
			if(hospital!=null){
				return hospital.getHospitalId();
			}
			return null;
		}
		return null;
	}
	
	/**
	 * 根据当前登录用户返回当前部门编号,如果没有,返回0
	 * @param sysUser
	 * @return
	 */
	public static Integer judgmentDepartmentId(SysUser sysUser){
		SysDepartment sysDepartment = new SysDepartment();
		sysDepartment = sysUser.getSysDepartment();
		if(sysDepartment!=null){
			return sysDepartment.getDepartmentId();
		}
		return 0;
	}
	


}
