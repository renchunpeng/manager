package com.hsnn.medstgmini.base.std.form;

import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.*;
import org.springframework.format.annotation.DateTimeFormat;

import com.hsnn.medstgmini.base.std.form.StdDictForm.First;

/**
 *
 * @Since 2010-2016
 * @Description: TODO
 * @author ***
 * @date 2016-05-28 15:50:14
 *
 */
public class StdPayContractForm  {

	//columns START
	
	/**
	 * @Fields org_id:orgId
	 */
	@NotEmpty(message = "请填写orgId")
	@Length(max = 36, message = "orgId的长度不能超过{1}")
	private String orgId;
	
	/**
	 * @Fields org_name:orgName
	 */
	@Length(max = 1024, message = "orgName的长度不能超过{1}")
	private String orgName;
	
	/**
	 * @Fields org_type:orgType
	 */
	@Range(message = "数值范围不正确")
	private Integer orgType;
	
	/**
	 * @Fields gather_tag:中间归集标志:0.未知、1.建行、2.工行
	 */
	@NotNull(message = "请选择中间归集标志")
	@Range(message = "数值范围不正确")
	private Integer gatherTag;
	
	/**
	 * @Fields bank_basic_account:医院显示:基本户账号,企业显示:结算账号
	 */
	@Length(max = 36, message = "医院显示:基本户账号,企业显示:结算账号的长度不能超过{1}")
	private String bankBasicAccount;
	
	/**
	 * @Fields bank_basic_name:医院显示:基本户户名,企业显示:结算户名
	 */
	@Length(max = 128, message = "医院显示:基本户户名,企业显示:结算户名的长度不能超过{1}")
	private String bankBasicName;
	
	/**
	 * @Fields bank_basic_bankname:开户行
	 */
	@Length(max = 128, message = "开户行的长度不能超过{1}")
	private String bankBasicBankname;
	
	/**
	 * @Fields bank_loan_account:贷款账号
	 */
	@Length(max = 128, message = "贷款账号的长度不能超过{1}")
	private String bankLoanAccount;
	
	/**
	 * @Fields bank_loan_name:贷款账号户名
	 */
	@Length(max = 128, message = "贷款账号户名的长度不能超过{1}")
	private String bankLoanName;
	
	/**
	 * @Fields bank_loan_bankname:贷款开户行
	 */
	@Length(max = 128, message = "贷款开户行的长度不能超过{1}")
	private String bankLoanBankname;
	
	/**
	 * @Fields bank_submit_state:提交状态:0.未提交、1.已提交(默认0)
	 */
	@NotNull(message = "请填写提交状态:0.未提交、1.已提交(默认0)")
	@Range(message = "数值范围不正确")
	private Integer bankSubmitState;
	
	/**
	 * @Fields bank_submit_user_id:提交人id
	 */
	@Length(max = 36, message = "提交人id的长度不能超过{1}")
	private String bankSubmitUserId;
	
	/**
	 * @Fields bank_submit_user_name:提交人
	 */
	@Length(max = 120, message = "提交人的长度不能超过{1}")
	private String bankSubmitUserName;
	
	/**
	 * @Fields bank_submit_time:提交时间
	 */
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date bankSubmitTime;
	
	/**
	 * @Fields bank_audit_first_state:初审状态0:默认,1:待初审,2:初审通过,3:初审不通过
	 */
	@NotNull(message = "请填写初审状态0:默认,1:待初审,2:初审通过,3:初审不通过")
	@Range(message = "数值范围不正确")
	private Integer bankAuditFirstState;
	
	/**
	 * @Fields bank_audit_first_user_id:初审人id
	 */
	@Length(max = 36, message = "初审人id的长度不能超过{1}")
	private String bankAuditFirstUserId;
	
	/**
	 * @Fields bank_audit_first_user_name:初审人
	 */
	@Length(max = 120, message = "初审人的长度不能超过{1}")
	private String bankAuditFirstUserName;
	
	/**
	 * @Fields bank_audit_first_time:初审时间
	 */
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date bankAuditFirstTime;
	
	/**
	 * @Fields bank_audit_second_state:复审状态0:默认,1:待复审,2:复审通过,3:复审不通过
	 */
	@NotNull(message = "请填写复审状态0:默认,1:待复审,2:复审通过,3:复审不通过")
	@Range(message = "数值范围不正确")
	private Integer bankAuditSecondState;
	
	/**
	 * @Fields bank_audit_second_user_id:复审人id
	 */
	@Length(max = 36, message = "复审人id的长度不能超过{1}")
	private String bankAuditSecondUserId;
	
