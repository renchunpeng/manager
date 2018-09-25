package com.hsnn.medstgmini.util.excel.bean;

/**
 * 
 * 用户自己定义类型转换器，会被优先处理  
 *
 * @ClassName: IExcelCustomConverter  
 * @author zhou.xy
 * @date 2016年4月11日 上午10:04:10  
 *
 */
public interface IExcelCustomConverter {
	/**
	 * 考虑到用于自定义值得类型不一定，所以放开为Objet,自己内部处理类型问题
	 * @param value
	 * @return
	 */
	public String valueToLabel(Object value);
	/**
	 * 返回数据是字符串类型，而不是Integer，因为有可能是字符串的value <br/>
	 * 强制需求的话可以在bean里面重载字段 set 方法，进行控制
	 * 
	 * @param name
	 * @return
	 */
	public String labelToValue(String name);
}
