package com.hsnn.medstgmini.base.std.enums;

import com.hsnn.medstgmini.util.enums.ICommonEnum;

/**
 * 
 * GMPGSP类型
 *
 * @ClassName: GmpGspType  
 * @author zhou.xy
 * @date 2016年2月29日 下午4:17:08  
 *
 */
public enum GmpGspType implements ICommonEnum<Integer> {
	GMP(0, "GMP"),
	GSP(1, "GSP");
	
	private final Integer key;
	private final String value;
	
	private GmpGspType(int key, String value) {
		this.key = key;
		this.value = value;
	}
	public static String getName(Integer key) {
		if (key != null && !"".equals(key)) {
			for (GmpGspType gmpGspType : GmpGspType.values()) {
				if (key == gmpGspType.getKey()) {
					return gmpGspType.getValue();
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
