package com.hsnn.medstgmini.base.std.enums;

import com.hsnn.medstgmini.util.enums.ICommonEnum;

/**
 * 
 * GMPGSP状态
 *
 * @ClassName: GmpGspStatus  
 * @author zhou.xy
 * @date 2016年2月29日 下午4:17:08  
 *
 */
public enum GmpGspStatus implements ICommonEnum<Integer> {
	NOAUDIT(0, "未审核"),
	AUDITFAIL(1, "审核不通过"),
	VALID(2, "有效"),
	invalid(3, "无效"),
	outofDate(4, "已过期"),
	DELETED(5, "已删除");
	
	private final Integer key;
	private final String value;
	
	private GmpGspStatus(int key, String value) {
		this.key = key;
		this.value = value;
	}
	public static String getName(Integer key) {
		if (key != null && !"".equals(key)) {
			for (GmpGspStatus gmpGspStatus : GmpGspStatus.values()) {
				if (key == gmpGspStatus.getKey()) {
					return gmpGspStatus.getValue();
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
