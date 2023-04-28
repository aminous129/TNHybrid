package com.tutorial.qa.testcases;



//import org.openqa.selenium.Alert;
import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.tutorial.qa.pages.InboxPage;
import com.tutorial.qa.pages.LoginPage;
import com.tutorial.qa.pages.landingPage;
import com.tutorial.qa.testbase.TestBase;



public class LoginTest extends TestBase {
public LoginTest () throws Exception {
	super();
}
public WebDriver driver;
public SoftAssert softassert= new SoftAssert();
	@BeforeMethod
	public void setUp() {
		driver=initializeBrowserAndOpenApplication(prop.getProperty("browserName"));
		landingPage landingpage= new landingPage(driver);
		landingpage.clickOnMyAccountLink();
		landingpage.clickOnLoginLink();
		
		//driver.findElement(By.linkText("My Account")).click();
		//driver.findElement(By.linkText("Login")).click();
	}
	@Test (priority = 1)
	public void verifyTutorialLoginWithValidUsernameAndValidPassword() {
	LoginPage loginpage=new LoginPage(driver);
	loginpage.enterusername(prop.getProperty("validUsername"));
	loginpage.enterPassword(prop.getProperty("validPassword"));	
	loginpage.LoginButtonClick();
	
		//driver.findElement(By.id("input-email")).sendKeys(prop.getProperty("validUsername"));
		//driver.findElement(By.id("input-password")).sendKeys(prop.getProperty("validPassword"));
		//driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/div/form/input")).click();
		
	driver.findElement(By.linkText("My Account")).click();
		InboxPage inboxpage=new InboxPage(driver);
		softassert.assertTrue(inboxpage.logoutLinkisDisplayedorNot());
		//softassert.assertTrue(driver.findElement(By.linkText("Logout")).isDisplayed());
		softassert.assertAll();

	}
	
