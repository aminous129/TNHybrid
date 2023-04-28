package com.tutorial.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	public WebDriver driver;
	//Objects
	
	@FindBy(id="input-email")
	private WebElement usernameTextBox;
	
	@FindBy(id="input-password")
	private WebElement passwordTextBox;
	
	@FindBy(xpath="//*[@id=\"content\"]/div/div[2]/div/form/input")
	private WebElement buttonLoginClick;
	
	@FindBy(xpath = "/html/body/div[2]/div[1]")
	private WebElement temporaryIssueMessageLocator;
	//constructor
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	//Actions
	public void enterusername(String userNameText) {
		usernameTextBox.sendKeys(userNameText);
	}
	public void enterPassword(String passwordText) {
		passwordTextBox.sendKeys(passwordText);
	}
	public void LoginButtonClick() {
		buttonLoginClick.click();
	}
	
	public String RetrieveErrorMessageText() {
		String tempErrorMessage=temporaryIssueMessageLocator.getText();
		return tempErrorMessage;
	}
}
