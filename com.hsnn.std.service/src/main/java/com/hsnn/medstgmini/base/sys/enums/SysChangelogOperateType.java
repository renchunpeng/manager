package com.hsnn.medstgmini.base.sys.enums;

import com.hsnn.medstgmini.util.enums.ICommonEnum;

/**
 * 日志枚举
 * @author he.fan
 *
 */
public enum SysChangelogOperateType implements ICommonEnum{
	
	OPERATION_INSERT(0, "新增"), 
    OPERATION_DELETE(1, "删除"), 
    OPERATION_MODIFY(2, "修改"),
    OPERATION_FORBIDDEN(3, "停用"),
    OPERATION_STARTUSE(4, "启用"),
    OPERATION_PASSWORD_RESET(5, "密码重置"),
    OPERATION_PASSWORD_MODIFY(6, "密码修改"),
    OPERATION_APPROVE(7, "审核"),
    OPERATION_ROLE_EMPOWER(8, "角色赋权"),
    OPERATION_SUBMIT(9, "提交"),
    OPERATION_BLOCKUP(10, "停用"),
    OPERATION_MAINTENANCE(11, "维护"),
    OPERATION_REVIEW(12, "复核")
    ;

	private final Object key;
    private final String value;

    private SysChangelogOperateType(Object key, String value) {
        this.key = key;
        this.value = value;
    }

    public Object getKey() {
		return key;
	}

	public String getValue() {
        return value;
    }
    
    	public static String getNameByValue(Object ordinal) {
        for(SysChangelogOperateType v : values()){
            if(v.getKey()==ordinal){
                return v.getValue();
            }
        }
        return null;
    }


}
