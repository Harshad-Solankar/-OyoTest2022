package roomBooking_POM_Class;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OfficialOyoBlog 
{
    private WebDriver driver;
	
	@FindBy (xpath= "(//div[@class='widget widget_archive'])//ul//li[1]//a")
	private WebElement firstArchives;
	
	
	public OfficialOyoBlog (WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	    this.driver=driver;
	}
	

	public void clickFirstArchives()
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true);", firstArchives);
		firstArchives.click();
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
