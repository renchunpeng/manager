package com.hsnn.medstgmini.util;

import java.io.IOException;
import java.io.OutputStream;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFFont;

import com.hsnn.medstgmini.common.model.ExcelExportDataInfo;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ExportUtil {


	/***
	 * DiaoSmile 刁先森
	 * @category 导出方法(导出的公共方法！都用这个)
	 * @param response
	 * @param list
	 * @param titles
	 * @throws Exception
	 */

	public static void exportExcel(HttpServletResponse response, List<Map<String, Object>> list, List<String> titles,Pagination pagination) throws Exception {
		ExcelExportDataInfo dataInfos = new ExcelExportDataInfo();
		dataInfos.setTitles(titles);
		dataInfos.setExcelExportDatas(list);
		String fileName = (String)pagination.getConditions().get("fileName");
		try {
			response.setContentType("text/html; charset=utf-8");
			response.setContentType("application/octet-stream");
			response.addHeader("Content-Disposition", "attachment;filename=" + new String((fileName+".xls").getBytes("GB2312"),
					"ISO-8859-1"));
			exportExcelDataInfo(dataInfos,response.getOutputStream(), fileName);
			pagination.setSuccess(true);
		} catch (Exception e) {
			/*log.error("", e);*/
			pagination.setSuccess(false);
		}

	}


	/**
	 * DiaoSmile 刁先森
	 *@category 导出excel工具类
	 *@date 2016年6月25日 下午7:49:54
	 */
	public static void exportExcelDataInfo(ExcelExportDataInfo dataInfos, OutputStream os,String str) {
		try {
			if(dataInfos != null) {
				// HSSFWorkbook 97-2003 版本的 ,
				// XSSFWorkbook 2007以上版本的
				Workbook workbook = new HSSFWorkbook();
				Sheet sheet = workbook.createSheet(str);
				
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
					
					sheet.setDefaultColumnStyle(0, getErrorColumnStyle(workbook));
				
				}
				workbook.write(os);
				workbook.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 标题单元格样式 
	 *DiaoSmile 刁先森
	 * @Title: getTitleStyle 
	 * @param workbook
	 * @return 
	 * @return CellStyle
	 * @throws
	 */
	public static CellStyle getTitleStyle(Workbook workbook) {
		CellStyle titleStyel = workbook.createCellStyle();
		HSSFFont font = (HSSFFont) workbook.createFont();
		font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);// 设置粗体
		titleStyel.setFont(font);
		return titleStyel;
	}
	/**
	 * 设置错误单元格样式 
	 *DiaoSmile 刁先森
	 * @Title: getErrorColumnStyle 
	 * @param workbook
	 * @return 
	 * @return CellStyle
	 * @throws
	 */
	public static CellStyle getErrorColumnStyle(Workbook workbook) {
		CellStyle errorColumnStyel = workbook.createCellStyle();
		HSSFFont font = (HSSFFont) workbook.createFont();
//		font.setBoldweight(XSSFFont.BOLDWEIGHT_BOLD);// 设置粗体
		font.setColor(HSSFColor.WHITE.index);
		font.setColor(Font.COLOR_RED);
		errorColumnStyel.setFont(font);
		errorColumnStyel.setFillBackgroundColor(HSSFColor.RED.index);
		return errorColumnStyel;
	}



}
