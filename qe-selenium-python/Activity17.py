from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.support.ui import Select
import time

# 1. Open the browser
driver = webdriver.Firefox()
# Set implicit wait for stability
driver.implicitly_wait(10)

try:
    # Open the URL
    driver.get("https://training-support.net/webelements/selects")
    
    # 2. Get the title and print it
    print(f"Page title: {driver.title}")

    # 3. Locate the Multi-Select dropdown
    # We find all <select> elements and pick the second one (index 1)
    selects = driver.find_elements(By.TAG_NAME, "select")
    multi_select_element = selects[1]
    multi_select = Select(multi_select_element)

    # • Select "HTML" using the visible text
    multi_select.select_by_visible_text("HTML")
    print("Selected: HTML")

    # • Select the 4th, 5th, and 6th options using the index
    # Indexes are 0-based: 4th=3, 5th=4, 6th=5
    for i in range(3, 6):
        multi_select.select_by_index(i)
    print("Selected options at indexes 3, 4, and 5")

    # • Select "Node" using visible text
    # We use visible text because 'value' can be inconsistent (e.g., 'node' vs 'nodejs')
    multi_select.select_by_visible_text("Node")
    print("Selected: Node")

    # • Deselect the 5th option using index (Index 4)
    multi_select.deselect_by_index(4)
    print("Deselected the 5th option (Index 4)")

    # 4. Print all currently selected options to verify
    print("\n--- Currently Selected Options ---")
    selected_options = multi_select.all_selected_options
    for option in selected_options:
        print(f"Selected: {option.text}")

finally:
    # 5. Close the browser
    time.sleep(2) # Brief pause to see the final selection
    driver.quit()