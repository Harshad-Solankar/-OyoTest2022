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

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import base.Browser;
import roomBooking_POM_Class.Header;
import roomBooking_POM_Class.LogIn;
import roomBooking_POM_Class.LowerHeader;
import roomBooking_POM_Class.OfficialOyoBlog;
import utils.Utility;

public class Test02 extends Browser
{
	private WebDriver driver;
	private Header header;
	private LogIn logIn;
	private LowerHeader lowerHeader; 
	private OfficialOyoBlog officialOyoBlog;
	private int testId;
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
		    			browserName= "Chrome T02 ";
		    			
		    	}
	    	
	    	if(browser.equalsIgnoreCase("FireFox"))
		    	{
		    			driver = launchFirefoxBrowser();
		    			browserName= "FireFox T02 ";
		    	}
	    	
	    	if(browser.equalsIgnoreCase("Opera"))
		    	{
		    			driver = launchOperaBrowser();
		    			browserName= "Opera T02 ";
		    	}
	    	
	    	if(browser.equalsIgnoreCase("MicrosoftEdge"))
		    	{
		    		 	driver = launchEdgeBrowser();
		    		 	browserName= "MicrosoftEdge T02 ";
		    	}
	    	
	    	if(browser.equalsIgnoreCase("InternetExplorer"))
		    	{
				    	driver = launchIEBrowser();
	    				browserName= "InternetExplorer T02 ";
		    	}
		    	
			    	driver.manage().window().maximize();
					driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);	
	    			
	    }
	
	
	
	@BeforeClass
		public void objectsOfPOMMethods()
		{
			header = new Header (driver);
			logIn = new LogIn(driver);
			lowerHeader = new LowerHeader(driver);
			officialOyoBlog = new OfficialOyoBlog(driver);
		}
    
	
    @BeforeMethod
	    public void UrlAnd_Login() throws EncryptedDocumentException, IOException
	    {
	    	driver.get("https://www.oyorooms.com/");
	    			header.clickLogin_Signup();
	
	    			logIn.clickForLogInByPassword();
	    	String mobileNo = Utility.getDataFromExcel("Sheet1", 2, 0);
	    	
	    			logIn.sendKeyEnterMobileNo_Field(mobileNo);
	    	String password = Utility.getDataFromExcel("Sheet1", 2, 1);		
	    			logIn.enterPassword_Field(password);
	    			logIn.clickVerfifyNumberButton();	
	    }
    
    @Test
	    public void testOfficialOYOBlog() throws InterruptedException 
	    {           testId = 105;
    	
    				Thread.sleep(3000);
	 
	    			lowerHeader.clickOfficialOYOBlog();
	    			
	    	ArrayList<String> add = new ArrayList<String>(driver.getWindowHandles());
	    			driver.switchTo().window(add.get(1));
	    	
	    			officialOyoBlog.clickFirstArchives();
	    			
	    	String currentUrl= driver.getCurrentUrl();
	    				if (currentUrl.equals("https://www.oyorooms.com/officialoyoblog/2022/02"))
	    				{
	    					 System.out.println("PASS// URl is Matched");
	    					 
	    		        }
	    				else
	    				{
	    					System.out.println("FAIL// URl is not Matched");
	    				}
	    	String currentTitle = driver.getTitle();
				    	if (currentTitle.equals("February 2022 - Official OYO Blog"))
						{
							 System.out.println("PASS// Title is Matched");
				        }
						else
						{
							System.out.println("FAIL// Tile is not Matched");
						}
	    }

    @AfterMethod
    	public void captureScreenShot(ITestResult result) throws IOException
    	{ 
    	      
    		if (ITestResult.FAILURE == result.getStatus())
    		{
    			Utility.captureScreenshot(driver, testId, browserName);
    		}
    	}
    @AfterClass
	public void clearObjectsOfPOMMethods()
		{
			header = null;
			logIn = null;
			lowerHeader = null;
			officialOyoBlog = null;
		}
    @AfterTest
	    public void browserclose()
	    {
	    	driver.quit();
	    	driver = null;
	    	System.gc();
	    }
	    
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
