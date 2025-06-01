package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestSelenium {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        //WebDriverManager.chromedriver().setup();
        // System.setProperty("webdriver.chrome.driver", "path/to/chromedriver"); // if needed
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void testDownloadLambdaTestFile() throws InterruptedException {

        // Navigate to the page
        driver.get("https://the-internet.herokuapp.com/download");

        // Find and click on the download link
        WebElement fileLink = driver.findElement(By.linkText("LambdaTest.txt"));
        fileLink.click();

        // Optional: wait to let the download begin
        Thread.sleep(3000);
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
