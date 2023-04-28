package com.tutorial.qa.listeners;

import java.io.File;
import java.io.IOException;
import java.util.logging.FileHandler;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.tutorial.qa.utils.MyExtentReporter;

public class myListeners implements ITestListener {
public ExtentReports extentreport;
public ExtentTest extentest;

	@Override
	public void onStart(ITestContext context) {
		
		try {
			extentreport=(ExtentReports) MyExtentReporter.generateExtentReport();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(" Execution of Tutorial Ninja Project Started");
	}
	
	
	@Override
	public void onTestStart(ITestResult result) {
	
		String testname=result.getName();
		extentest=extentreport.createTest(testname);
		extentest.log(Status.INFO, testname+"started executing");
		//System.out.println(testname+"started executing");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		String testname=result.getName();
		extentest=extentreport.createTest(testname);
		extentest.log(Status.PASS, testname+"succefully executing");
		//System.out.println(testname+" succefully executed");
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		String testname=result.getName();
		WebDriver driver=null;
		try {
			driver=(WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
		} catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		File source=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String destination=System.getProperty("user.dir") + "\\test-output\\screenshots\\" + testname + ".png";
		try {
			org.openqa.selenium.io.FileHandler.copy(source,new File(destination));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		extentest.addScreenCaptureFromPath(destination);
		extentest.log(Status.INFO, result.getThrowable());
		extentest.log(Status.FAIL, testname+" failed");
		//System.out.println(testname+" failed");
		//System.out.println(result.getThrowable());
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		String testname=result.getName();
		extentest.log(Status.INFO, result.getThrowable());
		extentest.log(Status.SKIP, testname+" got skipped");
		//System.out.println(testname+" got skipped");
		//System.out.println(result.getThrowable());
	}



	@Override
	public void onFinish(ITestContext context) {
	System.out.println("Excecution of Tutorial Ninja finished");
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		String testname=result.getName();
		System.out.println(testname+" got skipped");
		System.out.println(result.getThrowable());
	}



}
