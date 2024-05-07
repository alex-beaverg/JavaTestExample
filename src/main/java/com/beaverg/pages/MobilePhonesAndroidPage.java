package com.beaverg.pages;

import com.beaverg.components.ProductListComponent;
import com.beaverg.utils.Waiting;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MobilePhonesAndroidPage extends BasePage {
    private final WebDriver driver;
    private final ProductListComponent productsList;

    @FindBy(xpath = "//header//h1/span")
    private WebElement title;

    public MobilePhonesAndroidPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        productsList = new ProductListComponent(this.driver);
    }

    public boolean isPageOpen() {
        REPORT.info("[INFO]: Android Mobile Phones Page opening check");
        return Waiting.waitVisibility(driver, title).isDisplayed() &&
                Waiting.waitVisibility(driver, title).getText().equals("Android OS");
    }

    public ProductListComponent getProductsList() {
        REPORT.info("[INFO]: Getting Product List");
        Waiting.waitPageLoading(driver);
        return productsList;
    }
}
