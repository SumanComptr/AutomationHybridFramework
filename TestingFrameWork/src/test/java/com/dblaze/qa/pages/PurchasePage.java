package com.dblaze.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.dblaze.qa.base.BaseClass;

public class PurchasePage extends BaseClass {

	WebDriver driver;

	public PurchasePage(WebDriver ldriver) {

		this.driver = ldriver;
	}

	@FindBy(xpath = "//*[@id=\"finish\"]")
	WebElement BtnFinishPurchase;
	
	public void PurchaseFinish() throws InterruptedException {
		BtnFinishPurchase.click();
		Thread.sleep(3000);
	}

}
