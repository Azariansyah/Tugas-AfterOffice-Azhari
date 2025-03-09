package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.time.Duration;

public class CompletePurchaseTestNGTest {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://www.saucedemo.com/");
    }

    @Test
    public void completePurchaseFlow() {
        // 1. Login with standard user
        LoginPage loginPage = new LoginPage(driver);
        loginPage.setUsername("standard_user");
        loginPage.setPassword("secret_sauce");
        loginPage.clickLogin();


        // 2. Add item to cart
        InventoryPage inventoryPage = new InventoryPage(driver);
        Assert.assertTrue(inventoryPage.getProductsTitle().isDisplayed(), "Products title not displayed after login.");
        inventoryPage.selectProductSort("az");
        inventoryPage.addToCartBackPack();

        // 3. Navigate to cart and checkout
        inventoryPage.openCart();
        CartPage cartPage = new CartPage(driver);
        cartPage.clickCheckoutButton();

        // 4. Fill checkout information
        CheckOutStepOnePage checkOutStepOnePage = new CheckOutStepOnePage(driver);
        checkOutStepOnePage.setFirstName("John");
        checkOutStepOnePage.setLastName("Doe");
        checkOutStepOnePage.setPostalCode("12345");
        checkOutStepOnePage.clickContinueButton();

        // 5. Complete purchase
        CheckOutStepTwoPage checkOutStepTwoPage = new CheckOutStepTwoPage(driver);
        Assert.assertEquals(checkOutStepTwoPage.getPageTitleElement().getText(), "Checkout: Overview", "Not on checkout overview page.");
        Assert.assertTrue(checkOutStepTwoPage.getInventoryItem().isDisplayed(), "Item not present in checkout.");
        checkOutStepTwoPage.clickFinishButton();

        CheckoutCompletePage checkoutCompletePage = new CheckoutCompletePage(driver);
        Assert.assertEquals(checkoutCompletePage.getCompleteHeaderText(), "Thank you for your order!", "Order completion message not displayed.");

    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}