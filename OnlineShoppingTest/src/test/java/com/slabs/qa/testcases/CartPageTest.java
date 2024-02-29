package com.slabs.qa.testcases;

import org.testng.annotations.Test;

import com.slabs.qa.base.TestBase;
import com.slabs.qa.pages.CartPage;
import com.slabs.qa.pages.CustomerInfoPage;
import com.slabs.qa.pages.HomePage;
import com.slabs.qa.pages.LoginPage;

import org.testng.annotations.BeforeMethod;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class CartPageTest extends TestBase {
	LoginPage loginPage;
	HomePage homePage;
	CartPage cartPage;
	CustomerInfoPage customerinfoPage;

	public CartPageTest() {
		super();
	}

	@BeforeMethod
	public void SetUp() throws InterruptedException {
		Initialization();
		loginPage=new LoginPage();
		homePage=loginPage.Checklogin(prop.getProperty("username"), prop.getProperty("password"));
		homePage=new HomePage();
		homePage.AddProduct();
		cartPage=homePage.ShopCart();
	}
	@Test(priority=1)
	public void validateCartPageUrlTest() throws InterruptedException {
		Thread.sleep(3000);
		String CartPageUrl=cartPage.CartPageUrl();
		Assert.assertEquals(CartPageUrl,"https://www.saucedemo.com/cart.html");
		Thread.sleep(3000);
	}
	
	@Test(priority=2)
	public void validateCheckOutTest() throws InterruptedException {
		Thread.sleep(3000);
		customerinfoPage=cartPage.CheckOut();
		Thread.sleep(3000);
		
	}

	@AfterMethod
	public void TearDown() {
		driver.quit();
	}

}
