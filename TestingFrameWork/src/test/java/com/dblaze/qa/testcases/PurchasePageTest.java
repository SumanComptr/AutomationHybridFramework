package com.dblaze.qa.testcases;

import org.testng.annotations.Test;

import com.dblaze.qa.base.BaseClass;
import com.dblaze.qa.pages.CartPage;
import com.dblaze.qa.pages.CustomerInfoPage;
import com.dblaze.qa.pages.HomePage;
import com.dblaze.qa.pages.LoginPage;
import com.dblaze.qa.pages.PurchasePage;

import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;

public class PurchasePageTest extends BaseClass{
	LoginPageTest login;
	HomePageTest homeP;
	CartPage cart;
	CustomerInfoPage custinfo;
	
	PurchasePage purchase;
	
	

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
		
		CartPage cart=PageFactory.initElements(ldriver, CartPage.class);
		cart.PlaceOrder();
		Thread.sleep(3000);
		
		CustomerInfoPage custinfo=PageFactory.initElements(ldriver,CustomerInfoPage.class);
		custinfo.FillFirstName();
		custinfo.FillLastName();
		custinfo.FillPostalZip();
		custinfo.Continue();
		Thread.sleep(3000);
		
	}
	@Test(priority=1)
	public void PurchaseFinish() throws InterruptedException, IOException {
		
		PurchasePage purchase=PageFactory.initElements(ldriver, PurchasePage.class);
		purchase.PurchaseFinish();
		Thread.sleep(3000);
		
		TakesScreenshot sc = ((TakesScreenshot) ldriver);
		File src = sc.getScreenshotAs(OutputType.FILE);
		File f2 = new File("D:\\receipt.png");
		FileUtils.copyFile(src, f2);
		Thread.sleep(3000);
		
		
	}

	@AfterMethod
	public void afterMethod() {
	}

}
