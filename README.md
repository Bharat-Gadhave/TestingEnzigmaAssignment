# Selenium Automation Testing Assignment

## Overview
This project automates various test scenarios for the noKodr platform using **Selenium WebDriver** and **TestNG** with **Maven** as the build tool. The tests include validations for Signup, Login, and Forgot Password functionalities.

---

## Prerequisites
Ensure the following tools and dependencies are installed on your system:

1. **Java Development Kit (JDK)** (Version 8 or higher)
2. **Maven** (Version 3.6 or higher)
3. **Eclipse IDE** (or any preferred IDE)
4. **Google Chrome** (Version 131.0.6778.205 or compatible version)
5. **ChromeDriver** (Managed automatically by WebDriverManager)

---

## Dependencies
Add the following dependencies to your `pom.xml`:

```xml
<dependencies>
    <!-- Selenium WebDriver -->
    <dependency>
        <groupId>org.seleniumhq.selenium</groupId>
        <artifactId>selenium-java</artifactId>
        <version>4.0.0</version>
    </dependency>

    <!-- WebDriverManager -->
    <dependency>
        <groupId>io.github.bonigarcia</groupId>
        <artifactId>webdrivermanager</artifactId>
        <version>5.0.3</version>
    </dependency>

    <!-- TestNG -->
    <dependency>
        <groupId>org.testng</groupId>
        <artifactId>testng</artifactId>
        <version>7.8.0</version>
        <scope>test</scope>
    </dependency>
</dependencies>
```

---

## Project Structure

```
selenium-automation-testing
├── src
│   ├── main
│   │   └── java
│   │       └── com
│   │           └── automation
│   │               ├── BasicScript.java
│   │               ├── SignupPageValidation.java
│   │               ├── LoginPageValidation.java
│   │               └── ForgotPasswordValidation.java
│   └── test
│       └── java
│           └── com
│               └── automation
│                   └── TestRunner.java
├── pom.xml
└── README.md
```

---

## Features
### 1. Basic Script
- Opens the Chrome browser and navigates to the noKodr platform.

### 2. Signup Page Validation
- Validates mandatory fields and field-specific formats.
- Tests both valid and invalid inputs.
- Verifies success and error messages.

### 3. Login Page Validation
- Validates username and password fields.
- Tests various combinations of valid and invalid credentials.
- Verifies redirection or error messages.

### 4. Forgot Password Validation
- Validates the email field for mandatory and format checks.
- Tests valid and invalid email inputs.
- Verifies success and error messages.

---

## How to Run the Project

1. **Clone the Repository**
   ```bash
   git clone <repository-url>
   cd selenium-automation-testing
   ```

2. **Import into Eclipse**
   - Open Eclipse IDE.
   - Go to `File > Import > Existing Maven Projects`.
   - Select the project folder and click `Finish`.

3. **Run the Tests**
   - Right-click on any test class (e.g., `SignupPageValidation.java`) and select `Run As > TestNG Test`.

4. **Run All Tests**
   - Right-click on `TestRunner.java` and select `Run As > TestNG Test`.

---

## Notes
- Make sure your Chrome browser version matches the ChromeDriver version managed by WebDriverManager.
- TestNG annotations such as `@Test`, `@BeforeMethod`, and `@AfterMethod` are used to structure the test flow.
- Output logs and test results will be displayed in the console.

---

## Contribution
Feel free to fork this repository and submit pull requests to enhance the project.

---

## License
This project is licensed under the MIT License. See the LICENSE file for details.

