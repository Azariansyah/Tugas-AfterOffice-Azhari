package components;

import org.example.*;
import org.openqa.selenium.WebDriver;

public class PageFactory {
    private final WebDriver driver;
    private LoginPage loginPage;
    private InventoryPage inventoryPage;
    private CartPage cartPage;
    private CheckOutStepOnePage checkOutStepOnePage;
    private CheckOutStepTwoPage checkOutStepTwoPage;
    private CheckoutCompletePage checkoutCompletePage;

    // Gunakan WebDriver langsung, bukan via WebDriverProvider
    public PageFactory(WebDriver driver) {
        this.driver = driver;
    }

    // Lazy initialization untuk semua halaman (tetap sama)
    public LoginPage getLoginPage() {
        if (loginPage == null) {
            loginPage = new LoginPage(driver);
        }
        return loginPage;
    }

    public InventoryPage getInventoryPage() {
        if (inventoryPage == null) {
            inventoryPage = new InventoryPage(driver);
        }
        return inventoryPage;
    }

    public CartPage getCartPage() {
        if (cartPage == null) {
            cartPage = new CartPage(driver);
        }
        return cartPage;
    }

    public CheckOutStepOnePage getCheckOutStepOnePage() {
        if (checkOutStepOnePage == null) {
            checkOutStepOnePage = new CheckOutStepOnePage(driver);
        }
        return checkOutStepOnePage;
    }

    public CheckOutStepTwoPage getCheckOutStepTwoPage() {
        if (checkOutStepTwoPage == null) {
            checkOutStepTwoPage = new CheckOutStepTwoPage(driver);
        }
        return checkOutStepTwoPage;
    }

    public CheckoutCompletePage getCheckoutCompletePage() {
        if (checkoutCompletePage == null) {
            checkoutCompletePage = new CheckoutCompletePage(driver);
        }
        return checkoutCompletePage;
    }
}