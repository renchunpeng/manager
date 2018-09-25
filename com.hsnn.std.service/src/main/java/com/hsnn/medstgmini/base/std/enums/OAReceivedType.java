package com.hsnn.medstgmini.base.std.enums;

import com.hsnn.medstgmini.util.enums.ICommonEnum;

/***
 ** @category 收文类型
 ** @author SunHong
 ** @date 2016年8月10日 上午16:45
 ***/
public enum OAReceivedType implements ICommonEnum<Integer>{
	
		//(1命令（令）、2议案、3决定、4指示、5公告、6通告、7通知、8通报、9报告',)
		OA_Command(1,"命令（令）"),
		OA_Proposal(2,"议案"),
		OA_Decide(3,"决定"),
		OA_Instructions(4,"指示"),
		OA_Notice(5,"公告"),
		OA_Announcement(6,"通告"),
		OA_Notices(7,"通知"),
		OA_Bulletin(8,"通报"),
		OA_Statement(9,"报告");
		
		private int key;
		private String value;
		
		private OAReceivedType(int key,String value) {
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
