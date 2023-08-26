package tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import page.LoginPage;

public class LoginTests extends BaseTests{
	

	@Test
	public void Login_TC2() throws Exception
	{
		WebDriver driver = BaseTests.getDriver();
		LoginPage lp = new LoginPage(driver);
		
			
		driver.get("https://login.salesforce.com");
		
		lp.username.sendKeys("sheetalg@tek.com");
		lp.password.sendKeys("test1234");
		lp.LoginBtn.click();
		
        Thread.sleep(5000);
		
		String expected = "Home Page ~ Salesforce - Developer Edition";
		
	
		if(driver.getPageSource().contains(expected)) {
			System.out.println("Pass");
		}
		else {
			System.out.println("Fail");
		}
	}
	
	
	}


