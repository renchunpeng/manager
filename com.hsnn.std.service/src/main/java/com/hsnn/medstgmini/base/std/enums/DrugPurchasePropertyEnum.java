package com.hsnn.medstgmini.base.std.enums;

import com.hsnn.medstgmini.util.enums.ICommonEnum;

/**
 * 否基层医疗机构
 * @author he.fan
 *
 */
public enum DrugPurchasePropertyEnum implements ICommonEnum{
	

	THECOUNTY(0, "县及县以上"),
	GRASSROOTS(1, "基层");

	private Integer key;
	private String value;
	
	private DrugPurchasePropertyEnum(Integer key, String value) {
		this.key = key;
		this.value = value;
	}
	public static String getName(String key) {
		if (key != null && !"".equals(key)) {
			for (DrugPurchasePropertyEnum drugPurchasePropertyEnum : DrugPurchasePropertyEnum.values()) {
				if (key.equals(drugPurchasePropertyEnum.key)) {
					return drugPurchasePropertyEnum.value;
				}
			}
		}
		return "";
	}
	@Override
	public Integer getKey() {
		return this.key;
	}

	@Override
	public String getValue() {
		return this.value;
	}

}
