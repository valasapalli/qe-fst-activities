package demos;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class Activity8 {
    public static void main(String[] args) {
        // Initialize the Firefox driver
        WebDriver driver = new FirefoxDriver();
        // Initialize the Actions object
        Actions builder = new Actions(driver);
        // Initialize the Wait object
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        try {
            // Open the page
            driver.get("https://training-support.net/webelements/mouse-events");
            System.out.println("Page title is: " + driver.getTitle());

            // Find elements
            WebElement cargoLock = driver.findElement(By.cssSelector(".file:nth-child(1)"));
            WebElement cargoToml = driver.findElement(By.cssSelector(".file:nth-child(2)"));

            // Perform mouse actions: Click one, move to another, and click
            builder.click(cargoLock)
                   .moveToElement(cargoToml)
                   .click()
                   .build()
                   .perform();

            // Wait for the menu item to appear and then find it
            // Added the missing index '1' in the nth-child
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("li.w-full:nth-child(1)")));
            WebElement openButton = driver.findElement(By.cssSelector("li.w-full:nth-child(1)"));
            
            // Click the menu option
            builder.click(openButton).build().perform();

            // Wait for the result text to appear and print it
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("result")));
            System.out.println("Result is: " + driver.findElement(By.id("result")).getText());

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Close the browser
            driver.quit();
        }
    }
}