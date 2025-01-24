package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class LoginPage {
    private WebDriver driver;
    private WebDriverWait wait;

    // Constructor
    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        PageFactory.initElements(driver, this);
    }

    // Locators
    @FindBy(id = "user-name")
    private WebElement user;

    @FindBy(id = "password")
    private WebElement pass;

    @FindBy(id = "login-button")
    private WebElement loginBtn;

    // Actions
    public void setUsername(String username) {
        user.sendKeys(username);
    }

    public void setPassword(String password) {
        pass.sendKeys(password);
    }

    public void clickLogin() {
        loginBtn.click();
    }
}
