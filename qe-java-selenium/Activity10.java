package demos;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class Activity10 {
    public static void main(String[] args) {
        WebDriver driver = new FirefoxDriver();
        // Set up a wait object for stability
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        Actions builder = new Actions(driver);

        try {
            driver.get("https://training-support.net/webelements/drag-drop");
            System.out.println("Page Title: " + driver.getTitle());

            // Find elements
            WebElement ball = driver.findElement(By.id("ball"));
            WebElement d1 = driver.findElement(By.id("dropzone1"));
            WebElement d2 = driver.findElement(By.id("dropzone2"));

            // Drag and drop to Zone 1
            builder.dragAndDrop(ball, d1).pause(Duration.ofMillis(500)).build().perform();
            
            // Verify Dropzone 1 (Check if text changes or ball is inside)
            if (d1.getText().contains("Dropped!")) {
                System.out.println("Ball dropped into Dropzone 1");
            }

            // Drag from Zone 1 to Zone 2
            // Note: We re-find the ball because its position in the DOM has changed
            ball = driver.findElement(By.id("ball"));
            builder.clickAndHold(ball).moveToElement(d2).release().build().perform();
            
            // Verify Dropzone 2
            wait.until(ExpectedConditions.textToBePresentInElement(d2, "Dropped!"));
            System.out.println("Ball dropped into Dropzone 2");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }
}


