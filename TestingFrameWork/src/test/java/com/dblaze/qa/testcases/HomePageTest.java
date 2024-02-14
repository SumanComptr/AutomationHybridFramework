package com.dblaze.qa.testcases;

import org.testng.annotations.Test;

import com.dblaze.qa.base.BaseClass;
import com.dblaze.qa.pages.HomePage;
import com.dblaze.qa.pages.LoginPage;

import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;

public class HomePageTest extends BaseClass {
	HomePage homepage;
	LoginPageTest logHome;

	@Test(priority = 1)
	public void Product1() throws InterruptedException {
		HomePage homepage = PageFactory.initElements(ldriver, HomePage.class);
		Thread.sleep(3000);
		homepage.Product1();
		Thread.sleep(3000);
		homepage.ShopCart();
		Thread.sleep(3000);

	}

	@BeforeMethod
	public void beforeMethod() throws InterruptedException {
		LoginPage loginpage = PageFactory.initElements(ldriver, LoginPage.class);
		// String strActualUrl = loginpage.loginToOnlineShopping("TestingSumanName1",
		// "TestingSumanPass1");

		loginpage.loginToOnlineShopping("standard_user", "secret_sauce");
		Thread.sleep(3000);

	}

	@AfterMethod
	public void afterMethod() {
	}

}
