import org.example.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LoginTest {
    protected WebDriver driver;
    protected LoginPage loginPage;

    @BeforeClass
    public void setup() {
        System.setProperty("webdriver.chrome.driver",
                "C:\\Users\\ms.azhari.atmaja\\IdeaProjects\\Tugas-AfterOffice - Copy\\src\\main\\resources\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");

        // Initialize LoginPage
        loginPage = new LoginPage(driver);
    }

    @AfterClass
    public void teardown() {
        driver.quit();
    }

    @Test(groups = "login")
    public void testLogin() {
        // Perform login
        loginPage.setUsername("standard_user");
        loginPage.setPassword("secret_sauce");
        loginPage.clickLogin();
        assert driver.getCurrentUrl().contains("inventory.html");
        System.out.println("Login successful!");
    }
}
