package com.slabs.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.slabs.qa.base.TestBase;


public class HomePage extends TestBase {

	@FindBy(xpath = "//*[@id=\"add-to-cart-sauce-labs-fleece-jacket\"]")
	WebElement TestProduct;

	@FindBy(xpath = "//*[@id=\"shopping_cart_container\"]/a/span")
	WebElement ShopCart;

	public HomePage() {

		PageFactory.initElements(driver, this);
	}
	
	public String HomePageUrl() {

		return driver.getCurrentUrl();
	}
	
	public void AddProduct() throws InterruptedException {
		
		Thread.sleep(3000);
		TestProduct.click();
		Thread.sleep(3000);
	}
	
	public CartPage ShopCart() {
		ShopCart.click();
		return new CartPage();
	}

}
