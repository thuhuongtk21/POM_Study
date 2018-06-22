package pages;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import commons.PageFactoryManager;
import bankguru.LoginPageUI;

public class LoginPagePO extends AbstractPage{
	WebDriver driver;
	
	//constructor
	public LoginPagePO(WebDriver driver_) {
		this.driver = driver_;
	}
	public String getLoginPageUrl() {
		return getCurrentUrl(driver);
	}
	
	public void inputToUsernameTextbox(String username) {
		waitForControlVisible(driver, LoginPageUI.USERNAME_TXT);
		sendKeyToElement(driver, LoginPageUI.USERNAME_TXT, username);
	}
	
	public void inputToPasswordTextbox(String password) {
		waitForControlVisible(driver, LoginPageUI.PASSWORD_TXT);
		sendKeyToElement(driver, LoginPageUI.PASSWORD_TXT, password);
		
	}
	
	public HomePagePO clickToSubmitButton() {
		waitForControlVisible(driver, LoginPageUI.SUBMIT_BTN);
		clickToElement(driver, LoginPageUI.SUBMIT_BTN);		
		return PageFactoryManager.getHomePage(driver);
	}
	
	public void clickToResetButton() {
		waitForControlVisible(driver, LoginPageUI.RESET_BTN);
		clickToElement(driver, LoginPageUI.RESET_BTN);
		
	}
	
	public RegisterPagePO clickToHereLink() {
		waitForControlVisible(driver, LoginPageUI.HERE_LINK);
		clickToElement(driver, LoginPageUI.HERE_LINK);
		return PageFactoryManager.getRegisterPage(driver);
		
	}

}
