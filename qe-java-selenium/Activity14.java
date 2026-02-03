package demos;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;

public class Activity14 {
    public static void main(String[] args) {
        WebDriver driver = new FirefoxDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        try {
            // 1. Open the URL
            driver.get("https://training-support.net/webelements/tables");

            // 2. Print Page Title
            System.out.println("Page title: " + driver.getTitle());

            // 3. Find number of rows and columns
            // Finding rows in the table body (tbody)
            List<WebElement> rows = driver.findElements(By.xpath("//table[contains(@class, 'table-auto')]/tbody/tr"));
            // Finding columns in the first row
            List<WebElement> cols = driver.findElements(By.xpath("//table[contains(@class, 'table-auto')]/thead/tr/th"));

            System.out.println("Number of rows: " + rows.size());
            System.out.println("Number of columns: " + cols.size());

            // 4. Find and print the Book Name in the 5th row (Before Sort)
            // XPath: //tbody/tr[5]/td[2] (Assuming 2nd column is Book Name)
            WebElement book5 = driver.findElement(By.xpath("//table/tbody/tr[5]/td[2]"));
            System.out.println("Book Name in 5th row (Before Sort): " + book5.getText());

            // 5. Click the Price header to sort (usually the 5th column header)
            WebElement priceHeader = driver.findElement(By.xpath("//table/thead/tr/th[5]"));
            priceHeader.click();
            System.out.println("Price header clicked for sorting.");

            // 6. Find and print the Book Name in the 5th row again (After Sort)
            // We re-find the element because the table has refreshed/reordered
            WebElement book5AfterSort = driver.findElement(By.xpath("//table/tbody/tr[5]/td[2]"));
            System.out.println("Book Name in 5th row (After Sort): " + book5AfterSort.getText());

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            // 7. Close the browser
            driver.quit();
        }
    }
}