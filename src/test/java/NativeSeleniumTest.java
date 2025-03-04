import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class NativeSeleniumTest {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-gpu");
        options.addArguments("--window-size=1920,1080");

        WebDriver driver = new ChromeDriver(options);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        try {
            // Buka halaman login
            driver.get("https://www.saucedemo.com/");
            driver.manage().window().maximize();

            // Login
            driver.findElement(By.id("user-name")).sendKeys("standard_user");
            driver.findElement(By.id("password")).sendKeys("secret_sauce");
            driver.findElement(By.id("login-button")).click();

            // Verifikasi login berhasil
            wait.until(ExpectedConditions.urlContains("inventory"));

            // Tambahkan item ke keranjang
            driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();

            // Buka keranjang
            driver.findElement(By.cssSelector(".shopping_cart_link")).click();

            // Proses checkout
            wait.until(ExpectedConditions.elementToBeClickable(
                    By.cssSelector(".btn_medium.checkout_button"))).click();

            // Isi form checkout
            WebElement firstName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("first-name")));
            firstName.sendKeys("John");

            driver.findElement(By.id("last-name")).sendKeys("Doe");
            driver.findElement(By.id("postal-code")).sendKeys("12345");

            driver.findElement(By.cssSelector(".btn_primary.cart_button")).click();

            // Selesaikan checkout
            wait.until(ExpectedConditions.elementToBeClickable(By.id("finish"))).click();

            // Verifikasi pesanan selesai
            WebElement completeHeader = wait.until(
                    ExpectedConditions.visibilityOfElementLocated(By.className("complete-header")));

            if(completeHeader.getText().equals("Thank you for your order!")) {
                System.out.println("Test berhasil! Pesanan selesai.");
            } else {
                System.out.println("Test gagal! Pesanan tidak terkonfirmasi.");
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }
}