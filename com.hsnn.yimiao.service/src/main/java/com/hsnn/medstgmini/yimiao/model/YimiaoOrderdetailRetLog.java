package com.hsnn.medstgmini.yimiao.model;

import java.util.Date;
import java.math.BigDecimal;



import com.hsnn.medstgmini.common.model.ICreateInfo;
import com.hsnn.medstgmini.common.model.IUpdateInfo;

/**
 *
 * @Since 2010-2016
 * @Description: TODO
 * @author ***
 * @date 2016-11-28 08:58:36
 *
 */
public class YimiaoOrderdetailRetLog  implements ICreateInfo, IUpdateInfo{
	
	//alias
	public static final String TABLE_ALIAS = "疫苗_退货单明细日志表";
	
	//columns START
	/**
	 * @Fields logId:日志Id
	 */
	private String logId;
	
	/**
	 * @Fields orderdetailRetId:退货单明细Id
	 */
	private String orderdetailRetId;
	
	/**
	 * @Fields orderId:订单Id
	 */
	private String orderId;
	
	/**
	 * @Fields procurecatalogId:商品Id
	 */
	private Integer procurecatalogId;
	
	/**
	 * @Fields goodsId:产品代码
	 */
	private String goodsId;
	
	/**
	 * @Fields productName:通用名
	 */
	private String productName;
	
	/**
	 * @Fields productSpelName:通用名拼音码
	 */
	private String productSpelName;
	
	/**
	 * @Fields productWbName:通用名五笔码
	 */
	private String productWbName;
	
	/**
	 * @Fields goodsName:商品名
	 */
	private String goodsName;
	
	/**
	 * @Fields medicinemodel:剂型
	 */
	private String medicinemodel;
	
	/**
	 * @Fields outlook:规格
	 */
	private String outlook;
	
	/**
	 * @Fields factor:转换比
	 */
	private Integer factor;
	
	/**
	 * @Fields materialName:包装材质
	 */
	private String materialName;
	
	/**
	 * @Fields unit:单位
	 */
	private String unit;
	
	/**
	 * @Fields companyIdSc:生产企业名称
	 */
	private String companyIdSc;
	
	/**
	 * @Fields companyNameSc:生产企业名称
	 */
	private String companyNameSc;
	
	/**
	 * @Fields splitCompanyName:分包装企业
	 */
	private String splitCompanyName;
	
	/**
	 * @Fields trustCompanyName:委托加工企业
	 */
	private String trustCompanyName;
	
	/**
	 * @Fields companyIdTb:投标企业编号
	 */
	private String companyIdTb;
	
	/**
	 * @Fields companyNameTb:投标企业名称
	 */
	private String companyNameTb;
	
	/**
	 * @Fields middlePack:中包装
	 */
	private Integer middlePack;
	
	/**
	 * @Fields maxPack:大包装
	 */
	private Integer maxPack;
	
	/**
	 * @Fields isBaseDrug:是否基药(0:否,1:是)
	 */
	private Integer isBaseDrug;
	
	/**
	 * @Fields qualityLevel:质量层次
	 */
	private String qualityLevel;
	
	/**
	 * @Fields purchaseType:采购类别(0:中标药品，1：廉价药品，2：紧张药品，3：低价药品，4：备案药品)
	 */
	private Integer purchaseType;
	
	/**
	 * @Fields sourceId:来源id
	 */
	private Integer sourceId;
	
	/**
	 * @Fields sourceName:来源名称
	 */
	private String sourceName;
	
	/**
	 * @Fields bidPrice:中标价格(采购类别为中标类的,写入.其他的写0)
	 */
	private BigDecimal bidPrice;
	
	/**
	 * @Fields usingRang:使用范围（0：县上，1：基层，2：全省）
	 */
	private Integer usingRang;
	
	/**
	 * @Fields hospitalId:医疗机构编号
	 */
	private String hospitalId;
	
	/**
	 * @Fields hospitalName:医疗机构名称
	 */
	private String hospitalName;
	
	/**
	 * @Fields hospitalDepartmentId:医疗机构部门编号
	 */
	private Integer hospitalDepartmentId;
	
