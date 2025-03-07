package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckOutStepTwoPage extends AbstractComponent {
    @FindBy(id = "cancel")
    private WebElement CancelButton;

    @FindBy(id = "finish")
    private WebElement FinishButton;

    public CheckOutStepTwoPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void clickCancelButton() {
        CancelButton.click();
    }

    public void clickFinishButton() {
        FinishButton.click();
    }
}