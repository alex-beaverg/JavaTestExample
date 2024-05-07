package com.beaverg.components;

import com.beaverg.pages.MobilePhonesPage;
import com.beaverg.base.BaseElement;
import com.beaverg.utils.Waiting;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MobilePhonesDropMenuComponent extends BaseElement {
    private final WebDriver driver;

    @FindBy(xpath = "//i[@class='icon-android']/following-sibling::span")
    private WebElement androidIcon;

    @FindBy(xpath = "//i[@class='icon-apple']/following-sibling::span")
    private WebElement iOSIcon;

    @FindBy(xpath = "//ul[@class='drop-menu']//a[contains(@href, 'premium')]/span")
    private WebElement premiumIcon;

    public MobilePhonesDropMenuComponent(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public MobilePhonesPage clickAndroidIcon() {
        Waiting.clickWithWaiting(driver, androidIcon);
        REPORT.info("[INFO]: Drop menu item 'Android' was clicked!");
        return new MobilePhonesPage(driver);
    }

    public MobilePhonesPage clickIOSIcon() {
        Waiting.clickWithWaiting(driver, iOSIcon);
        REPORT.info("[INFO]: Drop menu item 'iOS' was clicked!");
        return new MobilePhonesPage(driver);
    }

    public MobilePhonesPage clickPremiumIcon() {
        Waiting.clickWithWaiting(driver, premiumIcon);
        REPORT.info("[INFO]: Drop menu item 'Premium phones' was clicked!");
        return new MobilePhonesPage(driver);
    }
}