	@Test (priority = 2)
	public void verifyTutorialLoginWithInValidUsernameAndInValidPassword() {
		
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterusername(dataprop.getProperty("invalidEmail"));
		loginpage.enterPassword(dataprop.getProperty("invalidPassword"));	
		loginpage.LoginButtonClick();
		
		//driver.findElement(By.id("input-email")).sendKeys(dataprop.getProperty("invalidEmail"));
		//driver.findElement(By.id("input-password")).sendKeys(dataprop.getProperty("invalidPassword"));
		//driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/div/form/input")).click();
	
		String actualWarningMessage= loginpage.RetrieveErrorMessageText();
		//String actualWarningMessage= driver.findElement(By.xpath("/html/body/div[2]/div[1]")).getText();
		String expectedWarningMessage=dataprop.getProperty("tempIssueWarningMessage");
		softassert.assertTrue(actualWarningMessage.contains(expectedWarningMessage),dataprop.getProperty("warningMessage"));
		softassert.assertAll();

		
}
	@Test (priority = 3)
	public void verifyTutorialLoginWithValidUsernameAndInValidPassword() {
		
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterusername(prop.getProperty("validUsername"));
		loginpage.enterPassword(dataprop.getProperty("invalidPassword"));	
		loginpage.LoginButtonClick();
		
		//driver.findElement(By.id("input-email")).sendKeys(prop.getProperty("validUsername"));
		//driver.findElement(By.id("input-password")).sendKeys(dataprop.getProperty("invalidPassword"));
		//driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/div/form/input")).click();
	
		String actualWarningMessage= driver.findElement(By.xpath("/html/body/div[2]/div[1]")).getText();
		String expectedWarningMessage=dataprop.getProperty("tempIssueWarningMessage");
		softassert.assertTrue(actualWarningMessage.contains(expectedWarningMessage),dataprop.getProperty("warningMessage"));
		softassert.assertAll();
		driver.quit();
}
	@Test (priority = 4)
	public void verifyTutorialLoginWithInValidUsernameAndValidPassword() {
		
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterusername(dataprop.getProperty("invalidEmail"));
		loginpage.enterPassword(prop.getProperty("validPassword"));	
		loginpage.LoginButtonClick();
		
		//driver.findElement(By.id("input-email")).sendKeys(dataprop.getProperty("invalidEmail"));
		//driver.findElement(By.id("input-password")).sendKeys(prop.getProperty("validPassword"));
		//driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/div/form/input")).click();

		String actualWarningMessage= driver.findElement(By.xpath("/html/body/div[2]/div[1]")).getText();
		String expectedWarningMessage=dataprop.getProperty("tempIssueWarningMessage");
		softassert.assertTrue(actualWarningMessage.contains(expectedWarningMessage),dataprop.getProperty("warningMessage"));
		softassert.assertAll();

}
	@Test (priority = 5)
	public void verifyTutorialLoginWithEmptyUsernameAndEmptyPassword() {
		
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterusername("");
		loginpage.enterPassword("");	
		loginpage.LoginButtonClick();
		
		//driver.findElement(By.id("input-email")).sendKeys("");
		//driver.findElement(By.id("input-password")).sendKeys("");
		//driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/div/form/input")).click();
										
	
		String actualWarningMessage= driver.findElement(By.xpath("/html/body/div[2]/div[1]")).getText();
		String expectedWarningMessage=dataprop.getProperty("tempIssueWarningMessage");
		softassert.assertTrue(actualWarningMessage.contains(expectedWarningMessage),dataprop.getProperty("warningMessage"));
		softassert.assertAll();

}
	@Test (priority = 6)
	public void verifyTutorialLoginWithEmptyUsernameAndValidPassword() {
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterusername("");
		loginpage.enterPassword(prop.getProperty("validPassword"));		
		loginpage.LoginButtonClick();		
		
		
		//driver.findElement(By.id("input-email")).sendKeys("");
		//driver.findElement(By.id("input-password")).sendKeys(prop.getProperty("validPassword"));
		//driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/div/form/input")).click();
	
	
		String actualWarningMessage= driver.findElement(By.xpath("/html/body/div[2]/div[1]")).getText();
		String expectedWarningMessage=dataprop.getProperty("tempIssueWarningMessage");
		softassert.assertTrue(actualWarningMessage.contains(expectedWarningMessage),dataprop.getProperty("warningMessage"));
		softassert.assertAll();
	
}
	@Test (priority = 7)
	public void verifyTutorialLoginWithValidUsernameAndEmptyPassword() {
		
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterusername(prop.getProperty("validUsername"));
		loginpage.enterPassword("");		
		loginpage.LoginButtonClick();
	      
		
		//driver.findElement(By.id("input-email")).sendKeys(prop.getProperty("validUsername"));
		//driver.findElement(By.id("input-password")).sendKeys("");
		//driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/div/form/input")).click();
		
		String actualWarningMessage= driver.findElement(By.xpath("/html/body/div[2]/div[1]")).getText();
		String expectedWarningMessage=dataprop.getProperty("tempIssueWarningMessage");
		softassert.assertTrue(actualWarningMessage.contains(expectedWarningMessage),dataprop.getProperty("warningMessage"));
		softassert.assertAll();
		
		//Alert alert=driver.switchTo().alert();
		//String actualAlertText=alert.getText();
		//String expectedAlertText="Warning: No match for E-Mail Address and/or Password.";
			
		//SoftAssert softassert= new SoftAssert();
		//softassert.assertEquals(actualAlertText,expectedAlertText);
		//if (actualAlertText.equals(expectedAlertText)) {
			//alert.accept();
		//}else {
			//alert.dismiss();
		//}
		
		//String actualWarningMessage= driver.findElement(By.xpath("/html/body/div[2]/div[1]")).getText();
		//String expectedWarningMessage="Warning: No match for E-Mail Address and/or Password.";
		//softassert.assertTrue(actualWarningMessage.contains(expectedWarningMessage),"Warning Message is not correct");
		//softassert.assertAll();
		
}
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}