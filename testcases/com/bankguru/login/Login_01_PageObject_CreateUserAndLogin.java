package com.bankguru.login;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import commons.AbstractTest;
import pages.HomePagePO;
import pages.LoginPagePO;
import pages.RegisterPagePO;;

public class Login_01_PageObject_CreateUserAndLogin extends AbstractTest {
	WebDriver driver;
	String email, username, passWord, loginUrl;
	private LoginPagePO loginPage;
	private RegisterPagePO registerPage;
	private HomePagePO homePage;

	@Parameters({ "browser" })
	@BeforeClass
	public void beforeClass(String browser) {
		driver = openMultiBrowser(browser);
		loginPage = new LoginPagePO(driver);

		email = "automation" + randomNumber() + "@gmail.com";
	}

	@Test
	public void TC_Login01_CreateUser() {
		loginUrl = loginPage.getLoginPageUrl();

		loginPage.clickToHereLink();

		registerPage = new RegisterPagePO(driver);

		registerPage.inputToEmailIdTextbox(email);

		registerPage.clickToSubmitButton();

		username = registerPage.getUserIdInfor();
		passWord = registerPage.getPasswordInfor();
	}
	@Test
	public void TC_Login02_LoginToApplication() {
		registerPage.openLoginPage(loginUrl);
		loginPage = new LoginPagePO(driver);

		loginPage.inputToUsernameTextbox(username);
		loginPage.inputToPasswordTextbox(passWord);
		loginPage.clickToSubmitButton();

		homePage = new HomePagePO(driver);

		Assert.assertTrue(homePage.isWelcomeMessageDisplayed());
	}

	@AfterClass
	public void afterClass() {
		driver.close();
	}

}
