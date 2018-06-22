package pages;

import org.openqa.selenium.WebDriver;

import bankguru.RegisterPageUI;
import commons.AbstractPage;;

public class RegisterPagePO extends AbstractPage {
	WebDriver driver;

	public RegisterPagePO(WebDriver driver_) {
		this.driver = driver_;
	}

	public void inputToEmailIdTextbox(String email) {
		waitForControlVisible(driver, RegisterPageUI.EMAIL_ID_TXT);
		sendKeyToElement(driver, RegisterPageUI.EMAIL_ID_TXT, email);
	}

	public void clickToSubmitButton() {
		waitForControlVisible(driver, RegisterPageUI.SUBMIT_BTN);
		clickToElement(driver, RegisterPageUI.SUBMIT_BTN);
	}

	public String getUserIdInfor() {
		waitForControlVisible(driver, RegisterPageUI.USER_ID_TEXT);
		return getTextElement(driver, RegisterPageUI.USER_ID_TEXT);
	}

	public String getPasswordInfor() {
		waitForControlVisible(driver, RegisterPageUI.PASSWORD_TEXT);
		return getTextElement(driver, RegisterPageUI.PASSWORD_TEXT);
	}

	public void openLoginPage(String loginPageUrl) {
		openAnyUrl(driver, loginPageUrl);
	}

}
