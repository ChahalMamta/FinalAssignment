package com.saucedemo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	WebDriver driver;

	public LoginPage(WebDriver ldriver) {
		this.driver = ldriver;
		PageFactory.initElements(driver, this);

		if (!driver.getTitle().equals("Swag Labs"))
			throw new AssertionError("Not on the login page");
	}

	@FindBy(id = "user-name")
	protected WebElement username;

	@FindBy(id = "password")
	protected WebElement passwrd;

	@FindBy(id = "login-button")
	protected WebElement loginBtn;
	
	@FindBy(xpath = "//div[@class= 'error-message-container error']")
	protected WebElement errorMsg;

	public ProductsPage loginToApp(String AppUsername, String AppPassword) throws InterruptedException {
		username.clear();
		username.sendKeys(AppUsername);
		passwrd.clear();
		passwrd.sendKeys(AppPassword);
		loginBtn.submit();
		
		return new ProductsPage(driver);
	}
	
	public void InvalidLoginToApp(String AppUsername, String AppPassword) throws InterruptedException {
        username.clear();
		username.sendKeys(AppUsername);
		passwrd.clear();
		passwrd.sendKeys(AppPassword);
		loginBtn.submit();
	}
	
	public String getErrorMsg() {
		return errorMsg.getText();
	}

}
