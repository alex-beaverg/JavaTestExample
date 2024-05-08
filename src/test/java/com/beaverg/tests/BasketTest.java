package com.beaverg.tests;

import com.beaverg.base.BaseTest;
import com.beaverg.components.drop.BasketDropComponent;
import com.beaverg.domain.ProductCard;
import com.beaverg.pages.BasketPage;
import com.beaverg.pages.HomePage;
import com.beaverg.pages.ProductListPage;
import com.beaverg.utils.PropertyGetter;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

@Epic("Web Mobile Shop testing")
@Feature("Basket testing")
public class BasketTest extends BaseTest {

    @Test
    @Story("Adding products to basket testing")
    @Description("Verifying Adding 1 product to basket test")
    public void verifyAddingOneProductToBasketTest() {
        SoftAssert sa = new SoftAssert();
        HomePage homePage = getHomePage();

        ProductListPage mobilePhonesAndroidPage = homePage
                .getMainMenuComponent()
                .clickMobilePhonesItem()
                .clickAndroidIcon();
        sa.assertTrue(mobilePhonesAndroidPage.isPageOpen("Android OS"),
                "Android mobile phones Page isn't open!");

        int productIndex = Integer.parseInt(PropertyGetter.getData("product_index"));
        ProductCard productCardFromProductsPage = mobilePhonesAndroidPage
                .getProductList()
                .getProductCardByIndex(productIndex);
        BasketDropComponent basketDropComponent = mobilePhonesAndroidPage
                .getProductList()
                .clickAddToBasketByIndex(productIndex);
        BasketPage basketPage = basketDropComponent
                .clickGoToCheckoutButton();
        sa.assertTrue(basketPage.isPageOpen("My Shopping Basket"),
                "Basket Page isn't open!");
        sa.assertEquals(basketPage.getBasketItemTitles().size(), 1,
                "Number of products in basket isn't equal to quantity added!");

        ProductCard productCardFromBasket = basketPage
                .getBasketItemByIndex(0);
        sa.assertEquals(productCardFromBasket, productCardFromProductsPage,
                "Product Cards aren't equal!");

        sa.assertAll();
    }

    @Test
    @Story("Adding products to basket testing")
    @Description("Verifying Adding 2 products to basket test")
    public void verifyAddingTwoProductsToBasketTest() {
        SoftAssert sa = new SoftAssert();
        HomePage homePage = getHomePage();

        ProductListPage mobilePhonesAndroidPage = homePage
                .getMainMenuComponent()
                .clickMobilePhonesItem()
                .clickAndroidIcon();
        sa.assertTrue(mobilePhonesAndroidPage.isPageOpen("Android OS"),
                "Android mobile phones Page isn't open!");

        ProductCard productCardFromProductsPage1 = mobilePhonesAndroidPage
                .getProductList()
                .getProductCardByIndex(0);
        ProductCard productCardFromProductsPage2 = mobilePhonesAndroidPage
                .getProductList()
                .getProductCardByIndex(1);
        mobilePhonesAndroidPage.getProductList().clickAddToBasketByIndex(0);
        mobilePhonesAndroidPage.refreshCurrentPage();
        BasketDropComponent basketDropComponent = mobilePhonesAndroidPage
                .getProductList()
                .clickAddToBasketByIndex(1);

        BasketPage basketPage = basketDropComponent
                .clickGoToCheckoutButton();
        sa.assertTrue(basketPage.isPageOpen("My Shopping Basket"),
                "Basket Page isn't open!");

        ProductCard productCardFromBasket1 = basketPage
                .getBasketItemByIndex(0);
        ProductCard productCardFromBasket2 = basketPage
                .getBasketItemByIndex(1);
        sa.assertEquals(productCardFromBasket1, productCardFromProductsPage1,
                "Product Cards aren't equal!");
        sa.assertEquals(productCardFromBasket2, productCardFromProductsPage2,
                "Product Cards aren't equal!");
        sa.assertEquals(basketPage.getBasketItemTitles().size(), 2,
                "Number of products in basket isn't equal to quantity added!");

        sa.assertAll();
    }
}