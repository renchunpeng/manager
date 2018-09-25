package com.hsnn.medstgmini.base.std.form;

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
 * @date 2016-03-01 10:31:04
 *
 */
public class StdDictForm  {

	//columns START
	
	/**
	 * @Fields id:id
	 */
	@NotNull(message = "请填写id")
	@Range(message = "数值范围不正确")
	private Integer id;
	
	/**
	 * @Fields parent_id:parentId
	 */
	@NotNull(message = "请填写parentId")
	@Range(message = "数值范围不正确")
	private Integer parentId;
	
	/**
	 * @Fields dictionary_key:键
	 */
	@AnnExtist(message="键已存在!",url="/stdDict/checkRepeat.html",params="type,id")
	@NotEmpty(message = "请填写键",groups={First.class})
	@Length(max = 36, message = "键的长度不能超过{1}",groups={First.class})
	private String dictionaryKey;
	
	/**
	 * @Fields dictionary_value:值
	 */
	@AnnExtist(message="值已存在!",url="/stdDict/checkRepeat.html",params="type,id")
	@NotEmpty(message = "请填写值",groups={First.class})
	@Length(max = 256, message = "值的长度不能超过{1}",groups={First.class})
	private String dictionaryValue;
	
	/**
	 * @Fields classify:名称（用户标识属于何类字典,如“地区”，“单位”等）
	 */
	@Length(max = 36, message = "分类编码的长度不能超过{1}")
	private String classify;
	
	/**
	 * @Fields classifyName:名称（用户标识属于何类字典,如“地区”，“单位”等）
	 */
	@Length(max = 256, message = "名称（用户标识属于何类字典,如“地区”，“单位”等）的长度不能超过{1}")
	private String classifyName;
	
	/**
	 * @Fields type:名称（用户标识属于何类字典,如“地区”，“单位”等）
	 */
	@Length(max = 36, message = "名称（用户标识属于何类字典,如“地区”，“单位”等）的长度不能超过{1}")
	private String type;
	
	/**
	 * @Fields sort:排序
	 */
	@NotNull(message = "请填写排序")
	@Range(message = "排序必须为数字")
	private Integer sort;
	
	/**
	 * @Fields is_using:删除标识
	 */
	@NotNull(message = "请填写删除标识")
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
	@NotEmpty(message="最后一次更新记录人")
	private String lastUpdateUserId;
	
	/**
	 * @Fields last_update_user_name:最后一次更新记录人
	 */
	@Length(max = 256, message = "最后一次更新记录人的长度不能超过{1}")
	@NotNull(message="最后一次更新记录人")
	private String lastUpdateUserName;
	
	/**
	 * @Fields last_update_time:最后一次更新记录时间
	 */
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date lastUpdateTime;
	//columns END
	

	public StdDictForm(){
	}

	public StdDictForm(Integer id){
		this.id = id;
	}

	
	public void setId(Integer id){
		this.id = id;
	}
	public Integer getId(){
		return id;
	}
	
	public void setParentId(Integer parentId){
		this.parentId = parentId;
	}
	public Integer getParentId(){
		return parentId;
	}
	
	public void setDictionaryKey(String dictionaryKey){
		this.dictionaryKey = dictionaryKey;
	}
	public String getDictionaryKey(){
		return dictionaryKey;
	}
	
	public void setDictionaryValue(String dictionaryValue){
		this.dictionaryValue = dictionaryValue;
	}
	public String getDictionaryValue(){
		return dictionaryValue;
	}
	
	public String getClassify() {
		return classify;
	}

	public void setClassify(String classify) {
		this.classify = classify;
	}

	public String getClassifyName() {
		return classifyName;
	}

	public void setClassifyName(String classifyName) {
		this.classifyName = classifyName;
	}
	
	public void setType(String type){
		this.type = type;
	}
	public String getType(){
		return type;
	}
	
	public void setSort(Integer sort){
		this.sort = sort;
	}
	public Integer getSort(){
		return sort;
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
	public interface First {  
	}
}

