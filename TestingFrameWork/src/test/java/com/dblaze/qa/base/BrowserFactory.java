package com.dblaze.qa.base;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserFactory {

	public static WebDriver driver;
	public static Properties prop;

	public static WebDriver startApplication() throws InterruptedException, IOException {

		prop = new Properties();

		FileReader reader = new FileReader(
				"C:\\Users\\suman\\eclipse-workspace\\TestingFrameWork\\src\\test\\java\\com\\dblaze\\qa\\config\\config.properties");

		prop.load(reader);

		String browserName = prop.getProperty("browser");
		String appURL = prop.getProperty("url");

		WebDriver ldriver = null;

		if (browserName.equalsIgnoreCase("chrome")) {

			ChromeOptions options = new ChromeOptions();
			options.addArguments("--remote-allow-origins=*");
			WebDriverManager.chromedriver().setup();
			WebDriver driver = new ChromeDriver(options);

			driver.manage().window().maximize();
			driver.get(appURL);
			ldriver = driver;
			Thread.sleep(4000);
			driver.manage().deleteAllCookies();
		}
		else if(browserName.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			WebDriver driver=new EdgeDriver();
			driver.manage().window().maximize();
			driver.get(appURL);
			ldriver=driver;
			Thread.sleep(4000);
			driver.manage().deleteAllCookies();
		}
		System.out.println("BrowerFactory - " + ldriver);
		return ldriver;
	}

	public static void quitBrowser(WebDriver driver) {
		driver.quit();
	}

}
