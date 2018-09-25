package com.hsnn.medstgmini.base.sys.enums;


/***
 ** @category 角色类型和角色Id
 ** @author wangbing
 ** @date 2016年3月8日 下午6:11:08
 ***/
public enum DeptRoleId{

	DEFAULT_SC_DEPT_ROLE(1, 13), // 生产部门默认的角色
	DEFAULT_PS_DEPT_ROLE(2,14),  // 经营部门默认的角色
	DEFAULT_SCPS_DEPT_ROLE(3, 15),  // 生产经营部门默认的角色
	DEFAULT_YL_DEPT_ROLE(4,16),  // 医疗部门默认的角色
	DEFAULT_YX_DEPT_ROLE(5, 17), // 药械部门默认的角色
	DEFAULT_JG_DEPT_ROLE(6,18),   // 监管部门默认的角色
	DEFAULT_JCYL_DEPT_ROLE(7,16);  // 医疗部门默认的角色
	
	private int key;
	private int value;
	
	private DeptRoleId(int key, int value) {
		this.key = key;
		this.value = value;
	}
	public static int getValueByKey(int key) {
		for (DeptRoleId hospLevel : DeptRoleId.values()) {
			if (hospLevel.key == key) {
				return hospLevel.value;
			}
		}
		return 0;
	}
	
	public static int getKeyByValue(int value) {
		for (DeptRoleId hospLevel : DeptRoleId.values()) {
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
