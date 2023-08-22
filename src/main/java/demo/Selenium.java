package demo;

//import java.awt.Button;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.remote.RemoteWebDriver;

public class Selenium {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

//		WebDriver driver = new ChromeDriver();
		
	    WebDriver driver = new FirefoxDriver();
		driver.get("https://login.salesforce.com");
		driver.findElement(By.id("username")).sendKeys("sheetalg@tek.com");
		driver.findElement(By.id("password")).sendKeys("dhruvdaksh1");
//		driver.findElement(By.xpath("//button[contains(text(),'Log')]")).click();
		driver.findElement(By.xpath("//input[@value=\"Log In\"]")).click();
		
		//input[@value="Log In"
		
		
		
		Thread.sleep(5000);
	}

}
