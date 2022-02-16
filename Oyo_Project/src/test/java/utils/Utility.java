package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.apache.poi.EncryptedDocumentException;
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
    	
    	
    	 File destination = new File("D:\\Velocty Automation Class\\Automation Screenshot\\Oyo Screenshots\\" + browserName + "TestID-" + testId + " " + dateTime + ".PNG");
    	 FileHandler.copy(src, destination);
    		
  
    }
    
    public static String getDataFromExcel(String sheet, int row , int cell) throws EncryptedDocumentException, IOException
    {
    	String path = "D:\\Velocty Automation Class\\Excel Sheet Data\\Oyo Excel Data\\Oyo Data.xlsx";
    	FileInputStream file = new FileInputStream(path);
    	
    	String testData = WorkbookFactory.create(file).getSheet(sheet).getRow(row).getCell(cell).getStringCellValue();
        return testData;
    }
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
