package components;

import hook.Hooks;
import org.openqa.selenium.WebDriver;

/**
 * WebDriver provider class for dependency injection with PicoContainer.
 * This class serves as a bridge between the ThreadLocal WebDriver in Hooks
 * and the dependency injection framework.
 */
public class WebDriverProvider {

    private final WebDriver driver;

    public WebDriverProvider() {
        // Get the WebDriver instance from Hooks
        this.driver = Hooks.getDriver();
        if (this.driver == null) {
            throw new RuntimeException("WebDriver is not initialized. Make sure Hooks.setUp() is called before this class is instantiated.");
        }
    }

    public WebDriver getDriver() {
        return driver;
    }
}
