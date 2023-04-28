package com.tutorial.qa.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.tutorial.qa.testbase.TestBase;

public class SearchProductTest extends TestBase{

	public SearchProductTest () throws Exception {
		super();
	}
	public WebDriver driver;
	public SoftAssert softassert= new SoftAssert();
	@BeforeMethod
	public void setUp() {
		driver=initializeBrowserAndOpenApplication("chrome");
	}

	@Test (priority = 1)
	public void SearchExistingProduct() {
		driver.findElement(By.name("search")).click();
		driver.findElement(By.name("search")).sendKeys(dataprop.getProperty("ExistingProduct"));
		driver.findElement(By.xpath("/html/body/header/div/div/div[2]/div/span/button")).click();
		
		softassert.assertTrue(driver.findElement(By.linkText("iMac")).isDisplayed());
		softassert.assertAll();
	}
	
	@Test (priority = 2)
	public void SearchNonExistingProduct() {
		
		driver.findElement(By.name("search")).click();
		driver.findElement(By.name("search")).sendKeys(dataprop.getProperty("UnexistingProduct"));
		driver.findElement(By.xpath("/html/body/header/div/div/div[2]/div/span/button")).click();
		
		String actualWarningMessage= driver.findElement(By.xpath("/html/body/div[2]/div/div/p[2]")).getText();
		String expectedWarningMessage=dataprop.getProperty("NoProductWarning");
		softassert.assertTrue(actualWarningMessage.contains(expectedWarningMessage),dataprop.getProperty("warningMessage"));
		softassert.assertAll();
	}
	@Test (priority = 3)
	public void SearchAnythingProduct() {
		driver.findElement(By.name("search")).click();
		driver.findElement(By.name("search")).sendKeys(dataprop.getProperty("AnythingProduct"));
		driver.findElement(By.xpath("/html/body/header/div/div/div[2]/div/span/button")).click();
		
		String actualWarningMessage= driver.findElement(By.xpath("/html/body/div[2]/div/div/p[2]")).getText();
		String expectedWarningMessage=dataprop.getProperty("NoProductWarning");
		softassert.assertTrue(actualWarningMessage.contains(expectedWarningMessage),dataprop.getProperty("warningMessage"));
		softassert.assertAll();
		
	}
	@Test (priority = 4)
	public void SearchMultipleExistingProduct() {
		
		driver.findElement(By.name("search")).click();
		driver.findElement(By.name("search")).sendKeys(dataprop.getProperty("MultipleSearch"));
		driver.findElement(By.xpath("/html/body/header/div/div/div[2]/div/span/button")).click();
		
		String actualWarningMessage= driver.findElement(By.xpath("html/body/div[2]/div/div/div[4]/div[2]")).getText();
		String expectedWarningMessage=dataprop.getProperty("MultipleProductConfirmation");
		softassert.assertTrue(actualWarningMessage.contains(expectedWarningMessage),dataprop.getProperty("warningMessage"));
		softassert.assertAll();
		
	}
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
