package hook;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {
    public static WebDriver driver;

    // Setup driver
    @Before
    public void setupAutomation() throws IOException {
        if (driver == null) { // Pastikan hanya diinisialisasi sekali
            Properties properties = new Properties();
            FileInputStream fileInputStream = new FileInputStream("src/main/resources/GlobalData.properties");
            properties.load(fileInputStream);
            String browserName = properties.getProperty("browser").trim();

            if (browserName.equalsIgnoreCase("chrome")) {
                System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
                driver = new ChromeDriver();
            } else if (browserName.equalsIgnoreCase("firefox")) {
                System.setProperty("webdriver.gecko.driver", "src/main/resources/geckodriver.exe");
                FirefoxOptions options = new FirefoxOptions();
                options.setBinary("C:/Program Files/Mozilla Firefox/firefox.exe");
                driver = new FirefoxDriver(options);
            }
            driver.get("https://www.saucedemo.com/");
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
            driver.manage().window().maximize(); // Opsional: maximize window
        }
    }

    // Close driver
    @After
    public void tearDownAutomation() {
        if (driver != null) {
            driver.quit(); // Hanya panggil quit() saja
            driver = null; // Reset driver
        }
    }

    // HAPUS METHOD initializeDriver() INI
    // (Sudah tidak diperlukan karena driver diakses langsung via Hooks.driver)
}