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
			topheaderCell.setCellValue("Over Time List");
			sheet.addMergedRegion(new CellRangeAddress(1,1,1,3)); //sheet.addMergedRegion(rowFrom,rowTo,colFrom,colTo); Merge Cell from B2 to C2
			topheaderStyle.setAlignment(CellStyle.ALIGN_CENTER);

			topheaderFont.setFontHeightInPoints((short)13);
			topheaderFont.setFontName("Arial");
			topheaderFont.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
			
			topheaderStyle.setFont(topheaderFont);
			topheaderCell.setCellStyle(topheaderStyle);//set style to top header
			
			//create header row
			HSSFRow header = sheet.createRow(3);
			
			header.createCell(0).setCellValue("ID");
			header.getCell(0).setCellStyle(style);

			header.createCell(1).setCellValue("Date");
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
			String otStatus="";
			String ottype="";
			for (OverTime aot : listOT) {
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
				
				if((aot.getoTStatus_id())==1) {
					otStatus="Planned";
				} else if((aot.getoTStatus_id())==4) {
					otStatus="Requested";
				}
				aRow.createCell(5).setCellValue(otStatus);
				aRow.getCell(5).setCellStyle(rowStyle);
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
