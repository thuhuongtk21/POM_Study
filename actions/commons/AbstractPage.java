package commons;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import bankguru.AbstractPageUI;
import pages.BalanceEnquiryPO;
import pages.ChangePasswordPO;
import pages.CustomisedStatementPO;
import pages.DeleteAccountPO;
import pages.DeleteCustomerPagePO;
import pages.DepositPO;
import pages.EditAccountPO;
import pages.EditCustomerPagePO;
import pages.FundTransferPO;
import pages.HomePagePO;
import pages.LoginPagePO;
import pages.MiniStatementPO;
import pages.NewAccountPO;
import pages.NewCustomerPagePO;
import pages.WithdrawalPO;


public class AbstractPage {

	public void openAnyUrl(WebDriver driver, String url) {
		driver.get(url);

	}

	public String getTitlePage(WebDriver driver) {
		return driver.getTitle();
	}

	public String getCurrentUrl(WebDriver driver) {
		return driver.getCurrentUrl();
	}

	public void back(WebDriver driver) {
		driver.navigate().back();
	}

	public void clickToElement(WebDriver driver, String locator) {
		WebElement element = driver.findElement(By.xpath(locator));
		element.click();
	}
	
	public void clickToElement(WebDriver driver, String locator, String value) {
		locator = String.format(locator, value);
		System.out.println("Click to element "+ locator);
		WebElement element = driver.findElement(By.xpath(locator));
		element.click();
	}

	public void sendKeyToElement(WebDriver driver, String locator, String value) {
		WebElement element = driver.findElement(By.xpath(locator));
		element.clear();
		element.sendKeys(value);

	}
	
	public void sendKeyToElement(WebDriver driver, String locator, String value, String dynamicXpath) {
		locator = String.format(locator, dynamicXpath);
		WebElement element = driver.findElement(By.xpath(locator));
		element.clear();
		element.sendKeys(value);

	}

	public void selectItemInDropdown(WebDriver driver, String locator, String value) {
		Select select = new Select(driver.findElement(By.xpath(locator)));
		select.selectByVisibleText(value);

	}

	public String getFirstItemSelected(WebDriver driver, String locator) {
		Select select = new Select(driver.findElement(By.xpath(locator)));
		return select.getFirstSelectedOption().getText();

	}

	public String getAttributeValue(WebDriver driver, String locator, String attribute) {
		WebElement element = driver.findElement(By.xpath(locator));
		return element.getAttribute(attribute);

	}

	public String getTextElement(WebDriver driver, String locator) {
		WebElement element = driver.findElement(By.xpath(locator));
		return element.getText();

	}

	public int getSizeElement(WebDriver driver, String locator) {
		List<WebElement> elements = driver.findElements(By.xpath(locator));
		return elements.size();

	}

	public void checkTheCheckbox(WebDriver driver, String locator) {
		WebElement element = driver.findElement(By.xpath(locator));
		if (!element.isSelected()) {
			element.click();
		}

	}
	
	public void checkTheCheckbox(WebDriver driver, String locator, String value) {
		locator = String.format(locator, value);
		WebElement element = driver.findElement(By.xpath(locator));
		if (!element.isSelected()) {
			element.click();
		}

	}

	public void uncheckTheCheckbox(WebDriver driver, String locator) {
		WebElement element = driver.findElement(By.xpath(locator));
		if (element.isSelected()) {
			element.click();
		}

	}
	
	public void uncheckTheCheckbox(WebDriver driver, String locator, String value) {
		locator = String.format(locator, value);
		WebElement element = driver.findElement(By.xpath(locator));
		if (element.isSelected()) {
			element.click();
		}

	}

	public boolean isControlDisplayed(WebDriver driver, String locator) {
		WebElement element = driver.findElement(By.xpath(locator));
		return element.isDisplayed();

	}
	
	public boolean isControlDisplayed(WebDriver driver, String locator, String value) {
		locator = String.format(locator, value);
		System.out.println("Dynamic is control displayed = "+ locator);
		WebElement element = driver.findElement(By.xpath(locator));
		return element.isDisplayed();

	}

	public boolean isControlEnabled(WebDriver driver, String locator) {
		WebElement element = driver.findElement(By.xpath(locator));
		return element.isEnabled();

	}

	public boolean isControlSelected(WebDriver driver, String locator) {
		WebElement element = driver.findElement(By.xpath(locator));
		return element.isSelected();

	}

	public void acceptAlert(WebDriver driver) {
		Alert alert = driver.switchTo().alert();
		alert.accept();
	}

	public void cancelAlert(WebDriver driver) {
		Alert alert = driver.switchTo().alert();
		alert.dismiss();
	}

	public String getTextAlert(WebDriver driver) {
		Alert alert = driver.switchTo().alert();
		return alert.getText();
	}

