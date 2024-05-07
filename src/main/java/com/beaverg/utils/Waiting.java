package com.beaverg.utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Waiting {
    private static final Duration duration = Duration.ofSeconds(10);

    public static void waitPageLoading(WebDriver driver) {
        (new WebDriverWait(driver, duration))
                .until(driver1 -> ((JavascriptExecutor)driver).executeScript("return document.readyState").equals("complete"));
    }

    public static WebElement waitVisibility(WebDriver driver, WebElement element) {
        return (new WebDriverWait(driver, duration))
                .until(ExpectedConditions.visibilityOf(element));
    }

    public static void clickWithWaiting(WebDriver driver, WebElement element) {
        WebElement waitingElement = waitVisibility(driver, element);
        (new WebDriverWait(driver, duration))
                .until(ExpectedConditions.elementToBeClickable(waitingElement)).click();
    }
}
