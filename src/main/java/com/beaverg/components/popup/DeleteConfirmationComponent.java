package com.beaverg.components.popup;

import com.beaverg.base.BaseElement;
import com.beaverg.utils.Waiting;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DeleteConfirmationComponent extends BaseElement {
    @FindBy(xpath = "//button[@name='jqi_state0_buttonYesDeleteit']")
    private WebElement confirmDeletingButton;

    public DeleteConfirmationComponent(WebDriver driver) {
        super(driver);
    }

    public void clickConfirmDeletingButton() {
        Waiting.clickWithWaiting(driver, confirmDeletingButton);
        REPORT.info("[INFO]: 'Confirm deleting' button was clicked");
        Waiting.waitPageLoading(driver);
    }
}
