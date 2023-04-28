package com.tutorial.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class landingPage {
	
	//Objects
	
	@FindBy (linkText = "My Account")
	private WebElement MyAccountLink;
	
	@FindBy (linkText = "Login")
	private WebElement loginLink;
	
	@FindBy (linkText = "Register")
	private WebElement registerLink;
	
	@FindBy (xpath  = "/html/body/header/div/div/div[2]/div/span/button")
	private WebElement searchButton;

	public WebDriver driver;
	
	public landingPage(WebDriver driver) {
		this.driver=driver;
		//PageFactory.initElements(driver, landingPage.class);
		PageFactory.initElements(driver, this);
	}
	
	//Actions
	
	public void clickOnMyAccountLink() {
		MyAccountLink.click();
		
	}
	public void clickOnLoginLink() {
		loginLink.click();
		
	}
	
	public void clickOnRegisternLink() {
		registerLink.click();
		
	}
	
	public void clickOnSearchButton() {
		searchButton.click();
		
	}
	
}
