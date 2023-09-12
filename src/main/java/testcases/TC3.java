package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TC3 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();
	    driver.get("https://login.salesforce.com");
	    driver.manage().window().maximize();
		driver.findElement(By.id("username")).sendKeys("sheetalg@tek.com");
		driver.findElement(By.id("password")).sendKeys("test1234");
		driver.findElement(By.id("rememberUn")).click();
		
		Thread.sleep(5000);
		
		driver.findElement(By.xpath("//input[@value=\"Log In\"]")).click();
		
		
		Thread.sleep(5000);
		
		String expected = "Home Page ~ Salesforce - Developer Edition";
		
		if(driver.getPageSource().contains(expected)) {
			System.out.println("Pass");
		}
		else {
			System.out.println("Fail");
		}
		
				
		Thread.sleep(4000);
		
		driver.findElement(By.xpath("//div[@id='userNav-arrow']")).click();
		
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//div[@id='userNav-menuItems']//child::a[@title=\"Logout\"]")).click();
		
		Thread.sleep(3000);
		
		String expected1 = "sheetalg@tek.com";
				
		if(driver.getPageSource().contains(expected1)) {
			
			System.out.println("pass");
					}
		else {
			System.out.println("fail");
			
		}
		
		
	}

}
