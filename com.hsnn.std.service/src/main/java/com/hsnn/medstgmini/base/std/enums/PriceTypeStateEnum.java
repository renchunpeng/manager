package com.hsnn.medstgmini.base.std.enums;

import com.hsnn.medstgmini.util.enums.ICommonEnum;

public enum PriceTypeStateEnum implements ICommonEnum<Integer>{
	
	 MedicalInsurance(1,"医保价"),
	 Agricultural(2,"农合价"),
	 BidPrice(3,"中标价"),
	 TopRetail(4,"最高零售价"),
	 MinimumRetail(5,"历史最低价"),
	 TopHistory(6,"历史最高价"),
	 PurchasePrice(7,"采购价");
	
	private final Object key;
	private final String value;
	
	private PriceTypeStateEnum(Object key, String value) {
		this.key = key;
		this.value = value;
	}
	
	public static String getName(String key) {
		if (key != null && !"".equals(key)) {
			for (PriceTypeStateEnum priceTypeStateEnum : PriceTypeStateEnum.values()) {
				if (key.equals(priceTypeStateEnum.key)) {
					return priceTypeStateEnum.value;
				}
			}
		}
		return "";
	}
	
	/*public static String getNameByValue(Object ordinal) {
        for(PriceTypeStateEnum v : values()){
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
