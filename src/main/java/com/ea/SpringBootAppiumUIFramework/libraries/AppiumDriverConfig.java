package com.ea.SpringBootAppiumUIFramework.libraries;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class AppiumDriverConfig {

    @Value("${app.url}") private String appUrl;
    @Value("${appium.deviceName}") private String deviceName;
    @Value("${appium.udid}") private String udid;
    @Value("${appium.platformVersion}") private String platformVersion;
    @Value("${appium.serverUrl}") private String appiumServerUrl;
    @Value("${use.sauce.labs}") private String useSauceLabs;
    @Value("${sauce.username}") private String sauceUsername;
    @Value("${sauce.accessKey}") private String sauceAccessKey;

    @Bean
    public WebDriver webDriver() {
        try {
            if (!Boolean.parseBoolean(useSauceLabs)){
                // Local Appium with emulator
                UiAutomator2Options options = new UiAutomator2Options();
                options.setPlatformName("Android");
                options.setDeviceName(deviceName);
                options.setUdid(udid);
                options.setPlatformVersion(platformVersion);
                options.setNewCommandTimeout(Duration.ofSeconds(60));
                options.setCapability("browserName", "Chrome");
                options.setCapability("chromedriverExecutable",
                        "C:\\Eclipse\\worskspace\\SpringBootAppiumUIFramework\\src\\test\\resources\\ChromeDriver\\chromedriver.exe");

                URI uri = URI.create(appiumServerUrl);
                AndroidDriver driver = new AndroidDriver(uri.toURL(), options);
                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
                driver.get(appUrl);
                return driver;
            }
            else {
                // Sauce Labs setup
                AndroidDriver driver = getWebDriver();
                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
                driver.get(appUrl);
                return driver;
            }
        } catch (Exception e) {
            throw new RuntimeException("Failed to create AndroidDriver for Appium: " + e.getMessage(), e);
        }
    }

    private AndroidDriver getWebDriver() throws MalformedURLException {
        MutableCapabilities caps = new MutableCapabilities();
        caps.setCapability("platformName", "Android");
        caps.setCapability("browserName", "Chrome");
        caps.setCapability("appium:deviceName", "Android GoogleAPI Emulator");
        caps.setCapability("appium:platformVersion", platformVersion);
        caps.setCapability("appium:automationName", "UIAutomator2");

        MutableCapabilities sauceOptions = new MutableCapabilities();
        sauceOptions.setCapability("username", sauceUsername);
        sauceOptions.setCapability("accessKey", sauceAccessKey);
        sauceOptions.setCapability("build", "SpringBootAppium Build");
        sauceOptions.setCapability("name", "Sauce Labs Tablet Test");
        sauceOptions.setCapability("deviceOrientation", "PORTRAIT");
        caps.setCapability("sauce:options", sauceOptions);

        URI uri = URI.create("https://ondemand.us-west-1.saucelabs.com:443/wd/hub");
        return new AndroidDriver(uri.toURL(), caps);
    }
}
