package com.beaverg.base;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BaseElement {
    protected final WebDriver driver;
    public static final Logger REPORT = LogManager.getLogger(BaseElement.class);

    public BaseElement(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }
}
