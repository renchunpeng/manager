package com.hsnn.medstgmini.base.std.enums;

import com.hsnn.medstgmini.util.enums.ICommonEnum;


public enum CompanyTypeEnum implements ICommonEnum<Integer> {
	
	TB(1, "生产企业"),
	PS(2, "配送企业"),
	TP(3, "生产兼代理企业"),
	D(20, "代理企业");

	private final Integer key;
	private final String value;
	
	private CompanyTypeEnum(Integer key, String value) {
		this.key = key;
		this.value = value;
	}
	public static String getName(String key) {
		if (key != null && !"".equals(key)) {
			for (CompanyTypeEnum clearState : CompanyTypeEnum.values()) {
				if (key.equals(clearState.key)) {
					return clearState.value;
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
