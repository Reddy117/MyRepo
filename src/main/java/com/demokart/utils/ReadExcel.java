package com.demokart.utils;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel {
	public FileInputStream f;
	public Workbook w;
	public XSSFSheet s;
	public XSSFRow r;
	public XSSFCell c;
	
	public String getCellData(String sheetName,int colNum,int rowNum){
		try{
			f=new FileInputStream(System.getProperty("user.dir")+"/src/test/resources/Data/TestData.xlsx");
			w=new XSSFWorkbook(f);
			s=(XSSFSheet) w.getSheet(sheetName);
			r=s.getRow(rowNum);
			c=r.getCell(colNum);
			
			return c.getStringCellValue();
					
			
		}catch(Exception e){
			return null;
		}
	}
	
}
