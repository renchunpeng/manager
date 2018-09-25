package com.hsnn.medstgmini.base.sys.enums;

import com.hsnn.medstgmini.util.enums.ICommonEnum;

/**
 * 通用枚举：表示是和否
 * @author 果然翁
 *
 */
public enum ProcedureEnum implements ICommonEnum<Integer> {

	XZ(0, "新增"),
	GX(1, "更新"),
	SC(2, "删除"),
	JCTJ(3, "基层调价删除"),
	JYTJ(4, "交易调价删除"),
	CPTY(5, "产品停用删除"),
	XMTY(6, "项目停用删除"),
	XMCPTY(7, "项目产品停用删除"),
	TBZT(8, "投标主体变更删除"),
	XSSPCF(9, "县上交易商品撤废删除"),
	CPCQ(10, "产品澄清删除"),
	JCKTJ(11, "基础库调价删除");
	private int key;
	private String value;

	private ProcedureEnum(int key, String value) {
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
