package com.saucedemo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class YourInformation {
	WebDriver driver;

	public YourInformation(WebDriver ldriver) {
		this.driver = ldriver;
		PageFactory.initElements(driver, this);

		if (!YourInformationlogo.isDisplayed())
			throw new AssertionError("Not landed on Your Information");
	}

	@FindBy(xpath = "//span[@class= 'title']")
	protected WebElement YourInformationlogo;

	@FindBy(id = "first-name")
	protected WebElement firstName;

	@FindBy(id = "last-name")
	protected WebElement lastName;

	@FindBy(id = "postal-code")
	protected WebElement postalCd;

	@FindBy(id = "continue")
	protected WebElement continueBtn;

	public void fillDetails(String fname, String lname, String postalCode) {
		firstName.sendKeys(fname);
		lastName.sendKeys(lname);
		postalCd.sendKeys(postalCode.replace("\"", ""));

	}

	public CheckoutOverview continueCheckout() {
		continueBtn.click();
		return new CheckoutOverview(driver);
	}

}
