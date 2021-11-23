package TestCases;

import java.io.IOException;

import org.testng.annotations.Test;

import Base.BaseTest;
import Pages.loginPage;

public class login extends BaseTest{
	
	
	
	@Test
	public void tc01VerifyLogin() throws IOException
	{
		lp=new loginPage(driver);
		
		objCommon.waitForElement(lp.username);
		objCommon.enterText(lp.username, objData.readCredentials()[0], "Username");
		lp.password.clear();
		objCommon.click(lp.login, "Login button");
		objCommon.waitForElement(lp.error);
		sa.assertEquals(lp.error.getText(), objData.readPageURL("login.error"));
		test.pass("Test Case 01 passed.");
	}

	@Test
	public void tc02Login() throws IOException
	{
		lp=new loginPage(driver);
		objCommon.login();
		test.pass("Test Case 02 passed.");
	}
	@Test
	public void tc03Rememberme() throws IOException
	{
		lp=new loginPage(driver);
		objCommon.waitForElement(lp.rememberMe);
		objCommon.click(lp.rememberMe, "Remember Me");
		objCommon.login();
		objCommon.waitForElement(lp.userNavlable);
		objCommon.click(lp.userNavlable, "Usermenu Dropdown");
		objCommon.click(lp.logOut, "Logout");
		objCommon.waitForElement(lp.rememberMe);
		if(!lp.rememberMe.isSelected())
		{
			test.pass("Test Case 03 passed.");
		}
	}
	@Test
	public void tc04Forgotpwd() throws IOException
	{
		lp=new loginPage(driver);
		objCommon.click(lp.forgotPassword, "Forgot Password");
		objCommon.waitForElement(lp.fUname);
		objCommon.enterText(lp.fUname, objData.readCredentials()[0], "Username of forgot password");
		objCommon.click(lp.fContinue, "Continue of forgot password");
		objCommon.waitForElement(lp.fMessage);
		sa.assertEquals(lp.fMessage, objData.readPageURL("fwp.message"));
		test.pass("Test Case 04A passed.");
	}
	public void tc04Wronglogin()
	{
		
	}
}
