package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class CartPage {
    private WebDriver driver;
    private WebDriverWait wait;

    // Locators
    private By addToCartButton = By.xpath("//a[contains(text(), 'Add to cart')]");
    private By cartLink = By.id("cartur");
    private By cartProduct = By.xpath("//tbody/tr/td[2]");
    private By deleteButton = By.xpath("//tbody/tr/td[4]/a");

    // Constructor
    public CartPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));  // Updated constructor
    }

    // Actions
    public void addProductToCart(String productName) {
        // Navigate to the product page (e.g., Samsung Galaxy S6)
        driver.findElement(By.linkText(productName)).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[contains(text(), '" + productName + "')]")));

        // Click on the "Add to cart" button
        driver.findElement(addToCartButton).click();
    }

    public String getAlertMessage() throws InterruptedException {
        // Switch to the alert
        org.openqa.selenium.Alert alert = driver.switchTo().alert();
        String alertText = alert.getText();
        Thread.sleep(500); // Wait for 0.5 seconds (for racing)
        alert.accept();  // Accept the alert (or use alert.dismiss())
        return alertText; // Return the alert message
    }

    public void openCart() throws InterruptedException {
        driver.findElement(cartLink).click();
        Thread.sleep(10000); // Wait for 10 seconds (for loading)
        wait.until(ExpectedConditions.visibilityOfElementLocated(cartProduct));
    }

    public void openEmptyCart() throws InterruptedException {
        driver.findElement(cartLink).click();
        Thread.sleep(5000); // Wait for 10 seconds (for racing)
    }

    public String getCartProduct() {
        return driver.findElement(cartProduct).getText();
    }

    public void deleteProductFromCart() {
        driver.findElement(deleteButton).click();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//tbody/tr")));
    }

    public boolean isCartEmpty() {
        return driver.findElements(By.xpath("//tbody/tr")).isEmpty();
    }
}
