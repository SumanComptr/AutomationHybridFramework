package com.dblaze.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.dblaze.qa.base.BaseClass;

public class LoginPage extends BaseClass {

	WebDriver driver;

	public LoginPage(WebDriver ldriver) {

		this.driver = ldriver;
	}

	/*
	 * @FindBy(id = "user-name") WebElement LoginButton;
	 */

	@FindBy(id = "user-name")
	WebElement uname;

	@FindBy(id = "password")
	WebElement pass;

	@FindBy(id="login-button")
	WebElement LoginSubmit;

	/*
	 * @FindBy(xpath = "//a[contains(text(),'Welcome TestingSumanName1')]")
	 * WebElement UserN;
	 */

	public void loginToOnlineShopping(String usernameApplication, String passwordApplication)
			throws InterruptedException {

		/*
		 * LoginButton.click(); Thread.sleep(2000);
		 */

		uname.sendKeys(usernameApplication);
		Thread.sleep(2000);

		pass.sendKeys(passwordApplication);
		Thread.sleep(2000);

		LoginSubmit.click();
		Thread.sleep(2000);

		// System.out.println(UserN.isDisplayed());

		// String actualpageurl = driver.getCurrentUrl();

		// return actualpageurl;

	}

}
