package com.tutorial.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class InboxPage {
	
	public WebDriver driver;
	//Objects
	@FindBy(linkText = "Logout")
	private WebElement logoutLink;
	
	public InboxPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	//Actions
	
	public boolean logoutLinkisDisplayedorNot() {
		
		boolean displayStatus=logoutLink.isDisplayed();
		return displayStatus;
	}
	

}
