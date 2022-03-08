package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;

public class Browser 
{
	public static WebDriver launchChromeBrowser()
	{
		System.setProperty("webdriver.chrome.driver", "F:\\Velocity Class"
		+ "\\Software\\Selenium\\Chrome file\\New folder\\chromedriver.exe");
    	WebDriver driver = new ChromeDriver();
    	return driver;
	}
	public static WebDriver launchFirefoxBrowser()
	{
		System.setProperty("webdriver.gecko.driver", "F:\\Velocity Class"
		+ "\\Software\\Selenium\\Firefox\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		return driver;
	}
	public static WebDriver launchOperaBrowser()
	{
		System.setProperty("webdriver.opera.driver", "F:\\Velocity Class"
	+ "\\Software\\Selenium\\Opera\\operadriver_win64\\operadriver.exe");
		WebDriver driver = new OperaDriver();
		return driver;
	}
	public static WebDriver launchEdgeBrowser()
	{
		System.setProperty("webdriver.edge.driver", "F:\\Velocity Class"
		+ "\\Software\\Selenium\\MicrosoftEdge\\msedgedriver.exe");
    	WebDriver driver = new EdgeDriver();
    	return driver;
	}
	
	public static WebDriver launchIEBrowser()
	{
		System.setProperty("webdriver.ie.driver", "F:\\Velocity Class\\Software\\Selenium\\Internet Explorer\\IEDriverServer.exe");
    	WebDriver driver = new InternetExplorerDriver();
    	return driver;
	}
}