	/**
	 * @Fields bank_audit_second_user_name:复审人
	 */
	@Length(max = 120, message = "复审人的长度不能超过{1}")
	private String bankAuditSecondUserName;
	
	/**
	 * @Fields bank_audit_second_time:复审时间
	 */
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date bankAuditSecondTime;
	
	/**
	 * @Fields finance_contact_person:财务联系人
	 */
	@Length(max = 128, message = "财务联系人的长度不能超过{1}")
	private String financeContactPerson;
	
	/**
	 * @Fields finance_contact_person_audit:财务联系人审核
	 */
	@NotEmpty(message = "请填写财务联系人",groups={First.class})
	@Length(max = 50, message = "财务联系人的长度不能超过{1}")
	private String financeContactPersonAudit;
	
	/**
	 * @Fields bank_basic_account_audit:基本户账号审核信息
	 */
	@NotEmpty(message = "请填写账号",groups={First.class})
	@Length(max = 128, message = "基本户账号审核信息的长度不能超过{1}")
	private String bankBasicAccountAudit;
	
	/**
	 * @Fields bank_basic_name_audit:基本户户名审核信息
	 */
	@NotEmpty(message = "请填写户名",groups={First.class})
	@Length(max = 128, message = "基本户户名审核信息的长度不能超过{1}")
	private String bankBasicNameAudit;
	
	/**
	 * @Fields bank_basic_bankname_audit:基本户开户行审核信息
	 */
	@NotEmpty(message = "请填写开户行",groups={First.class})
	@Length(max = 128, message = "基本户开户行审核信息的长度不能超过{1}")
	private String bankBasicBanknameAudit;
	
	/**
	 * @Fields bank_loan_account_audit:贷款账号审核信息
	 */
	@Length(max = 128, message = "贷款账号审核信息的长度不能超过{1}")
	private String bankLoanAccountAudit;
	
	/**
	 * @Fields bank_loan_name_audit:贷款户名审核信息
	 */
	@Length(max = 128, message = "贷款户名审核信息的长度不能超过{1}")
	private String bankLoanNameAudit;
	
	/**
	 * @Fields bank_loan_bankname_audit:贷款开户行审核信息
	 */
	@Length(max = 128, message = "贷款开户行审核信息的长度不能超过{1}")
	private String bankLoanBanknameAudit;
	
	/**
	 * @Fields gather_tag_audit:中间归集审核标志:0.未知、1.建行、2.工行
	 */
	@NotNull(message = "请选择中间归集标志")
	@Range(message = "数值范围不正确")
	private Integer gatherTagAudit;
	
	/**
	 * @Fields is_need_sync:是否需要同步(0否，1是)
	 */
	@NotNull(message = "请填写是否需要同步(0否，1是)")
	@Range(message = "数值范围不正确")
	private Integer isNeedSync;
	
	/**
	 * @Fields is_balance:是否结算账号:0.否,1.是
	 */
	@NotNull(message = "请填写是否结算账号:0.否,1.是")
	@Range(message = "数值范围不正确")
	private Integer isBalance;
	
	/**
	 * @Fields finance_contact_tel:财务联系人电话
	 */
	@Length(max = 128, message = "财务联系人电话的长度不能超过{1}")
	private String financeContactTel;
	
	/**
	 * @Fields finance_contact_tel_audit:财务联系人电话审核
	 */
	@NotEmpty(message = "请填写财务联系人电话",groups={First.class})
	@Pattern(regexp="^(1\\d{10})$", message="财务联系人电话格式不正确(只能为手机号)",groups={First.class})
	private String financeContactTelAudit;
	public String getFinanceContactPersonAudit() {
		return financeContactPersonAudit;
	}

	public void setFinanceContactPersonAudit(String financeContactPersonAudit) {
		this.financeContactPersonAudit = financeContactPersonAudit;
	}

	public String getFinanceContactTelAudit() {
		return financeContactTelAudit;
	}

	public void setFinanceContactTelAudit(String financeContactTelAudit) {
		this.financeContactTelAudit = financeContactTelAudit;
	}
	/**
	 * @Fields add_user_id:添加人id
	 */
	@Length(max = 36, message = "添加人id的长度不能超过{1}")
	private String addUserId;
	
	/**
	 * @Fields add_user_name:添加人
	 */
	@Length(max = 128, message = "添加人的长度不能超过{1}")
	private String addUserName;
	
	/**
	 * @Fields add_time:添加时间
	 */
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date addTime;
	
	/**
	 * @Fields last_update_user_id:最后更新人id
	 */
	@Length(max = 36, message = "最后更新人id的长度不能超过{1}")
	private String lastUpdateUserId;
	
