package stepdefinitions;

import components.PageFactory;
import components.WebDriverProvider;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class BaseStep {
    protected final WebDriver driver;
    protected final PageFactory pageFactory;

    public BaseStep(WebDriverProvider webDriverProvider, PageFactory pageFactory) {
        this.driver = webDriverProvider.getDriver();
        this.pageFactory = pageFactory;
    }

    // Method untuk navigasi
    protected void navigateTo(String url) {
        driver.get(url);
    }

    // Method untuk assertion
    protected void assertElementDisplayed(WebElement element) {
        Assert.assertTrue(element.isDisplayed(), "Element not displayed");
    }
}