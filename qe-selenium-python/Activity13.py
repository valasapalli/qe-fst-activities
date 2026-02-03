from selenium import webdriver
from selenium.webdriver.common.by import By


driver = webdriver.Chrome()
driver.maximize_window()


driver.get("https://training-support.net/webelements/tables")

print("Page Title:", driver.title)


table = driver.find_element(By.XPATH, "//table")


rows = table.find_elements(By.XPATH, ".//tbody/tr")
print("Number of Rows:", len(rows))


columns = table.find_elements(By.XPATH, ".//thead/tr/th")
print("Number of Columns:", len(columns))


print("Values in 3rd Row:")
third_row = table.find_elements(By.XPATH, ".//tbody/tr[3]/td")
for cell in third_row:
    print(cell.text)

cell_value = table.find_element(By.XPATH, ".//tbody/tr[2]/td[2]")
print("Value at 2nd row 2nd column:", cell_value.text)

driver.quit()