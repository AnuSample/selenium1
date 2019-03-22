package seleniumday1;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.LogStatus;

/*
 * Name : First  test cases using extent reports and access from the excel sheet
 * Description : url-salesforce page
 * 
 * Arguments : path1- path setup for the extent reports
 *          
 * 
 * Created by : Anu Creation date : 19-feb-2019
 *  Last modified date :26-feb-2019
 * 
 */
public class TestCase3  extends Test1{
	
	public static void main(String args[]) throws  IOException, InterruptedException {
		TestCase3 test3 = new TestCase3();
		test3.invokeTestCase1();
	/*	test3.invokeTestCase2();
		test3.invokeTestCase3();
		test3.invokeTestCase4();
		test3.invokeTestCase5();
		test3.invokeTestCase1();
	    test3.invokeTestCase7();
		test3.invokeTestCase8();
		test3.invokeTestCase9();
		test3.invokeTestCase10();  */
		
		String path1 = "/Users/PraveenPillai/Desktop/TestcaseReports/sheet1.html";
		report = new ExtentReports(path1);
		
		String dt_path = "/Users/PraveenPillai/Desktop/testcases.xls";
		String[][] recData = readExceldata(dt_path, "Sheet2");

		for (int i = 0; i < recData.length; i++) {
			for (int j = 0; j < recData[0].length; j++) {

				System.out.print(recData[i][j] + "  ");
			}
			System.out.println();
		}
	}

	public static String[][] readExceldata(String dataTablepath, String sheetName) throws IOException {
		/* Step1: Get the xl path */
		File xlfile = new File(dataTablepath);

		// Step 2: Access the xl file
		FileInputStream xlDoc = new FileInputStream(xlfile);

		// Step 3: Access the workbook;
		HSSFWorkbook wb = new HSSFWorkbook(xlDoc);

		// Step 4: Access the excel sheet
		HSSFSheet sheet = wb.getSheet(sheetName);

		String val;
		int iRowCount = sheet.getLastRowNum() + 1;
		int iColCount = sheet.getRow(0).getLastCellNum();
		String[][] xlData = new String[iRowCount][iColCount];

		// String val=sheet.getRow(3).getCell(1).getStringCellValue();
		// System.out.println(val);

		for (int i = 0; i < iRowCount; i++) {
			for (int j = 0; j < iColCount; j++) {
				xlData[i][j] = sheet.getRow(i).getCell(j).getStringCellValue();	
			}
		}
		return xlData;
	}



	private void invokeTestCase1() throws InterruptedException {
		//String path1 = "/Users/PraveenPillai/Desktop/TestcaseReports/sheet1.html";
		//report = new ExtentReports(path1);
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
	

}
