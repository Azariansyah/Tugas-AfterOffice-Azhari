package org.example;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutCompletePage {
    @FindBy(className = "complete-header")
    private WebElement completeHeader;

    @FindBy(id = "back-to-products")
    private WebElement backToProductsButton;

    public String getCompleteHeaderText() {
        return completeHeader.getText();
    }

    public void setBackToProductsButton() {
        backToProductsButton.click();
    }
}
