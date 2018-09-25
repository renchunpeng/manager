package com.hsnn.medstgmini.base.std.enums;

import com.hsnn.medstgmini.util.enums.ICommonEnum;

/**
 * 医疗机构审核状态
 * @author he.fan
 *
 */
@SuppressWarnings("rawtypes")
public enum StdHospitalInitializationState implements ICommonEnum{
	
	WAIT_SUMBIT(0,"待提交"),
	WAIT_VERITY(1,"待审核"),
	VERITY_PASS(2,"审核通过"),
	VERITY_NO(3,"审核不通过");
	
	private final int key;
    private final String value;

    private StdHospitalInitializationState(int key, String value) {
        this.key = key;
        this.value = value;
    }

    public Integer getKey() {
		return key;
	}

	public String getValue() {
        return value;
    }
    
    public static String getNameByValue(Object ordinal) {
        for(StdHospitalInitializationState v : values()){
            if(v.getKey()==ordinal){
                return v.getValue();
            }
        }
        return null;
    }
    
    public static String getValueByKey(Integer key) {
		for (ICommonEnum item : values()) {
			if (item.getKey() == key) {
				return item.getValue();
			}
		}
		return null;
	}
	
	public static Integer getKeyByValue(String value) {
		for (ICommonEnum item : values()) {
			if (item.getValue().equals(value)) {
				return (Integer)item.getKey();
			}
		}
		return null;
	}
	
	public static Integer getKeyByItemName(String itemName) {
		Integer res = null;
		try{
			res = valueOf(itemName).getKey();
		}catch(IllegalArgumentException|NullPointerException e){
		}
		return res; 
	}
}
