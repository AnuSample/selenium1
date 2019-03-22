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

/*
*************************************
*WebElement usermenu=driver.findElement(By.xpath("//*[@id='userNavButton']"));
 
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
}
**
*
*
*
*
********************************
*
*
*
/*WebElement inputBox = driver.findElement(By.id("inputBoxId"));

String textInsideInputBox = inputBox.getAttribute("value");
 

// Check whether input field is blank
 
if(textInsideInputBox.isEmpty())
 
{
 
 WebElement select = driver.findElement(By.id("airlineid"));
 
WebElement option = select.getFirstSelectedOption();
 
String selectedValueInDropDown = option.getText();

Boolean found = false;
 
List<WebElement> allOptions = select.getOptions();
 
for(int i=0; i<allOptions.size(); i++) {
 
if(alloptions[i].Equals("your_option_text")) {
 
found=true;
 
break;
 
}
 
}
 
if(found) {
 
System.out.println("Value exists");
 
}

System.out.println("Input field is empty");
//For File

WebElement file=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='publisherAttachContentPost']/span[1]")));

file.click();

System.out.println("clicked on file");

WebElement upload=wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='chatterUploadFileAction']")));

upload.click();

Thread.sleep(8000);

System.out.println("clicked on upload");

WebElement browse=wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='chatterFile']")));

browse.sendKeys("F:\\TEKARCH\\BATCH\\9-JUlY 2018\\workspace\\Selenium\\Steps to register on Tekarch Portal for video access.docx");

WebElement share=wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='publishersharebutton']")));

share.click();


}

String[] b=new String[3];

int i=0;


WebElement developerConsole=driver.findElement(By.xpath(".//*[@id='userNav-menuItems']/a[3]"));

developerConsole.click();


for(String window:driver.getWindowHandles()){

b[i]=window.toString();

i++;


Thread.sleep(3000);

driver.switchTo().window(b[0]);

driver.close();

driver.switchTo().window(b[1]);
}

*
***************************
WebElement post=driver.findElement(By.xpath(".//*[@id='publisherAttachTextPost']/span[1]"));

post.click();
 
System.out.println("Clicked on post");
 
WebElement frame=driver.findElement(By.tagName("iframe"));
driver.switchTo().frame(frame);
 
System.out.println("Switched to frame"+ frame);
 
WebElement messagebox=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body")));
 
messagebox.click();
 
System.out.println("Msg box clicked");
 
Thread.sleep(2000);
 
WebElement messagebox1=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body")));
 
System.out.println("Sending msg to post");
 
messagebox1.sendKeys("just posted2 now");
 
Thread.sleep(2000);
 
driver.switchTo().defaultContent();
 
System.out.println("back to default frame");
 
WebElement shareButtton=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='publishersharebutton']")));
 
shareButtton.click();
 
System.out.println("Share clicked");


**********/