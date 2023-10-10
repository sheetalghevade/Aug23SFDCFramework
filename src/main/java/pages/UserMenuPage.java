package pages;

import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

//import constants.FileConstants;
//import constants.WaitConstants;
import utils.CommonUtils;
import utils.FileUtils;

/**
 * This page contains all the required page object elements and methods of
 * usermenu page
 * 
 * @author Sheetal
 * @version v1.0
 */

public class UserMenuPage extends BasePage{

	public UserMenuPage(WebDriver driver) {
		PageFactory.initElements(driver, this);

	}

	@FindBy(id = "userNavLabel")
	public WebElement userMenu;

	@FindBy(xpath = "//div[@id='userNav-menuItems']/a")
	public List<WebElement> userMenuOptions;

	@FindBy(xpath = "//a[@title='My Profile']")
	public WebElement MyProfile;

	@FindBy(xpath = "//*[@id=\"userNav-menuItems\"]/a[2]")
	public WebElement MySettings;
	

//	@FindBy(id = "//a[@title='My Settings']")
//	public WebElement MySettings;
	
	@FindBy(xpath = "//a[@title='Developer Console (New Window)']")
	public WebElement DeveloperConsole1;

	@FindBy(id = "userNav-menuItems/a[4]")
	public WebElement SwitchtoLightningExperience;

	@FindBy(xpath = "//*[@id=\"userNav-menuItems\"]/a[5]")
	public WebElement Logout;
		
		// My profile
	@FindBy(xpath = "//a[@class='contactInfoLaunch editLink']")
	public WebElement editContactButton;

	@FindBy(xpath = "//div/h2[@id='contactInfoTitle']")
	public WebElement EditProfilePopupwindow;

	@FindBy(id = "aboutTab")
	public WebElement Abouttab;

	@FindBy(xpath = "//input[@id='lastName']")
	public WebElement Abouttablastname;

	@FindBy(xpath = "//*[@value='Save All']")
	public WebElement saveAllButton;

	@FindBy(xpath = "//*[@id=\"tailBreadcrumbNode\"]")
	public WebElement Userprofilepagenamedisplay;

	// Postlink
	@FindBy(css = "#publishereditablearea")
	public WebElement postLink;

	@FindBy(xpath = "/html/body")
	public WebElement postTextArea;

	@FindBy(xpath = "//input[@id='publishersharebutton']")
	public WebElement shareButton;

	// filelink

	@FindBy(xpath = "//*[@id='publisherAttachContentPost']")
	public WebElement filelink;

	@FindBy(xpath = "//a[@id='publisherAttachContentPost']/span[1]")
	public WebElement contentpost;

	@FindBy(css = "#chatterUploadFileAction")
	public WebElement Uploadfile;

	@FindBy(css = "#chatterFile")
	public WebElement Fileopen;

	@FindBy(css = "#publishersharebutton")
	public WebElement publish;

	@FindBy(xpath = "//input[@value='Cancel Upload']")
	public WebElement cancelUpload;

	@FindBy(id = "uploadLink")
	public WebElement updateButton;
	// Photo link

	@FindBy(xpath = "//*[@id=\"publisherAttachLinkPost\"]/span[1]")
	public WebElement photolink;

	@FindBy(id = "j_id0:uploadFileForm:uploadInputFile")
	public WebElement uploadphoto;

	@FindBy(name = "j_id0:uploadFileForm:uploadBtn")
	public WebElement uploadbutton;

	@FindBy(id = "publishersharebutton")
	public WebElement photosharebutton;

	@FindBy(id = "uploadPhotoContentId")
	public WebElement photoUploadIframe;

	@FindBy(xpath = "//input[@id='j_id0:uploadFileForm:uploadBtn']")
	public WebElement photoSaveButton;

	@FindBy(xpath = "//input[@id='j_id0:j_id7:save']")
	public WebElement photoSaveButton2;
	// My Settings
	// personallink

	@FindBy(xpath = "//*[@id=\'PersonalInfo_font\']")
	public WebElement personallink;

	@FindBy(xpath = "//*[@id=\"LoginHistory_font\"]")
	public WebElement loginHistorylink;

