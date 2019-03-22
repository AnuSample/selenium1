package seleniumday1;

import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;



public class Entry {
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
	

		InitializeDriver();
		Launch("https://login.salesforce.com");

		WebElement un = driver.findElement(By.id("username"));
		//enterText(By.xpath("//input[@id='username']"), "abc@gmail.com");
		//WebElement paswd = driver.findElement(By.id("password"));
	//	enterText(By.xpath("//input[@id='password']"), "pass123");

		// WebDriver driver=new ChromeDriver();
		// driver.get("https://login.salesforce.com/");

		WebElement Uname = driver.findElement(By.xpath("//input[@id='username']"));
		 Uname.sendKeys("abc@gmail.com");

	WebElement pswd = driver.findElement(By.xpath("//input[@id='password']"));
		pswd.sendKeys("malal");

		WebElement login = driver.findElement(By.xpath("//input[@id='Login']"));
		login.click();

		Thread.sleep(2000);
		driver.quit();

	}

	private static WebElement findElement(By location) {
		// TODO Auto-generated method stub
		WebElement obj= null;
		try {
			obj = driver.findElement(location);
			System.out.println("Pass : " +obj + "foung on the page ");
		} catch (NoSuchElementException errMessage) {
			System.out.println("Fail : " + obj + "could not found on the page ");
		}
		
		return obj;
	}

	public static void InitializeDriver() {
		System.setProperty("webdriver.chrome.driver", "/Users/PraveenPillai/Downloads/chromedriver");
		driver = new ChromeDriver();
		// driver.get("https://login.salesforce.com/");
	}

	public static void Launch(String url) {
		// open chrome url
		driver.get(url);

	}

	public static void selectCheckBox(WebElement obj, String objName) {
if(obj==null)
	return;
if(obj.isDisplayed())
{
	if(!obj.isSelected())
	{
		obj.click();
	}
	System.out.println("Pass : checkbox "+objName +" is selected ");
} 
else
{
	System.out.println("Fail : checkbox "+objName +"  couldnot be found ");
	
	
}
	}

	/*
	 * Name : enterText Description : Enter the text value into the textObject on
	 * the page
	 * 
	 * Arguments : object name-Name of the object text value- value to be entered
	 * 
	 * Created by : Anu Creation date : 14-feb-2019 Last modified date : 14-feb-2019
	 * 
	 */
	public static void enterText(By location, String objname, String textValue) {
		WebElement obj;
		try {
			obj = driver.findElement(location);
			System.out.println("Pass : " + objname + "foung on the page ");
			} catch (NoSuchElementException errMessage) {
			System.out.println("Fail : " + objname + "could not found on the page ");
			return;
		}
		if (obj.isDisplayed()) {
			obj.sendKeys(textValue);
			System.out.println("Pass : " + textValue + "entered in " + objname);
		} else {
			System.out.println("Fail : " + objname + "could not found");
		}
	}
}

