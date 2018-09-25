package com.hsnn.medstgmini.base.std.enums;

import com.hsnn.medstgmini.util.enums.ICommonEnum;

public enum ClearAuditStateEnum implements ICommonEnum {
	
	WaitAudit("1", "待审核"), 
	WaitAudit2("2", "待审核"), 
	AuditAdopt("3", "审核通过"),
	AuditNo("4", "审核不通过");

	private String key;
	private String value;
	
	private ClearAuditStateEnum(String key, String value) {
		this.key = key;
		this.value = value;
	}
	public static String getName(String key) {
		if (key != null && !"".equals(key)) {
			for (ClearAuditStateEnum clearState : ClearAuditStateEnum.values()) {
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
