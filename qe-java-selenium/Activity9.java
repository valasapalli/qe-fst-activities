package demos;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class Activity9 {

    public static void main(String[] args) {
        // Create WebDriver instance
        WebDriver driver = new FirefoxDriver();
        // Create Wait instance
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        // Create Actions instance
        Actions builder = new Actions(driver);

        try {
            // Open the page
            driver.get("https://training-support.net/webelements/keyboard-events");

            // Print page title
            System.out.println("Title: " + driver.getTitle());

            // 1. Press a key (e.g., "S") using the Actions class
            // This is more "correct" for a Keyboard Events activity
            builder.sendKeys("Hello Selenium!").sendKeys(Keys.RETURN).build().perform();

            // 2. Wait for the result element to be visible and contain text
            WebElement result = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("h1.mt-3")));
            
            // Print the result message
            System.out.println("Message displayed: " + result.getText());

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Close the browser
            driver.quit();
        }
    }
}