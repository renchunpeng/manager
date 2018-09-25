package com.hsnn.medstgmini.yimiao.form;

import java.util.Date;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import javax.validation.constraints.Digits;

/**
 *
 * @Since 2010-2016
 * @Description: TODO
 * @author ***
 * @date 2016-11-24 15:43:42
 *
 */
public class YimiaoOrderdetailRetlogForm  {

	//columns START
	
	/**
	 * @Fields LOG_ID:order_detail_id（有序guid编号）
	 */
	@NotEmpty(message = "请填写order_detail_id（有序guid编号）")
	@Length(max = 36, message = "order_detail_id（有序guid编号）的长度不能超过{1}")
	private String logId;
	
	/**
	 * @Fields ORDERDETAIL_RET_ID:order_detail_id（有序guid编号）
	 */
	@NotEmpty(message = "请填写order_detail_id（有序guid编号）")
	@Length(max = 36, message = "order_detail_id（有序guid编号）的长度不能超过{1}")
	private String orderdetailRetId;
	
	/**
	 * @Fields ORDER_ID:order_id（有序guid编号）
	 */
	@NotEmpty(message = "请填写order_id（有序guid编号）")
	@Length(max = 36, message = "order_id（有序guid编号）的长度不能超过{1}")
	private String orderId;
	
	/**
	 * @Fields PROCURECATALOG_ID:商品Id
	 */
	@NotNull(message = "请填写商品Id")
	@Digits(integer = 22, fraction = 0, message = "数字的值超出了允许范围(只允许在{0}位整数和{1}位小数范围内)")
	private BigDecimal procurecatalogId;
	
	/**
	 * @Fields GOODS_ID:产品代码
	 */
	@NotNull(message = "请填写产品代码")
	@Digits(integer = 22, fraction = 0, message = "数字的值超出了允许范围(只允许在{0}位整数和{1}位小数范围内)")
	private BigDecimal goodsId;
	
	/**
	 * @Fields PRODUCT_NAME:通用名
	 */
	@Length(max = 512, message = "通用名的长度不能超过{1}")
	private String productName;
	
	/**
	 * @Fields PRODUCT_SPEL_NAME:通用名拼音码
	 */
	@Length(max = 512, message = "通用名拼音码的长度不能超过{1}")
	private String productSpelName;
	
	/**
	 * @Fields PRODUCT_WB_NAME:通用名五笔码
	 */
	@Length(max = 512, message = "通用名五笔码的长度不能超过{1}")
	private String productWbName;
	
	/**
	 * @Fields GOODS_NAME:商品名
	 */
	@NotEmpty(message = "请填写商品名")
	@Length(max = 36, message = "商品名的长度不能超过{1}")
	private String goodsName;
	
	/**
	 * @Fields MEDICINEMODEL:剂型
	 */
	@Length(max = 256, message = "剂型的长度不能超过{1}")
	private String medicinemodel;
	
	/**
	 * @Fields OUTLOOK:规格
	 */
	@Length(max = 256, message = "规格的长度不能超过{1}")
	private String outlook;
	
	/**
	 * @Fields FACTOR:转换比
	 */
	@Digits(integer = 22, fraction = 0, message = "数字的值超出了允许范围(只允许在{0}位整数和{1}位小数范围内)")
	private BigDecimal factor;
	
	/**
	 * @Fields MATERIAL_NAME:包装材质
	 */
	@Length(max = 36, message = "包装材质的长度不能超过{1}")
	private String materialName;
	
	/**
	 * @Fields UNIT:单位
	 */
	@Length(max = 36, message = "单位的长度不能超过{1}")
	private String unit;
	
	/**
	 * @Fields COMPANY_NAME_SC:生产企业名称
	 */
	@Length(max = 512, message = "生产企业名称的长度不能超过{1}")
	private String companyNameSc;
	
	/**
	 * @Fields SPLIT_COMPANY_NAME:分包装企业
	 */
	@Length(max = 512, message = "分包装企业的长度不能超过{1}")
	private String splitCompanyName;
	
