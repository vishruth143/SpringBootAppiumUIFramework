package com.ea.SpringBootAppiumUIFramework.pages;

import com.ea.SpringBootAppiumUIFramework.extensions.UIElementExtensions;
import org.openqa.selenium.By;
import org.springframework.stereotype.Component;

@Component
public class HomePage extends BasePage {

//*******************************************************(Web Elements)*************************************************
//-------------------------------------------------------Link-----------------------------------------------------------
    private final By lnkLogin = By.xpath("//a[text()='Login']");

//*******************************************************(Actions)******************************************************
//-------------------------------------------------------Click----------------------------------------------------------
    public void clickLogin() {
        UIElementExtensions.performClick(driver, lnkLogin);
    }
}
