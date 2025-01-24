import org.example.CartPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckoutTest extends InventoryTest {
    private CartPage cartPage;

    @Test(dependsOnGroups = "inventory")
    public void testCheckout() {
        // Use `driver` from the parent class (LoginTest)
        cartPage = new CartPage(driver);

        // Click "Checkout"
        cartPage.clickCheckoutButton();
        System.out.println("Checkout button clicked!");
        Assert.assertTrue(driver.getCurrentUrl().contains("checkout-step-one.html"));
    }
}