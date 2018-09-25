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
		String mechanismName = null;
		Integer type=sysUser.getUserType();
		if(UserType.scqy.getKey().equals(type)){
			StdCompanys stdCompany = sysUser.getStdCompany();
			if(stdCompany!=null){
				mechanismName = stdCompany.getCompanyName();
			}
		}else if(UserType.wsj.getKey().equals(type) || UserType.cgzx.getKey().equals(type) ){
			StdManageOrg stdManageOrg  = sysUser.getStdManageOrg();
			if(stdManageOrg!=null){
				mechanismName = stdManageOrg.getHeaBurName();
			}
		}else if(UserType.jkzx.getKey().equals(type)){
			StdHospitals hospital = sysUser.getStdHospital();
			if(hospital!=null){
				mechanismName = hospital.getHospitalName();
			}
		}
		return mechanismName;
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


}
