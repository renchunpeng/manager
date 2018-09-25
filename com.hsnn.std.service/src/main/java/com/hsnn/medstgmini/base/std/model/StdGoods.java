package com.hsnn.medstgmini.base.std.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import com.hsnn.medstgmini.util.compile.KeywordsAnnotation;
import com.hsnn.medstgmini.util.compile.PropertyNameAnnotation;



/**
 *
 * @Since 2010-2016
 * @Description: TODO
 * @author zhou.xy
 * @date 2016-02-26 09:04:13
 *
 */
public class StdGoods  implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -8128269288778308833L;

	private boolean isOutdate;// 过期标识
	/**
	 * @Fields productName:productName
	 */
	private String productName;
	private String ngoodsId;

	public String getFactor() {
		return factor;
	}

	public void setFactor(String factor) {
		this.factor = factor;
	}

	private String factor;
	public String getNgoodsId() {
		return ngoodsId;
	}

	public void setNgoodsId(String ngoodsId) {
		this.ngoodsId = ngoodsId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getOutlook() {
		return outlook;
	}

	public void setOutlook(String outlook) {
		this.outlook = outlook;
	}

	public String getMedicinemodel() {
		return medicinemodel;
	}

	public void setMedicinemodel(String medicinemodel) {
		this.medicinemodel = medicinemodel;
	}

	/**
	 * @Fields outlook:outlook
	 */
	private String outlook;

	/**
	 * @Fields medicinemodel:medicinemodel
	 */
	private String medicinemodel;




	public boolean isOutdate() {
		return isOutdate;
	}

	public void setOutdate(boolean isOutdate) {
		this.isOutdate = isOutdate;
	}

	//alias
	public static final String TABLE_ALIAS = "StdGoods";

	public String getGgypId() {
		return ggypId;
	}

	public void setGgypId(String ggypId) {
		this.ggypId = ggypId;
	}

	private  String ggypId;
	//columns START
	/**
	 * @Fields goodsId:产品ID
	 */
	private Integer goodsId;
	
	/**
	 * @Fields productId:药品ID
	 */
	@PropertyNameAnnotation(annotation="药品编号")
	private Integer productId;
	
	/**
	 * @Fields goodsName:商品名
	 */
	@PropertyNameAnnotation(annotation="商品名")
	@KeywordsAnnotation(annotation="商品名")
	private String goodsName;
	
	/**
	 * @Fields materialName:包装材质
	 */
	@PropertyNameAnnotation(annotation="包装材质")
	private String materialName;
	
	/**
	 * @Fields materialRemark:材质备注
	 */
	private String materialRemark;
	
	/**
	 * @Fields unit:单位
	 */
	@PropertyNameAnnotation(annotation="单位")
	private String unit;
	
	/**
	 * @Fields minUnit:最小制剂单位
	 */
	@PropertyNameAnnotation(annotation="最小制剂单位")
	private String minUnit;
	
	/**
	 * @Fields approvalCode:批准文号
	 */
	@PropertyNameAnnotation(annotation="批准文号")
	private String approvalCode;
	
	/**
	 * @Fields approvalCodeBegintime:批准文号批准日期
	 */
	@PropertyNameAnnotation(annotation="批准文号批准日期")
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date approvalCodeBegintime;
	
	/**
	 * @Fields approvalCodeEndtime:批准文号截止日期
	 */
	@PropertyNameAnnotation(annotation="批准文号截止日期")
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date approvalCodeEndtime;
	
	/**
	 * @Fields regcode:注册证号
	 */
	@PropertyNameAnnotation(annotation="注册证号")
	private String regcode;
		
	/**
	 * @Fields regcodeBeginTime:注册证发证日期
	 */
	@PropertyNameAnnotation(annotation="注册证发证日期")
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date regcodeBeginTime;
	
	/**
	 * @Fields regcodeEndTime:注册证截止日期
	 */
	@PropertyNameAnnotation(annotation="注册证截止日期")
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date regcodeEndTime;
	
	/**
	 * @Fields surveyReportYear:药检报告年度
	 */
	@PropertyNameAnnotation(annotation="药检报告年度")
	private String surveyReportYear;
	
	/**
	 * @Fields drugStandardCode:药品本位码
	 */
	@PropertyNameAnnotation(annotation="药品本位码")
	private String drugStandardCode;
	
	/**
	 * @Fields executeStandardType:执行标准类型
	 */
	@PropertyNameAnnotation(annotation="执行标准类型")
	private Integer executeStandardType;
	
	/**
	 * @Fields executeStandardCode:执行标准编号
	 */
	@PropertyNameAnnotation(annotation="执行标准编号")
	private String executeStandardCode;
	
	/**
	 * @Fields trialStandardEndtime:试行标准截止日期
	 */
	@PropertyNameAnnotation(annotation="试行标准截止日期")
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date trialStandardEndtime;
	
	/**
	 * @Fields issubmitPositiveCertificate:是否递交试行标准转正受理证明
	 */
	@PropertyNameAnnotation(annotation="是否递交试行标准转正受理证明")
	private Integer issubmitPositiveCertificate;
	
	/**
	 * @Fields chineseMedicineLevelday:中成药日服用量
	 */
	@PropertyNameAnnotation(annotation="中成药日服用量")
	private String chineseMedicineLevelday;
	
	/**
	 * @Fields isHasSodium:是否含玻璃酸钠(0:否,1:是)
	 */
	@PropertyNameAnnotation(annotation="是否含玻璃酸钠")
	private Integer isHasSodium;
	
	/**
	 * @Fields electronicPack:电子监管包装或标签
	 */
	@PropertyNameAnnotation(annotation="电子监管包装或标签")
	private Integer electronicPack;
	
	/**
	 * @Fields maximumRetailPrice:最高零售价(如现无最高零售价，请暂填'0' )
	 */
	@PropertyNameAnnotation(annotation="最高零售价")
	private BigDecimal maximumRetailPrice;
	
	/**
	 * @Fields priceBasis:价格依据
	 */
	@PropertyNameAnnotation(annotation="价格依据")
	private String priceBasis;
	
	/**
	 * @Fields middlePack:中包装
	 */
	@PropertyNameAnnotation(annotation="中包装")
	private Integer middlePack;
	
	/**
	 * @Fields maxPack:大包装
	 */
	@PropertyNameAnnotation(annotation="大包装")
	private Integer maxPack;
	
	/**
	 * @Fields companyIdSc:生产企业编号
	 */
	private String companyIdSc;
	
	/**
	 * @Fields companyNameSc:生产企业名称
	 */
	@PropertyNameAnnotation(annotation="生产企业名称")
	private String companyNameSc;
	
	/**
	 * @Fields archiveNumber:归档号
	 */
	@PropertyNameAnnotation(annotation="产品归档号")
	private String archiveNumber;
	
	/**
	 * @Fields isSplitCompany:是否进口分包装(0:否,1:是)
	 */
	@PropertyNameAnnotation(annotation="是否进口分包装")
	private Integer isSplitCompany;
	
	/**
	 * @Fields splitCompanyId:分包装企业编号
	 */
	@PropertyNameAnnotation(annotation="分包装企业编号")
	private String splitCompanyId;
	
	/**
	 * @Fields splitCompanyName:分包装企业名称
	 */
	@PropertyNameAnnotation(annotation="分包装企业名称")
	private String splitCompanyName;
	
	/**
	 * @Fields isImportCompany:是否具有代理商（境外产品）(0:否,1:是)
	 */
	@PropertyNameAnnotation(annotation="是否具有代理商（境外产品）")
	private Integer isImportCompany;
	
	/**
	 * @Fields importCompanyid:代理商编号
	 */
	@PropertyNameAnnotation(annotation="代理商编号")
	private String importCompanyid;
	
	/**
	 * @Fields importCompanyName:代理商名称
	 */
	@PropertyNameAnnotation(annotation="投标企业")
	private String importCompanyName;
	
	/**
	 * @Fields importEndDate:代理有效截至日期
	 */
	@PropertyNameAnnotation(annotation="代理有效截至日期")
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date importEndDate;
	
	/**
	 * @Fields isTrustCompany:是否委托加工(0:否,1:是)
	 */
	@PropertyNameAnnotation(annotation="是否委托加工")
	private Integer isTrustCompany;
	
	/**
	 * @Fields trustCompanyId:受托加工企业编号
	 */
	@PropertyNameAnnotation(annotation="受托加工企业编号")
	private String trustCompanyId;
	
	/**
	 * @Fields trustCompanyName:受托加工企业名称
	 */
	@PropertyNameAnnotation(annotation="受托加工企业名称")
	private String trustCompanyName;
	
	/**
	 * @Fields trustEndDate:受托加工截至日期
	 */
	@PropertyNameAnnotation(annotation="受托加工截至日期")
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date trustEndDate;
	
	/**
	 * @Fields qualificationStatus:资质状态(0:合格,1:不合格)
	 */
	@PropertyNameAnnotation(annotation="资质状态(0:合格,1:不合格)")
	private Integer qualificationStatus;
	
	/**
	 * @Fields qualificationNopassReason:资质不合格原因
	 */
	@PropertyNameAnnotation(annotation="资质不合格原因")
	private String qualificationNopassReason;
	
	/**
	 * @Fields inputRemarks:录入备注
	 */
	private String inputRemarks;
	
	/**
	 * @Fields initializationState:初始化状态(0：待提交，1：待复核，2：复核通过，3，复核不通过，4：审核通过，5，审核不通过)
	 */
	private Integer initializationState;
	
	/**
	 * @Fields gmpCode:GMP证书号
	 */
	private String gmpCode;
	
	/**
	 * @Fields gmpName:GMP证书号
	 */
	private String gmpName;
	
	/**
	 * @Fields clearStatus:澄清状态(0：不可澄清，1：可澄清，2：已提交，3：澄清审核通过，4：澄清审核不通过)
	 */
	private Integer clearStatus;
	
	/**
	 * @Fields isUsing:是否启用
	 */
	private Integer isUsing;
	
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
	
	/**
	 * @Fields maintenanceState:维护状态(0:未维护,1:已维护)
	 */
	private Integer maintenanceState;

	/**
	 * @Fields reaudit_user_id:复核人id
	 */
	@Length(max = 36, message = "复核人id的长度不能超过{1}")
	private String reauditUserId;
	
	/**
	 * @Fields reaudit_user_name:复核人名称
	 */
	@Length(max = 256, message = "复核人名称的长度不能超过{1}")
	private String reauditUserName;
	
	/**
	 * @Fields reaudit_add_time:复核时间
	 */
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date reauditAddTime;
	
	/**
	 * @Fields reaudit_remark:复核备注
	 */
	@Length(max = 1000, message = "复核备注的长度不能超过{1}")
	private String reauditRemark;
	
	/**
	 * @Fields audit_user_id:审核人id
	 */
	@Length(max = 36, message = "审核人id的长度不能超过{1}")
	private String auditUserId;
	
	/**
	 * @Fields audit_user_name:审核人名称
	 */
	@Length(max = 256, message = "审核人名称的长度不能超过{1}")
	private String auditUserName;
	
	/**
	 * @Fields audit_add_time:审核时间
	 */
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date auditAddTime;
	
	/**
	 * @Fields audit_remark:审核备注
	 */
	@Length(max = 1000, message = "审核备注的长度不能超过{1}")
	private String auditRemark;
	
	
	private String companyNameTb;
	
	//新增字段：主成分，药品分类，药品类别
	@PropertyNameAnnotation(annotation="主成分")
	private String component;	
	
	@PropertyNameAnnotation(annotation="药品分类")
	private String drugClassification;
	
	@PropertyNameAnnotation(annotation="药品类别")
	private String drugCategory;
		
	private Integer isBaseDrug;

	private String priceUnit;

	public String getPriceUnit() {
		return priceUnit;
	}

	public void setPriceUnit(String priceUnit) {
		this.priceUnit = priceUnit;
	}
	//columns END

	public Integer getIsBaseDrug() {
		return isBaseDrug;
	}

	public void setIsBaseDrug(Integer isBaseDrug) {
		this.isBaseDrug = isBaseDrug;
	}

	public String getComponent() {
		return component;
	}

	public void setComponent(String component) {
		this.component = component;
	}

	public String getDrugClassification() {
		return drugClassification;
	}

	public void setDrugClassification(String drugClassification) {
		this.drugClassification = drugClassification;
	}

	public String getDrugCategory() {
		return drugCategory;
	}

	public void setDrugCategory(String drugCategory) {
		this.drugCategory = drugCategory;
	}

	public StdGoods(){
	}

	public StdGoods(Integer goodsId){
		this.goodsId = goodsId;
	}

	
	public void setGoodsId(Integer goodsId){
		this.goodsId = goodsId;
	}
	
	public Integer getGoodsId(){
		return goodsId;
	}
	
	public void setProductId(Integer productId){
		this.productId = productId;
	}
	
	public Integer getProductId(){
		return productId;
	}
	
	public void setGoodsName(String goodsName){
		this.goodsName = goodsName;
	}
	
	public String getGoodsName(){
		return goodsName;
	}
	
	public void setMaterialName(String materialName){
		this.materialName = materialName;
	}
	
	public String getMaterialName(){
		return materialName;
	}
	
	public void setMaterialRemark(String materialRemark){
		this.materialRemark = materialRemark;
	}
	
	public String getMaterialRemark(){
		return materialRemark;
	}
	
	public void setUnit(String unit){
		this.unit = unit;
	}
	
	public String getUnit(){
		return unit;
	}
	
	public void setMinUnit(String minUnit){
		this.minUnit = minUnit;
	}
	
	public String getMinUnit(){
		return minUnit;
	}
	
	public void setApprovalCode(String approvalCode){
		this.approvalCode = approvalCode;
	}
	
	public String getApprovalCode(){
		return approvalCode;
	}
	
	public void setApprovalCodeBegintime(Date approvalCodeBegintime){
		this.approvalCodeBegintime = approvalCodeBegintime;
	}
	
	public Date getApprovalCodeBegintime(){
		return approvalCodeBegintime;
	}
	
	public void setApprovalCodeEndtime(Date approvalCodeEndtime){
		this.approvalCodeEndtime = approvalCodeEndtime;
	}
	
	public Date getApprovalCodeEndtime(){
		return approvalCodeEndtime;
	}
	
	public void setRegcode(String regcode){
		this.regcode = regcode;
	}
	
	public String getRegcode(){
		return regcode;
	}
	
	public void setRegcodeBeginTime(Date regcodeBeginTime){
		this.regcodeBeginTime = regcodeBeginTime;
	}
	
	public Date getRegcodeBeginTime(){
		return regcodeBeginTime;
	}
	
	public void setRegcodeEndTime(Date regcodeEndTime){
		this.regcodeEndTime = regcodeEndTime;
	}
	
	public Date getRegcodeEndTime(){
		return regcodeEndTime;
	}
	
	public void setSurveyReportYear(String surveyReportYear){
		this.surveyReportYear = surveyReportYear;
	}
	
	public String getSurveyReportYear(){
		return surveyReportYear;
	}
	
	public void setDrugStandardCode(String drugStandardCode){
		this.drugStandardCode = drugStandardCode;
	}
	
	public String getDrugStandardCode(){
		return drugStandardCode;
	}
	
	public void setExecuteStandardType(Integer executeStandardType){
		this.executeStandardType = executeStandardType;
	}
	
	public Integer getExecuteStandardType(){
		return executeStandardType;
	}
	
	public void setExecuteStandardCode(String executeStandardCode){
		this.executeStandardCode = executeStandardCode;
	}
	
	public String getExecuteStandardCode(){
		return executeStandardCode;
	}
	
	public void setTrialStandardEndtime(Date trialStandardEndtime){
		this.trialStandardEndtime = trialStandardEndtime;
	}
	
	public Date getTrialStandardEndtime(){
		return trialStandardEndtime;
	}
	
	public void setIssubmitPositiveCertificate(Integer issubmitPositiveCertificate){
		this.issubmitPositiveCertificate = issubmitPositiveCertificate;
	}
	
	public Integer getIssubmitPositiveCertificate(){
		return issubmitPositiveCertificate;
	}
	
	public void setChineseMedicineLevelday(String chineseMedicineLevelday){
		this.chineseMedicineLevelday = chineseMedicineLevelday;
	}
	
	public String getChineseMedicineLevelday(){
		return chineseMedicineLevelday;
	}
	
	public void setIsHasSodium(Integer isHasSodium){
		this.isHasSodium = isHasSodium;
	}
	
	public Integer getIsHasSodium(){
		return isHasSodium;
	}
	
	public void setElectronicPack(Integer electronicPack){
		this.electronicPack = electronicPack;
	}
	
	public Integer getElectronicPack(){
		return electronicPack;
	}
	
	public void setMaximumRetailPrice(BigDecimal maximumRetailPrice){
		this.maximumRetailPrice = maximumRetailPrice;
	}
	
	public BigDecimal getMaximumRetailPrice(){
		return maximumRetailPrice;
	}
	
	public void setPriceBasis(String priceBasis){
		this.priceBasis = priceBasis;
	}
	
	public String getPriceBasis(){
		return priceBasis;
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
	
	public void setArchiveNumber(String archiveNumber){
		this.archiveNumber = archiveNumber;
	}
	
	public String getArchiveNumber(){
		return archiveNumber;
	}
	
	public void setIsSplitCompany(Integer isSplitCompany){
		this.isSplitCompany = isSplitCompany;
	}
	
	public Integer getIsSplitCompany(){
		return isSplitCompany;
	}
	
	public void setSplitCompanyId(String splitCompanyId){
		this.splitCompanyId = splitCompanyId;
	}
	
	public String getSplitCompanyId(){
		return splitCompanyId;
	}
	
	public void setSplitCompanyName(String splitCompanyName){
		this.splitCompanyName = splitCompanyName;
	}
	
	public String getSplitCompanyName(){
		return splitCompanyName;
	}
	
	public void setIsImportCompany(Integer isImportCompany){
		this.isImportCompany = isImportCompany;
	}
	
	public Integer getIsImportCompany(){
		return isImportCompany;
	}
	
	public void setImportCompanyid(String importCompanyid){
		this.importCompanyid = importCompanyid;
	}
	
	public String getImportCompanyid(){
		return importCompanyid;
	}
	
	public void setImportCompanyName(String importCompanyName){
		this.importCompanyName = importCompanyName;
	}
	
	public String getImportCompanyName(){
		return importCompanyName;
	}
	
	public void setImportEndDate(Date importEndDate){
		this.importEndDate = importEndDate;
	}
	
	public Date getImportEndDate(){
		return importEndDate;
	}
	
	public void setIsTrustCompany(Integer isTrustCompany){
		this.isTrustCompany = isTrustCompany;
	}
	
	public Integer getIsTrustCompany(){
		return isTrustCompany;
	}
	
	public void setTrustCompanyId(String trustCompanyId){
		this.trustCompanyId = trustCompanyId;
	}
	
	public String getTrustCompanyId(){
		return trustCompanyId;
	}
	
	public void setTrustCompanyName(String trustCompanyName){
		this.trustCompanyName = trustCompanyName;
	}
	
	public String getTrustCompanyName(){
		return trustCompanyName;
	}
	
	public void setTrustEndDate(Date trustEndDate){
		this.trustEndDate = trustEndDate;
	}
	
	public Date getTrustEndDate(){
		return trustEndDate;
	}
	
	public void setQualificationStatus(Integer qualificationStatus){
		this.qualificationStatus = qualificationStatus;
	}
	
	public Integer getQualificationStatus(){
		return qualificationStatus;
	}
	
	public void setQualificationNopassReason(String qualificationNopassReason){
		this.qualificationNopassReason = qualificationNopassReason;
	}
	
	public String getQualificationNopassReason(){
		return qualificationNopassReason;
	}
	
	public void setInputRemarks(String inputRemarks){
		this.inputRemarks = inputRemarks;
	}
	
	public String getInputRemarks(){
		return inputRemarks;
	}
	
	public void setInitializationState(Integer initializationState){
		this.initializationState = initializationState;
	}
	
	public Integer getInitializationState(){
		return initializationState;
	}
	
	public void setClearStatus(Integer clearStatus){
		this.clearStatus = clearStatus;
	}
	
	public Integer getClearStatus(){
		return clearStatus;
	}
	
	public void setIsUsing(Integer isUsing){
		this.isUsing = isUsing;
	}
	
	public Integer getIsUsing(){
		return isUsing;
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

	public String getGmpCode() {
		return gmpCode;
	}

	public void setGmpCode(String gmpCode) {
		this.gmpCode = gmpCode;
	}

	public Integer getMaintenanceState() {
		return maintenanceState;
	}

	public void setMaintenanceState(Integer maintenanceState) {
		this.maintenanceState = maintenanceState;
	}

	public String getAuditRemark() {
		return auditRemark;
	}

	public void setAuditRemark(String auditRemark) {
		this.auditRemark = auditRemark;
	}

	public String getReauditUserId() {
		return reauditUserId;
	}

	public void setReauditUserId(String reauditUserId) {
		this.reauditUserId = reauditUserId;
	}

	public String getReauditUserName() {
		return reauditUserName;
	}

	public void setReauditUserName(String reauditUserName) {
		this.reauditUserName = reauditUserName;
	}

	public Date getReauditAddTime() {
		return reauditAddTime;
	}

	public void setReauditAddTime(Date reauditAddTime) {
		this.reauditAddTime = reauditAddTime;
	}

	public String getReauditRemark() {
		return reauditRemark;
	}

	public void setReauditRemark(String reauditRemark) {
		this.reauditRemark = reauditRemark;
	}

	public String getAuditUserId() {
		return auditUserId;
	}

	public void setAuditUserId(String auditUserId) {
		this.auditUserId = auditUserId;
	}

	public String getAuditUserName() {
		return auditUserName;
	}

	public void setAuditUserName(String auditUserName) {
		this.auditUserName = auditUserName;
	}

	public Date getAuditAddTime() {
		return auditAddTime;
	}

	public void setAuditAddTime(Date auditAddTime) {
		this.auditAddTime = auditAddTime;
	}

	public String getGmpName() {
		return gmpName;
	}

	public void setGmpName(String gmpName) {
		this.gmpName = gmpName;
	}

	public String getCompanyNameTb() {
		return companyNameTb;
	}

	public void setCompanyNameTb(String companyNameTb) {
		this.companyNameTb = companyNameTb;
	}



}