package com.slabs.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.slabs.qa.base.TestBase;

public class PurchasePage extends TestBase{
	
	@FindBy(xpath = "//*[@id=\"finish\"]")
	WebElement BtnFinishPurchase;
	
	public PurchasePage() {
		PageFactory.initElements(driver,this);
	}
	public String PurchasePageUrl() {
		return driver.getCurrentUrl();
	}
	
	public PurchaseCompletePage PurchaseFinish() {
		BtnFinishPurchase.click();
		return new PurchaseCompletePage();
	}
	

}
