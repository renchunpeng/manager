package com.hsnn.medstgmini.base.std.enums;

import com.hsnn.medstgmini.util.enums.ICommonEnum;

public enum ClearSubmitStateEnum implements ICommonEnum {
	
	Save("1", "保存"), 
	Submit("2", "提交"),
	Submit2("3", "审核通过"),
	Submit3("4", "审核不通过");

	private String key;
	private String value;
	
	private ClearSubmitStateEnum(String key, String value) {
		this.key = key;
		this.value = value;
	}
	public static String getName(String key) {
		if (key != null && !"".equals(key)) {
			for (ClearSubmitStateEnum clearState : ClearSubmitStateEnum.values()) {
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
