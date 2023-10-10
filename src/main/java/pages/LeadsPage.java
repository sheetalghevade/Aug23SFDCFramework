package pages;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import constants.FileConstants;
//import constants.FileConstants;
//import tests.BaseTest;
import utils.CommonUtils;
import utils.FileUtils;

/**
 * This page contains all the required page object elements and methods of
 * Leads page
 * 
 * @author Sheetal
 * @version v1.0
 */
public class LeadsPage extends BasePage{

	public  LeadsPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//*[@id=\"Lead_Tab\"]/a")
	public WebElement LeadsTab;
	
	@FindBy(xpath = "//*[@id=\"fcf\"]")
	public WebElement LeadsDrpdwn;
	
	@FindBy(xpath = "//*[@id=\"fcf\"]/option[4]")
	public WebElement TodaysLead;
	
	@FindBy(xpath = "//*[@title='Go!']")
	public WebElement GoBtn;
	
	@FindBy(xpath = "//*[@title='New']")
	public WebElement New;
	
	@FindBy(xpath = "//*[@id=\"name_lastlea2\"]")
	public WebElement LastName;
	
	@FindBy(xpath = "//*[@id=\"lea3\"]")
	public WebElement Company;
	
	@FindBy(xpath = "//*[@title='Save']")
	public WebElement Save;
	
	@FindBy(xpath = "//*[@id=\"lea2_ileinner\"]")
	public WebElement Leadname;
	
	@FindBy(xpath = "//*[@title='Delete']")
	public WebElement Delete;
	
	 public boolean verifyLeadsPage(WebDriver driver){
	    	String expected = "Leads: Home ~ Salesforce - Developer Edition";
	    	if(driver.getPageSource().contains(expected)) {
	    		System.out.println("Leads home page is displayed");
				return true;
			}
			else {
				System.out.println("Leads home page is not displayed");
				return false;
			}
	    }
	 
	 public boolean verifyLeadsMenuItems() throws IOException {

			boolean isOptionsVerified;
			String[] expectedLeadsMenuItems = FileUtils.readLeadsDrpDownData("leads.items").split(",");
			
			
			Select list = new Select(LeadsDrpdwn);
			List<WebElement> actual = list.getOptions();
			
			System.out.println("Expected result:");
			System.out.println();
			for (int i = 0; i < expectedLeadsMenuItems.length; i++) {
				System.out.println(expectedLeadsMenuItems[i]);
	    	        }
						
			System.out.println("Number of leads are "+actual.size());
			
	        System.out.println("Actual result:");
	        System.out.println();
			String[] output = new String[actual.size()]; 
			for (int i = 0; i < actual.size(); i++) {
				output[i] = actual.get(i).getText();
	            System.out.println(output[i]);
	    	        }
				
			isOptionsVerified = Arrays.equals(expectedLeadsMenuItems, output);
			System.out.println(isOptionsVerified);
			
			return isOptionsVerified;
	 }	
			
	 
	 public void selectLead(WebDriver driver) throws IOException {
	    	Select sel = new Select(LeadsDrpdwn);
	    	sel.selectByVisibleText("Today's Leads");
	    	UserMenuPage ump = new UserMenuPage(driver);
			CommonUtils.waitForElement(driver, ump.userMenu);
			ump.userMenu.click();
			CommonUtils.waitForElement(driver, ump.Logout);
			ump.Logout.click();
			LoginPage lp = new LoginPage(driver);
			lp.loginToApp(driver);
					
	     }
	 public boolean verifyTodaysLeadsPage(WebDriver driver){
	    	String expected = "Leads ~ Salesforce - Developer Edition";
	    	if(driver.getPageSource().contains(expected)) {
	    		System.out.println("Today's Leads page is displayed");
				return true;
			}
			else {
				System.out.println("Today's Leads page is not displayed");
				return false;
			}
	    }
	 
	 public void logoutlogin(WebDriver driver) throws IOException {
		 UserMenuPage ump = new UserMenuPage(driver);
			CommonUtils.waitForElement(driver, ump.userMenu);
			ump.userMenu.click();
			Assert.assertTrue(ump.verifyUserMenuItems(), "Failed to verify user menu options");
			Assert.assertTrue(ump.selectLogout(), "Failed to logout");
		 LoginPage lp = new LoginPage(driver);
			CommonUtils.waitForElement(driver, lp.username);
				lp.username.sendKeys(FileUtils.readPropertiesFile(FileConstants.LOGIN_TESTDATA_FILE_PATH2, "username"));
				lp.password.sendKeys(FileUtils.readPropertiesFile(FileConstants.LOGIN_TESTDATA_FILE_PATH2, "password"));
				lp.loginButton.click();
	 }
	
	 public boolean verifyNewLeadsPage(WebDriver driver){
	    	String expected = "Lead Edit: New Lead ~ Salesforce - Developer Edition";
	    	if(driver.getPageSource().contains(expected)) {
	    		System.out.println("New Leads page is displayed");
				return true;
			}
			else {
				System.out.println("New Leads page is not displayed");
				return false;
			}
	    }
	 
	 
	 public boolean verifyNewLeadsCreated(WebDriver driver){
	    	String expected = "ABCD";
	    	if(Leadname.getText().contains(expected)) {
	    		System.out.println("New Leads is created");
				return true;
			}
			else {
				System.out.println("New Leads is not created");
				return false;
			}
	    }
	 
	 
	 
	 public boolean verifyLeadsPageAfterLeadDelete(WebDriver driver){
	    	String expected = "ABCD";
	    	if(driver.getPageSource().contains(expected)) {
	    		System.out.println("New Lead is not deleted");
				return false;
			}
			else {
				System.out.println("New Lead is deleted");
				return true;
			}
	    }
	 
	 
}
