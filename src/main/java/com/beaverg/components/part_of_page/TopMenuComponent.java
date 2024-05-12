package com.beaverg.components.part_of_page;

import com.beaverg.base.BaseElement;
import com.beaverg.components.drop.BasketDropComponent;
import com.beaverg.utils.Waiting;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@FindBy(xpath = "//nav[@class='top-menu']")
public class TopMenuComponent extends BaseElement {
    @FindBy(xpath = ".//button[@data-drop='basketDropPanel']")
    private WebElement basketButton;

    public TopMenuComponent(WebDriver driver) {
        super(driver);
    }

    public BasketDropComponent getBasketDropComponent() {
        Waiting.clickWithWaiting(driver, basketButton);
        REPORT.info("[INFO]: Basket drop component was opened!");
        return new BasketDropComponent(driver);
    }
}
