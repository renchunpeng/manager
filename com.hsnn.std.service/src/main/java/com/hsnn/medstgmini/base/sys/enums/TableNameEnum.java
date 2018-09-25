package com.hsnn.medstgmini.base.sys.enums;

import com.hsnn.medstgmini.util.enums.ICommonEnum;

/**
 * 数据库对应的表名
 * @author he.fan
 *
 */
public enum TableNameEnum  implements ICommonEnum {
	
	SYS_USER("sys_user", "用户管理"),
	STD_APPOINTMENT("std_appointment", "预约受理"),
	STD_APPOINTMENT_SETTING("std_appointment_setting", "预约设置"),
	STD_AREA("std_area", "地区字典表管理"),
	STD_COMPANY("std_company", "企业管理"),
	STD_DICT("std_dict", "数据字典管理"),
	STD_GMPGSP("std_gmpgsp", "GMPGSP管理"),
	STD_GOODS("std_goods", "产品管理"),
	STD_GOODS_CLEAR("std_goods_clear", "产品澄清管理"),
	STD_HOSPITAL("std_hospital", "医疗机构管理"),
	STD_MANAGE_ORG("std_manage_org", "监管部门管理"),
	SYS_DATE("sys_date", "日期管理"),
	SYS_DEPARTMENT("sys_department", "部门管理"),
	SYS_POST("sys_post", "岗位管理"),
	SYS_PRODUCT("std_product", "药品管理"),
	SYS_NOTICE("sys_notice","系统公告管理"),
	DRUGPUR_PROCURECATALOG("drugpur_procurecatalog","交易商品"),
	DRUGPUR_GOODS("drugpur_goods","产品管理"),
	STD_DRUGCATALOG("std_drugcatalog","项目新增"),
	DRUGPUR_FILING_APPLY("drugpur_filing_apply","备案申请");
	
	private String key;
	private String value;
	
	private TableNameEnum(String key, String value) {
		this.key = key;
		this.value = value;
	}
	public static String getName(String key) {
		if (key != null && !"".equals(key)) {
			for (TableNameEnum hospLevel : TableNameEnum.values()) {
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
