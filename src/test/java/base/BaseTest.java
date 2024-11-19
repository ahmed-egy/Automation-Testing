package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class BaseTest {

    protected WebDriver driver;
    private BufferedWriter writer;

    @BeforeSuite
    public void setUpReport() {
        try {
            // Create the HTML report file
            writer = new BufferedWriter(new FileWriter("TestReport.html"));
            writer.write("<html><head><title>Test Report</title></head><body>");
            writer.write("<h1>Test Execution Report</h1>");
            writer.write("<table border='1'><tr><th>Test Name</th><th>Result</th></tr>");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.demoblaze.com/index.html");
    }

    @AfterMethod
    public void tearDown(ITestResult result) {
        // Log the test result to the HTML report
        try {
            writer.write("<tr>");
            writer.write("<td>" + result.getMethod().getMethodName() + "</td>");
            if (result.getStatus() == ITestResult.SUCCESS) {
                writer.write("<td style='color:green;'>Passed</td>");
            } else if (result.getStatus() == ITestResult.FAILURE) {
                writer.write("<td style='color:red;'>Failed</td>");
            }
            writer.write("</tr>");
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Quit the driver after each test
        if (driver != null) {
            driver.quit();
        }
    }

    @AfterSuite
    public void closeReport() {
        try {
            if (writer != null) {
                // Finalize the HTML structure
                writer.write("</table>");
                writer.write("</body></html>");
                writer.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
