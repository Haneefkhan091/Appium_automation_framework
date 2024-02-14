package RunFirstScript;

import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Extentreport {
	
	static ExtentReports extent;
	@BeforeTest
	public static ExtentReports extentreport() {
		// TODO Auto-generated method stub

		String path = "C:\\Users\\Haneef-ullah\\eclipse-workspace\\Appium_project\\Report";
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		reporter.config().setReportName("Appium test framework");
		reporter.config().setDocumentTitle("Test results");
		extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Written by", "Haneef");
		return extent; 
		
	}   
	

}
