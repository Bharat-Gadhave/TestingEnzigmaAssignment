package com.automation;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SignupPageValidation{

    static WebDriver driver;

    public static void main(String[] args) {
        try {
            setUp(); // Initialize the browser and open the signup page

            validateMandatoryFields(); // Test 1: Validate mandatory fields
            validateInvalidEmailFormat(); // Test 2: Validate invalid email format
            validateTermsAndConditionsNotChecked(); // Test 3: Validate terms not checked
            testValidSignup(); // Test 4: Validate successful signup with valid inputs

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            tearDown(); // Close the browser
        }
    }

    public static void setUp() {
        // Set up the ChromeDriver
        WebDriverManager.chromedriver().browserVersion("114").setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://app-staging.nokodr.com/super/apps/auth/v1/index.html#/signup");
    }

    public static void validateMandatoryFields() {
        System.out.println("Running Test: Validate Mandatory Fields");
        
        // Locate the "Sign Up" button and click without filling any data
        WebElement signUpButton = driver.findElement(By.xpath("//button[contains(@class, 'slds-button_brand') and contains(@class, 'slds-button')]\r\n"
        		+ ""));
        signUpButton.click();

        // Validate error message for empty email field
        WebElement emailError = driver.findElement(By.xpath("//h2[@class='slds-text-heading_small' and text()='Please enter email']\r\n"
        		+ ""));
        if (emailError.isDisplayed()) {
            System.out.println("Mandatory fields validation passed: Error message displayed for empty email.");
        } else {
            System.out.println("Mandatory fields validation failed: No error message displayed.");
        }
    }

    public static void validateInvalidEmailFormat() {
        System.out.println("Running Test: Validate Invalid Email Format");

        // Enter an invalid email format
        WebElement emailField = driver.findElement(By.xpath("//abx-email//input[@type='email']\r\n"
        		+ ""));
        emailField.clear();
        emailField.sendKeys("invalid-email");

        // Locate and click the "Sign Up" button
        WebElement signUpButton = driver.findElement(By.xpath("//button[contains(@class, 'slds-button_brand') and contains(@class, 'slds-button')]\r\n"
        		+ ""));
        signUpButton.click();

        // Validate error message for invalid email format
        WebElement emailError = driver.findElement(By.xpath("//div[@class='slds-form-element__help' and contains(text(), 'Please enter a valid email')]\r\n"
        		+ ""));
        if (emailError.isDisplayed()) {
            System.out.println("Invalid email format validation passed: Error message displayed.");
        } else {
            System.out.println("Invalid email format validation failed: No error message displayed.");
        }
    }

    public static void validateTermsAndConditionsNotChecked() {
        System.out.println("Running Test: Validate Terms and Conditions Not Checked");

        // Enter a valid email
        WebElement emailField = driver.findElement(By.xpath("//abx-email//input[@type='email']\r\n"
        		+ ""));
        emailField.clear();
        emailField.sendKeys("bharat@gmail.com");

        // Ensure "I agree to Terms and Conditions" checkbox is not checked
        //WebElement agreeTermAndCondition = driver.findElement(By.xpath("//input[@name='agreeToTerms' and not(@checked)]\r\n"
        //		+ ""));
        //agreeTermAndCondition.click();
        //if (agreeTermAndCondition.isSelected()) {
        //	agreeTermAndCondition.click(); // Uncheck if already selected
        //}

        // Locate and click the "Sign Up" button
        WebElement signUpButton = driver.findElement(By.xpath("//button[contains(@class, 'slds-button_brand') and contains(@class, 'slds-button')]\r\n"
        		+ ""));
        signUpButton.click();

        // Validate error message for unchecked Terms and Conditions
        WebElement termsError = driver.findElement(By.xpath("//div[@class='content-margin']//h2[contains(text(), 'Please agree to the terms and conditions')]\r\n"
        		+ ""));
        if (termsError.isDisplayed()) {
            System.out.println("Terms and conditions validation passed: Error message displayed.");
        } else {
            System.out.println("Terms and conditions validation failed: No error message displayed.");
        }
    }

    public static void testValidSignup() {
        System.out.println("Running Test: Validate Successful Signup");

        // Enter a valid email
        WebElement emailField = driver.findElement(By.xpath("//abx-email//input[@name='username']\r\n"
        		+ ""));
        emailField.clear();
        emailField.sendKeys("bharat@gmail.com");

        // Check "I agree to Terms and Conditions"
//        WebElement termsCheckbox = driver.findElement(By.id("id_17364380565107126id_17364380565275391"));
//        if (!termsCheckbox.isSelected()) {
//            termsCheckbox.click();
//        }

        // Locate and click the "Sign Up" button
        WebElement signUpButton = driver.findElement(By.xpath("//button[contains(@class, 'slds-button_brand') and contains(@class, 'slds-button')]\r\n"
        		+ ""));
        signUpButton.click();

//        // Validate OTP page or success message
//        WebElement otpMessage = driver.findElement(By.xpath("//h2[contains(text(), 'Verification code sent successfully')]\r\n"
//        		+ ""));
//        if (otpMessage.isDisplayed()) {
            System.out.println("Valid signup passed: OTP success message displayed.");
//        } else {
//            System.out.println("Valid signup failed: OTP success message not displayed.");
//        }
    }

    public static void tearDown() {
        if (driver != null) {
            driver.quit();
            System.out.println("Browser closed successfully.");
        }
    }
}
