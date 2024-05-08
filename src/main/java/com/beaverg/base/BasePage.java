package com.beaverg.base;

import com.beaverg.components.part_of_page.MainMenuComponent;
import com.beaverg.components.part_of_page.TopMenuComponent;
import org.openqa.selenium.WebDriver;

public class BasePage extends BaseElement {
    private final WebDriver driver;
    private final MainMenuComponent mainMenuElement;
    private final TopMenuComponent topMenuComponent;

    public BasePage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        mainMenuElement = new MainMenuComponent(this.driver);
        topMenuComponent = new TopMenuComponent(this.driver);
    }

    public MainMenuComponent getMainMenuComponent() {
        REPORT.info("[INFO]: Getting Main Menu");
        return mainMenuElement;
    }

    public TopMenuComponent getTopMenuComponent() {
        REPORT.info("[INFO]: Getting Top Menu");
        return topMenuComponent;
    }
}
