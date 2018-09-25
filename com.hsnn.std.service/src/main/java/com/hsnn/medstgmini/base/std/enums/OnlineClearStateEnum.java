package com.hsnn.medstgmini.base.std.enums;

import com.hsnn.medstgmini.util.enums.ICommonEnum;

/**
 * 网上澄清审核状态
 * @author lil
 *
 */
public enum OnlineClearStateEnum implements ICommonEnum<String> {
	
	NoClear("0", "待处理"), 
	AuditAdopt("1", "审核通过"), 
	AuditNoGo("2", "审核不通过"),
	WaitAudit("3", "待审核");

	private String key;
	private String value;
	
	private OnlineClearStateEnum(String key, String value) {
		this.key = key;
		this.value = value;
	}
	public static String getName(String key) {
		if (key != null && !"".equals(key)) {
			for (OnlineClearStateEnum clearState : OnlineClearStateEnum.values()) {
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
