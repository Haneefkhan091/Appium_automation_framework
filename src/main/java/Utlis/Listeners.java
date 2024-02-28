package Utlis;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import RunFirstScript.Extentreport;
import Utlis.BaseTest;
import io.appium.java_client.AppiumDriver;

public class Listeners extends BaseTest implements ITestListener {
	AppiumDriver driver;
	ExtentTest test;
	ExtentReports extent = Extentreport.extentreport();
    @Override 
    public void onTestStart(ITestResult result) {
        System.out.println("Test started: " + result.getName());
        
         test = extent.createTest(result.getMethod().getMethodName()); 
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("Test passed: " + result.getName());
        
        test.log(Status.PASS, "Test is passed");
        
    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("Test failed: " + result.getName());
        
        test.fail(result.getName());
        
        
        
     // TODO Auto-generated method stub
     		//screenshot code
     		test.fail(result.getThrowable());
     		
     		try {
     			driver = (AppiumDriver) result.getTestClass().getRealClass().getField("driver")
     					.get(result.getInstance());
     			
     			
     		} catch (Exception e1) {
     			// TODO Auto-generated catch block
     			e1.printStackTrace();
     		} 
     		try {
     			test.addScreenCaptureFromPath(getScreenshotPath(result.getMethod().getMethodName(),driver), result.getMethod().getMethodName());
     		} catch (IOException e) {
     			// TODO Auto-generated catch block
     			e.printStackTrace();
     		}
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println("Test skipped: " + result.getName());
    }

    @Override
    public void onFinish(ITestContext context) {
        System.out.println("All tests in the suite have finished.");
        
        extent.flush();
        // Additional actions or logging can be performed here
    }
    // Other methods can be implemented as needed

}
