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
                .getMainMenuElement()
                .clickMobilePhonesItem()
                .clickAndroidIcon();
        sa.assertTrue(mobilePhonesAndroidPage.isPageOpen("Android OS"),
                "Android mobile phones Page isn't open!");

        int productIndex = Integer.parseInt(PropertyGetter.getData("product_index"));
        ProductCard productCardFromProductsPage = mobilePhonesAndroidPage
                .getProductList()
                .getProductCardByIndex(productIndex);
        BasketDropComponent basketPopupComponent = mobilePhonesAndroidPage
                .getProductList()
                .clickAddToBasketByIndex(productIndex);
        BasketPage basketPage = basketPopupComponent
                .clickGoToCheckoutButton();
        sa.assertTrue(basketPage.isPageOpen("My Shopping Basket"),
                "Basket Page isn't open!");

        ProductCard productCardFromBasket = basketPage
                .getBasketItemByIndex(0);
        sa.assertEquals(productCardFromBasket, productCardFromProductsPage,
                "Product Cards aren't equal!");

        sa.assertAll();
    }
}
