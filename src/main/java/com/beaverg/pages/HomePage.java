package com.beaverg.pages;

import com.beaverg.utils.Config;
import com.beaverg.utils.Waiting;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Set;

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
        Waiting.waitPageLoading(driver);
        Waiting.clickWithWaiting(driver, cookiesButton);
        REPORT.info("[INFO]: Button 'Agreement to use cookies' was clicked!");
    }
}
