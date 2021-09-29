package com.learn;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class FirstTest extends BaseTest {

	@Test(priority = 1)
	public void titleCheck() {
		Reporter.log(String.format("Title verification testcase %s", Thread.currentThread().getId()), true);
		driver = getDriver();
		driver.get("http://65.0.188.10:8080/webapp-5.0.0/");

		Assert.assertEquals(driver.findElement(By.xpath("/html/body/h2")).getText(), "Modal Signup Form");
		Reporter.log(String.format("application name verified %s", Thread.currentThread().getId()), true);
	}

	@Test(priority = 2)
	public void emailLabelTest() {
		Reporter.log(String.format("Environment test %s", Thread.currentThread().getId()), true);

		driver.findElement(By.xpath("/html/body/button")).click();
		Assert.assertEquals(driver.findElement(By.xpath("//*[@id='id01']/form/div/label[1]/b")).getText(), "Email");
		Reporter.log(String.format("Test for env verified %s", Thread.currentThread().getId()), true);
	}

	@Test(priority = 3)
	public void emptySignupCheck() {
		Reporter.log(String.format("Environment test %s", Thread.currentThread().getId()), true);

		WebElement submit = driver.findElement(By.xpath("//*[@id='id01']/form/div/div/button[2]"));
		submit.click();

		Assert.assertTrue(driver.findElement(By.xpath("//*[@id='id01']/form/div/input[1]"))
				.equals(driver.switchTo().activeElement()));
		Reporter.log(String.format("Test for env verified %s", Thread.currentThread().getId()), true);
	}

	@Test(priority = 4)
	public void passwordLabelCheck() {
		Reporter.log(String.format("Environment test %s", Thread.currentThread().getId()), true);

		Assert.assertEquals(driver.findElement(By.xpath("//*[@id='id01']/form/div/label[2]/b")).getText(), "Password");
		Reporter.log(String.format("Test for env verified %s", Thread.currentThread().getId()), true);
	}

	@Test(priority = 5)
	public void passwordRepwdcheck() {
		Reporter.log(String.format("Environment test %s", Thread.currentThread().getId()), true);
		WebElement password = driver.findElement(By.xpath("//*[@id='id01']/form/div/input[2]"));
		WebElement repassword = driver.findElement(By.xpath("//*[@id='id01']/form/div/input[3]"));
		password.sendKeys("test");
		repassword.sendKeys("test");
		Assert.assertEquals(password.getText(), repassword.getText());
		Reporter.log(String.format("Test for env verified %s", Thread.currentThread().getId()), true);
	}

	@Test(priority = 6)
	public void missingmandatoryfieldsCheck() {
		Reporter.log(String.format("Environment test %s", Thread.currentThread().getId()), true);

		WebElement submit = driver.findElement(By.xpath("//*[@id='id01']/form/div/div/button[2]"));
		submit.click();

		Assert.assertTrue(driver.findElement(By.xpath("//*[@id='id01']/form/div/input[1]"))
				.equals(driver.switchTo().activeElement()));
		Reporter.log(String.format("Test for env verified %s", Thread.currentThread().getId()), true);
	}

	@Test(priority = 7)
	public void cancelBtnCheck() {
		Reporter.log(String.format("Environment test %s", Thread.currentThread().getId()), true);

		WebElement cancel = driver.findElement(By.xpath("//*[@id='id01']/form/div/div/button[1]"));
		cancel.click();

		Assert.assertEquals(driver.findElement(By.xpath("/html/body/h2")).getText(), "Modal Signup Form");
		Reporter.log(String.format("Test for env verified %s", Thread.currentThread().getId()), true);
	}

}
