package com.hsnn.medstgmini.base.std.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.hsnn.medstgmini.util.ParseDate;
import com.hsnn.medstgmini.util.compile.KeywordsAnnotation;
import com.hsnn.medstgmini.util.compile.PropertyNameAnnotation;



/**
 *
 * @Since 2010-2016
 * @Description: TODO
 * @author zhou.xy
 * @date 2016-02-25 08:45:16
 *
 */
public class StdCompanys implements Serializable  {
	
	private static final long serialVersionUID = 1L;

	//alias
	public static final String TABLE_ALIAS = "StdCompany";
	
	//columns START
	/**
	 * @Fields companyId:企业id
	 */
	private String companyId;
	
	/**
	 * @Fields companyAccountCode:企业账号
	 */
	private String companyAccountCode;
	
	/**
	 * @Fields companyName:企业名称
	 */
	@PropertyNameAnnotation(annotation="企业名称")
	@KeywordsAnnotation(annotation="企业名称")
	private String companyName;
	
	/**
	 * @Fields compSpelCode:企业名称拼音码
	 */
	private String compSpelCode;
	
	/**
	 * @Fields companySimpleName:企业简称
	 */
	@PropertyNameAnnotation(annotation="企业简称")
	private String companySimpleName;
	
	/**
	 * @Fields companySimpleNameSpell:企业简称拼音
	 */
	private String companySimpleNameSpell;
	
	/**
	 * @Fields lastYearIncome:上年销售额(元)
	 */
	@PropertyNameAnnotation(annotation="上年销售额(元)")
	private BigDecimal lastYearIncome;
	
	/**
	 * @Fields companyContactTel:企业联系电话
	 */
	@PropertyNameAnnotation(annotation="企业联系电话")
	private String companyContactTel;
	
	/**
	 * @Fields companyContactFax:企业传真号码
	 */
	@PropertyNameAnnotation(annotation="企业传真号码")
	private String companyContactFax;
	
	/**
	 * @Fields zipCode:邮编
	 */
	@PropertyNameAnnotation(annotation="邮编")
	private Integer zipCode;
	
	/**
	 * @Fields email:联系邮箱（必填，用于找回密码）
	 */
	@PropertyNameAnnotation(annotation="联系邮箱")
	private String email;
	
	/**
	 * @Fields filingNumber:归档号
	 */
	@PropertyNameAnnotation(annotation="归档号")
	private String filingNumber;
	
	/**
	 * @Fields companyTypeSystem:企业类型(1:药品,2,耗材,3,药品和耗材)
	 */
	private Integer companyTypeSystem;
	
	/**
	 * @Fields companyType:企业类型(0:生产,1:代理,2:配送,3:生产配送企业)
	 */
	private Integer companyType;
	
	/**
	 * @Fields onceCompanyName:企业曾用名
	 */
	@PropertyNameAnnotation(annotation="企业曾用名")
	private String onceCompanyName;
	
	/**
	 * @Fields areaName:地区名称
	 */
	private String areaName;
	
	/**
	 * @Fields areaId:地区id
	 */
	private Integer areaId;
	
	/**
	 * @Fields address:地址
	 */
	@PropertyNameAnnotation(annotation="地址")
	private String address;
	
	/**
	 * @Fields registeredCapital:注册资本
	 */
	@PropertyNameAnnotation(annotation="注册资本")
	private Long registeredCapital;
	
	/**
	 * @Fields legalName:法人代表人姓名
	 */
	@PropertyNameAnnotation(annotation="法人代表人姓名")
	private String legalName;
	
	/**
	 * @Fields legalNumber:法人代表人证件号码
	 */
	@PropertyNameAnnotation(annotation="法人代表人证件号码")
	private String legalNumber;
	
	/**
	 * @Fields legalScanAttachId:法人代表人证件扫描件id
	 */
	private String legalScanAttachId;
	
	/**
	 * @Fields legalCellphone:法人代表人手机
	 */
	@PropertyNameAnnotation(annotation="法人代表人手机")
	private String legalCellphone;
	
