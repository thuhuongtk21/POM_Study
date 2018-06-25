package com.bankguru.login;

public class DynamicLocator {

	public static void main(String[] args) {
		String locator = "//ul[@class='%s']//a[text()='%s']";
		openDynamicPage(locator, "menusubnav", "Manager");
//		openDynamicPage(locator, "New Customer");
//		openDynamicPage(locator, "Edit Customer");
//		openDynamicPage(locator, "Delete Customer");
//		openDynamicPage(locator, "New Account");
//		openDynamicPage(locator, "Edit Account");
		

	}
	
	public static void openDynamicPage(String locator, String pageName1, String pageName2) {
		locator = String.format(locator, pageName1, pageName2);
		System.out.println(locator);
	}

}
