package roomBooking_POM_Class;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LowerHeader 
{
    private WebDriver driver;
	
    @FindBy (xpath="//a[text()='About Us']")
    private WebElement aboutUs;
    
    @FindBy (xpath ="//a[text()='Teams / Careers']")
    private WebElement teams_Careers;
    
	@FindBy (xpath= "//a[text()='Blogs']")
	private WebElement blogs;
	
	@FindBy (xpath = "//a[text()='Support']")
	private WebElement support;
	
	@FindBy (xpath = "//a[text()='Official OYO Blog']")
	private WebElement officialOYOBlog;
	
	@FindBy (xpath = "//a[text()='Investor Relations']")
	private WebElement investorRelations;
	
	@FindBy (xpath = "//a[text()='OYO Circle']")
	private WebElement oYO_Circle;
	
	@FindBy (xpath = "//a[text()='OYO Frames']")
	private WebElement oYO_Frames;
	
	
	
	public LowerHeader (WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
	

	public void clickOfficialOYOBlog()
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true);", officialOYOBlog);
		officialOYOBlog.click();
	}	
	
	
}
