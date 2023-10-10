package tests;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Method;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
//import org.testng.asserts.SoftAssert;

import constants.FileConstants;
import listeners.SFDClisteners;
import pages.LoginPage;
import pages.UserMenuPage;
import utils.CommonUtils;

@Listeners(SFDClisteners.class)

public class UserMenuTests extends BaseTest{
	
	@BeforeClass
	public void navigateToHome() throws IOException {
		WebDriver driver = BaseTest.getDriver();
		LoginPage lp = new LoginPage(driver);
		lp.loginToApp(driver);
	}

	
	@Test(description="Select user menu for <username> drop down")
	public void userMenuDropDown_TC05(Method name) throws IOException, InterruptedException {
	
	WebDriver driver = BaseTest.getDriver();
	BaseTest.test.info("Driver Configured");
	BaseTest.test.addScreenCaptureFromPath(CommonUtils.getScreenshots(driver));
	UserMenuPage ump = new UserMenuPage(driver);
	CommonUtils.waitForElement(driver, ump.userMenu);
	ump.userMenu.click();
	
	BaseTest.test.info("User Menu Displayed");
	logger.info("UserMenuTest: userMenuDropDown_05: User Menu Displayed");
	
	Assert.assertTrue(ump.verifyUserMenuItems(), "Failed to verify user menu options");
	BaseTest.test.info("User Menu Verified");
	
	}
	
//	@Test (description="Select 'My Profile' option from user menu for <username> drop down")
	public void userMenuDropDown_TC06() throws IOException, InterruptedException {
		
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
		
		
	}
	
//	@Test(description="Select 'My settings' option from user menu for <username> drop down")
	public void userMenuDropDown_TC07() throws IOException, InterruptedException {
	
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
	ump.logindisplay.click();
	ump.DisplayLayoutlink.click();
	CommonUtils.waitForElement(driver, ump.CustomizedTab);
	ump.CustomizedTab.click();
	Assert.assertEquals(ump.customizedTabisDisplayed(driver), true);
	CommonUtils.waitForElement(driver, ump.customDrpdown);
	ump.customDrpdown.click();
	Select dropdownoption = new Select(ump.customDrpdown);
	dropdownoption.selectByVisibleText("Salesforce Chatter");
	CommonUtils.waitForElement(driver, ump.SelectedTabs);
	ump.checkReport(driver);
	Assert.assertEquals(ump.verifyReport(driver), true);
	CommonUtils.waitForElement(driver, ump.save);
	ump.save.click();
	
	ump.email(driver);
	Assert.assertEquals(ump.verifyemail(), true);
	
	ump.calendarandremainder(driver);
	
		
	}
	
	@Test(description="Select 'Developers Console' option from user menu for <username> drop down")
	public void userMenuDropDown_TC08() throws IOException, InterruptedException {
	
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
	      System.out.println(getAllWindows.size());
	      String[]getwindow = getAllWindows.toArray(new String[getAllWindows.size()]);
	     	      
	      driver.switchTo().window(getwindow[1]);
	      driver.manage().window().maximize();
	      driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	      Assert.assertEquals(ump.verifyDevConsolePageDisplayed(driver), true);
	     driver.close();
	     driver.switchTo().window(oldwindow);
	    
	  LoginPage lp = new LoginPage(driver);
	  lp.homepageisDisplayed(driver);
	  Assert.assertEquals(lp.homepageisDisplayed(driver), true);
	  	
	}

//	@Test(description="Select 'Logout' option from user menu for <username> drop down")
	public void userMenuDropDown_TC09() throws IOException, InterruptedException {
	
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
	
	
//	@Test
	public void two() throws FileNotFoundException{
		
		System.out.println("test two");
		throw new FileNotFoundException();
		
	}
}
