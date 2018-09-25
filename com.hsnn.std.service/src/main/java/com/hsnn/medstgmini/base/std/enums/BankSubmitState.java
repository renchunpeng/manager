package com.hsnn.medstgmini.base.std.enums;

import com.hsnn.medstgmini.util.enums.ICommonEnum;
/**
 * 支付信息提交状态
 * @author ZXL
 *
 */
public enum BankSubmitState implements ICommonEnum {
	NOSUBMIT(0,"未提交"),
	SUBMIT(1,"已提交");

	private int key;
	private String value;
	
	private BankSubmitState(int key,String value) {
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