	/**
	 * @Fields TRUST_COMPANY_NAME:委托加工企业
	 */
	@Length(max = 512, message = "委托加工企业的长度不能超过{1}")
	private String trustCompanyName;
	
	/**
	 * @Fields COMPANY_ID_TB:投标企业编号
	 */
	@Length(max = 36, message = "投标企业编号的长度不能超过{1}")
	private String companyIdTb;
	
	/**
	 * @Fields COMPANY_NAME_TB:投标企业名称
	 */
	@Length(max = 512, message = "投标企业名称的长度不能超过{1}")
	private String companyNameTb;
	
	/**
	 * @Fields MIDDLE_PACK:中包装
	 */
	@Digits(integer = 22, fraction = 0, message = "数字的值超出了允许范围(只允许在{0}位整数和{1}位小数范围内)")
	private BigDecimal middlePack;
	
	/**
	 * @Fields MAX_PACK:大包装
	 */
	@Digits(integer = 22, fraction = 0, message = "数字的值超出了允许范围(只允许在{0}位整数和{1}位小数范围内)")
	private BigDecimal maxPack;
	
	/**
	 * @Fields IS_BASE_DRUG:是否基药(0:否,1:是)
	 */
	@Digits(integer = 22, fraction = 0, message = "数字的值超出了允许范围(只允许在{0}位整数和{1}位小数范围内)")
	private BigDecimal isBaseDrug;
	
	/**
	 * @Fields QUALITY_LEVEL:质量层次
	 */
	@Length(max = 50, message = "质量层次的长度不能超过{1}")
	private String qualityLevel;
	
	/**
	 * @Fields PURCHASE_TYPE:采购类别(0:中标药品，1：廉价药品，2：紧张药品，3：低价药品，4：备案药品)
	 */
	@Digits(integer = 22, fraction = 0, message = "数字的值超出了允许范围(只允许在{0}位整数和{1}位小数范围内)")
	private BigDecimal purchaseType;
	
	/**
	 * @Fields SOURCE_ID:来源id
	 */
	@Digits(integer = 22, fraction = 0, message = "数字的值超出了允许范围(只允许在{0}位整数和{1}位小数范围内)")
	private BigDecimal sourceId;
	
	/**
	 * @Fields SOURCE_NAME:来源名称
	 */
	@Length(max = 1024, message = "来源名称的长度不能超过{1}")
	private String sourceName;
	
	/**
	 * @Fields BID_PRICE:中标价格(采购类别为中标类的,写入.其他的写0)
	 */
	@Digits(integer = 18, fraction = 3, message = "数字的值超出了允许范围(只允许在{0}位整数和{1}位小数范围内)")
	private BigDecimal bidPrice;
	
	/**
	 * @Fields USING_RANG:使用范围（0：县上，1：基层，2：全省）
	 */
	@Digits(integer = 22, fraction = 0, message = "数字的值超出了允许范围(只允许在{0}位整数和{1}位小数范围内)")
	private BigDecimal usingRang;
	
	/**
	 * @Fields HOSPITAL_ID:医疗机构编号
	 */
	@Digits(integer = 22, fraction = 0, message = "数字的值超出了允许范围(只允许在{0}位整数和{1}位小数范围内)")
	private BigDecimal hospitalId;
	
	/**
	 * @Fields HOSPITAL_NAME:医疗机构名称
	 */
	@Length(max = 1024, message = "医疗机构名称的长度不能超过{1}")
	private String hospitalName;
	
	/**
	 * @Fields HOSPITAL_DEPARTMENT_ID:医疗机构部门编号
	 */
	@Digits(integer = 22, fraction = 0, message = "数字的值超出了允许范围(只允许在{0}位整数和{1}位小数范围内)")
	private BigDecimal hospitalDepartmentId;
	
