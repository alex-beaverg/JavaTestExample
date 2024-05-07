package com.beaverg.tests;

import com.beaverg.base.BaseTest;
import com.beaverg.domain.ProductCard;
import com.beaverg.pages.*;
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
        HomePage homePage = getHomePageWithAssertion();

        MobilePhonesPage mobilePhonesAndroidPage = homePage
                .getMainMenuElement()
                .clickMobilePhonesItem()
                .clickAndroidIcon();
        Assert.assertTrue(mobilePhonesAndroidPage.isPageOpen("Android OS"),
                "Android Mobile Phones Page isn't open!");

        compareCards(mobilePhonesAndroidPage);
    }

    @Test
    @Description("Verifying iOS mobile phone product card test")
    public void verifyIOSMobilePhoneProductCardTest() {
        HomePage homePage = getHomePageWithAssertion();

        MobilePhonesPage mobilePhonesIOSPage = homePage
                .getMainMenuElement()
                .clickMobilePhonesItem()
                .clickIOSIcon();
        Assert.assertTrue(mobilePhonesIOSPage.isPageOpen("iOS operating system"),
                "IOS Mobile Phones Page isn't open!");

        compareCards(mobilePhonesIOSPage);
    }

    @Test
    @Description("Verifying Premium mobile phone product card test")
    public void verifyPremiumMobilePhoneProductCardTest() {
        HomePage homePage = getHomePageWithAssertion();

        MobilePhonesPage mobilePhonesPremiumPage = homePage
                .getMainMenuElement()
                .clickMobilePhonesItem()
                .clickPremiumIcon();
        Assert.assertTrue(mobilePhonesPremiumPage.isPageOpen("Premium phones"),
                "Premium Mobile Phones Page isn't open!");

        compareCards(mobilePhonesPremiumPage);
    }

    private HomePage getHomePageWithAssertion() {
        HomePage homePage = new HomePage(driver);
        homePage.clickCookiesButton();
        Assert.assertTrue(homePage.isPageOpen(), "Home page isn't open!");
        return homePage;
    }

    private void compareCards(MobilePhonesPage page) {
        SoftAssert sa = new SoftAssert();

        int productIndex = Integer.parseInt(Config.getData("product_index"));
        ProductCard productCardFromProductsPage = page
                .getProductList()
                .getProductCardByIndex(productIndex);
        ProductPage productPage = page
                .getProductList()
                .clickProductCardTitleByIndex(productIndex);
        sa.assertTrue(productPage.isPageOpen(), "Product Page isn't open!");

        ProductCard productCardFromProductPage = productPage.getProductCard();
        sa.assertEquals(productCardFromProductPage, productCardFromProductsPage,
                "Product Cards aren't equal!");

        sa.assertAll();
    }
}
