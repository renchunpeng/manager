package com.hsnn.medstgmini.base.sys.enums;


/***
 ** @category 角色类型和角色Id
 ** @author wangbing
 ** @date 2016年3月8日 下午6:11:08
 ***/
public enum OrgRoleId{

	DEFAULT_SC_ORG_ROLE(1, 7), //  生产企业用户默认的角色
	DEFAULT_PS_ORG_ROLE(2,8),  // 经营企业用户默认的角色
	DEFAULT_SCPS_ORG_ROLE(3, 9),  // 生产经营企业用户默认的角色
	DEFAULT_YL_ORG_ROLE(4,10),  // 医疗机构用户默认的角色
	DEFAULT_YX_ORG_ROLE(5, 11), // 药械中心用户默认的角色
	DEFAULT_JG_ORG_ROLE(6,12),   // 监管机构用户默认的角色
	DEFAULT_JCYL_ORG_ROLE(7,10);  // 医疗机构用户默认的角色
	
	private int key;
	private int value;
	
	private OrgRoleId(int key, int value) {
		this.key = key;
		this.value = value;
	}
	public static int getValueByKey(int key) {
		for (OrgRoleId hospLevel : OrgRoleId.values()) {
			if (hospLevel.key == key) {
				return hospLevel.value;
			}
		}
		return 0;
	}
	
	public static int getKeyByValue(int value) {
		for (OrgRoleId hospLevel : OrgRoleId.values()) {
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
