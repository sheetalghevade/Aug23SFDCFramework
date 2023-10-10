package pages;

import java.io.IOException;
//import java.util.List;
import java.util.List;

import org.openqa.selenium.By;
//import org.openqa.selenium.By;
//import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import constants.FileConstants;
import utils.CommonUtils;
import utils.FileUtils;

/**
 * This page contains all the required page object elements and methods of
 * usermenu page
 * 
 * @author Sheetal
 * @version v1.0
 */

public class AccountsPage extends BasePage  {
	
	public  AccountsPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//*[@id=\"Account_Tab\"]/a")
	public WebElement AccountTab;
	
	@FindBy(xpath = "//*[@value=\" New \"]")
	public WebElement newbtn;
	
	@FindBy(id = "acc2")
	public WebElement Accountname;
	
	@FindBy(id = "acc6")
	public WebElement Accounttype;
	
	@FindBy(id = "00NHu00000PDxsb")
	public WebElement CustPriority;
	
	@FindBy(xpath = "//input[@value = \" Save \"]")
	public WebElement save;
	
	@FindBy(linkText = "Create New View")
	public WebElement CreateNewView;
	
	@FindBy(id = "fname")
	public WebElement ViewName;
	
	@FindBy(id = "devname")
	public WebElement ViewUniqName;
	
	@FindBy(xpath = "//input[@value = \" Save \"]")
	public WebElement ViewSave;
	
	@FindBy(xpath = "//*[@id=\"fcf\"]")
	public WebElement ViewDrpdown;
	
	@FindBy(linkText = "Edit")
	public WebElement Editlink;
	
	@FindBy(xpath = "//*[@id=\"fname\"]")
	public WebElement EditViewName;
		
	@FindBy(xpath = "//*[@id=\"fcol1\"]")
	public WebElement FilterField;
	
	@FindBy(xpath = "//*[@id=\"fop1\"]")
	public WebElement FilterOp;
	
	@FindBy(xpath = "//*[@id=\"fval1\"]")
	public WebElement FilterVal;
	
	@FindBy(name = "save")
	public WebElement EditViewSave;
	
	@FindBy(linkText = "Merge Accounts")
	public WebElement MergeAccLink;
	
	@FindBy(xpath = "//*[@id=\"srch\"]")
	public WebElement SearchAcc;
	
	@FindBy(name = "srchbutton")
	public WebElement FindAccounts;
	
	@FindBy(xpath = "//input[@value = \"Delete\"]")
	public WebElement DeleteAcc;
	
	
	@FindBy(xpath = "//*[@class='list']")
	public WebElement table;
	
	@FindBy(xpath = "//input[@id='cid0']")
	public WebElement SelectBox1;
	
	@FindBy(xpath = "//input[@id='cid1']")
	public WebElement SelectBox2;
	
	@FindBy(xpath = "//input[@id='cid2']")
	public WebElement SelectBox3;
	
	@FindBy(xpath = "//*[@title='Next']")
	public WebElement Next;
	
	@FindBy(xpath = "//*[@title='Merge']")
	public WebElement Merge;
	
	@FindBy(partialLinkText =  "30 days")
	public WebElement Reports30days;
	
	@FindBy(xpath = "//*[@id=\"ext-gen20\"]")
	public WebElement DateField;
	
	@FindBy(xpath = "//*[@id=\"ext-gen296\"]/div[3]")
	public WebElement CreatedDate;
	
	@FindBy(xpath = "//*[@id=\"ext-gen152\"]")
	public WebElement From;
	
	@FindBy(xpath = "//*[@class=\"x-btn-mc\"]")
	public WebElement FromToday;
	
	
	@FindBy(xpath = "//*[@id=\"ext-gen154\"]")
	public WebElement To;
	
	@FindBy(xpath = "//*[@class=\" x-btn-text\"]")
	public WebElement ToToday;
	
	
	
	
	
    public boolean verifyAccountsPage(WebDriver driver){
    	String expected = "Accounts: Home ~ Salesforce - Developer Edition";
    	if(driver.getPageSource().contains(expected)) {
    		System.out.println("Account page is displayed");
			return true;
		}
		else {
			System.out.println("Account page is not displayed");
			return false;
		}
    }
    public boolean verifyAccountEditPage(WebDriver driver){
    	String expected = "Account Edit: New Account ~ Salesforce - Developer Edition";
    	if(driver.getPageSource().contains(expected)) {
    		System.out.println("Account edit/new page is displayed");
			return true;
		}
		else {
			System.out.println("Account edit/new page is not displayed");
			return false;
		}
    }
    
    
    public void createNewAccount(WebDriver driver) throws IOException {
    	CommonUtils.waitForElement(driver, newbtn);
		newbtn.click();
    	CommonUtils.waitForElement(driver, Accountname);
    	Accountname.sendKeys(FileUtils.readPropertiesFile(FileConstants.LOGIN_TESTDATA_FILE_PATH2, "usraccname"));
    	CommonUtils.waitForElement(driver,Accounttype);
    	Select drpsel = new Select(Accounttype);
    	drpsel.selectByValue("Technology Partner");
    	CommonUtils.waitForElement(driver,CustPriority);
        Select drpsel1 = new Select(CustPriority);
      	drpsel1.selectByValue("High");
      	save.click();
     }
    
