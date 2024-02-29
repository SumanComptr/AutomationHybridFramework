package com.slabs.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.slabs.qa.base.TestBase;

public class CustomerInfoPage extends TestBase {
	
	@FindBy(xpath = "//*[@id=\"first-name\"]")
	WebElement FirstName;
	
	@FindBy(xpath="//*[@id=\"last-name\"]")
	WebElement LastName;
	
	@FindBy(xpath="//*[@id=\"postal-code\"]")
	WebElement ZipPostal;
	
	@FindBy(id="continue")
	WebElement BtnCont;
	
	public CustomerInfoPage() {
		PageFactory.initElements(driver,this);
	}
	
	public String CustomerInfoPageUrl() {
		return driver.getCurrentUrl();
	}
	
	public void FillCustomerInfo() throws InterruptedException {
		FirstName.clear();
		Thread.sleep(2000);
		FirstName.sendKeys("Suman");
		Thread.sleep(2000);
		LastName.clear();
		Thread.sleep(2000);
		LastName.sendKeys("Das");
		Thread.sleep(2000);
		ZipPostal.clear();
		Thread.sleep(2000);
		ZipPostal.sendKeys("201307");	
	}
	
	
	public PurchasePage PurchaseContinue() {
		
		BtnCont.click();
		return new PurchasePage();
	}

}
