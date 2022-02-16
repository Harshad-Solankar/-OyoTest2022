package roomBooking_POM_Class;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RoomSelect 
{
		
	
//	@FindBy (xpath = "(//button[@class='c-1k6asfw d-greenButton'])[1]")
//	    private WebElement oyoRoomselect01;
	
	@FindBy (xpath = "//div[@class='listingHotelDescription__contentWrapper'][1]")
	    private WebElement oyoRoomselect01;
	    
	   
	    public RoomSelect (WebDriver driver)
	    {
	    	PageFactory.initElements(driver, this);
	    	
	    }
	    
	    public void oyoRoomClick ()
	    {
	    	oyoRoomselect01.click();
	    }
}
