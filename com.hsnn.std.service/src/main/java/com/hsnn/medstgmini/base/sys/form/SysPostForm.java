package com.hsnn.medstgmini.base.sys.form;

import java.util.Date;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.*;
import org.springframework.format.annotation.DateTimeFormat;

import com.hsnn.medstgmini.util.validate.AnnExtist;

/**
 *
 * @Since 2010-2016
 * @Description: TODO
 * @author zhou.xy
 * @date 2016-02-19 10:49:37
 *
 */
public class SysPostForm  {

	//columns START
	
	/**
	 * @Fields post_id:岗位id
	 */
	@NotNull(message = "请填写岗位id")
	@Range(message = "数值范围不正确")
	private Integer postId;
	
	/**
	 * @Fields post_name:岗位名称
	 */
	@Length(max = 255, message = "岗位名称的长度不能超过{1}")
	@NotNull(message = "请填写岗位名称")
	@AnnExtist(url="/SysPost/extist.html",params="departmentId,postId",message="岗位已经存在！")
	private String postName;
	
	/**
	 * @Fields department_id:部门id
	 */
	@Range(message = "数值范围不正确")
	private Integer departmentId;
	
	/**
	 * @Fields is_using:是否启用
	 */
	@Range(message = "数值范围不正确")
	private Integer isUsing;
	
	/**
	 * @Fields add_user_id:记录添加人id
	 */
	@Length(max = 36, message = "记录添加人id的长度不能超过{1}")
	private String addUserId;
	
	/**
	 * @Fields add_user_name:记录添加人
	 */
	@Length(max = 256, message = "记录添加人的长度不能超过{1}")
	private String addUserName;
	
	/**
	 * @Fields add_time:记录添加时间
	 */
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date addTime;
	
	/**
	 * @Fields last_update_user_id:最后一次更新记录人id
	 */
	@Length(max = 36, message = "最后一次更新记录人id的长度不能超过{1}")
	private String lastUpdateUserId;
	
	/**
	 * @Fields last_update_user_name:最后一次更新记录人
	 */
	@Length(max = 256, message = "最后一次更新记录人的长度不能超过{1}")
	private String lastUpdateUserName;
	
	/**
	 * @Fields last_update_time:最后一次更新记录时间
	 */
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date lastUpdateTime;
	//columns END
	

	public SysPostForm(){
	}

	public SysPostForm(Integer postId){
		this.postId = postId;
	}

	
	public void setPostId(Integer postId){
		this.postId = postId;
	}
	public Integer getPostId(){
		return postId;
	}
	
	public void setPostName(String postName){
		this.postName = postName;
	}
	public String getPostName(){
		return postName;
	}
	
	public void setDepartmentId(Integer departmentId){
		this.departmentId = departmentId;
	}
	public Integer getDepartmentId(){
		return departmentId;
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

}