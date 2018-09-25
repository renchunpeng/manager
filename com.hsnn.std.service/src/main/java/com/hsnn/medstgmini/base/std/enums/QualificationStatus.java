package com.hsnn.medstgmini.base.std.enums;

import com.hsnn.medstgmini.util.enums.ICommonEnum;

/***
 ** @category 资质状态
 ** @author qing.yunhui
 ** @date 2016年3月9日 上午9:55:21
 ***/
public enum QualificationStatus implements ICommonEnum<Integer>{
	
	QUALIFIED(1, "合格"), UN_QUALIFIED(0, "不合格");
	
	private Integer key;
	private String value;

	private QualificationStatus(int key, String value) {
		this.key = key;
		this.value = value;
	}

	public static String getName(int key) {
		for (QualificationStatus status : QualificationStatus.values()) {
			if (status.key == key) {
				return status.value;
			}
		}
		return "";
	}

	public Integer getKey() {
		return key;
	}

	public void setKey(Integer key) {
		this.key = key;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
}
