package com.dblaze.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.dblaze.qa.base.BaseClass;

public class CustomerInfoPage extends BaseClass {

	WebDriver driver;

	public CustomerInfoPage(WebDriver ldriver) {

		this.driver = ldriver;
	}

	@FindBy(xpath = "//*[@id=\"first-name\"]")
	WebElement FirstName;
	
	@FindBy(xpath="//*[@id=\"last-name\"]")
	WebElement LastName;
	
	@FindBy(xpath="//*[@id=\"postal-code\"]")
	WebElement ZipPostal;
	
	@FindBy(id="continue")
	WebElement BtnCont;
	
	public void FillFirstName() throws InterruptedException {
		FirstName.clear();
		FirstName.sendKeys("Test Suman");
		Thread.sleep(2000);
		
	}
	
	public void FillLastName() throws InterruptedException {
		LastName.clear();
		LastName.sendKeys("Suman Test");
		Thread.sleep(2000);
		
	}
	
	public void FillPostalZip() throws InterruptedException {
		ZipPostal.clear();
		ZipPostal.sendKeys("201307");
		Thread.sleep(2000);
	}
	
	public void Continue() throws InterruptedException {
		BtnCont.click();
		Thread.sleep(2000);
	}

}
