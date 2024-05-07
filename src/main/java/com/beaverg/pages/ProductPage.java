package com.beaverg.pages;

import com.beaverg.domain.ProductCard;
import com.beaverg.utils.Waiting;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductPage extends BasePage {
    private final WebDriver driver;

    @FindBy(xpath = "//h1[@class='product-name']")
    private WebElement title;

    @FindBy(xpath = "//div[@class='price-wrap']/div[@class='price']")
    private WebElement price;

    public ProductPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public boolean isPageOpen() {
        return Waiting.waitVisibility(driver, title).isDisplayed();
    }

    private String getProductCardTitle() {
        return Waiting.waitVisibility(driver, title).getText();
    }

    private double getProductCardPrice() {
        return Double.parseDouble(Waiting.waitVisibility(driver, price).getText().replace('€', ' '));
    }

    public ProductCard getProductCard() {
        REPORT.info("[INFO]: Getting Product Card from Product Page!");
        return new ProductCard(getProductCardTitle(), getProductCardPrice());
    }
}
