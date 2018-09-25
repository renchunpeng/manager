package com.hsnn.medstgmini.util.enums;

/***
 ** @category 采购订单状态值（ORDER_STATE）
 ** @author hss
 ** @date 2017年7月2日 下午9:56:33
 ***/
public enum orderStatus implements ICommonEnum {
	NOTSUBMIT(0,"未提交"),
	SUBMIT(1,"已提交"),
	PASS(2,"已发送"),
	NOTPASS(3,"审核不通过"),
	SHZ(4,"收货中"),
    YWC(5,"已完成"),
	YQX(6,"已取消");
	private int key;
	private String value;

	private orderStatus(int key, String value) {
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
