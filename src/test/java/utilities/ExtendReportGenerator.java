package utilities;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtendReportGenerator implements ITestListener{
	
public ExtentSparkReporter reporter;
public ExtentReports extent;
public ExtentTest test;


public  void onStart(ITestContext context) {
	
	reporter=new ExtentSparkReporter(".//reports/extentreports.html");
	reporter.config().setReportName("Automation report for Herokuapp");
	reporter.config().setDocumentTitle("Test Results");
	extent = new ExtentReports();
	extent.attachReporter(reporter);
	 
      }


	  
	  public  void onTestSuccess(ITestResult result) {
		  test=extent.createTest(result.getClass().getName());
		  test.log(Status.PASS,"Test passed");
	  }

	  
	  public  void onTestFailure(ITestResult result) {
		  test=extent.createTest(result.getClass().getName());
	    test.log(Status.FAIL, "Test failed");
	  }

	  
	  public void onTestSkipped(ITestResult result) {
		  test =extent.createTest(result.getClass().getName());
		  test.log(Status.SKIP, "Test skipped");
	    
	  }


	  
	  public void onFinish(ITestContext context) {
	    extent.flush();
	  }
	}


