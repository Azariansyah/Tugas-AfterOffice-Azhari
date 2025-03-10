package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {
    WebDriver driver;

    @FindBy(css = ".btn_medium.checkout_button") // Adjust the selector as needed
    private WebElement checkoutButton;

    @FindBy(css = "#continue-shopping")
    private WebElement continueShoppingButton;

    public CartPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickCheckoutButton() {
        checkoutButton.click();
    }
    public void clickContinueShoppingButton() {
        continueShoppingButton.click();
    }







}