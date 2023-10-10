package tests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.LeadsPage;
import pages.LoginPage;
import utils.CommonUtils;

public class LeadsTests extends BaseTest{

	@BeforeClass
	public void navigateToHome() throws IOException {
		WebDriver driver = BaseTest.getDriver();
		LoginPage lp = new LoginPage(driver);
		lp.loginToApp(driver);
	}
	
	
//	@Test (description="check leads tab link")
	public void leads_TC20() throws IOException, InterruptedException {
		
    	WebDriver driver = BaseTest.getDriver();
		LeadsPage lsp = new LeadsPage(driver);
		CommonUtils.waitForElement(driver, lsp.LeadsTab);
		lsp.LeadsTab.click();
		Assert.assertEquals(lsp.verifyLeadsPage(driver), true);
			
       }
	
//	@Test (description="Validate 'Leads' drop down list contents")
	public void leads_TC21() throws IOException, InterruptedException {
		
    	WebDriver driver = BaseTest.getDriver();
		LeadsPage lsp = new LeadsPage(driver);
		CommonUtils.waitForElement(driver, lsp.LeadsTab);
		lsp.LeadsTab.click();
		Assert.assertEquals(lsp.verifyLeadsPage(driver), true);
		CommonUtils.waitForElement(driver, lsp.LeadsDrpdwn);
		lsp.LeadsDrpdwn.click();
		Assert.assertEquals(lsp.verifyLeadsMenuItems(), true);
	  }
	
	
//	@Test (description="Functionality of the Go Button")
	public void leads_TC22() throws IOException, InterruptedException {
		
    	WebDriver driver = BaseTest.getDriver();
		LeadsPage lsp = new LeadsPage(driver);
		CommonUtils.waitForElement(driver, lsp.LeadsTab);
		lsp.LeadsTab.click();
		Assert.assertEquals(lsp.verifyLeadsPage(driver), true);
		CommonUtils.waitForElement(driver, lsp.LeadsDrpdwn);
		lsp.LeadsDrpdwn.click();
		Assert.assertEquals(lsp.verifyLeadsMenuItems(), true);
		lsp.selectLead(driver);
		LoginPage lp = new LoginPage(driver);
	   Assert.assertEquals(lp.homepageisDisplayed(driver), true);
		CommonUtils.waitForElement(driver, lsp.LeadsTab);
		lsp.LeadsTab.click();
		Assert.assertEquals(lsp.verifyLeadsPage(driver), true);
		CommonUtils.waitForElement(driver, lsp.LeadsDrpdwn);
		lsp.GoBtn.click();
		Assert.assertEquals(lsp.verifyTodaysLeadsPage(driver), true);
		
	  }
	
//	@Test (description="List item 'Todays Leads' work")
	public void leads_TC23() throws IOException, InterruptedException {
		
    	WebDriver driver = BaseTest.getDriver();
		LeadsPage lsp = new LeadsPage(driver);
		CommonUtils.waitForElement(driver, lsp.LeadsTab);
		lsp.LeadsTab.click();
		Assert.assertEquals(lsp.verifyLeadsPage(driver), true);
		CommonUtils.waitForElement(driver, lsp.LeadsDrpdwn);
		lsp.LeadsDrpdwn.click();
		Assert.assertEquals(lsp.verifyLeadsMenuItems(), true);
		Select sel = new Select(lsp.LeadsDrpdwn);
    	sel.selectByVisibleText("Today's Leads");
    	Assert.assertEquals(lsp.verifyTodaysLeadsPage(driver), true);
    	lsp.logoutlogin(driver);
    	CommonUtils.waitForElement(driver, lsp.LeadsTab);
		lsp.LeadsTab.click();
		Assert.assertEquals(lsp.verifyLeadsPage(driver), true);
		CommonUtils.waitForElement(driver, lsp.GoBtn);
    	lsp.GoBtn.click();
    	Assert.assertEquals(lsp.verifyTodaysLeadsPage(driver), true);
	}
	
//	@Test (description="Check 'New' button on Leads Home")
	public void leads_TC24() throws IOException, InterruptedException {
		
    	WebDriver driver = BaseTest.getDriver();
		LeadsPage lsp = new LeadsPage(driver);
		CommonUtils.waitForElement(driver, lsp.LeadsTab);
		lsp.LeadsTab.click();
		Assert.assertEquals(lsp.verifyLeadsPage(driver), true);
		CommonUtils.waitForElement(driver, lsp.New);
		lsp.New.click();
		Assert.assertEquals(lsp.verifyNewLeadsPage(driver), true);
		CommonUtils.waitForElement(driver, lsp.LastName);
		lsp.LastName.sendKeys("ABCD");
		CommonUtils.waitForElement(driver, lsp.Company);
		lsp.Company.sendKeys("ABCD");
		CommonUtils.waitForElement(driver, lsp.Save);
		lsp.Save.click();
		Assert.assertEquals(lsp.verifyNewLeadsCreated(driver), true);
		CommonUtils.waitForElement(driver, lsp.Delete);
		lsp.Delete.click();
		driver.switchTo().alert().accept();
		lsp.LeadsTab.click();
		Assert.assertEquals(lsp.verifyLeadsPageAfterLeadDelete(driver), true);
		
		
	
}

}