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

public class CustomerInfoPageTest extends TestBase {

	LoginPage loginPage;
	HomePage homePage;
	CartPage cartPage;
	CustomerInfoPage customerinfoPage;

	public CustomerInfoPageTest() {
		super();
	}

	@BeforeMethod
	public void SetUp() throws InterruptedException {
		Initialization();
		loginPage = new LoginPage();
		homePage = loginPage.Checklogin(prop.getProperty("username"), prop.getProperty("password"));
		homePage = new HomePage();
		homePage.AddProduct();
		cartPage = homePage.ShopCart();
		cartPage = new CartPage();
		customerinfoPage = cartPage.CheckOut();
	}

	@Test(priority=1)
	public void validateCustomerInfoPageUrlTest() throws InterruptedException {
		Thread.sleep(2000);
		String CustomerInfoUrl = customerinfoPage.CustomerInfoPageUrl();
		Assert.assertEquals(CustomerInfoUrl, "https://www.saucedemo.com/checkout-step-one.html");
		Thread.sleep(2000);
	}
	@Test(priority=2)
	public void validateFillCustomerInfoTest() throws InterruptedException {
		customerinfoPage.FillCustomerInfo();
	}
	@Test(priority=3)
	public void validatePurchaseContinueTest() throws InterruptedException {
		Thread.sleep(2000);
		customerinfoPage.FillCustomerInfo();
		Thread.sleep(2000);
		customerinfoPage.PurchaseContinue();
		Thread.sleep(2000);
	}

	@AfterMethod
	public void TearDown() {
		driver.quit();
	}

}
