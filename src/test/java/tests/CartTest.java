package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CartPage;

public class CartTest extends BaseTest {

    @Test
    public void addToCartTest() throws InterruptedException {
        CartPage cartPage = new CartPage(driver);

        Thread.sleep(10000); // Wait for 10 seconds (for racing)

        // Add Samsung Galaxy S6 to the cart
        cartPage.addProductToCart("Samsung galaxy s6");

        Thread.sleep(10000); // Wait for 10 seconds (for loading)

        // Handle the alert pop-up and verify the message
        String alertMessage = cartPage.getAlertMessage();
        Assert.assertEquals(alertMessage, "Product added", "The product was not added to the cart!");

        // Verify the product is in the cart
        cartPage.openCart();
        String cartProduct = cartPage.getCartProduct();
        Assert.assertTrue(cartProduct.contains("Samsung galaxy s6"), "Product is not in the cart!");
    }

    @Test
    public void checkCartTest() throws InterruptedException {
        CartPage cartPage = new CartPage(driver);
        Thread.sleep(10000); // Wait for 10 seconds (for racing)

        // Navigate to the cart
        cartPage.openEmptyCart();

        // Verify the cart is empty
        boolean isCartEmpty = cartPage.isCartEmpty();
        Assert.assertFalse(isCartEmpty, "The cart is empty after closing and reopening website");

    }
    @Test
    public void deleteFromCartTest() throws InterruptedException {
        CartPage cartPage = new CartPage(driver);

        Thread.sleep(10000); // Wait for 10 seconds (for racing)

        // Add Samsung Galaxy S6 to the cart
        cartPage.addProductToCart("Samsung galaxy s6");

        Thread.sleep(10000); // Wait for 10 seconds (for loading)

        // Handle the alert pop-up and verify the message
        String alertMessage = cartPage.getAlertMessage();
        Assert.assertEquals(alertMessage, "Product added", "The product was not added to the cart!");

        Thread.sleep(5000); // Wait for 10 seconds (for loading)

        // Navigate to the cart
        cartPage.openCart();

        // Delete the first product from the cart
        cartPage.deleteProductFromCart();

        Thread.sleep(5000); // Wait for 5 seconds (for loading)

        // Verify the cart is empty
        boolean isCartEmpty = cartPage.isCartEmpty();
        Assert.assertTrue(isCartEmpty, "The cart is not empty after deleting the product!");

    }
}
