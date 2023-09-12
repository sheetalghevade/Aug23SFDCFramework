package tests;

import java.io.File;
import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterMethod;
//import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;

import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import constants.FileConstants;

public class BaseTest {

private static ThreadLocal<WebDriver> threadLocalDriver = new ThreadLocal<>();
	static ExtentReports extent = new ExtentReports();
	static ExtentSparkReporter spark = null;
	static ExtentTest test = null;
	
//	Requirements
//	Cross browser support
//	Parallel support -
//	Proper reporting - Accurate Assertion, Screenshots
//	Support of Logs in the framework
	
      @BeforeMethod
          public static void setup(Method name) {
        	BaseTest.test = extent.createTest(name.getName());
         }

        @AfterMethod
         public void tearDown() {
	
         }

@BeforeTest
public static void setDriver() {
	spark = new ExtentSparkReporter(new File(FileConstants.REPORT_PATH));
	extent.attachReporter(spark);
	WebDriver driver = BaseTest.getBrowserType("chrome");
	threadLocalDriver.set(driver);
}


public static WebDriver getDriver() {
	return threadLocalDriver.get();
}


//@AfterTest
public static void removeDriver() {
	getDriver().close();
	threadLocalDriver.remove();
	extent.flush();
}
	
	public static WebDriver getBrowserType(String browserName) {
		
		WebDriver driver;
		
		String browserType = browserName.toLowerCase();
		
		
		
		switch (browserType) {
		case "chrome":
			driver = new ChromeDriver();
			break;
			
		case "firefox":
			driver = new FirefoxDriver();
			break;
			
		case "safari":
			driver = new SafariDriver();
			break;	
			
		case "egde":
			driver = new EdgeDriver();
			break;
					
		default:
			driver = null;
			break;
		}
		
		return driver;
		
	}
	
}