	/**
	 * @Fields HOSPITAL_DEPARTMENT_NAME:医疗机构部门名称
	 */
	@Length(max = 1024, message = "医疗机构部门名称的长度不能超过{1}")
	private String hospitalDepartmentName;
	
	/**
	 * @Fields ADMIN_AREA_ID_STATISTICS_DRUG:药品行政区域id统计
	 */
	@Digits(integer = 22, fraction = 0, message = "数字的值超出了允许范围(只允许在{0}位整数和{1}位小数范围内)")
	private BigDecimal adminAreaIdStatisticsDrug;
	
	/**
	 * @Fields ADMIN_AREA_NAME_DRUG:药品行政区域名称
	 */
	@Length(max = 255, message = "药品行政区域名称的长度不能超过{1}")
	private String adminAreaNameDrug;
	
	/**
	 * @Fields ADMIN_AREA_ID_DRUG:药品行政区域id
	 */
	@Digits(integer = 22, fraction = 0, message = "数字的值超出了允许范围(只允许在{0}位整数和{1}位小数范围内)")
	private BigDecimal adminAreaIdDrug;
	
	/**
	 * @Fields BELONG_ORG_NAME:所属行政机构名称
	 */
	@Length(max = 1024, message = "所属行政机构名称的长度不能超过{1}")
	private String belongOrgName;
	
	/**
	 * @Fields ORDER_TYPE:订单类型（0：正常订单，1：急救药品临时订单）
	 */
	@Digits(integer = 22, fraction = 0, message = "数字的值超出了允许范围(只允许在{0}位整数和{1}位小数范围内)")
	private BigDecimal orderType;
	
	/**
	 * @Fields ORDER_NAME:订单名称
	 */
	@Length(max = 1024, message = "订单名称的长度不能超过{1}")
	private String orderName;
	
	/**
	 * @Fields SUBMIT_TIME:提交时间
	 */
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date submitTime;
	
	/**
	 * @Fields FILING_ID:备案编号(单内删除时,还原相应记录为未采购)
	 */
	@Digits(integer = 22, fraction = 0, message = "数字的值超出了允许范围(只允许在{0}位整数和{1}位小数范围内)")
	private BigDecimal filingId;
	
	/**
	 * @Fields COMPANY_ID_PS:配送企业编号
	 */
	@Length(max = 50, message = "配送企业编号的长度不能超过{1}")
	private String companyIdPs;
	
	/**
	 * @Fields COMPANY_NAME_PS:配送企业名称
	 */
	@Length(max = 1024, message = "配送企业名称的长度不能超过{1}")
	private String companyNamePs;
	
	/**
	 * @Fields PURCHASE_PRICE:采购价格
	 */
	@Digits(integer = 18, fraction = 3, message = "数字的值超出了允许范围(只允许在{0}位整数和{1}位小数范围内)")
	private BigDecimal purchasePrice;
	
	/**
	 * @Fields PURCHASE_COUNT:采购数量
	 */
	@Digits(integer = 22, fraction = 0, message = "数字的值超出了允许范围(只允许在{0}位整数和{1}位小数范围内)")
	private BigDecimal purchaseCount;
	
	/**
	 * @Fields PURCHASE_AMOUNT:purchaseAmount
	 */
	@Digits(integer = 18, fraction = 3, message = "数字的值超出了允许范围(只允许在{0}位整数和{1}位小数范围内)")
	private BigDecimal purchaseAmount;
	
	/**
	 * @Fields IS_READ:是否已阅读
	 */
	@Digits(integer = 22, fraction = 0, message = "数字的值超出了允许范围(只允许在{0}位整数和{1}位小数范围内)")
	private BigDecimal isRead;
	
	/**
	 * @Fields READ_USER_ID:readUserId
	 */
	@Length(max = 36, message = "readUserId的长度不能超过{1}")
	private String readUserId;
	
	/**
	 * @Fields READ_USER_NAME:阅读人
	 */
	@Length(max = 255, message = "阅读人的长度不能超过{1}")
	private String readUserName;
	
