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

import com.kh.coocon.lmsapp.entities.Leaves;

public class LeavesRequestExport extends AbstractExcelView{

	@Override
	protected void buildExcelDocument(Map<String, Object> model,
			HSSFWorkbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		try {

			List<Leaves> leavesRequestAdmin = (List<Leaves>) model.get("leavesRequestAdmin");

			// create a new Excel sheet
			HSSFSheet sheet = workbook.createSheet("Leaves Request List");
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
			topheaderCell.setCellValue("Leaves Request List");
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

			header.createCell(1).setCellValue("Full Name");
			header.getCell(1).setCellStyle(style);
			
			header.createCell(2).setCellValue("Start Date");
			header.getCell(2).setCellStyle(style);
			
			header.createCell(3).setCellValue("End Date");
			header.getCell(3).setCellStyle(style);
			
			header.createCell(4).setCellValue("Duration");
			header.getCell(4).setCellStyle(style);
			
			/*sheet.addMergedRegion(new CellRangeAddress(3,3,2,3));
			header.createCell(2).setCellValue("Duration");
			header.getCell(2).setCellStyle(style);*/

			header.createCell(5).setCellValue("Reason");
			header.getCell(5).setCellStyle(style);
			
			header.createCell(6).setCellValue("Leaves Type");
			header.getCell(6).setCellStyle(style);
			
			header.createCell(7).setCellValue("Status");
			header.getCell(7).setCellStyle(style);

			// create style for each row
			CellStyle rowStyle= workbook.createCellStyle();
			rowStyle.setAlignment(CellStyle.ALIGN_CENTER);
			
			// create data rows
			int rowCount = 4;
			int id=1;
			String lrStatus="";
			String lrType="";
			for (Leaves lr : leavesRequestAdmin) {
				HSSFRow aRow = sheet.createRow(rowCount++);

				// set data to each row
				aRow.createCell(0).setCellValue(id++);
				aRow.getCell(0).setCellStyle(rowStyle);
				
				aRow.createCell(1).setCellValue(lr.getLeavesEmpName());
				aRow.getCell(1).setCellStyle(rowStyle);
				
				aRow.createCell(2).setCellValue(lr.getLeavesStartdate());
				aRow.getCell(2).setCellStyle(rowStyle);
				
				aRow.createCell(3).setCellValue(lr.getLeavesEnddate());
				aRow.getCell(3).setCellStyle(rowStyle);
				
				aRow.createCell(4).setCellValue(lr.getLeavesDuration());
				aRow.getCell(4).setCellStyle(rowStyle);
				
				aRow.createCell(5).setCellValue(lr.getLeavesReason());
				aRow.getCell(5).setCellStyle(rowStyle);
				
				if((lr.getLeavesType())==0) {
					lrType="Annual Leave";
				} else if((lr.getLeavesType())==1) {
					lrType="Sick Leave";
				}else if((lr.getLeavesType())==2) {
					lrType="Special Leave";
				}
				aRow.createCell(6).setCellValue(lrType);
				aRow.getCell(6).setCellStyle(rowStyle);
				
				if((lr.getLeavesStatus())==1) {
					lrStatus="Planned";
				} else if((lr.getLeavesStatus())==2) {
					lrStatus="Approved";
				}else if((lr.getLeavesStatus())==3) {
					lrStatus="Rejected";
				}else if((lr.getLeavesStatus())==4) {
					lrStatus="Requested";
				}
				aRow.createCell(7).setCellValue(lrStatus);
				aRow.getCell(7).setCellStyle(rowStyle);
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
