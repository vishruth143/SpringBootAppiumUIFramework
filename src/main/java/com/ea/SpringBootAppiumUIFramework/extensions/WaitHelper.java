package com.ea.SpringBootAppiumUIFramework.extensions;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;
import java.util.List;

public class WaitHelper {

    private static final int DEFAULT_TIMEOUT = 30;
    private static final int DEFAULT_POLLING = 500; // milliseconds

    /**
     * Waits until the provided condition is met (generic).
     */
    public static WebElement waitForCondition(WebDriver driver, ExpectedCondition<WebElement> condition) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(DEFAULT_TIMEOUT));
        return wait.until(condition);
    }

    public static WebElement waitForCondition(WebDriver driver, ExpectedCondition<WebElement> condition, int timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
        return wait.until(condition);
    }

    /**
     * Waits until the element located by the locator is visible.
     */
    public static WebElement waitForVisibility(WebDriver driver, By locator) {
        return waitForCondition(driver, ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public static WebElement waitForVisibility(WebDriver driver, By locator, int timeoutInSeconds) {
        return waitForCondition(driver, ExpectedConditions.visibilityOfElementLocated(locator), timeoutInSeconds);
    }

    /**
     * Waits until the element located by the locator is clickable.
     */
    public static WebElement waitForClickability(WebDriver driver, By locator) {
        return waitForCondition(driver, ExpectedConditions.elementToBeClickable(locator));
    }

    public static WebElement waitForClickability(WebDriver driver, By locator, int timeoutInSeconds) {
        return waitForCondition(driver, ExpectedConditions.elementToBeClickable(locator), timeoutInSeconds);
    }

    /**
     * Waits until the element is present in the DOM (not necessarily visible).
     */
    public static WebElement waitForPresence(WebDriver driver, By locator) {
        return waitForCondition(driver, ExpectedConditions.presenceOfElementLocated(locator));
    }

    public static WebElement waitForPresence(WebDriver driver, By locator, int timeoutInSeconds) {
        return waitForCondition(driver, ExpectedConditions.presenceOfElementLocated(locator), timeoutInSeconds);
    }

    /**
     * Waits until the page is fully loaded using JavaScript readyState.
     */
    public static void waitForPageLoad(WebDriver driver) {
        new WebDriverWait(driver, Duration.ofSeconds(DEFAULT_TIMEOUT)).until(
                webDriver -> ((JavascriptExecutor) webDriver)
                        .executeScript("return document.readyState").equals("complete"));
    }

    /**
     * Generic FluentWait with custom polling and exception handling.
     */
    public static WebElement fluentWait(WebDriver driver, By locator, int timeoutInSeconds, int pollingMillis) {
        Wait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(timeoutInSeconds))
                .pollingEvery(Duration.ofMillis(pollingMillis))
                .ignoreAll(List.of(
                        NoSuchElementException.class,
                        ElementNotInteractableException.class,
                        StaleElementReferenceException.class
                ));

        return wait.until(driver1 -> driver1.findElement(locator));
    }

    /**
     * FluentWait with default polling.
     */
    public static WebElement fluentWait(WebDriver driver, By locator, int timeoutInSeconds) {
        return fluentWait(driver, locator, timeoutInSeconds, DEFAULT_POLLING);
    }

    public static WebElement waitForClickability(WebDriver driver, WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(DEFAULT_TIMEOUT));
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public static WebElement waitForVisibility(WebDriver driver, WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(DEFAULT_TIMEOUT));
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

}
