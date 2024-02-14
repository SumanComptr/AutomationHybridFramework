package com.dblaze.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.dblaze.qa.base.BaseClass;

public class CartPage extends BaseClass {

	WebDriver driver;

	public CartPage(WebDriver ldriver) {

		this.driver = ldriver;
	}
	
	@FindBy(xpath="//*[@id=\"checkout\"]")
	WebElement BtnCheckOut;
	
	public void PlaceOrder() throws InterruptedException {
		BtnCheckOut.click();
		Thread.sleep(3000);
		
	}

}