	/**
	 * @Fields READ_TIME:阅读时间
	 */
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date readTime;
	
	/**
	 * @Fields CONFIRM_USER_ID:确认人Id
	 */
	@Length(max = 36, message = "确认人Id的长度不能超过{1}")
	private String confirmUserId;
	
	/**
	 * @Fields CONFIRM_USER_NAME:确认人
	 */
	@Length(max = 255, message = "确认人的长度不能超过{1}")
	private String confirmUserName;
	
	/**
	 * @Fields CONFIRM_TIME:确认时间
	 */
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date confirmTime;
	
	/**
	 * @Fields CONFIRM_STATE:确认状态 0 - 待处理 1 - 供货 2 - 不供货
	 */
	@Digits(integer = 22, fraction = 0, message = "数字的值超出了允许范围(只允许在{0}位整数和{1}位小数范围内)")
	private BigDecimal confirmState;
	
	/**
	 * @Fields ORDERDETAIL_STATE:采购明细状态（0 已保存待提交 1已提交待确认 2已确认待配送 3 拒绝确认4 已配送待收货5 拒绝配送 6 未及时配送 7 收货中 8 已收货 9 已撤单 ）
	 */
	@Digits(integer = 22, fraction = 0, message = "数字的值超出了允许范围(只允许在{0}位整数和{1}位小数范围内)")
	private BigDecimal orderdetailState;
	
	/**
	 * @Fields REFUSE_REASON:拒绝理由
	 */
	@Length(max = 1024, message = "拒绝理由的长度不能超过{1}")
	private String refuseReason;
	
	/**
	 * @Fields DETAIL_DISTRIBUTE_ADDRESS:订单明细配送地址
	 */
	@Length(max = 1024, message = "订单明细配送地址的长度不能超过{1}")
	private String detailDistributeAddress;
	
	/**
	 * @Fields TOTAL_DISTRIBUTE_COUNT:总配送数量
	 */
	@Digits(integer = 22, fraction = 0, message = "数字的值超出了允许范围(只允许在{0}位整数和{1}位小数范围内)")
	private BigDecimal totalDistributeCount;
	
	/**
	 * @Fields TOTAL_DISTRIBUTE_AMOUNT:总配送金额
	 */
	@Digits(integer = 18, fraction = 3, message = "数字的值超出了允许范围(只允许在{0}位整数和{1}位小数范围内)")
	private BigDecimal totalDistributeAmount;
	
	/**
	 * @Fields TOTAL_WAREHOUSE_COUNT:总收货数量
	 */
	@Digits(integer = 22, fraction = 0, message = "数字的值超出了允许范围(只允许在{0}位整数和{1}位小数范围内)")
	private BigDecimal totalWarehouseCount;
	
	/**
	 * @Fields TOTAL_WAREHOUSE_AMOUNT:总收货金额
	 */
	@Digits(integer = 18, fraction = 3, message = "数字的值超出了允许范围(只允许在{0}位整数和{1}位小数范围内)")
	private BigDecimal totalWarehouseAmount;
	
	/**
	 * @Fields TOTAL_RETURN_AMOUNT:总退货金额
	 */
	@Digits(integer = 18, fraction = 3, message = "数字的值超出了允许范围(只允许在{0}位整数和{1}位小数范围内)")
	private BigDecimal totalReturnAmount;
	
	/**
	 * @Fields TOTAL_RETURN_COUNT:总退货数量
	 */
	@Digits(integer = 22, fraction = 0, message = "数字的值超出了允许范围(只允许在{0}位整数和{1}位小数范围内)")
	private BigDecimal totalReturnCount;
	
	/**
	 * @Fields IS_USING:是否启用
	 */
	@Digits(integer = 22, fraction = 0, message = "数字的值超出了允许范围(只允许在{0}位整数和{1}位小数范围内)")
	private BigDecimal isUsing;
	
