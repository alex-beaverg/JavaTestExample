package com.beaverg.tests;

import com.beaverg.base.BaseTest;
import com.beaverg.domain.ProductCard;
import com.beaverg.pages.*;
import com.beaverg.utils.PropertyGetter;
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
        HomePage homePage = getHomePage();

        ProductListPage mobilePhonesAndroidPage = homePage
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
        HomePage homePage = getHomePage();

        ProductListPage mobilePhonesIOSPage = homePage
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
        HomePage homePage = getHomePage();

        ProductListPage mobilePhonesPremiumPage = homePage
                .getMainMenuElement()
                .clickMobilePhonesItem()
                .clickPremiumIcon();
        Assert.assertTrue(mobilePhonesPremiumPage.isPageOpen("Premium phones"),
                "Premium Mobile Phones Page isn't open!");

        compareCards(mobilePhonesPremiumPage);
    }

    @Test
    @Description("Verifying Economic mobile phone product card test")
    public void verifyEconomicMobilePhoneProductCardTest() {
        HomePage homePage = getHomePage();

        ProductListPage mobilePhonesEconomicPage = homePage
                .getMainMenuElement()
                .clickMobilePhonesItem()
                .clickEconomicIcon();
        Assert.assertTrue(mobilePhonesEconomicPage.isPageOpen("Economic phones"),
                "Economic Mobile Phones Page isn't open!");

        compareCards(mobilePhonesEconomicPage);
    }

    @Test
    @Description("Verifying Basic mobile phone product card test")
    public void verifyBasicMobilePhoneProductCardTest() {
        HomePage homePage = getHomePage();

        ProductListPage mobilePhonesBasicPage = homePage
                .getMainMenuElement()
                .clickMobilePhonesItem()
                .clickBasicIcon();
        Assert.assertTrue(mobilePhonesBasicPage.isPageOpen("Basic phones"),
                "Basic Mobile Phones Page isn't open!");

        compareCards(mobilePhonesBasicPage);
    }

    @Test
    @Description("Verifying Top 10 Single SIM mobile phone product card test")
    public void verifySingleSimMobilePhoneProductCardTest() {
        HomePage homePage = getHomePage();

        ProductListPage mobilePhonesSingleSimPage = homePage
                .getMainMenuElement()
                .clickMobilePhonesItem()
                .clickSingleSimIcon();
        Assert.assertTrue(mobilePhonesSingleSimPage.isPageOpen("Top 10 single SIM phones"),
                "Top 10 single SIM Mobile Phones Page isn't open!");

        compareCards(mobilePhonesSingleSimPage);
    }

    @Test
    @Description("Verifying Top 10 Dual SIM mobile phone product card test")
    public void verifyDualSimMobilePhoneProductCardTest() {
        HomePage homePage = getHomePage();

        ProductListPage mobilePhonesDualSimPage = homePage
                .getMainMenuElement()
                .clickMobilePhonesItem()
                .clickDualSimIcon();
        Assert.assertTrue(mobilePhonesDualSimPage.isPageOpen("Top 10 dual SIM phones"),
                "Top 10 dual SIM Mobile Phones Page isn't open!");

        compareCards(mobilePhonesDualSimPage);
    }

    private HomePage getHomePage() {
        HomePage homePage = new HomePage(driver);
        homePage.clickCookiesButton();
        Assert.assertTrue(homePage.isPageOpen(), "Home page isn't open!");
        return homePage;
    }

    private void compareCards(ProductListPage productListPage) {
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
