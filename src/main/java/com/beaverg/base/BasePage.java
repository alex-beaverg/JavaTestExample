package com.beaverg.base;

import com.beaverg.components.part_of_page.MainMenuComponent;
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
        REPORT.info("[INFO]: Getting Main Menu");
        return mainMenuElement;
    }
}
