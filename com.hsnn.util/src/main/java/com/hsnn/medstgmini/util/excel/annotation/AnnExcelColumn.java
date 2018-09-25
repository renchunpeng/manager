package com.hsnn.medstgmini.util.excel.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.hsnn.medstgmini.util.excel.bean.IExcelCustomConverter;
import com.hsnn.medstgmini.util.excel.enums.ExcelColumnType;
import com.hsnn.medstgmini.util.excel.enums.ExcelNullEnum;
import com.hsnn.medstgmini.util.validate.ValidateImportDataUtil;

/**
 * 
 * 导入导出字段的注解
 *
 * @ClassName: AnnExcelColumn
 * @author zhou.xy
 * @date 2016年4月11日 上午9:59:54
 *
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface AnnExcelColumn {
	/**
	 * Excel 标题名称
	 */
	String title();

	/**
	 * 输出的的格式
	 */
	String format() default "";

	/**
	 * 在什么时间处理，导入， 导出， 全部
	 */
	ExcelColumnType type() default ExcelColumnType.ALL;

	/**
	 * 导出时标题的顺序 由小到大
	 */
	int order() default 999;
	
	Class<?> validateClass() default ValidateImportDataUtil.class;

	/**
	 * 导入时候的简单验证 FIXME 未实现
	 */
	String validateMethod() default "";

	/**
	 * 枚举类型的相互转换,必须是 ICommonEnum 的实现
	 */
	Class<?> enumType() default ExcelNullEnum.class;

	/**
	 * 自定义处理器，可以用于自已定义数据的转换，比如从数据库查出来的值，或者经过计算的值 FIXME 没有实现
	 */
	Class<?> customType() default IExcelCustomConverter.class;

	/**
	 * 列宽(px)，不是很精准，<br/>
	 * 0 默认值，不处理， <br/>
	 * -1 自动宽度， <br/>
	 * 其他值 就会设置为宽度
	 * 
	 * @default 0
	 */
	int width() default 0;
}
