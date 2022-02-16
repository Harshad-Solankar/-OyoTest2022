package roomBooking_POM_Class;

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
	 
	 
	 public void bookingClick()
	 {
		 JavascriptExecutor js = (JavascriptExecutor)driver; 
 	   	 js.executeScript("arguments[0].scrollIntoView(true);", booking);	
		 booking.click();
	 }
}
