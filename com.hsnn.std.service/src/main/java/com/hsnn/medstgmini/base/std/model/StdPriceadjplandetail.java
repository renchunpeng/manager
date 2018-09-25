package com.hsnn.medstgmini.base.std.model;

import com.hsnn.medstgmini.common.model.ICreateInfo;
import com.hsnn.medstgmini.common.model.IUpdateInfo;

import java.math.BigDecimal;
import java.util.Date;

/**
 *
 * @Since 2010-2017
 * @Description: TODO
 * @author ***
 * @date 2017-09-12 14:24:54
 *
 */
public class StdPriceadjplandetail  implements ICreateInfo, IUpdateInfo {
	
	//alias
	public static final String TABLE_ALIAS = "调价明细";


	private String projName;
	private String productName;
	private String medicinemodel;
	private String outlook;
	private String factor;
	private String materialName;
	private String unit;
	private String companyIdSc;
	private String companyNameSc;
	private BigDecimal bidPrice;
	private String sourceId;
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

	private String remark;

	private StdPriceadjplan stdPriceadjplan;

	//columns END

	private Integer goodsId;



	public StdPriceadjplan getStdPriceadjplan() {
		return stdPriceadjplan;
	}

	public void setStdPriceadjplan(StdPriceadjplan stdPriceadjplan) {
		this.stdPriceadjplan = stdPriceadjplan;
	}



	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
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

	public String getSourceId() {
		return sourceId;
	}

	public void setSourceId(String sourceId) {
		this.sourceId = sourceId;
	}

	public void setGoodsCode(String goodsCode){
		this.goodsCode = goodsCode;
	}

	public String getGoodsCode(){
		return goodsCode;
	}

	public BigDecimal getOrigProPriceLimit() {
		return origProPriceLimit;
	}

	public void setOrigProPriceLimit(BigDecimal origProPriceLimit) {
		this.origProPriceLimit = origProPriceLimit;
	}

	public BigDecimal getCurrProPriceLimit() {
		return currProPriceLimit;
	}

	public void setCurrProPriceLimit(BigDecimal currProPriceLimit) {
		this.currProPriceLimit = currProPriceLimit;
	}

	public BigDecimal getOrigRetailPriceLimit() {
		return origRetailPriceLimit;
	}

	public void setOrigRetailPriceLimit(BigDecimal origRetailPriceLimit) {
		this.origRetailPriceLimit = origRetailPriceLimit;
	}

	public BigDecimal getCurrRetailPriceLlimit() {
		return currRetailPriceLlimit;
	}

	public void setCurrRetailPriceLlimit(BigDecimal currRetailPriceLlimit) {
		this.currRetailPriceLlimit = currRetailPriceLlimit;
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





	@Override
	public void setLastUpdateUserId(String lastUpdateUserId) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setLastUpdateUserName(String lastUpdateUserName) {
		// TODO Auto-generated method stub

	}

	public String getProjName() {
		return projName;
	}

	public void setProjName(String projName) {
		this.projName = projName;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getMedicinemodel() {
		return medicinemodel;
	}

	public void setMedicinemodel(String medicinemodel) {
		this.medicinemodel = medicinemodel;
	}

	public String getOutlook() {
		return outlook;
	}

	public void setOutlook(String outlook) {
		this.outlook = outlook;
	}

	public String getFactor() {
		return factor;
	}

	public void setFactor(String factor) {
		this.factor = factor;
	}

	public String getMaterialName() {
		return materialName;
	}

	public void setMaterialName(String materialName) {
		this.materialName = materialName;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public String getCompanyIdSc() {
		return companyIdSc;
	}

	public void setCompanyIdSc(String companyIdSc) {
		this.companyIdSc = companyIdSc;
	}

	public String getCompanyNameSc() {
		return companyNameSc;
	}

	public void setCompanyNameSc(String companyNameSc) {
		this.companyNameSc = companyNameSc;
	}

	public BigDecimal getBidPrice() {
		return bidPrice;
	}

	public void setBidPrice(BigDecimal bidPrice) {
		this.bidPrice = bidPrice;
	}

	@Override
	public void setAddUserName(String addUserName) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setAddUserId(String addUserId) {
		// TODO Auto-generated method stub

	}

	public Integer getGoodsId() {
		return goodsId;
	}

	public void setGoodsId(Integer goodsId) {
		this.goodsId = goodsId;
	}
}