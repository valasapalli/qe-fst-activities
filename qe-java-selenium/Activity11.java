package demos;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Activity11 {
    public static void main(String[] args) {

        WebDriver driver = new FirefoxDriver();
        driver.get("https://training-support.net/webelements/dynamic-controls");
        System.out.println(driver.getTitle());

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        By toggleCheckboxBtn = By.xpath("//button[contains(.,'Toggle Checkbox')]");
        By checkbox = By.cssSelector("input[type='checkbox']");   // <-- FIXED locator

        // 1) Click toggle button to remove checkbox
        wait.until(ExpectedConditions.elementToBeClickable(toggleCheckboxBtn)).click();

        // 2) Wait for checkbox to disappear (not present/visible)
        wait.until(ExpectedConditions.invisibilityOfElementLocated(checkbox));
        System.out.println("Checkbox is removed (not visible).");

        // 3) Click toggle button to add checkbox back
        wait.until(ExpectedConditions.elementToBeClickable(toggleCheckboxBtn)).click();

        // 4) Wait for checkbox to appear
        WebElement cb = wait.until(ExpectedConditions.presenceOfElementLocated(checkbox));
        wait.until(ExpectedConditions.elementToBeClickable(cb));
        System.out.println("Checkbox appeared.");

        // 5) Select checkbox
        if (!cb.isSelected()) {
            cb.click();
        }
        System.out.println("Checkbox selected: " + cb.isSelected());

        // 6) Close browser
        driver.quit();
    }
}