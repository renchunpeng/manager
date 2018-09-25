package com.hsnn.medstgmini.util;

/**
 * @category 自定义异常
 * @author CCL
 *
 */
public class MSException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	// 全部购物计划已加入订单
	public static final int ALL_PLAN_ALREADY_TO_ORDER = 10001;

	// 部分购物计划已加入订单
	public static final int SOME_PLAN_ALREADY_TO_ORDER = 10002;

	private int code;
	private String msg;

	public MSException() {

	}

	public MSException(String msg) {
		this.msg = msg;
	}

	public MSException(int code, String msg) {
		this.code = code;
		this.msg = msg;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

}
