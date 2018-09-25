package com.hsnn.medstgmini.base.std.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.hsnn.medstgmini.common.model.Attachment;
import com.hsnn.medstgmini.common.model.IAttachment;
import com.hsnn.medstgmini.util.ParseDate;
import com.hsnn.medstgmini.util.compile.KeywordsAnnotation;
import com.hsnn.medstgmini.util.compile.PropertyNameAnnotation;



/**
 *
 * @Since 2010-2016
 * @Description: TODO
 * @author zhou.xy
 * @date 2016-02-25 08:45:15
 *
 */
public class StdHospital  implements Serializable, IAttachment<String>{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	//alias
	public static final String TABLE_ALIAS = "StdHospital";

	private Integer diancount;

	private Integer caicount;

	private BigDecimal ze;

	private BigDecimal sj;

	private BigDecimal ky;

	private BigDecimal dj;
	/**
	 * @Fields orderAmount:医院付款金额
	 */
	private BigDecimal paid;
	/**
	 * @Fields orderAmount:医院未付款金额
	 */
	private BigDecimal nopaid;
	//columns START
	/**
	 * @Fields hospitalId:医疗机构id
	 */
	private String hospitalId;
	
	/**
	 * @Fields hospitalName:医疗机构名称
	 */
	@KeywordsAnnotation(annotation="医疗机构名称")
	@PropertyNameAnnotation(annotation="医疗机构名称")
	private String hospitalName;
	

	/**
	 * @Fields userName:帐号
	 */
	@PropertyNameAnnotation(annotation="帐号")
	private String userName;
	
	/**
	 * @Fields hospSpelCode:医疗机构名称拼音码
	 */
	@PropertyNameAnnotation(annotation="医疗机构名称拼音码")
	private String hospSpelCode;
	
	/**
	 * @Fields hospShortName:医疗机构简称
	 */
	@PropertyNameAnnotation(annotation="医疗机构简称")
	private String hospShortName;
	
	/**
	 * @Fields hospShortSpelCode:医疗机构简称拼音码
	 */
	@PropertyNameAnnotation(annotation="医疗机构简称拼音码")
	private String hospShortSpelCode;
	
	/**
	 * @Fields hospitalAddress:医疗机构地址
	 */
	@PropertyNameAnnotation(annotation="医疗机构地址")
	private String hospitalAddress;
		
	/**
	 * @Fields areaId:地理区域id
	 */
	@PropertyNameAnnotation(annotation="地理区域id")
	private Integer areaId;
	
	/**
	 * @Fields contactPerson:联系人
	 */
	@PropertyNameAnnotation(annotation="联系人")
	private String contactPerson;
	
	/**
	 * @Fields contactTel:联系电话
	 */
	@PropertyNameAnnotation(annotation="联系电话")
	private String contactTel;
	
	/**
	 * @Fields contactEmail:联系邮箱（必填，用于找回密码）
	 */
	@PropertyNameAnnotation(annotation="联系邮箱")
	private String contactEmail;
	
	/**
	 * @Fields contactQq:联系人QQ
	 */
	@PropertyNameAnnotation(annotation="联系人QQ")
	private String contactQq;
	
	/**
	 * @Fields hospitalLevel:医疗机构等级(三级甲等...)
	 */
	@PropertyNameAnnotation(annotation="医疗机构等级")
	private String hospitalLevel;
	
	
	
	/**
	 * @Fields drugPurchaseProperty:药品采购属性(0:基层,1:县上)
	 */
	@PropertyNameAnnotation(annotation="药品采购属性(0:县及县以上,1:基层)")
	private Integer drugPurchaseProperty;
	
	/**
	 * @Fields adminAreaNameDrug:药品行政区域名称
	 */
	@PropertyNameAnnotation(annotation="药品行政区域名称")
	private String adminAreaNameDrug;
	
	/**
	 * @Fields adminAreaIdDrug:药品行政区域id
	 */
	@PropertyNameAnnotation(annotation="药品行政区域id")
	private Integer adminAreaIdDrug;
	
	/**
	 * @Fields adminAreaNameStatisticsDrug:药品统计名称
	 */
	@PropertyNameAnnotation(annotation="药品统计名称")
	private String adminAreaNameStatisticsDrug;
	
