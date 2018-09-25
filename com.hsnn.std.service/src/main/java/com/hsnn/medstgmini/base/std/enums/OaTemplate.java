package com.hsnn.medstgmini.base.std.enums;

import com.hsnn.medstgmini.util.enums.ICommonEnum;

/***
 ** @category 模版
 ** @author lil
 ** @date 2016年8月10日 17:59:23
 ***/
public enum OaTemplate implements ICommonEnum<Integer>{
	
		//(模版：1通知、2公告)
		Notice(1,"通知"),
		Message(2,"公告");
		
		private int key;
		private String value;
		
		private OaTemplate(int key,String value) {
			this.key = key;
			this.value = value;
		}
		@Override
		public Integer getKey() {
			return this.key;
		}

		@Override
		public String getValue() {
			return this.value;
		}
		
		public static String getValueByKey(Integer key) {
			for (ICommonEnum item : values()) {
				if (item.getKey() == key) {
					return item.getValue();
				}
			}
			return null;
		}
		
		public static Integer getKeyByValue(String value) {
			for (ICommonEnum item : values()) {
				if (item.getValue().equals(value)) {
					return (Integer)item.getKey();
				}
			}
			return null;
		}
		
		public static Integer getKeyByItemName(String itemName) {
			Integer res = null;
			try{
				res = valueOf(itemName).getKey();
			}catch(IllegalArgumentException|NullPointerException e){
			}
			return res; 
		}
}