	/**
	 * @Fields legalPhone:法人代表人电话
	 */
	@PropertyNameAnnotation(annotation="法人代表人电话")
	private String legalPhone;
	
	/**
	 * @Fields companyRegistType:机构登记注册类型
	 */
	@PropertyNameAnnotation(annotation="机构登记注册类型")
	private String companyRegistType;
	
	/**
	 * @Fields isGroupCompany:是否集团企业
	 */
	@PropertyNameAnnotation(annotation="是否集团企业")
	private Integer isGroupCompany;
	
	/**
	 * @Fields groupCompanyName:集团企业名称
	 */
	@PropertyNameAnnotation(annotation="集团企业名称")
	private String groupCompanyName;
	
	/**
	 * @Fields isLawerCompany:是否法人企业(0:否,1:是)
	 */
	@PropertyNameAnnotation(annotation="是否法人企业")
	private Integer isLawerCompany;
	
	/**
	 * @Fields lawerCompoanyName:法人企业名称
	 */
	@PropertyNameAnnotation(annotation="法人企业名称")
	private String lawerCompoanyName;
	
	/**
	 * @Fields organizationCode:组织机构代码
	 */
	@PropertyNameAnnotation(annotation="组织机构代码")
	private String organizationCode;
	
	/**
	 * @Fields taxRegistrationNumber:税务登记证号
	 */
	@PropertyNameAnnotation(annotation="税务登记证号")
	private String taxRegistrationNumber;
	
	/**
	 * @Fields businessLicense:营业执照注册号
	 */
	@PropertyNameAnnotation(annotation="营业执照注册号")
	private String businessLicense;
	
	/**
	 * @Fields businessLicenseBeginDate:营业执照发证日期
	 */
	@PropertyNameAnnotation(annotation="营业执照发证日期")
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date businessLicenseBeginDate;
	
	/**
	 * @Fields businessLicenseEndDate:营业执照截止日期
	 */
	@PropertyNameAnnotation(annotation="营业执照截止日期")
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date businessLicenseEndDate;
	
	/**
	 * @Fields annualInspection:年检年度
	 */
	@PropertyNameAnnotation(annotation="年检年度")
	private String annualInspection;
	
	/**
	 * @Fields authorizedPerson:被授权人
	 */
	@PropertyNameAnnotation(annotation="被授权人")
	private String authorizedPerson;
	
	/**
	 * @Fields authorizedPersonFax:被授权人传真*
	 */
	@PropertyNameAnnotation(annotation="被授权人传真")
	private String authorizedPersonFax;
	
	/**
	 * @Fields authorizedPersonIdcard:被授权人身份证号*
	 */
	@PropertyNameAnnotation(annotation="被授权人身份证号")
	private String authorizedPersonIdcard;
	
	/**
	 * @Fields authorizedPersonTel:被授权人联系电话
	 */
	@PropertyNameAnnotation(annotation="被授权人联系电话")
	private String authorizedPersonTel;
	
	/**
	 * @Fields productionPermissionCode:生产许可证号
	 */
	@PropertyNameAnnotation(annotation="生产许可证号")
	private String productionPermissionCode;
	
	/**
	 * @Fields productionPermissionRegistAddress:生产许可证注册地址
	 */
	@PropertyNameAnnotation(annotation="生产许可证注册地址")
	private String productionPermissionRegistAddress;
	
	/**
	 * @Fields productionPermissionLawer:生产许可证法人
	 */
	@PropertyNameAnnotation(annotation="生产许可证法人")
	private String productionPermissionLawer;
	
	/**
	 * @Fields productionPermissionEndDate:生产许可证截止日期
	 */
	@PropertyNameAnnotation(annotation="生产许可证截止日期")
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date productionPermissionEndDate;
	
	/**
	 * @Fields productionPermissionProductAddress:生产许可证生产地址
	 */
	@PropertyNameAnnotation(annotation="生产许可证生产地址")
	private String productionPermissionProductAddress;
	
	/**
	 * @Fields productionPermissionProductRange:生产许可证生产范围
	 */
	@PropertyNameAnnotation(annotation="生产许可证生产范围")
	private String productionPermissionProductRange;
	