    public boolean verifyNewAccount(WebDriver driver) throws IOException{
    	String expected = FileUtils.readPropertiesFile(FileConstants.LOGIN_TESTDATA_FILE_PATH2, "usraccname");
    	if(driver.getPageSource().contains(expected)) {
    		System.out.println("new Account is created");
			return true;
		}
		else {
			System.out.println("new Account is not created");
			return false;
		}
    }
    
    public boolean verifyNewViewPage(WebDriver driver){
    	String expected = "Accounts: Create New View ~ Salesforce - Developer Edition";
    	if(driver.getPageSource().contains(expected)) {
    		System.out.println("new view page is displayed");
			return true;
		}
		else {
			System.out.println("new view page is not displayed");
			return false;
		}
    }
    
    
    public void createNewView(WebDriver driver) throws IOException {
    	CommonUtils.waitForElement(driver, ViewName);
    	ViewName.sendKeys(FileUtils.readPropertiesFile(FileConstants.LOGIN_TESTDATA_FILE_PATH2, "Usraccview2"));
    	CommonUtils.waitForElement(driver,ViewUniqName);
    	ViewUniqName.click();
    	ViewUniqName.clear();
    	ViewUniqName.sendKeys(FileUtils.readPropertiesFile(FileConstants.LOGIN_TESTDATA_FILE_PATH2, "UsraccUnview2"));
    	ViewSave.click();
     }
    
    public boolean verifyNewView(WebDriver driver) throws IOException{
    	String expected = FileUtils.readPropertiesFile(FileConstants.LOGIN_TESTDATA_FILE_PATH2, "Usraccview2");
    	if(driver.getPageSource().contains(expected)) {
    		System.out.println("new View is created");
			return true;
		}
		else {
			System.out.println("new View is not created");
			return false;
		}
    }
    
    public boolean verifyEditViewPage(WebDriver driver){
    	String expected = "Accounts: Edit View ~ Salesforce - Developer Edition";
    	if(driver.getPageSource().contains(expected)) {
    		System.out.println("Edit view page is displayed");
			return true;
		}
		else {
			System.out.println("Edit view page is not displayed");
			return false;
		}
    }
    
    public void editView(WebDriver driver) throws IOException {
    	CommonUtils.waitForElement(driver,EditViewName);
    	EditViewName.click();
    	EditViewName.clear();
    	EditViewName.sendKeys(FileUtils.readPropertiesFile(FileConstants.LOGIN_TESTDATA_FILE_PATH2, "Usraccview3"));
    	CommonUtils.waitForElement(driver,FilterField);
    	Select fieldDrpsel = new Select(FilterField);
    	fieldDrpsel.selectByVisibleText("Account Name");
    	CommonUtils.waitForElement(driver,FilterOp);
        Select opDrpsel = new Select(FilterOp);
        opDrpsel.selectByVisibleText("contains"); 	
        CommonUtils.waitForElement(driver,FilterVal);
        FilterVal.click();
        FilterVal.clear();
        FilterVal.sendKeys("a");
        EditViewSave.click();
       }
    
    public boolean verifyEditView(WebDriver driver) throws IOException{
    	String expected = FileUtils.readPropertiesFile(FileConstants.LOGIN_TESTDATA_FILE_PATH2, "Usraccview3");
    	if(driver.getPageSource().contains(expected)) {
    		System.out.println("View Edited Succesfully");
			return true;
		}
		else {
			System.out.println("Edit View Fail");
			return false;
		}
    }
    
    public void createMultipleNewAccount(WebDriver driver) throws IOException {
    	CommonUtils.waitForElement(driver, AccountTab);
		AccountTab.click();
		CommonUtils.waitForElement(driver, newbtn);
	    newbtn.click();
    	CommonUtils.waitForElement(driver, Accountname);
    	Accountname.sendKeys(FileUtils.readPropertiesFile(FileConstants.LOGIN_TESTDATA_FILE_PATH2, "usraccname"));
    	CommonUtils.waitForElement(driver,Accounttype);
    	Select drpsel = new Select(Accounttype);
    	drpsel.selectByValue("Technology Partner");
    	CommonUtils.waitForElement(driver,CustPriority);
        Select drpsel1 = new Select(CustPriority);
      	drpsel1.selectByValue("High");
      	save.click();
      	
      	CommonUtils.waitForElement(driver, AccountTab);
		AccountTab.click();
		CommonUtils.waitForElement(driver, newbtn);
	    newbtn.click();
	    CommonUtils.waitForElement(driver, Accountname);
    	Accountname.sendKeys(FileUtils.readPropertiesFile(FileConstants.LOGIN_TESTDATA_FILE_PATH2, "usraccname1"));
    	CommonUtils.waitForElement(driver,Accounttype);
//    	Select drpse2 = new Select(Accounttype);
    	drpsel.selectByValue("Technology Partner");
    	CommonUtils.waitForElement(driver,CustPriority);
//        Select drpsel2 = new Select(CustPriority);
      	drpsel1.selectByValue("High");
      	save.click();
      	
      	CommonUtils.waitForElement(driver, AccountTab);
		AccountTab.click();
		CommonUtils.waitForElement(driver, newbtn);
	    newbtn.click();
	    CommonUtils.waitForElement(driver, Accountname);
    	Accountname.sendKeys(FileUtils.readPropertiesFile(FileConstants.LOGIN_TESTDATA_FILE_PATH2, "usraccname2"));
    	CommonUtils.waitForElement(driver,Accounttype);
//    	Select drpse2 = new Select(Accounttype);
    	drpsel.selectByValue("Technology Partner");
    	CommonUtils.waitForElement(driver,CustPriority);
//        Select drpsel2 = new Select(CustPriority);
      	drpsel1.selectByValue("High");
      	save.click();
	    
     }
    
