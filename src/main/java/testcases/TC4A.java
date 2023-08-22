package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TC4A {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

WebDriver driver = new FirefoxDriver();
		
		driver.get("https://login.salesforce.com");
		driver.manage().window().maximize();
		driver.findElement(By.id("forgot_password_link")).click();
		driver.findElement(By.id("un")).sendKeys("sheetalg@tek.com");
        driver.findElement(By.id("continue")).click();
        
        String expected = "We’ve sent you an email with a link to finish resetting your password.";
        if(driver.getPageSource().contains(expected)) {
        	System.out.println("Pass");
        }
        else {
        	System.out.println("Fail");
        }
		
	}

}
