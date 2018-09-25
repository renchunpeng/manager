package com.hsnn.medstgmini.base.std.enums;

import com.hsnn.medstgmini.util.enums.ICommonEnum;

public enum ClearStateEnum implements ICommonEnum {
	
	NoClear("0", "不可澄清"), 
	OkClear("1", "可澄清"), 
	Submit("2", "已提交"),
	auditAdopt("3", "澄清审核通过"), 
	auditNoGo("4", "澄清审核不通过");

	private String key;
	private String value;
	
	private ClearStateEnum(String key, String value) {
		this.key = key;
		this.value = value;
	}
	public static String getName(String key) {
		if (key != null && !"".equals(key)) {
			for (ClearStateEnum clearState : ClearStateEnum.values()) {
				if (key.equals(clearState.key)) {
					return clearState.value;
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