	/**
	 * @Fields productionPermissionClassificationCodes:生产许可证分类码
	 */
	@PropertyNameAnnotation(annotation="生产许可证分类码")
	private String productionPermissionClassificationCodes;
	
	/**
	 * @Fields gmpCode:gmp证书号
	 */
	private String gmpCode;
	
	/**
	 * @Fields businessPermissionCode:经营许可证号
	 */
	@PropertyNameAnnotation(annotation="经营许可证号")
	private String businessPermissionCode;
	
	/**
	 * @Fields businessPermissionRegistAddress:经营许可证注册地址
	 */
	@PropertyNameAnnotation(annotation="经营许可证注册地址")
	private String businessPermissionRegistAddress;
	
	/**
	 * @Fields businessPermissionLawer:经营许可证法人
	 */
	@PropertyNameAnnotation(annotation="经营许可证法人")
	private String businessPermissionLawer;
	
	/**
	 * @Fields businessPermissionEndDate:经营许可证截止日期
	 */
	@PropertyNameAnnotation(annotation="经营许可证截止日期")
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date businessPermissionEndDate;
	
	/**
	 * @Fields businessPermissionWarehouseAddress:经营许可证仓库地址
	 */
	@PropertyNameAnnotation(annotation="经营许可证仓库地址")
	private String businessPermissionWarehouseAddress;
	
	/**
	 * @Fields businessPermissionRange:经营许可证经营范围
	 */
	@PropertyNameAnnotation(annotation="经营许可证经营范围")
	private String businessPermissionRange;
	
	/**
	 * @Fields gspCode:gsp证书号
	 */
	private String gspCode;
	
	/**
	 * @Fields isUsing:是否启用
	 */
	private Integer isUsing;
	
	/**
	 * @Fields maintenance_state:维护状态(0:未维护,1:已维护)
	 */
	private Integer maintenanceState;
	
	/**
	 * @Fields qualificationStatus:资质状态(0:不合格,1:合格)
	 */
	private Integer qualificationStatus;
	
	/**
	 * @Fields qualificationStatusNopassReason:资质不合格原因
	 */
	private String qualificationStatusNopassReason;
	
	/**
	 * @Fields inputRemarks:录入备注
	 */
	private String inputRemarks;
	
	/**
	 * @Fields initializationState:初始化状态(0：待提交，1：待复核，2：复核通过，3，复核不通过，4：审核通过，5，审核不通过)
	 */
	private Integer initializationState;
	
	/**
	 * @Fields clearStatus:澄清状态(0：不可澄清，1：可澄清，2：已提交，3：澄清审核通过，4：澄清审核不通过)
	 */
	private Integer clearStatus;
	
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
	 * @Fields reauditUserId:复核人id
	 */
	private String reauditUserId;
	
	/**
	 * @Fields reauditUserName:复核人名称
	 */
	private String reauditUserName;
	
	/**
	 * @Fields reauditAddTime:复核时间
	 */
	private Date reauditAddTime;
	
	/**
	 * @Fields reauditRemark:复核备注
	 */
	private String reauditRemark;
	
	/**
	 * @Fields auditUserId:审核人id
	 */
	private String auditUserId;
	
	/**
	 * @Fields auditUserName:审核人名称
	 */
	private String auditUserName;
	
	/**
	 * @Fields auditAddTime:审核时间
	 */
	private Date auditAddTime;
	
	/**
	 * @Fields auditRemark:审核备注
	 */
	private String auditRemark;

	/**
	 * @Fields auditRemark:基本户账号
	 */
	private String bankBasicAccount;

	/**
	 * @Fields auditRemark:基本户户名
	 */
	private String bankBasicName;
	
	/**
	 * @Fields auditRemark:支付信息提交时间
	 */
	private Date bankSubmitTime;
	
	private Integer isDispermission;
	
	public Date getBankSubmitTime() {
		return bankSubmitTime;
	}

	public void setBankSubmitTime(Date bankSubmitTime) {
		this.bankSubmitTime = bankSubmitTime;
	}

