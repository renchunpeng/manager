package com.hsnn.medstgmini.base.std.model;

import java.util.Date;

import com.hsnn.medstgmini.common.model.Attachment;
import com.hsnn.medstgmini.common.model.IAttachment;



/**
 *
 * @Since 2010-2016
 * @Description: TODO
 * @author zhou.xy
 * @date 2016-02-29 14:53:03
 *
 */
public class StdGmpgsp  implements IAttachment<Integer>{
	
	//alias
	public static final String TABLE_ALIAS = "StdGmpgsp";
	
	//columns START
	/**
	 * @Fields id:id
	 */
	private Integer id;
	
	/**
	 * @Fields companyId:企业id
	 */
	private String companyId;
	
	/**
	 * @Fields companyName:企业名称*
	 */
	private String companyName;
	
	/**
	 * @Fields certificateNumber:证书编号*
	 */
	private String certificateNumber;
	
	/**
	 * @Fields address:企业地址*
	 */
	private String address;
	
	/**
	 * @Fields commRange:认证范围*
	 */
	private String commRange;
	
	/**
	 * @Fields certificateAttachmentId:证书附件id
	 */
	private String certificateAttachmentId;
	
	/**
	 * @Fields validStart:发证日期*
	 */
	private Date validStart;
	
	/**是否单独认证*/
	private Integer isSingleCertificate;
	
	/**单独认证项*/
	private String certificateItem;
	
	/**
	 * @Fields validEnd:有效期截止日*
	 */
	private Date validEnd;
	
	/**
	 * @Fields delayedDateEnd:有效期延续至
	 */
	private Date delayedDateEnd;
	
	/**
	 * @Fields type:类型(0:gmp,1:gsp)
	 */
	private Integer type;
	
	/**
	 * @Fields status:0:未审核、1:审核不通过、2:有效、3:无效 、4:已过期、5.已删除
	 */
	private Integer status;
	
	/**
	 * @Fields auditTime:审核时间
	 */
	private Date auditTime;
	
	/**
	 * @Fields auditor:审核人
	 */
	private String auditor;
	
	/**
	 * @Fields auditRemark:审核意见
	 */
	private String auditRemark;
	
	/**
	 * @Fields isusing:是否有效
	 */
	private Boolean isusing;
	
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
	
	private Attachment attachment;

	public StdGmpgsp(){
	}

	public StdGmpgsp(Integer id){
		this.id = id;
	}

	
	public void setId(Integer id){
		this.id = id;
	}
	
	public Integer getId(){
		return id;
	}
	
	public void setCompanyId(String companyId){
		this.companyId = companyId;
	}
	
	public String getCompanyId(){
		return companyId;
	}
	
	public void setCompanyName(String companyName){
		this.companyName = companyName;
	}
	
	public String getCompanyName(){
		return companyName;
	}
	
	public void setCertificateNumber(String certificateNumber){
		this.certificateNumber = certificateNumber;
	}
	
	public String getCertificateNumber(){
		return certificateNumber;
	}
	
	public void setAddress(String address){
		this.address = address;
	}
	
	public String getAddress(){
		return address;
	}
	
	public void setCommRange(String commRange){
		this.commRange = commRange;
	}
	
	public String getCommRange(){
		return commRange;
	}
	
	public void setCertificateAttachmentId(String certificateAttachmentId){
		this.certificateAttachmentId = certificateAttachmentId;
	}
	
	public String getCertificateAttachmentId(){
		return certificateAttachmentId;
	}
	
	public void setValidStart(Date validStart){
		this.validStart = validStart;
	}
	
	public Date getValidStart(){
		return validStart;
	}
	
	public void setValidEnd(Date validEnd){
		this.validEnd = validEnd;
	}
	
	public Date getValidEnd(){
		return validEnd;
	}
	
	public void setDelayedDateEnd(Date delayedDateEnd){
		this.delayedDateEnd = delayedDateEnd;
	}
	
	public Date getDelayedDateEnd(){
		return delayedDateEnd;
	}
	
	public void setType(Integer type){
		this.type = type;
	}
	
	public Integer getType(){
		return type;
	}
	
	public void setStatus(Integer status){
		this.status = status;
	}
	
	public Integer getStatus(){
		return status;
	}
	
	public void setAuditTime(Date auditTime){
		this.auditTime = auditTime;
	}
	
	public Date getAuditTime(){
		return auditTime;
	}
	
	public void setAuditor(String auditor){
		this.auditor = auditor;
	}
	
	public String getAuditor(){
		return auditor;
	}
	
	public void setAuditRemark(String auditRemark){
		this.auditRemark = auditRemark;
	}
	
	public String getAuditRemark(){
		return auditRemark;
	}
	
	public void setIsusing(Boolean isusing){
		this.isusing = isusing;
	}
	
	public Boolean getIsusing(){
		return isusing;
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

	public Integer getIsSingleCertificate() {
		return isSingleCertificate;
	}

	public void setIsSingleCertificate(Integer isSingleCertificate) {
		this.isSingleCertificate = isSingleCertificate;
	}

	public String getCertificateItem() {
		return certificateItem;
	}

	public void setCertificateItem(String certificateItem) {
		this.certificateItem = certificateItem;
	}
	@Override
	public Attachment getAttachment() {
		return attachment;
	}

	public void setAttachment(Attachment attachment) {
		this.attachment = attachment;
	}

}