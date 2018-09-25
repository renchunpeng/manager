package com.hsnn.medstgmini.base.std.enums;

import com.hsnn.medstgmini.util.enums.ICommonEnum;

public enum HealthOrganizationCodeEnum implements ICommonEnum {
	
	HEALTHANDSOCIALGROUPS("","卫生社会团体"),
	EMERGENCYCENTER("","急救中心（站）"),
	MCH("","妇幼保健院(所、站)");
	
	private final Object key;
    private final String value;

    private HealthOrganizationCodeEnum(Object key, String value) {
        this.key = key;
        this.value = value;
    }

    public Object getKey() {
		return key;
	}

	public String getValue() {
        return value;
    }
    
    	public static String getNameByValue(Object ordinal) {
        for(HealthOrganizationCodeEnum v : values()){
            if(v.getKey()==ordinal){
                return v.getValue();
            }
        }
        return null;
    }
	
	

}
