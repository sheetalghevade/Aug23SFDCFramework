package pages;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import constants.FileConstants;
import utils.CommonUtils;
import utils.FileUtils;

public class ContactsPage extends BasePage{

	
	public  ContactsPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//*[@id=\"Contact_Tab\"]/a")
	public WebElement ContactsTab;
	
	@FindBy(xpath = "//*[@value=\" New \"]")
	public WebElement newbtn;
	
	@FindBy(xpath = "//*[@id=\"name_lastcon2\"]")
	public WebElement Lastname;
	
	@FindBy(xpath = "//*[@id=\"con4\"]")
	public WebElement Accountname;
	
	@FindBy(xpath = "//input[@value = \" Save \"]")
	public WebElement save;
	
	@FindBy(xpath = "//*[@id=\"hotlist_mode\"]/option[1]")
	public WebElement RecentlyCreated;
	
	@FindBy(linkText = "Create New View")
	public WebElement CreateNewView;
	
	@FindBy(xpath = "//*[@id=\"fname\"]")
	public WebElement Viewname;
	
	@FindBy(xpath = "//*[@id=\"devname\"]")
	public WebElement UniqueViewname;
	
	@FindBy(linkText = "Go!")
	public WebElement Gobtn;
	
	@FindBy(linkText = "Delete")
	public WebElement Delete;
	
	@FindBy(xpath ="//*[@id=\"fcf\"]")
	public WebElement ViewSelect;
	
	@FindBy(xpath ="//*[@id=\"con2_ileinner\"]")
	public WebElement ContactName;
	
	@FindBy(xpath = "//*[@class='errorMsg']")
	public WebElement Error;
	
	@FindBy(xpath = "//input[@value = \"Cancel\"]")
	public WebElement Cancel;
	
	@FindBy(xpath = "//input[@value = \"Save & New\"]")
	public WebElement SaveNew;
	
	
	
	
	 public boolean verifyContactsPage(WebDriver driver){
	    	String expected = "Contacts: Home ~ Salesforce - Developer Edition";
	    	if(driver.getPageSource().contains(expected)) {
	    		System.out.println("Contacts page is displayed");
				return true;
			}
			else {
				System.out.println("Contacts page is not displayed");
				return false;
			}
	    }
	
	
	public boolean verifyNewContactPage(WebDriver driver){
    	String expected = "Contact Edit: New Contact ~ Salesforce - Developer Edition";
    	if(driver.getPageSource().contains(expected)) {
    		System.out.println("New Contact page is displayed");
			return true;
		}
		else {
			System.out.println("New Contact page is not displayed");
			return false;
		}
    }
	
	
	public void createNewAccount(WebDriver driver) throws IOException {
		AccountsPage ap = new AccountsPage(driver);
		CommonUtils.waitForElement(driver, ap.AccountTab);
		ap.AccountTab.click();
		ap.createNewAccount(driver);

	}
	
	
	 public void createNewContact(WebDriver driver) throws IOException {
	    	CommonUtils.waitForElement(driver, Lastname);
	    	Lastname.sendKeys(FileUtils.readPropertiesFile(FileConstants.LOGIN_TESTDATA_FILE_PATH2, "lastname"));
	    	CommonUtils.waitForElement(driver,Accountname);
	    	Accountname.sendKeys(FileUtils.readPropertiesFile(FileConstants.LOGIN_TESTDATA_FILE_PATH2, "usraccname"));
	    	CommonUtils.waitForElement(driver,save);
	    	save.click();
	     }
	 
	 public boolean verifyNewContact(WebDriver driver) throws IOException {
		 String expected = FileUtils.readPropertiesFile(FileConstants.LOGIN_TESTDATA_FILE_PATH2, "lastname");
	    	if(driver.getPageSource().contains(expected)) {
	    		System.out.println("New Contact is created");
				return true;
			}
			else {
				System.out.println("New Contact is not created");
				return false;
			}
	 }
	
	 public void createNewView(WebDriver driver) throws IOException, InterruptedException {
		 	CommonUtils.waitForElement(driver, Viewname);
		 	Viewname.click();
		 	Viewname.clear();
		 	Viewname.sendKeys(FileUtils.readPropertiesFile(FileConstants.LOGIN_TESTDATA_FILE_PATH2, "viewname"));
	    	CommonUtils.waitForElement(driver,UniqueViewname);
	    	Thread.sleep(4000);;
	    	UniqueViewname.clear();
	    	UniqueViewname.sendKeys(FileUtils.readPropertiesFile(FileConstants.LOGIN_TESTDATA_FILE_PATH2, "uviewname"));
	    	CommonUtils.waitForElement(driver,save);
	    	save.click();
	     }
	 
	 public void deleteNewView(WebDriver driver) throws IOException {
//		 	CommonUtils.waitForElement(driver, Gobtn);
//		 	Gobtn.click();
		 	CommonUtils.waitForElement(driver, Delete);
		 	Delete.click();
		 	driver.switchTo().alert().accept();
	     }
	 
	 public boolean verifyViewDeleted(WebDriver driver) throws IOException {
		 String expected = FileUtils.readPropertiesFile(FileConstants.LOGIN_TESTDATA_FILE_PATH2, "viewname");
	    	if(driver.getPageSource().contains(expected)) {
	    		System.out.println("View is not deleted");
				return false;
			}
			else {
				System.out.println("View is deleted");
				return true;
			}
	 }
	 
	 
	 public boolean verifyNewViewpage(WebDriver driver) {
		 String expected = "Contacts: Create New View ~ Salesforce - Developer Edition";
	    	if(driver.getPageSource().contains(expected)) {
	    		System.out.println("New View page is displayed");
				return true;
			}
			else {
				System.out.println("New View page is not displayed");
				return false;
			}
	 }
	 
	 public boolean verifyNewViewcreated(WebDriver driver) throws IOException {
		 String expected = FileUtils.readPropertiesFile(FileConstants.LOGIN_TESTDATA_FILE_PATH2, "viewname");
	    	if(driver.getPageSource().contains(expected)) {
	    		System.out.println("New View page is displayed");
				return true;
			}
			else {
				System.out.println("New View page is not displayed");
				return false;
			}
	 }


	public boolean MyContact(WebDriver driver) {
		String expected = "selected=\"selected\">My Contacts";
    	if(driver.getPageSource().contains(expected)) {
    		System.out.println("My Contact view is displayed");
			return true;
		}
		else {
			System.out.println("My Contact view is not displayed");
			return false;
		}
	}
	 
	 public boolean verifyContact() throws IOException {
		 String expected = FileUtils.readPropertiesFile(FileConstants.LOGIN_TESTDATA_FILE_PATH2, "lastname");
	    	if(ContactName.getText().equals(expected)) {
	    		System.out.println("Contact verified");
				return true;
			}
			else {
				System.out.println("Contact not verified");
				return false;
			}
	 }
	
	 public boolean verifyError() throws IOException {
		 String expected = "Error: You must enter a value";
	    	if(Error.getText().equals(expected)) {
	    		System.out.println("Error message displayed");
	    		return true;
			}
			else {
				System.out.println("No Error message");
				return false;
			}
	 }
	 
	 
}
