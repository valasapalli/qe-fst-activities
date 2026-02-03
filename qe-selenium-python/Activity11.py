from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC
import time

driver = webdriver.Firefox()
driver.maximize_window()

driver.get("https://training-support.net/webelements/dynamic-controls")

print("Page Title:", driver.title)

wait = WebDriverWait(driver, 10)

toggle = wait.until(EC.element_to_be_clickable((By.ID, "toggleCheckbox")))


toggle.click()
wait.until(EC.invisibility_of_element_located((By.ID, "checkbox")))
print("Checkbox removed")


toggle.click()


checkbox = wait.until(EC.element_to_be_clickable((By.ID, "checkbox")))
checkbox.click()
print("Checkbox selected")



driver.quit()