	/**
	 * @Fields adminAreaIdStatisticsDrug:药品统计id
	 */
	@PropertyNameAnnotation(annotation="药品统计id")
	private Integer adminAreaIdStatisticsDrug;
	
	/**
	 * @Fields adminAreaNameSupplies:耗材行政区域名称
	 */
	@PropertyNameAnnotation(annotation="耗材行政区域名称")
	private String adminAreaNameSupplies;
	
	/**
	 * @Fields adminAreaIdSupplies:耗材行政区域id
	 */
	@PropertyNameAnnotation(annotation="耗材行政区域id")
	private Integer adminAreaIdSupplies;
	
	/**
	 * @Fields adminAreaNameStatisticsSupplies:耗材统计名称
	 */
	@PropertyNameAnnotation(annotation="耗材统计名称")
	private String adminAreaNameStatisticsSupplies;
	
	/**
	 * @Fields adminAreaIdStatisticsSupplies:耗材统计id
	 */
	@PropertyNameAnnotation(annotation="耗材统计id")
	private Integer adminAreaIdStatisticsSupplies;
	
	
	private StdArea area;
	
	
	
	public String getAdminAreaNameStatisticsDrug() {
		return adminAreaNameStatisticsDrug;
	}

	public void setAdminAreaNameStatisticsDrug(String adminAreaNameStatisticsDrug) {
		this.adminAreaNameStatisticsDrug = adminAreaNameStatisticsDrug;
	}

	public Integer getAdminAreaIdStatisticsDrug() {
		return adminAreaIdStatisticsDrug;
	}

	public void setAdminAreaIdStatisticsDrug(Integer adminAreaIdStatisticsDrug) {
		this.adminAreaIdStatisticsDrug = adminAreaIdStatisticsDrug;
	}

	public String getAdminAreaNameStatisticsSupplies() {
		return adminAreaNameStatisticsSupplies;
	}

	public void setAdminAreaNameStatisticsSupplies(String adminAreaNameStatisticsSupplies) {
		this.adminAreaNameStatisticsSupplies = adminAreaNameStatisticsSupplies;
	}

	public Integer getAdminAreaIdStatisticsSupplies() {
		return adminAreaIdStatisticsSupplies;
	}

	public void setAdminAreaIdStatisticsSupplies(Integer adminAreaIdStatisticsSupplies) {
		this.adminAreaIdStatisticsSupplies = adminAreaIdStatisticsSupplies;
	}

	/**
	 * @Fields healthOrganizationCode:卫生机构代码(卫生社会团体,急救中心（站）,妇幼保健院(所、站)...)
	 */
	@PropertyNameAnnotation(annotation="卫生机构代码")
	private String healthOrganizationCode;
	
	/**
	 * @Fields organizers:举办单位
	 */
	@PropertyNameAnnotation(annotation="举办单位")
	private String organizers;
	
	/**
	 * @Fields bedNumber:床位数
	 */
	@PropertyNameAnnotation(annotation="床位数")
	private Integer bedNumber;
	
	/**
	 * @Fields technicalStaff:卫技人员数
	 */
	@PropertyNameAnnotation(annotation="卫技人员数")
	private Integer technicalStaff;
	
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
	@PropertyNameAnnotation(annotation="法人代表人证件扫描件id")
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
	 * @Fields isDrugDesignated:是否医保定点
	 */
	@PropertyNameAnnotation(annotation="是否医保定点(0:基层1：县上)")
	private Integer isDrugDesignated;
	
	/**
	 * @Fields isBillingHospital:是否结算医院(0：否,1：是)
	 */
	@PropertyNameAnnotation(annotation="是否结算医院(0：否,1：是)")
	private Integer isBillingHospital;
	
	/**
	 * @Fields governmentOfficeAffiliationCode:政府办卫生机构隶属关系
	 */
	@PropertyNameAnnotation(annotation="政府办卫生机构隶属关系")
	private String governmentOfficeAffiliationCode;
	
	/**
	 * @Fields isUsing:是否启用(0:停用,1:启用)
	 */
	@PropertyNameAnnotation(annotation="是否启用(0:停用,1:启用)")
	private Integer isUsing;
	
	/**
	 * @Fields dealReason:停用启用备注
	 */
	private String dealReason;
	public String getDealReason() {
		return dealReason;
	}

	public void setDealReason(String dealReason) {
		this.dealReason = dealReason;
	}

