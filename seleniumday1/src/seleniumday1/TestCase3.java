package seleniumday1;


import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
/*
 * url passed : https://selenium-prd.firebaseapp.com
 * Brief Description : Playing with the objects with selenium WebDriver
 * Created By : Automation team 
 *  Creation Date : 03/12/2019
 *  last modified :
 */


public class TestCase3 {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "/Users/PraveenPillai/Downloads/chromedriver");
		WebDriver driver = new ChromeDriver();
		WebDriverWait wait = new WebDriverWait(driver, 40);
		driver.get("https://selenium-prd.firebaseapp.com/home.html");
		System.out.println("Application launched successfully");
		Thread.sleep(2000);
		WebElement emailUname = driver.findElement(By.id("email_field"));
		emailUname.clear();
		emailUname.sendKeys("admin123@gmail.com");
		WebElement pwd = driver.findElement(By.id("password_field"));
		pwd.clear();
		pwd.sendKeys("admin123");
		WebElement login = driver.findElement(By.xpath("//button[@onclick='login()']"));
		login.click();
		Thread.sleep(2000);
		// Enter name
		WebElement name = driver.findElement(By.id("name"));
		name.clear();
		name.sendKeys("nandu");
		// Enter fathers name
		WebElement fatherName = driver.findElement(By.id("lname"));
		fatherName.clear();
		fatherName.sendKeys("pillai");
		// Enter postal address
		Thread.sleep(2000);
		WebElement postAdd = driver.findElement(By.id("postaladdress"));
		postAdd.clear();
		postAdd.sendKeys("576007");
		// Enter personal address
		WebElement perAdd = driver.findElement(By.id("personaladdress"));
		perAdd.clear();
		perAdd.sendKeys("bangalore");
		Thread.sleep(2000);
		// Radio button
		WebElement genderButton = driver
				.findElement(By.xpath("/html[1]/body[1]/div[2]/div[2]/form[1]/div[5]/span[1]/input[1]"));
		genderButton.click();
		Thread.sleep(2000);
		// Enter city
		Select city = new Select(driver.findElement(By.name("city")));
		city.selectByIndex(1);

		// Enter course
		Select course = new Select(driver.findElement(By.xpath("//select[@id='course']")));
		course.selectByVisibleText("MBA");
		Thread.sleep(2000);
		// Enter district
		Select dist = new Select(driver.findElement(By.xpath("//select[@id='district']")));
		dist.selectByVisibleText("GOA");
		// Enter State
		Select state = new Select(driver.findElement(By.name("state")));
		course.selectByVisibleText("PATNA");
		// Enter pincode
		WebElement pinCode = driver.findElement(By.id("pincode"));
		pinCode.clear();
		pinCode.sendKeys("567007");
		// Enter email
		WebElement emailname = driver.findElement(By.id("emailid"));
		emailname.clear();
		emailname.sendKeys("abc@gmail.com");
		Thread.sleep(2000);
		// Enter Submit button
		WebElement submit = driver.findElement(By.xpath("//button[@class='bootbutton']"));
		submit.click();
		Thread.sleep(2000);
		// Switch to tab Actions
		WebElement switchTo = driver.findElement(By.xpath("//button[contains(text(),'Switch To')]  "));
		switchTo.click();
		// Click on the alert
		WebElement alert = driver.findElement(By.xpath("//a[contains(text(),'Alert')]"));
		alert.click();
		// click on window
		WebElement WindowAlert = driver.findElement(By.xpath("//button[contains(text(),'Window Alert')]"));
		WindowAlert.click();
		Thread.sleep(2000);
		Alert WinAlert = driver.switchTo().alert();
		String alertText = WinAlert.getText();
		System.out.println("Alert text is : " + alertText);
		WinAlert.accept();
		Thread.sleep(2000);
		// click on prompt alert
		WebElement promptAlert = driver.findElement(By.xpath("//button[contains(text(),'Promt Alert')]"));
		promptAlert.click();
		Thread.sleep(2000);
		Alert promtselect = driver.switchTo().alert();
		promtselect.sendKeys("praveen");
		Thread.sleep(2000);
		promtselect.accept();
	}

}

	