	/**
	 * @Fields hospitalDepartmentName:医疗机构部门名称
	 */
	private String hospitalDepartmentName;
	
	/**
	 * @Fields adminAreaIdStatisticsDrug:药品行政区域id统计
	 */
	private Integer adminAreaIdStatisticsDrug;
	
	/**
	 * @Fields adminAreaNameDrug:药品行政区域名称
	 */
	private String adminAreaNameDrug;
	
	/**
	 * @Fields adminAreaIdDrug:药品行政区域id
	 */
	private Integer adminAreaIdDrug;
	
	/**
	 * @Fields belongOrgName:所属行政机构名称
	 */
	private String belongOrgName;
	
	/**
	 * @Fields orderType:订单类型（0：正常订单，1：急救药品临时订单）
	 */
	private Integer orderType;
	
	/**
	 * @Fields orderName:订单名称
	 */
	private String orderName;
	
	/**
	 * @Fields submitTime:提交时间
	 */
	private Date submitTime;
	
	/**
	 * @Fields filingId:备案编号(单内删除时,还原相应记录为未采购)
	 */
	private Integer filingId;
	
	/**
	 * @Fields companyIdPs:配送企业编号
	 */
	private String companyIdPs;
	
	/**
	 * @Fields companyNamePs:配送企业名称
	 */
	private String companyNamePs;
	
	/**
	 * @Fields purchasePrice:采购价格
	 */
	private BigDecimal purchasePrice;
	
	/**
	 * @Fields purchaseCount:采购数量
	 */
	private Integer purchaseCount;
	
	/**
	 * @Fields purchaseAmount:采购总金额
	 */
	private BigDecimal purchaseAmount;
	
	/**
	 * @Fields isRead:是否已阅读
	 */
	private Integer isRead;
	
	/**
	 * @Fields readUserId:阅读人Id
	 */
	private String readUserId;
	
	/**
	 * @Fields readUserName:阅读人
	 */
	private String readUserName;
	
	/**
	 * @Fields readTime:阅读时间
	 */
	private Date readTime;
	
	/**
	 * @Fields confirmUserId:确认人Id
	 */
	private String confirmUserId;
	
	/**
	 * @Fields confirmUserName:确认人
	 */
	private String confirmUserName;
	
	/**
	 * @Fields confirmTime:确认时间
	 */
	private Date confirmTime;
	
	/**
	 * @Fields confirmState:确认状态 0 - 待处理 1 - 供货 2 - 不供货
	 */
	private Integer confirmState;
	
	/**
	 * @Fields orderdetailState:采购明细状态（0 已保存待提交 1已提交待确认 2已确认待配送 3 拒绝确认4 已配送待收货5 拒绝配送 6 未及时配送 7 收货中 8 已收货 9 已撤单 ）
	 */
	private Integer orderdetailState;
	
	/**
	 * @Fields refuseReason:拒绝理由
	 */
	private String refuseReason;
	
	/**
	 * @Fields detailDistributeAddress:订单明细配送地址
	 */
	private String detailDistributeAddress;
	
	/**
	 * @Fields totalDistributeCount:总配送数量
	 */
	private Integer totalDistributeCount;
	
	/**
	 * @Fields totalDistributeAmount:总配送金额
	 */
	private BigDecimal totalDistributeAmount;
	
	/**
	 * @Fields totalWarehouseCount:总收货数量
	 */
	private Integer totalWarehouseCount;
	
	/**
	 * @Fields totalWarehouseAmount:总收货金额
	 */
	private BigDecimal totalWarehouseAmount;
	
	/**
	 * @Fields totalReturnAmount:总退货金额
	 */
	private BigDecimal totalReturnAmount;
	
	/**
	 * @Fields totalReturnCount:总退货数量
	 */
	private Integer totalReturnCount;
	
	/**
	 * @Fields isUsing:是否启用
	 */
	private Integer isUsing;
	
	/**
	 * @Fields compRatio:完成率
	 */
	private BigDecimal compRatio;
	
	/**
	 * @Fields orderCustomInfo:订单自定义信息
	 */
	private String orderCustomInfo;
	
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
	
