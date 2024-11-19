package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CategoryPage;
import base.BaseTest;

public class CategoryTest extends BaseTest {

    @Test
    public void testSelectLaptopsCategory() throws InterruptedException {
        CategoryPage categoryPage = new CategoryPage(driver);

        Thread.sleep(5000); // Wait for 5 seconds (for racing)

        // Select the Laptops category
        categoryPage.selectLaptopsCategory();

        Thread.sleep(5000); // Wait for 5 seconds (for racing)

        // Assert that the products in the Laptops category are displayed
        Assert.assertTrue(categoryPage.isProductDisplayedInCategory(), "No products are displayed in the Laptops category.");
    }
}
