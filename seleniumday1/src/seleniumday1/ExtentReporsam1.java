package seleniumday1;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class ExtentReporsam1 {
	static ExtentReports report;
	static ExtentTest logger;
	
	public static void main(String[] args) {
		
		System.out.println("Start");
		
		//Initialize extent report
		String path="/Users/PraveenPillai/Desktop/report.html";
		
		report=new ExtentReports(path);
		
		//Initialize logger
		logger=report.startTest("Login to SDFC");
		
		logger.log(LogStatus.INFO,"Firefox Browser launched");
		logger.log(LogStatus.PASS, "Username Enter Successfully");
		logger.log(LogStatus.FAIL, "Password field does not exist");
		logger.log(LogStatus.PASS, "Clicked on remember Checkbox");
		logger.log(LogStatus.PASS, "Login Button clicked");
		
		report.endTest(logger);
		
		//Initialize logger
				logger=report.startTest("Remember Password on SFDC");
				logger.log(LogStatus.INFO,"Firefox Browser launched");
				logger.log(LogStatus.PASS, "Username Enter Successfully");
				logger.log(LogStatus.PASS, "Password Entered");
				logger.log(LogStatus.PASS, "Clicked on remember Checkbox");
				logger.log(LogStatus.PASS, "Login Button clicked");
				
		report.endTest(logger);
		
		report.flush();
		
		System.out.println("End");
	}
	

}
