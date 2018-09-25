package com.hsnn.medstgmini.util.excel.bean.impl;

import java.beans.PropertyDescriptor;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import com.hsnn.medstgmini.util.StringTool;
import com.hsnn.medstgmini.util.enums.DataState;
import com.hsnn.medstgmini.util.excel.annotation.AnnExcelColumn;
import com.hsnn.medstgmini.util.excel.annotation.AnnExcelSheet;
import com.hsnn.medstgmini.util.excel.bean.IExcelImport;
import com.hsnn.medstgmini.util.excel.enums.ExcelColumnType;
import com.hsnn.medstgmini.util.excel.enums.ExcelNullEnum;
import com.hsnn.medstgmini.util.excel.enums.IExcelCommonEnum;
import com.hsnn.medstgmini.util.excel.exception.ExcelCellTypeException;
import com.hsnn.medstgmini.util.excel.exception.ExcelEnumTypeException;
import com.hsnn.medstgmini.util.excel.exception.ExcelTitleParseException;
import com.hsnn.medstgmini.util.validate.bean.ValidateResult;

/**
 * 
 * excel导入
 *
 * @ClassName: SimpleExcelImport
 * @author zhou.xy
 * @date 2016年4月11日 上午10:04:58
 *
 */
public class SimpleExcelImport implements IExcelImport {
	/**
	 * 处理对象的所有的注解相关的信息
	 */
	private ExcelAnnParse eap;
	/**
	 * 是否忽略掉一些无所谓的异常
	 */
	private boolean ignoreException = false;

	/**
	 * 工作薄解析
	 * 
	 * @param is
	 * @param clazz
	 * @return
	 * @throws Exception
	 */
	public <T> void execute(List<T> addList, List<T> errorList, InputStream is, Class<T> clazz) throws Exception {
		/**
		 * 1.获取实例的注解信息<br>
		 * 2.获取实例字段注解信息 <br>
		 * 3.获取标题信息 <br>
		 * 4.从标题行开始解析单元格数据 <br>
		 * 5.根据实例的注解信息获取Cell
		 * 6.把数据放入实例对象中去
		 */
		// @1 @2
		this.eap = ExcelAnnParse.parse(clazz);
		// 方便使用
		ignoreException = this.eap.getSheetInfo().ignoreException();
		// 工作薄的信息@1
		// AnnExcelSheet sheetInfo = parseAnnotationExcelSheet(clazz);
		// 根据注解的名字来获取需要解析哪些数据@2
		// parseAnnotationExcelColumn(clazz);

		AnnExcelSheet sheetInfo = eap.getSheetInfo();
		Map<String, PropertyDescriptor> fieldInfo = eap.getFieldInfo();

		Workbook workbook = WorkbookFactory.create(is);
		Sheet sheet = workbook.getSheetAt(sheetInfo.sheetIndex());
		// 获取标题信息@3
		Map<String, Integer> titleRowInfo = parseTitleRow(sheet.getRow(sheetInfo.titleNum()));

		int rowCount = sheet.getLastRowNum();
		// @4
		for (int i = sheetInfo.titleNum() + 1; i <= rowCount; i++) {
			T item = (T) clazz.newInstance();
			Row row = sheet.getRow(i);
			if (row == null) {
				continue;
			}
			//short columnCount = row.getLastCellNum();
			List<DataState> flags = new ArrayList<DataState>();// 错误标识
			List<ValidateResult> results = new ArrayList<ValidateResult>();// 错误信息
			for (Map.Entry<String, PropertyDescriptor> fieldItem : fieldInfo.entrySet()) {
				String titleValue = fieldItem.getKey();// 标题
				Integer cellIndex = titleRowInfo.get(titleValue);
				// 根据单元格数据赋值
				AnnExcelColumn annColumn = eap.getFieldAnnInfo().get(fieldItem.getKey());
				if(!ExcelColumnType.EXP.equals(annColumn.type())) {
					parseCell(row.getCell(cellIndex), item, fieldItem, flags, results);
				}
			}
			if(results != null && results.size() > 0) {
				String errorMsg = "";
				for(ValidateResult v : results) {
					if(!v.isRight()) {
						errorMsg += v.getMsg() + ", ";
					}
				}
				if(StringUtils.isNotEmpty(errorMsg)) {
					errorMsg = errorMsg.substring(0, errorMsg.length() - 2);
				}
				Method setImportDescriptionsMethod = item.getClass().getMethod("setImportDescriptions", String.class);
				setImportDescriptionsMethod.invoke(item, errorMsg);// 设置错误描述
			}
			if(flags != null && flags.size() > 0) {
				errorList.add(item);
			} else {
				addList.add(item);
			}
		}
		workbook.close();
	}

