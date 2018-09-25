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
 * @date 2017-12-11 18:02:41
 *
 */
public class YimiaoPriceadjplandetail  implements ICreateInfo, IUpdateInfo{
	
	//alias
	public static final String TABLE_ALIAS = "调价明细表";

	private YimiaoPriceadjplan yimiaoPriceadjplan;

	private YimiaoProcurecatalog yimiaoProcurecatalog;

	//columns START
	/**
	 * @Fields priceAdjPalnDetailId:计划明细id
	 */
	private String priceAdjPalnDetailId;
	
	/**
	 * @Fields priceAdjPlanId:调价计划id
	 */
	private String priceAdjPlanId;
	
	/**
	 * @Fields goodsCode:商品号
	 */
	private String goodsCode;
	
	/**
	 * @Fields origProPriceLimit:原采购限价
	 */
	private BigDecimal origProPriceLimit;
	
	/**
	 * @Fields currProPriceLimit:新采购限价
	 */
	private BigDecimal currProPriceLimit;
	
	/**
	 * @Fields origRetailPriceLimit:原最高零售价
	 */
	private BigDecimal origRetailPriceLimit;
	
	/**
	 * @Fields currRetailPriceLlimit:新最高零售价
	 */
	private BigDecimal currRetailPriceLlimit;
	
	/**
	 * @Fields addDatetime:加入计划时间
	 */
	private Date addDatetime;
	
	/**
	 * @Fields addUser:加入计划操作人
	 */
	private String addUser;
	
	/**
	 * @Fields remarks:备注
	 */
	private String remarks;
	
	//columns END

	public YimiaoPriceadjplandetail(){
	}

	public YimiaoPriceadjplandetail(String priceAdjPalnDetailId){
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

	public YimiaoPriceadjplan getYimiaoPriceadjplan() {
		return yimiaoPriceadjplan;
	}

	public void setYimiaoPriceadjplan(YimiaoPriceadjplan yimiaoPriceadjplan) {
		this.yimiaoPriceadjplan = yimiaoPriceadjplan;
	}

	public YimiaoProcurecatalog getYimiaoProcurecatalog() {
		return yimiaoProcurecatalog;
	}

	public void setYimiaoProcurecatalog(YimiaoProcurecatalog yimiaoProcurecatalog) {
		this.yimiaoProcurecatalog = yimiaoProcurecatalog;
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