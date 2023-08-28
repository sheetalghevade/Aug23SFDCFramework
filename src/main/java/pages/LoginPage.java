package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	
	}
	
	@FindBy(id = "username")
	public WebElement username;
	
	@FindBy(id = "password" )
	public WebElement password;
	
	@FindBy(id = "Login" )
	public WebElement loginButton;
	
	@FindBy(xpath = "//*[@id='rememberUn']" )
	public WebElement rememberMe;
	
	@FindBy(id = "error" )
	public WebElement errorMessage;
	
	@FindBy(partialLinkText = "Forgot" )
	public WebElement forgotPassword;
	
	@FindBy(id = "idcard-identity")
	public WebElement savedUsername;
	
	@FindBy(id = "un")
	public WebElement forgotUsername;
	
	@FindBy(xpath = "//a[text()='Return to Login']")
	public WebElement returnToLoginButton;
	
	
	public boolean selectRememberMeCheckBox() {
		boolean isSelected = false;
		if(! rememberMe.isSelected()) {
			rememberMe.click();
			isSelected = true;
		} 
		return isSelected;
	}
	
	
}
