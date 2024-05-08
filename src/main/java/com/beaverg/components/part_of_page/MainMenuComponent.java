package com.beaverg.components.part_of_page;

import com.beaverg.base.BaseElement;
import com.beaverg.components.drop.MobilePhonesDropMenuComponent;
import com.beaverg.utils.Waiting;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@FindBy(xpath = "//nav[@class='main-menu']")
public class MainMenuComponent extends BaseElement {
    private final WebDriver driver;

    @FindBy(xpath = ".//button[@data-drop='catMainDropPanel']")
    private WebElement mobilePhonesItem;

    public MainMenuComponent(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public MobilePhonesDropMenuComponent clickMobilePhonesItem() {
        Waiting.clickWithWaiting(driver, mobilePhonesItem);
        REPORT.info("[INFO]: Main menu item 'Mobile phones' was clicked!");
        return new MobilePhonesDropMenuComponent(driver);
    }
}
