package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutCompletePage extends AbstractComponent {
    @FindBy(className = "complete-header")
    private WebElement completeHeader;

    @FindBy(id = "back-to-products")
    private WebElement backToProductsButton;

    public CheckoutCompletePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this); // TAMBAHKAN INI

    }

    public String getCompleteHeaderText() {
        return completeHeader.getText();
    }

    public void setBackToProductsButton() {
        backToProductsButton.click();
    }
}