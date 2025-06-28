package com.ea.SpringBootAppiumUIFramework.pages;

import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;

public class BasePage {

    @Autowired
    protected WebDriver driver;

    // Common methods for all pages can go here
}

