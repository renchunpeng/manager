package com.hsnn.medstgmini.base.std.enums;

import com.hsnn.medstgmini.util.enums.ICommonEnum;

/***
 ** @category 发文状态
 ** @author lil
 ** @date 2016年8月10日 18:27:19
 ***/
public enum OaDispatchStatus implements ICommonEnum<Integer>{
	
		//(发文状态：0未提交、1科长审核、2综合科审、3副主任审、4主任审核、5拟稿人发、6文书发文)
		OA_NoSubmit(0,"未提交"),	
		OA_Chief(1,"科长审核"),
		OA_Synthetical(2,"综合科审"),
		OA_DeputyDirector(3,"副主任审"),
		OA_Director(4,"主任审核"),
		OA_NoReceived(5,"拟稿人发"),
		OA_Received(6,"文书发文");
		
		
		private int key;
		private String value;
		
		private OaDispatchStatus(int key,String value) {
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
