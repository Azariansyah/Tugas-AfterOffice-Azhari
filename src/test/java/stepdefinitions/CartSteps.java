package stepdefinitions;

import components.PageFactory;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.CartPage;
import org.example.InventoryPage;
import org.testng.Assert;
import java.util.HashMap;
import java.util.Map;

public class CartSteps {
    private final InventoryPage inventoryPage;
    private final CartPage cartPage;

    public CartSteps(PageFactory pageFactory) {
        this.inventoryPage = pageFactory.getInventoryPage();
        this.cartPage = pageFactory.getCartPage();
    }

    // Step untuk menambahkan produk ke keranjang
    @When("Buyer add product {string} to Cart")
    public void addSpecificProduct(String item) {
        Assert.assertTrue(inventoryPage.getProductsTitle().isDisplayed());

        Map<String, Runnable> itemActions = new HashMap<>();
        itemActions.put("addToCartBackPack", inventoryPage::addToCartBackPack);
        itemActions.put("addToCartBikeLight", inventoryPage::addToCartBikeLight);

        if (!itemActions.containsKey(item)) {
            throw new IllegalArgumentException("Invalid product: " + item);
        }
        itemActions.get(item).run();
    }

    // Step untuk menambahkan beberapa produk
    @When("Buyer add multiple product to Cart")
    public void addMultipleProducts() {
        inventoryPage.addToCartBackPack();
        inventoryPage.addToCartBikeLight();
    }

    // Step untuk kembali ke halaman produk
    @Then("Buyer return to product list page")
    public void returnToProductList() {
        cartPage.clickContinueShoppingButton();
    }
}