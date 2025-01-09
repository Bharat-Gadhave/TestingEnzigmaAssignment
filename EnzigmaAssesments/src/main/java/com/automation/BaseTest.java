package com.automation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	public static void main(String args[]) {

		WebDriverManager.chromedriver().browserVersion("114").setup();
		
		WebDriver driver = new ChromeDriver();
		//after hitting "https://app-staging.nokodr.com/" this url it redirecting automatically to below url
		driver.get("https://app-staging.nokodr.com/super/apps/auth/v1/index.html#/login");
		
		driver.manage().window().maximize();

		driver.quit();
	}
}
