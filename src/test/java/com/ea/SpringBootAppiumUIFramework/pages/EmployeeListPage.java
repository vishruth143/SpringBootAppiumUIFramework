package com.ea.SpringBootAppiumUIFramework.pages;

import com.ea.SpringBootAppiumUIFramework.extensions.UIElementExtensions;
import org.openqa.selenium.By;
import org.springframework.stereotype.Component;

@Component
public class EmployeeListPage extends BasePage {

//*******************************************************(Web Elements)*************************************************
//-------------------------------------------------------Link-----------------------------------------------------------
    private final By btnCreateNew = By.linkText("Create New");

//*******************************************************(Actions)******************************************************
//-------------------------------------------------------Click----------------------------------------------------------
    public void clickCreateNew() {
        UIElementExtensions.performClick(driver, btnCreateNew);
    }

}