	/**
	 * @Fields addUserId:记录添加人id
	 */
	@PropertyNameAnnotation(annotation="记录添加人id")
	private String addUserId;
	
	/**
	 * @Fields hospLiceNo:医疗机构执业许可证号
	 */
	@PropertyNameAnnotation(annotation="医疗机构执业许可证号")
	private String hospLiceNo;
	
	/**
	 * @Fields hospLiceStartDate:执业许可证号有效期始
	 */
	@PropertyNameAnnotation(annotation="执业许可证号有效期始")
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date hospLiceStartDate;
	
	/**
	 * @Fields hospLiceEndDate:执业许可证号有效期止
	 */
	@PropertyNameAnnotation(annotation="执业许可证号有效期止")
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date hospLiceEndDate;
	
	/**
	 * @Fields enterLiceNo:事业单位法人证书号
	 */
	@PropertyNameAnnotation(annotation="事业单位法人证书号")
	private String enterLiceNo;
	
	/**
	 * @Fields enterLiceStartDate:事业单位法人证书有效期始
	 */
	@PropertyNameAnnotation(annotation="事业单位法人证书有效期始")
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date enterLiceStartDate;
	
	/**
	 * @Fields enterLiceEndDate:事业单位法人证书有效期止
	 */
	@PropertyNameAnnotation(annotation="事业单位法人证书有效期止")
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date enterLiceEndDate;
	
	/**
	 * @Fields incomPatNum:年门诊量,单位,万人
	 */
	@PropertyNameAnnotation(annotation="年门诊量(单位：万人)")
	private BigDecimal incomPatNum;
	
	/**
	 * @Fields regCap:注册资本,万元
	 */
	@PropertyNameAnnotation(annotation="注册资本(单位：万元)")
	private BigDecimal regCap;
	
	/**
	 * @Fields initializationState:初始化状态
	 */
	@PropertyNameAnnotation(annotation="初始化状态(0:待提交,1:待审核,2:审核通过,3:审核不通过)")
	private Integer initializationState;
	
	/**
	 * @Fields audittRemarks:审核备注
	 */
	@PropertyNameAnnotation(annotation="审核备注")
	private String audittRemarks;
	
	/**
	 * @Fields addUserName:记录添加人
	 */
	@PropertyNameAnnotation(annotation="记录添加人")
	private String addUserName;
	
	/**
	 * @Fields addTime:记录添加时间
	 */
	@PropertyNameAnnotation(annotation="记录添加时间")
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date addTime;
	
	/**
	 * @Fields lastUpdateUserId:最后一次更新记录人id
	 */
	@PropertyNameAnnotation(annotation="最后一次更新记录人id")
	private String lastUpdateUserId;
	
	/**
	 * @Fields lastUpdateUserName:最后一次更新记录人
	 */
	@PropertyNameAnnotation(annotation="最后一次更新记录人")
	private String lastUpdateUserName;
	
	/**
	 * @Fields lastUpdateTime:最后一次更新记录时间
	 */
	@PropertyNameAnnotation(annotation="最后一次更新记录时间")
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date lastUpdateTime;
	
	//上传附件
    private transient Attachment attachment;
	
	//columns END
	
	//拓展字段
	//地区名称
	private String areaName;
	
	//地区
	private StdArea areaIdName;
	//药品行政区域
	private StdArea adminAreaIdDrugName;
	//耗材行政区域
	private StdArea adminAreaIdSuppliesName;
	
	//增加字段
	/**
	 * @Fields auditRemark:基本户账号
	 */
	private String bankBasicAccount;

	/**
	 * @Fields auditRemark:基本户户名
	 */
	private String bankBasicName;
	
	/**
	 * @Fields auditRemark:贷款账号
	 */
	private String bankLoanAccount;
	/**
	 * @Fields auditRemark:贷款账号户名
	 */
	private String loanName;
	
	/**
	 * @Fields auditRemark:支付信息提交时间
	 */
	private Date bankSubmitTime;

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
	
	@PropertyNameAnnotation(annotation="组织机构代码")
	private String organizationCode;
	
	@PropertyNameAnnotation(annotation="行政区划代码")
	private String administrativeAreaCode;
	
	@PropertyNameAnnotation(annotation="经济类型代码")
	private String economicTypeCode;
	
	@PropertyNameAnnotation(annotation="机构类别代码")
	private String organizationClassCode;
	
