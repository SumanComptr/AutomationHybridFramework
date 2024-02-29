package com.slabs.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.slabs.qa.base.TestBase;

public class LoginPage extends TestBase {

	@FindBy(id = "user-name")
	WebElement uname;

	@FindBy(id = "password")
	WebElement pass;

	@FindBy(id = "login-button")
	WebElement LoginSubmit;

	public LoginPage() {

		PageFactory.initElements(driver, this);

	}

	public String validateLoginPageTitle() {

		return driver.getTitle();
	}

	public HomePage Checklogin(String un, String pwd) throws InterruptedException {
		uname.sendKeys(un);
		Thread.sleep(3000);
		pass.sendKeys(pwd);
		Thread.sleep(3000);

		LoginSubmit.click();

		return new HomePage();
	}

}
