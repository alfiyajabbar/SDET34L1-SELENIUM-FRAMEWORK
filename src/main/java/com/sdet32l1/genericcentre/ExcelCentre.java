package com.sdet32l1.genericcentre;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
/**
 * This methos is used to open the excel sheet
 * @author Mypc
 *
 */
public class ExcelCentre {
	static Workbook book;
	public static void openExcel(String filepath) throws IOException
	{
		FileInputStream fis=new FileInputStream(filepath);
     book=WorkbookFactory.create(fis);
    }
	/**
	 * This method is used to fetch the data from the excel sheet
	 */

public static String getDataFromExcel(String sheetname,int rownumber,int cellnumber)
{
	String data=book.getSheet(sheetname).getRow(rownumber).getCell(cellnumber).getStringCellValue();
	return data;
}

/*
 * This method is used to fetch multiple data from excelsheet 
 */
public static Object[][] getMultipleDataFromExcel(String sheetname)
{
	Sheet sh=book.getSheet(sheetname);
	Object[][] arr=new Object[sh.getLastRowNum()+1][sh.getRow(0).getLastCellNum()];
	for(int i=1;i<=sh.getLastRowNum();i++)
	{
		for(int j=0;j<sh.getRow(i).getLastCellNum();j++)
		{
			arr[i][j]=sh.getRow(i).getCell(j).getStringCellValue();
			
		}
	}
	return arr;
}
	


/**
 * This method is used to store the data to the excel sheet
 */
public static void setDatatoExcel(String sheetname,int rownumber,int cellnumber,String value)
{
	book.getSheet(sheetname).getRow(rownumber).createCell(cellnumber).setCellValue(value);
}

/**
 * This methos is used to save data to excel
 * @throws IOException 
 */

public static void writeDatatoExcel(String path) throws IOException
{
	FileOutputStream fos=new FileOutputStream(path);
	book.write(fos);
}

/**
 * This method is used to close the Excel
 * @throws IOException 
 */

public static void  closeExcel() throws IOException
{
	book.close();
}
}




