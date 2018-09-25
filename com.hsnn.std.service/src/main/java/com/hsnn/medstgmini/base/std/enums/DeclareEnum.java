package com.hsnn.medstgmini.base.std.enums;

import com.hsnn.medstgmini.util.enums.ICommonEnum;


public enum DeclareEnum implements ICommonEnum<Integer> {

	YPQY(0, "药品企业申报"),
	/*DL(1, "代理企业"), */
	QY(1, "企业申报"),
	YP(2,"药品申报");
	/*SCPS(3, "生产配送企业"),*/
//	SJ(4, "进口药品国内总代理"),
//	SZ(5, "集团子公司生产企业"),
//	SJZ(6, "集团子公司进口代理企业");

	private final Integer key;
	private final String value;

	private DeclareEnum(Integer key, String value) {
		this.key = key;
		this.value = value;
	}
	public static String getName(String key) {
		if (key != null && !"".equals(key)) {
			for (DeclareEnum clearState : DeclareEnum.values()) {
				if (key.equals(clearState.key)) {
					return clearState.value;
				}
			}
		}
		return "";
	}
	public static String getValueByKey(Integer key) {
		for (ICommonEnum<Integer> item : values()) {
			if (item.getKey() == key) {
				return item.getValue();
			}
		}
		return null;
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
