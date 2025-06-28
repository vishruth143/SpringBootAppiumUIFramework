package com.ea.SpringBootAppiumUIFramework.libraries;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.net.URL;
import java.time.Duration;

@Configuration
public class AppiumDriverConfig {

    @Value("${app.url}") private String appUrl;
    @Value("${appium.deviceName}") private String deviceName;
    @Value("${appium.udid}") private String udid;
    @Value("${appium.platformVersion}") private String platformVersion;
    @Value("${appium.serverUrl}") private String appiumServerUrl;

    @Bean
    public WebDriver webDriver() {
        try {
            UiAutomator2Options options = new UiAutomator2Options();
            options.setPlatformName("Android");
            options.setDeviceName(deviceName);
            options.setUdid(udid);
            options.setPlatformVersion(platformVersion);
            options.setNewCommandTimeout(Duration.ofSeconds(60));
            options.setCapability("browserName", "Chrome");
            options.setCapability("chromedriverExecutable",
                    "C:\\Eclipse\\worskspace\\SpringBootAppiumUIFramework\\src\\test\\resources\\ChromeDriver\\chromedriver.exe");

            AndroidDriver driver = new AndroidDriver(new URL(appiumServerUrl), options);
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            driver.get(appUrl);
            return driver;
        } catch (Exception e) {
            throw new RuntimeException("Failed to create AndroidDriver for Appium: " + e.getMessage(), e);
        }
    }
}
