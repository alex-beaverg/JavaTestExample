package com.beaverg.components.drop;

import com.beaverg.base.BaseElement;
import com.beaverg.pages.ProductListPage;
import com.beaverg.utils.Waiting;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccessoriesDropMenuComponent extends BaseElement {
    @FindBy(xpath = "//ul[@class='drop-menu']//a[contains(@href, 'headphones')]/span")
    private WebElement headphonesIcon;

    @FindBy(xpath = "//ul[@class='drop-menu']//a[contains(@href, 'accessories')]/span")
    private WebElement accessoriesIcon;


    public AccessoriesDropMenuComponent(WebDriver driver) {
        super(driver);
    }

    public ProductListPage clickHeadphonesIcon() {
        Waiting.clickWithWaiting(driver, headphonesIcon);
        REPORT.info("[INFO]: Drop menu item 'Headphones' was clicked!");
        return new ProductListPage(driver);
    }

    public ProductListPage clickAccessoriesIcon() {
        Waiting.clickWithWaiting(driver, accessoriesIcon);
        REPORT.info("[INFO]: Drop menu item 'Other accessories' was clicked!");
        return new ProductListPage(driver);
    }
}
