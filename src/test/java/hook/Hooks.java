package hook;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {
    private static final ThreadLocal<WebDriver> driverThreadLocal = new ThreadLocal<>();

    @Before
    public void setupAutomation() throws IOException {
        try {
            if (driverThreadLocal.get() == null) {
                Properties properties = new Properties();
                FileInputStream file = new FileInputStream("src/main/resources/GlobalData.properties");
                properties.load(file);
                String browserName = properties.getProperty("browser").trim();

                WebDriver instance = null;
                String driverPath = System.getProperty("user.dir") + "/src/main/resources/";

                if (browserName.equalsIgnoreCase("chrome")) {
                    System.setProperty("webdriver.chrome.driver", driverPath + "chromedriver.exe");
                    ChromeOptions options = new ChromeOptions();
                    options.addArguments("--remote-allow-origins=*");
                    instance = new ChromeDriver(options);
                }
                else if (browserName.equalsIgnoreCase("firefox")) {
                    System.setProperty("webdriver.gecko.driver", driverPath + "geckodriver.exe");
                    FirefoxOptions options = new FirefoxOptions();
                    options.setBinary("C:\\Program Files\\Mozilla Firefox\\firefox.exe");
                    options.addArguments("--headless"); // Try if normal mode fails
                    options.addArguments("--no-sandbox");
                    instance = new FirefoxDriver(options);
                }

                if (instance != null) {
                    instance.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
                    instance.manage().window().maximize();
                    instance.get("https://www.saucedemo.com/");
                    driverThreadLocal.set(instance);
                }
            }
        } catch (Exception e) {
            System.err.println("Failed to initialize WebDriver: " + e.getMessage());
            throw new RuntimeException("WebDriver initialization failed", e);
        }
    }

    @After
    public void tearDownAutomation() {
        WebDriver driver = driverThreadLocal.get();
        if (driver != null) {
            driver.quit();
            driverThreadLocal.remove();
        }
    }

    public static WebDriver getDriver() {
        return driverThreadLocal.get();
    }
}