	public void sendKeyToAlert(WebDriver driver, String value) {
		Alert alert = driver.switchTo().alert();
		alert.sendKeys(value);

	}

	public void switchdToWindowById(WebDriver driver, String parent) {
		Set<String> allWindows = driver.getWindowHandles();
		for (String runWindow : allWindows) {
			if (!runWindow.equals(parent)) {
				driver.switchTo().window(runWindow);
				break;
			}
		}
	}

	public void switchToWindowByTitle(WebDriver driver, String title) {
		Set<String> allWindows = driver.getWindowHandles();
		for (String runWindows : allWindows) {
			driver.switchTo().window(runWindows);
			String currentWin = driver.getTitle();
			if (currentWin.equals(title)) {
				break;
			}
		}
	}

	public void switchToIframe(WebDriver driver, String locator) {
		WebElement element = driver.findElement(By.xpath(locator));
		driver.switchTo().frame(element);

	}

	public void doubleClick(WebDriver driver, String locator) {
		WebElement element = driver.findElement(By.xpath(locator));

		Actions action = new Actions(driver);
		action.doubleClick(element).perform();
	}

	public void hoverMouse(WebDriver driver, String locator) {
		WebElement element = driver.findElement(By.xpath(locator));

		Actions action = new Actions(driver);
		action.moveToElement(element).perform();

	}

	public void rightClick(WebDriver driver, String locator) {
		WebElement element = driver.findElement(By.xpath(locator));

		Actions action = new Actions(driver);
		action.contextClick(element).perform();

	}

	public void drapAndDrop(WebDriver driver, String sourceLocator, String targetLocator) {
		WebElement source = driver.findElement(By.xpath(sourceLocator));
		WebElement target = driver.findElement(By.xpath(targetLocator));

		Actions action = new Actions(driver);
		action.dragAndDrop(source, target).perform();

	}

	public void keyPress(WebDriver driver, String locator) {
		WebElement element = driver.findElement(By.xpath(locator));

		Actions action = new Actions(driver);
		action.sendKeys(element, Keys.ENTER);

	}

	public void upload(WebDriver driver, String locator, String filePath) {
		WebElement element = driver.findElement(By.xpath(locator));

		element.sendKeys(filePath);

	}

