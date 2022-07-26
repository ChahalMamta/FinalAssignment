package com.saucedemo.pages;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.saucedemo.utilities.BrowserFactory;
import com.saucedemo.utilities.ConfigDataProvider;
import com.saucedemo.utilities.ExcelDataProvider;
import com.saucedemo.utilities.Helper;

public class BaseClass {
	protected WebDriver driver;
	protected ExcelDataProvider excel;
	protected ConfigDataProvider config;

	@BeforeSuite
	public void setUpSuite() {
		excel = new ExcelDataProvider();
		config = new ConfigDataProvider();

	}

	@BeforeClass
	public void setUp() {
		driver = BrowserFactory.startApplication(driver, config.getBrowser(), config.getStagingUrl());
	}

	@AfterClass
	public void tearDown() {
		BrowserFactory.quitBrowser(driver);
	}

	@AfterMethod
	public void tearDownMethod(ITestResult result) throws IOException {
		if (result.getStatus() == ITestResult.FAILURE) {
			Helper.captureScreenshot(driver, result.getName());
		}
	}
}
