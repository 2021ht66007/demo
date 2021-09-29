package com.learn;

import java.net.MalformedURLException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	WebDriver driver = null;

	@BeforeClass
	@Parameters(value = { "browser" })
	public void setupTest(String browser) throws MalformedURLException {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--incognito");
		 options.addArguments("headless");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver(options);

	}

	public WebDriver getDriver() {
		return driver;
	}

	@AfterClass
	public void tearDown() {
		getDriver().quit();
	}

}
