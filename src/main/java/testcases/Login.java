package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Login {
	public void login() throws InterruptedException{
	WebDriver driver = new FirefoxDriver();
	driver.get("https://login.salesforce.com");
	driver.findElement(By.id("username")).sendKeys("sheetalg@tek.com");
	driver.findElement(By.id("password")).sendKeys("test1234");
	driver.findElement(By.id("Login")).click();
	
		
	Thread.sleep(3000);
	
	String expected = "Home Page ~ Salesforce - Developer Edition";
	
	if(driver.getPageSource().contains(expected)) {
		System.out.println("Pass");
	}
	else {
		System.out.println("Fail");
	}
	}
}
