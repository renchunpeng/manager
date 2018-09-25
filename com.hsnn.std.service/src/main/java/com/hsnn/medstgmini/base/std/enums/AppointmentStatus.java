package com.hsnn.medstgmini.base.std.enums;

import com.hsnn.medstgmini.util.enums.ICommonEnum;
/**
 * 预约信息的状态
 * @author ZXL
 *
 */
public enum AppointmentStatus implements ICommonEnum {
//	SAVE(0,"保存"),
	SUBMIT(1,"提交"),
	CANCEL(2,"已撤销"),
	ACCEPT(3,"已受理"),
	OVERDUE(4,"过期");

	private int key;
	private String value;
	
	private AppointmentStatus(int key,String value) {
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