	/**
	 * @Fields auditRemark:支付信息审核状态
	 */
	private Integer bankAuditState;

	/**
	 * @Fields auditRemark:支付信息审核人编号
	 */
	private String bankAuditUserId;

	/**
	 * @Fields auditRemark:支付信息审核人
	 */
	private String bankAuditUserName;
	/**
	 * @Fields auditRemark:支付信息审核时间
	 */
	private Date bankAuditTime;
	private String bankAuditTimeStr;
	
	/**
	 * @Fields auditRemark:开户行名称
	 */
	private String bankName;
	/**
	 * @Fields auditRemark:支付信息审核状态(0:默认,1:待复审,2:复审通过,3:复审不通过)
	 */
	private Integer bankAuditSecondState;
	/**
	 * @Fields auditRemark:支付信息复审人编号
	 */
	private String bankAuditSecondUserId;
	/**
	 * @Fields auditRemark:支付信息复审人
	 */
	private String bankAuditSecondUserName;
	/**
	 * @Fields auditRemark:支付信息复审时间
	 */
	private Date bankAuditSecondTime;
	
	private String changeRemark;
	//columns END
	
	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public Integer getBankAuditSecondState() {
		return bankAuditSecondState;
	}

	public void setBankAuditSecondState(Integer bankAuditSecondState) {
		this.bankAuditSecondState = bankAuditSecondState;
	}

	public String getBankAuditSecondUserId() {
		return bankAuditSecondUserId;
	}

	public void setBankAuditSecondUserId(String bankAuditSecondUserId) {
		this.bankAuditSecondUserId = bankAuditSecondUserId;
	}

	public String getBankAuditSecondUserName() {
		return bankAuditSecondUserName;
	}

	public void setBankAuditSecondUserName(String bankAuditSecondUserName) {
		this.bankAuditSecondUserName = bankAuditSecondUserName;
	}

	public Date getBankAuditSecondTime() {
		return bankAuditSecondTime;
	}

	public void setBankAuditSecondTime(Date bankAuditSecondTime) {
		this.bankAuditSecondTime = bankAuditSecondTime;
	}

	private String userName;
	
	private String companyNamePs;
	
	
	public StdCompanys(){
	}

	public StdCompanys(String companyId){
		this.companyId = companyId;
	}

	
	public void setCompanyId(String companyId){
		this.companyId = companyId;
	}
	
	public String getCompanyId(){
		return companyId;
	}
	
	public void setCompanyAccountCode(String companyAccountCode){
		this.companyAccountCode = companyAccountCode;
	}
	
	public String getCompanyAccountCode(){
		return companyAccountCode;
	}
	
	public void setCompanyName(String companyName){
		this.companyName = companyName;
	}
	
	public String getCompanyName(){
		return companyName;
	}
	
	public void setCompSpelCode(String compSpelCode){
		this.compSpelCode = compSpelCode;
	}
	
	public String getCompSpelCode(){
		return compSpelCode;
	}
	
	public void setCompanySimpleName(String companySimpleName){
		this.companySimpleName = companySimpleName;
	}
	
	public String getCompanySimpleName(){
		return companySimpleName;
	}
	
	public void setCompanySimpleNameSpell(String companySimpleNameSpell){
		this.companySimpleNameSpell = companySimpleNameSpell;
	}
	
	public String getCompanySimpleNameSpell(){
		return companySimpleNameSpell;
	}
	
	public void setLastYearIncome(BigDecimal lastYearIncome){
		this.lastYearIncome = lastYearIncome;
	}
	
	public BigDecimal getLastYearIncome(){
		return lastYearIncome;
	}
	
	public void setCompanyContactTel(String companyContactTel){
		this.companyContactTel = companyContactTel;
	}
	
	public String getCompanyContactTel(){
		return companyContactTel;
	}
	
	public void setCompanyContactFax(String companyContactFax){
		this.companyContactFax = companyContactFax;
	}
	
	public String getCompanyContactFax(){
		return companyContactFax;
	}
	
	public void setZipCode(Integer zipCode){
		this.zipCode = zipCode;
	}
	
	public Integer getZipCode(){
		return zipCode;
	}
	