	public Object executeJavascriptToBrowser(WebDriver driver, String javaSript) {
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			return js.executeScript(javaSript);
		} catch (Exception e) {
			e.getMessage();
			return null;
		}
	}

	public Object clickForWebElement(WebDriver driver, WebElement element) {
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			return js.executeScript("arguments[0].click();", element);
		} catch (Exception e) {
			e.getMessage();
			return null;
		}
	}

	public Object scrollToBottom(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		return js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
	}

	public Object srollToElement(WebDriver driver, WebElement element) {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		return js.executeScript("arguments[0].style.border='2px groove green'", element);
	}

	public void hightlightElement(WebDriver driver, WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].style.border='2px groove green'", element);
	}

	public void removeAttributeNameOfElement(WebDriver driver, WebElement element, String attributeName) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].removeAttribute('" + attributeName + "');", element);

	}

	public boolean checkAnyImageLoaded(WebDriver driver, WebElement image) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		return (boolean) js.executeScript("return arguments[0].complete &&"
				+ "typeof arguments[0].naturaWidth != 'undefined' && arguments[0].naturaWidth > 0", image);
	}

	public void waitForControlVisible(WebDriver driver, String locator) {
		WebDriverWait wait = new WebDriverWait(driver, 50);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));

	}
	
	public void waitForControlVisible(WebDriver driver, String locator, String value) {
		locator = String.format(locator, value);
		System.out.println("Wait for dynamic control visible = "+ locator);
		WebDriverWait wait = new WebDriverWait(driver, 50);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));

	}
	
	
	/*Open Dynamic Page*/
	public HomePagePO openHomePage(WebDriver driver) {
		waitForControlVisible(driver, AbstractPageUI.DYNAMIC_PAGE_LINK, "Manager");
		clickToElement(driver, AbstractPageUI.DYNAMIC_PAGE_LINK, "Manager");
		return PageFactoryManager.getHomePage(driver);
		
	}
	
	public NewCustomerPagePO openNewCustomerPage(WebDriver driver) {
		waitForControlVisible(driver, AbstractPageUI.DYNAMIC_PAGE_LINK, "New Customer");
		clickToElement(driver, AbstractPageUI.DYNAMIC_PAGE_LINK, "New Customer");
		return PageFactoryManager.getNewCustomerPage(driver);
	}
	
	public EditCustomerPagePO openEditCustomerPage(WebDriver driver) {
		waitForControlVisible(driver, AbstractPageUI.DYNAMIC_PAGE_LINK, "Edit Customer");
		clickToElement(driver, AbstractPageUI.DYNAMIC_PAGE_LINK, "Edit Customer");
		return PageFactoryManager.getEditCustomerPage(driver);
	}
	
	public DeleteCustomerPagePO openDeleteCustomerPage(WebDriver driver) {
		waitForControlVisible(driver, AbstractPageUI.DYNAMIC_PAGE_LINK, "Delete Customer");
		clickToElement(driver, AbstractPageUI.DYNAMIC_PAGE_LINK, "Delete Customer");
		return PageFactoryManager.getDeleteCustomerPage(driver);
	}
	
	public NewAccountPO openNewAccountPage(WebDriver driver) {
		waitForControlVisible(driver, AbstractPageUI.DYNAMIC_PAGE_LINK, "New Account");
		clickToElement(driver, AbstractPageUI.DYNAMIC_PAGE_LINK, "New Account");
		return PageFactoryManager.getNewAccountPage(driver);
	}
	
	public EditAccountPO openEditAccountPage(WebDriver driver) {
		waitForControlVisible(driver, AbstractPageUI.DYNAMIC_PAGE_LINK, "Edit Account");
		clickToElement(driver, AbstractPageUI.DYNAMIC_PAGE_LINK, "Edit Account");
		return PageFactoryManager.getEditAccountPage(driver);
	}
	
	public DeleteAccountPO openDeleteAccountPage(WebDriver driver) {
		waitForControlVisible(driver, AbstractPageUI.DYNAMIC_PAGE_LINK, "Delete Account");
		clickToElement(driver, AbstractPageUI.DYNAMIC_PAGE_LINK, "Delete Account");
		return PageFactoryManager.getDeleteAccountPage(driver);
	}
	
	public DepositPO openDepositPage(WebDriver driver) {
		waitForControlVisible(driver, AbstractPageUI.DYNAMIC_PAGE_LINK, "Deposit");
		clickToElement(driver, AbstractPageUI.DYNAMIC_PAGE_LINK, "Deposit");
		return PageFactoryManager.getDepositPage(driver);
	}
	
	public WithdrawalPO openWithdrawalPage(WebDriver driver) {
		waitForControlVisible(driver, AbstractPageUI.DYNAMIC_PAGE_LINK, "Withdrawal");
		clickToElement(driver, AbstractPageUI.DYNAMIC_PAGE_LINK, "Withdrawal");
		return PageFactoryManager.getWithdrawalPage(driver);
	}
	
	public FundTransferPO openFundTransferPage(WebDriver driver) {
		waitForControlVisible(driver, AbstractPageUI.DYNAMIC_PAGE_LINK, "Fund Transfer");
		clickToElement(driver, AbstractPageUI.DYNAMIC_PAGE_LINK, "Fund Transfer");
		return PageFactoryManager.getFundTransferPage(driver);
	}
	
	public ChangePasswordPO openChangePasswordPage(WebDriver driver) {
		waitForControlVisible(driver, AbstractPageUI.DYNAMIC_PAGE_LINK, "Change Password");
		clickToElement(driver, AbstractPageUI.DYNAMIC_PAGE_LINK, "Change Password");
		return PageFactoryManager.getChangePasswordPage(driver);
	}
	
	public BalanceEnquiryPO openBalanceEnquirydPage(WebDriver driver) {
		waitForControlVisible(driver, AbstractPageUI.DYNAMIC_PAGE_LINK, "Balance Enquiry");
		clickToElement(driver, AbstractPageUI.DYNAMIC_PAGE_LINK, "Balance Enquiry");
		return PageFactoryManager.getBalanceEnquiryPage(driver);
	}
	
	public MiniStatementPO openMiniStatementPage(WebDriver driver) {
		waitForControlVisible(driver, AbstractPageUI.DYNAMIC_PAGE_LINK, "Mini Statement");
		clickToElement(driver, AbstractPageUI.DYNAMIC_PAGE_LINK, "Mini Statement");
		return PageFactoryManager.getMiniStatementPage(driver);
	}
	
	public CustomisedStatementPO openCustomisedStatementPage(WebDriver driver) {
		waitForControlVisible(driver, AbstractPageUI.DYNAMIC_PAGE_LINK, "Customised Statement");
		clickToElement(driver, AbstractPageUI.DYNAMIC_PAGE_LINK, "Customised Statement");
		return PageFactoryManager.getCustomisedStatementPage(driver);
	}
	
	public LoginPagePO openLogOutPage(WebDriver driver) {
		waitForControlVisible(driver, AbstractPageUI.DYNAMIC_PAGE_LINK, "Log out");
		clickToElement(driver, AbstractPageUI.DYNAMIC_PAGE_LINK, "Log out");
		acceptAlert(driver);
		waitForControlVisible(driver, AbstractPageUI.LOGIN_PAGE_FORM);
		return PageFactoryManager.getLoginPage(driver);
	}
	
	

	

}
