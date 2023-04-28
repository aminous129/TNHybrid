package com.tutorial.qa.utils;

import java.io.File;
import java.io.FileInputStream;
//import java.io.FileNotFoundException;
import java.util.Properties;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

//import cucumber.deps.com.thoughtworks.xstream.persistence.FileStreamStrategy;

public class MyExtentReporter {

	
	public static ExtentReports generateExtentReport() throws Exception {
		//Step 1 Create Object of extentReport
		
		ExtentReports extentreport= new ExtentReports();
		//Step 2 Create folder in test output 
		File extentReportFile= new File(System.getProperty("user.dir")+"\\test-output\\ExtentReports\\extentreports.html");
		//Step 3Create object of ExtentSparkReporter
		ExtentSparkReporter sparkreporter=new ExtentSparkReporter(extentReportFile); 	//ExtentSparkReporter help us set configurations
		
		sparkreporter.config().setTheme(Theme.DARK);
		sparkreporter.config().setReportName("Tutorial Ninja Test Result");
		sparkreporter.config().setDocumentTitle("TutorialNinjaAutomationTest");
		sparkreporter.config().setTimeStampFormat("dd/MM/yyyy hh:mm:ss");
		
		extentreport.attachReporter(sparkreporter);
		
		Properties configprop= new Properties();
		FileInputStream ip = new FileInputStream(System.getProperty("user.dir")+ "\\src\\main\\java\\com\\tutorial\\qa\\config\\config.properties");
		
		configprop.load(ip);
		extentreport.setSystemInfo("Application url", configprop.getProperty("url"));
		extentreport.setSystemInfo("Browser Name", configprop.getProperty("browserName"));
		extentreport.setSystemInfo("User Name", configprop.getProperty("validUsername"));
		extentreport.setSystemInfo("Password", configprop.getProperty("validPassword"));
		
		extentreport.setSystemInfo("Operating System", System.getProperty("os.version"));
		extentreport.setSystemInfo("User Name", System.getProperty("user.name"));
		extentreport.setSystemInfo("Java Version", System.getProperty("java.version"));
		
		return extentreport;
		
	}
}
