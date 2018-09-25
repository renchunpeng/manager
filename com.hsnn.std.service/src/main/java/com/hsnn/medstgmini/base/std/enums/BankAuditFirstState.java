package com.hsnn.medstgmini.base.std.enums;

import com.hsnn.medstgmini.util.enums.ICommonEnum;
/**
 * 支付信息初审状态
 * @author ZXL
 *
 */
public enum BankAuditFirstState implements ICommonEnum {
//	SAVE(0,"保存"),
	DEFAULT(0,"默认"),
	WAITAUDIT(1,"待接收"),
	PASS(2,"已接收"),
	NOPASS(3,"拒绝接收");

	private int key;
	private String value;
	
	private BankAuditFirstState(int key,String value) {
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
