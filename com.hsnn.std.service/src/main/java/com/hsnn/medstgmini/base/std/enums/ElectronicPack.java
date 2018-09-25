package com.hsnn.medstgmini.base.std.enums;

import com.hsnn.medstgmini.util.enums.ICommonEnum;

/***
 ** @category 电子监管包装或标签
 ** @author lil
 ** @date 2016年3月10日 下午5:32:25
 ***/
public enum ElectronicPack implements ICommonEnum<Integer>{

	PASS(0, "合格"), 
	NO_PASS(1, "不合格"),
	UNCOMMITTED(2,"未递交");

	private Integer key;
	private String value;
	
	private ElectronicPack(Integer key, String value) {
		this.key = key;
		this.value = value;
	}
	public static String getName(String key) {
		if (key != null && !"".equals(key)) {
			for (ElectronicPack ep : ElectronicPack.values()) {
				if (key.equals(ep.key)) {
					return ep.value;
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
	
	public static String getNameByValue(Object ordinal) {
        for(ElectronicPack v : values()){
            if(v.getKey()==ordinal){
                return v.getValue();
            }
        }
        return null;
    }
}
