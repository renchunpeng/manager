package com.hsnn.medstgmini.base.std.enums;

import com.hsnn.medstgmini.util.enums.ICommonEnum;

/***
 ** @category 执行标准类型
 ** @author qing.yunhui
 ** @date 2016年3月10日 下午5:32:25
 ***/
@SuppressWarnings("rawtypes")
public enum ExecuteStandardType implements ICommonEnum{

	PHARMACOPOEIA_STANDARDS(0, "药典标准"), 
	TRIAL_STANDARDS(1, "试行标准"),
	OTHER_STANDARDS(2,"其它标准");

	private Integer key;
	private String value;
	
	private ExecuteStandardType(Integer key, String value) {
		this.key = key;
		this.value = value;
	}
	public static String getName(String key) {
		if (key != null && !"".equals(key)) {
			for (ExecuteStandardType drugPurchasePropertyEnum : ExecuteStandardType.values()) {
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
