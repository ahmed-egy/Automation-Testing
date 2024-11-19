package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private WebDriver driver;

    // Locators
    private By loginButton = By.id("login2");
    private By usernameField = By.id("loginusername");
    private By passwordField = By.id("loginpassword");
    private By submitLogin = By.xpath("//button[text()='Log in']");
    private By logoutButton = By.id("logout2");
    private By closeButton = By.xpath("//button[text()='Close']");


    // Constructor
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    // Page actions
    public void openLoginModal() {
        driver.findElement(loginButton).click();
    }

    public void enterUsername(String username) {
        driver.findElement(usernameField).sendKeys(username);
    }

    public void enterPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }

    public void submitLogin() {
        driver.findElement(submitLogin).click();
    }

    public String getAlertMessage() throws InterruptedException {
        // Switch to the alert
        Alert alert = driver.switchTo().alert();
        // Get the alert text
        String alertText = alert.getText();
        Thread.sleep(1000); // Wait for 2 seconds (for racing)
        // Optionally accept the alert to close it
        alert.accept();  // or alert.dismiss() if you want to cancel
        return alertText; // Return the alert message
    }

    public boolean isLogoutButtonDisplayed() {
        return driver.findElement(logoutButton).isDisplayed();
    }

    public void closeModal() {
        driver.findElement(closeButton).click();
    }

    // Combined login method
    public void login(String username, String password) throws InterruptedException {
        openLoginModal();
        Thread.sleep(1000); // Wait for 1 seconds (for demo purposes)
        enterUsername(username);
        Thread.sleep(1000); // Wait for 1 seconds (for demo purposes)
        enterPassword(password);
        Thread.sleep(1000); // Wait for 1 seconds (for demo purposes)
        submitLogin();
    }
}
