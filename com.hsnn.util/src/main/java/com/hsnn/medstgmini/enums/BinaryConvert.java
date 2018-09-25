package com.hsnn.medstgmini.enums;

import com.hsnn.medstgmini.util.enums.ICommonEnum;

public enum BinaryConvert implements com.hsnn.medstgmini.util.enums.ICommonEnum<Integer> {
	AUDIT_NOT_FINISHED(0, "没有审核完"),
	AUDIT_PASS(1, "审核通过"),
	AUDIT_NOT_THROUGH(2, "审核不通过"),
	ERROR(-1, "参数错误");

	private int key;
	private String value;

	private BinaryConvert(int key, String value) {
		this.key = key;
		this.value = value;
	}

	@Override
	public Integer getKey() {
		return this.key;
	}

	@Override
	public String getValue() {
		return this.value;
	}

	public static String getValueByKey(Integer key) {
		for (com.hsnn.medstgmini.util.enums.ICommonEnum<Integer> item : values()) {
			if (item.getKey() == key) {
				return item.getValue();
			}
		}
		return null;
	}

	public static Integer getKeyByValue(String value) {
		for (ICommonEnum<Integer> item : values()) {
			if (item.getValue().equals(value)) {
				return (Integer) item.getKey();
			}
		}
		return null;
	}

	public static Integer getKeyByItemName(String itemName) {
		Integer res = null;
		try {
			res = valueOf(itemName).getKey();
		} catch (IllegalArgumentException | NullPointerException e) {
		}
		return res;
	}

}
