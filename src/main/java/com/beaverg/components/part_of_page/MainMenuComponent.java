package com.beaverg.components.part_of_page;

import com.beaverg.base.BaseElement;
import com.beaverg.components.drop.AccessoriesDropMenuComponent;
import com.beaverg.components.drop.BrandsDropMenuComponent;
import com.beaverg.components.drop.ElectronicsDropMenuComponent;
import com.beaverg.components.drop.MobilePhonesDropMenuComponent;
import com.beaverg.utils.Waiting;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@FindBy(xpath = "//nav[@class='main-menu']")
public class MainMenuComponent extends BaseElement {
    @FindBy(xpath = ".//button[@data-drop='catMainDropPanel']")
    private WebElement mobilePhonesItem;

    @FindBy(xpath = ".//button[@data-drop='cat22DropPanel']")
    private WebElement electronicsItem;

    @FindBy(xpath = ".//button[@data-drop='cat9DropPanel']")
    private WebElement accessoriesItem;

    @FindBy(xpath = ".//button[@data-drop='catBrandDropPanel']")
    private WebElement brandsItem;

    public MainMenuComponent(WebDriver driver) {
        super(driver);
    }

    public MobilePhonesDropMenuComponent clickMobilePhonesItem() {
        Waiting.clickWithWaiting(driver, mobilePhonesItem);
        REPORT.info("[INFO]: Main menu item 'Mobile phones' was clicked!");
        return new MobilePhonesDropMenuComponent(driver);
    }

    public ElectronicsDropMenuComponent clickElectronicsItem() {
        Waiting.clickWithWaiting(driver, electronicsItem);
        REPORT.info("[INFO]: Main menu item 'Electronics' was clicked!");
        return new ElectronicsDropMenuComponent(driver);
    }

    public AccessoriesDropMenuComponent clickAccessoriesItem() {
        Waiting.clickWithWaiting(driver, accessoriesItem);
        REPORT.info("[INFO]: Main menu item 'Accessories' was clicked!");
        return new AccessoriesDropMenuComponent(driver);
    }

    public BrandsDropMenuComponent clickBrandsItem() {
        Waiting.clickWithWaiting(driver, brandsItem);
        REPORT.info("[INFO]: Main menu item 'Brands' was clicked!");
        return new BrandsDropMenuComponent(driver);
    }
}
