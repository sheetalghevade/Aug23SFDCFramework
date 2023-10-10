package pages;

import java.io.IOException;
import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import constants.FileConstants;
import utils.CommonUtils;
import utils.FileUtils;

public class OptyPage extends BasePage{

	public  OptyPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//*[@id=\"Opportunity_Tab\"]/a")
	public WebElement OpportunitiesTab;
	
	@FindBy(xpath = "//*[@title='View:']")
	public WebElement OptyDrpdwn;
	
	@FindBy(xpath = "//*[@value=\" New \"]")
	public WebElement New;
	
	@FindBy(id = "opp3")
	public WebElement OptyName;
	
	@FindBy(xpath = "//input[@id='opp4']")
	public WebElement AccountName;
	
	@FindBy(xpath = "//input[@id='opp9']")
	public WebElement CloseDate;
	
	@FindBy(xpath = "//a[@class='calToday']")
	public WebElement Today;
	
	@FindBy(xpath = "//select[@id='opp11']")
	public WebElement Stage;
	
	@FindBy(xpath = "//input[@id='opp12']")
	public WebElement Probability;
	
	@FindBy(xpath = "//select[@id='opp6']")
	public WebElement LeadSource;
	
	@FindBy(xpath = "//*[@title='Primary Campaign Source Lookup (New Window)']")
	public WebElement PCSource;
	
	@FindBy(xpath = "//*[@id=\"lksrch\"]")
	public WebElement Search;
	
	@FindBy(xpath = "//input[@name='go']")
	public WebElement Go;
	
	@FindBy(xpath = "//input[@value=\" Save \"]")
	public WebElement Save;
	
	@FindBy(linkText = "Opportunity Pipeline")
	public WebElement OptyPipeline;
	
	@FindBy(linkText = "Stuck Opportunities")
	public WebElement StuckOpty;
		
	@FindBy(xpath = "//*[@id=\"quarter_q\"]")
	public WebElement Interval;
	
	@FindBy(xpath = "//*[@id=\"open\"]")
	public WebElement Include;
	
	@FindBy(xpath = "//*[@value=\"Run Report\"]")
	public WebElement RunReport;
	
	 public boolean verifyOpportunitiesPage(WebDriver driver){
	    	String expected = "Opportunities: Home ~ Salesforce - Developer Edition";
	    	if(driver.getPageSource().contains(expected)) {
	    		System.out.println("Opportunities page is displayed");
				return true;
			}
			else {
				System.out.println("Opportunities page is not displayed");
				return false;
			}
	    }
	
	 public boolean verifyOpportunitiesMenuItems() throws IOException {

			boolean isOptionsVerified;
			String[] expectedOptyMenuItems = FileUtils.readOpty("opportunities.list").split(",");
			Select list = new Select(OptyDrpdwn);
			List<WebElement> actual = list.getOptions();
			
			System.out.println("Expected result:");
			System.out.println();
			for (int i = 0; i < expectedOptyMenuItems.length; i++) {
				System.out.println(expectedOptyMenuItems[i]);
	    	        }
						
			System.out.println("Number of oportunities are "+actual.size());
			
	        System.out.println("Actual result:");
	        System.out.println();
			String[] output = new String[actual.size()]; 
			for (int i = 0; i < actual.size(); i++) {
				output[i] = actual.get(i).getText();
	            System.out.println(output[i]);
	    	        }
				
			isOptionsVerified = Arrays.equals(expectedOptyMenuItems, output);
			System.out.println(isOptionsVerified);
			
			return isOptionsVerified;
	 }
	 
	 public boolean verifyNewOpportunitiesPage(WebDriver driver) {
		 String expected = "Opportunity Edit: New Opportunity ~ Salesforce - Developer Edition";
	    	if(driver.getPageSource().contains(expected)) {
	    		System.out.println("New Opportunities page is displayed");
				return true;
			}
			else {
				System.out.println("New Opportunities page is not displayed");
				return false;
			}
		 		 
	 }
	 
