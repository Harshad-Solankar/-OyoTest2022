import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import base.Browser;
import roomBooking_POM_Class.Header;
import roomBooking_POM_Class.LogIn;
import roomBooking_POM_Class.OyoRoomDetails;
import roomBooking_POM_Class.RoomSelect;
import roomBooking_POM_Class.StayDetails;
import utils.Utility;

public class Test01 extends Browser
{   
	private WebDriver driver;
	private Header header;
	private LogIn logIn;
	private StayDetails staydetails;
	private RoomSelect roomSelect;
	private OyoRoomDetails oyoRoomDetails;
	private int testID;
	private String browserName;
	static ExtentTest test;
	static ExtentHtmlReporter reporter;
	
	
	@BeforeTest
	@Parameters ("browser")
	public void browserOpen(String browser)
		{   
			reporter = new ExtentHtmlReporter("test-output"+File.separator+"ExtendReport"+File.separator+"extendReport.html");
			ExtentReports extend = new ExtentReports();
			extend.attachReporter(reporter); 
		
			if(browser.equalsIgnoreCase("Chrome"))
	    	{
				driver = launchChromeBrowser();
				browserName= "Chrome T01 ";	
	    	}
	    	
	    	if(browser.equalsIgnoreCase("FireFox"))
	    	{
	    		driver = launchFirefoxBrowser();
	    		browserName= "FireFox T01 ";
	    	}
	    	
	    	if(browser.equalsIgnoreCase("Opera"))
	    	{
	    		driver = launchOperaBrowser();
	    		browserName= "Opera T01 ";
	    	}
	    	
	    	if(browser.equalsIgnoreCase("MicrosoftEdge"))
	    	{
	    		driver = launchEdgeBrowser();
	    		browserName= "MicrosoftEdge T01 ";
	    	}
	    	
	//    	if(browser.equalsIgnoreCase("InternetExplorer"))
	//    	{
	//		    	driver = luanchInternetExplorerBrowser();
    //	    		browserName= "InternetExplorer T01 ";
	//    	}
	    	
	    	driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(300, TimeUnit.SECONDS);
	}
	
	
	
	
	
	@BeforeClass
		public void objectsOfPOMMethods()
		{
			header = new Header (driver);
			logIn = new LogIn(driver);
			staydetails = new StayDetails(driver);
			roomSelect = new RoomSelect(driver);
			oyoRoomDetails= new OyoRoomDetails(driver);
		}
 
	
	
	
	
	@BeforeMethod
		public void UrlAnd_Login() throws EncryptedDocumentException, IOException
		{
			driver.get("https://www.oyorooms.com");
			
//					header.clickLogin_Signup();
//					logIn.clickForLogInByPassword();
//					String mobileNO = Utility.getDataFromExcel("O_Details",3,0);
//					logIn.sendKeyEnterMobileNo_Field(mobileNO);
//					String password = Utility.getDataFromExcel("O_Details",3,1);
//					logIn.enterPassword_Field(password);
//					logIn.clickVerfifyNumberButton();
		}
	
	
	
	@Test
		public void test01() throws InterruptedException, EncryptedDocumentException, IOException
		{   
		    testID = 103;
		
			SoftAssert softAssert = new SoftAssert();
						Thread.sleep(3000);
			String attValue= staydetails.locationAtt_Verification();
					softAssert.assertEquals(attValue, "Search by city, hotel, or neighborhood", "FAIL// Location Attribute Values Are Not Matched");
			
	//					if (attValue.equals("Search by city, hotel, or neighborhood"))
	//					{
	//						System.out.println("PASS// Location Attribute Values Are Matched");
	//					}
	//					else
	//				  	{
	//				  	    System.out.println("FAIL// Location Attribute Values Are Not Matched");
	//			  	    }
				String location = Utility.getDataFromExcel("O_Details",7,0);
						staydetails.locationsend(location);
						staydetails.sublocationsClick();
						staydetails.dateClick();
						staydetails.dateArrowClick();
						staydetails.selectDate01Click();
						staydetails.selectDate02Click();
						staydetails.roomClick();
						staydetails.addGuestClick();
						staydetails.addRoomClick();
						staydetails.addGuest01Click();
						staydetails.serachClick();
			
		  
		  				roomSelect.oyoRoomClick();
		  				  
			  ArrayList <String> add = new ArrayList<String>(driver.getWindowHandles());
			  driver.switchTo().window(add.get(1));
			  				
					  		 oyoRoomDetails.bookingClick();
					  		 
			  
			  String title =driver.getTitle();
		//	  		softAssert.assertEquals(title, "SPOT ON 80746 Siddhi Home Stay, SPOT ON Pune,", "PASS// URl is Matched");
				         if (title.startsWith("SPOT ON 80746 Siddhi Home Stay, SPOT ON Pune,"))
				        		
				         {
				        	 System.out.println("PASS// URl is Matched");
				         }
				         else 
				         {
				        	 System.out.println("FAIL// URl is not Matched");
				         }
			  
			         
			  String currentUrl =driver.getCurrentUrl();
				  	softAssert.assertEquals(currentUrl, "https://www.oyorooms.com/112501/?checkin=20%2F02%2F2022&checkout=21%2F02%2F2022&guests=3&modal=bookingSummary&rooms=2&rooms_config=2-1_0-2_0&selected_rcid=272950", "FAIL// Title is not Matched");
			//	         if (currentUrl.equals("https://www.oyorooms.com/112501/?checkin=20%2F02%2F2022&checkout=21%2F02%2F2022&guests=3&modal=bookingSummary&rooms=2&rooms_config=2-1_0-2_0&selected_rcid=272950"))
			//               {
			//     	          System.out.println("PASS// Title is Matched");
			//               }
			//             else 
			//               {
			//     	          System.out.println("FAIL// Title is not Matched");
			//               }
				  	softAssert.assertAll();	
		}
		
	
	@AfterMethod
		public void captureScreenshot(ITestResult result) throws IOException
		{  
		     
			if (ITestResult.FAILURE == result.getStatus())
			{
				Utility.captureScreenshot(driver, testID, browserName);
			}
		
		}
	
	
	@AfterClass
		public void clearObjectsOfPOMMethods()
		{
				header = null;
				logIn = null;
				staydetails = null;
				roomSelect = null;
				oyoRoomDetails= null;
		}
	

	@AfterTest
		public void browserClose()
		{
			    driver.quit();
			    driver = null;
			 System.gc();   
		}

}
