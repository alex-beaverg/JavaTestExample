package com.beaverg.pages;

import com.beaverg.base.BasePage;
import com.beaverg.domain.ProductCard;
import com.beaverg.utils.Waiting;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class BasketPage extends BasePage {
    private final WebDriver driver;

    @FindBy(xpath = "//div[@class='container']/h1")
    private WebElement title;

    @FindBy(xpath = "//div[@class='basket']/div[@class='item']//div[@class='product-name']")
    private List<WebElement> basketItemTitles;

    @FindBy(xpath = "//div[@class='item']//div[@class='min-w']//preceding-sibling::div[2]")
    private List<WebElement> basketItemPrices;

    public BasketPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public boolean isPageOpen(String pageTitle) {
        REPORT.info(String.format("[INFO]: %s Page opening check", pageTitle));
        return Waiting.waitVisibility(driver, title).isDisplayed() &&
                Waiting.waitVisibility(driver, title).getText().equals(pageTitle);
    }

    private List<String> getBasketItemTitles() {
        REPORT.info("\t- Getting Title List");
        return basketItemTitles.stream()
                .map(element -> Waiting.waitVisibility(driver, element).getText())
                .toList();
    }

    private List<Double> getBasketItemPrices() {
        REPORT.info("\t- Getting Price List");
        return basketItemPrices.stream()
                .map(element -> Double.parseDouble(Waiting.waitVisibility(driver, element).getText().replace('€', ' ')))
                .toList();
    }

    public ProductCard getBasketItemByIndex(int index) {
        REPORT.info(String.format("[INFO]: Getting Basket Item from Basket by index=%d!", index));
        return new ProductCard(getBasketItemTitles().get(index), getBasketItemPrices().get(index));
    }
}