	public void setEmail(String email){
		this.email = email;
	}
	
	public String getEmail(){
		return email;
	}
	
	public void setFilingNumber(String filingNumber){
		this.filingNumber = filingNumber;
	}
	
	public String getFilingNumber(){
		return filingNumber;
	}
	
	public void setCompanyTypeSystem(Integer companyTypeSystem){
		this.companyTypeSystem = companyTypeSystem;
	}
	
	public Integer getCompanyTypeSystem(){
		return companyTypeSystem;
	}
	
	public void setCompanyType(Integer companyType){
		this.companyType = companyType;
	}
	
	public Integer getCompanyType(){
		return companyType;
	}
	
	public void setOnceCompanyName(String onceCompanyName){
		this.onceCompanyName = onceCompanyName;
	}
	
	public String getOnceCompanyName(){
		return onceCompanyName;
	}
	
	public void setAreaId(Integer areaId){
		this.areaId = areaId;
	}
	
	public Integer getAreaId(){
		return areaId;
	}
	
	public void setAddress(String address){
		this.address = address;
	}
	
	public String getAddress(){
		return address;
	}
	
	public void setRegisteredCapital(Long registeredCapital){
		this.registeredCapital = registeredCapital;
	}
	
	public Long getRegisteredCapital(){
		return registeredCapital;
	}
	
	public void setLegalName(String legalName){
		this.legalName = legalName;
	}
	
	public String getLegalName(){
		return legalName;
	}
	
	public void setLegalNumber(String legalNumber){
		this.legalNumber = legalNumber;
	}
	
	public String getLegalNumber(){
		return legalNumber;
	}
	
	public void setLegalScanAttachId(String legalScanAttachId){
		this.legalScanAttachId = legalScanAttachId;
	}
	
	public String getLegalScanAttachId(){
		return legalScanAttachId;
	}
	
	public void setLegalCellphone(String legalCellphone){
		this.legalCellphone = legalCellphone;
	}
	
	public String getLegalCellphone(){
		return legalCellphone;
	}
	
	public void setLegalPhone(String legalPhone){
		this.legalPhone = legalPhone;
	}
	
	public String getLegalPhone(){
		return legalPhone;
	}
	
	public void setCompanyRegistType(String companyRegistType){
		this.companyRegistType = companyRegistType;
	}
	
	public String getCompanyRegistType(){
		return companyRegistType;
	}
	
	public void setIsGroupCompany(Integer isGroupCompany){
		this.isGroupCompany = isGroupCompany;
	}
	
	public Integer getIsGroupCompany(){
		return isGroupCompany;
	}
	
	public void setGroupCompanyName(String groupCompanyName){
		this.groupCompanyName = groupCompanyName;
	}
	
	public String getGroupCompanyName(){
		return groupCompanyName;
	}
	
	public void setIsLawerCompany(Integer isLawerCompany){
		this.isLawerCompany = isLawerCompany;
	}
	
	public Integer getIsLawerCompany(){
		return isLawerCompany;
	}
	
	public void setLawerCompoanyName(String lawerCompoanyName){
		this.lawerCompoanyName = lawerCompoanyName;
	}
	
	public String getLawerCompoanyName(){
		return lawerCompoanyName;
	}
	
	public void setOrganizationCode(String organizationCode){
		this.organizationCode = organizationCode;
	}
	
	public String getOrganizationCode(){
		return organizationCode;
	}
	
	public void setTaxRegistrationNumber(String taxRegistrationNumber){
		this.taxRegistrationNumber = taxRegistrationNumber;
	}
	
	public String getTaxRegistrationNumber(){
		return taxRegistrationNumber;
	}
	
	public void setBusinessLicense(String businessLicense){
		this.businessLicense = businessLicense;
	}
	
	public String getBusinessLicense(){
		return businessLicense;
	}
	
	public void setBusinessLicenseBeginDate(Date businessLicenseBeginDate){
		this.businessLicenseBeginDate = businessLicenseBeginDate;
	}
	
	public Date getBusinessLicenseBeginDate(){
		return businessLicenseBeginDate;
	}
	
