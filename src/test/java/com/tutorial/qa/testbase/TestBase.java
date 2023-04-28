package com.tutorial.qa.testbase;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.tutorial.qa.utils.Utilities;

public class TestBase {
	public WebDriver driver;
	public Properties prop;
	public Properties dataprop;
	public FileInputStream ip;
	
	public TestBase() throws Exception {
		prop=new Properties();
		ip=new FileInputStream (System.getProperty("user.dir") + "\\src\\main\\java\\com\\tutorial\\qa\\config\\config.properties");
		prop.load(ip);
		dataprop=new Properties();
		ip=new FileInputStream (System.getProperty("user.dir") + "\\src\\test\\java\\com\\tutorial\\qa\\TestData\\testData.properties");
		dataprop.load(ip);
	}
	
	public WebDriver initializeBrowserAndOpenApplication(String browserName) {
		if (browserName.equalsIgnoreCase("chrome")) {
			driver=new ChromeDriver();
		} else if (browserName.equalsIgnoreCase("firefox")) {
			driver= new FirefoxDriver();
		}else if (browserName.equalsIgnoreCase("edge")) {
			driver= new EdgeDriver();
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Utilities.implitiWaitTime));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Utilities.pageLoadTime));
		driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(Utilities.scriptTimeOut));
		driver.get(prop.getProperty("url"));
		return driver;
	}
	

}
