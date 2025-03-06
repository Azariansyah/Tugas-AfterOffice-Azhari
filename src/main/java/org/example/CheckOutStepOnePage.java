package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.By;


public class CheckOutStepOnePage {
    WebDriver driver;

    @FindBy(id = "first-name")
    private WebElement firstName;

    @FindBy(id = "last-name")
    private WebElement lastName;

    @FindBy(id = "postal-code")
    private WebElement postalCode;

    @FindBy(css = ".btn_primary.cart_button")
    private WebElement continueButton;

    public CheckOutStepOnePage (WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void setFirstName(String name) {
        firstName.sendKeys(name);
    }

    public void setLastName(String name) {
        lastName.sendKeys(name);
    }

    public void setPostalCode(String code) {
        postalCode.sendKeys(code);
    }

    public void clickContinueButton() {
        continueButton.click();
    }

    public String getErrorMessage() {
        return driver.findElement(By.cssSelector("h3")).getText();
    }
}