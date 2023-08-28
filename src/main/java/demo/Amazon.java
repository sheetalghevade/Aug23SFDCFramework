package demo;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



public class Amazon {
	
	public static void verification(WebDriver driver) throws Exception {
		System.out.println("robot");
		order(driver);
		}
	
	public static void order(WebDriver driver) throws Exception {
		
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(80));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("twotabsearchtextbox")));

		
		WebElement search = driver.findElement(By.id("twotabsearchtextbox"));
		search.sendKeys("kindle");
		search.submit();
		
		Thread.sleep(4000);
		
	
		String expected = "Amazon.com : kindle";
		if(driver.getPageSource().contains(expected)) {
			System.out.println("Pass: Search results are visible");
		}
		else {
			System.out.println("Fail:Search result not returned");
		}
		
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"B09SWV3BYH-amazons-choice\"]")));
		
		driver.findElement(By.xpath("//*[@id=\"B09SWV3BYH-amazons-choice\"]")).click();
		driver.findElement(By.xpath("//*[@value=\"Add to Cart\"]")).submit();
		
		Thread.sleep(4000);
		
		String epected2 = "Amazon.com Shopping Cart";
		if(driver.getPageSource().contains(epected2))
		{
			System.out.println("Pass: Shopping cart is visible");
			if(driver.findElement(By.xpath("//*[@value=\"Proceed to checkout\"]")).isEnabled()) {
				System.out.println("Checkout Button is Enabled");
			}
			else {
				System.out.println("Checkout Button is not available");
			}
		}
		else {
			System.out.println("Fail");
		}
				
		System.out.println("Added to cart successfully");
	}
	
public static void main(String[] args) throws Exception {
	WebDriver driver = new FirefoxDriver();
		
	driver.get("https://www.amazon.com");
	String expected = "Amazon.com";
	
			
	if(driver.getPageSource().contains(expected))
	{
		verification(driver);
	}
	else {
		order(driver);
	}
	
}

}
