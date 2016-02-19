package com.kh.coocon.lmsapp.services;


import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.springframework.web.servlet.view.document.AbstractExcelView;

import com.kh.coocon.lmsapp.entities.HrManagement;

@SuppressWarnings("deprecation")
public class HumanResourceExport extends AbstractExcelView {

	@Override
	protected void buildExcelDocument(Map<String, Object> model,
			HSSFWorkbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		//get data model which is passed by the Spring container
		List<HrManagement> hrManagement = (List<HrManagement>)model.get("hrListExports");
		
		//create a new Excel sheet
		HSSFSheet sheet = workbook.createSheet("Human Resource List");
		sheet.setDefaultColumnWidth(20);
		
		//create style for header cells
		CellStyle cellstyle = workbook.createCellStyle();
		Font font = workbook.createFont();
		font.setFontName("Times New Roman");
		cellstyle.setFillBackgroundColor(HSSFColor.GREEN.index);
		cellstyle.setFillPattern(CellStyle.SOLID_FOREGROUND);
		font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
		font.setColor(HSSFColor.WHITE.index);
		cellstyle.setFont(font);
		
		//create header row
		HSSFRow header = sheet.createRow(0);
		
		header.createCell(0).setCellValue("ID");
		header.getCell(0).setCellStyle(cellstyle);
		header.createCell(1).setCellValue("Status");
		header.getCell(1).setCellStyle(cellstyle);
		header.createCell(2).setCellValue("First Name");
		header.getCell(2).setCellStyle(cellstyle);
		header.createCell(3).setCellValue("Last Name");
		header.getCell(3).setCellStyle(cellstyle);
		header.createCell(4).setCellValue("Contact Number");
		header.getCell(4).setCellStyle(cellstyle);
		header.createCell(5).setCellValue("Email");
		header.getCell(5).setCellStyle(cellstyle);
		header.createCell(6).setCellValue("Department");
		header.getCell(6).setCellStyle(cellstyle);
		header.createCell(7).setCellValue("Contrast");
		header.getCell(7).setCellStyle(cellstyle);
		header.createCell(8).setCellValue("Manager");
		header.getCell(8).setCellStyle(cellstyle);
		
		//Create data rows
		int rowCount = 1;
		for(HrManagement hrItem:hrManagement){
			HSSFRow aRow = sheet.createRow(rowCount++);
			aRow.createCell(0).setCellValue(hrItem.getId());
			aRow.createCell(1).setCellValue(hrItem.getStatus());
			aRow.createCell(2).setCellValue(hrItem.getFirstName());
			aRow.createCell(3).setCellValue(hrItem.getLastName());
			aRow.createCell(4).setCellValue(hrItem.getPhone());
			aRow.createCell(5).setCellValue(hrItem.getEmail());
			aRow.createCell(6).setCellValue(hrItem.getDepartment());
			aRow.createCell(7).setCellValue(hrItem.getContract());
			aRow.createCell(8).setCellValue(hrItem.getManager());
		}
	}

}
