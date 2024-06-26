package com.beaverg.tests;

import com.beaverg.base.BaseTest;
import com.beaverg.components.drop.BrandsDropMenuComponent;
import com.beaverg.pages.*;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

@Epic("Web Mobile Shop testing")
@Feature("Product cards testing")
public class ProductCardTest extends BaseTest {

    @Test
    @Story("Mobile phone cards testing")
    @Description("Verifying Android mobile phone product card test")
    public void verifyAndroidMobilePhoneProductCardTest() {
        HomePage homePage = getHomePage();

        ProductListPage mobilePhonesAndroidPage = homePage
                .getMainMenuComponent()
                .clickMobilePhonesItem()
                .clickAndroidIcon();
        Assert.assertTrue(mobilePhonesAndroidPage.isPageOpen("Android OS"),
                "Android mobile phones Page isn't open!");

        compareCards(mobilePhonesAndroidPage);
    }

    @Test
    @Story("Mobile phone cards testing")
    @Description("Verifying iOS mobile phone product card test")
    public void verifyIOSMobilePhoneProductCardTest() {
        HomePage homePage = getHomePage();

        ProductListPage mobilePhonesIOSPage = homePage
                .getMainMenuComponent()
                .clickMobilePhonesItem()
                .clickIOSIcon();
        Assert.assertTrue(mobilePhonesIOSPage.isPageOpen("iOS operating system"),
                "IOS mobile phones Page isn't open!");

        compareCards(mobilePhonesIOSPage);
    }

    @Test
    @Story("Mobile phone cards testing")
    @Description("Verifying Premium mobile phone product card test")
    public void verifyPremiumMobilePhoneProductCardTest() {
        HomePage homePage = getHomePage();

        ProductListPage mobilePhonesPremiumPage = homePage
                .getMainMenuComponent()
                .clickMobilePhonesItem()
                .clickPremiumIcon();
        Assert.assertTrue(mobilePhonesPremiumPage.isPageOpen("Premium phones"),
                "Premium mobile phones Page isn't open!");

        compareCards(mobilePhonesPremiumPage);
    }

    @Test
    @Story("Mobile phone cards testing")
    @Description("Verifying Economic mobile phone product card test")
    public void verifyEconomicMobilePhoneProductCardTest() {
        HomePage homePage = getHomePage();

        ProductListPage mobilePhonesEconomicPage = homePage
                .getMainMenuComponent()
                .clickMobilePhonesItem()
                .clickEconomicIcon();
        Assert.assertTrue(mobilePhonesEconomicPage.isPageOpen("Economic phones"),
                "Economic mobile phones Page isn't open!");

        compareCards(mobilePhonesEconomicPage);
    }

    @Test
    @Story("Mobile phone cards testing")
    @Description("Verifying Basic mobile phone product card test")
    public void verifyBasicMobilePhoneProductCardTest() {
        HomePage homePage = getHomePage();

        ProductListPage mobilePhonesBasicPage = homePage
                .getMainMenuComponent()
                .clickMobilePhonesItem()
                .clickBasicIcon();
        Assert.assertTrue(mobilePhonesBasicPage.isPageOpen("Basic phones"),
                "Basic mobile phones Page isn't open!");

        compareCards(mobilePhonesBasicPage);
    }

    @Test
    @Story("Mobile phone cards testing")
    @Description("Verifying Top 10 single SIM mobile phone product card test")
    public void verifySingleSimMobilePhoneProductCardTest() {
        HomePage homePage = getHomePage();

        ProductListPage mobilePhonesSingleSimPage = homePage
                .getMainMenuComponent()
                .clickMobilePhonesItem()
                .clickSingleSimIcon();
        Assert.assertTrue(mobilePhonesSingleSimPage.isPageOpen("Top 10 single SIM phones"),
                "Top 10 single SIM mobile phones Page isn't open!");

        compareCards(mobilePhonesSingleSimPage);
    }

    @Test
    @Story("Mobile phone cards testing")
    @Description("Verifying Top 10 dual SIM mobile phone product card test")
    public void verifyDualSimMobilePhoneProductCardTest() {
        HomePage homePage = getHomePage();

        ProductListPage mobilePhonesDualSimPage = homePage
                .getMainMenuComponent()
                .clickMobilePhonesItem()
                .clickDualSimIcon();
        Assert.assertTrue(mobilePhonesDualSimPage.isPageOpen("Top 10 dual SIM phones"),
                "Top 10 dual SIM mobile phones Page isn't open!");

        compareCards(mobilePhonesDualSimPage);
    }

    @Test
    @Story("Electronics cards testing")
    @Description("Verifying Tablet product card test")
    public void verifyTabletProductCardTest() {
        HomePage homePage = getHomePage();

        ProductListPage tabletsPage = homePage
                .getMainMenuComponent()
                .clickElectronicsItem()
                .clickTabletsIcon();
        Assert.assertTrue(tabletsPage.isPageOpen("Tablets"),
                "Tablets Page isn't open!");

        compareCards(tabletsPage);
    }

