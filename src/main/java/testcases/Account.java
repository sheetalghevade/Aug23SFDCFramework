package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Account {
	public void account() throws InterruptedException{
		
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
		
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//*[@id=\"Account_Tab\"]")).click();
		
     String expected1 = "Accounts: Home ~ Salesforce - Developer Edition";
     
		
		if(driver.getPageSource().contains(expected1)) {
			System.out.println("Pass");
		}
		else {
			System.out.println("Fail");
		}
		driver.findElement(By.xpath("//*[@id=\"Account_Tab\"]")).click();
		
		
		}
		}
	

