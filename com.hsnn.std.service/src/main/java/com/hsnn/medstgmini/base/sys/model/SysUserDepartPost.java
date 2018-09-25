package com.hsnn.medstgmini.base.sys.model;
/**
 * @category 部门用户岗位机构实体类
 * @author 韩守松
 * @date 2016年2月20日
 */
public class SysUserDepartPost {
		private String userId;//用户id
		private String orgId;//机构id
		private Integer roleId;//角色id
		private Integer  departmentId;//部门id
		private Integer postId;//岗位id
		private String orgName;//机构名称
		private String orgAddress;//机构地址
		private String orgAreaName;//机构地区名称
		private String departmentName;//部门名称
		private Integer departmentIsUsing;//部门状态
		private String postName;//岗位名称
		private Integer postIsUsing;//岗位状态
		private String userName;//用户名称
		private String name;//姓名
		private Integer userIsUsing;//用户状态
		private String email;//邮箱
		private String phone;//联系电话
		private Integer acctType;//账户类型 0 管理账户  1业务账户
		private Integer isBalance;
		
		
		public String getUserId() {
			return userId;
		}
		public void setUserId(String userId) {
			this.userId = userId;
		}
		public String getOrgId() {
			return orgId;
		}
		public void setOrgId(String orgId) {
			this.orgId = orgId;
		}
		
		public String getOrgAddress() {
			return orgAddress;
		}
		public void setOrgAddress(String orgAddress) {
			this.orgAddress = orgAddress;
		}
		public String getOrgAreaName() {
			return orgAreaName;
		}
		public void setOrgAreaName(String orgAreaName) {
			this.orgAreaName = orgAreaName;
		}
		public Integer getRoleId() {
			return roleId;
		}
		public void setRoleId(Integer roleId) {
			this.roleId = roleId;
		}
		public Integer getDepartmentId() {
			return departmentId;
		}
		public void setDepartmentId(Integer departmentId) {
			this.departmentId = departmentId;
		}
		public Integer getPostId() {
			return postId;
		}
		public void setPostId(Integer postId) {
			this.postId = postId;
		}
		public String getOrgName() {
			return orgName;
		}
		public void setOrgName(String orgName) {
			this.orgName = orgName;
		}
		public String getDepartmentName() {
			return departmentName;
		}
		public void setDepartmentName(String departmentName) {
			this.departmentName = departmentName;
		}
		public Integer getDepartmentIsUsing() {
			return departmentIsUsing;
		}
		public void setDepartmentIsUsing(Integer departmentIsUsing) {
			this.departmentIsUsing = departmentIsUsing;
		}
		public String getPostName() {
			return postName;
		}
		public void setPostName(String postName) {
			this.postName = postName;
		}
		public Integer getPostIsUsing() {
			return postIsUsing;
		}
		public void setPostIsUsing(Integer postIsUsing) {
			this.postIsUsing = postIsUsing;
		}
		
		public String getUserName() {
			return userName;
		}
		public void setUserName(String userName) {
			this.userName = userName;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public Integer getUserIsUsing() {
			return userIsUsing;
		}
		public void setUserIsUsing(Integer userIsUsing) {
			this.userIsUsing = userIsUsing;
		}
		
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public String getPhone() {
			return phone;
		}
		public void setPhone(String phone) {
			this.phone = phone;
		}
		
		public Integer getAcctType() {
			return acctType;
		}
		public void setAcctType(Integer acctType) {
			this.acctType = acctType;
		}
		@Override
		public String toString() {
			return "SysUserDepartPost [userId=" + userId + ", orgId=" + orgId
					+ ", roleId=" + roleId + ", departmentId=" + departmentId
					+ ", postId=" + postId + ", orgName=" + orgName
					+ ", orgAddress=" + orgAddress + ", orgAreaName="
					+ orgAreaName + ", departmentName=" + departmentName
					+ ", departmentIsUsing=" + departmentIsUsing
					+ ", postName=" + postName + ", postIsUsing=" + postIsUsing
					+ ", name=" + name +", userName=" + userName + ", userIsUsing=" + userIsUsing
					+ ", email=" + email + ", phone=" + phone + ", acctType="
					+ acctType + "]";
		}
		public Integer getIsBalance() {
			return isBalance;
		}
		public void setIsBalance(Integer isBalance) {
			this.isBalance = isBalance;
		}

		
}
