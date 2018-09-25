package com.hsnn.medstgmini.base.sys.enums;

import com.hsnn.medstgmini.util.enums.ICommonEnum;

/***
 ** @category 账户类型
 ** @author qing.yunhui
 ** @date 2016年3月8日 下午6:11:08
 ***/
@SuppressWarnings("rawtypes")
public enum AcctType implements ICommonEnum{

	ADMINISTRATOR_ACCOUNT("0", "管理员账户"),
	BUSINESS_ACCOUNT("1","业务账户");
	
	private String key;
	private String value;
	
	private AcctType(String key, String value) {
		this.key = key;
		this.value = value;
	}
	public static String getName(String key) {
		if (key != null && !"".equals(key)) {
			for (AcctType hospLevel : AcctType.values()) {
				if (key.equals(hospLevel.key)) {
					return hospLevel.value;
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
