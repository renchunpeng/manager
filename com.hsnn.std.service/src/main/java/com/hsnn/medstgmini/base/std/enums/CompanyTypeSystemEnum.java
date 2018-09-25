package com.hsnn.medstgmini.base.std.enums;

import com.hsnn.medstgmini.util.enums.ICommonEnum;

public enum CompanyTypeSystemEnum implements ICommonEnum<Integer> {
	
	DRUG(1, "药品"), 
	SUPPLIES(2, "耗材"),
	DRUGSUPPLIES(3, "药品和耗材");

	private final Integer key;
	private final String value;
	
	private CompanyTypeSystemEnum(int key, String value) {
		this.key = key;
		this.value = value;
	}
	public static String getName(Integer key) {
		if (key != null && !"".equals(key)) {
			for (GmpGspStatus gmpGspStatus : GmpGspStatus.values()) {
				if (key == gmpGspStatus.getKey()) {
					return gmpGspStatus.getValue();
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
