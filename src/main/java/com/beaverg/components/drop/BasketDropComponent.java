package com.beaverg.components.drop;

import com.beaverg.base.BaseElement;
import com.beaverg.pages.BasketPage;
import com.beaverg.utils.Waiting;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BasketDropComponent extends BaseElement {
    @FindBy(xpath = "//div[@id='basketDropPanel']//footer//span")
    private WebElement goToCheckoutButton;

    public BasketDropComponent(WebDriver driver) {
        super(driver);
    }

    public BasketPage clickGoToCheckoutButton() {
        Waiting.clickWithWaiting(driver, goToCheckoutButton);
        REPORT.info("[INFO]: 'Go to checkout' button was clicked!");
        return new BasketPage(driver);
    }
}
