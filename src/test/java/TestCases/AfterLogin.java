package TestCases;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import Base.BaseTest;
import Pages.afterLoginPage;

public class AfterLogin extends BaseTest {
	
	@Test
	public void tc05DropDown() throws IOException
	{
		afp = new afterLoginPage(driver);
		objCommon.login();
		objCommon.waitForElement(lp.userNavlable);
		objCommon.click(afp.userNavlable, "Profile Name");
		List<WebElement> userMenuDrop = afp.userMenuItem;
		int i=0;
		String str;
		boolean flag=true;
		for(WebElement UM:userMenuDrop)
		{
			str=objData.readPageURL("UserMenu"+(i+1));
			if(!(str.equals(UM.getText())))
			{
				flag=false;
			}
		}
		if(!flag)
		{
			test.fail("Dropdown mismatch");
		}
		
	}
	@Test
	public void tc06MyProfile()
	{
		
	}

}
