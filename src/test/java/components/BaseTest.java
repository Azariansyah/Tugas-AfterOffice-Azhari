package components;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class BaseTest {

    public WebDriver driver;

    public WebDriver initializeDriver() throws IOException {
        Properties properties = new Properties();
        FileInputStream fileInputStream = new FileInputStream("src/main/resources/GlobalData.properties");

        properties.load(fileInputStream);
        String browserName = properties.getProperty("browser").trim();

        System.out.println("Browser Name: [" + browserName + "]");

        if (browserName.equalsIgnoreCase("chrome")) { // Case-insensitive check
            // Driver chrome
            System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
            driver = new ChromeDriver();
        } else if (browserName.equalsIgnoreCase("firefox")) { // Explicit Firefox check
            try {
            // Driver firefox
            System.setProperty("webdriver.gecko.driver", "C:\\Users\\Azhari Iriansyah\\IdeaProjects\\Tugas-AfterOffice-Azhari\\src\\main\\resources\\geckodriver.exe");
            driver = new FirefoxDriver();
            } catch (Exception e) {
                System.err.println("Failed to initialize FirefoxDriver: " + e.getMessage());
                throw e; // Re-throw to indicate failure
            }
        }
        driver.get("https://www.saucedemo.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        return driver;
    }
}
