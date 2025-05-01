package stepdefinitions;

import components.PageFactory;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.*;
import org.testng.Assert;

public class CheckoutSteps {
    private final CheckOutStepOnePage checkOutStepOnePage;
    private final CheckOutStepTwoPage checkOutStepTwoPage;
    private final CheckoutCompletePage checkoutCompletePage;
    private final CartPage cartPage;

    public CheckoutSteps(PageFactory pageFactory) {
        this.checkOutStepOnePage = pageFactory.getCheckOutStepOnePage();
        this.checkOutStepTwoPage = pageFactory.getCheckOutStepTwoPage();
        this.checkoutCompletePage = pageFactory.getCheckoutCompletePage();
        this.cartPage = pageFactory.getCartPage();
    }

    // Step untuk navigasi ke checkout
    @When("Navigate to cart and checkout")
    public void navigateToCheckout() {
        cartPage.clickCheckoutButton();
    }

    // Step untuk mengisi informasi checkout
    @When("Fill checkout information")
    public void fillCheckoutInfo() {
        checkOutStepOnePage.setFirstName("John");
        checkOutStepOnePage.setLastName("Doe");
        checkOutStepOnePage.setPostalCode("12345");
        checkOutStepOnePage.clickContinueButton();
    }

    // Step untuk mengisi informasi checkout dengan parameter
    @When("Fill checkout information setFirstName {string} setLastName {string} PostalCode {string}")
    public void fillCheckoutInfoWithParams(String firstName, String lastName, String postalCode) {
        checkOutStepOnePage.setFirstName(firstName);
        checkOutStepOnePage.setLastName(lastName);
        checkOutStepOnePage.setPostalCode(postalCode);
        checkOutStepOnePage.clickContinueButton();
    }

    // Step untuk menyelesaikan pembelian (HANYA DI SINI)
    @Then("Buyer click complete purchase")
    public void completePurchase() {
        Assert.assertEquals(checkOutStepTwoPage.getPageTitleElement().getText(), "Checkout: Overview");
        checkOutStepTwoPage.clickFinishButton();
        Assert.assertEquals(checkoutCompletePage.getCompleteHeaderText(), "Thank you for your order!");
    }
}