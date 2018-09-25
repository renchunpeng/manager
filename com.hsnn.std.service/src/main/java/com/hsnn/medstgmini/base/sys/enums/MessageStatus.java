package com.hsnn.medstgmini.base.sys.enums;

import com.hsnn.medstgmini.util.enums.ICommonEnum;

public enum MessageStatus implements ICommonEnum<Integer>{
	INSERT(0, "新建"), 
	SENDOUT(1, "发送"), 
	DELETE(2, "删除"), 
	REMOVEALL(3, "彻底删除");
	
	private final Integer key;
	private final String value;
	
	private MessageStatus(int key, String value) {
		this.key = key;
		this.value = value;
	}
	public static String getName(Integer key) {
		if (key != null && !"".equals(key)) {
			for (MessageStatus noticeStatus : MessageStatus.values()) {
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
