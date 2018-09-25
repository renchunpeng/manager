package com.hsnn.medstgmini.yimiao.model;

import java.util.Date;
import java.math.BigDecimal;



import com.hsnn.medstgmini.common.model.ICreateInfo;
import com.hsnn.medstgmini.common.model.IUpdateInfo;

/**
 *
 * @Since 2010-2017
 * @Description: TODO
 * @author ***
 * @date 2017-12-11 17:24:13
 *
 */
public class YimiaoPriceadjplan  implements ICreateInfo, IUpdateInfo{
	
	//alias
	public static final String TABLE_ALIAS = "调价表";
	
	//columns START
	/**
	 * @Fields priceAdjPlanId:调价计划id
	 */
	private String priceAdjPlanId;
	
	/**
	 * @Fields priceAdjPlanName:调价计划名称
	 */
	private String priceAdjPlanName;
	
	/**
	 * @Fields priceAdjPlanCat:调价计划类型
	 */
	private String priceAdjPlanCat;
	
	/**
	 * @Fields executeCat:执行类型：1立刻执行2定时执行
	 */
	private Integer executeCat;
	
	/**
	 * @Fields createDatetime:创建时间
	 */
	private Date createDatetime;
	
	/**
	 * @Fields createUser:创建人
	 */
	private String createUser;
	
	/**
	 * @Fields createOrgId:createOrgId
	 */
	private String createOrgId;
	
	/**
	 * @Fields executeDatetime:执行时间
	 */
	private Date executeDatetime;
	
	/**
	 * @Fields priceAdjAccord:调价依据
	 */
	private String priceAdjAccord;
	
	/**
	 * @Fields remark:备注
	 */
	private String remark;
	
	/**
	 * @Fields status:状态0未执行1已执行
	 */
	private Integer status;
	
	/**
	 * @Fields updDatetime:更新时间
	 */
	private Date updDatetime;
	
	/**
	 * @Fields updUser:更新人
	 */
	private String updUser;
	
	//columns END

	public YimiaoPriceadjplan(){
	}

	public YimiaoPriceadjplan(String priceAdjPlanId){
		this.priceAdjPlanId = priceAdjPlanId;
	}

	
	public void setPriceAdjPlanId(String priceAdjPlanId){
		this.priceAdjPlanId = priceAdjPlanId;
	}
	
	public String getPriceAdjPlanId(){
		return priceAdjPlanId;
	}
	
	public void setPriceAdjPlanName(String priceAdjPlanName){
		this.priceAdjPlanName = priceAdjPlanName;
	}
	
	public String getPriceAdjPlanName(){
		return priceAdjPlanName;
	}
	
	public void setPriceAdjPlanCat(String priceAdjPlanCat){
		this.priceAdjPlanCat = priceAdjPlanCat;
	}
	
	public String getPriceAdjPlanCat(){
		return priceAdjPlanCat;
	}
	
	public void setExecuteCat(Integer executeCat){
		this.executeCat = executeCat;
	}
	
	public Integer getExecuteCat(){
		return executeCat;
	}
	
	public void setCreateDatetime(Date createDatetime){
		this.createDatetime = createDatetime;
	}
	
	public Date getCreateDatetime(){
		return createDatetime;
	}
	
	public void setCreateUser(String createUser){
		this.createUser = createUser;
	}
	
	public String getCreateUser(){
		return createUser;
	}
	
	public void setCreateOrgId(String createOrgId){
		this.createOrgId = createOrgId;
	}
	
	public String getCreateOrgId(){
		return createOrgId;
	}
	
	public void setExecuteDatetime(Date executeDatetime){
		this.executeDatetime = executeDatetime;
	}
	
	public Date getExecuteDatetime(){
		return executeDatetime;
	}
	
	public void setPriceAdjAccord(String priceAdjAccord){
		this.priceAdjAccord = priceAdjAccord;
	}
	
	public String getPriceAdjAccord(){
		return priceAdjAccord;
	}
	
	public void setRemark(String remark){
		this.remark = remark;
	}
	
	public String getRemark(){
		return remark;
	}
	
	public void setStatus(Integer status){
		this.status = status;
	}
	
	public Integer getStatus(){
		return status;
	}
	
	public void setUpdDatetime(Date updDatetime){
		this.updDatetime = updDatetime;
	}
	
	public Date getUpdDatetime(){
		return updDatetime;
	}
	
	public void setUpdUser(String updUser){
		this.updUser = updUser;
	}
	
	public String getUpdUser(){
		return updUser;
	}


	@Override
	public void setAddUserName(String addUserName) {

	}

	@Override
	public void setAddUserId(String addUserId) {

	}

	@Override
	public void setLastUpdateUserId(String lastUpdateUserId) {

	}

	@Override
	public void setLastUpdateUserName(String lastUpdateUserName) {

	}
}