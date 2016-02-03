package com.kh.coocon.lmsapp.services;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.sl.usermodel.TextParagraph.FontAlign;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.view.document.AbstractExcelView;

import com.kh.coocon.lmsapp.entities.OverTime;

public class OvertimeExport extends AbstractExcelView{
	
	@Autowired
	private OverTimeService overTimeService;
	
	@Override
	protected void buildExcelDocument(Map<String, Object> model,
			HSSFWorkbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		try {

			List<OverTime> listOT = (List<OverTime>) model.get("listOT");

			// create a new Excel sheet
			HSSFSheet sheet = workbook.createSheet("Over Time List");
			// sheet.setDisplayGridlines(false);
			sheet.setDefaultColumnWidth(15);
			
			// create style for header cells
			CellStyle style = workbook.createCellStyle();
			Font font = workbook.createFont();
			font.setFontName("Arial");
			style.setFillForegroundColor(HSSFColor.BLUE_GREY.index); // set background color to Header
			style.setFillPattern(CellStyle.SOLID_FOREGROUND);
			font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
			font.setColor(HSSFColor.WHITE.index);
			style.setFont(font);
			

			// create header row
			HSSFRow header = sheet.createRow(3);
			HSSFRow topheader = sheet.createRow(1);
			HSSFCell cell =topheader.createCell(3);
			cell.setCellValue("Over Time List");
			
			header.createCell(0).setCellValue("ID");
			header.getCell(0).setCellStyle(style);

			header.createCell(1).setCellValue("Status_id");
			header.getCell(1).setCellStyle(style);

			header.createCell(2).setCellValue("Date");
			header.getCell(2).setCellStyle(style);

			header.createCell(3).setCellValue("Duration");
			header.getCell(3).setCellStyle(style);
			
			header.createCell(4).setCellValue("Ot_type");
			header.getCell(4).setCellStyle(style);

			header.createCell(5).setCellValue("Cause");
			header.getCell(5).setCellStyle(style);

			// create data rows
			int rowCount = 4;
			int id=1;
			String otStatus="";
			String ottype="";
			for (OverTime aot : listOT) {
				HSSFRow aRow = sheet.createRow(rowCount++);
				aRow.createCell(0).setCellValue(id++);
				if((aot.getoTStatus_id())==1) {
					otStatus="Planned";
				} else if((aot.getoTStatus_id())==4) {
					otStatus="Requested";
				}
				aRow.createCell(1).setCellValue(otStatus);
				aRow.createCell(2).setCellValue(aot.getoTDate());
				aRow.createCell(3).setCellValue(aot.getoTDuration());
				if((aot.getoTType())==1) {
					ottype="Day(s)";
				} else if((aot.getoTType())==2) {
					ottype="Hour(s)";
				}
				aRow.createCell(4).setCellValue(ottype);
				aRow.createCell(5).setCellValue(aot.getoTReason());
				
			}
			/*
			 * HSSFRow row = sheet.createRow(1); HSSFCell cell =
			 * row.createCell(1);
			 * cell.setCellValue("Using ResourceBundleViewResolver");
			 */

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	

}
