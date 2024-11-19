package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.PurchasePage;
import base.BaseTest;

public class PurchaseTest extends BaseTest {

    @Test
    public void testEmptyFieldsPurchase() throws InterruptedException {
        CartPage cartPage = new CartPage(driver);
        PurchasePage purchasePage = new PurchasePage(driver);

        Thread.sleep(10000); // Wait for 10 seconds (for loading)

        // Step 1: Add a product to the cart
        cartPage.addProductToCart("Samsung galaxy s6");

        Thread.sleep(15000); // Wait for 10 seconds (for loading)

        // Handle the alert pop-up and verify the message
        String cartAlertMessage = cartPage.getAlertMessage();
        Assert.assertEquals(cartAlertMessage, "Product added", "The product was not added to the cart!");

        // Step 2: Open the cart
        cartPage.openCart();
        Thread.sleep(5000);  // Wait for the cart page to load (adjust if necessary)

        // Step 3: Click "Place Order"
        purchasePage.clickPlaceOrder();
        Thread.sleep(5000);  // Wait for the purchase modal to appear

        // Step 4: Attempt to complete the purchase without filling fields
        purchasePage.clickPurchase();

        Thread.sleep(5000);  // Wait for the purchase modal to appear

        // Step 5: Get the alert message and verify
        String formAlertMessage = cartPage.getAlertMessage();

        Thread.sleep(5000);  // Wait for the purchase modal to appear

        // Assert that the correct error message is displayed (customize based on actual alert)
        Assert.assertEquals(formAlertMessage, "Please fill out Name and Creditcard.", "Unexpected alert message when purchasing with empty fields.");
    }

    @Test
    public void testEmptyCartPurchase() throws InterruptedException {
        CartPage cartPage = new CartPage(driver);
        PurchasePage purchasePage = new PurchasePage(driver);

        Thread.sleep(10000); // Wait for 10 seconds (for loading)

        // Step : Open the cart
        cartPage.openEmptyCart();
        Thread.sleep(5000);  // Wait for the cart page to load (adjust if necessary)

        // Step 2: Click "Place Order"
        purchasePage.clickPlaceOrder();
        Thread.sleep(5000);  // Wait for the purchase modal to appear

        Assert.assertFalse(purchasePage.isPurchaseButtonDisplayed(), "continue to purchase although cart is empty.");

    }
}
