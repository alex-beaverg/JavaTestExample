package com.beaverg.components.part_of_page;

import com.beaverg.base.BaseElement;
import com.beaverg.utils.Waiting;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@FindBy(xpath = "//nav[@class='top-menu']")
public class TopMenuComponent extends BaseElement {
    private final WebDriver driver;

    @FindBy(xpath = ".//button[@data-drop='basketDropPanel']")
    private WebElement basketButton;

    public TopMenuComponent(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public void closeBasketDropComponent() {
        Waiting.waitPageLoading(driver);
        Waiting.clickWithWaiting(driver, basketButton);
        REPORT.info("[INFO]: Basket drop component was closed!");
    }
}
