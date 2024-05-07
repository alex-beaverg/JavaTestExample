package com.beaverg.pages;

import com.beaverg.components.MainMenuComponent;
import com.beaverg.service.BaseElement;
import org.openqa.selenium.WebDriver;

public class BasePage extends BaseElement {
    private final WebDriver driver;
    private final MainMenuComponent mainMenuElement;

    public BasePage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        mainMenuElement = new MainMenuComponent(this.driver);
    }

    public MainMenuComponent getMainMenuElement() {
        return mainMenuElement;
    }
}
