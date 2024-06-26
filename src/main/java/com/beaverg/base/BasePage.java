package com.beaverg.base;

import com.beaverg.components.part_of_page.MainMenuComponent;
import com.beaverg.components.part_of_page.TopMenuComponent;
import com.beaverg.utils.Waiting;
import org.openqa.selenium.WebDriver;

public class BasePage extends BaseElement {
    private final MainMenuComponent mainMenuElement;
    private final TopMenuComponent topMenuComponent;

    public BasePage(WebDriver driver) {
        super(driver);
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

    public void refreshCurrentPage() {
        Waiting.waitPageLoading(driver);
        REPORT.info("[INFO]: Refreshing current page");
        driver.navigate().refresh();
    }
}
