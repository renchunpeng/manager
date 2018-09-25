package com.hsnn.medstgmini.base.std.enums;

import com.hsnn.medstgmini.util.enums.ICommonEnum;

public enum InitializationStateEnum implements ICommonEnum<Integer>{
	
	WaitSubmit(0, "待提交"), 
	WaitReview(1, "待复核"), 
	reviewAdopt(2, "复核通过"),
	reviewNoGo(3, "复核不通过"), 
	auditAdopt(4, "审核通过"), 
	auditNoGo(5, "审核不通过");

	private final Object key;
	private final String value;
	
	private InitializationStateEnum(Object key, String value) {
		this.key = key;
		this.value = value;
	}
	
	public static String getName(String key) {
		if (key != null && !"".equals(key)) {
			for (InitializationStateEnum initializationState : InitializationStateEnum.values()) {
				if (key.equals(initializationState.key)) {
					return initializationState.value;
				}
			}
		}
		return "";
	}
	
/*	public static String getNameByValue(Object ordinal) {
        for(SysChangelogOperateType v : values()){
            if(v.getKey()==ordinal){
                return v.getValue();
            }
        }
        return null;
    }*/
	
	@Override
	public Integer getKey() {
		return (Integer) this.key;
	}

	@Override
	public String getValue() {
		return this.value;
	}
}
