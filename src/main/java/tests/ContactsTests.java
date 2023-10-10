package tests;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import constants.FileConstants;
import pages.ContactsPage;
import pages.LoginPage;
import utils.CommonUtils;
import utils.FileUtils;

public class ContactsTests extends BaseTest{
	
	@BeforeClass
	public void navigateToHome() throws IOException {
		WebDriver driver = BaseTest.getDriver();
		LoginPage lp = new LoginPage(driver);
		lp.loginToApp(driver);
	}
	
	
//	@Test (description="Create new contact")
	public void contacts_25() throws IOException {
		WebDriver driver = BaseTest.getDriver();
		ContactsPage cp = new ContactsPage(driver);
		cp.createNewAccount(driver);
		CommonUtils.waitForElement(driver, cp.ContactsTab);
		cp.ContactsTab.click();
		Assert.assertEquals(cp.verifyContactsPage(driver), true);
		CommonUtils.waitForElement(driver, cp.newbtn);
		cp.newbtn.click();
		Assert.assertEquals(cp.verifyNewContactPage(driver), true);
		cp.createNewContact(driver);
		Assert.assertEquals(cp.verifyNewContact(driver), true);
	}

//	@Test (description="Create new view")
	public void contacts_26() throws IOException, InterruptedException {
		WebDriver driver = BaseTest.getDriver();
		ContactsPage cp = new ContactsPage(driver);
		CommonUtils.waitForElement(driver, cp.ContactsTab);
		cp.ContactsTab.click();
		Assert.assertEquals(cp.verifyContactsPage(driver), true);
		CommonUtils.waitForElement(driver, cp.CreateNewView);
	 	cp.CreateNewView.click();
	 	Assert.assertEquals(cp.verifyNewViewpage(driver), true);
	 	cp.createNewView(driver);
	 	Assert.assertEquals(cp.verifyNewViewcreated(driver), true);
		cp.deleteNewView(driver);
		cp.ContactsTab.click();
		Assert.assertEquals(cp.verifyViewDeleted(driver), true);
	}
	
//	@Test (description="Check recently created contact in the Contact Page")
	public void contacts_27() throws IOException {
		WebDriver driver = BaseTest.getDriver();
		ContactsPage cp = new ContactsPage(driver);
		CommonUtils.waitForElement(driver, cp.ContactsTab);
		cp.ContactsTab.click();
		Assert.assertEquals(cp.verifyContactsPage(driver), true);
		CommonUtils.waitForElement(driver, cp.RecentlyCreated);
		cp.RecentlyCreated.click();
		Assert.assertEquals(cp.verifyNewContact(driver), true);
	}
	
//	@Test (description="Check 'My contacts' view in the Contact Page")
	public void contacts_28() throws IOException {
		WebDriver driver = BaseTest.getDriver();
		ContactsPage cp = new ContactsPage(driver);
		CommonUtils.waitForElement(driver, cp.ContactsTab);
		cp.ContactsTab.click();
		Assert.assertEquals(cp.verifyContactsPage(driver), true);
		CommonUtils.waitForElement(driver, cp.ViewSelect);
		Select view = new Select(cp.ViewSelect);
		view.selectByVisibleText("My Contacts");
		Assert.assertEquals(cp.MyContact(driver), true);
	}
	
//	@Test (description="View a contact in the contact Page")
	public void contacts_29() throws IOException {
		WebDriver driver = BaseTest.getDriver();
		ContactsPage cp = new ContactsPage(driver);
		CommonUtils.waitForElement(driver, cp.ContactsTab);
		cp.ContactsTab.click();
		Assert.assertEquals(cp.verifyContactsPage(driver), true);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.linkText(FileUtils.readPropertiesFile(FileConstants.LOGIN_TESTDATA_FILE_PATH2, "lastname"))).click();
		Assert.assertEquals(cp.verifyContact(), true);
	}
	
//	@Test (description="Check the Error message")
	public void contacts_30() throws IOException, InterruptedException {
		WebDriver driver = BaseTest.getDriver();
		ContactsPage cp = new ContactsPage(driver);
		CommonUtils.waitForElement(driver, cp.ContactsTab);
		cp.ContactsTab.click();
		Assert.assertEquals(cp.verifyContactsPage(driver), true);
		CommonUtils.waitForElement(driver, cp.CreateNewView);
	 	cp.CreateNewView.click();
	 	Assert.assertEquals(cp.verifyNewViewpage(driver), true);
	 	CommonUtils.waitForElement(driver, cp.UniqueViewname);
	 	cp.UniqueViewname.sendKeys("EFGH");
	 	CommonUtils.waitForElement(driver, cp.save);
	 	cp.save.click();
        Assert.assertEquals(cp.verifyError(), true);	 	
	 	
	}
	
//	@Test (description="Check the Cancel button")
	public void contacts_31() throws IOException, InterruptedException {
		WebDriver driver = BaseTest.getDriver();
		ContactsPage cp = new ContactsPage(driver);
		CommonUtils.waitForElement(driver, cp.ContactsTab);
		cp.ContactsTab.click();
		Assert.assertEquals(cp.verifyContactsPage(driver), true);
		CommonUtils.waitForElement(driver, cp.CreateNewView);
	 	cp.CreateNewView.click();
	 	Assert.assertEquals(cp.verifyNewViewpage(driver), true);
	 	CommonUtils.waitForElement(driver, cp.UniqueViewname);
	 	cp.UniqueViewname.sendKeys("EFGH");
	 	CommonUtils.waitForElement(driver, cp.Viewname);
	 	cp.Viewname.sendKeys("ABCD");
	 	CommonUtils.waitForElement(driver, cp.Cancel);
	 	cp.Cancel.click();
	 	Assert.assertEquals(cp.verifyContactsPage(driver), true); 	
	 	
	}
	
//	@Test (description="Check 'Save & New'")
	public void contacts_32() throws IOException, InterruptedException {
		WebDriver driver = BaseTest.getDriver();
		ContactsPage cp = new ContactsPage(driver);
		CommonUtils.waitForElement(driver, cp.ContactsTab);
		cp.ContactsTab.click();
		Assert.assertEquals(cp.verifyContactsPage(driver), true);
		CommonUtils.waitForElement(driver, cp.newbtn);
		cp.newbtn.click();
		Assert.assertEquals(cp.verifyNewContactPage(driver), true);
		CommonUtils.waitForElement(driver, cp.Lastname);
    	cp.Lastname.sendKeys(FileUtils.readPropertiesFile(FileConstants.LOGIN_TESTDATA_FILE_PATH2, "lastname1"));
    	CommonUtils.waitForElement(driver,cp.Accountname);
    	cp.Accountname.sendKeys(FileUtils.readPropertiesFile(FileConstants.LOGIN_TESTDATA_FILE_PATH2, "usraccname"));
	 	CommonUtils.waitForElement(driver, cp.SaveNew);
	 	cp.SaveNew.click();
	 	Assert.assertEquals(cp.verifyNewContactPage(driver), true); 	
	 	
	}
	
}
