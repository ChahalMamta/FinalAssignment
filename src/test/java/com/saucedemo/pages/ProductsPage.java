package com.saucedemo.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.saucedemo.utilities.Helper;

public class ProductsPage {
	WebDriver driver;
	Helper helper = new Helper();

	public ProductsPage(WebDriver ldriver) {
		this.driver = ldriver;
		PageFactory.initElements(driver, this);

		if (!ProductsPagelogo.isDisplayed())
			throw new AssertionError("Not landed on Products page");
	}

	@FindBy(xpath = "//span[@class= 'title']")
	protected WebElement ProductsPagelogo;

	@FindBy(id = "react-burger-menu-btn")
	protected WebElement menu;

	@FindBy(id = "react-burger-cross-btn")
	protected WebElement closeMenu;

	@FindBy(xpath = "//button[contains(@id, 'remove')]")
	protected List<WebElement> remove;

	@FindBy(id = "reset_sidebar_link")
	protected WebElement resetApp;

	String addElement = "add-to-cart-%s";

	@FindBy(xpath = "//a[@class= 'shopping_cart_link']")
	protected WebElement cart;
	
	public int getRemoveCount() {
		return remove.size();
	}

	public YourCart navigateToCart() {
		cart.click();
		return new YourCart(driver);
	}

	public void resetAppState() {
		menu.click();
		resetApp.click();
		closeMenu.click();
	}

	public void addToCart(String productName) {
		updateLocator(driver, productName.toLowerCase().replace(" ", "-")).click();
	}

	public WebElement updateLocator(WebDriver driver, String text) {
		return driver.findElement(By.id(String.format(addElement.toString(), text)));
	}
	
}
