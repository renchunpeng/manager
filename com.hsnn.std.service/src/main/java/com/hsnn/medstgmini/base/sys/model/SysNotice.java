package com.hsnn.medstgmini.base.sys.model;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.hsnn.medstgmini.base.sys.enums.NoticeStatus;
import com.hsnn.medstgmini.util.compile.Enums;
import com.hsnn.medstgmini.util.compile.KeywordsAnnotation;
import com.hsnn.medstgmini.util.compile.PropertyNameAnnotation;



/**
 *
 * @Since 2010-2016
 * @Description: TODO
 * @author zhou.xy
 * @date 2016-03-04 14:32:11
 *
 */
public class SysNotice  implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	//alias
	public static final String TABLE_ALIAS = "SysNotice";
	
	//columns START
	/**
	 * @Fields sysNoticeId:公告ID
	 */
	@PropertyNameAnnotation(annotation="公告ID")
	private String sysNoticeId;
	
	/**
	 * @Fields sysNoticeCode:公告编码
	 */
	@PropertyNameAnnotation(annotation="公告编码")
	private String sysNoticeCode;
	
	/**
	 * @Fields title:公告标题
	 */
	@KeywordsAnnotation(annotation="公告标题")
	@PropertyNameAnnotation(annotation="公告标题")
	private String title;
	
	/**
	 * @Fields org:公告组织
	 */
	@PropertyNameAnnotation(annotation="公告组织")
	private String UserType;
	
	/**
	 * @Fields content:公告内容
	 */
	@PropertyNameAnnotation(annotation="公告内容")
	private String content;
	
	/**
	 * @Fields datetime:公告时间
	 */
	@PropertyNameAnnotation(annotation="公告时间")
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date datetime;
	
	/**
	 * @Fields status:状态0新建1发布
	 */
	@Enums(enumClz=NoticeStatus.class,name="状态")
	private Integer status;
	
	/**
	 * @Fields readCount:阅读次数
	 */
	@PropertyNameAnnotation(annotation="阅读次数")
	private Integer readCount;
	
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
	
	//columns END

	public SysNotice(){
	}

	public SysNotice(String sysNoticeId){
		this.sysNoticeId = sysNoticeId;
	}

	
	public void setSysNoticeId(String sysNoticeId){
		this.sysNoticeId = sysNoticeId;
	}
	
	public String getSysNoticeId(){
		return sysNoticeId;
	}
	
	public void setSysNoticeCode(String sysNoticeCode){
		this.sysNoticeCode = sysNoticeCode;
	}
	
	public String getSysNoticeCode(){
		return sysNoticeCode;
	}
	
	public void setTitle(String title){
		this.title = title;
	}
	
	public String getTitle(){
		return title;
	}
	
	public String getUserType() {
		return UserType;
	}

	public void setUserType(String userType) {
		UserType = userType;
	}

	public void setContent(String content){
		this.content = content;
	}
	
	public String getContent(){
		return content;
	}
	
	public void setDatetime(Date datetime){
		this.datetime = datetime;
	}
	
	public Date getDatetime(){
		return datetime;
	}
	
	public void setStatus(Integer status){
		this.status = status;
	}
	
	public Integer getStatus(){
		return status;
	}
	
	public void setReadCount(Integer readCount){
		this.readCount = readCount;
	}
	
	public Integer getReadCount(){
		return readCount;
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