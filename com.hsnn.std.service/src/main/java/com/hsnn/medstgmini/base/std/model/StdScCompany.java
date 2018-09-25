package com.hsnn.medstgmini.base.std.model;

import java.util.Date;
import java.math.BigDecimal;



import com.hsnn.medstgmini.common.model.ICreateInfo;
import com.hsnn.medstgmini.common.model.IUpdateInfo;

/**
 *
 * @Since 2010-2018
 * @Description: TODO
 * @author ***
 * @date 2018-03-30 11:35:31
 *
 */
public class StdScCompany  implements ICreateInfo, IUpdateInfo{
	
	//alias
	public static final String TABLE_ALIAS = "生产企业表";
	
	//columns START
	/**
	 * @Fields id:主键
	 */
	private String id;
	
	/**
	 * @Fields companyAccountCode:生产企业账号
	 */
	private String companyAccountCode;
	
	/**
	 * @Fields companyIdSc:生产企业编号
	 */
	private String companyIdSc;
	
	/**
	 * @Fields companyNameSc:生产企业名称
	 */
	private String companyNameSc;
	
	/**
	 * @Fields 
	 */
	private Integer submitState;
	
	/**
	 * @Fields remark:备注
	 */
	private String remark;
	
	/**
	 * @Fields addUserId:添加人id
	 */
	private String addUserId;
	
	/**
	 * @Fields addTime:添加时间
	 */
	private Date addTime;
	
	/**
	 * @Fields addUserName:添加人姓名
	 */
	private String addUserName;
	
	/**
	 * @Fields lastUpdateUserId:修改人id
	 */
	private String lastUpdateUserId;
	
	/**
	 * @Fields lastUpdateUserName:修改人名称
	 */
	private String lastUpdateUserName;
	
	/**
	 * @Fields lastUpdateTime:修改时间
	 */
	private Date lastUpdateTime;
	
	//columns END

	public StdScCompany(){
	}

	public StdScCompany(String id){
		this.id = id;
	}

	
	public void setId(String id){
		this.id = id;
	}
	
	public String getId(){
		return id;
	}
	
	public void setCompanyAccountCode(String companyAccountCode){
		this.companyAccountCode = companyAccountCode;
	}
	
	public String getCompanyAccountCode(){
		return companyAccountCode;
	}
	
	public void setCompanyIdSc(String companyIdSc){
		this.companyIdSc = companyIdSc;
	}
	
	public String getCompanyIdSc(){
		return companyIdSc;
	}
	
	public void setCompanyNameSc(String companyNameSc){
		this.companyNameSc = companyNameSc;
	}
	
	public String getCompanyNameSc(){
		return companyNameSc;
	}
	
	public Integer getSubmitState() {
		return submitState;
	}

	public void setSubmitState(Integer submitState) {
		this.submitState = submitState;
	}

	public void setRemark(String remark){
		this.remark = remark;
	}
	
	public String getRemark(){
		return remark;
	}
	
	public void setAddUserId(String addUserId){
		this.addUserId = addUserId;
	}
	
	public String getAddUserId(){
		return addUserId;
	}
	
	public void setAddTime(Date addTime){
		this.addTime = addTime;
	}
	
	public Date getAddTime(){
		return addTime;
	}
	
	public void setAddUserName(String addUserName){
		this.addUserName = addUserName;
	}
	
	public String getAddUserName(){
		return addUserName;
	}
	
	public void setLastUpdateUserId(String lastUpdateUserId){
		this.lastUpdateUserId = lastUpdateUserId;
	}
	
	public String getLastUpdateUserId(){
		return lastUpdateUserId;
	}
	
	public void setLastUpdateUserName(String lastUpdateUserName){
		this.lastUpdateUserName = lastUpdateUserName;
	}
	
	public String getLastUpdateUserName(){
		return lastUpdateUserName;
	}
	
	public void setLastUpdateTime(Date lastUpdateTime){
		this.lastUpdateTime = lastUpdateTime;
	}
	
	public Date getLastUpdateTime(){
		return lastUpdateTime;
	}


}