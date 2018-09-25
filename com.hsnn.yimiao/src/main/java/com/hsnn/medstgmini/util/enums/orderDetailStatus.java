package com.hsnn.medstgmini.util.enums;

/***
 ** @category 采购明细状态值（CONFIRM_STATE）
 ** @author hss
 ** @date 2017年7月2日 下午9:56:33
 ***/
public enum orderDetailStatus implements ICommonEnum {
	DCL(0,"待处理"),
	GH(1,"供货"),
	BGH(2,"不供货"),
	TJ(3,"提交"),
	SHBTG(4,"审核不通过"),
    SHZ(5,"收货中"),
    YWC(6,"已完成"),
	YQX(7,"已取消");
	private int key;
	private String value;

	private orderDetailStatus(int key, String value) {
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
