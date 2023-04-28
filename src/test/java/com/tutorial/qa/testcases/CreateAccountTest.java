package com.tutorial.qa.testcases;


import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.tutorial.qa.pages.landingPage;
import com.tutorial.qa.testbase.TestBase;
import com.tutorial.qa.utils.Utilities;

public class CreateAccountTest extends TestBase {
	
	public CreateAccountTest () throws Exception {
		super();
	}
	public WebDriver driver;
	public SoftAssert softassert= new SoftAssert();
		@BeforeMethod
		
		public void setUp() {
			driver=initializeBrowserAndOpenApplication("chrome");
			landingPage landingpage= new landingPage(driver);
			landingpage.clickOnMyAccountLink();
			landingpage.clickOnRegisternLink();
		//	driver.findElement(By.linkText("My Account")).click();
			//driver.findElement(By.linkText("Register")).click();
		}
		@Test (priority = 1, invocationCount = 1)
		public void enterAllValidFields() {
			driver.findElement(By.name("firstname")).sendKeys(dataprop.getProperty("FirstName"));
			driver.findElement(By.name("lastname")).sendKeys(dataprop.getProperty("LastName"));
			driver.findElement(By.id("input-email")).sendKeys(Utilities.generateNameforEmailWithTimeStamp());
			driver.findElement(By.id("input-telephone")).sendKeys(dataprop.getProperty("input-telephone"));
			driver.findElement(By.id("input-password")).sendKeys(dataprop.getProperty("input-password"));
			driver.findElement(By.id("input-confirm")).sendKeys(dataprop.getProperty("input-password"));
			driver.findElement(By.xpath("//*[@id=\"content\"]/form/fieldset[3]/div/div/label[2]/input")).click();
			driver.findElement(By.cssSelector("#content > form > div > div > input[type=checkbox]:nth-child(2)")).click();
			driver.findElement(By.xpath("//*[@id=\"content\"]/form/div/div/input[2]")).click();
			
			String actualWarningMessage= driver.findElement(By.xpath("//*[@id=\"content\"]/h1")).getText();
			String expectedWarningMessage=dataprop.getProperty("successAccountCreate");
			softassert.assertTrue(actualWarningMessage.contains(expectedWarningMessage),dataprop.getProperty("warningMessage"));
			softassert.assertAll();
		}
		