	/**
	 * 解析titleRow
	 * 
	 * @param row
	 * @return
	 * @throws ExcelTitleParseException
	 */
	private Map<String, Integer> parseTitleRow(Row row) throws ExcelTitleParseException {
		if (row == null) {
			throw new ExcelTitleParseException("标题行索引配置错误！");
		}
		Map<String, Integer> titleRow = new HashMap<String, Integer>();
		short rowNum = row.getLastCellNum();
		for (int i = 0; i < rowNum; i++) {
			Cell cell = row.getCell(i);
			// FIXME cell 为空的情况不明确，暂时这么处理
			if (cell == null || cell.getCellType() != Cell.CELL_TYPE_STRING) {
				throw new ExcelTitleParseException("标题行第" + (i + 1) + "单元格类型不是字符串！");
			}
			titleRow.put(cell.getStringCellValue(), i);
		}
		return titleRow;
	}

	@SuppressWarnings("rawtypes")
	private void parseCell(Cell cell, Object instance, Map.Entry<String, PropertyDescriptor> entry,
			List<DataState> flags, List<ValidateResult> results) throws Exception {
		// 获取字段的注解信息
		AnnExcelColumn annColumn = eap.getFieldAnnInfo().get(entry.getKey());
		if (annColumn == null) {
			if (this.ignoreException) {
				return;
			} else {
				throw new ExcelTitleParseException(entry.getKey() + "列未找到！");
			}
		}
		// 如果是仅导出就不需要处理下面数据了
		if (cell == null || annColumn.type() == ExcelColumnType.EXP) {
			return;
		}

		Object value = null;
		Method setMethod = entry.getValue().getWriteMethod();

		Class paramType = setMethod.getParameterTypes()[0];
		// 类型处理
		switch (cell.getCellType()) {
		case Cell.CELL_TYPE_BLANK: // 貌似永远不会出现,
			value = "";
			break;
		case Cell.CELL_TYPE_NUMERIC: // 数值或者日期类型
			if (DateUtil.isCellDateFormatted(cell)) { // 日期
				value = cell.getDateCellValue();
			} else {// 数值
				value = cell.getNumericCellValue();
			}
			break;
		case Cell.CELL_TYPE_BOOLEAN: // 布尔值
			value = cell.getBooleanCellValue();
			break;
		case Cell.CELL_TYPE_STRING: // 字符串
			value = cell.getStringCellValue();
			break;
		case Cell.CELL_TYPE_FORMULA: // 公式
			// FIXME 先做简单的处理，所有计算结构都当成字符串处理
			value = cell.getRichStringCellValue().getString();
			break;
		case Cell.CELL_TYPE_ERROR: // ？？？
			if (this.ignoreException) {
				return;
			} else {
				throw new ExcelCellTypeException(cell.getRow().getRowNum() + "行" + cell.getRowIndex() + "列数据错误！");
			}
		default:
			break;
		}
		String validateMethodStr = annColumn.validateMethod();
		Method validateMethod = null;
		Class<?> validateClazz = annColumn.validateClass();
		if(!StringTool.isEmpty(validateMethodStr)) {
			try {
				validateMethod = validateClazz.getMethod(validateMethodStr, String.class, String.class);
			} catch (NoSuchMethodException e) {
				throw e;
			}
		}
		if(validateMethod != null) {
			ValidateResult result = (ValidateResult) validateMethod.invoke(validateClazz.newInstance(), value, annColumn.title());
			if(result != null) {
				if(!result.isRight()) {
					results.add(result);
					flags.add(DataState.IS_ERROR);
				}
			}
		}
		
		try {
			value = transformType(value, paramType, annColumn, cell);
			if (value == null) {// 如果是null，就不去处理， 以默认值方式赋值
				new NullPointerException(annColumn.title() + "列有空值");
			} else {
				setMethod.invoke(instance, value);
			}
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * 根据字段的描述信息，来进行类型的转换 这里的实现是一个不是很好的方式， 目前没有想到好的方式。。。
	 * 
	 * @param source
	 *            excel后去到的值
	 * @param target
	 *            字段set方法期望的值
	 * @param annExcelColumn
	 *            字段的注解
	 * @return
	 * @throws ExcelCellTypeException
	 * @throws ExcelEnumTypeException
	 */
	@SuppressWarnings("rawtypes")
	private Object transformType(Object source, Class target, AnnExcelColumn annExcelColumn, Cell cell) throws ExcelCellTypeException, ExcelEnumTypeException {
		if (target == source.getClass()) {
			return source;
		}
		// FIXME 考虑采用责任链方式处理
		if (source.getClass() == Double.class) {
			if (target == Integer.class) {// 匹配整形
				return Integer.parseInt(source.toString().replaceAll(("\\.0$"),
						""));
			} else if (target == String.class) {// 匹配字符串
				return source.toString().replaceAll(("\\.0$"), "");
			} else if (target == Date.class) {// 自定义日期类型的处理
				return DateUtil.getJavaDate((Double) source);
			} else if (target == Long.class) {// Long
				return Math.round((Double) source);
			} else if (target == BigDecimal.class) {
				return new BigDecimal((Double) source);
			} else if (target == BigInteger.class) {
				return new BigInteger(source.toString().replaceAll(("\\.0$"),
						""));
			}
		}
		if (source.getClass() == String.class) {
			if (annExcelColumn.enumType() != ExcelNullEnum.class) {// 枚举对象的处理
				return enumProcess(source, annExcelColumn.enumType());
			} else if (target == Integer.class) {// Integer的处理
				return Integer.valueOf(source.toString());
			} else if (target == Double.class) {// Double的处理
				return Double.valueOf(source.toString());
			} else if (target == Long.class) {// Long 处理
				return Long.valueOf(source.toString());
			}
		}
		if (this.ignoreException) {
			return null;
		} else {
			throw new ExcelCellTypeException(source.getClass().getName() + "没有转换成" + target.getName() + ";请联系 维护人员！");
		}
	}

	@SuppressWarnings("rawtypes")
	private Integer enumProcess(Object source, Class enumtype) throws ExcelEnumTypeException {
		if (!enumtype.isEnum()) {
			throw new ExcelEnumTypeException(enumtype.getName() + " 不是枚举对象");
		}
		if (ClassUtil.isImplement(enumtype, IExcelCommonEnum.class)) {
			// 遍历枚举值，找到对应的 value
			for (Object o : enumtype.getEnumConstants()) {
				IExcelCommonEnum ce = (IExcelCommonEnum) o;
				if (ce.getName().equals(source)) {
					return ce.getValue();
				}
			}
			if (this.ignoreException) {
				return null;
			} else {
				throw new ExcelEnumTypeException(enumtype.getName()
						+ " 没有找到枚举值：" + source);
			}
		}
		if (enumtype != ExcelNullEnum.class) {
			throw new ExcelEnumTypeException(enumtype.getName() + " 没有实现 ICommonEnum 接口");
		}
		return -1;
	}
	
	public static boolean changeV(boolean a) {
		boolean b = false;
		a = b;
		return a;
	}
	
	public static void main(String[] args) {
		boolean a = true;
		a = changeV(a);
		System.out.println(a);
	}
}

