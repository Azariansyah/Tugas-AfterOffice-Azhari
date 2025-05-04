package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage extends AbstractComponent {
    @FindBy(className = "title")
    private WebElement cartTitle;

    @FindBy(xpath = "//button[@id='checkout']")
    private WebElement checkoutButton;

    @FindBy(xpath = "//button[@id='continue-shopping']")
    private WebElement continueShoppingButton;

    public CartPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void clickCheckoutButton() {
        checkoutButton.click();
    }

    public void clickContinueShoppingButton() {
        continueShoppingButton.click();
    }
    public WebElement getCartTitle() {
        return cartTitle;
    }
}