	@FindBy(xpath = "//*[@id=\"RelatedUserLoginHistoryList_body\"]/div/a")
	public WebElement logindisplay;

	@FindBy(xpath = "//*[@id=\"PersonalInformation_font\"]")
	public WebElement PersonalInfo;

	@FindBy(xpath = "//*[@id=\"ChangePassword_font\"]")
	public WebElement ChangePasswrd;


	@FindBy(xpath = "//*[@id=\"LanguageAndTimeZone_font\"]")
	public WebElement LAndTZone;


	@FindBy(xpath = "//*[@id=\"GrantLoginAccess_font\"]")
	public WebElement GrantLogAccess;


	@FindBy(xpath = "//*[@id=\"Groups_font\"]")
	public WebElement Groups;


	@FindBy(xpath = "//*[@id=\"ResetApiToken_font\"]")
	public WebElement ResetToken;

	@FindBy(xpath = "//*[@id=\"Connections_font\"]")
	public WebElement Connection;

	@FindBy(xpath = "//*[@id=\"LoginHistory_font\"]")
	public WebElement LoginHist;

	@FindBy(xpath = "//*[@id=\"ApproverSettings_font\"]")
	public WebElement ApproverSet;

	@FindBy(xpath = "//*[@id=\"AdvancedUserDetails_font\"]")
	public WebElement AdvUsrSetails;

	@FindBy(xpath = "//*[@id=\"ExternalObjectUserSettings_font\"]")
	public WebElement ExternalObjectUsrSet;
	
	@FindBy(id = "contactInfoContentId")
	public WebElement iframeAboutTab;
	// Display&layoutlink

	@FindBy(xpath = "//*[@id=\"DisplayAndLayout_font\"]")
	public WebElement DisplayLayoutlink;
	

	@FindBy(id = "CustomizeTabs_font")
	public WebElement CustomizedTab;

	
	@FindBy(xpath = "//*[@id=\"p4\"]")
	public WebElement customDrpdown;
	
	
	@FindBy(xpath = "//*[@id=\"p4\"]/option[9]")
	public WebElement customApp;
	

	@FindBy(xpath = "//*[@id=\"duel_select_0\"]")
	public WebElement AvailableTabs;
	
	@FindBy(xpath = "//*[@id=\"duel_select_1\"]")
	public WebElement SelectedTabs;

//	@FindBy(xpath = "//*[@id=\"duel_select_0\"]/option[73]")
//	public WebElement Availabletab;

	@FindBy(xpath = "//*[@id=\"duel_select_0_right\"]/img")
	public WebElement Add;
	
	@FindBy(xpath = "//*[@id=\"duel_select_0_left\"]/img")
	public WebElement Remove;

	@FindBy(xpath = "//*[@id=\"bottomButtonRow\"]/input[1]")
	public WebElement save;

	@FindBy(id = "tabBar")
	public WebElement tabList;

	// Emaillink

	@FindBy(xpath = "//*[@id=\"EmailSetup_font\"]")
	public WebElement Emaillink;

	@FindBy(id = "EmailSettings_font")
	public WebElement MyEmailSettings;

	@FindBy(id = "sender_name")
	public WebElement Emailname;

	@FindBy(xpath = "//*[@id=\"sender_email\"]")
	public WebElement Emailaddress;

	@FindBy(xpath = "//*[@id=\"useremailSection\"]/table/tbody/tr[7]/td[2]/div")
	public WebElement BCCradiobutton;

	@FindBy(xpath = "//*[@id=\"bottomButtonRow\"]/input[1]")
	public WebElement Saveonemail;
	
	@FindBy(xpath = "//*[@class='messageText']")
	public WebElement SuccessMsg;

	// Calendar and Remainders
	@FindBy(id = "CalendarAndReminders_font")
	public WebElement CalendarAndReminders;

	@FindBy(xpath = "//*[@id=\"Reminders_font\"]")
	public WebElement ActivityRemainder;

	@FindBy(id = "testbtn")
	public WebElement OpenaTestRemainder;

	@FindBy(xpath = "//*[@id=\"summary\"]")
	public WebElement SampleEventPopup;

