package com.hsnn.medstgmini.util.enums;

/***
 ** @category 退货单（ORDER_STATE）
 ** @author hss
 ** @date 2017年7月2日 下午9:56:33
 ***/
public enum ReturnOrderStatus implements ICommonEnum {
	NOTSUBMIT(0,"未提交"),
	SUBMIT(1,"已提交"),
	PASS(2,"已发送"),
	NOTPASS(3,"审核不通过"),
	AGREE_RETURN(4,"同意退货"),
	NO_RETURN(5,"不退货"),
	ADMIN_RETURN(6,"退货中"),
	FISH_RETURN(7,"已完成");
	private int key;
	private String value;

	private ReturnOrderStatus(int key, String value) {
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
