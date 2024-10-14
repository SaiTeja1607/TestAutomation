package TestGroup.TestComponents;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import TestGroup.TestResources.ExtentReporterResource;


public class Listeners extends BaseTest implements ITestListener{
	
	ExtentReporterResource res = new ExtentReporterResource();
	
	ExtentReports extent;
	ExtentTest test;
	@Override
    public void onTestStart(ITestResult result) {
	 extent= res.extentReporterObject();
	 	test = extent.createTest(result.getMethod().getMethodName());
	
	}
    

    @Override
    public void onTestSuccess(ITestResult result) {
        test.log(Status.PASS, "Test Passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {
    	test.fail(result.getThrowable());
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
       
    }

    @Override
    public void onStart(ITestContext context) {
        
    }

    @Override
    public void onFinish(ITestContext context) {
     extent.flush();
    }

}
