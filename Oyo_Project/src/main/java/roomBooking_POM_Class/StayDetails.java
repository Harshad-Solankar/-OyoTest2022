package roomBooking_POM_Class;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class StayDetails  
{
	// after defined Global Vairables ///////////////////////////////////////////
	private WebDriver driver;
	private WebDriverWait wait;
	
	// WebElement And Xpath /////////////////////////////////////////////////////
//	@FindBy (xpath= "//input[@id='autoComplete__header']")
//	private WebElement location ;
	
	@FindBy (xpath= "//input[@autocomplete='off']")
	private WebElement location;
	
	@FindBy (xpath = "(//div[contains(@class,'-phone geoSuggestionsList__')])[1]")
	private WebElement sublocations;
	
	@FindBy (xpath = "//div[contains(@class,'datePickerDesktop ')]")
	private WebElement date;
	
	@FindBy (xpath = "//div[contains(@class,'__PaginationArrow--next')]")
	private WebElement dateArrow;
	
	@FindBy (xpath = "(//span[@class='DateRangePicker__DateLabel'])[21]")
	private WebElement selectDate01;
	
//	@FindBy (xpath = "(//span[text()='20'][1]")
//	private WebElement selectDate01;
	
	@FindBy (xpath= "(//span[@class='DateRangePicker__DateLabel'])[22]")
	private WebElement selectDate02;
	
//	@FindBy (xpath= "(//span[text()='27'])[1]")
//	private WebElement selectDate02;
	
	@FindBy (xpath = "//div[text()='1 Room, 2 Guests']")
	private WebElement room;
	
	@FindBy (xpath= "((//div[contains(@class,'oyo-cell oyo-cell')])[12])//span[1]")
	private WebElement addguest;			
			
//	@FindBy (xpath= "((//div[contains(@class,'oyo-cell oyo-cell')])[12])//span[3]")
//	private WebElement addguest;
	
	@FindBy (xpath = "//button[text()='Add Room']")
	private WebElement addroom;
	
	@FindBy (xpath = "((//div[contains(@class,'oyo-cell oyo-cell')])[15])//span[3]")
	private WebElement addGuest01;

	@FindBy (xpath = "//button[contains(@   class,'u-textCenter')]")
	private WebElement serach;
	
	
	
	// Constructor /////////////////////////////////////////////////////////////
	public StayDetails (WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		this.driver= driver;
		wait = new WebDriverWait(driver, 20);
	}
	
	// All Methods /////////////////////////////////////////////////////////
	
	public String locationAtt_Verification()
	{
		String locationVeri_Text =location.getAttribute("placeholder");
		return locationVeri_Text;
		
	}
	
	public void locationsend(String locationName )
	{
		location.sendKeys(locationName);
	}
	
	public void sublocationsClick ()
	{   
	   wait.until(ExpectedConditions.elementToBeClickable(sublocations)); 
		sublocations.click();
	}
	
	public boolean dateSelect_Verify()
	{
		Boolean dateVerify = date.isEnabled();
		return dateVerify;
	}
	
	public void dateClick ()
	{   
		
		date.click();
	}
	
	
	public void dateArrowClick () throws InterruptedException
	{
//		Thread.sleep(1000);
//	    for(int datearrow=0; datearrow<2; datearrow++)
//	    {  
//	        Thread.sleep(1000);
//	        dateArrow.click();
//	    }
//	    dateArrow.click();
	}
	
	
	public void selectDate01Click ()
	{   
		
		selectDate01.click();
	}
	
	
	public void selectDate02Click ()
	{
		selectDate02.click();
	}
	
	
	public void roomClick ()
	{
		room.click();    
	}
	
	
	public void addGuestClick ()
	{
		addguest.click();
	}
	
	public void addRoomClick()
	{
		addroom.click();
	}
	
	
	public void addGuest01Click () throws InterruptedException
	{
		
//	    for(int addguest01=0; addguest01<=1; addguest01++)
//	    {
//	    	addGuest01.click();
//	    }
	    addGuest01.click();
	}
	
	
	public void serachClick ()
	{ 
		serach.click();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
