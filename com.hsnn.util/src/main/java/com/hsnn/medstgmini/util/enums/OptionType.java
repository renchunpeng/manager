package com.hsnn.medstgmini.util.enums;

import com.hsnn.medstgmini.util.enums.ICommonEnum;

/**
 * 
 * 操作类别  
 *
 * @ClassName: OptionType  
 * @author zhou.xy
 * @date 2016年3月29日 下午2:35:04  
 *
 */
public enum OptionType implements ICommonEnum<Integer> {
	CONFIRM(0, "确认"), 
	REFUSE_CONFIRM_OR_SHIP(1, "拒绝确认或拒绝配送"),
	SHIP(2, "配送"),
	RETURN_AGREE(3, "同意退货"),
	RETURN_REFUSE(4, "拒绝退货"),
	MAINTAIN_RETURN_INVOICE(5, "维护退货发票"),
	REFUSE_RESPONSE(6, "拒绝响应"),
	REFUSE_SHIP(7, "拒绝配送"),
	EMERGENCY_CONFIRM(8, "急救药品临时订单确认"),
	REFUSE_EMERGENCY(9, "急救药品临时订单拒绝确认"),
	ADD(10, "新增"),
	UPDATE(11, "修改");

	private int key;
	private String value;

	private OptionType(int key, String value) {
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
		for (ICommonEnum<Integer> item : values()) {
			if (item.getKey() == key) {
				return item.getValue();
			}
		}
		return null;
	}

	public static Integer getKeyByValue(String value) {
		for (ICommonEnum<Integer> item : values()) {
			if (item.getValue().equals(value)) {
				return (Integer) item.getKey();
			}
		}
		return null;
	}

	public static Integer getKeyByItemName(String itemName) {
		Integer res = null;
		try {
			res = valueOf(itemName).getKey();
		} catch (IllegalArgumentException | NullPointerException e) {
		}
		return res;
	}

}
