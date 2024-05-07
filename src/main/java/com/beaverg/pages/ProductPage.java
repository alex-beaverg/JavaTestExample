package com.beaverg.pages;

import com.beaverg.domain.ProductCard;
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
        return title.isDisplayed();
    }

    private String getProductCardTitle() {
        return title.getText();
    }

    private double getProductCardPrice() {
        return Double.parseDouble(price.getText().replace('€', ' '));
    }

    public ProductCard getProductCard() {
        REPORT.info("[INFO]: Getting Product Card from Product Page!");
        return new ProductCard(getProductCardTitle(), getProductCardPrice());
    }
}