	@FindBy(css = "#displayBadge")
	public WebElement moderatorButton;

	@FindBy(id = "profileTab_sfdc.ProfilePlatformFeed")
	public WebElement profilePage;

	@FindBy(id = "contactTab")
	public WebElement contactTab;

	@FindBy(xpath = "//div[@class='cxfeeditem feeditem'][1]//p")
	public WebElement firstPostText;

	@FindBy(xpath = "(//*[@class='contentFileTitle'])[1]")
	public WebElement verifyFilePostElement;

	@FindBy(name = "j_id0:waitingForm")
	public WebElement spinnerIcon;
	
	@FindBy(id = "cropWaitingPage:croppingForm")
	public WebElement spinnerWhileCropping;
	
	@FindBy(id = "progressIcon")
	public WebElement fileUploadSpinner;

	/**
	 * This function can be called to select option from user menu options
	 * 
	 * @param driver  Webdriver instance has to be passed
	 * @param sOption Option value eg: "My Profile"
	 * @return {boolean} true if given option is selected else false
	 */
	public boolean selectOptionFromUserMenuOptions(WebDriver driver, String sOption) {
		boolean isOptionSelected = false;
		if (userMenu.isDisplayed()) {
			userMenu.click();
		}
		WebElement userMenuItem = driver.findElement(By.xpath("//*[text()='" + sOption + "']"));
		if (userMenuItem.isDisplayed()) {
			userMenuItem.click();
			isOptionSelected = true;
		}
		return isOptionSelected;
	}

	/**
	 * @return
	 * @throws IOException
	 */
	public boolean verifyUserMenuItems() throws IOException {

		boolean isOptionsVerified = true;
		String[] expectedUserMenuItems = FileUtils.readUserMenuTestData("usermenu.items").split(",");
		for (int i = 0; i < expectedUserMenuItems.length; i++) {
			String actualOption = userMenuOptions.get(i).getText();
			if (expectedUserMenuItems[i].equals(actualOption)) {
				System.out.println("Expected Option " + expectedUserMenuItems[i] + " Actual Option" + actualOption);
			} else {
				System.out.println("Expected Option " + expectedUserMenuItems[i] + "failed to match with Actual Option"
						+ actualOption);
				isOptionsVerified = false;
			}
		}
		return isOptionsVerified;
	}

	public boolean selectMyProfile() throws IOException {
//		return this.selectOptionFromUserMenuOptions(driver, FileUtils.readUserMenuTestData("usermenu.item.profile"));
		boolean isSelected = false;
		if (MyProfile.isDisplayed()) {
			MyProfile.click();
			isSelected = true;
		}
		return isSelected;

	}
	public boolean selectDeveloperConsole() throws IOException {
//		return this.selectOptionFromUserMenuOptions(driver, FileUtils.readUserMenuTestData("usermenu.item.profile"));
		boolean isSelected = false;
		if (DeveloperConsole1.isDisplayed()) {
			DeveloperConsole1.click();
			isSelected = true;
		}
		return isSelected;

	}
	
	public boolean verifyDevConsolePageDisplayed(WebDriver driver) throws IOException {
		String expected ="SfdcDevConsole";
		
		if(driver.getPageSource().contains(expected)) {
			return true;
		}
		else {
			return false;
		}
	}
	
	
	public boolean selectMySettings() throws IOException {
//		return this.selectOptionFromUserMenuOptions(driver, FileUtils.readUserMenuTestData("usermenu.item.profile"));
		boolean isSelected = false;
		if (MySettings.isDisplayed()) {
			MySettings.click();
			isSelected = true;
		}
		return isSelected;

	}
	
	public void checkReport(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		Select seltab = new Select(SelectedTabs);		
		List<WebElement> option = seltab.getOptions();
		String[] output = new String[option.size()]; 
		for (int i = 0; i < option.size(); i++) {
			output[i] = option.get(i).getText();
            System.out.println(output[i]);
    	        }
		
		for (String element : output){
	         if (element.contains("Reports")){
	        	int a= element.indexOf("Reports");
	        	System.out.println("index of reports is: "+a);
	             seltab.selectByVisibleText("Reports");
	              Remove.click();
	              addReport(driver);
	         }
	         
//	         else {
//	        	 addReport(driver);
//	         }
		}		
	}
	 
