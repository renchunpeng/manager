package com.hsnn.medstgmini.util.enums;

public enum CEAuditStatus implements ICommonEnum<Integer> {
	NOT_SUBMITTED(0, "未提交"),
	SUBMITTED(1, "已提交"),
	AUDIT_PASS(2, "审核通过"),
	REVISE(3, "修改或补充材料"),
	AUDIT_NOT_THROUGH(4, "审核不通过"),
	LAST_INSTANCE(5, "终审状态"),
	ZXCX(7,"中心撤销");

	private int key;
	private String value;

	private CEAuditStatus(int key, String value) {
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
		for (ICommonEnum<Integer> item : values()) {
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
