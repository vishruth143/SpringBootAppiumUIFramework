package com.ea.SpringBootAppiumUIFramework.runner;

import com.ea.SpringBootAppiumUIFramework.utils.AppiumServerManager;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

@CucumberOptions(
        features = {"src/test/java/com/ea/SpringBootAppiumUIFramework/features"},
        glue = "com.ea.SpringBootAppiumUIFramework.steps",
        plugin = {
            "pretty",                                          // ✅ Console readable format
            "json:target/cucumber-reports/cucumber.json",      // ✅ JSON for advanced reporting if needed
            "html:target/cucumber-reports/cucumber.html",      // ✅  HTML report
            "junit:target/cucumber-reports/cucumber.xml"       // ✅ Optional: JUnit format
        },
        monochrome = true
)

public class TestRunner extends AbstractTestNGCucumberTests {

        @BeforeSuite
        public void startAppiumServer() {
                System.out.println("Starting Appium server...");
                AppiumServerManager.startServer();
        }

        @AfterSuite
        public void stopAppiumServer() {
                System.out.println("Stopping Appium server...");
                AppiumServerManager.stopServer();
        }

}
