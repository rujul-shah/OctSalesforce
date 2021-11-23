package Pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class afterLoginPage {

	public afterLoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//span[@id='userNavLabel']")
	public WebElement userNavlable;
	
	@FindBy(xpath="//div[@id='userNav-menuItems']/child::*")
	public List<WebElement> userMenuItem;
	
	/*Test Case 6*/
	@FindBy(xpath = "//div[@id='userNav-menuItems']/child::a[1]")
	public WebElement userProfile;

	@FindBy(xpath = "//*[@id='chatterTab']/div[2]/div[2]/div[1]/h3/div/div/a")
	public WebElement editProfile;
	
	@FindBy(xpath = "//li[@id='aboutTab']/child::a[1]")
	public WebElement aboutTab;
	
	@FindBy(id="lastName")
	public WebElement lastName;
	
	@FindBy(xpath = "//*[@id='TabPanel']/div/div[2]/form/div/input[1]")
	public WebElement saveAll;
	
	@FindBy(xpath = "//span[@id='tailBreadcrumbNode']")
	public WebElement labelText;
	
	@FindBy(id = "publisherAttachTextPost")
	public WebElement attachPhoto;
	
	@FindBy(xpath = "//iframe[contains(@title,'Rich Text Editor, publisherRichTextEditor')]")
	public WebElement editor;
	
	@FindBy(xpath = "/html/body")
	public WebElement content;
	
	@FindBy(xpath = "//input[@id='publishersharebutton']")
	public WebElement publishButton;
	
	@FindBy(xpath = "//a[@id='publisherAttachContentPost']/span[1]")
	public WebElement publishAttach;
	
	@FindBy(xpath = "//td[@id='chatterUploadFileActionPanel']/a")
	public WebElement uploadFile;
	
	@FindBy(id = "chatterFile")
	public WebElement chatterFile;
	
	@FindBy(id = "publishersharebutton")
	public WebElement shareButton;
		
	@FindBy(xpath = "//span[@class='moderatorBadge']")
	public WebElement badge;
	
	@FindBy(xpath="//a[@id='uploadLink']")
	public WebElement upload;
	
	@FindBy(id = "uploadPhotoContentId")
	public WebElement photoID;
	
	@FindBy(xpath = "//input[@id='j_id0:uploadFileForm:uploadInputFile']")
	public WebElement chooseFile;
	
	@FindBy(xpath = "//input[@id='j_id0:uploadFileForm:uploadBtn']")
	public WebElement uploadButton;
	
	@FindBy(xpath = "//input[@id='j_id0:j_id7:save']")
	public WebElement saveButton;
	
	/*TestCase 8*/
	@FindBy(xpath = "//div[@id='userNav-menuItems']/child::a[3]")
	public WebElement developerConsole;
	
	/*TestCase 9*/
	
	@FindBy(xpath = "//div[@id='userNav-menuItems']/child::a[5]")
	public WebElement logout;
}
