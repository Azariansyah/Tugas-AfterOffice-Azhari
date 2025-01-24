package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class InventoryPage {
    WebDriver driver;

    @FindBy(css = ".btn_inventory") // Adjust the selector as needed
    private WebElement addToCartButton;

    @FindBy(css = ".shopping_cart_link") // Adjust the selector as needed
    private WebElement cartIcon;

    public InventoryPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void addToCart() {
        addToCartButton.click();
    }

    public void openCart() {
        cartIcon.click();
    }
}