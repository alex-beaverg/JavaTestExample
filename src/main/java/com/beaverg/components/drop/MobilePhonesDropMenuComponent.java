package com.beaverg.components.drop;

import com.beaverg.pages.ProductListPage;
import com.beaverg.base.BaseElement;
import com.beaverg.utils.Waiting;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MobilePhonesDropMenuComponent extends BaseElement {
    @FindBy(xpath = "//i[@class='icon-android']/following-sibling::span")
    private WebElement androidIcon;

    @FindBy(xpath = "//i[@class='icon-apple']/following-sibling::span")
    private WebElement iOSIcon;

    @FindBy(xpath = "//ul[@class='drop-menu']//a[contains(@href, 'premium')]/span")
    private WebElement premiumIcon;

    @FindBy(xpath = "//ul[@class='drop-menu']//a[contains(@href, 'economic')]/span")
    private WebElement economicIcon;

    @FindBy(xpath = "//ul[@class='drop-menu']//a[contains(@href, 'basic')]/span")
    private WebElement basicIcon;

    @FindBy(xpath = "//ul[@class='drop-menu']//a[contains(@href, 'single-sim')]/span")
    private WebElement singleSimIcon;

    @FindBy(xpath = "//ul[@class='drop-menu']//a[contains(@href, 'dual-sim')]/span")
    private WebElement dualSimIcon;

    public MobilePhonesDropMenuComponent(WebDriver driver) {
        super(driver);
    }

    public ProductListPage clickAndroidIcon() {
        Waiting.clickWithWaiting(driver, androidIcon);
        REPORT.info("[INFO]: Drop menu item 'Android' was clicked!");
        return new ProductListPage(driver);
    }

    public ProductListPage clickIOSIcon() {
        Waiting.clickWithWaiting(driver, iOSIcon);
        REPORT.info("[INFO]: Drop menu item 'iOS' was clicked!");
        return new ProductListPage(driver);
    }

    public ProductListPage clickPremiumIcon() {
        Waiting.clickWithWaiting(driver, premiumIcon);
        REPORT.info("[INFO]: Drop menu item 'Premium phones' was clicked!");
        return new ProductListPage(driver);
    }

    public ProductListPage clickEconomicIcon() {
        Waiting.clickWithWaiting(driver, economicIcon);
        REPORT.info("[INFO]: Drop menu item 'Economic phones' was clicked!");
        return new ProductListPage(driver);
    }

    public ProductListPage clickBasicIcon() {
        Waiting.clickWithWaiting(driver, basicIcon);
        REPORT.info("[INFO]: Drop menu item 'Basic phones' was clicked!");
        return new ProductListPage(driver);
    }

    public ProductListPage clickSingleSimIcon() {
        Waiting.clickWithWaiting(driver, singleSimIcon);
        REPORT.info("[INFO]: Drop menu item 'Top 10 single SIM phones' was clicked!");
        return new ProductListPage(driver);
    }

    public ProductListPage clickDualSimIcon() {
        Waiting.clickWithWaiting(driver, dualSimIcon);
        REPORT.info("[INFO]: Drop menu item 'Top 10 dual SIM phones' was clicked!");
        return new ProductListPage(driver);
    }
}
