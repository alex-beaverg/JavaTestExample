package com.beaverg.components;

import com.beaverg.pages.MobilePhonesAndroidPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.beaverg.utils.Printers.PRINTLN;

public class MobilePhonesDropMenuComponent extends BaseComponent {
    private final WebDriver driver;

    @FindBy(xpath = "//i[@class='icon-android']/following-sibling::span")
    private WebElement androidIcon;

    public MobilePhonesDropMenuComponent(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public MobilePhonesAndroidPage clickAndroidIcon() {
        clickWithWaiting(androidIcon);
        PRINTLN.info("[INFO]: Drop menu item 'Android' was clicked!");
        return new MobilePhonesAndroidPage(driver);
    }
}
