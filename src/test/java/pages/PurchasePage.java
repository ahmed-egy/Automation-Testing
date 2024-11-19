package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PurchasePage {
    private WebDriver driver;
    private WebDriverWait wait;

    // Locators for purchase form elements
    private By placeOrderButton = By.xpath("//button[text()='Place Order']");
    private By purchaseButton = By.xpath("//button[text()='Purchase']");

    // Constructor
    public PurchasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));  // 10-second wait
    }


    // Click on the "Place Order" button
    public void clickPlaceOrder() {
        driver.findElement(placeOrderButton).click();
    }

    public boolean isPurchaseButtonDisplayed() {
        return driver.findElement(purchaseButton).isDisplayed();
    }

    // Attempt to complete the purchase with empty fields
    public void clickPurchase() {
        driver.findElement(purchaseButton).click();
    }

}
