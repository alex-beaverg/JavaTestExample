package com.beaverg.components.part_of_page;

import com.beaverg.components.drop.BasketDropComponent;
import com.beaverg.domain.ProductCard;
import com.beaverg.pages.ProductPage;
import com.beaverg.base.BaseElement;
import com.beaverg.utils.Waiting;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.util.List;

@FindBy(xpath = "//div[@class='products-list']")
public class ProductListComponent extends BaseElement {
    private final WebDriver driver;

    @FindBy(xpath = ".//div//h5/a")
    private List<WebElement> productCardTitles;

    @FindBy(xpath = ".//div//div[@class='price']/div")
    private List<WebElement> productCardPrices;

    @FindBy(xpath = "//div[@class='product-wrap']")
    private List<WebElement> productCards;

    @FindBy(xpath = "//div[@class='product-wrap']//footer//span")
    private List<WebElement> addToBasketButtons;

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

    public void clickAddToBasketByIndex(int index) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", productCards.get(index));
        Actions action = new Actions(driver);
        action.moveToElement(productCards.get(index)).perform();
        Waiting.clickWithWaiting(driver, addToBasketButtons.get(index));
        REPORT.info(String.format("[INFO]: 'Add to basket' button by index=%d was clicked!", index));
    }
}
