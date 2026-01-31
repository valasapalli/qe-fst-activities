import pytest
from bs4 import BeautifulSoup
import requests
@pytest.fixture
def input_value():
    return 12

@pytest.fixture
def home_page_content():
    res=requests.get("https://training-support.net").content
    soup=BeautifulSoup(res,"html.parser")
    return soup
@pytest.fixture
def other_input_value():
    return 120
@pytest.fixture
def list_numbers():
    list1=[i for i in range(11)]
    return list1
