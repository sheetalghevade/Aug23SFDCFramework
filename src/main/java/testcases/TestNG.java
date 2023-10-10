package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class TestNG {
     WebDriver driver = new FirefoxDriver();
	@Test(groups = {"smoke", "regression"})
	public void Login(){
		driver.get("https://login.salesforce.com");
		driver.findElement(By.id("username")).sendKeys("sheetalg@tek.com");
		driver.findElement(By.id("password")).sendKeys("test1234");
		driver.findElement(By.id("Login")).click();
		System.out.println("Message");
	}
	

	@Test(groups = "regression")
	public void out() {
		System.out.println("regression");
	
	}
	
	@Test(groups = "smoke")
	public void ogin(){
		System.out.println("smoke");
	}

}
