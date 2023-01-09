package Com.Guru99.Utilities;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import Com.Guru99.BaseClass.BaseClass;

public class ITestListners extends BaseClass implements ITestListener {

	ExtentTest test;
	
	ExtentReports extent = ExtentReporterNG.getReportObject();
	
	ThreadLocal<ExtentTest> extentTest =new ThreadLocal<ExtentTest>();
	
	public void onTestStart(ITestResult result) {
		//Extent Report 
		test=extent.createTest(result.getMethod().getMethodName());
		extentTest.set(test);	
	}

	public void onTestSuccess(ITestResult result) {
		
		extentTest.get().log(Status.PASS, "Test Passed");
	}

	public void onTestFailure(ITestResult result) {
		
		extentTest.get().fail(result.getThrowable());
				
		String testmethodname=result.getMethod().getMethodName();
		
		try {
			driver= (WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
		} catch (Exception e) {
			e.printStackTrace();	
		}
		
		try {
			
			getScreenshotAs(result.getTestContext().getName()+"_"+result.getMethod().getMethodName()+".jpg");
		} catch (IOException e) {
			e.printStackTrace();
		}	
	}
	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		
	}
	public void onFinish(ITestContext context) {
		extent.flush();
	}

	public void onTestSkipped(ITestResult result) {
			
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}

	public void onStart(ITestContext context) {
		
	}
}