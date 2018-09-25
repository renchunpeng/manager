package com.hsnn.medstgmini.base.std.model;

import java.util.Date;
import java.io.Serializable;




import com.hsnn.medstgmini.common.model.ICreateInfo;

/**
 *
 * @Since 2010-2016
 * @Description: TODO
 * @author ***
 * @date 2016-04-11 14:35:11
 *
 */
public class StdProductSynonym  implements Serializable,ICreateInfo{
	
	private static final long serialVersionUID = 1L;
	//alias
	public static final String TABLE_ALIAS = "StdProductSynonym";
	
	//columns START
	/**
	 * @Fields id:product_id
	 */
	private Integer id;
	
	/**
	 * @Fields productName:通用名
	 */
	private String productName;
	
	/**
	 * @Fields synonym:异名
	 */
	private String synonym;
	
	/**
	 * @Fields remark:备注
	 */
	private String remark;
	
	/**
	 * @Fields addUserId:记录添加人id
	 */
	private String addUserId;
	
	/**
	 * @Fields addUserName:记录添加人
	 */
	private String addUserName;
	
	/**
	 * @Fields addTime:记录添加时间
	 */
	private Date addTime;
	
	//columns END

	public StdProductSynonym(){
	}

	public StdProductSynonym(Integer id){
		this.id = id;
	}

	
	public void setId(Integer id){
		this.id = id;
	}
	
	public Integer getId(){
		return id;
	}
	
	public void setProductName(String productName){
		this.productName = productName;
	}
	
	public String getProductName(){
		return productName;
	}
	
	public void setSynonym(String synonym){
		this.synonym = synonym;
	}
	
	public String getSynonym(){
		return synonym;
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

	@Override
	public void setLastUpdateUserId(String lastUpdateUserId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setLastUpdateUserName(String lastUpdateUserName) {
		// TODO Auto-generated method stub
		
	}


}