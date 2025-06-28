package com.ea.SpringBootAppiumUIFramework.pages;

import com.ea.SpringBootAppiumUIFramework.extensions.UIElementExtensions;
import org.openqa.selenium.By;
import org.springframework.stereotype.Component;

@Component
public class CreateEmployeePage extends BasePage {

//*******************************************************(Web Elements)*************************************************
//-------------------------------------------------------Text Box-------------------------------------------------------
    private final By txtName = By.name("Name");
    private final By txtSalary = By.name("Salary");
    private final By txtDurationWorked = By.id("DurationWorked");
    private final By txtEmail = By.name("Email");

//-------------------------------------------------------Drop Down List-------------------------------------------------
    private final By ddlGrade = By.name("Grade");

//-------------------------------------------------------Button-----------------------------------------------------
    private final By btnCreate = By.cssSelector(".btn");

//*******************************************************(Actions)******************************************************
    public void createNewEmployee(String name, String durationWorked, String email, String salary, String grade) {
        UIElementExtensions.performEnterText(driver, txtName, name);
        UIElementExtensions.performEnterText(driver, txtDurationWorked, durationWorked);
        UIElementExtensions.performEnterText(driver, txtSalary, salary);
        UIElementExtensions.performEnterText(driver, txtEmail, email);
        UIElementExtensions.performDropDownSelectionByText(driver, ddlGrade, grade);
        UIElementExtensions.performClick(driver, btnCreate);
    }

}
