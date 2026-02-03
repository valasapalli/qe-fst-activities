from selenium import webdriver
from selenium.webdriver.common.by import By
import time


driver = webdriver.Firefox()
driver.maximize_window()


driver.get("https://training-support.net/webelements/tables")

time.sleep(2)


print("Page Title:", driver.title)


table = driver.find_element(By.XPATH, "//table")


rows = table.find_elements(By.XPATH, ".//tbody/tr")
print("Number of rows:", len(rows))


columns = table.find_elements(By.XPATH, ".//thead/tr/th")
print("Number of columns:", len(columns))


book_before_sort = driver.find_element(
    By.XPATH, "//table/tbody/tr[5]/td[2]"
)
print("Book Name in 5th row before sorting:",
      book_before_sort.text)


price_header = driver.find_element(
    By.XPATH, "//table/thead/tr/th[text()='Price']"
)
price_header.click()

time.sleep(2)


book_after_sort = driver.find_element(
    By.XPATH, "//table/tbody/tr[5]/td[2]"A
)
print("Book Name in 5th row after sorting:",
      book_after_sort.text)


driver.quit()