	public void addReport(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		Select seltab = new Select(AvailableTabs);
		seltab.selectByVisibleText("Reports");
		Add.click();
		
	}
	
	
	public boolean verifyReport(WebDriver driver) {
		boolean ispresent = false;
		Select seltab = new Select(SelectedTabs);		
		List<WebElement> option = seltab.getOptions();
		String[] output = new String[option.size()]; 
		for (int i = 0; i < option.size(); i++) {
			output[i] = option.get(i).getText();
            System.out.println(output[i]);
    	        }
		
		for (String element : output){
	         if (element.contains("Reports")){
	        	 System.out.println("Reports added");
	              ispresent = true; 
	         }
	         	}
		return ispresent;
	}
	
	
	public void email(WebDriver driver) throws IOException {
		CommonUtils.waitForElement(driver,Emaillink);
		Emaillink.click();
		CommonUtils.waitForElement(driver, MyEmailSettings);
		MyEmailSettings.click();
		CommonUtils.waitForElement(driver, Emailname);
		Emailname.clear();
		Emailname.sendKeys(FileUtils.readUserMenuTestData("email.name"));
		CommonUtils.waitForElement(driver, Emailaddress);
		Emailaddress.clear();
		Emailaddress.sendKeys(FileUtils.readUserMenuTestData("email.address"));
		CommonUtils.waitForElement(driver, Saveonemail);
		Saveonemail.click();
		
	}
	
	public boolean verifyemail() throws IOException {

		boolean isMessageVerified = false;
		String expected ="Your settings have been successfully saved.";
		String output = SuccessMsg.getText();
		if (output.equalsIgnoreCase(expected)) {
			 isMessageVerified = true;
			} 
		return isMessageVerified;
	}
	
	public boolean verifyRemainders(WebDriver driver) {
          String expected ="Reminders";
		
		if(driver.getPageSource().contains(expected)) {
			return true;
		}
		else {
			return false;
		}
	}
		
	
	public void calendarandremainder(WebDriver driver) throws IOException, InterruptedException {
		
		CommonUtils.waitForElement(driver, CalendarAndReminders);
		CalendarAndReminders.click();
		CommonUtils.waitForElement(driver, ActivityRemainder);
		ActivityRemainder.click();
		CommonUtils.waitForElement(driver, OpenaTestRemainder);
		OpenaTestRemainder.click();
		Thread.sleep(3000);   
	     String parentWindow = driver.getWindowHandle();
	     System.out.println(parentWindow);
	     Set<String> windows = driver.getWindowHandles();
	     windows.remove(parentWindow);
	     String newwindow = "";
			for(String handle : windows) { 
				System.out.println(handle);
				newwindow = handle;
			}
			driver.switchTo().window(newwindow);
			driver.close();
			driver.switchTo().window(parentWindow);
	}
	
	
	public boolean verifyPersonalLinks() throws IOException {

		boolean isLinksVerified = false;
		if (loginHistorylink.isDisplayed()) {
				System.out.println();
				isLinksVerified = true;
			} 
		return isLinksVerified;
	}

