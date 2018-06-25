package commons;

import org.openqa.selenium.WebDriver;

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
import pages.RegisterPagePO;
import pages.WithdrawalPO;

public class PageFactoryManager {
	private static HomePagePO homePage;
	private static LoginPagePO loginPage;
	private static RegisterPagePO registerPage;
	private static NewCustomerPagePO newCustomerPage;
	private static EditCustomerPagePO editCustomerPage;
	private static DeleteCustomerPagePO deleteCustomerPage;
	private static NewAccountPO newAccountPage;
	private static EditAccountPO editAccountPage;
	private static DeleteAccountPO deleteAccountPage;
	private static DepositPO depositPage;
	private static WithdrawalPO withdrawalPage;
	private static FundTransferPO fundTransferPage;
	private static ChangePasswordPO changePasswordPage;
	private static BalanceEnquiryPO balanceEnquiryPage;
	private static MiniStatementPO miniStatementPage;
	private static CustomisedStatementPO customisedStatementPage;

	
	
	
	public static HomePagePO getHomePage(WebDriver driver_) {
		if(homePage==null) {
			return new HomePagePO(driver_);
		}
		return homePage;
	}
	
	public static LoginPagePO getLoginPage(WebDriver driver_) {
		if(loginPage==null) {
			return new LoginPagePO(driver_);
		}
		return loginPage;
	}
	
	public static RegisterPagePO getRegisterPage(WebDriver driver_) {
		if(loginPage==null) {
			return new RegisterPagePO(driver_);
		}
		return registerPage;
	}
	
	public static NewCustomerPagePO getNewCustomerPage(WebDriver driver_) {
		if(newCustomerPage==null) {
			return new NewCustomerPagePO(driver_);
		}
		return newCustomerPage;
	}
	
	public static EditCustomerPagePO getEditCustomerPage(WebDriver driver_) {
		if(editCustomerPage==null) {
			return new EditCustomerPagePO(driver_);
		}
		return editCustomerPage;
	}
	
	public static DeleteCustomerPagePO getDeleteCustomerPage(WebDriver driver_) {
		if(deleteCustomerPage==null) {
			return new DeleteCustomerPagePO(driver_);
		}
		return deleteCustomerPage;
	}
	
	public static NewAccountPO getNewAccountPage(WebDriver driver_) {
		if(newAccountPage==null) {
			return new NewAccountPO(driver_);
		}
		return newAccountPage;
	}
	
	public static EditAccountPO getEditAccountPage(WebDriver driver_) {
		if(editAccountPage==null) {
			return new EditAccountPO(driver_);
		}
		return editAccountPage;
	}
	
	public static DeleteAccountPO getDeleteAccountPage(WebDriver driver_) {
		if(deleteAccountPage==null) {
			return new DeleteAccountPO(driver_);
		}
		return deleteAccountPage;
	}
	
	public static DepositPO getDepositPage(WebDriver driver_) {
		if(depositPage==null) {
			return new DepositPO(driver_);
		}
		return depositPage;
	}
	
	public static WithdrawalPO getWithdrawalPage(WebDriver driver_) {
		if(withdrawalPage==null) {
			return new WithdrawalPO(driver_);
		}
		return withdrawalPage;
	}
	
	public static FundTransferPO getFundTransferPage(WebDriver driver_) {
		if(fundTransferPage==null) {
			return new FundTransferPO(driver_);
		}
		return fundTransferPage;
	}
	
	public static ChangePasswordPO getChangePasswordPage(WebDriver driver_) {
		if(changePasswordPage==null) {
			return new ChangePasswordPO(driver_);
		}
		return changePasswordPage;
	}
	
	public static BalanceEnquiryPO getBalanceEnquiryPage(WebDriver driver_) {
		if(balanceEnquiryPage==null) {
			return new BalanceEnquiryPO(driver_);
		}
		return balanceEnquiryPage;
	}
	
	public static MiniStatementPO getMiniStatementPage(WebDriver driver_) {
		if(miniStatementPage==null) {
			return new MiniStatementPO(driver_);
		}
		return miniStatementPage;
	}
	
	public static CustomisedStatementPO getCustomisedStatementPage(WebDriver driver_) {
		if(customisedStatementPage==null) {
			return new CustomisedStatementPO(driver_);
		}
		return customisedStatementPage;
	}
	
	

}
