package com.hsnn.medstgmini.base.std.enums;

import com.hsnn.medstgmini.util.enums.ICommonEnum;


public enum ProjTypeEnum implements ICommonEnum<Integer> {

	ZB(1, "招标采购"),
	/*DL(1, "代理企业"), */
	DD(2, "定点生产"),
	GW(3,"挂网生产"),
	YJ(4,"议价采购"),
	BA(5,"备案采购");
	/*SCPS(3, "生产配送企业"),*/
//	SJ(4, "进口药品国内总代理"),
//	SZ(5, "集团子公司生产企业"),
//	SJZ(6, "集团子公司进口代理企业");

	private final Integer key;
	private final String value;

	private ProjTypeEnum(Integer key, String value) {
		this.key = key;
		this.value = value;
	}
	public static String getName(String key) {
		if (key != null && !"".equals(key)) {
			for (ProjTypeEnum clearState : ProjTypeEnum.values()) {
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
