package com.dblaze.qa.base;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;

public class BaseClass {
	public static WebDriver ldriver;

	@BeforeClass
	public void setup() throws InterruptedException, IOException {
		ldriver = BrowserFactory.startApplication();
		System.out.println("BaseClass - " + ldriver);
	}

	@AfterClass
	public void teardown() {
		BrowserFactory.quitBrowser(ldriver);
	}

}