	/**
	 * @Fields COMP_RATIO:处理原因
	 */
	@Digits(integer = 18, fraction = 6, message = "数字的值超出了允许范围(只允许在{0}位整数和{1}位小数范围内)")
	private BigDecimal compRatio;
	
	/**
	 * @Fields ORDER_CUSTOM_INFO:订单自定义信息
	 */
	@Length(max = 1024, message = "订单自定义信息的长度不能超过{1}")
	private String orderCustomInfo;
	
	/**
	 * @Fields ADD_USER_ID:记录添加人id
	 */
	@Length(max = 36, message = "记录添加人id的长度不能超过{1}")
	private String addUserId;
	
	/**
	 * @Fields ADD_USER_NAME:记录添加人
	 */
	@Length(max = 256, message = "记录添加人的长度不能超过{1}")
	private String addUserName;
	
	/**
	 * @Fields ADD_TIME:记录添加时间
	 */
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date addTime;
	
	/**
	 * @Fields LAST_UPDATE_USER_ID:最后一次更新记录人id
	 */
	@Length(max = 36, message = "最后一次更新记录人id的长度不能超过{1}")
	private String lastUpdateUserId;
	
	/**
	 * @Fields LAST_UPDATE_USER_NAME:最后一次更新记录人
	 */
	@Length(max = 256, message = "最后一次更新记录人的长度不能超过{1}")
	private String lastUpdateUserName;
	
	/**
	 * @Fields LAST_UPDATE_TIME:最后一次更新记录时间
	 */
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date lastUpdateTime;
	
	/**
	 * @Fields COMPANY_ID_SC:companyIdSc
	 */
	@Length(max = 36, message = "companyIdSc的长度不能超过{1}")
	private String companyIdSc;
	//columns END
	

	public YimiaoOrderdetailRetlogForm(){
	}