	/**
	 * @Fields last_update_user_name:最后更新人
	 */
	@Length(max = 128, message = "最后更新人的长度不能超过{1}")
	private String lastUpdateUserName;
	
	/**
	 * @Fields last_update_time:最后更新时间
	 */
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date lastUpdateTime;
	
	/**
	 * @Fields agree_time:agreeTime
	 */
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date agreeTime;
	
	/**
	 * @Fields agree_user_id:agreeUserId
	 */
	@Length(max = 36, message = "agreeUserId的长度不能超过{1}")
	private String agreeUserId;
	
	/**
	 * @Fields agree_user_name:agreeUserName
	 */
	@Length(max = 100, message = "agreeUserName的长度不能超过{1}")
	private String agreeUserName;
	
	/**
	 * @Fields ip4:ip4
	 */
	@Length(max = 36, message = "ip4的长度不能超过{1}")
	private String ip4;
	

	/**
	 * @Fields hosp_pay_mode:医院支付的方式1网银支付、2一户通支付、3全部
	 */
	@NotNull(message = "请选择支付方式")
	@Range(message = "数值范围不正确")
	private Integer hospPayMode;
	//columns END
	
	/**
	 * @Fields isSignYht:isSignYht
	 */
	private Integer isSignYht;

	public Integer getIsSignYht() {
		return isSignYht;
	}

	public void setIsSignYht(Integer isSignYht) {
		this.isSignYht = isSignYht;
	}

	public StdPayContractForm(){
	}

	public StdPayContractForm(String orgId){
		this.orgId = orgId;
	}

	
	public void setOrgId(String orgId){
		this.orgId = orgId;
	}
	public String getOrgId(){
		return orgId;
	}
	
	public void setOrgName(String orgName){
		this.orgName = orgName;
	}
	public String getOrgName(){
		return orgName;
	}
	
	public void setOrgType(Integer orgType){
		this.orgType = orgType;
	}
	public Integer getOrgType(){
		return orgType;
	}
	
	public void setGatherTag(Integer gatherTag){
		this.gatherTag = gatherTag;
	}
	public Integer getGatherTag(){
		return gatherTag;
	}
	
	public void setBankBasicAccount(String bankBasicAccount){
		this.bankBasicAccount = bankBasicAccount;
	}
	public String getBankBasicAccount(){
		return bankBasicAccount;
	}
	
	public void setBankBasicName(String bankBasicName){
		this.bankBasicName = bankBasicName;
	}
	public String getBankBasicName(){
		return bankBasicName;
	}
	
	public void setBankBasicBankname(String bankBasicBankname){
		this.bankBasicBankname = bankBasicBankname;
	}
	public String getBankBasicBankname(){
		return bankBasicBankname;
	}
	
	public void setBankLoanAccount(String bankLoanAccount){
		this.bankLoanAccount = bankLoanAccount;
	}
	public String getBankLoanAccount(){
		return bankLoanAccount;
	}
	
	public void setBankLoanName(String bankLoanName){
		this.bankLoanName = bankLoanName;
	}
	public String getBankLoanName(){
		return bankLoanName;
	}
	
	public void setBankLoanBankname(String bankLoanBankname){
		this.bankLoanBankname = bankLoanBankname;
	}
	public String getBankLoanBankname(){
		return bankLoanBankname;
	}
	
	public void setBankSubmitState(Integer bankSubmitState){
		this.bankSubmitState = bankSubmitState;
	}
	public Integer getBankSubmitState(){
		return bankSubmitState;
	}
	
	public void setBankSubmitUserId(String bankSubmitUserId){
		this.bankSubmitUserId = bankSubmitUserId;
	}
	public String getBankSubmitUserId(){
		return bankSubmitUserId;
	}
	
	public void setBankSubmitUserName(String bankSubmitUserName){
		this.bankSubmitUserName = bankSubmitUserName;
	}
	public String getBankSubmitUserName(){
		return bankSubmitUserName;
	}
	
	public void setBankSubmitTime(Date bankSubmitTime){
		this.bankSubmitTime = bankSubmitTime;
	}
	public Date getBankSubmitTime(){
		return bankSubmitTime;
	}
	
	public void setBankAuditFirstState(Integer bankAuditFirstState){
		this.bankAuditFirstState = bankAuditFirstState;
	}
	public Integer getBankAuditFirstState(){
		return bankAuditFirstState;
	}
	
	public void setBankAuditFirstUserId(String bankAuditFirstUserId){
		this.bankAuditFirstUserId = bankAuditFirstUserId;
	}
	public String getBankAuditFirstUserId(){
		return bankAuditFirstUserId;
	}
	
