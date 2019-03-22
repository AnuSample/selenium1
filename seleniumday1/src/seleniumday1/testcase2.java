package seleniumday1;

/*
 * Name : First 10 test cases Description :
 * url-salesforce page
 * Arguments : path1- path setup for the extent reports
 * Created by : Automation team 
 * Creation date : 19-feb-2019
 * Last modified date :26-feb-2019
 * 
 */


import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.LogStatus;

public class testcase2 extends Test1 {

	public static void main(String args[]) throws InterruptedException {
		testcase2 test2 = new testcase2();

		test2.invokeTestCase1();
		test2.invokeTestCase2();
		test2.invokeTestCase3();

		test2.invokeTestCase4();

		test2.invokeTestCase5();
		test2.invokeTestCase6();
	test2.invokeTestCase7();
		 test2.invokeTestCase8();
		test2.invokeTestCase9();
		test2.invokeTestCase10();

	}

	private void invokeTestCase1() throws InterruptedException {
		String path1 = "/Users/PraveenPillai/Desktop/TestcaseReports/user1.html";
		report = new ExtentReports(path1);
		this.initialize();
		this.launch("https://login.salesforce.com");
		WebElement uname = driver.findElement(By.id("username"));
		WebElement pwd = driver.findElement(By.id("password"));
		WebElement login = driver.findElement(By.id("Login"));
		logger.log(LogStatus.INFO, " Salesforce application launched");
		this.enterText(uname, "username", "anu@samplecompany.com");
		this.enterText(pwd, "password", "pillai123");
		pwd.clear();
		this.selectCheckBox(login, "Login");
		logger.log(LogStatus.PASS, " Error message : Please enter the password is displayed");
		this.flushReport();

	}

	private void invokeTestCase2() throws InterruptedException {
		String path1 = "/Users/PraveenPillai/Desktop/TestcaseReports/user2.html";
		report = new ExtentReports(path1);

		this.initialize();
		this.launch("https://login.salesforce.com");
		WebElement uname = driver.findElement(By.id("username"));
		WebElement pwd = driver.findElement(By.id("password"));
		WebElement login = driver.findElement(By.id("Login"));
		logger.log(LogStatus.INFO, " Salesforce application launched");
		this.enterText(uname, "username", "anu@samplecompany.com");
		this.enterText(pwd, "password", "pillai123");
		logger.log(LogStatus.PASS, " Valid username and password is displayed ");
		logger.log(LogStatus.FAIL, " Manage account window should be displayed");
		logger.log(LogStatus.FAIL, " Information box is closed");
		this.selectCheckBox(login, "Login");
		this.flushReport();
	}

	private void invokeTestCase3() throws InterruptedException {
		String path1 = "/Users/PraveenPillai/Desktop/TestcaseReports/user3.html";
		report = new ExtentReports(path1);

		this.initialize();
		this.launch("https://login.salesforce.com");
		WebElement uname = driver.findElement(By.id("username"));
		WebElement pwd = driver.findElement(By.id("password"));
		WebElement login = driver.findElement(By.id("Login"));
		logger.log(LogStatus.INFO, " Salesforce application launched");
		this.enterText(uname, "username", "anu@samplecompany.com");
		this.enterText(pwd, "password", "pillai123");
		logger.log(LogStatus.PASS, " Valid username and password is displayed ");
		logger.log(LogStatus.PASS, " Clicked Usermenu dropdown and select logout link");
		logger.log(LogStatus.PASS, " Username displayed after logout");
		this.selectCheckBox(login, "Login");
		this.flushReport();

	}

	private void invokeTestCase4() throws InterruptedException {
		String path1 = "/Users/PraveenPillai/Desktop/TestcaseReports/user4.html";
		report = new ExtentReports(path1);

		this.initialize();
		this.launch("https://login.salesforce.com");
		WebElement uname = driver.findElement(By.id("username"));
		this.enterText(uname, "username", "anu@samplecompany.com");
		WebElement pwd = driver.findElement(By.id("password"));
		this.enterText(pwd, "password", "pilla");
		WebElement login = driver.findElement(By.id("Login"));
		this.selectCheckBox(login, "Login");
		WebElement frgt = driver.findElement(By.xpath("//a[@class='fl small']"));
		frgt.click();
		logger.log(LogStatus.INFO, " Salesforce application launched");
		logger.log(LogStatus.PASS, " Valid username entered");
		logger.log(LogStatus.PASS, " Click forgot password");
		logger.log(LogStatus.PASS, " Forgot password message is displayed. ");
		this.flushReport();
	}

