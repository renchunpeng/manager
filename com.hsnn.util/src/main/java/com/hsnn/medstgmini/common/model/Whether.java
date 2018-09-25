package com.hsnn.medstgmini.common.model;

/**
 * @category 是否
 * @author 蔡春龙
 * @date 2015年6月14日
 */
public enum Whether {

	no(0, "否"), yes(1, "是"), unknown(9, "未知");

	private int key;
	private String value;

	private Whether(int key, String value) {
		this.key = key;
		this.value = value;
	}

	public static String getName(int key) {
		for (Whether w : Whether.values()) {
			if (w.key == key) {
				return w.value;
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
