package com.bankguru.login;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import commons.AbstractTest;
import commons.PageFactoryManager;
import pages.DeleteCustomerPagePO;
import pages.EditCustomerPagePO;
import pages.HomePagePO;
import pages.LoginPagePO;
import pages.NewCustomerPagePO;
import pages.RegisterPagePO;;

public class Login_01_PageObject_CreateUserAndLogin extends AbstractTest {
	WebDriver driver;
	String email, username, passWord, loginUrl;
	private LoginPagePO loginPage;
	private RegisterPagePO registerPage;
	private HomePagePO homePage;
	private NewCustomerPagePO newCustomerPage;
	private EditCustomerPagePO editCustomerPage;
	private DeleteCustomerPagePO deleteCustomerPage;

	@Parameters({ "browser", "version"})
	@BeforeClass
	public void beforeClass(String browser, String version) {
		driver = openMultiBrowser(browser, version);
		loginPage = PageFactoryManager.getLoginPage(driver);
		email = "automation" + randomNumber() + "@gmail.com";
	}

	@Test
	public void TC_Login01_CreateUser() {
		loginUrl = loginPage.getLoginPageUrl();
		registerPage = loginPage.clickToHereLink();
		registerPage.inputToEmailIdTextbox(email);
		registerPage.clickToSubmitButton();		
		username = registerPage.getUserIdInfor();
		passWord = registerPage.getPasswordInfor();
	}

	@Test
	public void TC_Login02_LoginToApplication() {
		loginPage = registerPage.openLoginPage(loginUrl);
		loginPage.inputToUsernameTextbox(username);
		loginPage.inputToPasswordTextbox(passWord);
		homePage = loginPage.clickToSubmitButton();
		verifyTrue(homePage.isWelcomeMessageDisplayed());
		
		newCustomerPage = homePage.openNewCustomerPage(driver);
		editCustomerPage = newCustomerPage.openEditCustomerPage(driver);
		deleteCustomerPage = editCustomerPage.openDeleteCustomerPage(driver);
		homePage = deleteCustomerPage.openHomePage(driver);
		editCustomerPage = homePage.openEditCustomerPage(driver);
		loginPage = editCustomerPage.openLogOutPage(driver);
	}

	@AfterClass
	public void afterClass() {
		closeBrowser(driver);
	}

}
