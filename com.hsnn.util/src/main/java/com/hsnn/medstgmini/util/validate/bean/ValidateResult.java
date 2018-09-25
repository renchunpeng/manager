package com.hsnn.medstgmini.util.validate.bean;

/**
 * 
 * 校验结果  
 *
 * @ClassName: ValidateResult  
 * @author zhou.xy
 * @date 2016年4月13日 下午4:30:14  
 *
 */
public class ValidateResult {
	private boolean isRight;// 是否正确
	private String msg;// 描述信息

	public boolean isRight() {
		return isRight;
	}

	public void setRight(boolean isRight) {
		this.isRight = isRight;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

}
