package seleniumday1;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Test1 {
	static ExtentReports report;
	static ExtentTest logger;
	static WebDriver driver;
	static String path = "/Users/PraveenPillai/Desktop/TestcaseReports/user.html";

	public static void main(String[] args) throws InterruptedException, IOException {

		Test1 test = new Test1();
		
		test.initialize();
		test.launch("https://login.salesforce.com");

		WebElement uname = driver.findElement(By.id("username"));
		test.enterText(uname, "username", "anu@samplecompany.com");

		WebElement pwd = driver.findElement(By.id("password"));
		test.enterText(pwd, "password", "pillai123");

		WebElement login = driver.findElement(By.id("Login"));
		test.selectCheckBox(login, "Login");

		Thread.sleep(2000);

		report.endTest(logger);

		report.flush();
	}

	public  void initialize() {
		System.setProperty("webdriver.chrome.driver", "/Users/PraveenPillai/Downloads/chromedriver");
		//DesiredCapabilities cap = DesiredCapabilities.internetExplorer();
		 // cap.setCapability("ignoreProtectedModeSettings",true);
		  
		driver = new ChromeDriver();
		//report = new ExtentReports(path);
	}

	public  void launch(String url) {
		// open the url in chrome browser
		logger = report.startTest("Login to SDFC");
		driver.get(url);
		logger.log(LogStatus.INFO, "Launched salesforce page successfully");

	}

	public  void enterText(WebElement obj, String objName, String textValue) {
		if (obj.isDisplayed()) {
			obj.sendKeys(textValue);
			System.out.println("Pass :  " + textValue + "  entered in  " + objName);
			logger.log(LogStatus.PASS, " entered correctly :  ");
		} else {
			System.out.println("Fail :  " + objName + "  could not be found ");
			logger.log(LogStatus.FAIL, "Value could not be found  :  ");
		}

	}

	public  void selectCheckBox(WebElement obj, String objName) {
		if (obj == null)
			return;
		if (obj.isDisplayed()) {
			if (!obj.isSelected()) {
				obj.click();
			}
			System.out.println("Pass : checkbox " + objName + " is selected ");
			logger.log(LogStatus.PASS, " entered correctly :  ");
		} else {
			System.out.println("Fail : checkbox " + objName + "  couldnot be found ");
			logger.log(LogStatus.FAIL, " entered correctly :  ");

		}
	}
	
	public void flushReport() throws InterruptedException
	{
		Thread.sleep(2000);

		report.endTest(logger);

		report.flush();
		
		driver.close();
	}
}
