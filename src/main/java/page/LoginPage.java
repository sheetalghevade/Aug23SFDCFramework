package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage{
	
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "username")
	public WebElement username;
	
	@FindBy(id = "password")
	public WebElement password;
	
	@FindBy(id = "Login")
	public WebElement LoginBtn;
	
	@FindBy(id = "error")
	public WebElement errorMessage;
	
	@FindBy(id = "rememberUn")
	public WebElement rememberMeChkbox;
	
	@FindBy(id = "forgot_password_link")
	public WebElement forgotPswrdlink;
	
	@FindBy (id = "un")
	public WebElement usernameForgot;
	
	@FindBy (id = "continue")
	public WebElement continueBtn;
	
	@FindBy(id = "idcard-identity")
	public WebElement saveduserName;
	
	
	
}
