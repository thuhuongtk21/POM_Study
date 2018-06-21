package com.bankguru.login;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Login_01_CreateUserAndLogin {
  WebDriver driver;
  String userID, passWord, loginUrl;

  @BeforeClass
  public void beforeClass() {
	  driver = new FirefoxDriver();
	  driver.manage().window().maximize();
	  driver.get("http://demo.guru99.com/v4/");
	  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }
  @Test
  public void TC_Login01_CreateUser() {
	  loginUrl = driver.getCurrentUrl();
	  driver.findElement(By.xpath("//a[text()='here']")).click();
	  driver.findElement(By.xpath("//input[@name='emailid']")).sendKeys("automation" +randomNumber()+ "@gmail.com");
	  driver.findElement(By.xpath("//input[@name ='btnLogin']")).click();
	  
	  Assert.assertTrue(driver.findElement(By.xpath("//h2[text()='Access details to demo site.']")).isDisplayed());
	  
	  userID = driver.findElement(By.xpath("//td[text()='User ID :']/following-sibling::td")).getText();
	  passWord = driver.findElement(By.xpath("//td[text()='Password :']/following-sibling::td")).getText();
  }
  
  public void TC_Login02_LoginToApplication() {
	  driver.get(loginUrl);
	  
	  driver.findElement(By.xpath("//input[@name='uid']")).sendKeys(userID);
	  driver.findElement(By.xpath("//input[@name='password']")).sendKeys(passWord);
	  driver.findElement(By.xpath("//input[@name='btnLogin']")).click();
	  
	  WebElement loginMessage = driver.findElement(By.xpath("//marquee"));
	  Assert.assertEquals("Welcome To Manager's Page of Guru99 Bank<", loginMessage.getText());
	  
	  WebElement containUserID = driver.findElement(By.xpath("//td[text()='Manger Id : \"+userID+\"']"));
	  Assert.assertEquals("Manger Id : "+userID+"", containUserID);
	
  }
  
  

  @AfterClass
  public void afterClass() {
	  driver.close();
  }

  public int randomNumber() {
	  Random random = new Random();
	  int number = random.nextInt(999999);
	  return number;
  }
}
