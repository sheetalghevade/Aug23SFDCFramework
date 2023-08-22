package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TC4B {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriver driver = new FirefoxDriver();
		
		driver.get("https://login.salesforce.com");
		driver.findElement(By.id("username")).sendKeys("123");
		driver.findElement(By.id("password")).sendKeys("2341");
		driver.findElement(By.id("Login")).click();
		
		String expected = "Please check your username and password. If you still can't log in, contact your Salesforce administrator.";
		String output = driver.findElement(By.id("error")).getText();
		
		if(output.equals(expected)) {
			System.out.println("Pass");
		}
		else {
			System.out.println("Fail");
		}
		
	}

}