	public void setBankAuditFirstUserName(String bankAuditFirstUserName){
		this.bankAuditFirstUserName = bankAuditFirstUserName;
	}
	public String getBankAuditFirstUserName(){
		return bankAuditFirstUserName;
	}
	
	public void setBankAuditFirstTime(Date bankAuditFirstTime){
		this.bankAuditFirstTime = bankAuditFirstTime;
	}
	public Date getBankAuditFirstTime(){
		return bankAuditFirstTime;
	}
	
	public void setBankAuditSecondState(Integer bankAuditSecondState){
		this.bankAuditSecondState = bankAuditSecondState;
	}
	public Integer getBankAuditSecondState(){
		return bankAuditSecondState;
	}
	
	public void setBankAuditSecondUserId(String bankAuditSecondUserId){
		this.bankAuditSecondUserId = bankAuditSecondUserId;
	}
	public String getBankAuditSecondUserId(){
		return bankAuditSecondUserId;
	}
	
	public void setBankAuditSecondUserName(String bankAuditSecondUserName){
		this.bankAuditSecondUserName = bankAuditSecondUserName;
	}
	public String getBankAuditSecondUserName(){
		return bankAuditSecondUserName;
	}
	
	public void setBankAuditSecondTime(Date bankAuditSecondTime){
		this.bankAuditSecondTime = bankAuditSecondTime;
	}
	public Date getBankAuditSecondTime(){
		return bankAuditSecondTime;
	}
	
	public void setFinanceContactPerson(String financeContactPerson){
		this.financeContactPerson = financeContactPerson;
	}
	public String getFinanceContactPerson(){
		return financeContactPerson;
	}
	
	public void setBankBasicAccountAudit(String bankBasicAccountAudit){
		this.bankBasicAccountAudit = bankBasicAccountAudit;
	}
	public String getBankBasicAccountAudit(){
		return bankBasicAccountAudit;
	}
	
	public void setBankBasicNameAudit(String bankBasicNameAudit){
		this.bankBasicNameAudit = bankBasicNameAudit;
	}
	public String getBankBasicNameAudit(){
		return bankBasicNameAudit;
	}
	
	public void setBankBasicBanknameAudit(String bankBasicBanknameAudit){
		this.bankBasicBanknameAudit = bankBasicBanknameAudit;
	}
	public String getBankBasicBanknameAudit(){
		return bankBasicBanknameAudit;
	}
	
	public void setBankLoanAccountAudit(String bankLoanAccountAudit){
		this.bankLoanAccountAudit = bankLoanAccountAudit;
	}
	public String getBankLoanAccountAudit(){
		return bankLoanAccountAudit;
	}
	
	public void setBankLoanNameAudit(String bankLoanNameAudit){
		this.bankLoanNameAudit = bankLoanNameAudit;
	}
	public String getBankLoanNameAudit(){
		return bankLoanNameAudit;
	}
	
	public void setBankLoanBanknameAudit(String bankLoanBanknameAudit){
		this.bankLoanBanknameAudit = bankLoanBanknameAudit;
	}
	public String getBankLoanBanknameAudit(){
		return bankLoanBanknameAudit;
	}
	
	public void setGatherTagAudit(Integer gatherTagAudit){
		this.gatherTagAudit = gatherTagAudit;
	}
	public Integer getGatherTagAudit(){
		return gatherTagAudit;
	}
	
	public void setIsNeedSync(Integer isNeedSync){
		this.isNeedSync = isNeedSync;
	}
	public Integer getIsNeedSync(){
		return isNeedSync;
	}
	
	public void setIsBalance(Integer isBalance){
		this.isBalance = isBalance;
	}
	public Integer getIsBalance(){
		return isBalance;
	}
	
	public void setFinanceContactTel(String financeContactTel){
		this.financeContactTel = financeContactTel;
	}
	public String getFinanceContactTel(){
		return financeContactTel;
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
	
	public void setAgreeTime(Date agreeTime){
		this.agreeTime = agreeTime;
	}
	public Date getAgreeTime(){
		return agreeTime;
	}
	
	public void setAgreeUserId(String agreeUserId){
		this.agreeUserId = agreeUserId;
	}
	public String getAgreeUserId(){
		return agreeUserId;
	}
	
	public void setAgreeUserName(String agreeUserName){
		this.agreeUserName = agreeUserName;
	}
	public String getAgreeUserName(){
		return agreeUserName;
	}
	
	public void setIp4(String ip4){
		this.ip4 = ip4;
	}
	public String getIp4(){
		return ip4;
	}

}