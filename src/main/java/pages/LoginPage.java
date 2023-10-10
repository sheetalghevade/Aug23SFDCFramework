package pages;

import java.io.IOException;
//import java.sql.Driver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import constants.FileConstants;
import utils.CommonUtils;
import utils.FileUtils;;

public class LoginPage extends BasePage{

	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	
	}
	
	@FindBy(id = "username")
	public WebElement username;
	
	@FindBy(id = "password" )
	public WebElement password;
	
	@FindBy(id = "Login" )
	public WebElement loginButton;
	
	@FindBy(id="rememberUn" )
	public WebElement rememberMe;
	
	@FindBy(id = "error" )
	public WebElement errorMessage;
	
	@FindBy(partialLinkText = "Forgot" )
	public WebElement forgotPassword;
	
	@FindBy(id = "continue")
	public WebElement Continue;
	
	@FindBy(id = "idcard-identity")
	public WebElement savedUsername;
	
	@FindBy(id = "un")
	public WebElement forgotUsername;
	
	@FindBy(xpath = "//a[text()='Return to Login']")
	public WebElement returnToLoginButton;
	
	@FindBy(id = "userNav-menuItems/a[4]")
	public WebElement Logout;
	
	
	public boolean selectRememberMeCheckBox() {
		boolean isSelected = false;
		if(! rememberMe.isSelected()) {
			isSelected = true;
		} 
		return isSelected;
		
	}
	
	public void loginToApp(WebDriver driver) throws IOException {

		driver.get(FileUtils.readPropertiesFile(FileConstants.LOGIN_TESTDATA_FILE_PATH2, "prod.url"));
		driver.manage().window().maximize();
		logger.info("LoginPage: loginToApp: application launched");
		if (CommonUtils.waitForElement(driver, username)) {
			username.sendKeys(FileUtils.readPropertiesFile(FileConstants.LOGIN_TESTDATA_FILE_PATH2, "username"));
			password.sendKeys(FileUtils.readPropertiesFile(FileConstants.LOGIN_TESTDATA_FILE_PATH2, "password"));
			loginButton.click();
		}
	}
	
	public void loginRememberMe(WebDriver driver) throws IOException {
		driver.get(FileUtils.readPropertiesFile(FileConstants.LOGIN_TESTDATA_FILE_PATH2, "prod.url"));
		driver.manage().window().maximize();
		if (CommonUtils.waitForElement(driver, username)) {
			username.sendKeys(FileUtils.readPropertiesFile(FileConstants.LOGIN_TESTDATA_FILE_PATH2, "username"));
			password.sendKeys(FileUtils.readPropertiesFile(FileConstants.LOGIN_TESTDATA_FILE_PATH2, "password"));
			rememberMe.click();
			loginButton.click();
		}
	}
	public boolean homepageisDisplayed(WebDriver driver) throws IOException {
		String expected =FileUtils.readPropertiesFile(FileConstants.LOGIN_TESTDATA_FILE_PATH2, "expected2");
		
		if(driver.getPageSource().contains(expected)) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public boolean loginPageDisplayed(WebDriver driver) throws IOException {
		String expected = "Login | Salesforce";
		
		if(driver.getPageSource().contains(expected)) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public boolean usernameDisplayed(WebDriver driver) throws IOException {
 String expected =FileUtils.readPropertiesFile(FileConstants.LOGIN_TESTDATA_FILE_PATH2, "username");
		
		if(driver.getPageSource().contains(expected)) {
			return true;
		}
		else {
			return false;
		}
	}
	
	
	
	public boolean emailSent(WebDriver driver) throws IOException {
		String expected = "We’ve sent you an email with a link to finish resetting your password.";
        if(driver.getPageSource().contains(expected)) {
        	return true;
        }
        else {
        	return false;
        }
			}
	public boolean checkEmailPassword(WebDriver driver) throws IOException {
		String expected = "Please check your username and password. If you still can't log in, contact your Salesforce administrator.";
		String output = driver.findElement(By.id("error")).getText();
		if(output.equals(expected)) {
        	return true;
        }
        else {
        	return false;
        }
			}
}
