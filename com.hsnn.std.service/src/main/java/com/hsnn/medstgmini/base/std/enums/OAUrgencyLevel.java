package com.hsnn.medstgmini.base.std.enums;

import com.hsnn.medstgmini.util.enums.ICommonEnum;

/***
 ** @category 紧急程度
 ** @author SunHong
 ** @date 2016年8月10日 上午16:45
 ***/
public enum OAUrgencyLevel implements ICommonEnum<Integer>{
	
		//(1特急、2急件、3平件)
		OA_ExtraUrgent(1,"特急"),
		OA_Urgent(2,"急件"),
		OA_RegularFile(3,"平件");
		
		private int key;
		private String value;
		
		private OAUrgencyLevel(int key,String value) {
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