    public void deleteAccounts(WebDriver driver) {
    	CommonUtils.waitForElement(driver, AccountTab);
		AccountTab.click();
		
		CommonUtils.waitForElement(driver, table);
		List<WebElement> rows = table.findElements(By.tagName("tr"));
		for(int rnum=0;rnum<rows.size();rnum++) {
			List<WebElement> header = rows.get(rnum).findElements(By.tagName("th"));
			
			for(int head=0;head<header.size();head++) {
				List<WebElement> columns=rows.get(rnum).findElements(By.tagName("td"));


//				System.out.println(columns.get(0).getText());
				
				System.out.print(header.get(head).getText());
			System.out.print(header.get(0).getText());
			}
			header = rows.get(rnum).findElements(By.tagName("td"));
			for(int head=0;head<header.size();head++) {
				System.out.print(header.get(head).getText());
			}
			System.out.println(" ");
		}
		
    }
    
    
    
    
    public boolean verifyMergeAccountPage(WebDriver driver){
    	String expected = "Merge My Accounts ~ Salesforce - Developer Edition";
    	if(driver.getPageSource().contains(expected)) {
    		System.out.println("Merge Account page is displayed");
			return true;
		}
		else {
			System.out.println("Merge Account page is not displayed");
			return false;
		}
    }
    
    public void merge(WebDriver driver) throws IOException {
       	CommonUtils.waitForElement(driver,SearchAcc);
    	SearchAcc.sendKeys(FileUtils.readPropertiesFile(FileConstants.LOGIN_TESTDATA_FILE_PATH2, "usraccname"));
    	CommonUtils.waitForElement(driver, FindAccounts);
    	FindAccounts.click();
    	int rowcount = driver.findElements(By.xpath("//table[@class='list']//tr")).size();
    	System.out.println(rowcount);
    	
    	List<WebElement> totalRowlist = table.findElements(By.tagName("tr"));
    	for(int i=0;i<totalRowlist.size();i++) {
    	System.out.println(totalRowlist.get(i).getText());
    	    	}
    	
    	if(totalRowlist.size()>=rowcount-1) {
    		if(!SelectBox1.isSelected()) {
    			SelectBox1.click();
    		}
    		if(!SelectBox2.isSelected()) {
    			SelectBox2.click();
    		}
    		if(!SelectBox3.isSelected()) {
    			SelectBox3.click();
    		}
    	
    	}
    	CommonUtils.moveToElement(driver, Next);
    	Next.click();
    	CommonUtils.moveToElement(driver, Merge);
    	Merge.click();
    	driver.switchTo().alert().accept();
    	   	
       }
    
    
    public void deleteAccount(WebDriver driver) throws IOException {
    	CommonUtils.waitForElement(driver, AccountTab);
		AccountTab.click();
		driver.findElement(By.linkText(FileUtils.readPropertiesFile(FileConstants.LOGIN_TESTDATA_FILE_PATH2, "usraccname"))).click();
		CommonUtils.waitForElement(driver, DeleteAcc);
		DeleteAcc.click();
		driver.switchTo().alert().accept();
    }
    
    public void accountReport(WebDriver driver) throws IOException {
    	CommonUtils.waitForElement(driver, AccountTab);
		AccountTab.click();
    	CommonUtils.waitForElement(driver, Reports30days);
    	Reports30days.click();
    	
    	
    	CommonUtils.waitForElement(driver, DateField);
    	DateField.click();
    	
        WebElement dropdown = driver.findElement(By.xpath("//div[contains(text(),'Created Date')]"));

        dropdown.click();
    	    	
    	CommonUtils.waitForElement(driver, From);
    	From.click();
    	
    	CommonUtils.waitForElement(driver, FromToday);
    	FromToday.click();
    	
    	System.out.println("clicked today");
    	
    	CommonUtils.waitForElement(driver, To);
    	To.click();
    	
    	CommonUtils.waitForElement(driver, ToToday);
    	ToToday.click();
    	
    	
    }
}
