package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTests {

	
	public static ThreadLocal<WebDriver> threadLocalDriver = new ThreadLocal<>();
	
//	Requirements
//	Cross  Browser Support
//	Parallel support
//	Proper Reporting: Accurate Assertions, Screenshots
//	Support of logs in Framework
	
	@BeforeMethod
	public void setDriver(){
		WebDriver driver = BaseTests.getBrowserType("firefox");
		threadLocalDriver.set(driver);
	}
	
	public static WebDriver getDriver() {
	 return	threadLocalDriver.get();
	
	}
	
	@AfterMethod
	public static void removeDriver() {
		getDriver().close();
		threadLocalDriver.remove();
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
        
		case "edge":
			driver = new EdgeDriver();
			break;
        	
		default:
			driver = null;
			break;
		}
		return driver;
	}
	
	
}