	/**
	 * @Fields lastUpdateUserId:最后一次更新记录人id
	 */
	private String lastUpdateUserId;
	
	/**
	 * @Fields lastUpdateUserName:最后一次更新记录人
	 */
	private String lastUpdateUserName;
	
	/**
	 * @Fields lastUpdateTime:最后一次更新记录时间
	 */
	private Date lastUpdateTime;
	
	//columns END

	public YimiaoOrderdetailRetLog(){
	}

	public YimiaoOrderdetailRetLog(String logId){
		this.logId = logId;
	}

	
	public void setLogId(String logId){
		this.logId = logId;
	}
	
	public String getLogId(){
		return logId;
	}
	
	public void setOrderdetailRetId(String orderdetailRetId){
		this.orderdetailRetId = orderdetailRetId;
	}
	
	public String getOrderdetailRetId(){
		return orderdetailRetId;
	}
	
	public void setOrderId(String orderId){
		this.orderId = orderId;
	}
	
	public String getOrderId(){
		return orderId;
	}
	
	public void setProcurecatalogId(Integer procurecatalogId){
		this.procurecatalogId = procurecatalogId;
	}
	
	public Integer getProcurecatalogId(){
		return procurecatalogId;
	}
	
	public void setGoodsId(String goodsId){
		this.goodsId = goodsId;
	}
	
	public String getGoodsId(){
		return goodsId;
	}
	
	public void setProductName(String productName){
		this.productName = productName;
	}
	
	public String getProductName(){
		return productName;
	}
	
	public void setProductSpelName(String productSpelName){
		this.productSpelName = productSpelName;
	}
	
	public String getProductSpelName(){
		return productSpelName;
	}
	
	public void setProductWbName(String productWbName){
		this.productWbName = productWbName;
	}
	
	public String getProductWbName(){
		return productWbName;
	}
	
	public void setGoodsName(String goodsName){
		this.goodsName = goodsName;
	}
	
	public String getGoodsName(){
		return goodsName;
	}
	
	public void setMedicinemodel(String medicinemodel){
		this.medicinemodel = medicinemodel;
	}
	
	public String getMedicinemodel(){
		return medicinemodel;
	}
	
	public void setOutlook(String outlook){
		this.outlook = outlook;
	}
	
	public String getOutlook(){
		return outlook;
	}
	
	public void setFactor(Integer factor){
		this.factor = factor;
	}
	
	public Integer getFactor(){
		return factor;
	}
	
	public void setMaterialName(String materialName){
		this.materialName = materialName;
	}
	
	public String getMaterialName(){
		return materialName;
	}
	
	public void setUnit(String unit){
		this.unit = unit;
	}
	
