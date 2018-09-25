package com.hsnn.medstgmini.base.std.enums;

import com.hsnn.medstgmini.util.enums.ICommonEnum;

public enum AppointmentDealTimeinterval  implements ICommonEnum {
	BEFORE10__MORNING(1,"上午10点之前"),
	AFTER10__MORNING(2,"上午10点之后"),
	BEFORE15__AFTERNOON(3,"下午15点之前"),
	AFTER15__AFTERNOON(4,"下午15点之后");
	
	private int key;
	private String value;
	
	private AppointmentDealTimeinterval(int key,String value) {
		this.key = key;
		this.value = value;
	}
	
	@Override
	public Object getKey() {
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
