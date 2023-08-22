package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TC1 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		 WebDriver driver = new FirefoxDriver();
			driver.get("https://login.salesforce.com");
			driver.manage().window().maximize();
			driver.findElement(By.id("username")).sendKeys("sheetalg@tek.com");

			
		    driver.findElement(By.xpath("//input[@value=\"Log In\"]")).click();
			
			String expected = "Please enter your password.";
			String output = driver.findElement(By.id("error")).getText();
			
			
			if(output.equals(expected)) {
				System.out.println("Pass");
			}
			else {
				System.out.println("Fail");
			}
			Thread.sleep(5000);

	}

}