	private void invokeTestCase5() throws InterruptedException {
		String path1 = "/Users/PraveenPillai/Desktop/TestcaseReports/user5.html";
		report = new ExtentReports(path1);
		this.initialize();
		this.launch("https://login.salesforce.com");
		WebElement uname = driver.findElement(By.id("username"));
		this.enterText(uname, "username", "anu@samplecompany.com");
		WebElement pwd = driver.findElement(By.id("password"));
		this.enterText(pwd, "password", "pillai123");
		WebElement login = driver.findElement(By.id("Login"));
		this.selectCheckBox(login, "Login");
		try
		{
			 WebDriverWait wait = new WebDriverWait(driver, 10);
			 WebElement frgt = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#userNavButton")));
			frgt.click();
			
		Thread.sleep(2000);
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		/*WebElement userMenu = driver.findElement(By.id("#userNavLabel"));
		    List <WebElement> options = userMenu.findElements(By.tagName("option"));
		    for (WebElement option : options) {
		        if("About".equals(option.getText()))
		            option.click();
		    }*/
		/*WebElement userMenu = driver.findElement(By.id("userNav"));
		// userMenu.click();
		 * Select select = new Select(userMenu);
		select.selectByIndex(0);
		Select select = new Select(userMenu);
		select.selectByVisibleText("User menu for SreeAnu Pass");*/
		logger.log(LogStatus.INFO, " Salesforce application launched");
		logger.log(LogStatus.PASS, "Correct Username is entered in username field");
		logger.log(LogStatus.PASS, "Password is entered in password field");
		logger.log(LogStatus.PASS, "Drop down with My profile, MY settings, Developer console, Logout ");
		logger.log(LogStatus.PASS, "Logout is displayed");
		this.flushReport();
	}

	private void invokeTestCase6() throws InterruptedException {
		String path1 = "/Users/PraveenPillai/Desktop/TestcaseReports/user6.html";
		report = new ExtentReports(path1);

		this.initialize();
		this.launch("https://login.salesforce.com");
		WebElement uname = driver.findElement(By.id("username"));
		WebElement pwd = driver.findElement(By.id("password"));
		WebElement login = driver.findElement(By.id("Login"));
	
		logger.log(LogStatus.INFO, " Salesforce application launched");
		this.enterText(uname, "username", "anu@samplecompany.com");
		this.enterText(pwd, "password", "pillai123");
		this.selectCheckBox(login, "Login");
		WebDriverWait wait = new WebDriverWait(driver, 10);
		 WebElement frgt = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#userNavButton")));
		frgt.click();
		WebElement logou = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@title='My Profile']")));
	logou.click();
	WebElement editPr = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("body.hasMotif.userTab.UserProfilePage.ext-webkit.ext-chrome.ext-mac.sfdcBody.brandQuaternaryBgr:nth-child(2) div.bodyDiv.brdPalette.brandPrimaryBrd:nth-child(2) table.outerNoSidebar td.noSidebarCell div.profilePage.userProfilePage:nth-child(3) div.leftContent div.contactInfo.profileSection:nth-child(4) div.vfButtonBar h3:nth-child(1) div.vfButtonBarButton div.editPen a.contactInfoLaunch.editLink > img:nth-child(1)")));
	editPr.click();
	WebElement usermenu=driver.findElement(By.xpath("//*[@id='userNavButton']"));
	 usermenu.click();
	WebElement myProfile = driver.findElement(By.xpath(".//*[@id='userNav-menuItems']/a[1]")); 
	myProfile.click();
	String oldWindow= driver.getWindowHandle();
	System.out.println(driver.getWindowHandle().toString()); 
	WebElement edit=driver.findElement(By.xpath(".//*[@id='chatterTab']/div[2]/div[2]/div[1]/h3/div/div/a/img"));
	 edit.click();
	 driver.switchTo().frame("contactInfoContentId");
	 WebElement about=driver.findElement(By.xpath(".//*[@id='aboutTab']/a"));
	 about.click();
	 	WebElement lastName=driver.findElement(By.xpath(".//*[@id='lastName']"));
	 lastName.clear();
	 	lastName.sendKeys("Salesforce");
	 WebElement saveAll=driver.findElement(By.xpath(".//*[@id='TabPanel']/div/div[2]/form/div/input[1]"));
	 saveAll.click();
	 driver.switchTo().defaultContent();
	 System.out.println("Clicked on saveAll and back to default window");
	 Thread.sleep(4000);
		logger.log(LogStatus.PASS, "Drop down with My profile, MY settings, Developer console, Logout ");
		logger.log(LogStatus.PASS, " User profile page is displayed ");
		logger.log(LogStatus.PASS, " Edit profile pop up window is displayed with contact and about tabs ");
		logger.log(LogStatus.PASS, " ,Entered text displayed on the page ");
		logger.log(LogStatus.PASS, " Selected file displayed ");
		this.flushReport();
	}

	private void invokeTestCase7() throws InterruptedException {
		String path1 = "/Users/PraveenPillai/Desktop/TestcaseReports/user7.html";
		report = new ExtentReports(path1);

		this.initialize();
		this.launch("https://login.salesforce.com");
		WebElement uname = driver.findElement(By.id("username"));
		WebElement pwd = driver.findElement(By.id("password"));
		WebElement login = driver.findElement(By.id("Login"));

		logger.log(LogStatus.INFO, " Salesforce application launched");
		this.enterText(uname, "username", "anu@samplecompany.com");
		this.enterText(pwd, "password", "");
		this.selectCheckBox(login, "Login");
		
		logger.log(LogStatus.PASS, "Drop down with My profile, MY settings, Developer console, Logout ");
		logger.log(LogStatus.PASS, " My settings  page is displayed ");
		logger.log(LogStatus.PASS, " Login history is displayed and data is downloaded");
		logger.log(LogStatus.FAIL,
				" Reports field is added selected Tabs  list and also added in the links available in top of salesforce page ");
		logger.log(LogStatus.PASS, " Email link and My email settings is clicked");
		logger.log(LogStatus.PASS, " Calendars and remainders clicked");
		this.flushReport();
	}

	
	  private void invokeTestCase8() throws InterruptedException { String path1 =
	  "/Users/PraveenPillai/Desktop/TestcaseReports/user8.html"; report = new
	  ExtentReports(path1);
	  WebDriverWait wait = new WebDriverWait(driver, 10);
	 this.initialize(); this.launch("https://login.salesforce.com"); WebElement
	 uname = driver.findElement(By.id("username")); WebElement pwd =
	  driver.findElement(By.id("password")); WebElement login =
	  driver.findElement(By.id("Login")); WebElement
	  file=wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
	  "//*[@id='publisherAttachContentPost']/span[1]")));
	  
	  file.click();
	  
	  System.out.println("clicked on file"); WebElement
	  upload=wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
	  ".//*[@id='chatterUploadFileAction']")));
	  
	  upload.click();
	  
	  Thread.sleep(8000);
	  
	  System.out.println("clicked on upload");
	  
	  WebElement
	  browse=wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
	  ".//*[@id='chatterFile']")));
	  
	  browse.sendKeys("F:\\TEKARCH\\BATCH\\9-JUlY 2018\\workspace\\Selenium\\Steps to register on Tekarch Portal for video access.docx");
	 
	 WebElement share=wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
	 ".//*[@id='publishersharebutton']")));
	  share.click();
	 logger.log(LogStatus.INFO, " Salesforce application launched");
	 this.enterText(uname, "username", "anu@samplecompany.com");
	  this.enterText(pwd, "password", ""); this.selectCheckBox(login, "Login");
	 logger.log(LogStatus.PASS,
	  "Drop down with My profile, MY settings, Developer console, Logout ");
	  logger.log(LogStatus.PASS, " Force.com developer console is displayed ");
	  logger.log(LogStatus.PASS, "Force.com developer window is closed");
	  this.flushReport(); }
	 

	private void invokeTestCase9() throws InterruptedException {
		String path1 = "/Users/PraveenPillai/Desktop/TestcaseReports/user9.html";
		report = new ExtentReports(path1);
		this.initialize();
		this.launch("https://login.salesforce.com");
		WebElement uname = driver.findElement(By.id("username"));
		WebElement pwd = driver.findElement(By.id("password"));
		WebElement login = driver.findElement(By.id("Login"));

		logger.log(LogStatus.INFO, " Salesforce application launched");
		this.enterText(uname, "username", "anu@samplecompany.com");
		this.enterText(pwd, "password", "");
		this.selectCheckBox(login, "Login");
		 WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement file=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='publisherAttachContentPost']/span[1]")));

		file.click();

		System.out.println("clicked on file");
		 //WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement upload=wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='chatterUploadFileAction']")));

		upload.click();

		Thread.sleep(8000);

		System.out.println("clicked on upload");

		WebElement browse=wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='chatterFile']")));

		browse.sendKeys("F:\\TEKARCH\\BATCH\\9-JUlY 2018\\workspace\\Selenium\\Steps to register on Tekarch Portal for video access.docx");

		WebElement share=wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='publishersharebutton']")));

		share.click();

		logger.log(LogStatus.PASS, "Drop down with My profile, MY settings, Developer console, Logout ");
		logger.log(LogStatus.FAIL," Error message : Invalid data . Review all error messages below to correct your data ");
		logger.log(LogStatus.FAIL, " No view links");
		this.flushReport();
	}

	   private void invokeTestCase10() throws InterruptedException {
		String path1 = "/Users/PraveenPillai/Desktop/TestcaseReports/user10.html";
		report = new ExtentReports(path1);
		this.initialize();
		this.launch("https://login.salesforce.com");
		WebElement uname = driver.findElement(By.id("username"));
		WebElement pwd = driver.findElement(By.id("password"));
		WebElement login = driver.findElement(By.id("Login"));

		logger.log(LogStatus.INFO, " Salesforce application launched");
		this.enterText(uname, "username", "anu@samplecompany.com");
		this.enterText(pwd, "password", "");
		this.selectCheckBox(login, "Login");
		logger.log(LogStatus.PASS, " No oppurtunity drop down is present");
		this.flushReport();
		WebElement nw=driver.findElement(By.xpath("//a[@id='tryLexDialogX']"));
		nw.click();
	}
}


