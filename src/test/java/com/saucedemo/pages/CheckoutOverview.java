package com.saucedemo.pages;

import java.text.DecimalFormat;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutOverview {

	WebDriver driver;

	public CheckoutOverview(WebDriver ldriver) {
		this.driver = ldriver;
		PageFactory.initElements(driver, this);

		if (!CheckOutOverviewlogo.isDisplayed())
			throw new AssertionError("Not landed on Your Information");
	}

	@FindBy(xpath = "//span[@class= 'title']")
	protected WebElement CheckOutOverviewlogo;

	@FindBy(id = "finish")
	protected WebElement finishBtn;

	@FindBy(xpath = "//div[@class= 'inventory_item_price']")
	protected List<WebElement> price;

	@FindBy(className = "summary_total_label")
	protected WebElement total;

	@FindBy(xpath = "//div[@class= 'summary_value_label'][1]")
	protected WebElement paymentInformation;

	public CheckoutComplete finishCheckout() {
		finishBtn.click();
		return new CheckoutComplete(driver);
	}


	public String getTotal() {
		String uitotal = total.getText().split(" ")[1].replace("$", "").trim();
		return uitotal;
	}

	public String getPaymentInformation() {
		return paymentInformation.getText();
	}

	public String totalPrice() {
		double sum = 0;
		double tax = 0;
		double totalPrice = 0;
		final DecimalFormat df = new DecimalFormat("0.00");

		for (WebElement inputElement : price) {
			sum = sum + Double.parseDouble(inputElement.getText().replace("$", ""));
		}

		tax = (sum * 8) / 100;
		totalPrice = sum + tax;

		return df.format(totalPrice);
	}

}
