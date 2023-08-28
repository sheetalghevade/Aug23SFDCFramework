package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class test {
     static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
        WebDriverManager.firefoxdriver().setup();
		
		driver = new FirefoxDriver();
		driver.get("https://www.google.com");
        
		WebElement search = driver.findElement(By.name("q"));
		search.sendKeys("Selenium");
		search.submit();
//		WebElement uname=driver.findElement(By.id("username"));
//		uname.clear();
//		uname.sendKeys("sheetalg@tek.com");
//		WebElement pswrd = driver.findElement(By.id("password"));
//		pswrd.clear();
//		pswrd.sendKeys("test1234");
//		
//		driver.findElement(By.id("Login")).click();
//		
//		
//		Thread.sleep(4000);

	}

}
