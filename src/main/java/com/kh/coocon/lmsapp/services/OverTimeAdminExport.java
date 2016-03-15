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
import org.apache.poi.hssf.util.CellRangeAddress;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.springframework.web.servlet.view.document.AbstractExcelView;

import com.kh.coocon.lmsapp.entities.OverTime;

public class OverTimeAdminExport extends AbstractExcelView{

	@Override
	protected void buildExcelDocument(Map<String, Object> model,
			HSSFWorkbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		try {

			List<OverTime> listOTAdmin = (List<OverTime>) model.get("otAdmin");

			// create a new Excel sheet
			HSSFSheet sheet = workbook.createSheet("Over Time List");
			// sheet.setDisplayGridlines(false);
			sheet.setDefaultColumnWidth(15);
			sheet.setDefaultRowHeightInPoints(15);
			sheet.setColumnWidth(0, 2000);
			sheet.setColumnWidth(2, 2000);
			sheet.setColumnWidth(4, 10000); // set column width to culumn 4 (= Reason column)
			
			// create style for header cells
			CellStyle style = workbook.createCellStyle();
			Font font = workbook.createFont();
			style.setFillForegroundColor(HSSFColor.BLUE_GREY.index); // set background color to Header
			style.setFillPattern(CellStyle.SOLID_FOREGROUND);
			style.setAlignment(CellStyle.ALIGN_CENTER);
			
			font.setFontName("Arial");
			font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
			font.setColor(HSSFColor.WHITE.index);
			font.setFontHeightInPoints((short)13);
			
			style.setFont(font);

			// create Title row
			HSSFRow topheader = sheet.createRow(1);
			HSSFCell topheaderCell =topheader.createCell(1);
			CellStyle topheaderStyle= workbook.createCellStyle();
			Font topheaderFont= workbook.createFont();
			topheaderCell.setCellValue("Admin OT List");
			sheet.addMergedRegion(new CellRangeAddress(1,1,1,4)); //sheet.addMergedRegion(rowFrom,rowTo,colFrom,colTo); Merge Cell from B2 to C2
			topheaderStyle.setAlignment(CellStyle.ALIGN_CENTER);

			topheaderFont.setFontHeightInPoints((short)15);
			topheaderFont.setFontName("Arial");
			topheaderFont.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
			
			topheaderStyle.setFont(topheaderFont);
			topheaderCell.setCellStyle(topheaderStyle);//set style to top header
			topheader.setHeight((short)500); 
			
			//create header row
			HSSFRow header = sheet.createRow(3);
			
			header.createCell(0).setCellValue("ID");
			header.getCell(0).setCellStyle(style);

			header.createCell(1).setCellValue("Start Date");
			header.getCell(1).setCellStyle(style);
			
			sheet.addMergedRegion(new CellRangeAddress(3,3,2,3));
			header.createCell(2).setCellValue("Duration");
			header.getCell(2).setCellStyle(style);

			header.createCell(4).setCellValue("Reason");
			header.getCell(4).setCellStyle(style);
			
			header.createCell(5).setCellValue("Status");
			header.getCell(5).setCellStyle(style);

			// create style for each row
			CellStyle rowStyle= workbook.createCellStyle();
			rowStyle.setAlignment(CellStyle.ALIGN_CENTER);

			// create data rows
			int rowCount = 4;
			int id=1;
			String ottype="";
			for (OverTime aot : listOTAdmin) {
				HSSFRow aRow = sheet.createRow(rowCount++);

				// set data to each row
				aRow.createCell(0).setCellValue(id++);
				aRow.getCell(0).setCellStyle(rowStyle);
				
				aRow.createCell(1).setCellValue(aot.getoTDate());
				aRow.getCell(1).setCellStyle(rowStyle);
				
				aRow.createCell(2).setCellValue(aot.getoTDuration());
				aRow.getCell(2).setCellStyle(rowStyle);
				
				if((aot.getoTType())==1) {
					ottype="Day(s)";
				} else if((aot.getoTType())==2) {
					ottype="Hour(s)";
				}
				aRow.createCell(3).setCellValue(ottype);
				aRow.getCell(3).setCellStyle(rowStyle);
				
				aRow.createCell(4).setCellValue(aot.getoTReason());
				aRow.getCell(4).setCellStyle(rowStyle);
				
				aRow.createCell(5).setCellValue(aot.getStatusNm());
				aRow.getCell(5).setCellStyle(rowStyle);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
