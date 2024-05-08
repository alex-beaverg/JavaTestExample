package com.beaverg.base;

import com.beaverg.domain.ProductCard;
import com.beaverg.pages.HomePage;
import com.beaverg.pages.ProductListPage;
import com.beaverg.pages.ProductPage;
import com.beaverg.utils.PropertyGetter;
import com.beaverg.utils.WebDriverService;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.asserts.SoftAssert;

public class BaseTest {
    protected WebDriver driver;

    @BeforeMethod(alwaysRun = true)
    public void setup() {
        driver = WebDriverService.getDriver();
        driver.manage().window().maximize();
    }

    @AfterMethod(alwaysRun = true)
    public void teardown() {
        WebDriverService.closeDriver();
    }

    protected HomePage getHomePage() {
        HomePage homePage = new HomePage(driver);
        homePage.clickCookiesButton();
        Assert.assertTrue(homePage.isPageOpen(), "Home page isn't open!");
        return homePage;
    }

    protected void compareCards(ProductListPage productListPage) {
        SoftAssert sa = new SoftAssert();

        int productIndex = Integer.parseInt(PropertyGetter.getData("product_index"));
        ProductCard productCardFromProductsPage = productListPage
                .getProductList()
                .getProductCardByIndex(productIndex);
        ProductPage productPage = productListPage
                .getProductList()
                .clickProductCardTitleByIndex(productIndex);
        sa.assertTrue(productPage.isPageOpen(), "Product Page isn't open!");

        ProductCard productCardFromProductPage = productPage.getProductCard();
        sa.assertEquals(productCardFromProductPage, productCardFromProductsPage,
                "Product Cards aren't equal!");

        sa.assertAll();
    }
}
