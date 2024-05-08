package com.beaverg.components.drop;

import com.beaverg.base.BaseElement;
import com.beaverg.pages.ProductListPage;
import com.beaverg.utils.Waiting;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class BrandsDropMenuComponent extends BaseElement {
    private final WebDriver driver;

    @FindBy(xpath = "//ul[@class='drop-menu']/li//img/following-sibling::span")
    private List<WebElement> brandIcons;

    public BrandsDropMenuComponent(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public int getBrandNamesNumber() {
        Waiting.waitVisibility(driver, brandIcons.get(0));
        REPORT.info("[INFO]: Getting number of brands from Brands drop menu");
        return brandIcons.size();
    }

    public String getBrandNameByIndex(int brandIndex) {
        Waiting.waitVisibility(driver, brandIcons.get(brandIndex));
        REPORT.info(String.format("[INFO]: Getting brand name '%s' by index=%d", brandIcons.get(brandIndex).getText(), brandIndex));
        return brandIcons.get(brandIndex).getText();
    }

    public ProductListPage clickBrandIconByIndex(int brandIndex) {
        String brandName = getBrandNameByIndex(brandIndex);
        Waiting.clickWithWaiting(driver, brandIcons.get(brandIndex));
        REPORT.info(String.format("[INFO]: Drop menu item '%s' was clicked!", brandName));
        return new ProductListPage(driver);
    }
}
