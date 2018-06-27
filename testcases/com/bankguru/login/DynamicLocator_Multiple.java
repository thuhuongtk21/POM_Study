package com.bankguru.login;

public class DynamicLocator_Multiple {
	
	public static void main(String[] args) {
		String locator_fixed_param = "//ul[@class= menusubnav]//a[text()='Manager']";
		String locator_one_param = "//ul[@class= menusubnav]//a[text()='%s']";
		String locator_2_param = "//ul[@class= '%s']//a[text()='%s']";
		openDynamicPage(locator_fixed_param);
		openDynamicPage(locator_one_param, "Manager");
		openDynamicPage(locator_2_param, "locator1", "locator2");

	}
	
	public static void openDynamicPage(String locator) {
		System.out.println("Fixed locator =" + locator);
	}
	
	//Rest parameter
	public static void openDynamicPage(String locator, String... value) {
		locator = String.format(locator, (Object[])value);
		System.out.println(locator);
	}


}
