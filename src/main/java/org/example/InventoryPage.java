package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import java.util.List;

public class InventoryPage extends AbstractComponent {
    @FindBy(id = "add-to-cart-sauce-labs-backpack")
    private WebElement addToCartBackPackButton;

    @FindBy(id = "add-to-cart-sauce-labs-bike-light") // Adjust the selector as needed
    private WebElement addToCartBikeLightButton;

    @FindBy(id = "add-to-cart-sauce-labs-bolt-t-shirt") // Adjust the selector as needed
    private WebElement addToCartBoltTShirtButton;

    @FindBy(id = "add-to-cart-sauce-labs-fleece-jacket") // Adjust the selector as needed
    private WebElement addToCartFleeceJacketButton;

    @FindBy(id = "add-to-cart-sauce-labs-onesie") // Adjust the selector as needed
    private WebElement addToCartOnesieButton;

    @FindBy(id = "add-to-cart-test.allthethings()-t-shirt-(red)") // Adjust the selector as needed
    private WebElement addToCartRedTShirtButton;

    @FindBy(css = ".shopping_cart_link") // Adjust the selector as needed
    private WebElement cartIcon;

    @FindBy(className = "product_sort_container") // Adjust the selector as needed
    private WebElement sortDropdown;

    @FindBy(css = ".inventory_item_name") // Selector untuk nama produk
    private List<WebElement> productNames;

    @FindBy(css = ".inventory_item_price") // Selector untuk harga produk
    private List<WebElement> productPrices;

    public InventoryPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
    public void addToCartBackPack() {
        addToCartBackPackButton.click();
    }
    public void addToCartBikeLight() {
        addToCartBikeLightButton.click();
    }
    public void addToCartBoltTShirt() {
        addToCartBoltTShirtButton.click();
    }
    public void addToCartFleeceJacket() {
        addToCartFleeceJacketButton.click();
    }
    public void addToCartOnesie() {
        addToCartOnesieButton.click();
    }
    public void addToCartRedTShirt() {
        addToCartRedTShirtButton.click();
    }
    public void openCart() {
        cartIcon.click();
    }
    public void selectProductSort(String sortValue) {
        Select select = new Select(sortDropdown);
        select.selectByValue(sortValue); // e.g., "az", "za", "lohi", "hilo"
    }
    public List<WebElement> getProductElements() {
        return productNames;
    }
    public List<WebElement> getProductPriceElements() {
        return productPrices;
    }
}