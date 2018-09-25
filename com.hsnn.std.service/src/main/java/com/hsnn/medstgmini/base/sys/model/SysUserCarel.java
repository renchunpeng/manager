package com.hsnn.medstgmini.base.sys.model;

import com.hsnn.medstgmini.common.model.ICreateInfo;
import com.hsnn.medstgmini.common.model.IUpdateInfo;

/**
 *
 * @Since 2010-2016
 * @Description: TODO
 * @author ***
 * @date 2016-06-27 18:17:05
 *
 */
public class SysUserCarel  implements ICreateInfo, IUpdateInfo{
	

	//alias
	public static final String TABLE_ALIAS = "SysUserCarel";
	
	//columns START
	/**
	 * @Fields caCode:caCode
	 */
	private String caCode;
	
	/**
	 * @Fields userId:用户ID
	 */
	private String userId;
	

	public SysUserCarel(){
	}



	public String getCaCode() {
		return caCode;
	}


	public void setCaCode(String caCode) {
		this.caCode = caCode;
	}


	public String getUserId() {
		return userId;
	}


	public void setUserId(String userId) {
		this.userId = userId;
	}



	@Override
	public void setLastUpdateUserId(String lastUpdateUserId) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void setLastUpdateUserName(String lastUpdateUserName) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void setAddUserName(String addUserName) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void setAddUserId(String addUserId) {
		// TODO Auto-generated method stub
		
	}



}