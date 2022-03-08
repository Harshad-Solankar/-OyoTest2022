package roomBooking_POM_Class;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogIn 
{   
	private WebDriver driver;
	
	@FindBy (xpath = "//button[@data-logintype='password']")
	private WebElement logInByPassword;
	
	@FindBy (xpath = "//input[@class='textTelInput__input']")
	private WebElement enterMobileNo_Field;
	
	@FindBy (xpath = "//input[@class='textInput__input']")
	private WebElement enterPassword_Field;
	
	@FindBy (xpath = "//button[@class='loginCard__button']")
	private WebElement verfifyNumberButton;
	
	
	public LogIn (WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}
	
	
	public void clickForLogInByPassword ()
	{
		logInByPassword.click();
	}
	
    public void sendKeyEnterMobileNo_Field(String mobileno )
    {
    	enterMobileNo_Field.sendKeys(mobileno);	
    }
    
    public void enterPassword_Field(String password)
    {
    	enterPassword_Field.sendKeys(password);
    }
    
    public void clickVerfifyNumberButton()
    {
    	verfifyNumberButton.click();
    }
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
