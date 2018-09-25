package com.hsnn.medstgmini.base.std.model;

public enum ExcelType {

	stdCataProdRelFile(1, "stdCataProdRelFile");

	private int key;
	private String value;

	private ExcelType(int key, String value) {
		this.key = key;
		this.value = value;
	}

	public static String getName(int key) {
		for (ExcelType it : ExcelType.values()) {
			if (it.key == key) {
				return it.value;
			}
		}
		return "";
	}

	public static ExcelType getUserType(int key) {
		for (ExcelType it : ExcelType.values()) {
			if (it.key == key) {
				return it;
			}
		}
		return null;
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
