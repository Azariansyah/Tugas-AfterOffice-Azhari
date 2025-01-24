import org.example.InventoryPage;
import org.openqa.selenium.support.ui.Wait;
import org.testng.annotations.Test;

public class InventoryTest extends LoginTest {
    private InventoryPage inventoryPage;

    @Test(dependsOnGroups = "login", groups = "inventory")
    public void testAddToCart() {
        // Use `driver` from the parent class (LoginTest)
        inventoryPage = new InventoryPage(driver);

        // Click "Add to Cart"
        inventoryPage.addToCart();

        // Click Cart icon
        inventoryPage.openCart();
        System.out.println("Item added to cart and cart opened!");
    }
}