		@Test (priority = 2)
		public void enterExistingLoginEmailField() {
			driver.findElement(By.name("firstname")).sendKeys(dataprop.getProperty("FirstName"));
			driver.findElement(By.name("lastname")).sendKeys(dataprop.getProperty("LastName"));
			driver.findElement(By.id("input-email")).sendKeys("input3@gmail.com");
			driver.findElement(By.id("input-telephone")).sendKeys(dataprop.getProperty("input-telephone"));
			driver.findElement(By.id("input-password")).sendKeys(dataprop.getProperty("input-password"));
			driver.findElement(By.id("input-confirm")).sendKeys(dataprop.getProperty("input-password"));
			driver.findElement(By.xpath("//*[@id=\"content\"]/form/fieldset[3]/div/div/label[2]/input")).click();
			driver.findElement(By.cssSelector("#content > form > div > div > input[type=checkbox]:nth-child(2)")).click();
			driver.findElement(By.xpath("//*[@id=\"content\"]/form/div/div/input[2]")).click();
			
			String actualWarningMessage= driver.findElement(By.xpath("/html/body/div[2]/div[1]")).getText();
			String expectedWarningMessage=dataprop.getProperty("warningMessageCreation");
			softassert.assertTrue(actualWarningMessage.contains(expectedWarningMessage),dataprop.getProperty("warningMessage"));
			softassert.assertAll();
		}
		@Test (priority = 3)
		public void enterNotSameSecondPasswordField() {
			driver.findElement(By.name("firstname")).sendKeys(dataprop.getProperty("FirstName"));
			driver.findElement(By.name("lastname")).sendKeys(dataprop.getProperty("LastName"));
			driver.findElement(By.id("input-email")).sendKeys("input3@gmail.com");
			driver.findElement(By.id("input-telephone")).sendKeys(dataprop.getProperty("input-telephone"));
			driver.findElement(By.id("input-password")).sendKeys("password2");
			driver.findElement(By.id("input-confirm")).sendKeys("passw");
			driver.findElement(By.xpath("//*[@id=\"content\"]/form/fieldset[3]/div/div/label[2]/input")).click();
			driver.findElement(By.cssSelector("#content > form > div > div > input[type=checkbox]:nth-child(2)")).click();
			driver.findElement(By.xpath("//*[@id=\"content\"]/form/div/div/input[2]")).click();
			
			String actualWarningMessage= driver.findElement(By.className("text-danger")).getText();
			String expectedWarningMessage=dataprop.getProperty("passwordConfirmationNotMatch");
			softassert.assertTrue(actualWarningMessage.contains(expectedWarningMessage),dataprop.getProperty("warningMessage"));
			softassert.assertAll();
		}
		@Test (priority = 4)
		public void notClickOnPrivacyPolicyField() {
			driver.findElement(By.name("firstname")).sendKeys(dataprop.getProperty("FirstName"));
			driver.findElement(By.name("lastname")).sendKeys(dataprop.getProperty("LastName"));
			driver.findElement(By.id("input-email")).sendKeys("input5@gmail.com");
			driver.findElement(By.id("input-telephone")).sendKeys(dataprop.getProperty("input-telephone"));
			driver.findElement(By.id("input-password")).sendKeys("password2");
			driver.findElement(By.id("input-confirm")).sendKeys("passw");
			driver.findElement(By.xpath("//*[@id=\"content\"]/form/fieldset[3]/div/div/label[2]/input")).click();
			//driver.findElement(By.cssSelector("#content > form > div > div > input[type=checkbox]:nth-child(2)")).click();
			driver.findElement(By.xpath("//*[@id=\"content\"]/form/div/div/input[2]")).click();
			
			String actualWarningMessage= driver.findElement(By.xpath("/html/body/div[2]/div[1]")).getText();
			String expectedWarningMessage=dataprop.getProperty("privacyPolicyWarningMessage");
			softassert.assertTrue(actualWarningMessage.contains(expectedWarningMessage),dataprop.getProperty("warningMessage"));
			softassert.assertAll();
		}
			@Test (priority = 5)
			public void enterEmptyFirstNameField() {
				driver.findElement(By.name("firstname")).sendKeys("");
				driver.findElement(By.name("lastname")).sendKeys(dataprop.getProperty("LastName"));
				driver.findElement(By.id("input-email")).sendKeys("input5@gmail.com");
				driver.findElement(By.id("input-telephone")).sendKeys(dataprop.getProperty("input-telephone"));
				driver.findElement(By.id("input-password")).sendKeys("password2");
				driver.findElement(By.id("input-confirm")).sendKeys("passw");
				driver.findElement(By.xpath("//*[@id=\"content\"]/form/fieldset[3]/div/div/label[2]/input")).click();
				driver.findElement(By.cssSelector("#content > form > div > div > input[type=checkbox]:nth-child(2)")).click();
				driver.findElement(By.xpath("//*[@id=\"content\"]/form/div/div/input[2]")).click();
				
				String actualWarningMessage= driver.findElement(By.xpath("/html/body/div[2]/div/div/form/fieldset[1]/div[2]/div/div")).getText();
				String expectedWarningMessage=dataprop.getProperty("firstNameWarningMessage");
				softassert.assertTrue(actualWarningMessage.contains(expectedWarningMessage),dataprop.getProperty("warningMessage"));
				softassert.assertAll();
			}
			@Test (priority = 6)
			public void enterEmptyLastNameField() {
				driver.findElement(By.name("firstname")).sendKeys(dataprop.getProperty("FirstName"));
				driver.findElement(By.name("lastname")).sendKeys("");
				driver.findElement(By.id("input-email")).sendKeys("input5@gmail.com");
				driver.findElement(By.id("input-telephone")).sendKeys(dataprop.getProperty("input-telephone"));
				driver.findElement(By.id("input-password")).sendKeys("password2");
				driver.findElement(By.id("input-confirm")).sendKeys("passw");
				driver.findElement(By.xpath("//*[@id=\"content\"]/form/fieldset[3]/div/div/label[2]/input")).click();
				driver.findElement(By.cssSelector("#content > form > div > div > input[type=checkbox]:nth-child(2)")).click();
				driver.findElement(By.xpath("//*[@id=\"content\"]/form/div/div/input[2]")).click();
				
				String actualWarningMessage= driver.findElement(By.xpath("/html/body/div[2]/div/div/form/fieldset[1]/div[3]/div/div")).getText();
				String expectedWarningMessage=dataprop.getProperty("lastNameWarningMessage");
				softassert.assertTrue(actualWarningMessage.contains(expectedWarningMessage),dataprop.getProperty("warningMessage"));
				softassert.assertAll();
			}
			@Test (priority = 7)
			public void enterEmptyEmailField() {
				driver.findElement(By.name("firstname")).sendKeys(dataprop.getProperty("FirstName"));
				driver.findElement(By.name("lastname")).sendKeys(dataprop.getProperty("LastName"));
				driver.findElement(By.id("input-email")).sendKeys("");
				driver.findElement(By.id("input-telephone")).sendKeys(dataprop.getProperty("input-telephone"));
				driver.findElement(By.id("input-password")).sendKeys("password2");
				driver.findElement(By.id("input-confirm")).sendKeys("passw");
				driver.findElement(By.xpath("//*[@id=\"content\"]/form/fieldset[3]/div/div/label[2]/input")).click();
				driver.findElement(By.cssSelector("#content > form > div > div > input[type=checkbox]:nth-child(2)")).click();
				driver.findElement(By.xpath("//*[@id=\"content\"]/form/div/div/input[2]")).click();
				
				String actualWarningMessage= driver.findElement(By.xpath("/html/body/div[2]/div/div/form/fieldset[1]/div[4]/div/div")).getText();
				String expectedWarningMessage=dataprop.getProperty("emailEligibility");
				softassert.assertTrue(actualWarningMessage.contains(expectedWarningMessage),dataprop.getProperty("warningMessage"));
				softassert.assertAll();
			}
			@Test (priority = 8)
			public void enterEmptyTelephoneField() {
				driver.findElement(By.name("firstname")).sendKeys(dataprop.getProperty("FirstName"));
				driver.findElement(By.name("lastname")).sendKeys(dataprop.getProperty("LastName"));
				driver.findElement(By.id("input-email")).sendKeys("ggjgh@gmail.com");
				driver.findElement(By.id("input-telephone")).sendKeys("");
				driver.findElement(By.id("input-password")).sendKeys("password2");
				driver.findElement(By.id("input-confirm")).sendKeys("passw");
				driver.findElement(By.xpath("//*[@id=\"content\"]/form/fieldset[3]/div/div/label[2]/input")).click();
				driver.findElement(By.cssSelector("#content > form > div > div > input[type=checkbox]:nth-child(2)")).click();
				driver.findElement(By.xpath("//*[@id=\"content\"]/form/div/div/input[2]")).click();
				
				String actualWarningMessage= driver.findElement(By.xpath("/html/body/div[2]/div/div/form/fieldset[1]/div[5]/div/div")).getText();
				String expectedWarningMessage=dataprop.getProperty("telephoneEligibility");
				softassert.assertTrue(actualWarningMessage.contains(expectedWarningMessage),dataprop.getProperty("warningMessage"));
				softassert.assertAll();
			}
			@Test (priority = 9)
			public void enterEmptyPasswordField() {
				driver.findElement(By.name("firstname")).sendKeys(dataprop.getProperty("FirstName"));
				driver.findElement(By.name("lastname")).sendKeys(dataprop.getProperty("LastName"));
				driver.findElement(By.id("input-email")).sendKeys("ggjgh@gmail.com");
				driver.findElement(By.id("input-telephone")).sendKeys(dataprop.getProperty("input-telephone"));
				driver.findElement(By.id("input-password")).sendKeys("");
				driver.findElement(By.id("input-confirm")).sendKeys("78676");
				driver.findElement(By.xpath("//*[@id=\"content\"]/form/fieldset[3]/div/div/label[2]/input")).click();
				driver.findElement(By.cssSelector("#content > form > div > div > input[type=checkbox]:nth-child(2)")).click();
				driver.findElement(By.xpath("//*[@id=\"content\"]/form/div/div/input[2]")).click();
				
				String actualWarningMessage= driver.findElement(By.xpath("/html/body/div[2]/div/div/form/fieldset[2]/div[1]/div/div")).getText();
				String expectedWarningMessage=dataprop.getProperty("passwordEligibility");
				softassert.assertTrue(actualWarningMessage.contains(expectedWarningMessage),dataprop.getProperty("warningMessage"));
				softassert.assertAll();
			}
			@Test (priority = 10)
			public void enterEmptyPasswordConfirmField() {
				driver.findElement(By.name("firstname")).sendKeys(dataprop.getProperty("FirstName"));
				driver.findElement(By.name("lastname")).sendKeys(dataprop.getProperty("LastName"));
				driver.findElement(By.id("input-email")).sendKeys("ggjgh@gmail.com");
				driver.findElement(By.id("input-telephone")).sendKeys(dataprop.getProperty("input-telephone"));
				driver.findElement(By.id("input-password")).sendKeys("jjjnj");
				driver.findElement(By.id("input-confirm")).sendKeys("");
				driver.findElement(By.xpath("//*[@id=\"content\"]/form/fieldset[3]/div/div/label[2]/input")).click();
				driver.findElement(By.cssSelector("#content > form > div > div > input[type=checkbox]:nth-child(2)")).click();
				driver.findElement(By.xpath("//*[@id=\"content\"]/form/div/div/input[2]")).click();
				
				String actualWarningMessage= driver.findElement(By.xpath("/html/body/div[2]/div/div/form/fieldset[2]/div[2]/div/div")).getText();
				String expectedWarningMessage=dataprop.getProperty("passwordConfirmationNotMatch");
				softassert.assertTrue(actualWarningMessage.contains(expectedWarningMessage),dataprop.getProperty("warningMessage"));
				softassert.assertAll();
			}
			@Test (priority = 11)
			public void enterEmailAddressField() {
				driver.findElement(By.name("firstname")).sendKeys(dataprop.getProperty("FirstName"));
				driver.findElement(By.name("lastname")).sendKeys(dataprop.getProperty("LastName"));
				driver.findElement(By.id("input-email")).sendKeys("cc");
				driver.findElement(By.id("input-telephone")).sendKeys(dataprop.getProperty("input-telephone"));
				driver.findElement(By.id("input-password")).sendKeys("jjjnj");
				driver.findElement(By.id("input-confirm")).sendKeys("");
				driver.findElement(By.xpath("//*[@id=\"content\"]/form/fieldset[3]/div/div/label[2]/input")).click();
				driver.findElement(By.cssSelector("#content > form > div > div > input[type=checkbox]:nth-child(2)")).click();
				driver.findElement(By.xpath("//*[@id=\"content\"]/form/div/div/input[2]")).click();
				
				//String actualWarningMessage= driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/form/fieldset[1]/div[4]/div/div")).getText();
				//String expectedWarningMessage=dataprop.getProperty("InvalidEmailErrorMessage");
				//softassert.assertTrue(actualWarningMessage.contains(expectedWarningMessage),dataprop.getProperty("warningMessage"));
				//softassert.assertAll();
				
				
				Alert alert=driver.switchTo().alert();
				String actualAlertText=alert.getText();
				String expectedAlertText=dataprop.getProperty("emailWarningMessage");
		
				softassert.assertEquals(actualAlertText,expectedAlertText);
				if (actualAlertText.equals(expectedAlertText)) {
					alert.accept();
				}else {
					alert.dismiss();
				}
				softassert.assertTrue(actualAlertText.contains(expectedAlertText),dataprop.getProperty("warningMessage"));
				softassert.assertAll();
			}
			
		@AfterMethod
		public void tearDown() {
			driver.quit();
		}
}
