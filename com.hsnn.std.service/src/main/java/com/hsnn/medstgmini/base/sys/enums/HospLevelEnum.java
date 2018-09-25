/**
 * 上午11:35:31
 */
package com.hsnn.medstgmini.base.sys.enums;

import com.hsnn.medstgmini.util.enums.ICommonEnum;

/**
 * @author hsnn
 * 医院等级枚举类
 */
public enum HospLevelEnum implements ICommonEnum {
	level1Grade1("1", "一级甲等"), 
	level1Grade2("2", "一级乙等"), 
	level1Grade3("3", "一级丙等"),
	level2Grade1("4", "二级甲等"), 
	level2Grade2("5", "二级乙等"), 
	level2Grade3("6", "二级丙等"), 
	level3Grade1("7", "三级甲等"), 
	level3Grade2("8", "三级乙等"),
	level3Grade3("9", "三级丙等"),
	level3GradeT("10", "三级特等");

	private String key;
	private String value;
	
	private HospLevelEnum(String key, String value) {
		this.key = key;
		this.value = value;
	}
	public static String getName(String key) {
		if (key != null && !"".equals(key)) {
			for (HospLevelEnum hospLevel : HospLevelEnum.values()) {
				if (key.equals(hospLevel.key)) {
					return hospLevel.value;
				}
			}
		}
		return "";
	}
	@Override
	public String getKey() {
		return this.key;
	}

	@Override
	public String getValue() {
		return this.value;
	}

}
