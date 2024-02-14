package com.dblaze.qa.testcases;

import org.testng.annotations.Test;

import com.dblaze.qa.base.BaseClass;
import com.dblaze.qa.pages.CartPage;
import com.dblaze.qa.pages.HomePage;
import com.dblaze.qa.pages.LoginPage;


import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;

public class CartPageTest extends BaseClass {
	LoginPageTest login;
	HomePageTest homeP;
	CartPage cart;

	@BeforeMethod
	public void beforeMethod() throws InterruptedException {
		LoginPage loginpage = PageFactory.initElements(ldriver, LoginPage.class);
		loginpage.loginToOnlineShopping("standard_user", "secret_sauce");
		Thread.sleep(3000);

		HomePage homepage = PageFactory.initElements(ldriver, HomePage.class);
		Thread.sleep(3000);
		homepage.Product1();
		homepage.ShopCart();
		Thread.sleep(3000);
			
	}
	@Test(priority=1)
	public void PlaceOrder() throws InterruptedException {
		CartPage cart=PageFactory.initElements(ldriver, CartPage.class);
		cart.PlaceOrder();
		Thread.sleep(3000);
	}

	@AfterMethod
	public void afterMethod() {
	}

}
