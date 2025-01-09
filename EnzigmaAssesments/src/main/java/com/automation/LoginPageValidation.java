package com.automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginPageValidation {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().browserVersion("114").setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://app-staging.nokodr.com/super/apps/auth/v1/index.html#/login");

        WebElement usernameField = driver.findElement(By.name("username"));
        WebElement passwordField = driver.findElement(By.xpath("//input[@type='password']"));
        WebElement loginButton = driver.findElement(By.xpath("//button[contains(@class, 'slds-button_brand')]"));
        
        usernameField.sendKeys("bharatgadhave777@gmail.com");
        passwordField.sendKeys("Bharat@12345");
        loginButton.click();
        
        WebElement dashboard = driver.findElement(By.id("dashboard"));
        if (dashboard.isDisplayed()) {
            System.out.println("Login successful.");
        }

        usernameField.clear();
        passwordField.clear();
        usernameField.sendKeys("invalidUser");
        passwordField.sendKeys("InvalidPass123");
        loginButton.click();
        
        WebElement errorMessage = driver.findElement(By.id("errorMessage"));
        if (errorMessage.isDisplayed()) {
            System.out.println("Error: Invalid username or password.");
        }

        driver.quit();
    }
}
