package com.saucedemo.testcases;


import java.text.DecimalFormat;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCaseWithoutFramework {
    @Test
	public void loginTest() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\mamta.chahal\\Documents\\New folder\\PulseTest\\Drivers\\chromedriver.exe");
	    WebDriver driver = new ChromeDriver();
	    
	    driver.get("https://www.saucedemo.com/");
	    driver.manage().window().maximize();
	    
	    driver.findElement(By.id("user-name")).sendKeys("standard_user");
	    driver.findElement(By.id("password")).sendKeys("secret_sauce");
	    driver.findElement(By.id("login-button")).submit();
	    
	    driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
	    driver.findElement(By.id("add-to-cart-sauce-labs-bike-light")).click();
	    driver.findElement(By.id("add-to-cart-sauce-labs-bolt-t-shirt")).click();
	    
	    driver.findElement(By.xpath("//a[@class= 'shopping_cart_link']")).click();
	    
	    //to remove second item -- need to include relative xpath 
	    driver.findElement(By.xpath("//div[@class= 'cart_item'][2]//button")).click();
	    
	    //price verification is pending
	    List<WebElement> elements = driver.findElements(By.xpath("//div[@class= 'inventory_item_price']"));
	    double sum = 0 ;
	    double tax = 0 ;
	    final DecimalFormat df = new DecimalFormat("0.00");
	    
	    for(WebElement inputElement : elements) 
		   {   
			   System.out.println(inputElement.getText());
			   sum = sum + Double.parseDouble(inputElement.getText().replace("$", "")); 
			   
		   }
	    System.out.println(df.format(sum));
	    
	    tax = (sum * 8)/100;
	    
	    
	    System.out.println(df.format(tax));
	    
	    
	    Thread.sleep(5000);
	    
	    driver.findElement(By.id("checkout")).click();
	    
	    driver.findElement(By.id("first-name")).sendKeys("standard");
	    driver.findElement(By.id("last-name")).sendKeys("user");
	    driver.findElement(By.id("postal-code")).sendKeys("40170");
	    
	    driver.findElement(By.id("continue")).click();
	    
	   // Thread.sleep(5000);
	    
	    Assert.assertEquals(driver.findElement(By.xpath("//div[@class= 'summary_value_label'][1]")).getText(),"SauceCard #31337");
	    
	    driver.findElement(By.id("finish")).click();
	    
	    Assert.assertEquals(driver.findElement(By.xpath("//div[@class= 'checkout_complete_container']/h2")).getText(),"THANK YOU FOR YOUR ORDER");
	   
	    Assert.assertEquals(driver.findElement(By.xpath("//div[@class= 'complete-text']")).getText(),
	    		"Your order has been dispatched, and will arrive just as fast as the pony can get there!");
	    

	    Assert.assertTrue(driver.findElement(By.xpath("//img[@class= 'pony_express']")).isDisplayed(), "No image present");
	   
	    
	    Thread.sleep(5000);
	    
	    driver.quit();
	    
	    
	    //second test 
	   
//
	}
    
    @Test
    public void errorTest() {
    	
    	System.setProperty("webdriver.chrome.driver", "C:\\Users\\mamta.chahal\\Documents\\New folder\\PulseTest\\Drivers\\chromedriver.exe");
	    WebDriver driver = new ChromeDriver();
	    
    	 driver.get("https://www.saucedemo.com/");
 	    driver.manage().window().maximize();
 	    
 	    driver.findElement(By.id("user-name")).sendKeys("locked_out_user");
 	    driver.findElement(By.id("password")).sendKeys("secret_sauce");
 	   driver.findElement(By.id("login-button")).submit();
 	    Assert.assertEquals(driver.findElement(By.xpath("//div[@class= 'error-message-container error']")).getText(),
 	    		"Epic sadface: Sorry, this user has been locked out.");
 	   driver.quit();
    }

}
