package com.slabs.qa.testcases;

import org.testng.annotations.Test;

import com.slabs.qa.base.TestBase;
import com.slabs.qa.pages.CartPage;
import com.slabs.qa.pages.CustomerInfoPage;
import com.slabs.qa.pages.HomePage;
import com.slabs.qa.pages.LoginPage;
import com.slabs.qa.pages.PurchasePage;

import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class PurchasePageTest extends TestBase {
	LoginPage loginPage;
	HomePage homePage;
	CartPage cartPage;
	CustomerInfoPage customerinfoPage;
	PurchasePage purchasePage;

	public PurchasePageTest() {
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
		customerinfoPage=new CustomerInfoPage();
		customerinfoPage.FillCustomerInfo();
		purchasePage=customerinfoPage.PurchaseContinue();

	}
	@Test(priority=1)
	public void validatePurchasePageUrlTest() throws InterruptedException {
		Thread.sleep(2000);
		String PurchasePageUrl=purchasePage.PurchasePageUrl();
		Assert.assertEquals(PurchasePageUrl, "https://www.saucedemo.com/checkout-step-two.html");
		Thread.sleep(2000);
	}
	@Test(priority=2)
	public void validatePurchaseFinishTest() throws InterruptedException, IOException {
		Thread.sleep(2000);
		purchasePage.PurchaseFinish();
		Thread.sleep(3000);
		
		TakesScreenshot sc = ((TakesScreenshot) driver);
		File src = sc.getScreenshotAs(OutputType.FILE);
		File f2 = new File("D:\\receipt.png");
		FileUtils.copyFile(src, f2);
		Thread.sleep(3000);
	}

	@AfterMethod
	public void TearDown() {
		driver.quit();
	}

}
