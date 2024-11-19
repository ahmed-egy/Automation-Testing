package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;

public class LoginTest extends BaseTest {

    @Test
    public void validLoginTest() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        Thread.sleep(3000); // Wait for 3 seconds (for loading)
        loginPage.login("hello123456", "hello");
        Thread.sleep(15000); // Wait for 5 seconds (for loading)
        Assert.assertTrue(loginPage.isLogoutButtonDisplayed(), "Login failed, logout button not displayed.");
    }

    @Test
    public void invalidLoginTest() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        Thread.sleep(3000); // Wait for 1 seconds (for loading)
        loginPage.login("wrongUser", "wrongPassword");
        Thread.sleep(15000); // Wait for 1 seconds (for racing)
        String alertMessage = loginPage.getAlertMessage();
        Thread.sleep(2000); // Wait for 2 seconds (for racing)
        Assert.assertTrue(alertMessage.contains("User does not exist."), "Error message for invalid login is incorrect.");
    }

    @Test
    public void loginWithEmptyUsername() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("", "hello");
        Thread.sleep(6000); // Wait for 1 seconds (for racing)
        String alertMessage = loginPage.getAlertMessage();
        Thread.sleep(2000); // Wait for 2 seconds (for racing)
        Assert.assertTrue(alertMessage.contains("Please fill out Username and Password."), "Error message for invalid login is incorrect.");
    }

    @Test
    public void loginWithEmptyPassword() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("hello123456", "");
        Thread.sleep(6000); // Wait for 1 seconds (for racing)
        String alertMessage = loginPage.getAlertMessage();
        Thread.sleep(2000); // Wait for 2 seconds (for racing)
        Assert.assertTrue(alertMessage.contains("Please fill out Username and Password."), "Error message for invalid login is incorrect.");
    }

    @Test
    public void loginWithEmptyUsernameAndPassword() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("", "");
        Thread.sleep(6000); // Wait for 1 seconds (for racing)
        String alertMessage = loginPage.getAlertMessage();
        Thread.sleep(2000); // Wait for 2 seconds (for racing)
        Assert.assertTrue(alertMessage.contains("Please fill out Username and Password."), "Error message for invalid login is incorrect.");
    }

}
