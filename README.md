# Spring Boot Appium UI Framework

This project is a test automation framework that combines Spring Boot with Appium, designed to provide a robust and scalable solution for web application testing on mobile/tablet devices.

## Project Structure

```
SpringBootAppiumUIFramework/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/
│   │   │       └── ea/
│   │   │           └── SpringBootAppiumUIFramework
│   │   │               └── extensions/
│   │   │               │   └── UIElementExtensions.java
│   │   │               │   └── WaitHelper.java 
│   │   │               └── libraries/
│   │   │               │   └── AppiumDriverConfig.java 
│   │   │               └── utils/
│   │   │               │   └── AppiumServerManager.java 
│   │   │               │   └── ConfigPParser.java 
│   │   │               │   └── ScreenshotUtil.java   
│   │   │               └── SpringBootAppiumUIFrameworkApplication.java
│   │   └── resources/
│   │       ├── application.properties
│   │       ├── application-qa.properties
│   │       └── application-prod.properties
│   └── test/
│       └── java/
│           └── com/
│           │   └── ea/
│           │        └── SpringBootAppiumUIFramework/
│           │            │└── features
│           │            │├── Login.feature  
│           │            └── pages/
│           │            │    ├── BasePage.java
│           │            │    ├── LoginPage.java
│           │            │    ├── HomePage.java
│           │            │    ├── EmployeeListPage.java
│           │            │    └── CreateEmployeePage.java
│           │            └── runner/
│           │            │   ├── TestRunner.java  
│           │            └── steps/
│           │            │   ├── CucumberTestContextConfig.java 
│           │            │   ├── Hooks.java 
│           │            │   ├── LoginSteps.java
│           │            └── SpringBootAppiumUIFrameworkApplicationTestNGTests.java
│           │            └── SpringBootAppiumUIFrameworkApplicationTests.java
│           └── resources/
│           │   └── drivers/
│           │       ├── chromedriver.exe
│           │   └── config/
│           │       ├── ui_test_data_config.yml
│               │──testng.xml
├── pom.xml
├── mvnw
├── mvnw.cmd
├── .gitignore
└── .gitattributes
```

## Features

- Integration of Spring Boot with Appium
- Page Object Model (POM) design pattern for better maintainability
- Configurable WebDriver setup
- Custom UI element extensions for enhanced functionality
- Support for multiple environments (dev, prod) through Spring profiles

## Prerequisites

- Java 21
- Maven 3.9.9
- Your favorite IDE (IntelliJ IDEA, Eclipse, etc.)
- ---

# 🪜 Step-by-Step Setup.

---
## 🚀 Install Node JS

---

## 🚀 Install Appium Server
```bash
    npm install -g appium
    appium --version
    appium
```
---

## 🚀 Install UIAutomator2 and XCUITest Driver
```bash
    appium driver install uiautomator2
    appium driver install xcuitest
    appium driver list --installed 
```
---   
## 🚀 Install Appium Inspector
    1. Search 'appium-inspector' on google
    2. Visit the link https://github.com/appium/appium-inspector
    3. Under 'Installation' section click on 'Releases'
    4. Under 'Assets' section click on 'Appium-Inspector-2025.3.1-win-x64.exe'
---   
## 🚀 Android Studio Installation
    1. Search 'android studio' on google
    2. Download android studio and install
---   
## 🚀 Add ANDROID_HOME variable to System variables
    ANDROID_HOME=C:\Users\Vishvambruth_Javagal\AppData\Local\Android\Sdk
---  
## 🚀 Add below to Path variable
    %ANDROID_HOME%\platforms
    %ANDROID_HOME%\platform-tools
    %ANDROID_HOME%\emulator
---  
## 🚀 Emulator Setup
    1. Open the Android Studio.
    2. Go to 'Tools' and Click on the 'Device Manager'.
    3. Select + Add a new device 'Create Virtual Device'.
    4. Select the required device and 'Select system image'.
    5. Click on 'Finish' the device will be added.
---  
## 🚀 Appium Inspector
    1. Remote Host: 127.0.0.1
    2. Remote Port: 4723
    3. Remote Path
    4. JSON Representation
        {
        "automationName" : "uiautomator2",
        "platformName" : "Android",
        "deviceName" : "Pixel 9 Pro XL",
        "udid" : "emulator-5554",
        "appPackage" : "com.code2lead.kwad" ,
        "appActivity" : "com.code2lead.kwad.MainActivity"       
        }
--- 
# 📱 Appium Commands

## 🔧 Install Appium Drivers
```bash
    appium driver install uiautomator2
    appium driver install xcuitest 
    appium driver install chromium
    appium driver install gecko
    appium driver install safari
    appium driver install espresso
    appium driver install mac2
```
## 🔄 Update a Driver
```bash
    appium driver update chromium
```
## 📋 List Installed Drivers
```bash
    appium driver list
    appium driver list --installed
```

# 📲 Android Device & Emulator Commands
## 🔍 View Connected Devices and Emulators
```bash
    adb devices
```  
## 🔍 To get the 'appium.platformVersion'
```bash
    adb shell getprop ro.build.version.release
```

## Getting Started

1. Clone the repository:
   ```
   git clone https://github.com/vishruth143/SpringBootAppiumUIFramework.git
   ```

2. Navigate to the project directory:
   ```
   cd SpringBootAppiumUIFramework
   ```

3. Build the project:
   ```
   mvn clean install
   ```

4. Run tests:
   ```
   mvn clean test
   mvn clean test "-Dspring.profiles.active=qa"
   mvn clean test "-Dspring.profiles.active=prod"
   mvn clean verify "-Dspring.profiles.active=qa"
   mvn clean verify "-Dspring.profiles.active=prod"
   ```

## Configuration

- `application.properties`: Contains default configuration properties
- `application-qa.properties`: Contains qa-specific properties
- `application-prod.properties`: Contains production-specific properties
- `WebDriverConfig.java`: Configure Selenium WebDriver options

## Writing Tests

1. Create new page objects in the `pages` package as needed
2. Extend `BasePage` for common functionalities
3. Write test classes using the page objects and Spring Boot's testing annotations

## Acknowledgments

- Spring Boot
- Selenium WebDriver
- Cucumber
- Maven
- JUnit/TestNG