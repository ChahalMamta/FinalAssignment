package com.saucedemo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutComplete {
	WebDriver driver;

	public CheckoutComplete(WebDriver ldriver) {
		this.driver = ldriver;
		PageFactory.initElements(driver, this);

		if (!checkoutCompletelogo.isDisplayed())
			throw new AssertionError("Not landed on Your Information");
	}

	@FindBy(xpath = "//span[@class= 'title']")
	protected WebElement checkoutCompletelogo;

	@FindBy(xpath = "//div[@class= 'checkout_complete_container']/h2")
	protected WebElement thankyouNote;
	
	@FindBy(xpath = "//div[@class= 'complete-text']")
	protected WebElement finalNote;
	
	@FindBy(xpath = "//img[@class= 'pony_express']")
	protected WebElement image;
	
	public String getThankyouNote() {
		return thankyouNote.getText();
	}
	
	public String getFinalNote() {
		return finalNote.getText();
	}
	
	public boolean getImage() {
		return image.isDisplayed();
	}
	
	
	
}
