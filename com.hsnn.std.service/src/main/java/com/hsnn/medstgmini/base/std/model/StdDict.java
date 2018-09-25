package com.hsnn.medstgmini.base.std.model;

import java.io.Serializable;
import java.util.Date;



/**
 *
 * @Since 2010-2016
 * @Description: TODO
 * @author zhou.xy
 * @date 2016-03-01 10:31:04
 *
 */
public class StdDict  implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	//alias
	public static final String TABLE_ALIAS = "StdDict";
	private  String ndictId;
	
	//columns START
	/**
	 * @Fields id:id
	 */
	private Integer id;
	
	/**
	 * @Fields parentId:parentId
	 */
	private Integer parentId;
	
	/**
	 * @Fields dictionaryKey:键
	 */
	private String dictionaryKey;
	
	/**
	 * @Fields dictionaryValue:值
	 */
	private String dictionaryValue;
	
	/**
	 * @Fields classify:分类编码
	 */
	private String classify;
	
	/**
	 * @Fields classifyName:分类名称（字典所属的种类，如“医院”,"专家","企业"等）
	 */
	private String classifyName;
	
	/**
	 * @Fields type:名称（用户标识属于何类字典,如“地区”，“单位”等）
	 */
	private String type;
	
	/**
	 * @Fields sort:排序
	 */
	private Integer sort;
	
	/**
	 * @Fields isUsing:删除标识
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
	
	//columns END

	public StdDict(){
	}

	public StdDict(Integer id){
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


	public String getNdictId() {
		return ndictId;
	}

	public void setNdictId(String ndictId) {
		this.ndictId = ndictId;
	}
}