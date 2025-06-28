package com.ea.SpringBootAppiumUIFramework.pages;

import com.ea.SpringBootAppiumUIFramework.extensions.UIElementExtensions;
import org.openqa.selenium.By;
import org.springframework.stereotype.Component;

@Component
public class LoginPage extends BasePage {

//*******************************************************(Web Elements)*************************************************
//-------------------------------------------------------Text Box-------------------------------------------------------
    private final By txtUserName = By.name("UserName");
    private final By txtPassword = By.name("Password");

//-------------------------------------------------------Button--------------------------------------------------------
    private final By btnLogin = By.cssSelector(".btn");


//*******************************************************(Actions)******************************************************
//-------------------------------------------------------Type-----------------------------------------------------------
    public void Login(String userName, String password) {
        UIElementExtensions.performEnterText(driver, txtUserName, userName);
        UIElementExtensions.performEnterText(driver, txtPassword, password);
    }

//-------------------------------------------------------Click----------------------------------------------------------
    public void ClickLogin(){
        UIElementExtensions.performClick(driver, btnLogin);
    }

}
