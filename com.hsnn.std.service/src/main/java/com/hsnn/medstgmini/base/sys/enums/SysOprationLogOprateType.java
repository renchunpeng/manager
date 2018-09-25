package com.hsnn.medstgmini.base.sys.enums;

import com.hsnn.medstgmini.util.enums.ICommonEnum;

/**
 * 操作日志
 * @author he.fan
 *
 */
public enum SysOprationLogOprateType  implements ICommonEnum {

	OPERATION_INSERT(0, "新增"), 
    OPERATION_DELETE(1, "删除"), 
    OPERATION_MODIFY(2, "修改"),
    OPERATION_SEARCH(3, "查询"),
    OPERATION_FORBIDDEN(4, "停用"),
    OPERATION_STARTUSE(5, "启用"),
    OPERATION_PASSWORD_RESET(6, "密码重置"),
    OPERATION_PASSWORD_MODIFY(7, "密码修改"),
    OPERATION_CHOOSE_ROLE(8, "选取角色"),
    OPERATION_APPROVE(9, "审核"),
    OPERATION_LOGIN(10, "登录"),
    OPERATION_LOGOUT(11, "登出"),
    OPERATION_ROLE_EMPOWER(12, "角色赋权"),
    OPERATION_TAKEOFF(13, "下架"),
    OPERATION_IMPORT(14, "导入"),
    OPERATION_EXPORT(15, "导出"),
    OPERATION_SUBMIT(16, "提交"),
    OPERATION_BLOCKUP(17, "停用"),
    OPERATION_MAINTENANCE(18, "维护"),
    OPERATION_REVIEW(19, "复核")
    ;

    private final int key;
    private final String name;

    private SysOprationLogOprateType(int key, String name) {
        this.key = key;
        this.name = name;
    }

    public Object getKey() {
        return key;
    }

    public String getValue() {
        return name;
    }
    
    public static String getNameByValue(Object ordinal) {
        for(SysOprationLogOprateType v : values()){
            if(v.getValue()==ordinal){
                return v.getValue();
            }
        }
        return null;
    }

}
