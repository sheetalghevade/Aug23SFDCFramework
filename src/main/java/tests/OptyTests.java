package tests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.AccountsPage;
import pages.LoginPage;
import pages.OptyPage;
import utils.CommonUtils;

public class OptyTests extends BaseTest{

	@BeforeClass
	public void navigateToHome() throws IOException {
		WebDriver driver = BaseTest.getDriver();
		LoginPage lp = new LoginPage(driver);
		lp.loginToApp(driver);
		AccountsPage ap = new AccountsPage(driver);
		CommonUtils.waitForElement(driver, ap.AccountTab);
		ap.AccountTab.click();
		ap.createNewAccount(driver);
		
	}
	
	
	@Test (description="opportunities drop down")
	public void optyTab_TC15() throws IOException, InterruptedException {
		WebDriver driver = BaseTest.getDriver();
		OptyPage op = new OptyPage(driver);
		CommonUtils.waitForElement(driver, op.OpportunitiesTab);
		op.OpportunitiesTab.click();
		Assert.assertEquals(op.verifyOpportunitiesPage(driver), true);
		Assert.assertEquals(op.verifyOpportunitiesMenuItems(), true);		
	}
	
//	@Test (description="Create a new Opty")
	public void optyTab_TC16() throws IOException, InterruptedException {
		WebDriver driver = BaseTest.getDriver();
		OptyPage op = new OptyPage(driver);
		CommonUtils.waitForElement(driver, op.OpportunitiesTab);
		op.OpportunitiesTab.click();
		Assert.assertEquals(op.verifyOpportunitiesPage(driver), true);
		CommonUtils.waitForElement(driver, op.New);
		op.New.click();
		Assert.assertEquals(op.verifyNewOpportunitiesPage(driver), true);
		op.CreateNewOpty(driver);
		Assert.assertEquals(op.verifyNewOptyCreated(driver), true);
		op.OpportunitiesTab.click();
	}
	
//	@Test (description="Test Opportunity Pipeline Report")
	public void optyTab_TC17() throws IOException, InterruptedException {
		WebDriver driver = BaseTest.getDriver();
		OptyPage op = new OptyPage(driver);
		CommonUtils.waitForElement(driver, op.OpportunitiesTab);
		op.OpportunitiesTab.click();
		Assert.assertEquals(op.verifyOpportunitiesPage(driver), true);
		Assert.assertEquals(op.verifyNewOptyPipeline(driver), true);
		}
	
//	@Test (description="Test Stuck Opportunities Report")
	public void optyTab_TC18() throws IOException, InterruptedException {
		WebDriver driver = BaseTest.getDriver();
		OptyPage op = new OptyPage(driver);
		CommonUtils.waitForElement(driver, op.OpportunitiesTab);
		op.OpportunitiesTab.click();
		Assert.assertEquals(op.verifyOpportunitiesPage(driver), true);
		Assert.assertEquals(op.verifyStuckOpty(driver), true);
		}
	
//	@Test (description="Test Quarterly Summary Report")
	public void optyTab_TC19() throws IOException, InterruptedException {
		WebDriver driver = BaseTest.getDriver();
		OptyPage op = new OptyPage(driver);
		CommonUtils.waitForElement(driver, op.OpportunitiesTab);
		op.OpportunitiesTab.click();
		Assert.assertEquals(op.verifyOpportunitiesPage(driver), true);
		Assert.assertEquals(op.verifyQuartSumryReport(driver), true);
		}
	
	@AfterClass
	public void delete() throws IOException {
		WebDriver driver = BaseTest.getDriver();
		AccountsPage ap = new AccountsPage(driver);
		ap.deleteAccount(driver);
}
	
	
}
