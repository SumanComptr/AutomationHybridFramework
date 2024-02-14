package com.dblaze.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage {

	WebDriver driver;

	public HomePage(WebDriver ldriver) {

		this.driver = ldriver;
	}

	/*
	 * @FindBy(xpath = "//a[contains(text(),'Welcome TestingSumanName1')]")
	 * WebElement UserNLabel;
	 */

	@FindBy(xpath = "//*[@id=\"add-to-cart-sauce-labs-fleece-jacket\"]")
	WebElement Product1;
	
	@FindBy(xpath="//*[@id=\"shopping_cart_container\"]/a/span")
	WebElement ShopCart;

	/*
	 * public boolean VerifyCorrectUser() {
	 * 
	 * return UserNLabel.isDisplayed();
	 * 
	 * }
	 */

	public void Product1() throws InterruptedException {
		Product1.click();
		Thread.sleep(2000);
	}
	
	public void ShopCart() throws InterruptedException {
		ShopCart.click();
		Thread.sleep(3000);
	}

}
