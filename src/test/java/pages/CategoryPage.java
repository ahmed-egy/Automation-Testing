package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class CategoryPage {
    private WebDriver driver;
    private WebDriverWait wait;

    // Locators for category links
    private By laptopsCategory = By.linkText("Laptops");
    private By phonesCategory = By.linkText("Phones");
    private By monitorsCategory = By.linkText("Monitors");

    // Locator for products in the selected category
    private By productContainer = By.cssSelector(".card-block");

    public CategoryPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Set a 10-second wait
    }

    // Method to select the Laptops category
    public void selectLaptopsCategory() {
        driver.findElement(laptopsCategory).click();
    }

    // Verify if products in the selected category are displayed
    public boolean isProductDisplayedInCategory() {
        // Wait for products to be displayed
        List<WebElement> products = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(productContainer));
        // Return true if at least one product is displayed
        return products.size() > 0;
    }
}
