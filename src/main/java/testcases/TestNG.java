package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class TestNG {
     WebDriver driver = new FirefoxDriver();
	@Test
	public void Login(){
		driver.get("https://login.salesforce.com");
		driver.findElement(By.id("username")).sendKeys("sheetalg@tek.com");
		driver.findElement(By.id("password")).sendKeys("test1234");
		driver.findElement(By.id("Login")).click();
	}
	
	@Test
	public void out() {
		driver.close();
	}
}
