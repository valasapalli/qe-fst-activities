package demos;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.util.List;

public class Activity13 {
    public static void main(String[] args) {
        // Create a new instance of the Firefox driver
        WebDriver driver = new FirefoxDriver();

        try {
            // 1. Open the browser to the specified URL
            driver.get("https://training-support.net/webelements/tables");

            // 2. Get the title of the page and print it
            System.out.println("Page title is: " + driver.getTitle());

            // Note: Use 'tr' to find rows
            List<WebElement> rows = driver.findElements(By.xpath("//table[contains(@class, 'table-auto')]/tbody/tr"));
            System.out.println("Number of rows: " + rows.size());

            
            List<WebElement> cols = driver.findElements(By.xpath("//table[contains(@class, 'table-auto')]/thead/tr/th"));
            System.out.println("Number of columns: " + cols.size());

            // 5. Find and print all cell values in the third row of the table
            List<WebElement> thirdRowCells = driver.findElements(By.xpath("//table[contains(@class, 'table-auto')]/tbody/tr[3]/td"));
            System.out.println("Values in the third row:");
            for (WebElement cell : thirdRowCells) {
                System.out.println(cell.getText());
            }

            // 6. Find and print the cell value at the second row, second column
            WebElement secondRowSecondCol = driver.findElement(By.xpath("//table[contains(@class, 'table-auto')]/tbody/tr[2]/td[2]"));
            System.out.println("Value at 2nd row, 2nd column: " + secondRowSecondCol.getText());

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 7. Close the browser
            //driver.quit();//
        }
    }
}
