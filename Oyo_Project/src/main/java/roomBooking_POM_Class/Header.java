package roomBooking_POM_Class;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Header 
{
   @FindBy (xpath = "//div[@data-cms-template='cWeb-Properties'][1]")
   private WebElement becomeMemberH1;
   
   
   @FindBy (xpath = "//div[@data-cms-name='cWEB-OYOBIN']")
   private WebElement oyoForBusinessH2;
   
   @FindBy (xpath = "//div[@data-cms-template='cWeb-Properties'][2]")
   private WebElement listYourPropertyH3; 
   
   @FindBy (xpath = "//div[@headerprimary__rightheader='true']")
   private WebElement langugesSuppotH4;
   
   
   @FindBy (xpath = "//div[@data-cms-template='cWEB-SideMenu']")
   private WebElement login_SignupH5;
   
   
   public Header (WebDriver driver)
   {
	   PageFactory.initElements(driver, this);
   }
   
   
   
   public void clickBecomeMember ()
   {
	   becomeMemberH1.click();
   }
   
   public void clickOyoForBusinessH2()
   {
	   oyoForBusinessH2.click();
   }

   public void clickListYourPropertyH3()
   {
	   listYourPropertyH3.click();
   }
	
   public void clickLangugesSuppotH4()
   {
	   langugesSuppotH4.click();
   }

   public void clickLogin_Signup()
   {
	   login_SignupH5.click();
   }
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