	 public void CreateNewOpty(WebDriver driver) throws IOException, InterruptedException {
		 CommonUtils.waitForElement(driver, OptyName);
		 OptyName.click();
		 OptyName.clear();
		 OptyName.sendKeys(FileUtils.readOpty("optyName"));
		 CommonUtils.waitForElement(driver, AccountName);
		 AccountName.click();
		 AccountName.sendKeys(FileUtils.readPropertiesFile(FileConstants.LOGIN_TESTDATA_FILE_PATH2, "usraccname"));
		 CommonUtils.waitForElement(driver, CloseDate);
		 CloseDate.click();
		 CommonUtils.waitForElement(driver, Today);
		 Today.click();
		 CommonUtils.waitForElement(driver, Stage);
		 Select selStage = new Select(Stage);
		 selStage.selectByIndex(2);
		 CommonUtils.waitForElement(driver, Probability);
		 Probability.click();
		 Probability.clear();
		 Probability.sendKeys("50");
		 CommonUtils.waitForElement(driver, LeadSource);
		 Select selLeadSource = new Select(LeadSource);
		 selLeadSource.selectByIndex(1);
		 CommonUtils.waitForElement(driver, PCSource);
		 PCSource.click();
		 String oldwindow = driver.getWindowHandle();
	      Set<String> getAllWindows = driver.getWindowHandles();
	      System.out.println(getAllWindows.size());
	      String[]getwindow = getAllWindows.toArray(new String[getAllWindows.size()]);
	     	      
	      driver.switchTo().window(getwindow[1]);
	      driver.manage().window().maximize();
	      driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	      driver.switchTo().frame("searchFrame"); 
		 	CommonUtils.waitForElement(driver, Search);
			Search.click();
			Search.sendKeys("*a");
			CommonUtils.waitForElement(driver, Go);
			Go.click();
			driver.switchTo().defaultContent();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			driver.switchTo().frame("resultsFrame");
			System.out.println("in results frame");
			driver.findElement(By.xpath("//*[@class='dataRow even first']/th/a")).click();
			Thread.sleep(4000);
			driver.switchTo().window(getwindow[0]);
			CommonUtils.waitForElement(driver, Save);
			Save.click();
			}
	 
	 public boolean verifyNewOptyCreated(WebDriver driver) throws IOException {
		 String expected = "Opportunity: ".concat(FileUtils.readOpty("optyName")).concat(" ~ Salesforce - Developer Edition");
	    	if(driver.getPageSource().contains(expected)) {
	    		System.out.println("New Opty is created");
				return true;
			}
			else {
				System.out.println("New Opty is not created");
				return false;
			}
		 		 
	 }
	 
	 public boolean verifyStuckOpty(WebDriver driver) {
		 CommonUtils.waitForElement(driver, StuckOpty);
		 StuckOpty.click();
		 String expected = "Stuck Opportunities ~ Salesforce - Developer Edition";
	    	if(driver.getPageSource().contains(expected)) {
	    		System.out.println("Stucked Opportunities are displayed");
				return true;
			}
			else {
				System.out.println("Stucked Opportunities are not displayed");
				return false;
			}
		 		 
	 }
	
	 public boolean verifyQuartSumryReport(WebDriver driver) {
		 CommonUtils.waitForElement(driver, Interval);
		 Select selInterval = new Select(Interval);
		 selInterval.selectByVisibleText("Current FQ");
		 
		 CommonUtils.waitForElement(driver, Include);
		 Select selInclude = new Select(Include);
		 selInclude.selectByVisibleText("Open Opportunities");
		 
		 CommonUtils.waitForElement(driver, RunReport);
		 RunReport.click();
		 
		 String expected = "Opportunity Report ~ Salesforce - Developer Edition";
	    	if(driver.getPageSource().contains(expected)) {
	    		System.out.println("Quarterly summary report is displayed");
				return true;
			}
			else {
				System.out.println("Quarterly summary report is not displayed");
				return false;
			}
		 		 
	 }
	 
	 
	 public boolean verifyNewOptyPipeline(WebDriver driver) {
		 CommonUtils.waitForElement(driver, OptyPipeline);
		 OptyPipeline.click();
		 String expected = "Opportunity Pipeline ~ Salesforce - Developer Edition";
	    	if(driver.getPageSource().contains(expected)) {
	    		System.out.println("Pipelined Opportunities are displayed");
				return true;
			}
			else {
				System.out.println("Pipelined Opportunities are not displayed");
				return false;
			}
		 		 
	 }
	
}
