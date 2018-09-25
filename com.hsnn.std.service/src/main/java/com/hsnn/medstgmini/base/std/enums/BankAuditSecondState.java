package com.hsnn.medstgmini.base.std.enums;

import com.hsnn.medstgmini.util.enums.ICommonEnum;
/**
 * 支付信息复审状态
 * @author wangb
 *
 */
public enum BankAuditSecondState implements ICommonEnum {
	DEFAULT(0,"默认"),
	WAITAUDIT(1,"待同步"),
	PASS(2,"已同步"),
	NOPASS(3,"拒绝同步");

	private int key;
	private String value;
	
	private BankAuditSecondState(int key,String value) {
		this.key = key;
		this.value = value;
	}
	@Override
	public Integer getKey() {
		return this.key;
	}

	@Override
	public String getValue() {
		return this.value;
	}
	
	public static String getNameByValue(int ordinal) {
		for(ICommonEnum ce:values()){
			if(ce.getKey().equals(ordinal)){
				return ce.getValue();
			}
		}
		return null;
	}
}
