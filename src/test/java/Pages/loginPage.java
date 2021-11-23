package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class loginPage {
	
	public loginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	@FindBy(id="username")
	public WebElement username;
	
	@FindBy(id="password")
	public WebElement password;
	
	@FindBy(id="Login")
	public WebElement login;
	
	@FindBy(id="error")
	public WebElement error;
	
	@FindBy(xpath = "//*[@id='rememberUn']")
	public WebElement rememberMe;
	
	@FindBy(id="forgot_password_link")
	public WebElement forgotPassword;

	@FindBy(xpath = "//*[@id='un']")
	public WebElement fUname;
	
	@FindBy(id="continue")
	public WebElement fContinue;
	
	@FindBy(xpath = "//div[@class='message']/p")
	public WebElement fMessage;
	
	@FindBy(xpath="//span[@id='userNavLabel']")
	public WebElement userNavlable;
	
	@FindBy(xpath="//a[@title='Logout']")
	public WebElement logOut;
	

}

