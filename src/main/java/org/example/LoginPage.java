package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends AbstractComponent {
    @FindBy(id = "user-name")
    private WebElement user;

    @FindBy(id = "password")
    private WebElement pass;

    @FindBy(id = "login-button")
    private WebElement loginBtn;

    public LoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void setUsername(String username) {
        user.sendKeys(username);
    }

    public void setPassword(String password) {
        pass.sendKeys(password);
    }

    public void clickLogin() {
        loginBtn.click();
        // Metode lainnya tetap sama
    }
}