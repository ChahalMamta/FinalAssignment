package com.saucedemo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class YourCart {

	WebDriver driver;
	public YourCart(WebDriver ldriver) {
		this.driver = ldriver;
		PageFactory.initElements(driver, this);
		
		if (!YourCartlogo.isDisplayed())
			throw new AssertionError("Not landed on Your Cart");
	}
	
	@FindBy(xpath = "//span[@class= 'title']")
	protected WebElement YourCartlogo;
	
	@FindBy(xpath = "//div[@class= 'cart_item'][2]//button")
	protected WebElement removeSecond;
	
	@FindBy(id = "checkout")
	protected WebElement checkout;
		
	public void removeSecondElement() {
		removeSecond.click();
	}
	
	public YourInformation checkout() {
		checkout.click();
		return new YourInformation(driver);
	}
}