    @Test
    @Story("Electronics cards testing")
    @Description("Verifying Smartwatches product card test")
    public void verifySmartwatchesProductCardTest() {
        HomePage homePage = getHomePage();

        ProductListPage smartwatchesPage = homePage
                .getMainMenuComponent()
                .clickElectronicsItem()
                .clickSmartwatchesIcon();
        Assert.assertTrue(smartwatchesPage.isPageOpen("Smartwatches"),
                "Smartwatches Page isn't open!");

        compareCards(smartwatchesPage);
    }

    @Test
    @Story("Electronics cards testing")
    @Description("Verifying Speakers product card test")
    public void verifySpeakersProductCardTest() {
        HomePage homePage = getHomePage();

        ProductListPage speakersPage = homePage
                .getMainMenuComponent()
                .clickElectronicsItem()
                .clickSpeakersIcon();
        Assert.assertTrue(speakersPage.isPageOpen("Speakers"),
                "Speakers Page isn't open!");

        compareCards(speakersPage);
    }

    @Test
    @Story("Electronics cards testing")
    @Description("Verifying Laptops product card test")
    public void verifyLaptopsProductCardTest() {
        HomePage homePage = getHomePage();

        ProductListPage laptopsPage = homePage
                .getMainMenuComponent()
                .clickElectronicsItem()
                .clickLaptopsIcon();
        Assert.assertTrue(laptopsPage.isPageOpen("Laptops"),
                "Laptops Page isn't open!");

        compareCards(laptopsPage);
    }

    @Test
    @Story("Electronics cards testing")
    @Description("Verifying Gaming console product card test")
    public void verifyConsoleProductCardTest() {
        HomePage homePage = getHomePage();

        ProductListPage consolePage = homePage
                .getMainMenuComponent()
                .clickElectronicsItem()
                .clickConsoleIcon();
        Assert.assertTrue(consolePage.isPageOpen("Gaming console"),
                "Gaming console Page isn't open!");

        compareCards(consolePage);
    }

    @Test
    @Story("Electronics cards testing")
    @Description("Verifying Vacuum cleaner product card test")
    public void verifyCleanerProductCardTest() {
        HomePage homePage = getHomePage();

        ProductListPage cleanerPage = homePage
                .getMainMenuComponent()
                .clickElectronicsItem()
                .clickCleanerIcon();
        Assert.assertTrue(cleanerPage.isPageOpen("Vacuum cleaner"),
                "Vacuum cleaner Page isn't open!");

        compareCards(cleanerPage);
    }

    @Test
    @Story("Electronics cards testing")
    @Description("Verifying Computer hardware product card test")
    public void verifyHardwareProductCardTest() {
        HomePage homePage = getHomePage();

        ProductListPage hardwarePage = homePage
                .getMainMenuComponent()
                .clickElectronicsItem()
                .clickHardwareIcon();
        Assert.assertTrue(hardwarePage.isPageOpen("Computer hardware"),
                "Computer hardware Page isn't open!");

        compareCards(hardwarePage);
    }

    @Test
    @Story("Accessories cards testing")
    @Description("Verifying Headphones product card test")
    public void verifyHeadphonesProductCardTest() {
        HomePage homePage = getHomePage();

        ProductListPage headphonesPage = homePage
                .getMainMenuComponent()
                .clickAccessoriesItem()
                .clickHeadphonesIcon();
        Assert.assertTrue(headphonesPage.isPageOpen("Headphones"),
                "Headphones Page isn't open!");

        compareCards(headphonesPage);
    }

    @Test
    @Story("Accessories cards testing")
    @Description("Verifying Other accessories product card test")
    public void verifyAccessoriesProductCardTest() {
        HomePage homePage = getHomePage();

        ProductListPage accessoriesPage = homePage
                .getMainMenuComponent()
                .clickAccessoriesItem()
                .clickAccessoriesIcon();
        Assert.assertTrue(accessoriesPage.isPageOpen("Other accessories"),
                "Other accessories Page isn't open!");

        compareCards(accessoriesPage);
    }

    @Test(dataProvider = "brandIndexes")
    @Story("Brand cards testing")
    @Description("Verifying Brand name product card test")
    public void verifyBrandNameProductCardTest(int brandIndex) {
        HomePage homePage = getHomePage();

        BrandsDropMenuComponent brandsDropMenuComponent = homePage
                .getMainMenuComponent()
                .clickBrandsItem();
        String brandName = brandsDropMenuComponent.getBrandNameByIndex(brandIndex);
        ProductListPage brandPage = brandsDropMenuComponent
                .clickBrandIconByIndex(brandIndex);
        Assert.assertTrue(brandPage.isPageOpen(brandName),
                String.format("%s Page isn't open!", brandName));

        compareCards(brandPage);
    }

    @DataProvider(name = "brandIndexes")
    public Object[][] getBrandIndexes() {
        int brandsNumber = getBrandsNumber();
        Object[][] brandIndexes = new Object[brandsNumber][1];
        for (int i = 0; i < brandsNumber; i++) {
            brandIndexes[i][0] = i;
        }
        return brandIndexes;
    }

    private int getBrandsNumber() {
        setup();
        int numbers = getHomePage()
                .getMainMenuComponent()
                .clickBrandsItem()
                .getBrandNamesNumber();
        teardown();
        return numbers;
    }
}