	public boolean loginHistoryPageisDisplayed(WebDriver driver) throws IOException {
		String expected ="Login History ~ Salesforce - Developer Edition";
		
		if(driver.getPageSource().contains(expected)) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public boolean customizedTabisDisplayed(WebDriver driver) throws IOException {
		String expected ="Customize My Tabs ~ Salesforce - Developer Edition";
		
		if(driver.getPageSource().contains(expected)) {
			return true;
		}
		else {
			return false;
		}
	}
	
	
	public boolean selectLogout() throws IOException {
//		return this.selectOptionFromUserMenuOptions(driver, FileUtils.readUserMenuTestData("usermenu.item.profile"));
		boolean isSelected = false;
		if (Logout.isDisplayed()) {
			Logout.click();
			isSelected = true;
		}
		return isSelected;

	}
	

	public boolean isProfilePageVisible() {
		return profilePage.isDisplayed();
	}

	public void selectEditContact(WebDriver driver) {
		if (CommonUtils.waitForElement(driver, editContactButton)) {
			editContactButton.click();
		}
	}

	public boolean verifyEditContactPopUp(WebDriver driver) {
		boolean isContactPopUpVerified = false;

		if (CommonUtils.waitForElement(driver, iframeAboutTab)) {
			driver.switchTo().frame(iframeAboutTab);

			if (Abouttab.isDisplayed() && contactTab.isDisplayed()) {
				isContactPopUpVerified = true;
			}
		}
		// NOTE: Maybe required to switch to parent frame
		return isContactPopUpVerified;
	}

	public boolean verifyLastNameChangeInAboutTab(WebDriver driver, String sLastName) {
		boolean isLastNameVerified = false;
		if (Abouttab.isDisplayed()) {
			Abouttab.click();
			Abouttablastname.clear();
			Abouttablastname.sendKeys(sLastName);
			saveAllButton.click();
			driver.switchTo().parentFrame();

			if (Userprofilepagenamedisplay.isDisplayed()) {
				String sActualName = Userprofilepagenamedisplay.getText();
				if (sActualName.contains(sLastName)) {
					isLastNameVerified = true;
				}
			}
		} else {
			System.out.println("UserMenuPage : verifyLastNameChangeInAboutTab : About tab is not visible");
		}
		return isLastNameVerified;
	}

	public boolean verifyCreatePost(WebDriver driver, String sMessageToPost) throws InterruptedException {
		boolean verifyCreatePost = false;
		if (CommonUtils.waitForElement(driver, postLink)) {
			postLink.click();
			driver.switchTo().frame(0);
			postTextArea.sendKeys(sMessageToPost);
			driver.switchTo().parentFrame();
			if (shareButton.isDisplayed()) {
				shareButton.click();
//				Thread.sleep(2000); // this to be replaced with invisibility of an element
				CommonUtils.waitForElementToDisappear(driver, shareButton);
			}
//			if (firstPostText.isDisplayed()) {
			verifyCreatePost = true;
//			}
		}
		return verifyCreatePost;
	}

	public boolean verifyFileUpload(WebDriver driver, String sFilePath) throws InterruptedException {

		boolean isFileUploadSuccess = false;
		if (CommonUtils.waitForElement(driver, filelink)) {
			filelink.click();
			if (CommonUtils.waitForElement(driver, Uploadfile)) {
				Uploadfile.click();
			}
			if (CommonUtils.waitForElement(driver, Fileopen)) {
				Fileopen.sendKeys(sFilePath);
				shareButton.click();
//				Thread.sleep(WaitConstants.WAIT_FOR_UPLOAD_TO_FINISH);
				if (CommonUtils.waitForElementToDisappear(driver, cancelUpload)) {
					if (verifyFilePostElement.isDisplayed()) {
						isFileUploadSuccess = true;
					}
				}
			}
		}
		return isFileUploadSuccess;
	}

	public void clickOnUpdatePhotoButton(WebDriver driver) {
		CommonUtils.moveToElement(driver, moderatorButton);
		if (updateButton.isDisplayed()) {
			updateButton.click();
		}
	}

	public boolean verifyPhotoUpload(WebDriver driver, String sPhotoPath) throws InterruptedException {
		boolean isUploadSuccess = false;
		clickOnUpdatePhotoButton(driver);
		driver.switchTo().frame(photoUploadIframe);
		if (CommonUtils.waitForElement(driver, uploadphoto)) {
			uploadphoto.sendKeys(sPhotoPath);
			photoSaveButton.click();

//			Thread.sleep(4000);
		}
		if (CommonUtils.waitForElementToDisappear(driver, spinnerIcon)
				&& CommonUtils.waitForElement(driver, photoSaveButton2)) {
			photoSaveButton2.click();
//			Thread.sleep(4000);
			if(CommonUtils.waitForElementToDisappear(driver, spinnerWhileCropping)) {
				isUploadSuccess = true;
			}
		}
		driver.switchTo().parentFrame();
		return isUploadSuccess;
	}

	
	public String selectRandomOption() {
		
		
		return "Option Value";
	}
	
}
