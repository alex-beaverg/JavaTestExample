package com.beaverg.pages;

import com.beaverg.base.BasePage;
import com.beaverg.components.part_of_page.ProductListComponent;
import com.beaverg.utils.Waiting;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductListPage extends BasePage {
    private final WebDriver driver;
    private final ProductListComponent productList;

    @FindBy(xpath = "//header//h1/span")
    private WebElement title;

    public ProductListPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        productList = new ProductListComponent(this.driver);
    }

    public boolean isPageOpen(String pageTitle) {
        REPORT.info(String.format("[INFO]: %s Page opening check", pageTitle));
        return Waiting.waitVisibility(driver, title).isDisplayed() &&
                Waiting.waitVisibility(driver, title).getText().equals(pageTitle);
    }

    public ProductListComponent getProductList() {
        REPORT.info("[INFO]: Getting Product List");
        Waiting.waitPageLoading(driver);
        return productList;
    }
}
