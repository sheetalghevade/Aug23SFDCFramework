package tests;

import java.io.IOException;
import java.lang.reflect.Method;
import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
//import org.testng.asserts.SoftAssert;

import constants.FileConstants;
import pages.LoginPage;
import pages.UserMenuPage;
import utils.CommonUtils;



public class UserMenuTests extends BaseTest{
	
	@BeforeClass
	public void navigateToHome() throws IOException {
		WebDriver driver = BaseTest.getDriver();
		LoginPage lp = new LoginPage(driver);
		lp.loginToApp(driver);
	}

	
	@Test
	public void userMenuDropDown_TC5(Method name) throws IOException, InterruptedException {
	
	WebDriver driver = BaseTest.getDriver();
	BaseTest.test.info("Driver Configured");
	BaseTest.test.addScreenCaptureFromPath(CommonUtils.getScreenshots(driver));
	UserMenuPage ump = new UserMenuPage(driver);
	CommonUtils.waitForElement(driver, ump.userMenu);
	ump.userMenu.click();
	BaseTest.test.addScreenCaptureFromPath(CommonUtils.getScreenshots(driver));
	BaseTest.test.info("User Menu Displayed");
	
	Assert.assertTrue(ump.verifyUserMenuItems(), "Failed to verify user menu options");
	BaseTest.test.info("User Menu Verified");
	BaseTest.test.pass(name.getName()+" Test Passed");
	}
	
//	@Test ()
	public void userMenuDropDown_TC06() throws IOException, InterruptedException {
		
//		SoftAssert softAssert = new SoftAssert();
		
		WebDriver driver = BaseTest.getDriver();
		UserMenuPage ump = new UserMenuPage(driver);
		CommonUtils.waitForElement(driver, ump.userMenu);
		ump.userMenu.click();
		Assert.assertTrue(ump.verifyUserMenuItems(), "Failed to verify user menu options");
		Assert.assertTrue(ump.selectMyProfile(), "");
		CommonUtils.waitForElement(driver, ump.profilePage);
		Assert.assertTrue(ump.isProfilePageVisible(), "");
		ump.selectEditContact(driver);
		Assert.assertTrue(ump.verifyEditContactPopUp(driver), "");
		Assert.assertTrue(ump.verifyLastNameChangeInAboutTab(driver, "Tekarch"), "");
		Assert.assertTrue(ump.verifyCreatePost(driver, "Hello welcome to java"));
		BaseTest.test.info("Driver Configured");
		BaseTest.test.addScreenCaptureFromPath(CommonUtils.getScreenshots(driver));
		Assert.assertTrue(ump.verifyFileUpload(driver, FileConstants.LOGIN_TESTDATA_FILE_PATH));
		Assert.assertTrue(ump.verifyPhotoUpload(driver, FileConstants.PROFILE_PHOTO_FILE_PATH));
		
//	*	Assert.assertEquals(ump.selectRandomOption(), "My profile", "Failed");
		
	}
	
//	@Test
	public void userMenuDropDown_TC7() throws IOException, InterruptedException {
	
	WebDriver driver = BaseTest.getDriver();
	UserMenuPage ump = new UserMenuPage(driver);
	CommonUtils.waitForElement(driver, ump.userMenu);
	ump.userMenu.click();
	Assert.assertTrue(ump.verifyUserMenuItems(), "Failed to verify user menu options");
	CommonUtils.waitForElement(driver, ump.MySettings);
	Assert.assertTrue(ump.selectMySettings(), "Failed to open My Settings");
	CommonUtils.waitForElement(driver, ump.personallink);
	ump.personallink.click();
	Assert.assertEquals(ump.verifyPersonalLinks(), true);
	CommonUtils.waitForElement(driver, ump.loginHistorylink);
	ump.loginHistorylink.click();
	Assert.assertEquals(ump.loginHistoryPageisDisplayed(driver), true);
	CommonUtils.waitForElement(driver, ump.logindisplay);
//	ump.logindisplay.click();
	ump.DisplayLayoutlink.click();
	CommonUtils.waitForElement(driver, ump.CustomizedTab);
	ump.CustomizedTab.click();
	Assert.assertEquals(ump.customizedTabisDisplayed(driver), true);
	CommonUtils.waitForElement(driver, ump.customDrpdown);
	ump.customDrpdown.click();
	Select dropdownoption = new Select(ump.customDrpdown);
	dropdownoption.selectByVisibleText("Salesforce Chatter");
	
	
	}
	
//	@Test
	public void userMenuDropDown_TC8() throws IOException, InterruptedException {
	
	WebDriver driver = BaseTest.getDriver();
	UserMenuPage ump = new UserMenuPage(driver);
	CommonUtils.waitForElement(driver, ump.userMenu);
	ump.userMenu.click();
	Assert.assertTrue(ump.verifyUserMenuItems(), "Failed to verify user menu options");
	Assert.assertTrue(ump.selectDeveloperConsole(), "Failed to open Developer console");
	
	BaseTest.test.info("Driver Configured");
	BaseTest.test.addScreenCaptureFromPath(CommonUtils.getScreenshots(driver));
	
	String oldwindow = driver.getWindowHandle();
	      Set<String> getAllWindows = driver.getWindowHandles();
	      String[]getwindow = getAllWindows.toArray(new String[getAllWindows.size()]);
	     	      
	      driver.switchTo().window(getwindow[1]);
	      driver.manage().window().maximize();
	      Thread.sleep(4000);
	     driver.close();
	     driver.switchTo().window(oldwindow);
	    
	  LoginPage lp = new LoginPage(driver);
	  lp.homepageisDisplayed(driver);
	  Assert.assertEquals(lp.homepageisDisplayed(driver), true);
	  	
	}

//	@Test
	public void userMenuDropDown_TC9() throws IOException, InterruptedException {
	
	WebDriver driver = BaseTest.getDriver();
	UserMenuPage ump = new UserMenuPage(driver);
	CommonUtils.waitForElement(driver, ump.userMenu);
	ump.userMenu.click();
	Assert.assertTrue(ump.verifyUserMenuItems(), "Failed to verify user menu options");
	Assert.assertTrue(ump.selectLogout(), "Failed to logout");
	  
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	  LoginPage lp = new LoginPage(driver);
	  CommonUtils.waitForElementvisible(driver, lp.username);
	  Assert.assertEquals(lp.loginPageDisplayed(driver), true);
	  	
	}
	
}
