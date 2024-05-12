package com.beaverg.pages;

import com.beaverg.base.BasePage;
import com.beaverg.domain.ProductCard;
import com.beaverg.utils.Waiting;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductPage extends BasePage {
    @FindBy(xpath = "//h1[@class='product-name']")
    private WebElement title;

    @FindBy(xpath = "//div[@class='price-wrap']/div[@class='price']")
    private WebElement price;

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    public boolean isPageOpen() {
        REPORT.info("[INFO]: Product Page opening check");
        return Waiting.waitVisibility(driver, title).isDisplayed();
    }

    private String getProductCardTitle() {
        REPORT.info("\t- Getting Title");
        return Waiting.waitVisibility(driver, title).getText();
    }

    private double getProductCardPrice() {
        REPORT.info("\t- Getting Price");
        return Double.parseDouble(Waiting.waitVisibility(driver, price).getText().replace('€', ' '));
    }

    public ProductCard getProductCard() {
        REPORT.info("[INFO]: Getting Product Card from Product Page:");
        return new ProductCard(getProductCardTitle(), getProductCardPrice());
    }
}