	public void setBusinessLicenseEndDate(Date businessLicenseEndDate){
		this.businessLicenseEndDate = businessLicenseEndDate;
	}
	
	public Date getBusinessLicenseEndDate(){
		return businessLicenseEndDate;
	}
	
	public void setAnnualInspection(String annualInspection){
		this.annualInspection = annualInspection;
	}
	
	public String getAnnualInspection(){
		return annualInspection;
	}
	
	public void setAuthorizedPerson(String authorizedPerson){
		this.authorizedPerson = authorizedPerson;
	}
	
	public String getAuthorizedPerson(){
		return authorizedPerson;
	}
	
	public void setAuthorizedPersonFax(String authorizedPersonFax){
		this.authorizedPersonFax = authorizedPersonFax;
	}
	
	public String getAuthorizedPersonFax(){
		return authorizedPersonFax;
	}
	
	public void setAuthorizedPersonIdcard(String authorizedPersonIdcard){
		this.authorizedPersonIdcard = authorizedPersonIdcard;
	}
	
	public String getAuthorizedPersonIdcard(){
		return authorizedPersonIdcard;
	}
	
	public void setAuthorizedPersonTel(String authorizedPersonTel){
		this.authorizedPersonTel = authorizedPersonTel;
	}
	
	public String getAuthorizedPersonTel(){
		return authorizedPersonTel;
	}
	
	public void setProductionPermissionCode(String productionPermissionCode){
		this.productionPermissionCode = productionPermissionCode;
	}
	
	public String getProductionPermissionCode(){
		return productionPermissionCode;
	}
	
	public void setProductionPermissionRegistAddress(String productionPermissionRegistAddress){
		this.productionPermissionRegistAddress = productionPermissionRegistAddress;
	}
	
	public String getProductionPermissionRegistAddress(){
		return productionPermissionRegistAddress;
	}
	
	public void setProductionPermissionLawer(String productionPermissionLawer){
		this.productionPermissionLawer = productionPermissionLawer;
	}
	
	public String getProductionPermissionLawer(){
		return productionPermissionLawer;
	}
	
	public void setProductionPermissionEndDate(Date productionPermissionEndDate){
		this.productionPermissionEndDate = productionPermissionEndDate;
	}
	
	public Date getProductionPermissionEndDate(){
		return productionPermissionEndDate;
	}
	
	public void setProductionPermissionProductAddress(String productionPermissionProductAddress){
		this.productionPermissionProductAddress = productionPermissionProductAddress;
	}
	
	public String getProductionPermissionProductAddress(){
		return productionPermissionProductAddress;
	}
	
	public void setProductionPermissionProductRange(String productionPermissionProductRange){
		this.productionPermissionProductRange = productionPermissionProductRange;
	}
	
	public String getProductionPermissionProductRange(){
		return productionPermissionProductRange;
	}
	
	public void setProductionPermissionClassificationCodes(String productionPermissionClassificationCodes){
		this.productionPermissionClassificationCodes = productionPermissionClassificationCodes;
	}
	
	public String getProductionPermissionClassificationCodes(){
		return productionPermissionClassificationCodes;
	}
	
	public void setGmpCode(String gmpCode){
		this.gmpCode = gmpCode;
	}
	
	public String getGmpCode(){
		return gmpCode;
	}
	
	public void setBusinessPermissionCode(String businessPermissionCode){
		this.businessPermissionCode = businessPermissionCode;
	}
	
	public String getBusinessPermissionCode(){
		return businessPermissionCode;
	}
	
	public void setBusinessPermissionRegistAddress(String businessPermissionRegistAddress){
		this.businessPermissionRegistAddress = businessPermissionRegistAddress;
	}
	
	public String getBusinessPermissionRegistAddress(){
		return businessPermissionRegistAddress;
	}
	
	public void setBusinessPermissionLawer(String businessPermissionLawer){
		this.businessPermissionLawer = businessPermissionLawer;
	}
	
	public String getBusinessPermissionLawer(){
		return businessPermissionLawer;
	}
	
