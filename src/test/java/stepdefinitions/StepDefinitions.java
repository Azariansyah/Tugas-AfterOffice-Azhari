package stepdefinitions;

import components.BaseTest;
import org.example.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.testng.Assert;

import java.io.IOException;
import java.time.Duration;

public class StepDefinitions extends BaseTest {
    WebDriver driver;
    LoginPage loginPage;
    InventoryPage inventoryPage;
    CartPage cartPage;
    CheckOutStepOnePage checkOutStepOnePage;
    CheckOutStepTwoPage checkOutStepTwoPage;
    CheckoutCompletePage checkoutCompletePage;

    @Before
    public void landingPage() throws IOException {
        driver=initializeDriver();
    }

        @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    // ========== BACKGROUND STEP ==========
    @Given("Buyer landing to ecommerce")
    public void buyer_landing_to_ecommerce() {
        driver.get("https://www.saucedemo.com/");
    }

    // ========== REGULAR SCENARIO STEPS ==========
    @Given("Buyer logged to website")
    public void buyer_logged_to_website() {
        loginPage = new LoginPage(driver);
        loginPage.setUsername("standard_user");
        loginPage.setPassword("secret_sauce");
        loginPage.clickLogin();
    }

    @When("Buyer add product to Cart")
    public void buyer_add_product_to_cart() {
        inventoryPage = new InventoryPage(driver);
        Assert.assertTrue(inventoryPage.getProductsTitle().isDisplayed());
        inventoryPage.addToCartBackPack();
    }
    @When("Buyer add multiple product to Cart")
    public void multiple_product_to_cart() {
        inventoryPage = new InventoryPage(driver);
        Assert.assertTrue(inventoryPage.getProductsTitle().isDisplayed());
        inventoryPage.addToCartBackPack();
        inventoryPage.addToCartBikeLight();
        inventoryPage.addToCartBoltTShirt();
    }
    @Then("Buyer return to product list page")
    public void return_to_product_list_page() {
        inventoryPage.openCart();
        cartPage = new CartPage(driver);
        cartPage.clickContinueShoppingButton();
    }


    @When("Fill checkout information")
    public void fill_checkout_information() {
        checkOutStepOnePage = new CheckOutStepOnePage(driver);
        checkOutStepOnePage.setFirstName("John");
        checkOutStepOnePage.setLastName("Doe");
        checkOutStepOnePage.setPostalCode("12345");
        checkOutStepOnePage.clickContinueButton();
    }

    // ========== SCENARIO OUTLINE STEPS ==========
    @Given("Buyer logged to website username {string} and password {string}")
    public void buyer_logged_to_website_with_credentials(String username, String password) {
        loginPage = new LoginPage(driver);
        loginPage.setUsername(username);
        loginPage.setPassword(password);
        loginPage.clickLogin();

    }
        @When("Buyer add product {string} to Cart")
        public void buyer_add_specific_product_to_cart(String item) {
            inventoryPage = new InventoryPage(driver);
            Assert.assertTrue(inventoryPage.getProductsTitle().isDisplayed());

            switch(item) {
                case "addToCartBackPack":
                    inventoryPage.addToCartBackPack();
                    break;
                default:
                    throw new IllegalArgumentException("Invalid product: " + item);
            }
        }

    @When("Fill checkout information setFirstName {string} setLastName {string} PostalCode {string}")
    public void fill_checkout_information_with_parameters(String firstName, String lastName, String postalCode) {
        checkOutStepOnePage = new CheckOutStepOnePage(driver);
        checkOutStepOnePage.setFirstName(firstName);
        checkOutStepOnePage.setLastName(lastName);
        checkOutStepOnePage.setPostalCode(postalCode);
        checkOutStepOnePage.clickContinueButton();
    }
    // ========== COMMON STEPS ==========
    @When("Navigate to cart and checkout")
    public void navigate_to_cart_and_checkout() {
        inventoryPage.openCart();
        cartPage = new CartPage(driver);
        cartPage.clickCheckoutButton();
    }

    @Then("Buyer click complete purchase")
    public void buyer_click_complete_purchase() {
        checkOutStepTwoPage = new CheckOutStepTwoPage(driver);
        Assert.assertEquals(checkOutStepTwoPage.getPageTitleElement().getText(), "Checkout: Overview");
        checkOutStepTwoPage.clickFinishButton();

        checkoutCompletePage = new CheckoutCompletePage(driver);
        Assert.assertEquals(checkoutCompletePage.getCompleteHeaderText(), "Thank you for your order!");
    }
}