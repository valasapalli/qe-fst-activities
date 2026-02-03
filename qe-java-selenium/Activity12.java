package demos;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class Activity12 {
    public static void main(String[] args) {
        WebDriver driver = new FirefoxDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        try {
            driver.get("https://training-support.net/webelements/dynamic-content");
            
            // 1. Find and click the button
            WebElement clickMeButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("genButton")));
            clickMeButton.click();
            System.out.println("Button clicked. Waiting for 'release' word...");

            // 2. Custom Wait: Wait until the button text (in lowercase) contains "release"
            // This ignores whether the site says "RELEASE", "Release", or "release"
            wait.until(d -> clickMeButton.getText().toLowerCase().contains("release"));

            // 3. Get the text and print it
            String finalText = clickMeButton.getText();
            System.out.println("Text found: " + finalText);

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            // 4. Close the browser
            driver.quit();
        }
    }
}