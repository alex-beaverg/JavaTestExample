package com.beaverg.pages;

import com.beaverg.utils.Config;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
    private final String home_url;
    private final WebDriver driver;

    @FindBy(xpath = "//a[@class='button db ghost']")
    private WebElement cookiesButton;

    public HomePage(WebDriver driver) {
        super(driver);
        home_url = Config.getProperty("home_url");
        this.driver = driver;
        this.driver.get(home_url);
    }

    public boolean isPageOpen() {
        return driver.getCurrentUrl().equals(home_url);
    }

    public void clickCookiesButton() {
        clickWithWaiting(cookiesButton);
        REPORT.info("[INFO]: Button 'Agreement to use cookies' was clicked!");
    }
}
