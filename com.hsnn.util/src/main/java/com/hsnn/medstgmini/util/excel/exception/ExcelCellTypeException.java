package com.hsnn.medstgmini.util.excel.exception;

/**
 * 
 * ExcelTitle行解析错误
 *
 * @ClassName: ExcelCellTypeException
 * @author zhou.xy
 * @date 2016年4月11日 上午10:06:35
 *
 */
public class ExcelCellTypeException extends Exception {

	public ExcelCellTypeException() {
		super();
	}

	public ExcelCellTypeException(String message, Throwable cause) {
		super(message, cause);
	}

	public ExcelCellTypeException(String message) {
		super(message);
	}

	public ExcelCellTypeException(Throwable cause) {
		super(cause);
	}

}
