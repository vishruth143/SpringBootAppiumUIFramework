package com.ea.SpringBootAppiumUIFramework.steps;

import com.ea.SpringBootAppiumUIFramework.pages.HomePage;
import io.cucumber.java.en.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoginSteps {

    private static final Logger logger = LoggerFactory.getLogger(LoginSteps.class);

    @Autowired
    private HomePage homePage;

    @Given("I click login in Home page")
    public void iClickLoginInHomePage() {
        logger.info("I click login in Home page");
        homePage.clickLogin();
    }
}
