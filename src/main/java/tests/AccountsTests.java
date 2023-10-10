package tests;

import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import constants.FileConstants;
import pages.AccountsPage;
import pages.LoginPage;
import utils.CommonUtils;
import utils.FileUtils;

public class AccountsTests extends BaseTest{
	
	@BeforeClass
	public void navigateToHome() throws IOException {
		WebDriver driver = BaseTest.getDriver();
		LoginPage lp = new LoginPage(driver);
		lp.loginToApp(driver);
	}
	
	
//	@Test (description="Create New Account")
	public void accountTab_TC10() throws IOException, InterruptedException {
		
    	WebDriver driver = BaseTest.getDriver();
		AccountsPage ap = new AccountsPage(driver);
		CommonUtils.waitForElement(driver, ap.AccountTab);
		ap.AccountTab.click();
		Assert.assertEquals(ap.verifyAccountsPage(driver), true);
		
		Assert.assertEquals(ap.verifyAccountEditPage(driver), true);
		ap.createNewAccount(driver);
		Assert.assertEquals(ap.verifyNewAccount(driver), true);
		
}
	
//	@Test (description="Create New View")
	public void accountTab_TC11() throws IOException, InterruptedException {
		
    	WebDriver driver = BaseTest.getDriver();
		AccountsPage ap = new AccountsPage(driver);
		CommonUtils.waitForElement(driver, ap.AccountTab);
		ap.AccountTab.click();
		Assert.assertEquals(ap.verifyAccountsPage(driver), true);
		CommonUtils.waitForElement(driver, ap.CreateNewView);
		ap.CreateNewView.click();
		Assert.assertEquals(ap.verifyNewViewPage(driver), true);
		ap.createNewView(driver);
		Assert.assertEquals(ap.verifyNewView(driver), true);
		
}

//	@Test (description="Edit View")
	public void accountTab_TC12() throws IOException, InterruptedException {
		
    	WebDriver driver = BaseTest.getDriver();
		AccountsPage ap = new AccountsPage(driver);
		CommonUtils.waitForElement(driver, ap.AccountTab);
		ap.AccountTab.click();
		Assert.assertEquals(ap.verifyAccountsPage(driver), true);
		CommonUtils.waitForElement(driver, ap.ViewDrpdown);
    	Select viewDrpSel = new Select(ap.ViewDrpdown);
    	viewDrpSel.selectByVisibleText(FileUtils.readPropertiesFile(FileConstants.LOGIN_TESTDATA_FILE_PATH2, "Usraccview2"));
    	CommonUtils.waitForElement(driver, ap.Editlink);
		ap.Editlink.click();
		Assert.assertEquals(ap.verifyEditViewPage(driver), true);
		ap.editView(driver);
		Assert.assertEquals(ap.verifyEditView(driver), true);
		
}
//	@Test (description="Merge Accounts")
	public void accountTab_TC13() throws IOException, InterruptedException {
		
    	WebDriver driver = BaseTest.getDriver();
		AccountsPage ap = new AccountsPage(driver);
		CommonUtils.waitForElement(driver, ap.AccountTab);
		ap.AccountTab.click();
		Assert.assertEquals(ap.verifyAccountsPage(driver), true);
		ap.createMultipleNewAccount(driver);
		CommonUtils.waitForElement(driver, ap.AccountTab);
		ap.AccountTab.click();
		CommonUtils.waitForElement(driver, ap.MergeAccLink);
		ap.MergeAccLink.click();
		Assert.assertEquals(ap.verifyMergeAccountPage(driver), true);
		ap.merge(driver);
		ap.deleteAccount(driver);
		Assert.assertEquals(ap.verifyAccountsPage(driver), true);	
}
	
	
	
	
//	@Test(description="Create account report- NOT COMPLETED")
	public void accountTab_TC14() throws IOException {
		WebDriver driver = BaseTest.getDriver();
		AccountsPage ap = new AccountsPage(driver);
		ap.createNewAccount(driver);
		CommonUtils.waitForElement(driver, ap.AccountTab);
		ap.AccountTab.click();
		
		ap.deleteAccount(driver);
		
	}
	
//	@Test
	public void test() throws IOException {
		WebDriver driver = BaseTest.getDriver();
		AccountsPage ap = new AccountsPage(driver);
		CommonUtils.waitForElement(driver, ap.AccountTab);
		ap.AccountTab.click();
		ap.createNewAccount(driver);
		ap.accountReport(driver);
		
		
	}
	
}	