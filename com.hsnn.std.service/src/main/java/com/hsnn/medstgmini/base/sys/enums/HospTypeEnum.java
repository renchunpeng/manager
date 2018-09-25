/**
 * 上午11:35:31
 */
package com.hsnn.medstgmini.base.sys.enums;

import com.hsnn.medstgmini.util.enums.ICommonEnum;

/**
 * @author hsnn
 * 医院等级枚举类
 */
public enum HospTypeEnum implements ICommonEnum<Object> {
	Type1Grade1("0", "基层"),
	Type1Grade2("1", "县级及县以上");
//	Type1Grade3("3", "城市");

	private String key;
	private String value;
	
	private HospTypeEnum(String key, String value) {
		this.key = key;
		this.value = value;
	}
	public static String getName(String key) {
		if (key != null && !"".equals(key)) {
			for (HospTypeEnum hospType : HospTypeEnum.values()) {
				if (key.equals(hospType.key)) {
					return hospType.value;
				}
			}
		}
		return "";
	}
	@Override
	public String getKey() {
		return this.key;
	}

	@Override
	public String getValue() {
		return this.value;
	}

}
