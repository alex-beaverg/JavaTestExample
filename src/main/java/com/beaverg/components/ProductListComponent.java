package com.beaverg.components;

import com.beaverg.domain.ProductCard;
import com.beaverg.pages.ProductPage;
import com.beaverg.base.BaseElement;
import com.beaverg.utils.Waiting;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

@FindBy(xpath = "//div[@class='products-list']")
public class ProductListComponent extends BaseElement {
    private final WebDriver driver;

    @FindBy(xpath = ".//div//h5/a")
    private List<WebElement> productCardTitles;

    @FindBy(xpath = ".//div//div[@class='price']/div")
    private List<WebElement> productCardPrices;

    public ProductListComponent(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    private List<String> getProductCardTitles() {
        REPORT.info("\t- Getting Title List");
        return productCardTitles.stream()
                .map(element -> Waiting.waitVisibility(driver, element).getText())
                .toList();
    }

    private List<Double> getProductCardPrices() {
        REPORT.info("\t- Getting Price List");
        return productCardPrices.stream()
                .map(element -> Double.parseDouble(Waiting.waitVisibility(driver, element).getText().replace('€', ' ')))
                .toList();
    }

    public ProductCard getProductCardByIndex(int index) {
        REPORT.info(String.format("[INFO]: Getting Product Card from Product List by index=%d!", index));
        return new ProductCard(getProductCardTitles().get(index), getProductCardPrices().get(index));
    }

    public ProductPage clickProductCardTitleByIndex(int index) {
        Waiting.clickWithWaiting(driver, productCardTitles.get(index));
        REPORT.info(String.format("[INFO]: Product Card by index=%d was clicked!", index));
        return new ProductPage(driver);
    }
}
