package com.sdet32l1.genericcentre;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListenerImplementation implements ITestListener{
	ExtentReports report;
	ExtentTest test;
	
	@Override
	 public void onStart(ITestContext context)
	 {
		 System.out.println("Onstart");
		 ExtentSparkReporter spark=new ExtentSparkReporter("./extentreport/extentreport.html");
		 spark.config().setDocumentTitle("DocumentTitle");
		 spark.config().setTheme(Theme.DARK);
		 spark.config().setReportName("ReportName");
		 report=new ExtentReports();
		 report.attachReporter(spark);
		 report.setSystemInfo("Environment","Testing Environment");
		 report.setSystemInfo("ReporterName","ALFIYA JABBAR");
		 report.setSystemInfo("Platform","Windows7");
		 report.setSystemInfo("UnitTestingTool","TestNG");
		 report.setSystemInfo("BuildManagementTool","Maven");
		 report.setSystemInfo("AutomationTool","Selenium");
     }
	 @Override
	 public void onTestStart(ITestResult result)
	 {
		 System.out.println("OnTestStart");
		 test=report.createTest(result.getMethod().getMethodName());
     }
	 
	 @Override
	  public void onTestSuccess(ITestResult result)
	  {
		 System.out.println("onTestSuccess ");
		 test.log(Status.PASS,result.getMethod().getMethodName()+"is pass");
	  }
	 
	 
	 public void onTestFailure(ITestResult result) {
		 System.out.println("onTestFailure ");
		 test.log(Status.FAIL,result.getMethod().getMethodName()+"is failed");
		 test.log(Status.FAIL,result.getThrowable());
		// JavaCentre javacentre=new JavaCentre();
		 try {
			test.addScreenCaptureFromPath(WebDriverCentre.takeScreeShot(result.getMethod().getMethodName(),Baseclass.staticDriver));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		 
	 }
	 
	 public void onTestSkipped(ITestResult result) {
		 System.out.println("onTestSkipped ");
		 test.log(Status.SKIP,result.getMethod().getMethodName()+"is skipped");
		 test.log(Status.SKIP,result.getThrowable());
		 
	 }
	 
	 public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// System.out.println("onTestFailedButWithinSuccessPercentage ");
		 
	 }
	
	 public void onFinish(ITestContext context) {
		 System.out.println("onFinish ");
		 report.flush();
		 
	 }

}
