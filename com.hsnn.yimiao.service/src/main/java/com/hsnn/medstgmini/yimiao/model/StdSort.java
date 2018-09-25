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
 * @date 2017-12-06 14:56:42
 *
 */
public class StdSort  implements ICreateInfo, IUpdateInfo{
	
	//alias
	public static final String TABLE_ALIAS = "二级目录表";
	
	//columns START
	/**
	 * @Fields sortId:主键id
	 */
	private String sortId;
	


	/**
	 * @Fields addUserId:添加人id
	 */
	private String addUserId;
	
	/**
	 * @Fields addUserName:添加人
	 */
	private String addUserName;
	
	/**
	 * @Fields addTime:添加时间
	 */
	private Date addTime;

	/**
	 * @Fields productId:一级目录id
	 */
	private Integer productId;
	
	/**
	 * @Fields productName:一级目录名称
	 */
	private String productName;
	
	/**
	 * @Fields outlook:二级目录
	 */
	private String outlook;
	
	//columns END

	public StdSort(){
	}

	public String getSortId() {
		return sortId;
	}

	public void setSortId(String sortId) {
		this.sortId = sortId;
	}

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public void setAddUserId(String addUserId){
		this.addUserId = addUserId;
	}

	@Override
	public void setLastUpdateUserId(String lastUpdateUserId) {

	}

	@Override
	public void setLastUpdateUserName(String lastUpdateUserName) {

	}

	public String getAddUserId(){
		return addUserId;
	}
	
	public void setAddUserName(String addUserName){
		this.addUserName = addUserName;
	}
	
	public String getAddUserName(){
		return addUserName;
	}
	
	public void setAddTime(Date addTime){
		this.addTime = addTime;
	}
	
	public Date getAddTime(){
		return addTime;
	}

	public void setProductName(String productName){
		this.productName = productName;
	}
	
	public String getProductName(){
		return productName;
	}
	
	public void setOutlook(String outlook){
		this.outlook = outlook;
	}
	
	public String getOutlook(){
		return outlook;
	}


}