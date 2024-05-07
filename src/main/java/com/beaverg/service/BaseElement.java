package com.beaverg.service;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BaseElement {
    private final WebDriver driver;

    public BaseElement(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    public void clickWithWaiting(WebElement element) {
        (new WebDriverWait(driver, Duration.ofSeconds(5))).until(ExpectedConditions.elementToBeClickable(element))
                .click();
    }
}
