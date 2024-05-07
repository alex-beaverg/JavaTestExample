package com.beaverg.components;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainMenuComponent extends BaseComponent {
    private final WebDriver driver;

    @FindBy(xpath = "//nav[@class='main-menu']//button[@data-drop='catMainDropPanel']")
    private WebElement mobilePhonesItem;

    public MainMenuComponent(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public MobilePhonesDropMenuComponent clickMobilePhonesItem() {
        clickWithWaiting(mobilePhonesItem);
        REPORT.info("[INFO]: Main menu item 'Mobile phones' was clicked!");
        return new MobilePhonesDropMenuComponent(driver);
    }
}
