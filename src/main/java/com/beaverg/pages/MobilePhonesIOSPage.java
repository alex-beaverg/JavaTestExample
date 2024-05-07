package com.beaverg.pages;

import com.beaverg.components.ProductListComponent;
import com.beaverg.utils.Waiting;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MobilePhonesIOSPage extends BasePage {
    private final WebDriver driver;
    private final ProductListComponent productList;

    @FindBy(xpath = "//header//h1/span")
    private WebElement title;

    public MobilePhonesIOSPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        productList = new ProductListComponent(this.driver);
    }

    public boolean isPageOpen() {
        REPORT.info("[INFO]: iOS Mobile Phones Page opening check");
        return Waiting.waitVisibility(driver, title).isDisplayed() &&
                Waiting.waitVisibility(driver, title).getText().equals("iOS operating system");
    }

    public ProductListComponent getProductList() {
        REPORT.info("[INFO]: Getting Product List");
        Waiting.waitPageLoading(driver);
        return productList;
    }
}
