package com.ea.SpringBootAppiumUIFramework.extensions;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;

public class UIElementExtensions {

    public static void performEnterText(WebDriver driver, By locator, String value) {
        WebElement element = WaitHelper.waitForClickability(driver, locator);
        scrollIntoView(driver, element);

        try {
            element.clear();
            element.sendKeys(value);
        } catch (ElementClickInterceptedException e) {
            System.out.println("Element not interactable immediately. Retrying...");
            scrollIntoView(driver, element);
            element.clear();
            element.sendKeys(value);
        }
    }

    public static void performClick(WebDriver driver, By locator) {
        WebElement element = WaitHelper.waitForClickability(driver, locator);
        scrollIntoView(driver, element);
        element.click();
    }

    public static void performDropDownSelectionByText(WebDriver driver, By locator, String dropDownText) {
        WebElement element = WaitHelper.waitForVisibility(driver, locator);
        scrollIntoView(driver, element);
        new Select(element).selectByVisibleText(dropDownText);
    }

    public static void performDropDownSelectionByIndex(WebDriver driver, By locator, int index) {
        WebElement element = WaitHelper.waitForVisibility(driver, locator);
        scrollIntoView(driver, element);
        new Select(element).selectByIndex(index);
    }

    public static void performDropDownSelectionByValue(WebDriver driver, By locator, String dropDownValue) {
        WebElement element = WaitHelper.waitForVisibility(driver, locator);
        scrollIntoView(driver, element);
        new Select(element).selectByValue(dropDownValue);
    }

    private static void scrollIntoView(WebDriver driver, WebElement element) {
        try {
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", element);
        } catch (Exception e) {
            System.out.println("Scrolling failed: " + e.getMessage());
        }
    }
}
