package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ContactPage;
import base.BaseTest;

public class ContactTest extends BaseTest {

    @Test
    public void testSendEmptyContactForm() throws InterruptedException {
        ContactPage contactPage = new ContactPage(driver);

        // Open the contact form
        contactPage.openContactForm();

        Thread.sleep(5000); // Wait for 5 seconds (for racing)

        // Send message without filling any fields
        contactPage.sendEmptyMessage();

        Thread.sleep(5000); // Wait for 5 seconds (for racing)

        // Get the alert message
        String alertMessage = contactPage.getAlertMessage();

        // Assert that the correct error message is displayed (customize as per actual alert message)
        Assert.assertEquals(alertMessage, "Please fill out the required fields", "Unexpected alert message for empty contact form.");
    }
}
