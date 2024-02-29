package com.slabs.qa.testcases;

import org.testng.annotations.Test;

import com.slabs.qa.base.TestBase;
import com.slabs.qa.pages.HomePage;
import com.slabs.qa.pages.LoginPage;

import org.testng.annotations.BeforeMethod;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class LoginPageTest extends TestBase {

	LoginPage loginpage;
	HomePage homepage;

	public LoginPageTest() {
		super();
	}

	@BeforeMethod
	public void setup() {

		Initialization();

		loginpage = new LoginPage();
	}

	@Test(priority = 1)
	public void CheckPageTitleTest() throws InterruptedException {
		Thread.sleep(3000);
		String Title = loginpage.validateLoginPageTitle();
		Assert.assertEquals(Title, "Swag Labs");
	}

	@Test(priority = 2)
	public void CheckLoginTest() throws InterruptedException {
		Thread.sleep(3000);

		homepage = loginpage.Checklogin(prop.getProperty("username"), prop.getProperty("password"));
		Thread.sleep(3000);

	}

	@AfterMethod
	public void teardown() {
		driver.quit();

	}

}
