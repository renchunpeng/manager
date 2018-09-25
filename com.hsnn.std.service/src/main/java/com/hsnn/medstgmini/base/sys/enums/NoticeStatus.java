package com.hsnn.medstgmini.base.sys.enums;

import com.hsnn.medstgmini.util.enums.ICommonEnum;

public enum NoticeStatus implements ICommonEnum<Integer>{
	INSERT(0, "新建"), 
    SUBMIT(1, "发布"),
	ADUIT(2,"审核");
	
	private final Integer key;
	private final String value;
	
	private NoticeStatus(int key, String value) {
		this.key = key;
		this.value = value;
	}
	public static String getName(Integer key) {
		if (key != null && !"".equals(key)) {
			for (NoticeStatus noticeStatus : NoticeStatus.values()) {
				if (key == noticeStatus.getKey()) {
					return noticeStatus.getValue();
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
