package commons;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import commons.Constants;

public class AbstractTest {
	WebDriver driver;
	
	  public WebDriver openMultiBrowser(String browser) {
		  if(browser.equals("firefox")) {
			  driver = new FirefoxDriver();
		  }else if(browser.equals("chrome")) {
			  System.setProperty("webdriver.chrome.driver", ".\\resources\\chromedriver.exe");
			  driver = new ChromeDriver();
		  }else {
			  System.setProperty("webdriver.ie.driver", ".\\resources\\IEDriverServer.exe");
			  driver = new InternetExplorerDriver();
		  }
		  
		  driver.manage().window().maximize();
		  driver.get(Constants.URL);
		  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		  return driver;
	  }

}
