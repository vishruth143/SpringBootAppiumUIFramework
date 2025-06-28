package com.ea.SpringBootAppiumUIFramework.pages;

import com.ea.SpringBootAppiumUIFramework.extensions.UIElementExtensions;
import com.ea.SpringBootAppiumUIFramework.extensions.WaitHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.springframework.stereotype.Component;

@Component
public class HomePage extends BasePage {

//*******************************************************(Web Elements)*************************************************
//-------------------------------------------------------Link-----------------------------------------------------------
    private final By lnkLogin = By.linkText("Login");
    private final By lnkEmployeeList = By.linkText("Employee List");
    private final By lnkEmployeeDetails = By.linkText("Employee Details");

//*******************************************************(Actions)******************************************************
//-------------------------------------------------------Click----------------------------------------------------------
    public void clickLogin() {
        UIElementExtensions.performClick(driver, lnkLogin);
    }

    public void clickEmployeeList(){
        UIElementExtensions.performClick(driver, lnkEmployeeList);
    }
//-------------------------------------------------------Exists---------------------------------------------------------
    public boolean isEmployeeDetailsExists() {
        WebElement element = WaitHelper.waitForPresence(driver, lnkEmployeeDetails, 10);
        return element.isDisplayed();
    }

}
