package com.saucedemo.utilities;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Helper {
	public static String captureScreenshot(WebDriver driver, String screenShotName) {
		String ScreenshotPath = System.getProperty("user.dir") + "./Screenshots/" + getCurrentDateTime() + "_"
				+ screenShotName + ".png";
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		try {
			FileUtils.copyFile(src, new File(ScreenshotPath));
			System.out.println("Screenshot Captured");

		} catch (Exception e) {
			System.out.println("Unable to capture screenshot" + e.getMessage());
		}
		return ScreenshotPath;

	}

	public static String getCurrentDateTime() {
		DateFormat customFormat = new SimpleDateFormat("MM_dd_yyyy_HH_mm_ss");
		Date currentDate = new Date();
		return customFormat.format(currentDate);
	}


	
}
