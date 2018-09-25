package com.hsnn.medstgmini.base.std.enums;

import com.hsnn.medstgmini.util.enums.ICommonEnum;

/***
 ** @category 收文状态
 ** @author SunHong
 ** @date 2016年8月10日 上午16:45
 ***/
public enum OAReceivedStatus implements ICommonEnum<Integer>{
	
		//(0未提交、1综合科审、2副主任审、3主任审、4收文、5已收文)
		OA_NoSubmit(0,"未提交"),	
		OA_Synthetical(1,"综合科审"),
		OA_DeputyDirector(2,"副主任审"),
		OA_Director(3,"主任审"),
		OA_NoReceived(4,"待收文"),
		OA_Received(5,"已收文");
		
		
		private int key;
		private String value;
		
		private OAReceivedStatus(int key,String value) {
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
