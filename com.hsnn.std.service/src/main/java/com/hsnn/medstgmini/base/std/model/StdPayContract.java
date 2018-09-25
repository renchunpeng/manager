package com.hsnn.medstgmini.base.std.model;

import java.util.Date;



import com.hsnn.medstgmini.common.model.ICreateInfo;
import com.hsnn.medstgmini.common.model.IUpdateInfo;

/**
 *
 * @Since 2010-2016
 * @Description: TODO
 * @author ***
 * @date 2016-05-28 15:50:14
 *
 */
public class StdPayContract  implements ICreateInfo, IUpdateInfo{
	
	//alias
	public static final String TABLE_ALIAS = "StdPayContract";
	
	//columns START
	/**
	 * @Fields orgId:orgId
	 */
	private String orgId;
	
	/**
	 * @Fields orgName:orgName
	 */
	private String orgName;
	
	/**
	 * @Fields orgType:orgType
	 */
	private Integer orgType;
	
	/**
	 * @Fields gatherTag:中间归集标志:0.未知、1.建行、2.工行
	 */
	private Integer gatherTag;
	
	/**
	 * @Fields bankBasicAccount:医院显示:基本户账号,企业显示:结算账号
	 */
	private String bankBasicAccount;
	
	/**
	 * @Fields bankBasicName:医院显示:基本户户名,企业显示:结算户名
	 */
	private String bankBasicName;
	
	/**
	 * @Fields bankBasicBankname:开户行
	 */
	private String bankBasicBankname;
	
	/**
	 * @Fields bankLoanAccount:贷款账号
	 */
	private String bankLoanAccount;
	
	/**
	 * @Fields bankLoanName:贷款账号户名
	 */
	private String bankLoanName;
	
	/**
	 * @Fields bankLoanBankname:贷款开户行
	 */
	private String bankLoanBankname;
	
	/**
	 * @Fields bankSubmitState:提交状态:0.未提交、1.已提交(默认0)
	 */
	private Integer bankSubmitState;
	
	/**
	 * @Fields bankSubmitUserId:提交人id
	 */
	private String bankSubmitUserId;
	
	/**
	 * @Fields bankSubmitUserName:提交人
	 */
	private String bankSubmitUserName;
	
	/**
	 * @Fields bankSubmitTime:提交时间
	 */
	private Date bankSubmitTime;
	
	/**
	 * @Fields bankAuditFirstState:初审状态0:默认,1:待初审,2:初审通过,3:初审不通过
	 */
	private Integer bankAuditFirstState;
	
	/**
	 * @Fields bankAuditFirstUserId:初审人id
	 */
	private String bankAuditFirstUserId;
	
	/**
	 * @Fields bankAuditFirstUserName:初审人
	 */
	private String bankAuditFirstUserName;
	
	/**
	 * @Fields bankAuditFirstTime:初审时间
	 */
	private Date bankAuditFirstTime;
	
	/**
	 * @Fields bankAuditSecondState:复审状态0:默认,1:待复审,2:复审通过,3:复审不通过
	 */
	private Integer bankAuditSecondState;
	
	/**
	 * @Fields bankAuditSecondUserId:复审人id
	 */
	private String bankAuditSecondUserId;
	
	/**
	 * @Fields bankAuditSecondUserName:复审人
	 */
	private String bankAuditSecondUserName;
	
	/**
	 * @Fields bankAuditSecondTime:复审时间
	 */
	private Date bankAuditSecondTime;
	
	/**
	 * @Fields financeContactPerson:财务联系人
	 */
	private String financeContactPerson;
	
	/**
	 * @Fields bankBasicAccountAudit:基本户账号审核信息
	 */
	private String bankBasicAccountAudit;
	
	/**
	 * @Fields bankBasicNameAudit:基本户户名审核信息
	 */
	private String bankBasicNameAudit;
	
	/**
	 * @Fields bankBasicBanknameAudit:基本户开户行审核信息
	 */
	private String bankBasicBanknameAudit;
	
	/**
	 * @Fields bankLoanAccountAudit:贷款账号审核信息
	 */
	private String bankLoanAccountAudit;
	
	/**
	 * @Fields bankLoanNameAudit:贷款户名审核信息
	 */
	private String bankLoanNameAudit;
	
	/**
	 * @Fields bankLoanBanknameAudit:贷款开户行审核信息
	 */
	private String bankLoanBanknameAudit;
	
	/**
	 * @Fields gatherTagAudit:中间归集审核标志:0.未知、1.建行、2.工行
	 */
	private Integer gatherTagAudit;
	
	/**
	 * @Fields isNeedSync:是否需要同步(0否，1是)
	 */
	private Integer isNeedSync;
	
	/**
	 * @Fields isBalance:是否结算账号:0.否,1.是
	 */
	private Integer isBalance;
	
	/**
	 * @Fields financeContactTel:财务联系人电话
	 */
	private String financeContactTel;
	
	/**
	 * @Fields addUserId:添加人id
	 */
	private String addUserId;
	
	/**
	 * @Fields addUserName:添加人
	 */
	private String addUserName;
	
	/**
	 * @Fields addTime:添加时间
	 */
	private Date addTime;
	
	/**
	 * @Fields lastUpdateUserId:最后更新人id
	 */
	private String lastUpdateUserId;
	
	/**
	 * @Fields lastUpdateUserName:最后更新人
	 */
	private String lastUpdateUserName;
	
	/**
	 * @Fields lastUpdateTime:最后更新时间
	 */
	private Date lastUpdateTime;
	
	/**
	 * @Fields agreeTime:agreeTime
	 */
	private Date agreeTime;
	
	/**
	 * @Fields agreeUserId:agreeUserId
	 */
	private String agreeUserId;
	
	/**
	 * @Fields agreeUserName:agreeUserName
	 */
	private String agreeUserName;
	
	/**
	 * @Fields ip4:ip4
	 */
	private String ip4;
	
	/**
	 * @Fields hospPayMode:医院支付的方式1网银支付、2一户通支付、3全部
	 */
	private Integer hospPayMode;
	
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

	/**
	 * @Fields financeContactPersonAudit:财务联系人审核
	 */
	private String financeContactPersonAudit;
	
	/**
	 * @Fields financeContactTelAudit:财务联系人电话审核
	 */
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

	private StdCompany stdCompany;
	
	private StdHospital stdHospital; 
	//columns END

	public StdCompany getStdCompany() {
		return stdCompany;
	}

	public void setStdCompany(StdCompany stdCompany) {
		this.stdCompany = stdCompany;
	}

	public StdHospital getStdHospital() {
		return stdHospital;
	}

	public void setStdHospital(StdHospital stdHospital) {
		this.stdHospital = stdHospital;
	}

	public StdPayContract(){
	}

	public StdPayContract(String orgId){
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

	public Integer getHospPayMode() {
		return hospPayMode;
	}

	public void setHospPayMode(Integer hospPayMode) {
		this.hospPayMode = hospPayMode;
	}
}