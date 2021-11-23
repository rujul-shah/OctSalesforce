package Utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.utils.FileUtil;

import Base.BaseTest;
import freemarker.template.SimpleDate;

public class CommonUtilities {
	
	//to take the screenshot
	public void takeScreenshot() throws IOException
	{
		TakesScreenshot screenshot = (TakesScreenshot)BaseTest.driver;
		String sDate = new SimpleDateFormat("ddmmyyyyhhmmss").format(new Date());
		String sDstFilepath = System.getProperty("user.dir")+"/Reorts/Screenshot/"+sDate+".png";
		File fSrcFile = screenshot.getScreenshotAs(OutputType.FILE);
		File fDstFile = new File(sDstFilepath);
		FileUtils.copyFile(fSrcFile, fDstFile);

	}
	//To enterText in input box
	public void enterText(WebElement element,String inputText, String elementName)
	{
		if(element.isDisplayed())
		{
			element.clear();
			element.sendKeys(inputText);
			BaseTest.test.log(Status.INFO, "Text added to "+elementName);
		}
		else
		{
			BaseTest.test.log(Status.INFO,elementName+" not found!!");
		}
	}
	//To click
	public void click(WebElement element, String elementName)
	{
		if(element.isDisplayed())
		{
			element.click();
			BaseTest.test.log(Status.INFO, elementName+" Clicked.");
		}
		else
			BaseTest.test.log(Status.INFO,elementName+" not found!!");
	}
	//To compare 2 texts
	public void compareText(String originalText, String outputText, String msg)
	{
		BaseTest.sa.assertEquals(originalText, outputText);
		BaseTest.test.log(Status.INFO,msg+" verified successfully.");
	}
	//To wait till the element is loaded
	public boolean waitForElement(WebElement element)
	{
		try
		{
			WebDriverWait wait = new WebDriverWait(BaseTest.driver, 3000);
			wait.until(ExpectedConditions.visibilityOf(element));
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}
	//login
	public void login() throws IOException
	{
		String[] creds= new String[2];
		creds=BaseTest.objData.readCredentials();
		BaseTest.objCommon.enterText(BaseTest.lp.username, creds[0], "Username");
		BaseTest.objCommon.enterText(BaseTest.lp.password, creds[1], "Password");
		BaseTest.objCommon.click(BaseTest.lp.login, "Login button");
		if(BaseTest.objCommon.waitForElement(BaseTest.lp.userNavlable))
		{
			BaseTest.test.pass("Logged in successfully.");
		}
		
		
	}
	//logout
	public void logOut() throws IOException
	{
		BaseTest.objCommon.waitForElement(BaseTest.lp.userNavlable);
		BaseTest.objCommon.click(BaseTest.lp.userNavlable, "Usermenu clicked.");
		BaseTest.objCommon.click(BaseTest.lp.logOut, "Logout clicked.");
		BaseTest.sa.assertEquals(BaseTest.driver.getCurrentUrl(), BaseTest.objData.readPageURL("Salesforce.logout"));
		BaseTest.test.pass("Logout succes");
	}
}
