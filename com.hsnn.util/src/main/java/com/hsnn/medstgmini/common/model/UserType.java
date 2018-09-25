package com.hsnn.medstgmini.common.model;

import com.hsnn.medstgmini.util.enums.ICommonEnum;

/**
 * @category 用户类型
 * @author CCL
 *
 */
public enum UserType implements ICommonEnum<Integer>{

	scqy(1,"生产企业"),jkzx(4,"疾控中心"),cgzx(5,"采购中心"),wsj(6,"卫生局");
	private int key;
	private String value;

	private UserType(int key, String value) {
		this.key = key;
		this.value = value;
	}

	public static String getName(int key) {
		for (UserType ut : UserType.values()) {
			if (ut.key == key) {
				return ut.value;
			}
		}
		return "";
	}

	public static UserType getUserType(int key) {
		for (UserType ut : UserType.values()) {
			if (ut.key == key) {
				return ut;
			}
		}
		return null;
	}

	public Integer getKey() {
		return key;
	}

	public void setKey(Integer key) {
		this.key = key;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}