	public void setBusinessPermissionEndDate(Date businessPermissionEndDate){
		this.businessPermissionEndDate = businessPermissionEndDate;
	}
	
	public Date getBusinessPermissionEndDate(){
		return businessPermissionEndDate;
	}
	
	public void setBusinessPermissionWarehouseAddress(String businessPermissionWarehouseAddress){
		this.businessPermissionWarehouseAddress = businessPermissionWarehouseAddress;
	}
	
	public String getBusinessPermissionWarehouseAddress(){
		return businessPermissionWarehouseAddress;
	}
	
	public void setBusinessPermissionRange(String businessPermissionRange){
		this.businessPermissionRange = businessPermissionRange;
	}
	
	public String getBusinessPermissionRange(){
		return businessPermissionRange;
	}
	
	public void setGspCode(String gspCode){
		this.gspCode = gspCode;
	}
	
	public String getGspCode(){
		return gspCode;
	}
	
	public void setIsUsing(Integer isUsing){
		this.isUsing = isUsing;
	}
	
	public Integer getIsUsing(){
		return isUsing;
	}
	
	public void setQualificationStatus(Integer qualificationStatus){
		this.qualificationStatus = qualificationStatus;
	}
	
	public Integer getQualificationStatus(){
		return qualificationStatus;
	}
	
	public void setQualificationStatusNopassReason(String qualificationStatusNopassReason){
		this.qualificationStatusNopassReason = qualificationStatusNopassReason;
	}
	
	public String getQualificationStatusNopassReason(){
		return qualificationStatusNopassReason;
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
	

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
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

	public String getAuditRemark() {
		return auditRemark;
	}

	public void setAuditRemark(String auditRemark) {
		this.auditRemark = auditRemark;
	}

	public Integer getMaintenanceState() {
		return maintenanceState;
	}

	public void setMaintenanceState(Integer maintenanceState) {
		this.maintenanceState = maintenanceState;
	}

	public String getAreaName() {
		return areaName;
	}

	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}

	public String getBankBasicAccount() {
		return bankBasicAccount;
	}

	public void setBankBasicAccount(String bankBasicAccount) {
		this.bankBasicAccount = bankBasicAccount;
	}

	public String getBankBasicName() {
		return bankBasicName;
	}

	public void setBankBasicName(String bankBasicName) {
		this.bankBasicName = bankBasicName;
	}

	public String getCompanyNamePs() {
		if(companyName!=""||companyName!=null){
			companyNamePs=companyName;
		}
		return companyNamePs;
	}

	public void setCompanyNamePs(String companyNamePs) {
	    this.companyNamePs = companyNamePs;	
	}

	public Integer getBankAuditState() {
		return bankAuditState;
	}

	public void setBankAuditState(Integer bankAuditState) {
		this.bankAuditState = bankAuditState;
	}

	public String getBankAuditUserId() {
		return bankAuditUserId;
	}

	public void setBankAuditUserId(String bankAuditUserId) {
		this.bankAuditUserId = bankAuditUserId;
	}

	public String getBankAuditUserName() {
		return bankAuditUserName;
	}

	public void setBankAuditUserName(String bankAuditUserName) {
		this.bankAuditUserName = bankAuditUserName;
	}

	public Date getBankAuditTime() {
		return bankAuditTime;
	}

	public void setBankAuditTime(Date bankAuditTime) {
		this.bankAuditTime = bankAuditTime;
	}

	public String getBankAuditTimeStr() {
		if(bankAuditTime !=null){
		bankAuditTimeStr=ParseDate.parseFullFormat(bankAuditTime);
		}
		return bankAuditTimeStr;
	}

	public void setBankAuditTimeStr(String bankAuditTimeStr) {
		this.bankAuditTimeStr = bankAuditTimeStr;
	}

	public Integer getIsDispermission() {
		return isDispermission;
	}

	public void setIsDispermission(Integer isDispermission) {
		this.isDispermission = isDispermission;
	}

	public String getChangeRemark() {
		return changeRemark;
	}

	public void setChangeRemark(String changeRemark) {
		this.changeRemark = changeRemark;
	}

	

	
	
}