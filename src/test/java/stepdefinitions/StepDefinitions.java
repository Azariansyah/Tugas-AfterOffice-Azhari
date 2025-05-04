package stepdefinitions;
import org.example.PageFactory;
import hook.Hooks;
import org.example.*;
import io.cucumber.java.en.*;
import org.testng.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class StepDefinitions {
    private final WebDriver driver;
    private final WebDriverWait wait;
    private final PageFactory pageFactory;
    private final LoginPage loginPage;
    private final InventoryPage inventoryPage;
    private final CartPage cartPage;
    private final CheckOutStepOnePage checkOutStepOnePage;
    private final CheckOutStepTwoPage checkOutStepTwoPage;
    private final CheckoutCompletePage checkoutCompletePage;

    // Constructor: Initialize PageFactory dengan driver dari Hooks
    public StepDefinitions() {
        this.driver = Hooks.getDriver();
        if (this.driver == null) {
            throw new IllegalStateException("WebDriver not initialized!");
        }
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        this.pageFactory = new PageFactory (driver);
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
        inventoryPage.openCart();
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
        inventoryPage.openCart();
    }

    @Then("Buyer return to product list page")
    public void returnToProductList() {
        cartPage.clickContinueShoppingButton();
    }

    @When("Navigate to cart and checkout")
    public void navigateToCheckout() {
        Assert.assertTrue(cartPage.getCartTitle().isDisplayed());
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