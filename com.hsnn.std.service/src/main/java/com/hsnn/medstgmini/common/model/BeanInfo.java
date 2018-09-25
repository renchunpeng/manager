package com.hsnn.medstgmini.common.model;

public class BeanInfo {
	private String beanName;// 类名
	private String fullBeanName;// 全路劲类名
	private String tableName;// 表名

	public String getBeanName() {
		return beanName;
	}

	public void setBeanName(String beanName) {
		this.beanName = beanName;
	}

	public String getFullBeanName() {
		return fullBeanName;
	}

	public void setFullBeanName(String fullBeanName) {
		this.fullBeanName = fullBeanName;
	}

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

}
