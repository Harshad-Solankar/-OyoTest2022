package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Utility 
{
    public static void captureScreenshot (WebDriver driver, int testId, String browserName) throws IOException
    {
    	File src =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
    	
		    	LocalDateTime currentDateTime = LocalDateTime.now();
		    	DateTimeFormatter formateDateTime = DateTimeFormatter.ofPattern("dd_MM_yyyy HH-mm-ss");
		    	String dateTime = currentDateTime.format(formateDateTime);

    	 File destination = new File("D:\\Velocty Automation Class\\Automation Screenshot"
    	 		+ "\\Oyo Screenshots\\" + 0 + "TestID-" + testId + " " + dateTime + ".PNG");
    	 FileHandler.copy(src, destination);
    }
    
    public static String getDataFromExcel(String sheetName, int row , int cell) 
    		throws EncryptedDocumentException, IOException
    {
    	String path = "D:\\Velocty Automation Class\\Excel Sheet Data\\Oyo Excel Data\\Oyo Data 01.xlsx";
    	FileInputStream file = new FileInputStream(path);
    	
    	String testData="";	
    	Sheet sheet =WorkbookFactory.create(file).getSheet(sheetName);
    	try
    	{
    		testData = sheet.getRow(row).getCell(cell).getStringCellValue();
    	}
    	catch (IllegalStateException h)
    	{
    		double testData01 = sheet.getRow(row).getCell(cell).getNumericCellValue();
    		long testData02 = (long)testData01;
    		testData = String.valueOf(testData02);
    	}
    	catch(NullPointerException m)
    	{
    		System.out.println("No Data Present");
    	}
     	return testData;
    }
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
