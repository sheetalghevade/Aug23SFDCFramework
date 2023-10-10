package tests;

import java.io.IOException;
//import java.time.Duration;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.support.ui.ExpectedCondition;
//import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import constants.FileConstants;
import listeners.SFDClisteners;
//import constants.WaitConstants;
import pages.LoginPage;
import pages.UserMenuPage;
import utils.CommonUtils;
import utils.FileUtils;

@Listeners(SFDClisteners.class)

public class LoginTests extends BaseTest{

//	@Test
	public void loginTest1() throws InvalidFormatException, IOException {
		WebDriver driver = BaseTest.getDriver();
		
		LoginPage lp = new LoginPage(driver);
		driver.get(FileUtils.readPropertiesFile(FileConstants.LOGIN_TESTDATA_FILE_PATH2, "prod.url"));
//		String[] creds = ExcelUtils.readLoginTestData(1);
		lp.username.sendKeys(FileUtils.readPropertiesFile(FileConstants.LOGIN_TESTDATA_FILE_PATH2, "username"));
		lp.password.clear();
		lp.loginButton.click();

		String output= lp.errorMessage.getText();
		String expected =FileUtils.readPropertiesFile(FileConstants.LOGIN_TESTDATA_FILE_PATH2, "expected1");
		
		Assert.assertEquals(expected, output);

		
	}
	
	@Test
	public void loginTest2() throws InvalidFormatException, IOException {
	WebDriver driver = BaseTest.getDriver();
	
	LoginPage lp = new LoginPage(driver);
	lp.loginToApp(driver);
	BaseTest.test.info("Login Successfull");
	BaseTest.test.addScreenCaptureFromPath(CommonUtils.getScreenshots(driver));
	logger.info("LoginTests: loginTest2: Home Page Displayed");
    Assert.assertEquals(lp.homepageisDisplayed(driver), true);
	}
	
 
//	@Test(description="Remmeber me checkbox check.")
	
	public void loginTest3() throws InvalidFormatException, IOException, InterruptedException {
		WebDriver driver = BaseTest.getDriver();
		
		LoginPage lp = new LoginPage(driver);
		lp.loginRememberMe(driver);
		
		Assert.assertEquals(lp.homepageisDisplayed(driver), true);
	
		
		UserMenuPage ump = new UserMenuPage(driver);
		CommonUtils.waitForElement(driver, ump.userMenu);
		ump.userMenu.click();
		CommonUtils.waitForElement(driver, ump.Logout);
		
		ump.Logout.click();
		
		
		CommonUtils.waitForElementvisible(driver, lp.username);
					
		Assert.assertEquals(lp.usernameDisplayed(driver), true);
		
	}
	
	@Test
		public void loginTest4A() throws InvalidFormatException, IOException {
			WebDriver driver = BaseTest.getDriver();
			
			LoginPage lp = new LoginPage(driver);
			driver.get(FileUtils.readPropertiesFile(FileConstants.LOGIN_TESTDATA_FILE_PATH2, "prod.url"));
			lp.forgotPassword.click();

			lp.forgotUsername.sendKeys(FileUtils.readPropertiesFile(FileConstants.LOGIN_TESTDATA_FILE_PATH2, "username"));
			BaseTest.test.addScreenCaptureFromPath(CommonUtils.getScreenshots(driver));
			logger.info("LoginTests: loginTest4a: Forgot username page is displayed");
			lp.Continue.click();
			Assert.assertEquals(lp.emailSent(driver), true);
				
			}	
 
//	@Test(description="Validate Login Error Message")
	public void loginTest4B() throws InvalidFormatException, IOException {
		WebDriver driver = BaseTest.getDriver();
		
		LoginPage lp = new LoginPage(driver);
		driver.get(FileUtils.readPropertiesFile(FileConstants.LOGIN_TESTDATA_FILE_PATH2, "prod.url"));
		lp.username.sendKeys("tekarch.com");
		lp.password.sendKeys("1234");
		lp.loginButton.click();
		
		Assert.assertEquals(lp.checkEmailPassword(driver), true);
			
		}	
}