	public String getUnit(){
		return unit;
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
	
	public void setSplitCompanyName(String splitCompanyName){
		this.splitCompanyName = splitCompanyName;
	}
	
	public String getSplitCompanyName(){
		return splitCompanyName;
	}
	
	public void setTrustCompanyName(String trustCompanyName){
		this.trustCompanyName = trustCompanyName;
	}
	
	public String getTrustCompanyName(){
		return trustCompanyName;
	}
	
	public void setCompanyIdTb(String companyIdTb){
		this.companyIdTb = companyIdTb;
	}
	
	public String getCompanyIdTb(){
		return companyIdTb;
	}
	
	public void setCompanyNameTb(String companyNameTb){
		this.companyNameTb = companyNameTb;
	}
	
	public String getCompanyNameTb(){
		return companyNameTb;
	}
	
	public void setMiddlePack(Integer middlePack){
		this.middlePack = middlePack;
	}
	
	public Integer getMiddlePack(){
		return middlePack;
	}
	
	public void setMaxPack(Integer maxPack){
		this.maxPack = maxPack;
	}
	
	public Integer getMaxPack(){
		return maxPack;
	}
	
	public void setIsBaseDrug(Integer isBaseDrug){
		this.isBaseDrug = isBaseDrug;
	}
	
	public Integer getIsBaseDrug(){
		return isBaseDrug;
	}
	
	public void setQualityLevel(String qualityLevel){
		this.qualityLevel = qualityLevel;
	}
	
	public String getQualityLevel(){
		return qualityLevel;
	}
	
	public void setPurchaseType(Integer purchaseType){
		this.purchaseType = purchaseType;
	}
	
	public Integer getPurchaseType(){
		return purchaseType;
	}
	
	public void setSourceId(Integer sourceId){
		this.sourceId = sourceId;
	}
	
	public Integer getSourceId(){
		return sourceId;
	}
	
	public void setSourceName(String sourceName){
		this.sourceName = sourceName;
	}
	
	public String getSourceName(){
		return sourceName;
	}
	
	public void setBidPrice(BigDecimal bidPrice){
		this.bidPrice = bidPrice;
	}
	
	public BigDecimal getBidPrice(){
		return bidPrice;
	}
	
	public void setUsingRang(Integer usingRang){
		this.usingRang = usingRang;
	}
	
	public Integer getUsingRang(){
		return usingRang;
	}
	
	public void setHospitalId(String hospitalId){
		this.hospitalId = hospitalId;
	}
	
	public String getHospitalId(){
		return hospitalId;
	}
	
	public void setHospitalName(String hospitalName){
		this.hospitalName = hospitalName;
	}
	
	public String getHospitalName(){
		return hospitalName;
	}
	
	public void setHospitalDepartmentId(Integer hospitalDepartmentId){
		this.hospitalDepartmentId = hospitalDepartmentId;
	}
	
	public Integer getHospitalDepartmentId(){
		return hospitalDepartmentId;
	}
	
	public void setHospitalDepartmentName(String hospitalDepartmentName){
		this.hospitalDepartmentName = hospitalDepartmentName;
	}
	
	public String getHospitalDepartmentName(){
		return hospitalDepartmentName;
	}
	
	public void setAdminAreaIdStatisticsDrug(Integer adminAreaIdStatisticsDrug){
		this.adminAreaIdStatisticsDrug = adminAreaIdStatisticsDrug;
	}
	
	public Integer getAdminAreaIdStatisticsDrug(){
		return adminAreaIdStatisticsDrug;
	}
	
	public void setAdminAreaNameDrug(String adminAreaNameDrug){
		this.adminAreaNameDrug = adminAreaNameDrug;
	}
	
	public String getAdminAreaNameDrug(){
		return adminAreaNameDrug;
	}
	
	public void setAdminAreaIdDrug(Integer adminAreaIdDrug){
		this.adminAreaIdDrug = adminAreaIdDrug;
	}
	
	public Integer getAdminAreaIdDrug(){
		return adminAreaIdDrug;
	}
	
	public void setBelongOrgName(String belongOrgName){
		this.belongOrgName = belongOrgName;
	}
	
	public String getBelongOrgName(){
		return belongOrgName;
	}
	
	public void setOrderType(Integer orderType){
		this.orderType = orderType;
	}
	
	public Integer getOrderType(){
		return orderType;
	}
	
	public void setOrderName(String orderName){
		this.orderName = orderName;
	}
	
	public String getOrderName(){
		return orderName;
	}
	
	public void setSubmitTime(Date submitTime){
		this.submitTime = submitTime;
	}
	
	public Date getSubmitTime(){
		return submitTime;
	}
	
	public void setFilingId(Integer filingId){
		this.filingId = filingId;
	}
	
	public Integer getFilingId(){
		return filingId;
	}
	
	public void setCompanyIdPs(String companyIdPs){
		this.companyIdPs = companyIdPs;
	}
	
	public String getCompanyIdPs(){
		return companyIdPs;
	}
	
	public void setCompanyNamePs(String companyNamePs){
		this.companyNamePs = companyNamePs;
	}
	
	public String getCompanyNamePs(){
		return companyNamePs;
	}
	
	public void setPurchasePrice(BigDecimal purchasePrice){
		this.purchasePrice = purchasePrice;
	}
	
	public BigDecimal getPurchasePrice(){
		return purchasePrice;
	}
	
	public void setPurchaseCount(Integer purchaseCount){
		this.purchaseCount = purchaseCount;
	}
	
	public Integer getPurchaseCount(){
		return purchaseCount;
	}
	
	public void setPurchaseAmount(BigDecimal purchaseAmount){
		this.purchaseAmount = purchaseAmount;
	}
	
	public BigDecimal getPurchaseAmount(){
		return purchaseAmount;
	}
	
	public void setIsRead(Integer isRead){
		this.isRead = isRead;
	}
	
	public Integer getIsRead(){
		return isRead;
	}
	
	public void setReadUserId(String readUserId){
		this.readUserId = readUserId;
	}
	
	public String getReadUserId(){
		return readUserId;
	}
	
	public void setReadUserName(String readUserName){
		this.readUserName = readUserName;
	}
	
	public String getReadUserName(){
		return readUserName;
	}
	
	public void setReadTime(Date readTime){
		this.readTime = readTime;
	}
	
	public Date getReadTime(){
		return readTime;
	}
	
	public void setConfirmUserId(String confirmUserId){
		this.confirmUserId = confirmUserId;
	}
	
	public String getConfirmUserId(){
		return confirmUserId;
	}
	
	public void setConfirmUserName(String confirmUserName){
		this.confirmUserName = confirmUserName;
	}
	
	public String getConfirmUserName(){
		return confirmUserName;
	}
	
	public void setConfirmTime(Date confirmTime){
		this.confirmTime = confirmTime;
	}
	
	public Date getConfirmTime(){
		return confirmTime;
	}
	
	public void setConfirmState(Integer confirmState){
		this.confirmState = confirmState;
	}
	
	public Integer getConfirmState(){
		return confirmState;
	}
	
	public void setOrderdetailState(Integer orderdetailState){
		this.orderdetailState = orderdetailState;
	}
	
	public Integer getOrderdetailState(){
		return orderdetailState;
	}
	
	public void setRefuseReason(String refuseReason){
		this.refuseReason = refuseReason;
	}
	
	public String getRefuseReason(){
		return refuseReason;
	}
	
	public void setDetailDistributeAddress(String detailDistributeAddress){
		this.detailDistributeAddress = detailDistributeAddress;
	}
	
	public String getDetailDistributeAddress(){
		return detailDistributeAddress;
	}
	
	public void setTotalDistributeCount(Integer totalDistributeCount){
		this.totalDistributeCount = totalDistributeCount;
	}
	
	public Integer getTotalDistributeCount(){
		return totalDistributeCount;
	}
	
	public void setTotalDistributeAmount(BigDecimal totalDistributeAmount){
		this.totalDistributeAmount = totalDistributeAmount;
	}
	
	public BigDecimal getTotalDistributeAmount(){
		return totalDistributeAmount;
	}
	
	public void setTotalWarehouseCount(Integer totalWarehouseCount){
		this.totalWarehouseCount = totalWarehouseCount;
	}
	
	public Integer getTotalWarehouseCount(){
		return totalWarehouseCount;
	}
	
	public void setTotalWarehouseAmount(BigDecimal totalWarehouseAmount){
		this.totalWarehouseAmount = totalWarehouseAmount;
	}
	
	public BigDecimal getTotalWarehouseAmount(){
		return totalWarehouseAmount;
	}
	
	public void setTotalReturnAmount(BigDecimal totalReturnAmount){
		this.totalReturnAmount = totalReturnAmount;
	}
	
	public BigDecimal getTotalReturnAmount(){
		return totalReturnAmount;
	}
	
	public void setTotalReturnCount(Integer totalReturnCount){
		this.totalReturnCount = totalReturnCount;
	}
	
	public Integer getTotalReturnCount(){
		return totalReturnCount;
	}
	
	public void setIsUsing(Integer isUsing){
		this.isUsing = isUsing;
	}
	
	public Integer getIsUsing(){
		return isUsing;
	}
	
	public void setCompRatio(BigDecimal compRatio){
		this.compRatio = compRatio;
	}
	
	public BigDecimal getCompRatio(){
		return compRatio;
	}
	
	public void setOrderCustomInfo(String orderCustomInfo){
		this.orderCustomInfo = orderCustomInfo;
	}
	
	public String getOrderCustomInfo(){
		return orderCustomInfo;
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