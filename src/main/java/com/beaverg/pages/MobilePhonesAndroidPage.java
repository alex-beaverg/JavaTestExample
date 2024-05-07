package com.beaverg.pages;

import com.beaverg.components.ProductsListComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MobilePhonesAndroidPage extends BasePage {
    private final WebDriver driver;
    private final ProductsListComponent productsList;

    @FindBy(xpath = "//header//h1/span")
    private WebElement title;

    public MobilePhonesAndroidPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        productsList = new ProductsListComponent(this.driver);
    }

    public boolean isPageOpen() {
        return title.isDisplayed();
    }

    public ProductsListComponent getProductsList() {
        return productsList;
    }
}
