package com.automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ForgotPasswordValidation {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://app-staging.nokodr.com/super/apps/auth/v1/index.html#/forgot-password");

        WebElement emailField = driver.findElement(By.xpath("//abx-email//input[@type='email']\r\n"
        		+ ""));
        WebElement submitButton = driver.findElement(By.xpath("//button[contains(@class, 'slds-button_brand') and contains(@class, 'slds-button')]\r\n"
        		+ ""));;

        emailField.sendKeys("bharat@gmail.com");
        submitButton.click();

        WebElement successMessage = driver.findElement(By.id("successMessage"));
        if (successMessage.isDisplayed()) {
            System.out.println("Password reset link sent to the email.");
        }

        emailField.clear();
        emailField.sendKeys("nonregisteredemail@example.com");
        submitButton.click();
        
        WebElement errorMessage = driver.findElement(By.id("errorMessage"));
        if (errorMessage.isDisplayed()) {
            System.out.println("Error: Email not registered.");
        }

        emailField.clear();
        emailField.sendKeys("invalidemail.com");
        submitButton.click();

        if (errorMessage.isDisplayed()) {
            System.out.println("Error: Invalid email format.");
        }

        emailField.clear();
        submitButton.click();

        if (errorMessage.isDisplayed()) {
            System.out.println("Error: Email field cannot be empty.");
        }

        driver.quit();
    }
}
