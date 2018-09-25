package com.hsnn.medstgmini.util;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.hsnn.medstgmini.common.model.ExcelExportDataInfo;
import com.hsnn.medstgmini.common.model.ExcelImportDataInfo;

/**
 * 
 * Excel工具类  
 *
 * @ClassName: ExcelUtils  
 * @author zhou.xy
 * @date 2016年4月14日 下午9:36:52  
 *
 */
public class ExcelUtils {
	/**
	 * 解析excel数据 
	 *
	 * @Title: excel2DataInfo 
	 * @param inputStream
	 * @return 
	 * @return ExcelDataInfo
	 * @throws
	 */
	public static ExcelImportDataInfo excel2DataInfo(InputStream inputStream) {
		ExcelImportDataInfo excelDataInfo = new ExcelImportDataInfo();
		List<String> titles = new ArrayList<String>();
		List<List<String>> dataInfos = new ArrayList<List<String>>();
		try {
			Workbook workbook = WorkbookFactory.create(inputStream);// 处理输入流
			Sheet sheet = workbook.getSheetAt(0);// 获取第一个sheet
			int rowNum = sheet.getLastRowNum();// 总行数
			Row firstRow = sheet.getRow(0); // 获取总行数
			int columnNum = firstRow.getLastCellNum();// 总列数
			
			for(int i = 0; i < columnNum; i++) {// 获取excel表头
				Cell cell = firstRow.getCell((short) i); 
				String title = cell.getStringCellValue();
				if(StringUtils.isEmpty(title)) {
					return null;
				}
				titles.add(title);
			}
			excelDataInfo.setTitles(titles);
			DecimalFormat decimalFormat = new DecimalFormat("######.###");
			for (int i = 1; i <= rowNum; i++) {
				List<String> cellValues = new ArrayList<String>();
                Row row = sheet.getRow(i);  
                for (int j = 0; j < columnNum; j++) {//对一行的每个列进行解析  
                    Cell cell = row.getCell((short) j);  
                    Object value = null;
                    if(null!=cell){
                    	 switch (cell.getCellType()) {
                 		case Cell.CELL_TYPE_BLANK: // 貌似永远不会出现,
                 			value = "";
                 			break;
                 		case Cell.CELL_TYPE_NUMERIC: // 数值或者日期类型
                 			if (DateUtil.isCellDateFormatted(cell)) { // 日期
                 				value = cell.getDateCellValue();
                 			} else {// 数值
                 				//value = cell.getNumericCellValue();
                 				value=decimalFormat.format(cell.getNumericCellValue());
                 			}
                 			break;
                 		case Cell.CELL_TYPE_BOOLEAN: // 布尔值
                 			value = cell.getBooleanCellValue();
                 			break;
                 		case Cell.CELL_TYPE_STRING: // 字符串
                 			value = cell.getStringCellValue();
                 			break;
                 		default:
                 			break;
                 		}
                    }
                    cellValues.add(Objects.toString(value, ""));
                }  
                dataInfos.add(cellValues);
			}
			excelDataInfo.setExcelimportDatas(dataInfos);
		} catch (InvalidFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return excelDataInfo;
	}

	public static void dataInfo2excel(ExcelExportDataInfo dataInfos, OutputStream os, String showFlag) {
		if(dataInfos != null) {
			// HSSFWorkbook 97-2003 版本的 ,
			// XSSFWorkbook 2007以上版本的
			Workbook workbook = new XSSFWorkbook();
			Sheet sheet = workbook.createSheet("导出数据表");
			
			List<String> titles = dataInfos.getTitles();
			if(titles != null && titles.size() > 0) {
				int r = 0; 
				int columnNum = titles.size();
				Row titleRow = sheet.createRow(r++);
				CellStyle cellStyle = getTitleStyle(workbook);
				for(int i = 0; i < columnNum; i++) {
					Cell titleCell = titleRow.createCell(i);
					titleCell.setCellValue(titles.get(i));
					titleCell.setCellStyle(cellStyle);
				}
				// 对数据进行处理
				List<Map<String, Object>> excelDatas = dataInfos.getExcelExportDatas();
				if(excelDatas != null && excelDatas.size() > 0) {
					for(Map<String, Object> map : excelDatas) {
						Row row = sheet.createRow(r++);// 数据行
						for(int j = 0; j < columnNum; j++) {
							Cell cell = row.createCell(j);
							cell.setCellValue(Objects.toString(map.get(titles.get(j)), ""));
						}
					}
				}
				
				if(StringUtils.isNotEmpty(showFlag)) {
					sheet.setDefaultColumnStyle(0, getErrorColumnStyle(workbook));
				}
			}
			try {
				workbook.write(os);
				workbook.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * 标题单元格样式 
	 *
	 * @Title: getTitleStyle 
	 * @param workbook
	 * @return 
	 * @return CellStyle
	 * @throws
	 */
	public static CellStyle getTitleStyle(Workbook workbook) {
		CellStyle titleStyel = workbook.createCellStyle();
		XSSFFont font = (XSSFFont) workbook.createFont();
		font.setBoldweight(XSSFFont.BOLDWEIGHT_BOLD);// 设置粗体
		titleStyel.setFont(font);
		return titleStyel;
	}
	
	/**
	 * 设置错误单元格样式 
	 *
	 * @Title: getErrorColumnStyle 
	 * @param workbook
	 * @return 
	 * @return CellStyle
	 * @throws
	 */
	public static CellStyle getErrorColumnStyle(Workbook workbook) {
		CellStyle errorColumnStyel = workbook.createCellStyle();
		XSSFFont font = (XSSFFont) workbook.createFont();
//		font.setBoldweight(XSSFFont.BOLDWEIGHT_BOLD);// 设置粗体
		font.setColor(HSSFColor.WHITE.index);
		font.setColor(Font.COLOR_RED);
		errorColumnStyel.setFont(font);
		errorColumnStyel.setFillBackgroundColor(HSSFColor.RED.index);
		return errorColumnStyel;
	}
	
	
	/**
	 * 
	 *@category 导出excel
	 *@author wangbing
	 *@date 2015年6月15日 下午7:49:54
	 *@param padataInfosge
	 *@param os
	 *@return
	 * @throws IOException 
	 */
	public static void exportExcelDataInfo(ExcelExportDataInfo dataInfos,OutputStream os) throws IOException{
		SXSSFWorkbook  wb = new SXSSFWorkbook (100);  
		Sheet  sheet = wb.createSheet("导出数据表");  
		List<String> titles = dataInfos.getTitles();
		
        Row row = sheet.createRow((int) 0);  
        CellStyle style = getTitleStyle(wb);
        
        Cell cell = null;
        for(int i = 0;i<titles.size();i++){
        	 cell = row.createCell(i);
             cell.setCellValue(titles.get(i));  
             cell.setCellStyle(style);  
        }
        
        List<Map<String,Object>> list = dataInfos.getExcelExportDatas();
        for (int i = 0; i < list.size(); i++) {  
            row = sheet.createRow((int) i + 1);  
            Map<String,Object> data = list.get(i);  
            for(int j = 0;j<titles.size();j++){
            	row.createCell(j).setCellValue(Objects.toString(data.get(titles.get(j)), ""));  
            }
            
        }  
        try {   
            wb.write(os);  
            os.close();  
            wb.close();
        } catch (Exception e){  
            e.printStackTrace();  
        } 
       
	}
}