	public YimiaoOrderdetailRetlogForm(String orderdetailRetId){
		this.orderdetailRetId = orderdetailRetId;
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
	
	public void setProcurecatalogId(BigDecimal procurecatalogId){
		this.procurecatalogId = procurecatalogId;
	}
	public BigDecimal getProcurecatalogId(){
		return procurecatalogId;
	}
	
	public void setGoodsId(BigDecimal goodsId){
		this.goodsId = goodsId;
	}
	public BigDecimal getGoodsId(){
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
	
	public void setFactor(BigDecimal factor){
		this.factor = factor;
	}
	public BigDecimal getFactor(){
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
	
	public void setMiddlePack(BigDecimal middlePack){
		this.middlePack = middlePack;
	}
	public BigDecimal getMiddlePack(){
		return middlePack;
	}
	
	public void setMaxPack(BigDecimal maxPack){
		this.maxPack = maxPack;
	}
	public BigDecimal getMaxPack(){
		return maxPack;
	}
	
	public void setIsBaseDrug(BigDecimal isBaseDrug){
		this.isBaseDrug = isBaseDrug;
	}
	public BigDecimal getIsBaseDrug(){
		return isBaseDrug;
	}
	
	public void setQualityLevel(String qualityLevel){
		this.qualityLevel = qualityLevel;
	}
	public String getQualityLevel(){
		return qualityLevel;
	}
	
	public void setPurchaseType(BigDecimal purchaseType){
		this.purchaseType = purchaseType;
	}
	public BigDecimal getPurchaseType(){
		return purchaseType;
	}
	
	public void setSourceId(BigDecimal sourceId){
		this.sourceId = sourceId;
	}
	public BigDecimal getSourceId(){
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
	
	public void setUsingRang(BigDecimal usingRang){
		this.usingRang = usingRang;
	}
	public BigDecimal getUsingRang(){
		return usingRang;
	}
	
	public void setHospitalId(BigDecimal hospitalId){
		this.hospitalId = hospitalId;
	}
	public BigDecimal getHospitalId(){
		return hospitalId;
	}
	
	public void setHospitalName(String hospitalName){
		this.hospitalName = hospitalName;
	}
	public String getHospitalName(){
		return hospitalName;
	}
	
	public void setHospitalDepartmentId(BigDecimal hospitalDepartmentId){
		this.hospitalDepartmentId = hospitalDepartmentId;
	}
	public BigDecimal getHospitalDepartmentId(){
		return hospitalDepartmentId;
	}
	
	public void setHospitalDepartmentName(String hospitalDepartmentName){
		this.hospitalDepartmentName = hospitalDepartmentName;
	}
	public String getHospitalDepartmentName(){
		return hospitalDepartmentName;
	}
	
	public void setAdminAreaIdStatisticsDrug(BigDecimal adminAreaIdStatisticsDrug){
		this.adminAreaIdStatisticsDrug = adminAreaIdStatisticsDrug;
	}
	public BigDecimal getAdminAreaIdStatisticsDrug(){
		return adminAreaIdStatisticsDrug;
	}
	
	public void setAdminAreaNameDrug(String adminAreaNameDrug){
		this.adminAreaNameDrug = adminAreaNameDrug;
	}
	public String getAdminAreaNameDrug(){
		return adminAreaNameDrug;
	}
	
	public void setAdminAreaIdDrug(BigDecimal adminAreaIdDrug){
		this.adminAreaIdDrug = adminAreaIdDrug;
	}
	public BigDecimal getAdminAreaIdDrug(){
		return adminAreaIdDrug;
	}
	
	public void setBelongOrgName(String belongOrgName){
		this.belongOrgName = belongOrgName;
	}
	public String getBelongOrgName(){
		return belongOrgName;
	}
	
	public void setOrderType(BigDecimal orderType){
		this.orderType = orderType;
	}
	public BigDecimal getOrderType(){
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
	
	public void setFilingId(BigDecimal filingId){
		this.filingId = filingId;
	}
	public BigDecimal getFilingId(){
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
	
	public void setPurchaseCount(BigDecimal purchaseCount){
		this.purchaseCount = purchaseCount;
	}
	public BigDecimal getPurchaseCount(){
		return purchaseCount;
	}
	
	public void setPurchaseAmount(BigDecimal purchaseAmount){
		this.purchaseAmount = purchaseAmount;
	}
	public BigDecimal getPurchaseAmount(){
		return purchaseAmount;
	}
	
	public void setIsRead(BigDecimal isRead){
		this.isRead = isRead;
	}
	public BigDecimal getIsRead(){
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
	
	public void setConfirmState(BigDecimal confirmState){
		this.confirmState = confirmState;
	}
	public BigDecimal getConfirmState(){
		return confirmState;
	}
	
	public void setOrderdetailState(BigDecimal orderdetailState){
		this.orderdetailState = orderdetailState;
	}
	public BigDecimal getOrderdetailState(){
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
	
	public void setTotalDistributeCount(BigDecimal totalDistributeCount){
		this.totalDistributeCount = totalDistributeCount;
	}
	public BigDecimal getTotalDistributeCount(){
		return totalDistributeCount;
	}
	
	public void setTotalDistributeAmount(BigDecimal totalDistributeAmount){
		this.totalDistributeAmount = totalDistributeAmount;
	}
	public BigDecimal getTotalDistributeAmount(){
		return totalDistributeAmount;
	}
	
	public void setTotalWarehouseCount(BigDecimal totalWarehouseCount){
		this.totalWarehouseCount = totalWarehouseCount;
	}
	public BigDecimal getTotalWarehouseCount(){
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
	
	public void setTotalReturnCount(BigDecimal totalReturnCount){
		this.totalReturnCount = totalReturnCount;
	}
	public BigDecimal getTotalReturnCount(){
		return totalReturnCount;
	}
	
	public void setIsUsing(BigDecimal isUsing){
		this.isUsing = isUsing;
	}
	public BigDecimal getIsUsing(){
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
	
	public void setCompanyIdSc(String companyIdSc){
		this.companyIdSc = companyIdSc;
	}
	public String getCompanyIdSc(){
		return companyIdSc;
	}

}