	@PropertyNameAnnotation(annotation="机构分类管理代码")
	private String organizationManagementCode;
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
	
	public StdHospital(){
	}

	public StdHospital(String hospitalId){
		this.hospitalId = hospitalId;
	}

	public String getHospitalId() {
		return hospitalId;
	}

	public void setHospitalId(String hospitalId) {
		this.hospitalId = hospitalId;
	}

	public String getHospitalName() {
		return hospitalName;
	}

	public void setHospitalName(String hospitalName) {
		this.hospitalName = hospitalName;
	}

	public String getHospSpelCode() {
		return hospSpelCode;
	}

	public void setHospSpelCode(String hospSpelCode) {
		this.hospSpelCode = hospSpelCode;
	}

	public String getHospShortName() {
		return hospShortName;
	}

	public void setHospShortName(String hospShortName) {
		this.hospShortName = hospShortName;
	}

	public String getHospShortSpelCode() {
		return hospShortSpelCode;
	}

	public void setHospShortSpelCode(String hospShortSpelCode) {
		this.hospShortSpelCode = hospShortSpelCode;
	}

	public String getHospitalAddress() {
		return hospitalAddress;
	}

	public void setHospitalAddress(String hospitalAddress) {
		this.hospitalAddress = hospitalAddress;
	}

	public Integer getAreaId() {
		return areaId;
	}

	public void setAreaId(Integer areaId) {
		this.areaId = areaId;
	}

	public String getContactPerson() {
		return contactPerson;
	}

	public void setContactPerson(String contactPerson) {
		this.contactPerson = contactPerson;
	}

	public String getContactTel() {
		return contactTel;
	}

	public void setContactTel(String contactTel) {
		this.contactTel = contactTel;
	}

	public String getContactEmail() {
		return contactEmail;
	}

	public void setContactEmail(String contactEmail) {
		this.contactEmail = contactEmail;
	}

	public String getContactQq() {
		return contactQq;
	}

	public void setContactQq(String contactQq) {
		this.contactQq = contactQq;
	}

	public String getHospitalLevel() {
		return hospitalLevel;
	}

	public void setHospitalLevel(String hospitalLevel) {
		this.hospitalLevel = hospitalLevel;
	}

	public Integer getDrugPurchaseProperty() {
		return drugPurchaseProperty;
	}

	public void setDrugPurchaseProperty(Integer drugPurchaseProperty) {
		this.drugPurchaseProperty = drugPurchaseProperty;
	}

	public Integer getAdminAreaIdDrug() {
		return adminAreaIdDrug;
	}

	public void setAdminAreaIdDrug(Integer adminAreaIdDrug) {
		this.adminAreaIdDrug = adminAreaIdDrug;
	}

	public Integer getAdminAreaIdSupplies() {
		return adminAreaIdSupplies;
	}

	public void setAdminAreaIdSupplies(Integer adminAreaIdSupplies) {
		this.adminAreaIdSupplies = adminAreaIdSupplies;
	}

	public String getHealthOrganizationCode() {
		return healthOrganizationCode;
	}

	public void setHealthOrganizationCode(String healthOrganizationCode) {
		this.healthOrganizationCode = healthOrganizationCode;
	}

	public String getOrganizers() {
		return organizers;
	}

	public void setOrganizers(String organizers) {
		this.organizers = organizers;
	}

	public Integer getBedNumber() {
		return bedNumber;
	}

	public void setBedNumber(Integer bedNumber) {
		this.bedNumber = bedNumber;
	}

	public Integer getTechnicalStaff() {
		return technicalStaff;
	}

	public void setTechnicalStaff(Integer technicalStaff) {
		this.technicalStaff = technicalStaff;
	}

	public String getLegalName() {
		return legalName;
	}

	public void setLegalName(String legalName) {
		this.legalName = legalName;
	}

	public String getLegalNumber() {
		return legalNumber;
	}

	public void setLegalNumber(String legalNumber) {
		this.legalNumber = legalNumber;
	}

	public String getLegalScanAttachId() {
		return legalScanAttachId;
	}

	public void setLegalScanAttachId(String legalScanAttachId) {
		this.legalScanAttachId = legalScanAttachId;
	}

	public String getLegalCellphone() {
		return legalCellphone;
	}

	public void setLegalCellphone(String legalCellphone) {
		this.legalCellphone = legalCellphone;
	}

