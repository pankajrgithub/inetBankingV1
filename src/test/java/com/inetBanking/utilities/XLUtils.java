package com.inetBanking.utilities;

import java.io.FileInputStream;

import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;



public class XLUtils {

	public static FileInputStream f1;
	public static XSSFWorkbook wb;
	public static XSSFSheet ws;
	public static XSSFRow row;
	public static XSSFCell cell;
	public static FileOutputStream fo;
	//count number of rows
	public static int getRowCount(String xlfile,String xlsheet) throws IOException
	{
		f1=new FileInputStream(xlfile);
		wb=new XSSFWorkbook(f1);
		ws=wb.getSheet(xlsheet);
		int rowcount=ws.getLastRowNum();
		wb.close();
		f1.close();
		return rowcount;
		
	}
	//count number of column 
	public static int getCellCount(String xlfile,String xlsheet,int rownum) throws IOException {
		f1=new FileInputStream(xlfile);
		wb=new XSSFWorkbook(f1);
		ws=wb.getSheet(xlsheet);
		int cellcount=ws.getRow(rownum).getLastCellNum();	
		wb.close();
		f1.close();
		return cellcount;
	}
	//get cell data from excel----
	public static String getCellData(String xlfile,String xlSheet,int rownum,int cellnum) throws IOException {
		f1=new FileInputStream(xlfile);
		wb=new XSSFWorkbook(f1);
		ws=wb.getSheet(xlSheet);
		row=ws.getRow(rownum);
		cell=row.getCell(cellnum);
		
		String data;
		try {
		DataFormatter formatter=new DataFormatter();
		String cellData=formatter.formatCellValue(cell);
		return cellData;
		}catch(Exception e) {
			data="";
		}
		wb.close();
		f1.close();
		return data;
	}
	//insert data into excel file
	public static void setCellData(String xlfile,String xlSheet,int rownum,int cellnum,String data) throws IOException {
		f1=new FileInputStream(xlfile);
		wb=new XSSFWorkbook(f1);
		ws=wb.getSheet(xlSheet);
		row=ws.getRow(rownum);
		cell=row.createCell(cellnum);
		cell.setCellValue(data);
		fo=new FileOutputStream(xlfile);
		wb.write(fo);
		wb.close();
		f1.close();
		fo.close();
		
	}
	
}
