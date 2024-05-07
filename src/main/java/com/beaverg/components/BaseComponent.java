package com.beaverg.components;

import com.beaverg.service.BaseElement;
import org.openqa.selenium.WebDriver;

public class BaseComponent extends BaseElement {
    private final WebDriver driver;

    public BaseComponent(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }
}
