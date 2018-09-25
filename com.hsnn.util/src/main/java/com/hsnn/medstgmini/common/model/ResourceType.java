package com.hsnn.medstgmini.common.model;

/**
 * @category 权限类型
 * @author CCL
 *
 */
public enum ResourceType {

	system(1, "系统"), module(2, "模块"), menu(3, "菜单"), button(4, "按钮"), other(0, "其他");

	private int key;
	private String value;

	private ResourceType(int key, String value) {
		this.key = key;
		this.value = value;
	}

	public static String getName(int key) {
		for (ResourceType pt : ResourceType.values()) {
			if (pt.key == key) {
				return pt.value;
			}
		}
		return "";
	}

	public int getKey() {
		return key;
	}

	public void setKey(int key) {
		this.key = key;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}
