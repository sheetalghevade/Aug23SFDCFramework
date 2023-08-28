package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class TC10 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

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
		
		
		driver.findElement(By.xpath("//*[@id=\"Account_Tab\"]")).click();
		
		
		
		//creating new account.
		
		driver.findElement(By.xpath("//*[@value=\" New \"]")).click();
		
		//Adding details
		
		driver.findElement(By.id("acc2")).sendKeys("Account12");
		
		driver.findElement(By.id("acc6")).click();
				
		
		Select drpsel = new Select(driver.findElement(By.id("acc6")));
		
		drpsel.selectByValue("Technology Partner");
		
       Select drpsel1 = new Select(driver.findElement(By.id("00NHu00000PDxsb")));
      
		
		drpsel1.selectByValue("High");
		
		driver.findElement(By.xpath("//input[@value = \" Save \"]")).click();
		
		String expected1 = "Account: Account12 ~ Salesforce - Developer Edition";
		if(driver.getPageSource().contains(expected1)) {
			System.out.println("Pass");
		}
		else
		{System.out.println("Fail");
		
		}
		
		
		
	}

}
