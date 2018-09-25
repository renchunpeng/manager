package com.hsnn.medstgmini.base.sys.enums;


/***
 ** @category 角色类型和角色Id
 ** @author wangbing
 ** @date 2016年3月8日 下午6:11:08
 ***/
public enum RoleId{

	DEFAULT_SC_ROLE(1, 1), // 生产企业默认的角色
	DEFAULT_PS_ROLE(2,2),  // 经营企业默认的角色
	DEFAULT_SCPS_ROLE(3, 3),  // 生产经营企业默认的角色
	DEFAULT_YL_ROLE(4,4),  // 县级及以上医疗机构默认的角色
	DEFAULT_YX_ROLE(5, 5), // 药械中心默认的角色
	DEFAULT_JG_ROLE(6,6),   // 监管机构默认的角色
	DEFAULT_JCYL_ROLE(7,19);  // 基层医疗机构默认的角色
	
	private int key;
	private int value;
	
	private RoleId(int key, int value) {
		this.key = key;
		this.value = value;
	}
	
	public static int getValueByKey(int key) {
		for (RoleId hospLevel : RoleId.values()) {
			if (hospLevel.key == key) {
				return hospLevel.value;
			}
		}
		return 0;
	}

	public static int getKeyByValue(int value) {
		for (RoleId hospLevel : RoleId.values()) {
			if (hospLevel.value == value) {
				return hospLevel.key;
			}
		}
		return 0;
	}

	
	public int getKey() {
		return this.key;
	}

	public int getValue() {
		return this.value;
	}
}
