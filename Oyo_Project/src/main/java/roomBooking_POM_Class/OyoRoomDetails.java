package roomBooking_POM_Class;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OyoRoomDetails 
{
 private WebDriver driver;
     
 
 
 
	 @FindBy (xpath = "//span[text()='Continue to Book']")
	 private WebElement booking; 

	 public OyoRoomDetails(WebDriver driver)
	 {
		 PageFactory.initElements(driver, this);
		 this.driver = driver;
	 }
	 
	 
	 public void bookingClick() throws InterruptedException
	 {
		 JavascriptExecutor js = (JavascriptExecutor)driver; 
 	   	 js.executeScript("arguments[0].scrollIntoView(true);", booking);
 	   	 Thread.sleep(3000);
		 booking.click();
	 }
	 
	 
	   public static String getDataFromExcel(String sheet, int row , int cell) throws EncryptedDocumentException, IOException
	    {
	    	String path = "D:\\Velocty Automation Class\\Excel Sheet Data\\Oyo Excel Data\\Oyo Data.xlsx";
	    	FileInputStream file = new FileInputStream(path);
	    	
	    	String testData= "";
	    	
	    	Sheet sheet1 =WorkbookFactory.create(file).getSheet(sheet);
	    	
	    	try
	    	{
	    		testData = sheet1.getRow(row).getCell(cell).getStringCellValue();
	    	}
	    	catch (IllegalStateException h)
	    	{
	    		double testData01 = sheet1.getRow(row).getCell(cell).getNumericCellValue();
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
