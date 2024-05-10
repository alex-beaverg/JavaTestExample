package com.beaverg.tests;

import com.beaverg.base.BaseTest;
import com.beaverg.domain.ProductCard;
import com.beaverg.pages.BasketPage;
import com.beaverg.pages.HomePage;
import com.beaverg.pages.ProductListPage;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.ArrayList;
import java.util.List;

@Epic("Web Mobile Shop testing")
@Feature("Basket testing")
public class BasketTest extends BaseTest {

    @Test(dataProvider = "productsNumber", enabled = false)
    @Story("Adding products to basket testing")
    @Description("Verifying Adding 1/2/3 products to basket test")
    public void verifyAddingProductsToBasketTest(int productsNumber) {
        SoftAssert sa = new SoftAssert();
        ProductListPage mobilePhonesAndroidPage = getMobilePhonesAndroidPage();

        List<ProductCard> cardsFromProductsPage = new ArrayList<>();
        for (int i = 0; i < productsNumber; i++) {
            cardsFromProductsPage.add(mobilePhonesAndroidPage.getProductList().getProductCardByIndex(i));
            mobilePhonesAndroidPage.getProductList().clickAddToBasketByIndex(i);
            mobilePhonesAndroidPage.refreshCurrentPage();
        }
        BasketPage basketPage = getBasketPage(mobilePhonesAndroidPage);

        List<ProductCard> cardsFromBasket = new ArrayList<>();
        for (int i = 0; i < productsNumber; i++) {
            cardsFromBasket.add(basketPage.getBasketItemByIndex(i));
        }
        sa.assertEquals(cardsFromBasket, cardsFromProductsPage, "Product Cards aren't equal!");
        sa.assertEquals(basketPage.getBasketItemTitles().size(), productsNumber,
                "Number of products in basket isn't equal to quantity added!");

        sa.assertAll();
    }

    @Test(dataProvider = "productsNumber")
    @Story("Adding and deleting products to/from basket testing")
    @Description("Verifying Adding and deleting 1/2/3 products to/from basket test")
    public void verifyAddingAndDeletingProductsToBasketTest(int productsNumber) {
        ProductListPage mobilePhonesAndroidPage = getMobilePhonesAndroidPage();

        for (int i = 0; i < productsNumber; i++) {
            mobilePhonesAndroidPage.getProductList().clickAddToBasketByIndex(i);
            mobilePhonesAndroidPage.refreshCurrentPage();
        }

        BasketPage basketPage = getBasketPage(mobilePhonesAndroidPage);
        for (int i = 0; i < productsNumber; i++) {
            basketPage.clickDeleteProductItem().clickConfirmDeletingButton();
            basketPage.refreshCurrentPage();
        }
        Assert.assertTrue(basketPage.isBasketEmpty(), "Basket isn't empty!");
    }

    @DataProvider(name = "productsNumber")
    public Object[][] getProductsNumber() {
        return new Object[][]{
                { 1 }, { 2 }, { 3 }
        };
    }

    protected ProductListPage getMobilePhonesAndroidPage() {
        HomePage homePage = getHomePage();

        ProductListPage mobilePhonesAndroidPage = homePage
                .getMainMenuComponent()
                .clickMobilePhonesItem()
                .clickAndroidIcon();
        Assert.assertTrue(mobilePhonesAndroidPage.isPageOpen("Android OS"),
                "Android mobile phones Page isn't open!");

        return mobilePhonesAndroidPage;
    }

    protected BasketPage getBasketPage(ProductListPage productListPage) {
        BasketPage basketPage = productListPage
                .getTopMenuComponent()
                .getBasketDropComponent()
                .clickGoToCheckoutButton();
        Assert.assertTrue(basketPage.isPageOpen("My Shopping Basket"), "Basket Page isn't open!");

        return basketPage;
    }
}
