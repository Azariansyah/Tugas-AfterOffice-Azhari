package stepdefinitions;

import components.PageFactory;
import hook.Hooks;
import io.cucumber.java.en.Given;
import org.openqa.selenium.WebDriver;

public class CommonSteps {
    private final WebDriver driver;

    public CommonSteps(PageFactory pageFactory) {
        this.driver = Hooks.getDriver();; // Asumsi ada method getDriver() di PageFactory
    }

    @Given("Buyer landing to ecommerce")
    public void navigateToEcommerce() {
        driver.get("https://www.saucedemo.com/");
    }
}