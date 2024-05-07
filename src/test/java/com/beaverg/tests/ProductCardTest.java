package com.beaverg.tests;

import com.beaverg.domain.ProductCard;
import com.beaverg.pages.HomePage;
import com.beaverg.pages.MobilePhonesAndroidPage;
import com.beaverg.pages.MobilePhonesIOSPage;
import com.beaverg.pages.ProductPage;
import com.beaverg.utils.Config;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

@Epic("Web Mobile Shop testing")
@Story("Product cards testing")
public class ProductCardTest extends BaseTest {

    @Test
    @Description("Verifying android mobile phone product card test")
    public void verifyAndroidMobilePhoneProductCardTest() {
        SoftAssert sa = new SoftAssert();

        HomePage homePage = getHomePageWithAssertion();

        MobilePhonesAndroidPage mobilePhonesAndroidPage = homePage
                .getMainMenuElement()
                .clickMobilePhonesItem()
                .clickAndroidIcon();
        sa.assertTrue(mobilePhonesAndroidPage.isPageOpen(), "Android Mobile Phones Page isn't open!");

        int productIndex = Integer.parseInt(Config.getData("product_index"));
        ProductCard productCardFromProductsPage = mobilePhonesAndroidPage
                .getProductsList()
                .getProductCardByIndex(productIndex);
        ProductPage productPage = mobilePhonesAndroidPage
                .getProductsList()
                .clickProductCardTitleByIndex(productIndex);
        sa.assertTrue(productPage.isPageOpen(), "Product Page isn't open!");

        ProductCard productCardFromProductPage = productPage.getProductCard();
        sa.assertEquals(productCardFromProductPage, productCardFromProductsPage, "Product Cards aren't equal!");

        sa.assertAll();
    }

    @Test
    @Description("Verifying iOS mobile phone product card test")
    public void verifyIOSMobilePhoneProductCardTest() {
        SoftAssert sa = new SoftAssert();

        HomePage homePage = getHomePageWithAssertion();

        MobilePhonesIOSPage mobilePhonesIOSPage = homePage
                .getMainMenuElement()
                .clickMobilePhonesItem()
                .clickIOSIcon();
        sa.assertTrue(mobilePhonesIOSPage.isPageOpen(), "IOS Mobile Phones Page isn't open!");

        int productIndex = Integer.parseInt(Config.getData("product_index"));
        ProductCard productCardFromProductsPage = mobilePhonesIOSPage
                .getProductList()
                .getProductCardByIndex(productIndex);
        ProductPage productPage = mobilePhonesIOSPage
                .getProductList()
                .clickProductCardTitleByIndex(productIndex);
        sa.assertTrue(productPage.isPageOpen(), "Product Page isn't open!");

        ProductCard productCardFromProductPage = productPage.getProductCard();
        sa.assertEquals(productCardFromProductPage, productCardFromProductsPage, "Product Cards aren't equal!");

        sa.assertAll();
    }

    private HomePage getHomePageWithAssertion() {
        HomePage homePage = new HomePage(driver);
        homePage.clickCookiesButton();
        Assert.assertTrue(homePage.isPageOpen(), "Home page isn't open!");
        return homePage;
    }
}
