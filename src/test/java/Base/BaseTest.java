package Base;
import java.io.IOException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.*;

import org.apache.log4j.LogManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.TestNG;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.beust.jcommander.Parameter;
import com.mongodb.diagnostics.logging.Logger;

import Pages.afterLoginPage;
import Pages.loginPage;
import Utilities.AppConstants;
import Utilities.CommonUtilities;
import Utilities.DataUtilities;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {

		public static WebDriver driver;
		public static ExtentReports report;
		public static ExtentTest test;
		public static ExtentHtmlReporter htmlreporter;
		public static String sReportTime;
		public static SoftAssert sa;
		public static String sBrowserName;
		public static Properties prop;
		public static DataUtilities objData=new DataUtilities();
		public static CommonUtilities objCommon = new CommonUtilities();
		public static loginPage lp;
		public static afterLoginPage afp;
		
		//public Logger log = (Logger) LogManager.getLogger(getClass().getSimpleName());
	
		public ChromeOptions EnableHeadlessmode()
		{
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--headless","--disable-gpu");
			return options;
		}
		//browser selection and opening code 
		public WebDriver getBrowser(String sBrowserName, boolean bEnableHeadless) throws IOException
		{
			
			
			switch(sBrowserName.toLowerCase())
			{
				
				case "chrome":
					
					WebDriverManager.chromedriver().setup();
					if(bEnableHeadless)
					{
						driver=new ChromeDriver(EnableHeadlessmode());
					}
					else
					{
					
						driver = new ChromeDriver();
					}	
					break;
				case "firefox":	
					WebDriverManager.firefoxdriver().setup();
					driver = new FirefoxDriver();
				default:
					driver = null;
						
			}
			driver.manage().window().maximize();
			driver.get(objData.readPageURL("Salesforce.HomePage"));
			if(driver!=null)
				lp=new loginPage(driver);
			return driver;
		}
		
	
		//Initialization of report
		@BeforeTest
		public void initializeReport()
		{
			
			sReportTime = new SimpleDateFormat("mmddyyyyhhmmss").format(new Date());
			htmlreporter = new ExtentHtmlReporter(AppConstants.EXTENT_REPORT_PATH+"/"+this.getClass().getName()+"-"+sReportTime+".html");
			report = new ExtentReports();
			report.attachReporter(htmlreporter);
		}
		
		//Flush report
		@AfterTest
		public void tearDown()
		{
			report.flush();
		}
		
		//Basic initialization of driver, assert, report
		@Parameters({"Browsername","Headless"})
		@BeforeMethod
		public void Initialization(Method sMethodname,String sBrowsername, Boolean bHeadless) throws IOException
		{
			driver=getBrowser(sBrowsername, bHeadless);
			sa= new SoftAssert();
			test = report.createTest(sMethodname.getName());
		}
		//closure of driver and browser
		@AfterMethod
		public void closure() throws Exception
		{
			Thread.sleep(3000);
			if(driver.getTitle()!=null)
			{
				driver.close();
			}
		}
	

}
