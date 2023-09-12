package demo;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class CurrencyConverot {
	WebDriver driver;
	
	@Test
	public void currency() throws Exception {
		
		driver = new FirefoxDriver();
		driver.get("https://www.xe.com");
		
		driver.findElement(By.xpath("//input[@id='midmarketFromCurrency']")).sendKeys("USD"+Keys.ENTER);
        driver.findElement(By.xpath("//input[@id='midmarketToCurrency']")).sendKeys("INR"+Keys.ENTER); 
        Thread.sleep(4000);
        driver.findElement(By.xpath("//*[@style='grid-area:buttons']")).click();		
	}

}
