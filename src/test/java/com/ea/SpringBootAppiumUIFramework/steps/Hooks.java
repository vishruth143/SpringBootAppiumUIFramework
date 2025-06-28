package com.ea.SpringBootAppiumUIFramework.steps;

import com.ea.SpringBootAppiumUIFramework.utils.ScreenshotUtil;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

public class Hooks {

    @Autowired
    private WebDriver driver;

    @Value("${app.url}")
    private String url;

    @Before
    public void InitializeTest(Scenario scenario) {
        System.out.println("Hooks->InitializeTest");
        driver.get(url);
    }

    @After
    public void TearDownTest(Scenario scenario) {
        System.out.println("Hooks->TearDownTest");
        if (scenario.isFailed()) {
            ScreenshotUtil.takeScreenshot(driver, scenario.getName());
            System.out.println(scenario.getName()+" - Failed!");
        }
        driver.quit();
    }
}
