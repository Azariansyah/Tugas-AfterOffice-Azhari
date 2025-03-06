package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CheckOutStepTwoPage {
    private WebDriver driver;

    public CheckOutStepTwoPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        new WebDriverWait(driver, Duration.ofSeconds(2));
    }

    @FindBy(id = "cancel")
    private WebElement CancelButton;

    @FindBy(id = "finish")
    private WebElement FinishButton;

    public void clickCancelButton() {
        CancelButton.click();
    }
    public void clickFinishButton () {
        FinishButton.click();
    }

}
