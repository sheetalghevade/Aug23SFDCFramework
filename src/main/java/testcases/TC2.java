package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.devtools.idealized.Javascript;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TC2 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub


	    WebDriver driver = new FirefoxDriver();
	    driver.get("https://login.salesforce.com");
	    driver.manage().window().maximize();
		driver.findElement(By.id("username")).sendKeys("sheetalg@tek.com");
		driver.findElement(By.id("password")).sendKeys("test1234");
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("alert('Search Me');");
		
		
		
		driver.findElement(By.xpath("//input[@value=\"Log In\"]")).click();
		
		
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
