package com.slabs.qa.testcases;

import org.testng.annotations.Test;

import com.slabs.qa.base.TestBase;
import com.slabs.qa.pages.CartPage;
import com.slabs.qa.pages.HomePage;
import com.slabs.qa.pages.LoginPage;

import org.testng.annotations.BeforeMethod;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class HomePageTest extends TestBase {
	LoginPage loginpage;
	HomePage homePage;
	CartPage cartPage;
	
	public HomePageTest() {
		super();
	}
	
  
  @BeforeMethod
  public void setup() throws InterruptedException {
	  Initialization();
	  loginpage=new LoginPage();
	  homePage=loginpage.Checklogin(prop.getProperty("username"), prop.getProperty("password"));
	  
  }
  
  @Test(priority=1)
  public void validateUrlTest() throws InterruptedException {
	  Thread.sleep(3000);
	  String strUrl=homePage.HomePageUrl();
	  Assert.assertEquals(strUrl, "https://www.saucedemo.com/inventory.html");
	  Thread.sleep(3000);
  }
  @Test(priority=2)
  public void validateAddProductTest() throws InterruptedException {
	  Thread.sleep(3000);
	  homePage.AddProduct();
	  Thread.sleep(3000);
  }
  @Test(priority=3)
  public void validateShopCartTest() throws InterruptedException {
	  homePage.AddProduct();
	  Thread.sleep(3000);
	  cartPage=homePage.ShopCart();
	  Thread.sleep(3000);
  }

  @AfterMethod
  public void TearDown() {
	  driver.quit();
  }

}
