package stepdefinitions;

import components.PageFactory;
import io.cucumber.java.en.Given;
import org.example.LoginPage;

public class LoginSteps {
    private final LoginPage loginPage;

    // Dependency Injection via constructor
    public LoginSteps(PageFactory pageFactory) {
        this.loginPage = pageFactory.getLoginPage();
    }

    @Given("Buyer logged to website username {string} and password {string}")
    public void loginWithCredentials(String username, String password) {
        loginPage.setUsername(username);
        loginPage.setPassword(password);
        loginPage.clickLogin();
    }

    @Given("Buyer logged to website")
    public void buyerLoggedToWebsite() {
        loginPage.setUsername("standard_user");
        loginPage.setPassword("secret_sauce");
        loginPage.clickLogin();
    }
}