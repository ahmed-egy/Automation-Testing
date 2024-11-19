package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.Alert;

import java.time.Duration;

public class ContactPage {
    private WebDriver driver;
    private WebDriverWait wait;

    // Locators for contact form elements
    private By contactLink = By.linkText("Contact");
    private By sendMessageButton = By.xpath("//button[text()='Send message']");

    public ContactPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));  // 10-second wait
    }

    // Method to open the contact form
    public void openContactForm() {
        driver.findElement(contactLink).click();
    }

    // Method to send the message without filling any fields
    public void sendEmptyMessage() {
        driver.findElement(sendMessageButton).click();
    }

    // Method to get alert text
    public String getAlertMessage() {
        wait.until(ExpectedConditions.alertIsPresent());  // Wait for the alert to appear
        Alert alert = driver.switchTo().alert();
        String alertText = alert.getText();  // Get the alert text
        alert.accept();  // Accept the alert to close it
        return alertText;
    }
}
