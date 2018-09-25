package com.hsnn.medstgmini.base.sys.model;

import java.io.Serializable;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;



/**
 *
 * @Since 2010-2016
 * @Description: TODO
 * @author zhou.xy
 * @date 2016-02-19 10:49:37
 *
 */
public class SysResource implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((addTime == null) ? 0 : addTime.hashCode());
		result = prime * result
				+ ((addUserId == null) ? 0 : addUserId.hashCode());
		result = prime * result
				+ ((addUserName == null) ? 0 : addUserName.hashCode());
		result = prime * result + ((checked == null) ? 0 : checked.hashCode());
		result = prime * result
				+ ((children == null) ? 0 : children.hashCode());
		result = prime * result + ((icon == null) ? 0 : icon.hashCode());
		result = prime * result + ((isUsing == null) ? 0 : isUsing.hashCode());
		result = prime * result
				+ ((lastUpdateTime == null) ? 0 : lastUpdateTime.hashCode());
		result = prime
				* result
				+ ((lastUpdateUserId == null) ? 0 : lastUpdateUserId.hashCode());
		result = prime
				* result
				+ ((lastUpdateUserName == null) ? 0 : lastUpdateUserName
						.hashCode());
		result = prime * result
				+ ((menuName == null) ? 0 : menuName.hashCode());
		result = prime
				* result
				+ ((parentResourceId == null) ? 0 : parentResourceId.hashCode());
		result = prime * result
				+ ((resourceId == null) ? 0 : resourceId.hashCode());
		result = prime * result
				+ ((resourceName == null) ? 0 : resourceName.hashCode());
		result = prime * result
				+ ((resourceStyle == null) ? 0 : resourceStyle.hashCode());
		result = prime * result
				+ ((resourceType == null) ? 0 : resourceType.hashCode());
		result = prime * result
				+ ((resourceUrl == null) ? 0 : resourceUrl.hashCode());
		result = prime * result + ((sort == null) ? 0 : sort.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SysResource other = (SysResource) obj;
		if (addTime == null) {
			if (other.addTime != null)
				return false;
		} else if (!addTime.equals(other.addTime))
			return false;
		if (addUserId == null) {
			if (other.addUserId != null)
				return false;
		} else if (!addUserId.equals(other.addUserId))
			return false;
		if (addUserName == null) {
			if (other.addUserName != null)
				return false;
		} else if (!addUserName.equals(other.addUserName))
			return false;
		if (checked == null) {
			if (other.checked != null)
				return false;
		} else if (!checked.equals(other.checked))
			return false;
		if (children == null) {
			if (other.children != null)
				return false;
		} else if (!children.equals(other.children))
			return false;
		if (icon == null) {
			if (other.icon != null)
				return false;
		} else if (!icon.equals(other.icon))
			return false;
		if (isUsing == null) {
			if (other.isUsing != null)
				return false;
		} else if (!isUsing.equals(other.isUsing))
			return false;
		if (lastUpdateTime == null) {
			if (other.lastUpdateTime != null)
				return false;
		} else if (!lastUpdateTime.equals(other.lastUpdateTime))
			return false;
		if (lastUpdateUserId == null) {
			if (other.lastUpdateUserId != null)
				return false;
		} else if (!lastUpdateUserId.equals(other.lastUpdateUserId))
			return false;
		if (lastUpdateUserName == null) {
			if (other.lastUpdateUserName != null)
				return false;
		} else if (!lastUpdateUserName.equals(other.lastUpdateUserName))
			return false;
		if (menuName == null) {
			if (other.menuName != null)
				return false;
		} else if (!menuName.equals(other.menuName))
			return false;
		if (parentResourceId == null) {
			if (other.parentResourceId != null)
				return false;
		} else if (!parentResourceId.equals(other.parentResourceId))
			return false;
		if (resourceId == null) {
			if (other.resourceId != null)
				return false;
		} else if (!resourceId.equals(other.resourceId))
			return false;
		if (resourceName == null) {
			if (other.resourceName != null)
				return false;
		} else if (!resourceName.equals(other.resourceName))
			return false;
		if (resourceStyle == null) {
			if (other.resourceStyle != null)
				return false;
		} else if (!resourceStyle.equals(other.resourceStyle))
			return false;
		if (resourceType == null) {
			if (other.resourceType != null)
				return false;
		} else if (!resourceType.equals(other.resourceType))
			return false;
		if (resourceUrl == null) {
			if (other.resourceUrl != null)
				return false;
		} else if (!resourceUrl.equals(other.resourceUrl))
			return false;
		if (sort == null) {
			if (other.sort != null)
				return false;
		} else if (!sort.equals(other.sort))
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		return true;
	}

	//alias
	public static final String TABLE_ALIAS = "SysResource";
	
	//columns START
	/**
	 * @Fields resourceId:资源编号
	 */
	private Integer resourceId;
	
	/**
	 * @Fields parentResourceId:父资源编号
	 */
	private Integer parentResourceId;
	
	/**
	 * @Fields resourceName:资源名称
	 */
	private String resourceName;
	/**
	 * @Fields menuName:菜单名称
	 */
	private String menuName;
	
	/**
	 * @Fields resourceStyle:菜单样式
	 */
	private String resourceStyle;
	
	/**
	 * @Fields resourceUrl:菜单路径
	 */
	private String resourceUrl;
	
	/**
	 * @Fields resourceType:0.其他 1.系统 2.模块 3.菜单
	 */
	private Integer resourceType;
	
	/**
	 * @Fields icon:权限图标
	 */
	private String icon;
	
	/**
	 * @Fields isUsing:isUsing
	 */
	private Integer isUsing;
	
	/**
	 * @Fields sort:排序(0，1，2，3，4，5...)
	 */
	private Integer sort;
	
	/**
	 * @Fields type:类型(0:药品,1:耗材)
	 */
	private Integer type;
	
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
	
	private List<SysResource> children;
	
	private Integer checked;
	
	//columns END

	public SysResource(){
	}

	public SysResource(Integer resourceId){
		this.resourceId = resourceId;
	}

	
	public void setResourceId(Integer resourceId){
		this.resourceId = resourceId;
	}
	
	public Integer getResourceId(){
		return resourceId;
	}
	
	public void setParentResourceId(Integer parentResourceId){
		this.parentResourceId = parentResourceId;
	}
	
	public Integer getParentResourceId(){
		return parentResourceId;
	}
	
	public void setResourceName(String resourceName){
		this.resourceName = resourceName;
	}
	
	public String getResourceName(){
		return resourceName;
	}
	
	public void setResourceStyle(String resourceStyle){
		this.resourceStyle = resourceStyle;
	}
	
	public String getResourceStyle(){
		return resourceStyle;
	}
	
	public void setResourceUrl(String resourceUrl){
		this.resourceUrl = resourceUrl;
	}
	
	public String getResourceUrl(){
		return resourceUrl;
	}
	
	public void setIcon(String icon){
		this.icon = icon;
	}
	
	public String getIcon(){
		return icon;
	}
	
	public void setIsUsing(Integer isUsing){
		this.isUsing = isUsing;
	}
	
	public Integer getIsUsing(){
		return isUsing;
	}
	
	public void setSort(Integer sort){
		this.sort = sort;
	}
	
	public Integer getSort(){
		return sort;
	}
	
	public void setType(Integer type){
		this.type = type;
	}
	
	public Integer getType(){
		return type;
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

	public List<SysResource> getChildren() {
		return children;
	}

	public void setChildren(List<SysResource> children) {
		this.children = children;
	}
	
	public void addChild(SysResource resource) {
		if (resource != null) {
			if (children == null) {
				children = new LinkedList<SysResource>();
			}
			children.add(resource);
		}
	}

	public Integer getResourceType() {
		return resourceType;
	}

	public void setResourceType(Integer resourceType) {
		this.resourceType = resourceType;
	}

	public Integer getChecked() {
		return checked;
	}

	public void setChecked(Integer checked) {
		this.checked = checked;
	}

	public String getMenuName() {
		return menuName;
	}

	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}
	
	
}