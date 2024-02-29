package com.slabs.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.slabs.qa.base.TestBase;

public class CartPage extends TestBase{
	
	@FindBy(xpath="//*[@id=\"checkout\"]")
	WebElement BtnCheckOut;
	
	public CartPage() {
		PageFactory.initElements(driver, this);
	}
	
	public String CartPageUrl() {
		return driver.getCurrentUrl();
	}
	
	public CustomerInfoPage CheckOut() {
		
		BtnCheckOut.click();
		return new CustomerInfoPage();
		
	}

}
