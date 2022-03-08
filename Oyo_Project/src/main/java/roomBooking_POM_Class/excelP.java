package roomBooking_POM_Class;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;



public class excelP      
{     
	public static String excel01  (String sheetName, int row01, int cell01) throws EncryptedDocumentException, IOException
	{      
		String test04;
		
		 String path = "D:\\Velocty Automation Class\\Excel Sheet Data\\Oyo Excel Data\\Oyo Data 01.xlsx";
		 FileInputStream file = new FileInputStream(path);
		 
//		 Cell cellValue = WorkbookFactory.create(file).getSheet("Sheet1").getRow(6).getCell(0);
		Sheet sheet= WorkbookFactory.create(file).getSheet(sheetName);
//		 	System.out.println(cellValue);
		 	try
		 	{
		 		 test04 =sheet.getRow(row01).getCell(cell01).getStringCellValue();
		 		System.out.println(test04);
		 	}
		 	
		 	catch(IllegalStateException m)
		 	{
		 	double test01 = sheet.getRow(row01).getCell(cell01).getNumericCellValue();
		 	long test02 = (long)test01;
		 	test04 = String.valueOf(test02);
		 	System.out.println(test01);
		 	} 
		 	
		 	return test04;
		
	}
	
	
	
	
	 public static void main (String[]args) throws EncryptedDocumentException, IOException
	 {
		 String path01 = "D:\\Velocty Automation Class\\Excel Sheet Data\\Oyo Excel Data\\Oyo Data 01.xlsx";
		 FileInputStream file01 = new FileInputStream(path01);
		 
//		 String value = WorkbookFactory.create(file01).getSheet("Sheet1").getRow(2).getCell(0).getStringCellValue();
//			
//			System.out.println(value); 
		  
		
//		try
//		{
//			String value01 = WorkbookFactory.create(file01).getSheet("Sheet1").getRow(2).getCell(0).getStringCellValue();
//					
//			System.out.println(value01);
//		}
//		catch(IllegalStateException h)
//		{
//			double value01 = WorkbookFactory.create(file01).getSheet("Sheet1").getRow(2).getCell(0).getNumericCellValue();
//					
//			int testData02 = (int)value01 ;
//			String testData03 = String.valueOf(testData02);
//			System.out.println(testData03);
//			
//		}
//		catch (Exception z)
//		{
//			z.printStackTrace();
//		}
//		 
		 
		 
		 
		 String path = "D:\\Velocty Automation Class\\Excel Sheet Data\\Oyo Excel Data\\Oyo Data 01.xlsx";
		 FileInputStream file = new FileInputStream(path);
		 
//		 Cell cellValue = WorkbookFactory.create(file).getSheet("Sheet1").getRow(6).getCell(0);
		Sheet sheet= WorkbookFactory.create(file).getSheet("Sheet1");
//		 	System.out.println(cellValue);
		 	try
		 	{
		 		String test04 =sheet.getRow(0).getCell(0).getStringCellValue();
		 		System.out.println(test04);
		 	}
		 	catch(IllegalStateException m)
		 	{
		 	double test01 = sheet.getRow(0).getCell(0).getNumericCellValue();
		 	long test02 = (long)test01;
		 	String test03 = String.valueOf(test02);
		 	System.out.println(test03);
		 	} 
		 
		 	String T01 =OyoRoomDetails.getDataFromExcel("Sheet1", 0, 0);
		    System.out.println(T01);
		 
	 }
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
