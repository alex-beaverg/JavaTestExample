package com.beaverg.components.drop;

import com.beaverg.base.BaseElement;
import com.beaverg.pages.ProductListPage;
import com.beaverg.utils.Waiting;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ElectronicsDropMenuComponent extends BaseElement {
    @FindBy(xpath = "//ul[@class='drop-menu']//a[contains(@href, 'tablets')]/span")
    private WebElement tabletsIcon;

    @FindBy(xpath = "//ul[@class='drop-menu']//a[contains(@href, 'smartwatches')]/span")
    private WebElement smartwatchesIcon;

    @FindBy(xpath = "//ul[@class='drop-menu']//a[contains(@href, 'speakers')]/span")
    private WebElement speakersIcon;

    @FindBy(xpath = "//ul[@class='drop-menu']//a[contains(@href, 'laptops')]/span")
    private WebElement laptopsIcon;

    @FindBy(xpath = "//ul[@class='drop-menu']//a[contains(@href, 'console')]/span")
    private WebElement consoleIcon;

    @FindBy(xpath = "//ul[@class='drop-menu']//a[contains(@href, 'cleaner')]/span")
    private WebElement cleanerIcon;

    @FindBy(xpath = "//ul[@class='drop-menu']//a[contains(@href, 'hardware')]/span")
    private WebElement hardwareIcon;

    public ElectronicsDropMenuComponent(WebDriver driver) {
        super(driver);
    }

    public ProductListPage clickTabletsIcon() {
        Waiting.clickWithWaiting(driver, tabletsIcon);
        REPORT.info("[INFO]: Drop menu item 'Tablets' was clicked!");
        return new ProductListPage(driver);
    }

    public ProductListPage clickSmartwatchesIcon() {
        Waiting.clickWithWaiting(driver, smartwatchesIcon);
        REPORT.info("[INFO]: Drop menu item 'Smartwatches' was clicked!");
        return new ProductListPage(driver);
    }

    public ProductListPage clickSpeakersIcon() {
        Waiting.clickWithWaiting(driver, speakersIcon);
        REPORT.info("[INFO]: Drop menu item 'Speakers' was clicked!");
        return new ProductListPage(driver);
    }

    public ProductListPage clickLaptopsIcon() {
        Waiting.clickWithWaiting(driver, laptopsIcon);
        REPORT.info("[INFO]: Drop menu item 'Laptops' was clicked!");
        return new ProductListPage(driver);
    }

    public ProductListPage clickConsoleIcon() {
        Waiting.clickWithWaiting(driver, consoleIcon);
        REPORT.info("[INFO]: Drop menu item 'Gaming console' was clicked!");
        return new ProductListPage(driver);
    }

    public ProductListPage clickCleanerIcon() {
        Waiting.clickWithWaiting(driver, cleanerIcon);
        REPORT.info("[INFO]: Drop menu item 'Vacuum cleaner' was clicked!");
        return new ProductListPage(driver);
    }

    public ProductListPage clickHardwareIcon() {
        Waiting.clickWithWaiting(driver, hardwareIcon);
        REPORT.info("[INFO]: Drop menu item 'Computer hardware' was clicked!");
        return new ProductListPage(driver);
    }
}
