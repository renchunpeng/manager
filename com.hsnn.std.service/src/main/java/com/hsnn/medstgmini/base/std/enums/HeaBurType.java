package com.hsnn.medstgmini.base.std.enums;

import com.hsnn.medstgmini.util.enums.ICommonEnum;

/**
 * 
 * 机构类别
 *
 * @ClassName: HeaBurType  
 * @author zhou.xy
 * @date 2016年2月29日 下午4:17:08  
 *
 */
public enum HeaBurType implements ICommonEnum<Integer> {
	OTHER(0, "其他"),
	CENTER(1, "中心"),
	HEALTHBUREAU(2, "卫生局");
	
	private final Integer key;
	private final String value;
	
	private HeaBurType(int key, String value) {
		this.key = key;
		this.value = value;
	}
	public static String getName(Integer key) {
		if (key != null && !"".equals(key)) {
			for (HeaBurType heaBurType : HeaBurType.values()) {
				if (key == heaBurType.getKey()) {
					return heaBurType.getValue();
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
}
