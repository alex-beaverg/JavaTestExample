package com.beaverg.components;

import com.beaverg.domain.ProductCard;
import com.beaverg.pages.ProductPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static com.beaverg.utils.Printers.PRINTLN;

@FindBy(xpath = "//div[@class='products-list']")
public class ProductsListComponent extends BaseComponent {
    private final WebDriver driver;

    @FindBy(xpath = ".//div//h5/a")
    private List<WebElement> productCardTitles;

    @FindBy(xpath = ".//div//div[@class='price']/div")
    private List<WebElement> productCardPrices;

    public ProductsListComponent(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    private List<String> getProductCardTitles() {
        return productCardTitles.stream()
                .map(WebElement::getText)
                .toList();
    }

    private List<Double> getProductCardPrices() {
        return productCardPrices.stream()
                .map(element -> Double.parseDouble(element.getText().replace('€', ' ')))
                .toList();
    }

    public ProductCard getProductCardByIndex(int index) {
        PRINTLN.info(String.format("[INFO]: Getting Product Card from Products Page by index=%d!", index));
        return new ProductCard(getProductCardTitles().get(index), getProductCardPrices().get(index));
    }

    public ProductPage clickProductCardTitleByIndex(int index) {
        PRINTLN.info(String.format("[INFO]: Product Card by index=%d was clicked!", index));
        clickWithWaiting(productCardTitles.get(index));
        return new ProductPage(driver);
    }
}