	public String getLegalPhone() {
		return legalPhone;
	}

	public void setLegalPhone(String legalPhone) {
		this.legalPhone = legalPhone;
	}

	public Integer getIsDrugDesignated() {
		return isDrugDesignated;
	}

	public void setIsDrugDesignated(Integer isDrugDesignated) {
		this.isDrugDesignated = isDrugDesignated;
	}
	
	public Integer getIsBillingHospital() {
		return isBillingHospital;
	}

	public void setIsBillingHospital(Integer isBillingHospital) {
		this.isBillingHospital = isBillingHospital;
	}

	public static String getTableAlias() {
		return TABLE_ALIAS;
	}

	public String getGovernmentOfficeAffiliationCode() {
		return governmentOfficeAffiliationCode;
	}

	public void setGovernmentOfficeAffiliationCode(
			String governmentOfficeAffiliationCode) {
		this.governmentOfficeAffiliationCode = governmentOfficeAffiliationCode;
	}

	public Integer getIsUsing() {
		return isUsing;
	}

	public void setIsUsing(Integer isUsing) {
		this.isUsing = isUsing;
	}

	public String getAddUserId() {
		return addUserId;
	}

	public void setAddUserId(String addUserId) {
		this.addUserId = addUserId;
	}

	public String getHospLiceNo() {
		return hospLiceNo;
	}

	public void setHospLiceNo(String hospLiceNo) {
		this.hospLiceNo = hospLiceNo;
	}

	public Date getHospLiceStartDate() {
		return hospLiceStartDate;
	}

	public void setHospLiceStartDate(Date hospLiceStartDate) {
		this.hospLiceStartDate = hospLiceStartDate;
	}

	public Date getHospLiceEndDate() {
		return hospLiceEndDate;
	}

	public void setHospLiceEndDate(Date hospLiceEndDate) {
		this.hospLiceEndDate = hospLiceEndDate;
	}

	public String getEnterLiceNo() {
		return enterLiceNo;
	}

	public void setEnterLiceNo(String enterLiceNo) {
		this.enterLiceNo = enterLiceNo;
	}

	public Date getEnterLiceStartDate() {
		return enterLiceStartDate;
	}

	public void setEnterLiceStartDate(Date enterLiceStartDate) {
		this.enterLiceStartDate = enterLiceStartDate;
	}

	public Date getEnterLiceEndDate() {
		return enterLiceEndDate;
	}

	public void setEnterLiceEndDate(Date enterLiceEndDate) {
		this.enterLiceEndDate = enterLiceEndDate;
	}

	public BigDecimal getIncomPatNum() {
		return incomPatNum;
	}

	public void setIncomPatNum(BigDecimal incomPatNum) {
		this.incomPatNum = incomPatNum;
	}

	public BigDecimal getRegCap() {
		return regCap;
	}

	public void setRegCap(BigDecimal regCap) {
		this.regCap = regCap;
	}

	public Integer getInitializationState() {
		return initializationState;
	}

	public void setInitializationState(Integer initializationState) {
		this.initializationState = initializationState;
	}
	
	public String getAudittRemarks() {
		return audittRemarks;
	}

	public void setAudittRemarks(String audittRemarks) {
		this.audittRemarks = audittRemarks;
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

	public String getLastUpdateUserId() {
		return lastUpdateUserId;
	}

	public void setLastUpdateUserId(String lastUpdateUserId) {
		this.lastUpdateUserId = lastUpdateUserId;
	}

	public String getLastUpdateUserName() {
		return lastUpdateUserName;
	}

	public void setLastUpdateUserName(String lastUpdateUserName) {
		this.lastUpdateUserName = lastUpdateUserName;
	}

	public Date getLastUpdateTime() {
		return lastUpdateTime;
	}

	public void setLastUpdateTime(Date lastUpdateTime) {
		this.lastUpdateTime = lastUpdateTime;
	}

	public String getAreaName() {
		return areaName;
	}

	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}

	@Override
	public String getId() {
		return hospitalId;
	}

	@Override
	public Attachment getAttachment() {
		
		return attachment;
	}

	@Override
	public void setAttachment(Attachment attachment) {
		this.attachment=attachment;
	}

	public StdArea getAreaIdName() {
		return areaIdName;
	}

