package com.hsnn.medstgmini.base.std.model;



import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 *
 * @Since 2010-2016
 * @Description: TODO
 * @author ***
 * @date 2016-05-20 15:34:54
 *
 */
public class StdPrice  implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	//alias
	public static final String TABLE_ALIAS = "StdPrice";
	
	private String id;
	
	private Integer goodsId;
	
	private String productName;
	
	private String medicinemodel;
	
	private String outlook;
	
	private Integer factor;
	
	private String unit;
	
	private String materialName;
	
	private String companyIdSc;
	
	private String companyNameSc;
	private Integer sourceId;
	private String sourceName;
	private BigDecimal bidPrice;
	private String areaId;
	private String hospId;
	private String hospName;
	private String combineId;
	private String combineName;
	private String addUserId;
	private String addUserName;
	private Date addTime;
	private Integer procurecatalogId;
	private Integer varType;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Integer getGoodsId() {
		return goodsId;
	}
	public void setGoodsId(Integer goodsId) {
		this.goodsId = goodsId;
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
	public Integer getFactor() {
		return factor;
	}
	public void setFactor(Integer factor) {
		this.factor = factor;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	public String getMaterialName() {
		return materialName;
	}
	public void setMaterialName(String materialName) {
		this.materialName = materialName;
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
	public Integer getSourceId() {
		return sourceId;
	}
	public void setSourceId(Integer sourceId) {
		this.sourceId = sourceId;
	}
	public String getSourceName() {
		return sourceName;
	}
	public void setSourceName(String sourceName) {
		this.sourceName = sourceName;
	}
	public BigDecimal getBidPrice() {
		return bidPrice;
	}
	public void setBidPrice(BigDecimal bidPrice) {
		this.bidPrice = bidPrice;
	}
	public String getAreaId() {
		return areaId;
	}
	public void setAreaId(String areaId) {
		this.areaId = areaId;
	}
	public String getHospId() {
		return hospId;
	}
	public void setHospId(String hospId) {
		this.hospId = hospId;
	}
	public String getHospName() {
		return hospName;
	}
	public void setHospName(String hospName) {
		this.hospName = hospName;
	}
	public String getCombineId() {
		return combineId;
	}
	public void setCombineId(String combineId) {
		this.combineId = combineId;
	}
	public String getCombineName() {
		return combineName;
	}
	public void setCombineName(String combineName) {
		this.combineName = combineName;
	}
	public String getAddUserId() {
		return addUserId;
	}
	public void setAddUserId(String addUserId) {
		this.addUserId = addUserId;
	}
	public String getAddUserName() {
		return addUserName;
	}
	public void setAddUserName(String addUserName) {
		this.addUserName = addUserName;
	}
	public Date getAddTime() {
		return addTime;
	}
	public void setAddTime(Date addTime) {
		this.addTime = addTime;
	}
	public Integer getProcurecatalogId() {
		return procurecatalogId;
	}
	public void setProcurecatalogId(Integer procurecatalogId) {
		this.procurecatalogId = procurecatalogId;
	}
	public Integer getVarType() {
		return varType;
	}
	public void setVarType(Integer varType) {
		this.varType = varType;
	}
	
	
	
}