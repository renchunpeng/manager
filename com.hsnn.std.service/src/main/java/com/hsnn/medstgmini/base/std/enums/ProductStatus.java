package com.hsnn.medstgmini.base.std.enums;

import com.hsnn.medstgmini.util.enums.ICommonEnum;

/**
 * 
 * 药品状态
 *
 * @ClassName: ProductStatus  
 * @author zhou.xy
 * @date 2016年2月29日 下午4:17:08  
 *
 */
public enum ProductStatus implements ICommonEnum<Integer> {
	SAVED(0, "已保存待提交"),
	COMMITED(1, "已提交待审核"),
	AUDITPASS(2, "审核通过"),
	AUDITNOPASS(3, "审核不通过");
	
	private final Integer key;
	private final String value;
	
	private ProductStatus(int key, String value) {
		this.key = key;
		this.value = value;
	}
	public static String getName(Integer key) {
		if (key != null && !"".equals(key)) {
			for (ProductStatus productStatus : ProductStatus.values()) {
				if (key == productStatus.getKey()) {
					return productStatus.getValue();
				}
			}
		}
		return "";
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
				return item.getKey();
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
	
	@Override
	public Integer getKey() {
		return this.key;
	}

	@Override
	public String getValue() {
		return this.value;
	}
}