	public void setAreaIdName(StdArea areaIdName) {
		this.areaIdName = areaIdName;
	}

	public StdArea getAdminAreaIdDrugName() {
		return adminAreaIdDrugName;
	}

	public void setAdminAreaIdDrugName(StdArea adminAreaIdDrugName) {
		this.adminAreaIdDrugName = adminAreaIdDrugName;
	}

	public StdArea getAdminAreaIdSuppliesName() {
		return adminAreaIdSuppliesName;
	}

	public void setAdminAreaIdSuppliesName(StdArea adminAreaIdSuppliesName) {
		this.adminAreaIdSuppliesName = adminAreaIdSuppliesName;
	}

	public String getAdminAreaNameDrug() {
		return adminAreaNameDrug;
	}

	public void setAdminAreaNameDrug(String adminAreaNameDrug) {
		this.adminAreaNameDrug = adminAreaNameDrug;
	}

	public String getAdminAreaNameSupplies() {
		return adminAreaNameSupplies;
	}

	public void setAdminAreaNameSupplies(String adminAreaNameSupplies) {
		this.adminAreaNameSupplies = adminAreaNameSupplies;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
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

	public String getBankLoanAccount() {
		return bankLoanAccount;
	}

	public void setBankLoanAccount(String bankLoanAccount) {
		this.bankLoanAccount = bankLoanAccount;
	}

	public String getLoanName() {
		return loanName;
	}

	public void setLoanName(String loanName) {
		this.loanName = loanName;
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
		if(bankAuditTime != null){
			bankAuditTimeStr=ParseDate.parseFullFormat(bankAuditTime);
		}
		return bankAuditTimeStr;
	}

	public void setBankAuditTimeStr(String bankAuditTimeStr) {
		this.bankAuditTimeStr = bankAuditTimeStr;
	}

	public StdArea getArea() {
		return area;
	}

	public void setArea(StdArea area) {
		this.area = area;
	}

	public String getOrganizationCode() {
		return organizationCode;
	}

	public void setOrganizationCode(String organizationCode) {
		this.organizationCode = organizationCode;
	}

	public String getAdministrativeAreaCode() {
		return administrativeAreaCode;
	}

	public void setAdministrativeAreaCode(String administrativeAreaCode) {
		this.administrativeAreaCode = administrativeAreaCode;
	}

	public String getEconomicTypeCode() {
		return economicTypeCode;
	}

	public void setEconomicTypeCode(String economicTypeCode) {
		this.economicTypeCode = economicTypeCode;
	}

	public String getOrganizationClassCode() {
		return organizationClassCode;
	}

	public void setOrganizationClassCode(String organizationClassCode) {
		this.organizationClassCode = organizationClassCode;
	}

	public String getOrganizationManagementCode() {
		return organizationManagementCode;
	}

	public void setOrganizationManagementCode(String organizationManagementCode) {
		this.organizationManagementCode = organizationManagementCode;
	}
	
	
	/**
	 * @Fields orderControl:下单控制
	 */
	@PropertyNameAnnotation(annotation="下单控制")
	private String orderControl;



	public String getOrderControl() {
		return orderControl;
	}

	public void setOrderControl(String orderControl) {
		this.orderControl = orderControl;
	}


	public BigDecimal getPaid() {
		return paid;
	}

	public void setPaid(BigDecimal paid) {
		this.paid = paid;
	}

	public BigDecimal getNopaid() {
		return nopaid;
	}

	public Integer getDiancount() {
		return diancount;
	}

	public void setDiancount(Integer diancount) {
		this.diancount = diancount;
	}

	public Integer getCaicount() {
		return caicount;
	}

	public void setCaicount(Integer caicount) {
		this.caicount = caicount;
	}

	public BigDecimal getZe() {
		return ze;
	}

	public void setZe(BigDecimal ze) {
		this.ze = ze;
	}

	public BigDecimal getSj() {
		return sj;
	}

	public void setSj(BigDecimal sj) {
		this.sj = sj;
	}

	public BigDecimal getKy() {
		return ky;
	}

	public void setKy(BigDecimal ky) {
		this.ky = ky;
	}

	public BigDecimal getDj() {
		return dj;
	}

	public void setDj(BigDecimal dj) {
		this.dj = dj;
	}

	public void setNopaid(BigDecimal nopaid) {
		this.nopaid = nopaid;
	}
}