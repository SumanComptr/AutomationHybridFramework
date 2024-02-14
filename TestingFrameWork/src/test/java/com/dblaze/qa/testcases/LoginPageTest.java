package com.dblaze.qa.testcases;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.dblaze.qa.base.BaseClass;
import com.dblaze.qa.pages.LoginPage;

public class LoginPageTest extends BaseClass {

	@Test
	public void loginApp() throws InterruptedException {

		LoginPage loginpage = PageFactory.initElements(ldriver, LoginPage.class);
		//String strActualUrl = loginpage.loginToOnlineShopping("TestingSumanName1", "TestingSumanPass1");
		
		loginpage.loginToOnlineShopping("standard_user", "secret_sauce");
		
		//Assert.assertTrue(true);

		Thread.sleep(4000);
	}
}
