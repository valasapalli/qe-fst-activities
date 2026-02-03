from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.support.ui import Select

# 1. Open browser
driver = webdriver.Firefox()
driver.implicitly_wait(10)

# 2. Open URL
driver.get("https://training-support.net/webelements/selects")

# 3. Print title
print(f"Page title: {driver.title}")


dropdown_element = driver.find_element(By.CSS_SELECTOR, "select")
dropdown_object = Select(dropdown_element)


dropdown_object.select_by_index(1) 
print("Selected the second option.")


dropdown_object.select_by_index(2)
print("Selected the third option.")


dropdown_object.select_by_index(3)
print("Selected the fourth option.")


print("\n--- Available Options ---")
for option in dropdown_object.options:
    print(f"Option: {option.text}")

# 7. Close browser
driver.quit()