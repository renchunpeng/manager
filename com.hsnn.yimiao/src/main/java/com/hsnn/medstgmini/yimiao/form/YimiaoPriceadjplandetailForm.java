package com.hsnn.medstgmini.yimiao.form;

import java.util.Date;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import javax.validation.constraints.Digits;

/**
 *
 * @Since 2010-2017
 * @Description: TODO
 * @author ***
 * @date 2017-12-11 18:02:41
 *
 */
public class YimiaoPriceadjplandetailForm  {

	//columns START
	
	/**
	 * @Fields PRICE_ADJ_PALN_DETAIL_ID:计划明细id
	 */
	@NotEmpty(message = "请填写计划明细id")
	@Length(max = 36, message = "计划明细id的长度不能超过{1}")
	private String priceAdjPalnDetailId;
	
	/**
	 * @Fields PRICE_ADJ_PLAN_ID:调价计划id
	 */
	@Length(max = 36, message = "调价计划id的长度不能超过{1}")
	private String priceAdjPlanId;
	
	/**
	 * @Fields GOODS_CODE:商品号
	 */
	@Length(max = 36, message = "商品号的长度不能超过{1}")
	private String goodsCode;
	
	/**
	 * @Fields ORIG_PRO_PRICE_LIMIT:原采购限价
	 */
	@Digits(integer = 18, fraction = 3, message = "数字的值超出了允许范围(只允许在{0}位整数和{1}位小数范围内)")
	private BigDecimal origProPriceLimit;
	
	/**
	 * @Fields CURR_PRO_PRICE_LIMIT:新采购限价
	 */
	@Digits(integer = 18, fraction = 3, message = "数字的值超出了允许范围(只允许在{0}位整数和{1}位小数范围内)")
	private BigDecimal currProPriceLimit;
	
	/**
	 * @Fields ORIG_RETAIL_PRICE_LIMIT:原最高零售价
	 */
	@Digits(integer = 18, fraction = 3, message = "数字的值超出了允许范围(只允许在{0}位整数和{1}位小数范围内)")
	private BigDecimal origRetailPriceLimit;
	
	/**
	 * @Fields CURR_RETAIL_PRICE_LLIMIT:新最高零售价
	 */
	@Digits(integer = 18, fraction = 3, message = "数字的值超出了允许范围(只允许在{0}位整数和{1}位小数范围内)")
	private BigDecimal currRetailPriceLlimit;
	
	/**
	 * @Fields ADD_DATETIME:加入计划时间
	 */
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date addDatetime;
	
	/**
	 * @Fields ADD_USER:加入计划操作人
	 */
	@Length(max = 36, message = "加入计划操作人的长度不能超过{1}")
	private String addUser;
	
	/**
	 * @Fields REMARKS:备注
	 */
	@Length(max = 50, message = "备注的长度不能超过{1}")
	private String remarks;
	//columns END
	

	public YimiaoPriceadjplandetailForm(){
	}

	public YimiaoPriceadjplandetailForm(String priceAdjPalnDetailId){
		this.priceAdjPalnDetailId = priceAdjPalnDetailId;
	}

	
	public void setPriceAdjPalnDetailId(String priceAdjPalnDetailId){
		this.priceAdjPalnDetailId = priceAdjPalnDetailId;
	}
	public String getPriceAdjPalnDetailId(){
		return priceAdjPalnDetailId;
	}
	
	public void setPriceAdjPlanId(String priceAdjPlanId){
		this.priceAdjPlanId = priceAdjPlanId;
	}
	public String getPriceAdjPlanId(){
		return priceAdjPlanId;
	}
	
	public void setGoodsCode(String goodsCode){
		this.goodsCode = goodsCode;
	}
	public String getGoodsCode(){
		return goodsCode;
	}
	
	public void setOrigProPriceLimit(BigDecimal origProPriceLimit){
		this.origProPriceLimit = origProPriceLimit;
	}
	public BigDecimal getOrigProPriceLimit(){
		return origProPriceLimit;
	}
	
	public void setCurrProPriceLimit(BigDecimal currProPriceLimit){
		this.currProPriceLimit = currProPriceLimit;
	}
	public BigDecimal getCurrProPriceLimit(){
		return currProPriceLimit;
	}
	
	public void setOrigRetailPriceLimit(BigDecimal origRetailPriceLimit){
		this.origRetailPriceLimit = origRetailPriceLimit;
	}
	public BigDecimal getOrigRetailPriceLimit(){
		return origRetailPriceLimit;
	}
	
	public void setCurrRetailPriceLlimit(BigDecimal currRetailPriceLlimit){
		this.currRetailPriceLlimit = currRetailPriceLlimit;
	}
	public BigDecimal getCurrRetailPriceLlimit(){
		return currRetailPriceLlimit;
	}
	
	public void setAddDatetime(Date addDatetime){
		this.addDatetime = addDatetime;
	}
	public Date getAddDatetime(){
		return addDatetime;
	}
	
	public void setAddUser(String addUser){
		this.addUser = addUser;
	}
	public String getAddUser(){
		return addUser;
	}
	
	public void setRemarks(String remarks){
		this.remarks = remarks;
	}
	public String getRemarks(){
		return remarks;
	}

}