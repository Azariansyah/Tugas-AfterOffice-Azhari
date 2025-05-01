package stepdefinitions;

import components.PageFactory;
import org.example.*;
import io.cucumber.java.en.*;
import org.testng.Assert;


import static hook.Hooks.driver;

public class StepDefinitions {
    private final PageFactory pageFactory;
    private final LoginPage loginPage;
    private final InventoryPage inventoryPage;
    private final CartPage cartPage;
    private final CheckOutStepOnePage checkOutStepOnePage;
    private final CheckOutStepTwoPage checkOutStepTwoPage;
    private final CheckoutCompletePage checkoutCompletePage;

    // Constructor: Initialize PageFactory dengan driver dari Hooks
    public StepDefinitions() {
        this.pageFactory = new PageFactory(driver);
        this.loginPage = pageFactory.getLoginPage();
        this.inventoryPage = pageFactory.getInventoryPage();
        this.cartPage = pageFactory.getCartPage();
        this.checkOutStepOnePage = pageFactory.getCheckOutStepOnePage();
        this.checkOutStepTwoPage = pageFactory.getCheckOutStepTwoPage();
        this.checkoutCompletePage = pageFactory.getCheckoutCompletePage();
    }

    @Given("Buyer landing to ecommerce")
    public void navigateToEcommerce() {
        driver.get("https://www.saucedemo.com/");
    }

    @Given("Buyer logged to website username {string} and password {string}")
    public void loginWithCredentials(String username, String password) {
        loginPage.setUsername(username);
        loginPage.setPassword(password);
        loginPage.clickLogin();
    }

    @Given("Buyer logged to website")
    public void buyer_logged_to_website() {
        loginPage.setUsername("standard_user");
        loginPage.setPassword("secret_sauce");
        loginPage.clickLogin();
    }

    @When("Buyer add product to Cart")
    public void buyer_add_product_to_cart() {
        Assert.assertTrue(inventoryPage.getProductsTitle().isDisplayed());
        inventoryPage.addToCartBackPack();
        inventoryPage.openCart();

    }

    @When("Buyer add multiple product to Cart")
    public void addMultipleProducts() {
        inventoryPage.addToCartBackPack();
        inventoryPage.addToCartBikeLight();
    }

    @When("Buyer add product {string} to Cart")
    public void buyer_add_specific_product_to_cart(String item) {
        Assert.assertTrue(inventoryPage.getProductsTitle().isDisplayed());

        switch(item) {
            case "addToCartBackPack":
                inventoryPage.addToCartBackPack();
                break;
            default:
                throw new IllegalArgumentException("Invalid product: " + item);
        }
    }

    @Then("Buyer return to product list page")
    public void returnToProductList() {
        cartPage.clickContinueShoppingButton();
    }

    @And("Navigate to cart and checkout")
    public void navigateToCheckout() {
        inventoryPage.openCart();
        cartPage.clickCheckoutButton();
    }

    @When("Fill checkout information")
    public void fillCheckoutInfo() {
        checkOutStepOnePage.setFirstName("John");
        checkOutStepOnePage.setLastName("Doe");
        checkOutStepOnePage.setPostalCode("12345");
        checkOutStepOnePage.clickContinueButton();
    }

    @When("Fill checkout information setFirstName {string} setLastName {string} PostalCode {string}")
    public void fillCheckoutInfoWithParams(String firstName, String lastName, String postalCode) {
        checkOutStepOnePage.setFirstName(firstName);
        checkOutStepOnePage.setLastName(lastName);
        checkOutStepOnePage.setPostalCode(postalCode);
        checkOutStepOnePage.clickContinueButton();
    }

    @Then("Buyer click complete purchase")
    public void completePurchase() {
        Assert.assertEquals(checkOutStepTwoPage.getPageTitleElement().getText(), "Checkout: Overview");
        checkOutStepTwoPage.clickFinishButton();
        Assert.assertEquals(checkoutCompletePage.getCompleteHeaderText(), "Thank you for your order!");
    }
}